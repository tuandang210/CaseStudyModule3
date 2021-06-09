package com.codegym.controller;

import com.codegym.model.RentalPerson;
import com.codegym.service.IRentalPersonService;
import com.codegym.service.RentalPersonService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.codegym.model.RentalPerson.MAX_AGE;
import static com.codegym.model.RentalPerson.MIN_AGE;

@WebServlet(name = "RentalPersonServlet", value = "/employee")
public class RentalPersonServlet extends HttpServlet {
    private IRentalPersonService rentalPersonService = new RentalPersonService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        switch (action) {
            case "viewEmployee":
                viewRental(request, response);
                break;
            case "createEmployee":
                showCreateRentalForm(request, response);
                break;
            case "editEmployee":
                showEditRentalForm(request, response);
                break;
            case "deleteEmployee":
                showDeleteRentalForm(request, response);
                break;

            default:
                showListRental(request, response);
                break;

        }
    }


    private void showListRental(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<RentalPerson> rentals;
        String search = request.getParameter("search");

        if (search == null || search.equals("")) {
            rentals = this.rentalPersonService.selectAll();
        } else {
            rentals = this.rentalPersonService.findRentalByName(search);
        }

        String sort = request.getParameter("sort");
        String type = request.getParameter("type");

        if (sort != null) {
            rentals = this.rentalPersonService.sort(sort, type);
        }
        request.setAttribute("rentals", rentals);
        request.setAttribute("userName", UserServlet.checkUser);
        request.setAttribute("passWord", UserServlet.checkUserPassWord);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/rentalPerson/list.jsp");
        dispatcher.forward(request, response);
    }

    private void showListRentals(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<RentalPerson> rentals = this.rentalPersonService.selectAll();
        request.setAttribute("rentals", rentals);
        request.setAttribute("userName", UserServlet.checkUser);
        request.setAttribute("passWord", UserServlet.checkUserPassWord);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/rentalPerson/list.jsp");
        dispatcher.forward(request, response);
    }


    private void viewRental(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("employeeId"));
        RentalPerson rental = this.rentalPersonService.select(id);

        RequestDispatcher dispatcher;
        request.setAttribute("userName", UserServlet.checkUser);
        request.setAttribute("passWord", UserServlet.checkUserPassWord);
        if (rental == null) {
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            if (UserServlet.checkUser.equals("admin")) {
                request.setAttribute("rental", rental);
                dispatcher = request.getRequestDispatcher("/rentalPerson/view.jsp");
            } else {
                request.setAttribute("rental", rental);
                dispatcher = request.getRequestDispatcher("/orderUser/view.jsp");
            }
        }
        dispatcher.forward(request, response);
    }

    private void showCreateRentalForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/rentalPerson/create.jsp");
        dispatcher.forward(request, response);
    }


    private void showEditRentalForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("employeeId"));
        RentalPerson rental = this.rentalPersonService.select(id);

        List<Integer> validAges = new ArrayList<>();
        for (int i = MIN_AGE; i <= MAX_AGE; i++) {
            validAges.add(i);
        }

        RequestDispatcher dispatcher;
        if (rental == null) {
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            request.setAttribute("validAges", validAges);
            request.setAttribute("rental", rental);
            dispatcher = request.getRequestDispatcher("/rentalPerson/edit.jsp");
        }
        dispatcher.forward(request, response);
    }


    private void showDeleteRentalForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("employeeId"));
        RentalPerson rental = this.rentalPersonService.select(id);

        RequestDispatcher dispatcher;
        if (rental == null) {
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            request.setAttribute("rental", rental);
            dispatcher = request.getRequestDispatcher("/rentalPerson/delete.jsp");
        }

        dispatcher.forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        switch (action) {
            case "createEmployee":
                createNewRental(request, response);
                break;
            case "editEmployee":
                editRental(request, response);
                break;
            case "deleteEmployee":
                deleteRental(request, response);
                break;
            default:
                showListRental(request, response);
                break;
        }
    }


    private void createNewRental(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        String gender = request.getParameter("gender");
        boolean status = Boolean.parseBoolean(request.getParameter("status"));
        String phone = request.getParameter("phone");
        String urlImage = request.getParameter("urlImage");

        boolean isInserted;

        if (validateName(name) == false) {
            request.setAttribute("warningName", "Name must start with 1 letter and not exceed 50 characters");
        }

        if (validatePhone(phone) == false) {
            request.setAttribute("warningPhone", "Phone number contains 10 digits");
        }

        if (validateUrlImage(urlImage) == false) {
            request.setAttribute("warningImage", "URL Image should not exceed 255 characters");
        }
        boolean isValidate = validateName(name) & validatePhone(phone) & validateUrlImage(urlImage);

        if (isValidate) {
            isInserted = this.rentalPersonService.create(new RentalPerson(name, age, gender, status, phone, urlImage));
        } else {
            isInserted = false;
        }

        if (isInserted == false) {
            request.setAttribute("message", "Error occurs when adding new employee!");
        } else {
            request.setAttribute("message", "Added new employee!");
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("/rentalPerson/create.jsp");
        dispatcher.forward(request, response);

    }


    private void editRental(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("employeeId"));

        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        String gender = request.getParameter("gender");
        boolean status = Boolean.parseBoolean(request.getParameter("status"));
        String phone = request.getParameter("phone");
        String urlImage = request.getParameter("urlImage");
        RentalPerson rental = this.rentalPersonService.select(id);
        RequestDispatcher dispatcher;

        List<Integer> validAges = new ArrayList<>();
        for (int i = MIN_AGE; i <= MAX_AGE; i++) {
            validAges.add(i);
        }

        if (rental == null) {
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            rental.setName(name);
            rental.setAge(age);
            rental.setGender(gender);
            rental.setStatus(status);
            rental.setPhone(phone);
            rental.setUrlImage(urlImage);
            boolean isUpdated;
            request.setAttribute("validAges", validAges);
            request.setAttribute("rental", rental);

            if (validateName(name) == false) {
                request.setAttribute("warningName", "Name must start with 1 letter and not exceed 50 characters");
            }

            if (validatePhone(phone) == false) {
                request.setAttribute("warningPhone", "Phone number contains 10 digits");
            }

            if (validateUrlImage(urlImage) == false) {
                request.setAttribute("warningImage", "URL Image should not exceed 255 characters");
            }

            boolean isValidate = validateName(name) & validatePhone(phone) & validateUrlImage(urlImage);
            if (isValidate) {
                isUpdated = this.rentalPersonService.update(id, rental);
            } else {
                isUpdated = false;
            }

            if (isUpdated == false) {
                request.setAttribute("message", "Errors occurs when editing this employee!");
            } else {
                request.setAttribute("message", "Updated successfully!");
            }
            dispatcher = request.getRequestDispatcher("/rentalPerson/edit.jsp");
        }
        dispatcher.forward(request, response);

    }


    private void deleteRental(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("employeeId"));
        RentalPerson rental = this.rentalPersonService.select(id);

        RequestDispatcher dispatcher;
        if (rental == null) {
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            this.rentalPersonService.delete(id);
            response.sendRedirect("/employee");
        }
    }


    private boolean validatePhone(String phone) {
        Pattern pattern = Pattern.compile("^[0-9]{10}$");
        Matcher matcher = pattern.matcher(phone);
        return matcher.matches();
    }


    private boolean validateUrlImage(String urlImage) {
        return (urlImage.length() <= 255);
    }

    private boolean validateName(String name) {
        Pattern pattern = Pattern.compile("^([a-zA-z]+[a-zA-Z0-9 .,]*){1,50}$");
        Matcher matcher = pattern.matcher(name);
        return matcher.matches();
    }

}
