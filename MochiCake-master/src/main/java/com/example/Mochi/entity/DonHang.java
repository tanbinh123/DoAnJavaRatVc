package com.example.Mochi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "donhang")
public class DonHang {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int donhangId;
    private float TongTien;
    private Date NgayDatHang;

    @ManyToOne
    @JoinColumn(name = "userid")
    private User user;



    @JsonIgnore
    @OneToMany(mappedBy = "donhang",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    List<Bill> listCTDH;

    public DonHang(){

    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Bill> getListCTDH() {
        return listCTDH;
    }

    public void setListCTDH(List<Bill> listCTDH) {
        this.listCTDH = listCTDH;
    }

    public int getDonhangId() {
        return donhangId;
    }

    public void setDonhangId(int donhangId) {
        this.donhangId = donhangId;
    }

    public float getTongTien() {
        return TongTien;
    }

    public void setTongTien(float tongTien) {
        TongTien = tongTien;
    }

    public Date getNgayDatHang() {
        return NgayDatHang;
    }

    public void setNgayDatHang(Date ngayDatHang) {
        NgayDatHang = ngayDatHang;
    }


}
