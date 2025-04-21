package com.workintech.s18d2.repository;

import com.workintech.s18d2.entity.Fruit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FruitRepository extends JpaRepository<Fruit, Long> {
    //bu sınıfı oluşturmak bize otomatik olarak bütün crud functionlarını getirir
    //özel metodlar yazmak istersek burada yazabiliriz

    //Özel bir query yazmak istediğim zaman bu şekilde repository içine yazıyorum

    @Query("SELECT f FROM Fruit f WHERE f.name ILIKE %:name%")
    List<Fruit> searchByName(String name);

    @Query("SELECT f FROM Fruit f ORDER BY f.price DESC")
    List<Fruit> searchByDescOrder();

    @Query("SELECT f FROM Fruit f ORDER BY f.price")
    List<Fruit> searchByAscOrder();
}
