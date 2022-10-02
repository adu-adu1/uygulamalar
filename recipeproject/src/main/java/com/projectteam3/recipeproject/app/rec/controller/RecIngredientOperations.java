package com.projectteam3.recipeproject.app.rec.controller;

import com.projectteam3.recipeproject.app.rec.dto.RecIngredientSaveRequestDto;
import com.projectteam3.recipeproject.app.rec.dto.RecIngredientUpdateRequestDto;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1/ingredients")
public interface RecIngredientOperations {

    @PostMapping
    ResponseEntity save(@Validated @RequestBody RecIngredientSaveRequestDto recIngredientSaveRequestDto);

    @PutMapping
    ResponseEntity update(@Validated @RequestBody RecIngredientUpdateRequestDto recIngredientUpdateRequestDto);

    @DeleteMapping("/{id}")
    ResponseEntity delete(@PathVariable Long id);

    @GetMapping("/{name}")
    ResponseEntity findByName(@PathVariable String name);
}
