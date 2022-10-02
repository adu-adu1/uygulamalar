package com.projectteam3.recipeproject.app.rec.controller;

import com.projectteam3.recipeproject.app.rec.dto.RecRecipeImageSaveRequestDto;
import com.projectteam3.recipeproject.app.rec.dto.RecRecipeImageUpdateRequestDto;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/api/v1/recipe-images")
public interface RecRecipeImageOperations {


    @PostMapping
    ResponseEntity save(@Validated @RequestBody RecRecipeImageSaveRequestDto recRecipeImageSaveRequestDto);

    @PutMapping
    ResponseEntity update(@Validated @RequestBody RecRecipeImageUpdateRequestDto recRecipeImageUpdateRequestDto);

    @DeleteMapping("/{id}")
    ResponseEntity delete(@PathVariable Long id);

    @GetMapping("/{recipeId}")
    ResponseEntity findAllByRecRecipe_Id(@PathVariable Long recipeId);
}
