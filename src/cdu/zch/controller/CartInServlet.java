package cdu.zch.controller;

import cdu.zch.model.Customer;
import cdu.zch.model.Product;
import cdu.zch.service.CartService;
import cdu.zch.service.ProductService;
import cdu.zch.service.impl.CartServiceImpl;
import cdu.zch.service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

@WebServlet("/cartIn")
public class CartInServlet extends HttpServlet {

    ProductService productService = new ProductServiceImpl();
    CartService cartService = new CartServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //需要顾客已登录
        HttpSession session = req.getSession();
        Customer customer = (Customer) session.getAttribute("customer");
        if (customer == null) {
            resp.sendRedirect("login.do");
            return;
        }
//        System.out.println("customer@@@" + customer);
        String sProductId = req.getParameter("productId");
//        System.out.println("sProductId%%%" + sProductId);
        if (sProductId == null || sProductId.equals("")) {
            resp.sendRedirect("list");
            return;
        }
        int productId = Integer.parseInt(sProductId);
//        System.out.println("productId###:" + productId);
        //获取顾客的购物车
        Map<Integer, Integer> map = cartService.getProducts(customer.getId());
        if (map.containsKey(productId)) {
            //购物车中已有商品
            int buyNum = map.get(productId) + 1;
            Product product = productService.findById(productId);
            if (buyNum > product.getStock()) {
                //购买数量超出库存数量
                resp.setContentType("text/html;charset=utf-8");
                PrintWriter out = resp.getWriter();
                out.println("<script>alert('库存不足');window.location.href='list'</script>");
                out.close();
            } else {
                cartService.update(customer.getId(), productId, buyNum);
            }
        } else {
            map.put(productId, 1);
            cartService.add(customer.getId(), productId);
        }
//        System.out.println("map$$$$" + map);
        resp.sendRedirect("list");
    }
}
