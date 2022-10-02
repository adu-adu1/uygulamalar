package com.projectteam3.recipeproject.app.rec.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class RecRecipeImageSaveRequestDto {
    @NotNull
    private String link;

    @NotNull
    private Long recipeId;
}
