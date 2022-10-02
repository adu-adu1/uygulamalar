package com.projectteam3.recipeproject.app.rec.controller;

import com.projectteam3.recipeproject.app.rec.dto.RecRecipeSaveRequestDto;
import com.projectteam3.recipeproject.app.rec.dto.RecRecipeUpdateRequestDto;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1/recipes")
public interface RecRecipeOperations {


    @PostMapping
    ResponseEntity save(@Validated @RequestBody RecRecipeSaveRequestDto recRecipeSaveRequestDto);

    @PutMapping
    ResponseEntity update(@Validated @RequestBody RecRecipeUpdateRequestDto recRecipeUpdateRequestDto);

    @DeleteMapping("/{id}")
    ResponseEntity delete(@PathVariable Long id);

    @GetMapping
    ResponseEntity findAll();

    @GetMapping("/{id}")
    ResponseEntity findById(@PathVariable Long id);
}
