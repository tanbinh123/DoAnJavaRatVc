package com.example.Mochi.service;

import com.example.Mochi.entity.Bill;
import com.example.Mochi.entity.Bill_ID;
import com.example.Mochi.repository.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BillService {

    @Autowired
    private BillRepository repository;

    public List<Bill> getBill(int donhang_id){
        List<Bill> listBill = repository.getCTDHByMadh(donhang_id);
        return listBill;
    }
    public Optional<Bill> findbyid(Bill_ID id){
        return repository.findById(id);
    }
    public String deleteCTDH(int donhang_id) {

        try {
            repository.deleteCTDHByDonhang(donhang_id);
        } catch (Exception e) {
            e.getMessage();
            return "false";
        }
        return "true";
    }
}
