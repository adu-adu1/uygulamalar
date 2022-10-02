package com.projectteam3.recipeproject.app.rec.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "REC_INGREDIENT")
@Getter
@Setter
public class RecIngredient {
    @Id
    @SequenceGenerator(name = "RecIngredient", sequenceName = "REC_INGREDIENT_ID_SEQ")
    @GeneratedValue(generator = "RecIngredient")
    private Long id;

    @Column(name = "NAME", nullable = false, unique = true, length = 100)
    private String name;

    @Column(name = "PRICE", precision = 19, scale = 2)
    private BigDecimal price;

    @Column(name = "IS_VEGETARIAN")
    private Boolean isVegetarian;
}
