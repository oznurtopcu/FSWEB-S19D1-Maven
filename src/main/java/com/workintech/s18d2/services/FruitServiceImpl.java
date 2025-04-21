package com.workintech.s18d2.services;

import com.workintech.s18d2.entity.Fruit;
import com.workintech.s18d2.repository.FruitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//Backgroundda @Service bir componenttir
@Service
public class FruitServiceImpl implements FruitService{

    private FruitRepository fruitRepository;

    @Autowired
    public FruitServiceImpl(FruitRepository fruitRepository) {
        this.fruitRepository = fruitRepository;
    }

    @Override
    public Fruit save(Fruit fruit) {
        return fruitRepository.save(fruit);
    }

    @Override
    public List<Fruit> findAll() {
        return fruitRepository.findAll();
    }

    @Override
    public Fruit findById(long id) {
        Optional<Fruit> fruitOptional = fruitRepository.findById(id);
        if(fruitOptional.isPresent()) {
            return fruitOptional.get();
        }
        //burada exception throw etmeliyiz, null bırakmamalıyız
        return null;
    }

    //isme göre aratan
    @Override
    public List<Fruit> searchByName(String name) {
        return fruitRepository.searchByName(name);
    }

    //artan sıraya göre listeleyen
    @Override
    public List<Fruit> searchByAscOrder() {
        return fruitRepository.searchByAscOrder();
    }

    //azalan sıraya göre listeleyen
    @Override
    public List<Fruit> searchByDescOrder() {
        return fruitRepository.searchByDescOrder();
    }
}
