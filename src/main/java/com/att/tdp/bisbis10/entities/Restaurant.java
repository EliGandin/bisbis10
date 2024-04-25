package com.att.tdp.bisbis10.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.Formula;

import java.util.List;

@Entity
@Table(name = "restaurants")
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;

//    @ManyToOne
//    private Rating rating;

    @Column
    @Formula("(SELECT AVG(average_rating) FROM ratings r WHERE r.restaurant_id = id)")
    private Double avgRating;

    private boolean isKosher;

    @ElementCollection(fetch = FetchType.EAGER)
    @Column(name = "cuisines")
    private List<String> cuisines;

    public Restaurant() {
    }
    public Restaurant(String name,Rating rating, boolean isKosher, List<String> cuisines) {
        this.name = name;
//        this.rating = rating;
        this.isKosher = isKosher;
        this.cuisines = cuisines;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public Rating getRating() {
//        return rating;
//    }
//
//    public void setRating(Rating rating) {
//        this.rating = rating;
//    }

    public boolean isKosher() {
        return isKosher;
    }

    public void setKosher(boolean kosher) {
        isKosher = kosher;
    }

    public List<String> getCuisines() {
        return cuisines;
    }

    public void setCuisines(List<String> cuisines) {
        this.cuisines = cuisines;
    }

    public Double getAvgRating() {
        return avgRating;
    }

    public void setAvgRating(Double avgRating) {
        this.avgRating = avgRating;
    }
}
