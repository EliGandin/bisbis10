package com.att.tdp.bisbis10.domain;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name = "ratings")
public class Rating {
    @Id
    private Long restaurantId;

    @ElementCollection
    private List<Double> rating;

}
