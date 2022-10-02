package com.projectteam3.recipeproject.app.rec.controller;

import com.projectteam3.recipeproject.app.rec.dto.RecRecipeIngredientSaveRequestDto;
import com.projectteam3.recipeproject.app.rec.dto.RecRecipeIngredientUpdateRequestDto;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1/recipes-ingredients")
public interface RecRecipeIngredientOperations {

    @PostMapping
    ResponseEntity save(@Validated @RequestBody RecRecipeIngredientSaveRequestDto recRecipeIngredientSaveRequestDto);

    @PutMapping
    ResponseEntity update(@Validated @RequestBody RecRecipeIngredientUpdateRequestDto recRecipeIngredientUpdateRequestDto);

    @DeleteMapping("/{id}")
    ResponseEntity delete(@PathVariable Long id);

    @GetMapping("/{recipeId}")
    ResponseEntity findAllByRecRecipe_Id(@PathVariable Long recipeId);
}
