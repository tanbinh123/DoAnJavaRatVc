package com.example.Mochi.entity;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class Bill_ID implements Serializable {

    private int donhangId;
    private Long id;

    public int getDonhangId() {
        return donhangId;
    }

    public void setDonhangId(int donhangId) {
        this.donhangId = donhangId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
