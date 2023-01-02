package cdu.zch.controller;

import cdu.zch.service.ProductService;
import cdu.zch.service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/product/del")
public class DelProductServlet extends HttpServlet {
    ProductService productService = new ProductServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String sid = req.getParameter("id");
        productService.deleteProduct(Integer.parseInt(sid));

        req.getRequestDispatcher("list").forward(req, resp);
    }
}
