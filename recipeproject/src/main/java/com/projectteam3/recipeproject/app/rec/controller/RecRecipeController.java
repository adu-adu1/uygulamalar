package com.projectteam3.recipeproject.app.rec.controller;

import com.projectteam3.recipeproject.app.gen.dto.BaseResponseDto;
import com.projectteam3.recipeproject.app.rec.dto.RecRecipeSaveRequestDto;
import com.projectteam3.recipeproject.app.rec.dto.RecRecipeUpdateRequestDto;
import com.projectteam3.recipeproject.app.rec.service.RecRecipeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class RecRecipeController implements RecRecipeOperations {

    private final RecRecipeService recRecipeService;

    @Override
    public ResponseEntity save(RecRecipeSaveRequestDto recRecipeSaveRequestDto) {
        BaseResponseDto baseResponseDto = recRecipeService.save(recRecipeSaveRequestDto);
        return ResponseEntity.ok(baseResponseDto);
    }

    @Override
    public ResponseEntity update(RecRecipeUpdateRequestDto recRecipeUpdateRequestDto) {
        BaseResponseDto baseResponseDto = recRecipeService.update(recRecipeUpdateRequestDto);
        return ResponseEntity.ok(baseResponseDto);
    }

    @Override
    public ResponseEntity delete(Long id) {
        BaseResponseDto baseResponseDto = recRecipeService.delete(id);
        return ResponseEntity.ok(baseResponseDto);
    }

    @Override
    public ResponseEntity findAll() {
        BaseResponseDto baseResponseDto = recRecipeService.findAll();
        return ResponseEntity.ok(baseResponseDto);
    }

    @Override
    public ResponseEntity findById(Long id) {
        BaseResponseDto baseResponseDto = recRecipeService.findById(id);
        return ResponseEntity.ok(baseResponseDto);
    }
}
