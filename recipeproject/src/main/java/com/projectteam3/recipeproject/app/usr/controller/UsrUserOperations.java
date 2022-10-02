package com.projectteam3.recipeproject.app.usr.controller;

import com.projectteam3.recipeproject.app.usr.dto.UsrUserSaveRequestDto;
import com.projectteam3.recipeproject.app.usr.dto.UsrUserUpdateRequestDto;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1/users")
public interface UsrUserOperations {

    @PostMapping
    ResponseEntity save(@Validated @RequestBody UsrUserSaveRequestDto usrUserSaveRequestDto);

    @PutMapping
    ResponseEntity update(@Validated @RequestBody UsrUserUpdateRequestDto usrUserUpdateRequestDto);

    @DeleteMapping("/{id}")
    ResponseEntity delete(@PathVariable Long id);

    @GetMapping
    ResponseEntity findAll();

    @GetMapping("/{id}")
    ResponseEntity findById(@PathVariable Long id);

    @GetMapping("/username/{username}")
    ResponseEntity findByUsername(@PathVariable String username);
}
