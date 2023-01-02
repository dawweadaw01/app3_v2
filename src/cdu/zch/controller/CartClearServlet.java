package cdu.zch.controller;

import cdu.zch.model.Customer;
import cdu.zch.service.CartService;
import cdu.zch.service.impl.CartServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/cartClear")
public class CartClearServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        CartService cartService = new CartServiceImpl();

        HttpSession session = req.getSession();
        Customer customer = (Customer) session.getAttribute("customer");

        cartService.clear(customer.getId());
        resp.sendRedirect("cart");
    }
}
