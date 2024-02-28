package net.openwebinars.java.mysql.crud.model;

import java.util.Objects;

public class Producto {
    private int product_id;
    private  String product_name;
    private String description;
    private double prize;
    private int stock;

    public Producto(){

    }

    public Producto(String product_name, String description, double prize, int stock) {
        this.product_name = product_name;
        this.description = description;
        this.prize = prize;
        this.stock = stock;
    }

    public Producto(int product_id, String product_name, String description, double prize, int stock) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.description = description;
        this.prize = prize;
        this.stock = stock;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrize() {
        return prize;
    }

    public void setPrize(double prize) {
        this.prize = prize;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Producto producto = (Producto) o;
        return product_id == producto.product_id && Double.compare(prize, producto.prize) == 0 && stock == producto.stock && Objects.equals(product_name, producto.product_name) && Objects.equals(description, producto.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(product_id, product_name, description, prize, stock);
    }

    @Override
    public String toString() {
        return "Producto{" +
                "product_id=" + product_id +
                ", product_name='" + product_name + '\'' +
                ", description='" + description + '\'' +
                ", prize=" + prize +
                ", stock=" + stock +
                '}';
    }


}
