package cdu.zch.controller;

import cdu.zch.service.OrderService;
import cdu.zch.service.impl.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/orderCancel")
public class OrderCancelServlet extends HttpServlet {

    OrderService orderService = new OrderServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String orderId = req.getParameter("orderId");
        orderService.del(orderId);

        req.getRequestDispatcher("list").forward(req, resp);

    }
}
