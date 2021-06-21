package com.example.Mochi.service;

import com.example.Mochi.entity.DonHang;
import com.example.Mochi.entity.User;
import com.example.Mochi.repository.DonhangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class DonhangService {

    @Autowired
    private DonhangRepository repository;

    //Them don hang
    public DonHang createDonhang(DonHang donHang){
        Date now = new Date();
        donHang.setNgayDatHang(now);
        return repository.save(donHang);
    }
    //get all don hang
    public List<DonHang> getAllDonhang(){
        return repository.findAll();
    }
    //get by id
    public Optional<DonHang> getById(int id){
        return repository.findById(id);
    }
    //get by Userid
    public List<DonHang> getByUserid(User userid){
        return repository.getDonhangByUserId(userid);

    }
    //update
    public String putDonhang(DonHang donHang){
        try{
            repository.save(donHang);
        }
        catch (Exception ex){
            ex.getMessage();
            return "false";
        }
        return "true";
    }
    //delete
    public String deleteDonhangById(int id){
        try{
            repository.deleteById(id);
        }catch (Exception ex)
        {
            ex.getMessage();
            return "false";
        }
        return "true";

    }


}
