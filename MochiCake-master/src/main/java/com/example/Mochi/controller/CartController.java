package com.example.Mochi.controller;

import com.example.Mochi.entity.Cart;
import com.example.Mochi.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("cart")
public class CartController {

    @Autowired
    private CartService service;

    @GetMapping("/{userid}")
    public List<Cart> getCart(@PathVariable("userid") int userid){
        return service.getCart(userid);
    }

    @DeleteMapping("/{userid}")
    public String deleteCartOfUser(@PathVariable("userid") int userid){

        return service.deleteCartByUserId(userid);
    }

    @DeleteMapping("/{userid}/{id}")
    public String deleteCartById(@PathVariable("userid") int userid,
                                 @PathVariable("id") Long id){
        return service.deleteCartById(userid,id);
    }

    @PostMapping("/{userid}/{id}")
    public String addCart(@PathVariable("userid") int userid, @PathVariable("id") Long id, @RequestParam("soluong") int soluong){
        return service.addCart(userid, id, soluong);
    }
}
