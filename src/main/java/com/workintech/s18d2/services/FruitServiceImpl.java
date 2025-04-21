package com.workintech.s18d2.services;

import com.workintech.s18d2.entity.Fruit;
import com.workintech.s18d2.exceptions.PlantException;
import com.workintech.s18d2.repository.FruitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public Fruit getById(long id) {
        Optional<Fruit> fruitOptional = fruitRepository.findById(id);
        if(fruitOptional.isPresent()) {
            return fruitOptional.get();
        }
        throw new PlantException("Bu ID ile eşleşen bir kayıt bulunamadı!", HttpStatus.NOT_FOUND);
    }

    @Override
    public Fruit delete(long id) {
        Optional<Fruit> fruitOptional = fruitRepository.findById(id);
        if(fruitOptional.isPresent()) {
            fruitRepository.delete(fruitOptional.get());
            return fruitOptional.get();
        }
      throw new PlantException("Bu ID ile eşleşen bir kayıt bulunamadı!", HttpStatus.NOT_FOUND);
    }

    //isme göre aratan
    @Override
    public List<Fruit> searchByName(String name) {
        return fruitRepository.searchByName(name);
    }

    //artan sıraya göre listeleyen
    @Override
    public List<Fruit> getByPriceAsc() {
        return fruitRepository.getByPriceAsc();
    }

    //azalan sıraya göre listeleyen
    @Override
    public List<Fruit> getByPriceDesc() {
        return fruitRepository.getByPriceAsc();
    }
}
