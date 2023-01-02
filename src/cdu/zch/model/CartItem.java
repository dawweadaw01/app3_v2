package cdu.zch.model;

public class CartItem {

    private int id;
    private int customerId;  // 顾客id
    private int productId;   // 商品id
    private int number;    // 商品数量

    public CartItem() {
    }

    public CartItem(int id, int customerId, int productId, int number) {
        this.id = id;
        this.customerId = customerId;
        this.productId = productId;
        this.number = number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "id=" + id +
                ", customerId=" + customerId +
                ", productId=" + productId +
                ", number=" + number +
                '}';
    }
}
