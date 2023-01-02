package cdu.zch.controller;

import cdu.zch.model.Customer;
import cdu.zch.model.Product;
import cdu.zch.service.CustomerService;
import cdu.zch.service.impl.CustomerServiceImpl;
import cdu.zch.util.PageInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/customer/list")
public class CustomerListServlet extends HttpServlet {

    CustomerService customerService = new CustomerServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 得到总数据条数
        int count = customerService.count();
        PageInfo<Customer> pageInfo = new PageInfo<>();
        // 得到当前页数
        String cPage = req.getParameter("currentPage");
        if(cPage == null || "".equals(cPage)){
            cPage = "1";
        }
        int currentPage = Integer.parseInt(cPage);

        // 得到每页最大数据数
        String sPageSize = req.getParameter("pageSize");
        if(sPageSize == null || "".equals(sPageSize)){
            sPageSize = "3";
        }
        int pageSize = Integer.parseInt(sPageSize);

        List<Customer> customerList = customerService.pageCustomer(currentPage, pageSize);

        req.setAttribute("customerList", customerList);
//        System.out.println(customerList);

        // 计算出总页面数，设置到页面上
        pageInfo.setCount(count);
        pageInfo.setPageSize(pageSize);
        pageInfo.setCurrentPage(currentPage);
        req.setAttribute("pageInfo",pageInfo);

        req.getRequestDispatcher("list.do").forward(req, resp);


    }
}
