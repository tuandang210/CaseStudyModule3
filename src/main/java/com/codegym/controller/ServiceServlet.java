package com.codegym.controller;

import com.codegym.model.ServiceDB;
import com.codegym.model.TypeService;
import com.codegym.service.IServiceOfService;
import com.codegym.service.ITypeOfService;
import com.codegym.service.ServiceOfService;
import com.codegym.service.TypeOfService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ServiceServlet", value = "/Services")
public class ServiceServlet extends HttpServlet {
    private final IServiceOfService servicesOfService = new ServiceOfService();
    private final ITypeOfService typeOfService = new TypeOfService();
    String action ="";
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
                    editForm(request, response);
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
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        action = request.getParameter("action");
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

    private void deleteForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("service_id"));
        boolean isDelete = false;
        try {
            isDelete = servicesOfService.delete(id);
            if (!isDelete) {
                request.setAttribute("message", "Error!");
            } else {
                request.setAttribute("message", "Success!");
            }
            response.sendRedirect("/Services");
        } catch (SQLException | IOException throwables) {
            throwables.printStackTrace();
        }
    }

    private void editForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int service_id = Integer.parseInt(request.getParameter("service_id"));
        ServiceDB service = servicesOfService.findById(service_id);
        List<TypeService> typeServices = typeOfService.findAll();
        RequestDispatcher dispatcher = request.getRequestDispatcher("service/editService.jsp");
        if (service == null) {
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        }
        request.setAttribute("service", service);
        request.setAttribute("typeServices",typeServices);
        dispatcher.forward(request, response);
    }

    private void createNewForm(HttpServletRequest request, HttpServletResponse response) {
        List<TypeService> typeServices = typeOfService.findAll();
        RequestDispatcher dispatcher = request.getRequestDispatcher("service/createNewService.jsp");
        try {
            request.setAttribute("typeServices",typeServices);
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showListForm(HttpServletRequest request, HttpServletResponse response) {
        List<ServiceDB> services = servicesOfService.findAll();
        request.setAttribute("services", services);
        request.setAttribute("userName", UserServlet.checkUser);
        request.setAttribute("passWord", UserServlet.checkUserPassWord);
        RequestDispatcher dispatcher = request.getRequestDispatcher("service/listService.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }



    private void edit(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("service_id"));
        String name = request.getParameter("service_name");
        int type = Integer.parseInt(request.getParameter("type_id"));
        ServiceDB serviceDB = new ServiceDB(id, name,type);
        List<TypeService> typeServices = typeOfService.findAll();

        try {
            boolean isEdit = servicesOfService.update(serviceDB.getId(), serviceDB);
            if (!isEdit) {
                request.setAttribute("message", "Error!");
            } else {
                request.setAttribute("message", "Success!");
            }
            RequestDispatcher dispatcher = request.getRequestDispatcher("/service/editService.jsp");
            request.setAttribute("service", serviceDB);
            request.setAttribute("typeServices",typeServices);
            dispatcher.forward(request, response);
        } catch (SQLException | ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void createNew(HttpServletRequest request, HttpServletResponse response) {
        List<TypeService> typeServices = typeOfService.findAll();

        String name = request.getParameter("service_name");
        int type = Integer.parseInt(request.getParameter("type_id"));
        ServiceDB serviceDB = new ServiceDB(name,type);
        try {
            boolean isCreate = servicesOfService.create(serviceDB);
            if (!isCreate) {
                request.setAttribute("message", "Error!");
            } else {
                request.setAttribute("message", "Success!");
            }

            RequestDispatcher dispatcher = request.getRequestDispatcher("/service/createNewService.jsp");
            request.setAttribute("typeServices",typeServices);

            dispatcher.forward(request, response);
        } catch (SQLException | ServletException | IOException throwables) {
            throwables.printStackTrace();
        }

    }
}