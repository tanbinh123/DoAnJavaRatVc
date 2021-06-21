package com.example.Mochi.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private float price;
    private String description;
    private String img_Url;

    public Product(){

    }

    @JsonIgnore
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    List<Bill> listCTHD;

    public List<Bill> getListCTHD() {
        return listCTHD;
    }

    public void setListCTHD(List<Bill> listCTHD) {
        this.listCTHD = listCTHD;
    }

    @ManyToOne
    @JoinColumn(name = "category")
    private Category category;


    @JsonIgnore
    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    List<Cart> listCart;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Cart> getListCart() {
        return listCart;
    }

    public void setListCart(List<Cart> listCart) {
        this.listCart = listCart;
    }
    //    @JsonIgnore
//    @OneToMany(mappedBy = "product")
//    private List<Bill> listBill = new ArrayList<>();
//
//
//    @JsonIgnore
//    @OneToMany(mappedBy = "product")
//    private List<Cart> listGioHang = new ArrayList<>();
//
//    public List<Bill> getListBill() {
//        return listBill;
//    }
//
//    public void setListBill(List<Bill> listBill) {
//        this.listBill = listBill;
//    }
//
//    public List<Cart> getListGioHang() {
//        return listGioHang;
//    }
//
//    public void setListGioHang(List<Cart> listGioHang) {
//        this.listGioHang = listGioHang;
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImg_Url() {
        return img_Url;
    }

    public void setImg_Url(String img_Url) {
        this.img_Url = img_Url;
    }
}
