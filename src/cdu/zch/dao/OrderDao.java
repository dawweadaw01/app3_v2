package cdu.zch.dao;

import cdu.zch.model.Order;

import java.util.List;

public interface OrderDao {

    // 根据订单编号获取全部订单
    Order get(String orderId);
    // 查找全部订单
    List<Order> findAll();
    //通过顾客id查找
    List<Order> findByCustomer(int customerId);
    // 添加订单
    int insert(Order order);
    //修改订单
    int update(Order order);
    //删除订单
    int delete(String orderId);

    // 分页功能
    int count();
    List<Order> findByPage(int start,int num);
}
