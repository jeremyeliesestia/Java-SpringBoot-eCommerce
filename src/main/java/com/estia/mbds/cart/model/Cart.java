package com.estia.mbds.cart.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class
Cart {
    @Id
    @GeneratedValue
    private long id;

    @OneToMany(cascade = CascadeType.ALL)
    private List<CartItem> items;

    public Cart(){

    }

    public Cart(long id, List<CartItem> items) {
        this.id = id;
        this.items = items;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<CartItem> getItems() {
        return items;
    }
    public void addItem(CartItem item) {
        this.items.add(item);
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", items=" + items +
                '}';
    }
}
