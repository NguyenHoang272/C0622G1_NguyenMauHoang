package ss17_binary_file_serialization.product_manage.model;

import java.io.Serializable;

public class Product implements Serializable {
    private int id;
    private String name;
    private String productCompany;
    private double price;

    public Product() {
    }

    public Product(int id, String name, String productCompany, double price) {
        this.id = id;
        this.name = name;
        this.productCompany = productCompany;
        this.price = price;
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

    public String getProductCompany() {
        return productCompany;
    }

    public void setProductCompany(String productCompany) {
        this.productCompany = productCompany;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s",id,name,productCompany,price);
    }
}