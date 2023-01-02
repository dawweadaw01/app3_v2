package cdu.zch.controller;

import cdu.zch.model.Customer;
import cdu.zch.service.CustomerService;
import cdu.zch.service.impl.CustomerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RegisterServlet", value = "/register")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        CustomerService customerService = new CustomerServiceImpl();

        req.setCharacterEncoding("utf-8");

        Customer customer = new Customer();
        customer.setName(req.getParameter("name"));
        customer.setPassword(req.getParameter("password"));

        if(customerService.addCustomer(customer)){
            resp.sendRedirect("login.do");
        }else{
            resp.sendRedirect("list");
        }
    }
}
