package cdu.zch.dao.impl;

import cdu.zch.dao.CustomerDao;
import cdu.zch.dao.OrderDao;
import cdu.zch.model.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderDaoImpl extends BaseDao implements OrderDao {
    CustomerDao customerDao = new CustomerDaoImpl();

    @Override
    public Order get(String orderId) {
        Order order = null;
        String sql = "SELECT * FROM order_table WHERE orderId=?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, orderId);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                order = new Order();
                order.setId(rs.getInt("id"));
                order.setOrderId(rs.getString("orderId"));
                order.setCustomerId(rs.getInt("customerId"));
                order.setMoney(rs.getBigDecimal("money"));
                order.setProducts(rs.getString("products"));
                order.setName(rs.getString("name"));
                order.setAddress(rs.getString("address"));
                order.setTel(rs.getString("tel"));
                order.setCreateTime(rs.getLong("createTime"));
                order.setUpdateTime(rs.getLong("updateTime"));
                order.setStatusCode(rs.getInt("statusCode"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return order;

    }

    @Override
    public List<Order> findAll() {
        List<Order> orderList = new ArrayList<Order>();

        String sql = "SELECT * FROM order_table ORDER BY createTime DESC";

        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Order order = new Order();
                order.setId(rs.getInt("id"));
                order.setOrderId(rs.getString("orderId"));
                order.setCustomerId(rs.getInt("customerId"));
                order.setMoney(rs.getBigDecimal("money"));
                order.setProducts(rs.getString("products"));
                order.setName(rs.getString("name"));
                order.setAddress(rs.getString("address"));
                order.setTel(rs.getString("tel"));
                order.setCreateTime(rs.getLong("createTime"));
                order.setUpdateTime(rs.getLong("updateTime"));
                order.setStatusCode(rs.getInt("statusCode"));
                orderList.add(order);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return orderList;
    }

    @Override
    public List<Order> findByCustomer(int customerId) {
        List<Order> orderList = new ArrayList<Order>();

        String sql = "SELECT * FROM order_table ORDER BY createTime DESC WHERE customerId=?";

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, customerId);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Order order = new Order();
                order.setId(rs.getInt("id"));
                order.setMoney(rs.getBigDecimal("money"));
                order.setCustomerId(rs.getInt("customerId"));
                order.setProducts(rs.getString("products"));
                order.setName(rs.getString("name"));
                order.setAddress(rs.getString("address"));
                order.setTel(rs.getString("tel"));
                order.setCreateTime(rs.getLong("createTime"));
                order.setUpdateTime(rs.getLong("updateTime"));
                order.setStatusCode(rs.getInt("statusCode"));
                orderList.add(order);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return orderList;

    }

    @Override
    public int insert(Order order) {
        int rows = 0;

        String sql = "INSERT INTO order_table(orderId,customerId,money,products,name,address,tel,createTime,updateTime,statusCode) VALUES(?,?,?,?,?,?,?,?,?,?)";

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, order.getOrderId());
            pstmt.setInt(2, order.getCustomerId());
            pstmt.setBigDecimal(3, order.getMoney());
            pstmt.setString(4, order.getProducts());
            pstmt.setString(5, order.getName());
            pstmt.setString(6, order.getAddress());
            pstmt.setString(7, order.getTel());
            pstmt.setLong(9, order.getUpdateTime());
            pstmt.setLong(8, order.getCreateTime());
            pstmt.setInt(10, order.getStatusCode());
            rows = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rows;

    }

    @Override
    public int update(Order order) {
        int rows = 0;
        String sql = "UPDATE order_table SET updateTime=?,statusCode=? WHERE orderId=?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setLong(1, order.getUpdateTime());
            pstmt.setInt(2, order.getStatusCode());
            pstmt.setString(3, order.getOrderId());
            rows = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rows;
    }

    @Override
    public int delete(String orderId) {
        int rows = 0;
        String sql = "DELETE FROM order_table WHERE orderId=?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, orderId);
            rows = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rows;

    }

    @Override
    public int count() {
        int count = 0;
        String sql = "SELECT count(*) FROM order_table";
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;

    }

    @Override
    public List<Order> findByPage(int start, int num) {
        List<Order> orderList = new ArrayList<Order>();

        String sql = "SELECT * FROM order_table ORDER BY createTime DESC LIMIT ?,?";

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, start);
            pstmt.setInt(2, num);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Order order = new Order();
                order.setId(rs.getInt("id"));
                order.setOrderId(rs.getString("orderId"));
                order.setMoney(rs.getBigDecimal("money"));
                order.setProducts(rs.getString("products"));
                order.setName(rs.getString("name"));
                order.setAddress(rs.getString("address"));
                order.setTel(rs.getString("tel"));
                order.setCreateTime(rs.getLong("createTime"));
                order.setUpdateTime(rs.getLong("updateTime"));
                order.setStatusCode(rs.getInt("statusCode"));
                orderList.add(order);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return orderList;
    }
}
