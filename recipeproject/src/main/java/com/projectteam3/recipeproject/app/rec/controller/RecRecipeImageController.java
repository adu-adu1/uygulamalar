package com.projectteam3.recipeproject.app.rec.controller;

import com.projectteam3.recipeproject.app.gen.dto.BaseResponseDto;
import com.projectteam3.recipeproject.app.rec.dto.RecRecipeImageSaveRequestDto;
import com.projectteam3.recipeproject.app.rec.dto.RecRecipeImageUpdateRequestDto;
import com.projectteam3.recipeproject.app.rec.service.RecRecipeImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
public class RecRecipeImageController implements RecRecipeImageOperations{

    private final RecRecipeImageService recRecipeImageService;

    @Override
    public ResponseEntity save(RecRecipeImageSaveRequestDto recRecipeImageSaveRequestDto) {
        BaseResponseDto baseResponseDto = recRecipeImageService.save(recRecipeImageSaveRequestDto);
        return ResponseEntity.ok(baseResponseDto);
    }

    @Override
    public ResponseEntity update(RecRecipeImageUpdateRequestDto recRecipeImageUpdateRequestDto) {
        BaseResponseDto baseResponseDto = recRecipeImageService.update(recRecipeImageUpdateRequestDto);
        return ResponseEntity.ok(baseResponseDto);
    }

    @Override
    public ResponseEntity delete(Long id) {
        BaseResponseDto baseResponseDto = recRecipeImageService.delete(id);
        return ResponseEntity.ok(baseResponseDto);
    }

    @Override
    public ResponseEntity findAllByRecRecipe_Id(Long recipeId) {
        BaseResponseDto baseResponseDto = recRecipeImageService.findAllByRecRecipe_Id(recipeId);
        return ResponseEntity.ok(baseResponseDto);
    }
}
