package com.projectteam3.recipeproject.app.rec.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class RecRecipeUpdateRequestDto {

    @NotNull
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private String description;
}
