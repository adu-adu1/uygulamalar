package com.projectteam3.recipeproject.app.crd.controller;

import com.projectteam3.recipeproject.app.crd.dto.CrdCreditCardSaveRequestDto;
import com.projectteam3.recipeproject.app.crd.dto.CrdCreditCardUpdateRequestDto;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/api/v1/credit-cards")
public interface CrdCreditCardOperations {

    @PostMapping("/user/{userId}")
    ResponseEntity save(@PathVariable Long userId, @Validated @RequestBody CrdCreditCardSaveRequestDto crdCreditCardSaveRequestDto);

    @PutMapping("user/{userId}/card/{cardId}")
    ResponseEntity update(
            @PathVariable(name = "userId") Long userId,
            @PathVariable(name = "cardId") Long cardId,
            @Validated @RequestBody CrdCreditCardUpdateRequestDto crdCreditCardUpdateRequestDto
    );

    @DeleteMapping("/{id}")
    ResponseEntity delete(@PathVariable Long id);

    @GetMapping("/{userId}")
    ResponseEntity findAllByUsrUser_Id(@PathVariable Long userId);
}
