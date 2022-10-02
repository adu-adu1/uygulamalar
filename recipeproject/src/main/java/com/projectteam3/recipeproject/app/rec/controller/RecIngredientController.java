package com.projectteam3.recipeproject.app.rec.controller;

import com.projectteam3.recipeproject.app.gen.dto.BaseResponseDto;
import com.projectteam3.recipeproject.app.rec.dto.RecIngredientSaveRequestDto;
import com.projectteam3.recipeproject.app.rec.dto.RecIngredientUpdateRequestDto;
import com.projectteam3.recipeproject.app.rec.service.RecIngredientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class RecIngredientController implements RecIngredientOperations{
    private final RecIngredientService recIngredientService;


    @Override
    public ResponseEntity save(RecIngredientSaveRequestDto recIngredientSaveRequestDto) {
        BaseResponseDto baseResponseDto = recIngredientService.save(recIngredientSaveRequestDto);
        return ResponseEntity.ok(baseResponseDto);
    }

    @Override
    public ResponseEntity update(RecIngredientUpdateRequestDto recIngredientUpdateRequestDto) {
        BaseResponseDto baseResponseDto = recIngredientService.update(recIngredientUpdateRequestDto);
        return ResponseEntity.ok(baseResponseDto);
    }

    @Override
    public ResponseEntity delete(Long id) {
        BaseResponseDto baseResponseDto = recIngredientService.delete(id);
        return ResponseEntity.ok(baseResponseDto);
    }

    @Override
    public ResponseEntity findByName(String name) {
        BaseResponseDto baseResponseDto = recIngredientService.findByName(name);
        return ResponseEntity.ok(baseResponseDto);
    }
}
