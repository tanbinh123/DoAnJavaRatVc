package com.example.Mochi.service;

import com.example.Mochi.entity.Category;
import com.example.Mochi.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    public Category insertCategory (Category category) { return repository.save(category) ;}

    public List<Category> insertCategories(List<Category> categories){
        return repository.saveAll(categories);
    }

    public List<Category> getCategory(){
        return repository.findAll();
    }


    public Category updateCategory(Category category) {
        Category baseCategory = repository.findById(category.getId()).orElse(null);
        baseCategory.setName(category.getName());
        return repository.save(baseCategory);
    }


    public void deleteById(int id) {
        repository.deleteById(id);
    }


}
