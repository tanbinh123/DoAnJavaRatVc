package com.example.Mochi.controller;


import com.example.Mochi.entity.Product;
import com.example.Mochi.entity.User;
import com.example.Mochi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin()
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService service;

    @PostMapping()
    public Product createProduct(@RequestBody Product product){
        return service.insertProduct(product);
    }
    @GetMapping()
    public List<Product> getAll(){
        return service.findAll();
    }
    @GetMapping("/{id}")
    public Optional<Product> getProductById (@PathVariable("id") Long id){
        return service.getProductById(id);
    }
    @PutMapping()
    public Product updateUser (@RequestBody Product product){
        return service.updateProduct(product);
    }

    @DeleteMapping("/{userid}")
    @ResponseBody
    public String deleteById(@PathVariable("userid") Long id){
        service.deleteProductById(id);
        return "Successfully";
    }

}
