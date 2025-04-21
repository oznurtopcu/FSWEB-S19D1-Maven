package com.workintech.s18d2.controller;

import com.workintech.s18d2.entity.Fruit;
import com.workintech.s18d2.services.FruitService;
import com.workintech.s18d2.services.FruitServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fruit")
public class FruitController {

    private FruitService fruitService;

    @Autowired
    public FruitController(FruitService fruitService) {
        this.fruitService = fruitService;
    }

    //[GET]/workintech/fruits => tüm fruits kayıtlarını price göre artan sırada dönmeli.
    @GetMapping
    public List<Fruit> getByPriceAsc() {
        return fruitService.getByPriceAsc();
    }

    //[GET]/workintech/fruits/{id} => İlgili id deki fruit objesini dönmeli.
    @GetMapping("/{id}")
    public Fruit findById(@PathVariable long id) {
        return fruitService.getById(id);
    }

    //[GET]/workintech/fruits/desc => tüm fruit kayıtlarını price göre azalan sırada dönmeli.
    @GetMapping("/desc")
    public List<Fruit> getByPriceDesc() {
        return fruitService.getByPriceDesc();
    }

    @PostMapping
    public Fruit save(@RequestBody Fruit fruit) {
        return fruitService.save(fruit);
    }

    @GetMapping("/name/{name}")
    public List<Fruit> searchByName(@PathVariable String name) {
        return fruitService.searchByName(name);
    }

    @DeleteMapping("/{id}")
    public Fruit delete(@PathVariable long id) {
        return fruitService.delete(id);
    }

}
