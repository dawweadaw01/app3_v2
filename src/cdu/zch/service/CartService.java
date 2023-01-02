package cdu.zch.service;

import java.util.Map;

public interface CartService {

    Map<Integer,Integer> getProducts(int customerId);

    boolean add(int customerId, int sProductId);
    boolean update(int customerId, int sProductId, int num);
    boolean del(int customerId, int sProductId);

    boolean clear(int customerId);
}
