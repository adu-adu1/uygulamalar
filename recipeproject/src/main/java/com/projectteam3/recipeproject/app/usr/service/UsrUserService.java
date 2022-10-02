package com.projectteam3.recipeproject.app.usr.service;

import com.projectteam3.recipeproject.app.gen.dto.BaseResponseDto;
import com.projectteam3.recipeproject.app.gen.dto.ResponseInfo;
import com.projectteam3.recipeproject.app.gen.enums.ExceptionMessage;
import com.projectteam3.recipeproject.app.gen.enums.ResponseMessage;
import com.projectteam3.recipeproject.app.gen.exception.ResourceNotFoundException;
import com.projectteam3.recipeproject.app.gen.exception.ResourceUsedException;
import com.projectteam3.recipeproject.app.usr.dao.UsrUserDao;
import com.projectteam3.recipeproject.app.usr.dto.UsrUserDto;
import com.projectteam3.recipeproject.app.usr.dto.UsrUserSaveRequestDto;
import com.projectteam3.recipeproject.app.usr.dto.UsrUserUpdateRequestDto;
import com.projectteam3.recipeproject.app.usr.entity.UsrUser;
import com.projectteam3.recipeproject.app.usr.mapper.UsrUserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsrUserService {

    private final UsrUserDao usrUserDao;
    private final PasswordEncoder passwordEncoder;

    public BaseResponseDto save(UsrUserSaveRequestDto usrUserSaveRequestDto) {
        controlUserNotExists(usrUserSaveRequestDto.getUsername());

        UsrUser usrUser = UsrUserMapper.INSTANCE.convertToUsrUser(usrUserSaveRequestDto);
        String password = passwordEncoder.encode(usrUser.getPassword());
        usrUser.setPassword(password);

        usrUser = usrUserDao.save(usrUser);
        UsrUserDto usrUserDto = UsrUserMapper.INSTANCE.convertToUsrUserDto(usrUser);

        BaseResponseDto baseResponseDto = new BaseResponseDto(ResponseInfo.success(HttpStatus.CREATED.value(), ResponseMessage.SUCCESSFUL.getMessage()), usrUserDto);
        return baseResponseDto;
    }

    public BaseResponseDto update(UsrUserUpdateRequestDto usrUserUpdateRequestDto) {
        Long id = usrUserUpdateRequestDto.getId();
        boolean exists = usrUserDao.existsById(id);
        if (!exists)
            throw new ResourceNotFoundException(ExceptionMessage.RESOURCE_NOT_FOUND.getMessage());


        controlUserNotExists(usrUserUpdateRequestDto.getUsername());

        UsrUser usrUser = UsrUserMapper.INSTANCE.convertToUsrUser(usrUserUpdateRequestDto);
        String password = passwordEncoder.encode(usrUser.getPassword());
        usrUser.setPassword(password);

        usrUser = usrUserDao.save(usrUser);
        UsrUserDto usrUserDto = UsrUserMapper.INSTANCE.convertToUsrUserDto(usrUser);
        BaseResponseDto baseResponseDto = new BaseResponseDto(ResponseInfo.success(ResponseMessage.SUCCESSFUL.getMessage()), usrUserDto);
        return baseResponseDto;
    }

    public BaseResponseDto delete(Long id) {
        usrUserDao.deleteById(id);
        BaseResponseDto baseResponseDto = new BaseResponseDto(ResponseInfo.success(ResponseMessage.SUCCESSFUL.getMessage()), null);
        return baseResponseDto;
    }

    public BaseResponseDto findAll() {
        List<UsrUser> usrUserList = usrUserDao.findAll();
        List<UsrUserDto> usrUserDtoList = UsrUserMapper.INSTANCE.convertToUsrUserDtoList(usrUserList);
        BaseResponseDto baseResponseDto = new BaseResponseDto(ResponseInfo.success(ResponseMessage.SUCCESSFUL.getMessage()), usrUserDtoList);
        return baseResponseDto;
    }

    public BaseResponseDto findById(Long id) {
        UsrUser usrUser = findByIdWithControl(id);
        UsrUserDto usrUserDto = UsrUserMapper.INSTANCE.convertToUsrUserDto(usrUser);
        BaseResponseDto baseResponseDto = new BaseResponseDto(ResponseInfo.success(ResponseMessage.SUCCESSFUL.getMessage()), usrUserDto);
        return baseResponseDto;
    }

    public BaseResponseDto findByUsername(String username) {
        UsrUser usrUser = usrUserDao.findByUsername(username);
        if (usrUser == null)
            throw new ResourceNotFoundException(ExceptionMessage.RESOURCE_NOT_FOUND.getMessage());

        UsrUserDto usrUserDto = UsrUserMapper.INSTANCE.convertToUsrUserDto(usrUser);
        BaseResponseDto baseResponseDto = new BaseResponseDto(ResponseInfo.success(ResponseMessage.SUCCESSFUL.getMessage()), usrUserDto);
        return baseResponseDto;
    }

    public UsrUser findByIdWithControl(Long id) {
        Optional<UsrUser> optionalUsrUser = usrUserDao.findById(id);

        UsrUser usrUser;
        if (optionalUsrUser.isPresent())
            usrUser = optionalUsrUser.get();
        else
            throw new ResourceNotFoundException(ExceptionMessage.RESOURCE_NOT_FOUND.getMessage());

        return usrUser;
    }

    private void controlUserNotExists(String username) {
        UsrUser usrUser = usrUserDao.findByUsername(username);
        if (usrUser != null)
            throw new ResourceUsedException(ExceptionMessage.RESOURCE_USED.getMessage());
    }
}
