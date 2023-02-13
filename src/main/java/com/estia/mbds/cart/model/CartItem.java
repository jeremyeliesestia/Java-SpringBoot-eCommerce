package com.estia.mbds.cart.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class CartItem {

    @Id
    @GeneratedValue
    private long id;

    private long productId;
    private String title;
    private String description;
    private String illustration;
    private Double price;

    private int quantity;

    public CartItem(){

    }

    public CartItem(long productId, String title, String description, String illustration, Double price, Integer quantity) {
        this.id = id;
        this.productId = productId;
        this.title = title;
        this.description = description;
        this.illustration = illustration;
        this.price = price;
        this.quantity = quantity;
    }

   public CartItem(String title, String description, String illustration, Double price, Integer quantity) {
        this.productId = productId;
        this.title = title;
        this.description = description;
        this.illustration = illustration;
        this.price = price;
        this.quantity = quantity;
   }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIllustration() {
        return illustration;
    }

    public void setIllustration(String illustration) {
        this.illustration = illustration;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "id=" + id +
                ", productId=" + productId +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", illustration='" + illustration + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
