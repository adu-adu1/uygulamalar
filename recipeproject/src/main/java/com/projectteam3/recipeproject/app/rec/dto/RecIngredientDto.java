package com.projectteam3.recipeproject.app.rec.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class RecIngredientDto {
    private Long id;
    private String name;
    private BigDecimal price;
    private Boolean isVegetarian;
}
