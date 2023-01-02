package cdu.zch.model;

public class Customer {

    private int id;
    private String name;
    private String password;
    private Boolean isVip;

    public Customer() {
    }

    public Customer(int id, String name, String password, Boolean isVip) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.isVip = isVip;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getIsVip() {
        return isVip;
    }

    public void setIsVip(Boolean vip) {
        isVip = vip;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", isVip=" + isVip +
                '}';
    }
}
