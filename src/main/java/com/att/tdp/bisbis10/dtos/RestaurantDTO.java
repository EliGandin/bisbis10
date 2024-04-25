package com.att.tdp.bisbis10.dtos;

import java.util.List;

public class RestaurantDTO {
    private Long id;
    private String name;
    private boolean isKosher;
    private List<String> cuisines;

    public RestaurantDTO() {
    }

    public RestaurantDTO(Long id, String name, boolean isKosher, List<String> cuisines) {
        this.id = id;
        this.name = name;
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
}
