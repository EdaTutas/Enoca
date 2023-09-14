package com.example.demo.controller;


import com.example.demo.Enocav2Application;
import com.example.demo.model.Products;
import com.example.demo.repository.ProductsRepository;
import com.example.demo.service.ProductsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("products/api/v1")
public class ProductsController {

    private static final Logger logger = LoggerFactory.getLogger(Enocav2Application.class);
    @Autowired
    private ProductsService productsService;

    @Autowired
    private ProductsRepository productsRepository;

    // getAll
    @GetMapping("/getAll")
    public List<Products> getAll() {
        logger.info("***** Getting All Categories *****");
        return productsService.findAll();
    }

    //getById
    @GetMapping(value = "/getById/{id}")
    public Products getById(@PathVariable("id") Long id) {
        try {
            Products products = productsService.getById(id);
            logger.info("***** Getting the products, Id: " + id + " Name: " + products.getName() + " *****");
            return products;
        } catch (NoSuchElementException e) {
            logger.error("***** There is no defined id *****");
            return productsService.getById(id);
        }
    }

    //create
    @PostMapping("/save")
    private long save(@RequestBody Products products) {
        if (products.getName().equals("glass")) {
            logger.error("***** Name can't be glass *****");
        } else {
            logger.info("***** Save the categories Name : " + products.getName() + " *****");
            productsService.save(products);
            return products.getId();
        }
        return 1;
    }

    //update
    @PutMapping("/update")
    private Products update(@RequestBody Products products) {
        if (products.getName().equals("glass")) {
            logger.error("***** Name can't be glass *****");
        } else {
            logger.info("***** Updating the Products *****" );
            productsService.saveOrUpdate(products);
        }
        return products;
    }

    // delete
    @DeleteMapping("/delete/{id}")
    private void delete(@PathVariable("id") long id) {
        try {
            Products products = productsService.getById(id);
            logger.info("***** Deleting the products Id: " + id + " *****");
            productsService.delete(id);
        } catch (NoSuchElementException ex) {
            logger.error("***** There is no defined id *****");
        }
    }

    //deleteAll
    @DeleteMapping("/deleteAll")
    private void deleteAll() {
        logger.info("***** Deleting the all value *****");
        productsService.deleteAll();
    }
}