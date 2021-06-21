package com.example.Mochi.service;

import com.example.Mochi.entity.Product;
import com.example.Mochi.entity.User;
import com.example.Mochi.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;


    public Product insertProduct (Product product){
      return repository.save(product);
    }

    public List<Product> findAll(){
        return repository.findAll();
    }

    public Product getByName(String name){
        return repository.findByName(name);
    }

    public Optional<Product> getProductById(Long id){
        return repository.findById(id);
    }
    public Product updateProduct(Product updateProduct){
        Product baseProduct = repository.findById(updateProduct.getId()).orElse(null);
        baseProduct.setName(updateProduct.getName());
        baseProduct.setPrice(updateProduct.getPrice());
        baseProduct.setDescription(updateProduct.getDescription());
        return repository.save(baseProduct);
    }

    //DeleteUserById
    public void deleteProductById(Long id) {
        repository.deleteById(id);
    }
}
