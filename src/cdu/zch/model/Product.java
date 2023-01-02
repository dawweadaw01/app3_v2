package cdu.zch.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class Product implements Serializable {

    private int id;
    private String name;
    private BigDecimal price;
    private int sale;
    private long stock;
    private String imgUrl;
    private String info;
    private  long marketDate;

    public Product() {
    }

    public Product(int id, String name, BigDecimal price, int sale, long stock, String imgUrl, String info, long marketDate) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.sale = sale;
        this.stock = stock;
        this.imgUrl = imgUrl;
        this.info = info;
        this.marketDate = marketDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getSale() {
        return sale;
    }

    public void setSale(int sale) {
        this.sale = sale;
    }

    // 格式化金钱的方法
    public BigDecimal getSalePrice() {
        return price.multiply(new BigDecimal(sale)).divide(new BigDecimal(100));
    }

    public long getStock() {
        return stock;
    }

    public void setStock(long stock) {
        this.stock = stock;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public long getMarketDate() {
        return marketDate;
    }

    public void setMarketDate(long marketDate) {
        this.marketDate = marketDate;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", sale=" + sale +
                ", stock=" + stock +
                ", imgUrl='" + imgUrl + '\'' +
                ", info='" + info + '\'' +
                ", marketDate=" + marketDate +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Product) {
            return this.id == ((Product) obj).getId();
        }
        return false;
    }
}
