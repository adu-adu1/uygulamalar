package com.projectteam3.recipeproject.app.sec.service;

import com.projectteam3.recipeproject.app.gen.dto.BaseResponseDto;
import com.projectteam3.recipeproject.app.gen.dto.ResponseInfo;
import com.projectteam3.recipeproject.app.sec.dto.SecLoginRequestDto;
import com.projectteam3.recipeproject.app.sec.security.JwtTokenGenerator;
import com.projectteam3.recipeproject.app.sec.security.JwtUserDetails;
import com.projectteam3.recipeproject.app.usr.dto.UsrUserSaveRequestDto;
import com.projectteam3.recipeproject.app.usr.entity.UsrUser;
import com.projectteam3.recipeproject.app.usr.service.UsrUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UsrUserService usrUserService;
    private final AuthenticationManager authenticationManager;
    private final JwtTokenGenerator jwtTokenGenerator;

    public BaseResponseDto register(UsrUserSaveRequestDto usrUserSaveRequestDto) {
        BaseResponseDto baseResponseDto = usrUserService.save(usrUserSaveRequestDto);
        return baseResponseDto;
    }

    public BaseResponseDto login(SecLoginRequestDto secLoginRequestDto) {
        String username = secLoginRequestDto.getUsername();
        String password = secLoginRequestDto.getPassword();
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, password);

        Authentication authentication = authenticationManager.authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String bearer = "Bearer ";
        String token = jwtTokenGenerator.generateJwtToken(authentication);
        String fullToken = bearer + token;

        BaseResponseDto baseResponseDto = new BaseResponseDto(ResponseInfo.success(fullToken), ResponseInfo.success(fullToken));
        return baseResponseDto;
    }

    public UsrUser getCurrentUser() {
        JwtUserDetails jwtUserDetails = getCurrentJwtUserDetails();
        UsrUser usrUser = null;
        if (jwtUserDetails != null) {
            usrUser = usrUserService.findByIdWithControl(jwtUserDetails.getId());
        }
        return usrUser;
    }

    private JwtUserDetails getCurrentJwtUserDetails() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        JwtUserDetails jwtUserDetails = null;
        if (authentication != null && authentication.getPrincipal() instanceof JwtUserDetails){
            jwtUserDetails = (JwtUserDetails) authentication.getPrincipal();
        }
        return jwtUserDetails;
    }
}
