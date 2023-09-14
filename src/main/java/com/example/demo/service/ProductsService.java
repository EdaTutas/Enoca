package com.example.demo.service;

import com.example.demo.model.Categories;
import com.example.demo.model.Products;
import com.example.demo.repository.CategoriesRepository;
import com.example.demo.repository.ProductsRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Transactional
public class ProductsService {

    @Autowired
    private CategoriesRepository categoriesRepository;
    @Autowired
    private ProductsRepository productsRepository;
    public List<Products> findAll(){
        return productsRepository.findAll();
    }
    public Products getById(Long id){
        return  productsRepository.findById(id).get();
    }
    public void save(Products products){
        productsRepository.save(products);
    }
    public void saveOrUpdate(Products products){
        productsRepository.save(products);
    }
    public void delete(long id){
        productsRepository.deleteById(id);
    }
    public void deleteAll(){
        productsRepository.deleteAll();
    }
}