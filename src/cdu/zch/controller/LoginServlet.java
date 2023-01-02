package cdu.zch.controller;

import cdu.zch.model.Customer;
import cdu.zch.service.CustomerService;
import cdu.zch.service.impl.CustomerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name="LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CustomerService customerService = new CustomerServiceImpl();

        // 得到登录页面获得的用户名及密码
        // 这里要设置一下乱码问题
        req.setCharacterEncoding("utf-8");
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        // 获取页面session
        HttpSession session = req.getSession();

        Customer customer = customerService.findByNameAndPwd(name, password);
        // 将登录的用户存入session
        session.setAttribute("customer", customer);
//        System.out.println("@@@@@" + customer);

        if(null != customer){
            req.setAttribute("customer", customer);
        }

        resp.sendRedirect("list");
    }
}
