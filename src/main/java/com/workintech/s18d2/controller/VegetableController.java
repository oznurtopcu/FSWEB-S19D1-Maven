package com.workintech.s18d2.controller;

import com.workintech.s18d2.entity.Fruit;
import com.workintech.s18d2.entity.Vegetable;
import com.workintech.s18d2.services.VegetableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vegetables")
public class VegetableController {

    private VegetableService vegetableService;

    @Autowired
    public VegetableController(VegetableService vegetableService) {
        this.vegetableService = vegetableService;
    }

    //[GET]/workintech/vegetables => tüm vegetables kayıtlarını price göre artan sırada dönmeli.
    @GetMapping
    public List<Vegetable> getByPriceAsc() {
        return vegetableService.getByPriceAsc();
    }

    @GetMapping("/{id}")
    public Vegetable findById(@PathVariable long id) {
        return vegetableService.getById(id);
    }

    @GetMapping("/desc")
    public List<Vegetable> getByPriceDesc() {
        return vegetableService.getByPriceDesc();
    }

    @PostMapping
    public Vegetable save( @Validated @RequestBody Vegetable vegetable) {
        return vegetableService.save(vegetable);
    }

    //[POST]/workintech/vegetables/{name} => Bir adet name değişkeni alır
    // ve vegetable tablosu içerisinde geçen tüm vegetable değerlerini döner

    @GetMapping("/name/{name}")
    public List<Vegetable> searchByName(@PathVariable String name) {
        return vegetableService.searchByName(name);
    }


    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable long id) {
        vegetableService.deleteById(id);
    }
}
