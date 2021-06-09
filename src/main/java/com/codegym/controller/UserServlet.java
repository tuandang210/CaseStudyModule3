package com.codegym.controller;

import com.codegym.model.User;
import com.codegym.service.IUserService;
import com.codegym.service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "UserServlet", value = "/users")
public class UserServlet extends HttpServlet {
    private final IUserService userService = new UserService();
    public static String checkUser = "";
    public static String checkUserPassWord = "";
    public static float Price = 3000;
    public static int idUser = 0;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    String a = "registration.jsp";
                    createNewForm(request, response, a);
                    break;
                case "edit":
                    showEditUserForm(request, response);
                    break;
                case "list":
                    String b = "list.jsp";
                    createNewForm(request, response, b);
                    break;
                case "delete":

                    deleteNewFrom(request, response);

                    break;
                case "ForgotPasswords":
                    forgotPasswordsFrom(request, response);
                    break;
                default:
                    b = "list.jsp";
                    createNewForm(request, response, b);
                    break;
            }
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }

    }

    private void forgotPasswordsFrom(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("accountManagement/ForgotPassword.jsp");
        dispatcher.forward(request,response);
    }

    private void forgotPassword(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String userName = request.getParameter("userName");
        String phone = request.getParameter("phone");
        String check = userService.forgotPassword(userName, phone);
        if (check.equals("")) {
            check = "wrong account or phone number";
        }
        request.setAttribute("message", "PassWord : "+check);
        RequestDispatcher dispatcher = request.getRequestDispatcher("accountManagement/ForgotPassword.jsp");
        dispatcher.forward(request,response);
    }

    private void deleteNewFrom(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        int id = Integer.parseInt(request.getParameter("userId"));
        userService.delete(id);
        setAttribute(request);
//        response.sendRedirect("/users?userName=" + checkUser + "&passWord=" + checkUserPassWord);
        response.sendRedirect("/users");
    }

    private void setAttribute(HttpServletRequest request) {
        request.setAttribute("userName", checkUser);
        request.setAttribute("passWord", checkUserPassWord);
    }

    private void showEditUserForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("userId"));
        User user = userService.findById(id);
        getUserNamePW(request, response, user);

    }

    private void getUserNamePW(HttpServletRequest request, HttpServletResponse response, User user) throws ServletException, IOException {
        setAttribute(request);
        request.setAttribute("user", user);
        RequestDispatcher dispatcher;
        if (checkUser.equals("admin")) {
            dispatcher = request.getRequestDispatcher("/accountManagement/editAdmin.jsp");
        } else {
            dispatcher = request.getRequestDispatcher("/accountManagement/editUser.jsp");
        }
        dispatcher.forward(request, response);
    }

    private void createNewForm(HttpServletRequest request, HttpServletResponse response, String a) throws ServletException, IOException {
        List<User> users = userService.findAll();
        request.setAttribute("user", users);
        setAttribute(request);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/accountManagement/" + a);
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":

                    createNewCustomer(request, response);

                    break;
                case "edit":

                    editUser(request, response);

                    break;
                case "ForgotPassword":
                    forgotPassword(request, response);
                    break;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private void editUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("userId"));
        User user = getUser(request);
        boolean isUpdate = userService.update(id, user);
        if (!isUpdate) {
            request.setAttribute("message", "Error!");
        } else {
            checkUser = user.getUserName();
            checkUserPassWord= user.getPassWord();
            request.setAttribute("message", "Success!");
        }
        getUserNamePW(request, response, user);
    }

    private void createNewCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        User user = getUser(request);
        boolean isUpdate = userService.create(user);
        if (!isUpdate && user.getPassWord().equals("") && user.getUserName().equals("")) {
            request.setAttribute("message", "Error!");
        } else {
            request.setAttribute("message", "Success!");
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("/accountManagement/registration.jsp");
        dispatcher.forward(request, response);
    }

    private User getUser(HttpServletRequest request) {
        String userName = request.getParameter("userName");
        String passWord = request.getParameter("passWord");
        String gender = request.getParameter("gender");
        String phone = request.getParameter("phone");
        int level = Integer.parseInt(request.getParameter("level"));
        return new User(userName, passWord, gender, phone, level);
    }
}