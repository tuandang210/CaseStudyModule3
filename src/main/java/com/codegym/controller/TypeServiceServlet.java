package com.codegym.controller;

import com.codegym.model.TypeService;
import com.codegym.service.ITypeOfService;
import com.codegym.service.TypeOfService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "TypeServiceServlet", value = "/typeServices")
public class TypeServiceServlet extends HttpServlet {
    private final ITypeOfService typeOfService = new TypeOfService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
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
        int id = Integer.parseInt(request.getParameter("type_id"));
        boolean isDelete = false;
        try {
            isDelete = typeOfService.delete(id);
            if (!isDelete) {
                request.setAttribute("message", "Error!");
            } else {
                request.setAttribute("message", "Success!");
            }
            response.sendRedirect("/typeServices");
        } catch (SQLException | IOException throwables) {
            throwables.printStackTrace();
        }
    }

    private void editTypeServiceForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int type_id = Integer.parseInt(request.getParameter("type_id"));
        TypeService typeService = typeOfService.findById(type_id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("typeService/editTypeService.jsp");
        if (typeService == null) {
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        }
        request.setAttribute("typeService", typeService);
        dispatcher.forward(request, response);
    }

    private void createNewForm(HttpServletRequest request, HttpServletResponse response) {

        RequestDispatcher dispatcher = request.getRequestDispatcher("typeService/createNewTypeService.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showListForm(HttpServletRequest request, HttpServletResponse response) {
        List<TypeService> typeServices = typeOfService.findAll();
        request.setAttribute("types", typeServices);
        request.setAttribute("userName", UserServlet.checkUser);
        request.setAttribute("passWord", UserServlet.checkUserPassWord);
        RequestDispatcher dispatcher = request.getRequestDispatcher("typeService/listTypeService.jsp");
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
        int type_id = Integer.parseInt(request.getParameter("type_id"));
        String type_name = request.getParameter("type_name");
        TypeService typeService = new TypeService(type_id, type_name);
        try {
            boolean isEdit = typeOfService.update(typeService.getId(), typeService);
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
        String type_name = request.getParameter("type_name");
        TypeService typeService = new TypeService(type_name);

        try {
            boolean isCreate = typeOfService.create(typeService);
            if (!isCreate) {
                request.setAttribute("message", "Error!");
            } else {
                request.setAttribute("message", "Success!");
            }
            RequestDispatcher dispatcher = request.getRequestDispatcher("/typeService/createNewTypeService.jsp");
            dispatcher.forward(request, response);
        } catch (SQLException | ServletException | IOException throwables) {
            throwables.printStackTrace();
        }

    }
}