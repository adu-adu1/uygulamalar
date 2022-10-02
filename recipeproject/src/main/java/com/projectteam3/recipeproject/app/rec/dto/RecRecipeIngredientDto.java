package com.projectteam3.recipeproject.app.rec.dto;

import com.projectteam3.recipeproject.app.rec.entity.RecIngredient;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RecRecipeIngredientDto {
    private Long id;
    private Long quantity;
    private RecIngredient recIngredient;

}
