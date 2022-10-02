package com.projectteam3.recipeproject.app.crd.controller;

import com.projectteam3.recipeproject.app.crd.dto.CrdCreditCardSaveRequestDto;
import com.projectteam3.recipeproject.app.crd.dto.CrdCreditCardUpdateRequestDto;
import com.projectteam3.recipeproject.app.crd.service.CrdCreditCardService;
import com.projectteam3.recipeproject.app.gen.dto.BaseResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
public class CrdCreditCardController implements CrdCreditCardOperations{
    private final CrdCreditCardService crdCreditCardService;


    @Override
    public ResponseEntity save(Long userId, CrdCreditCardSaveRequestDto crdCreditCardSaveRequestDto) {
        BaseResponseDto baseResponseDto = crdCreditCardService.save(userId, crdCreditCardSaveRequestDto);
        return ResponseEntity.ok(baseResponseDto);
    }

    @Override
    public ResponseEntity update(Long userId, Long cardId, CrdCreditCardUpdateRequestDto crdCreditCardUpdateRequestDto) {
        BaseResponseDto baseResponseDto = crdCreditCardService.update(userId, cardId, crdCreditCardUpdateRequestDto);
        return ResponseEntity.ok(baseResponseDto);
    }

    @Override
    public ResponseEntity delete(Long id) {
        BaseResponseDto baseResponseDto = crdCreditCardService.delete(id);
        return ResponseEntity.ok(baseResponseDto);
    }

    @Override
    public ResponseEntity findAllByUsrUser_Id(Long userId) {
        BaseResponseDto baseResponseDto = crdCreditCardService.findAllByUsrUser_Id(userId);
        return ResponseEntity.ok(baseResponseDto);
    }
}
