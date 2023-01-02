package cdu.zch.controller;

import cdu.zch.model.Customer;
import cdu.zch.model.Order;
import cdu.zch.model.Product;
import cdu.zch.service.CartService;
import cdu.zch.service.OrderService;
import cdu.zch.service.impl.CartServiceImpl;
import cdu.zch.service.impl.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

@WebServlet("/order")
public class OrderServlet extends HttpServlet {

    OrderService orderService = new OrderServiceImpl();
    CartService cartService = new CartServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Customer customer = (Customer) session.getAttribute("customer");

        // 得到订单信息
        Map<Integer, Integer> products = (Map<Integer, Integer>) session.getAttribute("products");
        Map<Integer, Product> productMap = (Map<Integer, Product>) session.getAttribute("productMap");
        Map<Integer, Integer> productNumMap = (Map<Integer, Integer>) session.getAttribute("productNumMap");
        BigDecimal cartMoney = (BigDecimal) session.getAttribute("cartMoney");
        req.setCharacterEncoding("utf-8");
        String name = req.getParameter("name");
        String address = req.getParameter("address");
        String tel = req.getParameter("tel");
//        System.out.println("products:@@@" + products);

        // 将订单信息添加进订单里面
        Order order = new Order();
        long now = new Date().getTime();
        order.setOrderId("" + customer.getId() + now);
        order.setCustomerId(customer.getId());
        order.setMoney(cartMoney);
        order.setProducts(products.toString());
        order.setName(name);
        order.setAddress(address);
        order.setTel(tel);
        order.setCreateTime(now);
        order.setUpdateTime(now);
        order.setStatusCode(0);
//        System.out.println("order:@@@" + order);
//        System.out.println("productMap@@@" + productMap);
//        System.out.println("productNumMap@@@" + productNumMap);

        // 创建订单
        if (orderService.createOrder(order)) {
            //订单创建成功

            session.removeAttribute("products");
            session.removeAttribute("productMap");
            session.removeAttribute("productNumMap");
            session.removeAttribute("cartMoney");
            session.setAttribute("order", order);
//            req.getRequestDispatcher("pay.do").forward(req, resp);
            resp.sendRedirect("pay.do");
        } else {
            //生成订单失败，返回购物车
            resp.setContentType("text/html;charset=utf-8");
            PrintWriter out = resp.getWriter();
            out.println("<script>alert('生成订单失败');window.location.href='cart'</script>");
        }
    }

}
