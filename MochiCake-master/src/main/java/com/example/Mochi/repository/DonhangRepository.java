package com.example.Mochi.repository;

import com.example.Mochi.entity.DonHang;
import com.example.Mochi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DonhangRepository extends JpaRepository<DonHang, Integer> {

    @Query("select u from DonHang u where u.user = ?1")
    List<DonHang> getDonhangByUserId(User userid);


}
