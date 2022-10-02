package com.projectteam3.recipeproject.app.usr.mapper;

import com.projectteam3.recipeproject.app.usr.dto.UsrUserDto;
import com.projectteam3.recipeproject.app.usr.dto.UsrUserSaveRequestDto;
import com.projectteam3.recipeproject.app.usr.dto.UsrUserUpdateRequestDto;
import com.projectteam3.recipeproject.app.usr.entity.UsrUser;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UsrUserMapper {
    UsrUserMapper INSTANCE = Mappers.getMapper(UsrUserMapper.class);

    UsrUser convertToUsrUser(UsrUserSaveRequestDto usrUserSaveRequestDto);
    UsrUser convertToUsrUser(UsrUserUpdateRequestDto usrUserUpdateRequestDto);
    UsrUserDto convertToUsrUserDto(UsrUser usrUser);
    List<UsrUserDto> convertToUsrUserDtoList(List<UsrUser> usrUserList);
}
