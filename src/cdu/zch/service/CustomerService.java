package cdu.zch.service;

import cdu.zch.model.Customer;

import java.util.List;

public interface CustomerService {

    // 查找全部用户
    List<Customer> findAll();
    //通过ID 查找
    Customer findById(int id);
    // 通过用户名密码查找
    Customer findByNameAndPwd(String name, String pwd);

    //增删改
    Boolean addCustomer(Customer customer);
    Boolean deleteCustomer(int id);
    Boolean updateCustomer(Customer customer);

    //分页功能
    int count();
    List<Customer> pageCustomer(int currentPage, int pageSize);
}
