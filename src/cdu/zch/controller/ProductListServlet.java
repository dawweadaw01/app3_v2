package cdu.zch.controller;

import cdu.zch.model.Product;
import cdu.zch.service.ProductService;
import cdu.zch.service.impl.ProductServiceImpl;
import cdu.zch.util.PageInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ListProductServlet", urlPatterns = {"/list", "/product/list"})
public class ProductListServlet extends HttpServlet {

    ProductService productService = new ProductServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 得到总数据条数
        int count = productService.count();
        PageInfo<Product> pageInfo = new PageInfo<>();
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

        // 得到分页查询的数据
        List<Product> productList = productService.pageProduct(currentPage, pageSize);

        //渲染到页面上
        req.setAttribute("productList", productList);

        // 计算出总页面数，设置到页面上
        pageInfo.setCount(count);
        pageInfo.setPageSize(pageSize);
        pageInfo.setCurrentPage(currentPage);
        req.setAttribute("pageInfos",pageInfo);
        System.out.println("￥￥￥" + pageInfo);

        req.getRequestDispatcher("list.do").forward(req, resp);
    }
}
