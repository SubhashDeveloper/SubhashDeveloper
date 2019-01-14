package com.example.subhash.subhashdeveloper;

public class Pojo {
    String name;
    String price;
    String product_size;
    String time_stamp;
    String quantity;

    public Pojo(String name, String price, String product_size, String time_stamp, String quantity) {
        this.name = name;
        this.price = price;
        this.product_size = product_size;
        this.time_stamp = time_stamp;
        this.quantity = quantity;
    }

    public Pojo() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getProduct_size() {
        return product_size;
    }

    public void setProduct_size(String product_size) {
        this.product_size = product_size;
    }

    public String getTime_stamp() {
        return time_stamp;
    }

    public void setTime_stamp(String time_stamp) {
        this.time_stamp = time_stamp;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
}
