package com.example.Mochi.repository;

import com.example.Mochi.entity.Cart;
import com.example.Mochi.entity.Cart_ID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Cart, Cart_ID> {

    @Query("select u from Cart u where u.user = ?1")
    List<Cart> getCartByUserid(int userid);

    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "delete from Cart where user = ?1")
    List<Cart> deleteCartByUserId(int userid);

}
