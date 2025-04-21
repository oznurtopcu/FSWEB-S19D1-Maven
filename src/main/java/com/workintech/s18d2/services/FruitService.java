package com.workintech.s18d2.services;

import com.workintech.s18d2.entity.Fruit;
import com.workintech.s18d2.repository.FruitRepository;

import java.util.List;

public interface FruitService {

    Fruit save(Fruit fruit);
    List<Fruit> findAll();
    Fruit getById(long id);
    List<Fruit> searchByName(String name);
    List<Fruit> getByPriceDesc();
    List<Fruit> getByPriceAsc();
    Fruit delete(long id);
}
