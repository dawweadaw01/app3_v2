package cdu.zch.dao;

import cdu.zch.model.Product;

import java.util.List;

public interface ProductDao {
    // 查找所有商品
    List<Product> findAll();

    // 根据id查找
    Product findById(int id);

    // 增删改
    int addProduct(Product product);
    int deleteProduct(int id);
    int updateProduct(Product product);

    // 分页功能
    int count();
    List<Product> pageProduct(int currentPage, int pageSize);  //当前页 页面最大数据条数
}
