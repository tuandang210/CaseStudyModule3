package com.codegym.controller;

import com.codegym.model.RentalPerson;
import com.codegym.model.User;
import com.codegym.service.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    private final IRentalPersonService rentalPersonService = new RentalPersonService();
    private final LoginService loginService1 = new LoginService();
    private final IUserService userService = new UserService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }

        try {
            switch (action) {
                case "login":
                    login(req, resp);
                    break;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void login(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException {
        String userName = req.getParameter("userName");
        String passWord = req.getParameter("passWord");
        int checkUser = loginService1.loginService(userName, passWord);
        User user = userService.findById(checkUser);
        req.setAttribute("user",user);
        RequestDispatcher dispatcher;
        UserServlet.checkUser = userName;
        UserServlet.checkUserPassWord = passWord;
        if (checkUser != -1) {
            UserServlet.idUser = user.getUserId();
            if (userName.equals("admin")) {
                dispatcher = req.getRequestDispatcher("/accountManagement/homePageAdmin.jsp");
            }else {
                showListRentalUser(req,resp);
                dispatcher = req.getRequestDispatcher("/accountManagement/homePageUser.jsp");
            }
        } else {
            dispatcher = req.getRequestDispatcher("/error-404.jsp");
        }
        dispatcher.forward(req, resp);
    }
    private void showListRentalUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<RentalPerson> rentals = this.rentalPersonService.selectAll();
        request.setAttribute("rentals", rentals);
    }
}
