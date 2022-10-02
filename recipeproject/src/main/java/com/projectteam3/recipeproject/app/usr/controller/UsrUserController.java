package com.projectteam3.recipeproject.app.usr.controller;

import com.projectteam3.recipeproject.app.gen.dto.BaseResponseDto;
import com.projectteam3.recipeproject.app.usr.dto.UsrUserSaveRequestDto;
import com.projectteam3.recipeproject.app.usr.dto.UsrUserUpdateRequestDto;
import com.projectteam3.recipeproject.app.usr.service.UsrUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
public class UsrUserController implements UsrUserOperations{

    private final UsrUserService usrUserService;


    @Override
    public ResponseEntity save(UsrUserSaveRequestDto usrUserSaveRequestDto) {
        BaseResponseDto baseResponseDto = usrUserService.save(usrUserSaveRequestDto);
        return ResponseEntity.ok(baseResponseDto);
    }

    @Override
    public ResponseEntity update(UsrUserUpdateRequestDto usrUserUpdateRequestDto) {
        BaseResponseDto baseResponseDto = usrUserService.update(usrUserUpdateRequestDto);
        return ResponseEntity.ok(baseResponseDto);
    }

    @Override
    public ResponseEntity delete(Long id) {
        BaseResponseDto baseResponseDto = usrUserService.delete(id);
        return ResponseEntity.ok(baseResponseDto);
    }

    @Override
    public ResponseEntity findAll() {
        BaseResponseDto baseResponseDto = usrUserService.findAll();
        return ResponseEntity.ok(baseResponseDto);
    }

    @Override
    public ResponseEntity findById(Long id) {
        BaseResponseDto baseResponseDto = usrUserService.findById(id);
        return ResponseEntity.ok(baseResponseDto);
    }

    @Override
    public ResponseEntity findByUsername(String username) {
        BaseResponseDto baseResponseDto = usrUserService.findByUsername(username);
        return ResponseEntity.ok(baseResponseDto);
    }
}
