package com.workintech.s18d2.repository;

import com.workintech.s18d2.entity.Vegetable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VegetableRepository extends JpaRepository<Vegetable, Long> {
    //bu sınıfı oluşturmak bize otomatik olarak bütün crud functionlarını getirir
    //özel metodlar yazmak istersek burada yazabiliriz

    //Özel bir query yazmak istediğim zaman bu şekilde repository içine yazıyorum

    @Query("SELECT v FROM Vegetable v WHERE v.name ILIKE %:name%")
    List<Vegetable> searchByName(String name);

    @Query("SELECT v FROM Vegetable v ORDER BY v.price DESC")
    List<Vegetable> searchByDescOrder();

    @Query("SELECT v FROM Vegetable v ORDER BY v.price")
    List<Vegetable> searchByAscOrder();
}
