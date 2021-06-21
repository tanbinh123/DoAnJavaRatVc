package com.example.Mochi.controller;

import com.example.Mochi.entity.Bill;
import com.example.Mochi.entity.Bill_ID;
import com.example.Mochi.repository.BillRepository;
import com.example.Mochi.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("bill")
public class BillController {

    @Autowired
    private BillService service;

    @Autowired
    private BillRepository repository;

    @GetMapping()
    public List<Bill> getAll(){
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public List<Bill> getBill(@PathVariable("id") int id){
        return service.getBill(id);
    }

    @DeleteMapping("/{id}")
    public String deleteBill(@PathVariable("id") int id)
    {
        return service.deleteCTDH(id);
    }
}
