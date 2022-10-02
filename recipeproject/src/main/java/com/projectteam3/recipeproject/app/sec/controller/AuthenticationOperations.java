package com.projectteam3.recipeproject.app.sec.controller;

import com.projectteam3.recipeproject.app.sec.dto.SecLoginRequestDto;
import com.projectteam3.recipeproject.app.usr.dto.UsrUserSaveRequestDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/auth")
public interface AuthenticationOperations {

    @PostMapping("/login")
    ResponseEntity login(@RequestBody SecLoginRequestDto secLoginRequestDto);

    @PostMapping("/register")
    ResponseEntity register(@RequestBody UsrUserSaveRequestDto usrUserSaveRequestDto);
}
