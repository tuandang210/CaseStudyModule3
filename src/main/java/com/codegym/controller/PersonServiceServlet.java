package com.codegym.controller;

import com.codegym.model.PersonService;
import com.codegym.model.TypeService;
import com.codegym.service.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "PersonServiceServlet", value = "/PersonServices")
public class PersonServiceServlet extends HttpServlet {
    private final IServiceOfPersonService personServicesDAO = new ServiceOfPersonService();
    private IRentalPersonService rentalPersonService = new RentalPersonService();
    private final IServiceOfService servicesOfService = new ServiceOfService();

    String action;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createNewForm(request, response);

                break;
            case "edit":
                try {
                    editTypeServiceForm(request, response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            case "delete":
                deleteForm(request, response);
                break;
            default:
                showListForm(request, response);
                break;
        }
    }

    private void deleteForm(HttpServletRequest request, HttpServletResponse response) {
        int person_id = Integer.parseInt(request.getParameter("person_id"));
        int service_id = Integer.parseInt(request.getParameter("service_id"));
        boolean isDelete = false;
        try {
            isDelete = personServicesDAO.delete(service_id,person_id);
            if (!isDelete) {
                request.setAttribute("message", "Error!");
            } else {
                request.setAttribute("message", "Success!");
            }
            response.sendRedirect("/PersonServices");
        } catch (SQLException | IOException throwables) {
            throwables.printStackTrace();
        }
    }

    private void editTypeServiceForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int type_id = Integer.parseInt(request.getParameter("person_id"));
        PersonService personService = personServicesDAO.findById(type_id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("typeService/editTypeService.jsp");
        if (personService == null) {
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        }
        request.setAttribute("personService", personService);
        dispatcher.forward(request, response);
    }

    private void createNewForm(HttpServletRequest request, HttpServletResponse response) {
        List<Integer> serviceIDs = servicesOfService.selectAllID();
        List<Integer> personIDs = rentalPersonService.selectAllID();
        request.setAttribute("serviceIDs",serviceIDs);
        request.setAttribute("personIDs",personIDs);
        RequestDispatcher dispatcher = request.getRequestDispatcher("personService/create.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showListForm(HttpServletRequest request, HttpServletResponse response) {
        List<PersonService> personServices = personServicesDAO.findAll();
        request.setAttribute("personServices", personServices);
        request.setAttribute("userName", UserServlet.checkUser);
        request.setAttribute("passWord", UserServlet.checkUserPassWord);
        RequestDispatcher dispatcher = request.getRequestDispatcher("personService/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createNew(request, response);
                break;
            case "edit":
                edit(request, response);
                break;
            default:
                showListForm(request, response);
                break;
        }
    }

    private void edit(HttpServletRequest request, HttpServletResponse response) {
        int person_id  = Integer.parseInt(request.getParameter("person_id"));
        int service_id  = Integer.parseInt(request.getParameter("service_id"));

        PersonService personService = new PersonService(service_id, person_id);
        try {
            boolean isEdit = personServicesDAO.update(personService.getPerson_id(), personService);
            if (!isEdit) {
                request.setAttribute("message", "Error!");
            } else {
                request.setAttribute("message", "Success!");
            }
            RequestDispatcher dispatcher = request.getRequestDispatcher("/typeService/editTypeService.jsp");
            dispatcher.forward(request, response);
        } catch (SQLException | ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void createNew(HttpServletRequest request, HttpServletResponse response) {
        int service_id = Integer.parseInt(request.getParameter("service_id"));
        int person_id = Integer.parseInt(request.getParameter("person_id"));
        PersonService personService = new PersonService(service_id,person_id);
        List<Integer> serviceIDs = servicesOfService.selectAllID();
        List<Integer> personIDs = rentalPersonService.selectAllID();
        request.setAttribute("serviceIDs",serviceIDs);
        request.setAttribute("personIDs",personIDs);
        List<PersonService> personServiceList=personServicesDAO.findAll();
        for (PersonService element :
                personServiceList) {
            if (element.getService_id()==service_id&&element.getPerson_id()==person_id) {
                request.setAttribute("message", "Error database already exists !");
            }
            RequestDispatcher dispatcher = request.getRequestDispatcher("personService/create.jsp");
            try {
                dispatcher.forward(request, response);
            } catch (ServletException | IOException e) {
                e.printStackTrace();
            }
        }
        try {
            boolean isCreate = personServicesDAO.create(personService);
            if (!isCreate) {
                request.setAttribute("message", "Error!");
            } else {
                request.setAttribute("message", "Success!");
            }
            RequestDispatcher dispatcher = request.getRequestDispatcher("personService/create.jsp");
            dispatcher.forward(request, response);
        } catch (SQLException | ServletException | IOException throwables) {
            throwables.printStackTrace();
        }

    }
}