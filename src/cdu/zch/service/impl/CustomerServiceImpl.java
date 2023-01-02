package cdu.zch.service.impl;

import cdu.zch.dao.CustomerDao;
import cdu.zch.dao.impl.CustomerDaoImpl;
import cdu.zch.model.Customer;
import cdu.zch.service.CustomerService;

import java.util.List;

public class CustomerServiceImpl implements CustomerService {

    CustomerDao customerDao = new CustomerDaoImpl();

    @Override
    public List<Customer> findAll() {
        return customerDao.findAll();
    }

    @Override
    public Customer findById(int id) {
        return customerDao.findById(id);
    }

    @Override
    public Customer findByNameAndPwd(String name, String pwd) {
        return customerDao.findByNameAndPwd(name, pwd);
    }

    @Override
    public Boolean addCustomer(Customer customer) {
        return customerDao.addCustomer(customer) == 1;
    }

    @Override
    public Boolean deleteCustomer(int id) {
        return customerDao.deleteCustomer(id) == 1;
    }

    @Override
    public Boolean updateCustomer(Customer customer) {
        return customerDao.updateCustomer(customer) == 1;
    }

    @Override
    public int count() {
        return customerDao.count();
    }

    @Override
    public List<Customer> pageCustomer(int currentPage, int pageSize) {
        return customerDao.pageCustomer(currentPage, pageSize);
    }
}
