package com.projectteam3.recipeproject.app.rec.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class RecRecipeIngredientSaveRequestDto {
    @NotNull
    private Long quantity;

    @NotNull
    private Long recipeId;

    @NotNull
    private Long ingredientId;

}
