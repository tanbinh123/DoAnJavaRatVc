package com.example.Mochi.entity;

import javax.persistence.*;

@Entity
@Table(name = "cart")

public class Cart {

    @EmbeddedId
    private Cart_ID cartId;
    private int soluong;

    @ManyToOne
    @MapsId("userid")
    @JoinColumn(name = "userid")
    private User user;

    @ManyToOne
    @MapsId("id")
    @JoinColumn(name = "id")
    private Product product;


    public Cart(){

    }

    public Cart_ID getCartId() {
        return cartId;
    }

    public void setCartId(Cart_ID cartId) {
        this.cartId = cartId;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
