package com.workintech.s18d2.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="fruit", schema="fsweb")
public class Fruit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    @Min(value=0, message = "ID değeri 0'dan küçük olamaz!")
    private long id;

    @Column(name="name")
    @NotNull
    @NotBlank
    private String name;

    @Column(name="price")
    @NotNull
    private double price;

    @Column(name="fruit_type")
    @Enumerated(EnumType.STRING)
    private FruitType fruitType;
}
