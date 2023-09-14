package com.example.demo.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.Set;
@Entity
@Table(name= "categories")
public class Categories {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "name")
    private String name;


    //@Column(nullable = true)
    @OneToMany(mappedBy = "category_id", cascade = CascadeType.ALL)
    private List<Products> products;
    //private Set<Products> productSet;



    public Categories(){
    }

    public Categories(long id, String name){
        this.id=id;
        this.name=name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "Categories{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}