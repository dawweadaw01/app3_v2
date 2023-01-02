package cdu.zch.model;

import java.math.BigDecimal;

public class Order {
    private int id;
    private String orderId;  // 订单编号
    private int customerId;   // 顾客编号
    private BigDecimal money;  // 商品总价
    private String products;   // 商品数
    private String name;    // 收件人姓名
    private String address;   //收件地址
    private String tel;   // 收件电话
    private int statusCode;   // 订单状态
    private long createTime;   // 下单时间
    private long updateTime;   // 订单状态更新时间

    public Order() {
    }

    public Order(int id, String orderId, int customerId, BigDecimal money, String products, String name,
                 String address, String tel, int statusCode, long createTime, long updateTime) {
        this.id = id;
        this.orderId = orderId;
        this.customerId = customerId;
        this.money = money;
        this.products = products;
        this.name = name;
        this.address = address;
        this.tel = tel;
        this.statusCode = statusCode;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public String getProducts() {
        return products;
    }

    public void setProducts(String products) {
        this.products = products;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(long updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderId='" + orderId + '\'' +
                ", customerId=" + customerId +
                ", money=" + money +
                ", products='" + products + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", tel='" + tel + '\'' +
                ", statusCode=" + statusCode +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
