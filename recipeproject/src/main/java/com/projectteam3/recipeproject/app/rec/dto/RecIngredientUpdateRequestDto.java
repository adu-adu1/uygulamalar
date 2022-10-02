package com.projectteam3.recipeproject.app.rec.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Getter
@Setter
public class RecIngredientUpdateRequestDto {

    @NotNull
    private Long id;

    @NotNull
    @Size(max = 100)
    private String name;
    private BigDecimal price;
    private Boolean isVegetarian;
}
