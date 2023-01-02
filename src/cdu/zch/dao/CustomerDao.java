package cdu.zch.dao;

import cdu.zch.model.Customer;

import java.util.List;

public interface CustomerDao {

    // 查找全部用户
    List<Customer> findAll();
    //通过ID 查找
    Customer findById(int id);
    // 通过用户名密码查找
    Customer findByNameAndPwd(String name, String pwd);

    //增删改
    int addCustomer(Customer customer);
    int deleteCustomer(int id);
    int updateCustomer(Customer customer);

    //分页功能
    int count();
    List<Customer> pageCustomer(int currentPage, int pageSize);
}
