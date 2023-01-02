package cdu.zch.dao.impl;

import cdu.zch.dao.CustomerDao;
import cdu.zch.model.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerDaoImpl extends BaseDao implements CustomerDao {
    @Override
    public List<Customer> findAll() {
        List<Customer> customerList = new ArrayList<>();

        String sql = "SELECT * FROM customer_table";

        try{
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while(rs.next()){
                Customer customer = new Customer();
                customer.setId(rs.getInt("id"));
                customer.setName(rs.getString("name"));
                customer.setPassword(rs.getString("password"));
                customer.setIsVip(rs.getBoolean("isVip"));
                customerList.add(customer);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return customerList;
    }

    @Override
    public Customer findById(int id) {
        Customer customer = null;

        String sql = "SELECT * FROM customer_table WHERE id=?";

        try{
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();
            while(rs.next()){
                customer = new Customer();
                customer.setId(id);
                customer.setName(rs.getString("name"));
                customer.setPassword(rs.getString("password"));
                customer.setIsVip(rs.getBoolean("isVip"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return customer;
    }

    @Override
    public Customer findByNameAndPwd(String name, String pwd) {
        Customer customer = null;

        String sql = "SELECT * FROM customer_table WHERE name=? AND password=?";

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, name);
            pstmt.setString(2, pwd);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                customer = new Customer();
                customer.setId(rs.getInt("id"));
                customer.setName(rs.getString("name"));
                customer.setPassword(rs.getString("password"));
                customer.setIsVip(rs.getBoolean("isVip"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return customer;
    }

    @Override
    public int addCustomer(Customer customer) {
        int rows = 0;

        String sql = "INSERT INTO customer_table(name, password) VALUES(?, ?)";

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, customer.getName());
            pstmt.setString(2, customer.getPassword());
            rows = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return rows;
    }

    @Override
    public int deleteCustomer(int id) {
        int rows = 0;
        String sql = "DELETE FROM customer_table WHERE id=?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            rows = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rows;
    }

    @Override
    public int updateCustomer(Customer customer) {
        int rows = 0;
        String sql = "UPDATE customer_table SET name=?, password=?, isVip=? WHERE id=?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, customer.getName());
            pstmt.setString(2, customer.getPassword());
            pstmt.setBoolean(3, customer.getIsVip());
            pstmt.setInt(4, customer.getId());
            rows = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return rows;
    }

    @Override
    public int count() {
        // 要执行的SQL语句
        String sql = "SELECT COUNT(*) FROM customer_table";
        int count = 0;
        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while(rs.next()){
                count = rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return count;
    }

    @Override
    public List<Customer> pageCustomer(int currentPage, int pageSize) {
        List<Customer> customerList = new ArrayList<>();

        String sql = "SELECT * FROM customer_table limit ?, ?";

        try{
            pstmt = conn.prepareStatement(sql);
            // SQL语句第一个参数的是从哪里开始，第二个参数是查询多少条数据
            pstmt.setInt(1,(currentPage - 1) * pageSize);
            pstmt.setInt(2, pageSize);
            rs = pstmt.executeQuery();
            while(rs.next()){
                Customer customer = new Customer();
                customer.setId(rs.getInt("id"));
                customer.setName(rs.getString("name"));
                customer.setPassword(rs.getString("password"));
                customer.setIsVip(rs.getBoolean("isVip"));
                customerList.add(customer);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return customerList;
    }
}
