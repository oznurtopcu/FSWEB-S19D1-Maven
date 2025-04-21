package com.workintech.s18d2.services;

import com.workintech.s18d2.entity.Vegetable;
import com.workintech.s18d2.repository.VegetableRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class VegetableServiceImpl implements VegetableService{

    private VegetableRepository vegetableRepository;

    @Autowired
    public VegetableServiceImpl(VegetableRepository vegetableRepository) {
        this.vegetableRepository = vegetableRepository;
    }

    @Override
    public Vegetable save(Vegetable vegetable) {
        return vegetableRepository.save(vegetable);
    }

    @Override
    public List<Vegetable> findAll() {
        return vegetableRepository.findAll();
    }

    @Override
    public Vegetable findById(long id) {
        Optional<Vegetable> optionalVegetable = vegetableRepository.findById(id);
        //return optionalVegetable.orElse(null);
        if(optionalVegetable.isPresent()) {
            return optionalVegetable.get();
        }
        //throw new Vegetable Exception
        return null;
    }

    @Override
    public List<Vegetable> searchByName(String name) {
        return vegetableRepository.searchByName(name);
    }

    @Override
    public List<Vegetable> searchByDescOrder() {
        return vegetableRepository.searchByDescOrder();
    }

    @Override
    public List<Vegetable> searchByAscOrder() {
        return vegetableRepository.searchByAscOrder();
    }
}
