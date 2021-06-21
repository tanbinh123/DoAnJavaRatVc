package com.example.Mochi.controller;


import com.example.Mochi.entity.DonHang;
import com.example.Mochi.entity.User;
import com.example.Mochi.repository.DonhangRepository;
import com.example.Mochi.service.DonhangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/order")
public class DonhangController {

    @Autowired
    private DonhangService service;

    @Autowired
    private DonhangRepository repository;

    @PostMapping()
    public DonHang createDonhang(@RequestBody DonHang donHang){
        return service.createDonhang(donHang);
    }
    @GetMapping()
    public List<DonHang> getAll(){
        return service.getAllDonhang();
    }
    //get DonhangById
    @GetMapping("/{id}")
    public Optional<DonHang> getDonhangById(@PathVariable("id") int id){
        return service.getById(id);
    }
    //getByUserid
    @GetMapping("/user")
    public List<DonHang> getByUserId(@RequestParam(value = "user", required = false) User user)
    {
        return repository.getDonhangByUserId(user);
    }

    @PutMapping()
    public String updateDonhang(@RequestBody DonHang donHang) {
        return service.putDonhang(donHang);
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public String deleteDonhang(@PathVariable("id") int id){
            return  service.deleteDonhangById(id);
    }

}
