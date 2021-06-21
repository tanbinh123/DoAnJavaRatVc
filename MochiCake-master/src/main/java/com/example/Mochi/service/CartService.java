package com.example.Mochi.service;

import com.example.Mochi.entity.Cart;
import com.example.Mochi.entity.Cart_ID;
import com.example.Mochi.entity.Product;
import com.example.Mochi.entity.User;
import com.example.Mochi.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    @Autowired
    private CartRepository repository;

    public List<Cart> getCart(int userid){

        List<Cart> listCart = repository.getCartByUserid(userid);
        return listCart;

    }

    public String deleteCartByUserId(int userid){

        try {
            repository.deleteCartByUserId(userid);
        }
        catch (Exception ex) {
            ex.getMessage();
            return "false";
        }
        return "true";
    }

    public String deleteCartById(int userid, Long productId){
        Cart cart = new Cart();
        cart.setCartId(new Cart_ID(userid, productId));
        try {
            repository.delete(cart);
        }
        catch (Exception ex){
            ex.getMessage();
            ex.printStackTrace();
            return "false";
        }
        return "true";
    }

    //post
    public String addCart(int userid, Long productId, int soluong){
        Cart_ID id = new Cart_ID(userid, productId);
        Cart cart = new Cart();
        cart.setCartId(id);
        cart.setSoluong(soluong);
        Product product = new Product();
        product.setId(productId);
        User user = new User();
        user.setUserid(userid);
        cart.setProduct(product);
        cart.setUser(user);

        List<Cart> listCart = repository.findAll();
        for (Cart i:listCart){
            if(i.getCartId().getId()==productId && i.getCartId().getUserid()==userid){
                cart.setSoluong(soluong +i.getSoluong());
            }
        }
        try{
            repository.save(cart);
            return "true";
        }
        catch (Exception ex){
            ex.printStackTrace();

        }
        return "false";
    }




}
