package com.example.demo.controller;


import com.example.demo.Enocav2Application;
import com.example.demo.model.Categories;
import com.example.demo.repository.CategoriesRepository;
import com.example.demo.service.CategoriesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("categories/api/v1")
public class CategoriesController {
    private static final Logger logger = LoggerFactory.getLogger(Enocav2Application.class);
    @Autowired
    private CategoriesRepository categoriesRepository;
    @Autowired
    private CategoriesService categoriesService;

    // getAll
    @GetMapping("/getAll")
    public List<Categories> getAll() {
        logger.info("***** Getting All Categories *****");
        return categoriesService.findAll();
    }

    //getById
    @GetMapping(value = "/getById/{id}")
    public void getById(@PathVariable("id") Long id) {
        try {
            Categories categories = categoriesService.getById(id);
            logger.info("***** Getting the categories, Id: " + id + " Name: " + categories.getName() +" *****" );
        } catch (NoSuchElementException e) {
            logger.error("***** There is no defined id *****");
        }
    }

    //create
    @PostMapping("/save")
    private Categories save(@RequestBody Categories categories) {
        if (categories.getName().equals("glass")) {
            logger.error("***** Name can't be glass *****");
        } else {
            logger.info("***** Save the Categories Name " + categories.getName() + " *****");
            categoriesService.save(categories);
        }
        return categories;
    }

    //update
    @PutMapping("/update")
    private void update(@RequestBody Categories categories) {
        if (categories.getName().equals("glass")) {
            logger.error("***** Name can't be glass *****");
        } else {
            logger.info("***** Updating the Categories Name : " + categories.getName() + " *****");
            categoriesService.saveOrUpdate(categories);
        }
    }

    // delete
    @DeleteMapping("/delete/{id}")
    private void delete(@PathVariable("id") long id) {
        try {
            Categories categories = categoriesService.getById(id);
            logger.info("***** Deleting the categories, Id: " + id + " *****");
            categoriesService.delete(id);
        } catch (NoSuchElementException ex) {
            logger.error("***** There is no defined id *****");
        }
    }

    //deleteAll
    @DeleteMapping("/deleteAll")
    private void deleteAll() {
        logger.info("***** Deleting the all value *****");
        categoriesService.deleteAll();
    }
}