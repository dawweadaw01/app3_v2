package cdu.zch.controller;

import cdu.zch.model.Order;
import cdu.zch.model.Product;
import cdu.zch.service.OrderService;
import cdu.zch.service.ProductService;
import cdu.zch.service.impl.OrderServiceImpl;

import cdu.zch.service.impl.ProductServiceImpl;
import cdu.zch.util.StringToMap;
import cdu.zch.util.StringToMap.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/pay")
public class PayServlet extends HttpServlet {

    OrderService orderService = new OrderServiceImpl();
    ProductService productService = new ProductServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String orderId = req.getParameter("orderId");
        Order order = orderService.get(orderId);
        order.setStatusCode(1);
        order.setUpdateTime(new Date().getTime());
        orderService.updateStatus(order);

//        System.out.println(order.getProducts() + " + " + order.getProducts().getClass());
        // 拿到购买的商品及其数量的信息，病转换为map
        Map<Integer, Integer> products = new HashMap<>();
        products = StringToMap.mapStringToMap(order.getProducts());
//        System.out.println(products);
        Product product = new Product();
        // 遍历products 然后修改对应商品的库存
        for (int productId: products.keySet()){
            // 得到商品id对应的商品购买数量
            int num = products.get(productId);
            // 得到原来的商品
            product = productService.findById(productId);
            // 通过商品id修改商品库存
            product.setStock(product.getStock() - num);
            // 更新数据库中的数据
            productService.updateProduct(product);
        }
        session.setAttribute("order", order);
        req.getRequestDispatcher("pay.do?orderId=" + orderId).forward(req, resp);
    }
}
