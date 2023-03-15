package com.example.demo2;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
@Data
@AllArgsConstructor
public class Order {
    private String id;
    private List<Product> products;}
    //------------constructor--------------
   /* public Order() {
    }
    public Order(String id, List<Product> products) {
        this.id = id;
        this.products = products;
    }
    //------------------setter und getter für id----------------

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    //--------------- setter und getter für product------------------
    public List<Product> getProducts() {
        return products;
    }
    public void setProducts(List<Product> products) {
        this.products = products;
    }

    //---------------------equals----------------------
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order order)) return false;

        if (getId() != null ? !getId().equals(order.getId()) : order.getId() != null) return false;
        return getProducts() != null ? getProducts().equals(order.getProducts()) : order.getProducts() == null;
    }

    //____________hashcode______________-----
    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getProducts() != null ? getProducts().hashCode() : 0);
        return result;
    }
    //-_______--toString_________________________-
    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", products=" + products +
                '}';
    } */
