package cdu.zch.service.impl;

import cdu.zch.dao.OrderDao;
import cdu.zch.dao.impl.OrderDaoImpl;
import cdu.zch.model.Order;
import cdu.zch.service.CartService;
import cdu.zch.service.OrderService;
import cdu.zch.service.ProductService;

import java.util.List;

public class OrderServiceImpl implements OrderService {

    OrderDao orderDao = new OrderDaoImpl();
    CartService cartService = new CartServiceImpl();
    ProductService productService = new ProductServiceImpl();

    @Override
    public Order get(String orderId) {
        return orderDao.get(orderId);
    }

    @Override
    public List<Order> findByPage(String sPage) {
        return findByPage(Integer.parseInt(sPage), 10);
    }

    @Override
    public List<Order> findByCustomer(String sCustomerId) {
        return null;
    }

    @Override
    public boolean createOrder(Order order) {
        if (orderDao.insert(order) == 1) {
            cartService.clear(order.getCustomerId());
//            productService.mod(order.getProducts());
            return true;
        }
        return false;
    }

    @Override
    public boolean updateStatus(Order order) {
        return orderDao.update(order) == 1;
    }

    @Override
    public boolean del(String orderId) {
        return orderDao.delete(orderId) == 1;
    }

    @Override
    public int count() {
        return orderDao.count();
    }

    @Override
    public List<Order> findByPage(int page, int pageSize) {
        return orderDao.findByPage((page - 1) * pageSize, pageSize);
    }
}
