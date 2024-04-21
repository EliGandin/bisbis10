package com.att.tdp.bisbis10.domain;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "restaurants")
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "restaurants_id_seq")
    private Integer id;
    
    private String name;

    private Rating rating;

    private boolean isKosher;

    @ElementCollection
    private List<String> cuisines;
}
