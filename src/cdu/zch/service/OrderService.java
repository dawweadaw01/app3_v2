package cdu.zch.service;

import cdu.zch.model.Order;

import java.util.List;

public interface OrderService {

    Order get(String orderId);
    List<Order> findByPage(String sPage);
    List<Order> findByCustomer(String sCustomerId);
    boolean createOrder(Order order);
    boolean updateStatus(Order order);
    boolean del(String orderId);

    int count();
    List<Order> findByPage(int page, int pageSize);
}
