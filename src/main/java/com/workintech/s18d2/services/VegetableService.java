package com.workintech.s18d2.services;

import com.workintech.s18d2.entity.Vegetable;

import java.util.List;

public interface VegetableService {

    Vegetable save(Vegetable vegetable);
    List<Vegetable> findAll();
    Vegetable getById(long id);
    List<Vegetable> searchByName(String name);
    List<Vegetable> getByPriceDesc();
    List<Vegetable> getByPriceAsc();
    void deleteById(long id);
}

