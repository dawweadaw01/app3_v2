package cdu.zch.service.impl;

import cdu.zch.dao.ProductDao;
import cdu.zch.dao.impl.ProductDaoImpl;
import cdu.zch.model.Product;
import cdu.zch.service.ProductService;

import java.util.List;

public class ProductServiceImpl implements ProductService {

    ProductDao productDao = new ProductDaoImpl();

    @Override
    public List<Product> findAll() {
        return productDao.findAll();
    }

    @Override
    public Product findById(int id) {
        return productDao.findById(id);
    }

    @Override
    public Boolean addProduct(Product product) {
        return productDao.addProduct(product) == 1;
    }

    @Override
    public Boolean deleteProduct(int id) {
        return productDao.deleteProduct(id) == 1;
    }

    @Override
    public Boolean updateProduct(Product product) {
        return productDao.updateProduct(product) == 1;
    }

    @Override
    public int count() {
        return productDao.count();
    }

    @Override
    public List<Product> pageProduct(int currentPage, int pageSize) {
        return productDao.pageProduct(currentPage, pageSize);
    }
}
