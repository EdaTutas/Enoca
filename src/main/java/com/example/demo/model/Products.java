package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Products")
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;
    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;
    @Column(name = "price")
    private int price;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Categories category_id;

    public Products(){
    }

    public Products(String name, String description, int price, Categories category_id) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.category_id= category_id;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Categories getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Categories category_id) {
        this.category_id = category_id;
    }
}