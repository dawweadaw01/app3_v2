package cdu.zch.dao.impl;

import cdu.zch.dao.ProductDao;
import cdu.zch.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl extends BaseDao implements ProductDao {

    @Override
    public List<Product> findAll() {
        List<Product> productList = new ArrayList<>();
        String sql = "SELECT * FROM product_table ORDER BY id DESC";
        try{
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while(rs.next()){
                Product product = new Product();
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                product.setPrice(rs.getBigDecimal("price"));
                product.setSale(rs.getInt("sale"));
                product.setStock(rs.getLong("stock"));
                product.setMarketDate(rs.getLong("marketDate"));
                product.setImgUrl(rs.getString("imgUrl"));
                product.setInfo(rs.getString("info"));
                productList.add(product);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return productList;
    }

    @Override
    public Product findById(int id) {
        Product product = null;

        String sql = "SELECT * FROM product_table WHERE id=?";

        try{
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();
            while(rs.next()){
                product = new Product();
                product.setId(id);
                product.setName(rs.getString("name"));
                product.setPrice(rs.getBigDecimal("price"));
                product.setSale(rs.getInt("sale"));
                product.setStock(rs.getLong("stock"));
                product.setMarketDate(rs.getLong("marketDate"));
                product.setImgUrl(rs.getString("imgUrl"));
                product.setInfo(rs.getString("info"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return product;
    }

    @Override
    public int addProduct(Product product) {
        int rows = 0;

        String sql = "INSERT INTO product_table(name, price, sale, stock, marketDate, imgUrl, info) VALUES(?, ?, ?, ?, ?, ?, ?)";

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, product.getName());
            pstmt.setBigDecimal(2, product.getPrice());
            pstmt.setInt(3, product.getSale());
            pstmt.setLong(4, product.getStock());
            pstmt.setLong(5, product.getMarketDate());
            pstmt.setString(6, product.getImgUrl());
            pstmt.setString(7, product.getInfo());

            rows = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return rows;
    }

    @Override
    public int deleteProduct(int id) {
        int rows = 0;
        String sql = "DELETE FROM product_table WHERE id=?";
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
    public int updateProduct(Product product) {
        int rows = 0;

        String sql = "UPDATE product_table SET name=?, price=?, sale=?, stock=?, imgUrl=?, info=?, marketDate=? WHERE id=?";

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, product.getName());
            pstmt.setBigDecimal(2, product.getPrice());
            pstmt.setInt(3, product.getSale());
            pstmt.setLong(4, product.getStock());
            pstmt.setString(5, product.getImgUrl());
            pstmt.setString(6, product.getInfo());
            pstmt.setLong(7, product.getMarketDate());
            pstmt.setInt(8, product.getId());

            rows = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return rows;
    }

    @Override
    public int count() {
        // 要执行的SQL语句
        String sql = "SELECT COUNT(*) FROM product_table";
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
    public List<Product> pageProduct(int currentPage, int pageSize) {
        List<Product> productList = new ArrayList<>();

        String sql = "SELECT * FROM product_table limit ?, ? ";

        try{
            pstmt = conn.prepareStatement(sql);
            // SQL语句第一个参数的是从哪里开始，第二个参数是查询多少条数据
            pstmt.setInt(1,(currentPage - 1) * pageSize);
            pstmt.setInt(2, pageSize);
            rs = pstmt.executeQuery();
            while(rs.next()){
                Product product = new Product();
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                product.setPrice(rs.getBigDecimal("price"));
                product.setSale(rs.getInt("sale"));
                product.setStock(rs.getLong("stock"));
                product.setMarketDate(rs.getLong("marketDate"));
                product.setImgUrl(rs.getString("imgUrl"));
                product.setInfo(rs.getString("info"));
                productList.add(product);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return productList;
    }
}
