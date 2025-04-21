package com.workintech.s18d2.services;

import com.workintech.s18d2.entity.Fruit;
import com.workintech.s18d2.repository.FruitRepository;

import java.util.List;

public interface FruitService {

    Fruit save(Fruit fruit);
    List<Fruit> findAll();
    Fruit findById(long id);
    List<Fruit> searchByName(String name);
    List<Fruit> searchByDescOrder();
    List<Fruit> searchByAscOrder();
}
