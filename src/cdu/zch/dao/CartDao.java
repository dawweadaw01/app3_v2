package cdu.zch.dao;

import cdu.zch.model.CartItem;

import java.util.Map;

public interface CartDao {

    // 根据顾客ID查找
    Map<Integer, Integer> findById(int customerId);
    // 添加购物车
    int insertCart(CartItem cartItem);
    // 修改购物车商品数量
    int updateCart(CartItem cartItem);
    // 删除购物车
    int deleteCart(CartItem cartItem);
    // 清空购物车
    int delete(int customerId);
}
