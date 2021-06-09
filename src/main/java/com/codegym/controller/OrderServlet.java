package com.codegym.controller;

import com.codegym.DAO.order.OrderDAO;
import com.codegym.DAO.rentalPerson.RentalPersonDAO;
import com.codegym.DAO.user.UserDAO;
import com.codegym.model.OrderDetail;
import com.codegym.model.RentalPerson;
import com.codegym.model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "OrderServlet", value = "/orders")
public class OrderServlet extends HttpServlet {

    public OrderDAO orderDAO = new OrderDAO();
    public UserDAO userDAO = new UserDAO();
    public RentalPersonDAO rentalPersonDAO = new RentalPersonDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    showCreateForm(request, response);
                    break;
                case "edit":
                    showEditForm(request, response);
                    break;
                case "delete":
                    deleteOrder(request, response);
                    break;
                case "view":
                    viewDetail(request, response);
                    break;
                default:
                    showList(request, response);
                    break;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void viewDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        OrderDetail orderDetail = orderDAO.select(id);
        RequestDispatcher dispatcher;
        if (orderDetail == null) {
            dispatcher = request.getRequestDispatcher("error-404.jsp");
            dispatcher.forward(request, response);
        } else {
            request.setAttribute("orderDetail", orderDetail);
            dispatcher = request.getRequestDispatcher("orders/view.jsp");
            dispatcher.forward(request, response);
        }
    }

    private void deleteOrder(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        boolean isDelete = orderDAO.delete(id);
        if (!isDelete) {
            request.setAttribute("message", "Error!");
        } else {
            request.setAttribute("message", "Success!");
            response.sendRedirect("/orders");
        }

    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        OrderDetail orderDetail = orderDAO.select(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("orders/updateOrderDetail.jsp");
        if (orderDetail == null) {
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        }
        request.setAttribute("orderDetail", orderDetail);
        dispatcher.forward(request, response);
    }

    private void showList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<OrderDetail> orderDetails = orderDAO.selectAll();
        request.setAttribute("orderDetails", orderDetails);
        request.setAttribute("userName", UserServlet.checkUser);
        request.setAttribute("passWord", UserServlet.checkUserPassWord);
        RequestDispatcher dispatcher = request.getRequestDispatcher("orders/listOrder.jsp");
        dispatcher.forward(request, response);
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        User users = userDAO.select(UserServlet.idUser);
        request.setAttribute("users", users);
        request.setAttribute("userName", UserServlet.checkUser);
        request.setAttribute("passWord", UserServlet.checkUserPassWord);
        request.setAttribute("startHour", java.time.LocalDateTime.now()+"");
        List<RentalPerson> rentalPeople = rentalPersonDAO.selectAll();
        request.setAttribute("rentalPeople", rentalPeople);
        double Price = UserServlet.Price-UserServlet.Price*0.05*(users.getLevel()-1);
        request.setAttribute("price", Price);

        request.setAttribute("startHour", java.time.LocalDateTime.now()+"");

        RequestDispatcher dispatcher = request.getRequestDispatcher("orders/createOrderDetail.jsp");
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
                    createOrder(request, response);
                    break;
                case "edit":
                    updateOrder(request, response);
                    break;
                default:
                    showList(request, response);
                    break;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void updateOrder(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int orderId = Integer.parseInt(request.getParameter("id"));
        int userId = Integer.parseInt(request.getParameter("userId"));
        int personId = Integer.parseInt(request.getParameter("personId"));
        float price = Float.parseFloat(request.getParameter("price"));
        float hours = Float.parseFloat(request.getParameter("hours"));
        String startHour = request.getParameter("startHour");
        OrderDetail orderDetail = new OrderDetail(userId, personId, price, hours, startHour);

        boolean isUpdate = orderDAO.update(orderId, orderDetail);
        if (!isUpdate) {
            request.setAttribute("message", "Error!");
        } else {
            request.setAttribute("message", "Success!");
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("orders/updateOrderDetail.jsp");
        dispatcher.forward(request, response);
    }

    private void createOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        int userId = Integer.parseInt(request.getParameter("userId"));
        int personId = Integer.parseInt(request.getParameter("personId"));
        float price = Float.parseFloat(request.getParameter("price"));
        float hours = Float.parseFloat(request.getParameter("hours"));
        String startHour = request.getParameter("startHour");
        request.setAttribute("userName", UserServlet.checkUser);
        request.setAttribute("passWord", UserServlet.checkUserPassWord);
        OrderDetail orderDetail = new OrderDetail(userId, personId, price, hours, startHour);
        boolean isCreate = orderDAO.create(orderDetail);
        if (!isCreate) {
            request.setAttribute("message", "Error!");
        } else {
            request.setAttribute("message", "Success!");
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("orders/createOrderDetail.jsp");
        dispatcher.forward(request, response);
    }
}