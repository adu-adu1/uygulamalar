package com.projectteam3.recipeproject.app.sec.controller;

import com.projectteam3.recipeproject.app.gen.dto.BaseResponseDto;
import com.projectteam3.recipeproject.app.sec.dto.SecLoginRequestDto;
import com.projectteam3.recipeproject.app.sec.service.AuthenticationService;
import com.projectteam3.recipeproject.app.usr.dto.UsrUserSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthenticationController implements AuthenticationOperations {
    private final AuthenticationService authenticationService;

    @Override
    public ResponseEntity login(SecLoginRequestDto secLoginRequestDto) {
        BaseResponseDto baseResponseDto = authenticationService.login(secLoginRequestDto);
        return ResponseEntity.ok(baseResponseDto);
    }

    @Override
    public ResponseEntity register(UsrUserSaveRequestDto usrUserSaveRequestDto) {
        BaseResponseDto baseResponseDto = authenticationService.register(usrUserSaveRequestDto);
        return ResponseEntity.ok(baseResponseDto);
    }
}
