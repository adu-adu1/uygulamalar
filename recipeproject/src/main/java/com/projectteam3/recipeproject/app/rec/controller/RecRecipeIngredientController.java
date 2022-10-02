package com.projectteam3.recipeproject.app.rec.controller;

import com.projectteam3.recipeproject.app.gen.dto.BaseResponseDto;
import com.projectteam3.recipeproject.app.rec.dto.RecRecipeIngredientSaveRequestDto;
import com.projectteam3.recipeproject.app.rec.dto.RecRecipeIngredientUpdateRequestDto;
import com.projectteam3.recipeproject.app.rec.service.RecRecipeIngredientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
public class RecRecipeIngredientController implements RecRecipeIngredientOperations{

    private final RecRecipeIngredientService recRecipeIngredientService;


    @Override
    public ResponseEntity save(RecRecipeIngredientSaveRequestDto recRecipeIngredientSaveRequestDto) {
        BaseResponseDto baseResponseDto = recRecipeIngredientService.save(recRecipeIngredientSaveRequestDto);
        return ResponseEntity.ok(baseResponseDto);
    }

    @Override
    public ResponseEntity update(RecRecipeIngredientUpdateRequestDto recRecipeIngredientUpdateRequestDto) {
        BaseResponseDto baseResponseDto = recRecipeIngredientService.update(recRecipeIngredientUpdateRequestDto);
        return ResponseEntity.ok(baseResponseDto);
    }

    @Override
    public ResponseEntity delete(Long id) {
        BaseResponseDto baseResponseDto = recRecipeIngredientService.delete(id);
        return ResponseEntity.ok(baseResponseDto);
    }

    @Override
    public ResponseEntity findAllByRecRecipe_Id(Long recipeId) {
        BaseResponseDto baseResponseDto = recRecipeIngredientService.findAllByRecRecipe_Id(recipeId);
        return ResponseEntity.ok(baseResponseDto);
    }
}
