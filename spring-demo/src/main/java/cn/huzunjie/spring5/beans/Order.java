package cn.huzunjie.spring5.beans;

/**
 * @Author HuZunJie
 * @Date 2021/2/3 15:50
 * @Version 1.0
 */

public class Order {
    private String name;
    private String address;

    public Order(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }
}
