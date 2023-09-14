package com.example.demo.service;

import com.example.demo.model.Categories;
import com.example.demo.repository.CategoriesRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Transactional
public class CategoriesService {
    @Autowired
    private CategoriesRepository categoriesRepository;
    public List<Categories> findAll(){
        return categoriesRepository.findAll();
    }
    public Categories getById(Long id){
        return  categoriesRepository.findById(id).get();
    }
    public void save(Categories categories){
        categoriesRepository.save(categories);
    }
    public void saveOrUpdate(Categories categories){
        categoriesRepository.save(categories);
    }
    public void delete(long id){
        categoriesRepository.deleteById(id);
    }
    public void deleteAll(){
        categoriesRepository.deleteAll();
    }
}