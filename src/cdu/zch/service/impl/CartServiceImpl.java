package cdu.zch.service.impl;

import cdu.zch.dao.CartDao;
import cdu.zch.dao.CustomerDao;
import cdu.zch.dao.ProductDao;
import cdu.zch.dao.impl.CartDaoImpl;
import cdu.zch.dao.impl.CustomerDaoImpl;
import cdu.zch.dao.impl.ProductDaoImpl;
import cdu.zch.model.CartItem;
import cdu.zch.service.CartService;

import java.util.Map;

public class CartServiceImpl implements CartService {

    CartDao cartDao = new CartDaoImpl();

    @Override
    public Map<Integer, Integer> getProducts(int customerId) {
        return cartDao.findById(customerId);
    }

    @Override
    public boolean add(int customerId, int sProductId) {
        CartItem cartItem = new CartItem();
        cartItem.setCustomerId(customerId);
        cartItem.setProductId(sProductId);
        cartItem.setNumber(1);

        return cartDao.insertCart(cartItem) == 1;
    }

    @Override
    public boolean update(int customerId, int sProductId, int num) {
        CartItem cartItem = new CartItem();
        cartItem.setCustomerId(customerId);
        cartItem.setProductId(sProductId);
        cartItem.setNumber(num);

        return cartDao.updateCart(cartItem) == 1;
    }

    @Override
    public boolean del(int customerId, int sProductId) {
        CartItem cartItem = new CartItem();
        cartItem.setCustomerId(customerId);
        cartItem.setProductId(sProductId);

        return cartDao.deleteCart(cartItem) == 1;
    }

    @Override
    public boolean clear(int customerId) {
        return cartDao.delete(customerId) == 1;
    }
}
