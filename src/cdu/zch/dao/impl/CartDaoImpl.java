package cdu.zch.dao.impl;

import cdu.zch.dao.CartDao;
import cdu.zch.model.CartItem;

import java.util.HashMap;
import java.util.Map;

public class CartDaoImpl extends BaseDao implements CartDao {
    @Override
    public Map<Integer, Integer> findById(int customerId) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        String sql = "SELECT * FROM cart_table WHERE customerId=?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, customerId);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                map.put(rs.getInt("productId"), rs.getInt("number"));
            }
//            System.out.println("map:@@@" + map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

    @Override
    public int insertCart(CartItem cartItem) {
        int rows = 0;
        String sql = "INSERT INTO cart_table(customerId, productId, number) VALUES(?, ?, ?)";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, cartItem.getCustomerId());
            pstmt.setInt(2, cartItem.getProductId());
            pstmt.setInt(3, cartItem.getNumber());
            rows = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rows;
    }

    @Override
    public int updateCart(CartItem cartItem) {
        int rows = 0;
        String sql = "UPDATE cart_table SET number=? WHERE customerId=? AND productId=?";

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, cartItem.getNumber());
            pstmt.setInt(2, cartItem.getCustomerId());
            pstmt.setInt(3, cartItem.getProductId());
            rows = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return rows;
    }

    @Override
    public int deleteCart(CartItem cartItem) {
        int rows = 0;
        String sql = "DELETE FROM cart_table WHERE customerId=? AND productId=?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, cartItem.getCustomerId());
            pstmt.setInt(2, cartItem.getProductId());
            rows = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rows;
    }

    @Override
    public int delete(int customerId) {
        int rows = 0;
        String sql = "DELETE FROM cart_table WHERE customerId=?";

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, customerId);
            rows = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return rows;
    }
}
