package com.example.Mochi.entity;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class Cart_ID implements Serializable {

    private int userid;
    private Long id;

    public Cart_ID(){
        super();
    }

    public Cart_ID(int userid, Long id){
        super();
        this.userid = userid;
        this.id = id;

    }
    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
