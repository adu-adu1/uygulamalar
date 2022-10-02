package com.projectteam3.recipeproject.app.rec.service;

import com.projectteam3.recipeproject.app.gen.dto.BaseResponseDto;
import com.projectteam3.recipeproject.app.gen.dto.ResponseInfo;
import com.projectteam3.recipeproject.app.gen.enums.ExceptionMessage;
import com.projectteam3.recipeproject.app.gen.enums.ResponseMessage;
import com.projectteam3.recipeproject.app.gen.exception.ResourceNotFoundException;
import com.projectteam3.recipeproject.app.rec.dao.RecRecipeDao;
import com.projectteam3.recipeproject.app.rec.dto.RecRecipeDto;
import com.projectteam3.recipeproject.app.rec.dto.RecRecipeSaveRequestDto;
import com.projectteam3.recipeproject.app.rec.dto.RecRecipeUpdateRequestDto;
import com.projectteam3.recipeproject.app.rec.entity.RecRecipe;
import com.projectteam3.recipeproject.app.rec.mapper.RecRecipeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RecRecipeService {

    private final RecRecipeDao recRecipeDao;

    public BaseResponseDto save(RecRecipeSaveRequestDto recRecipeSaveRequestDto) {
        RecRecipe recRecipe = RecRecipeMapper.INSTANCE.convertToRecRecipe(recRecipeSaveRequestDto);
        recRecipe = recRecipeDao.save(recRecipe);
        RecRecipeDto recRecipeDto = RecRecipeMapper.INSTANCE.convertToRecRecipeDto(recRecipe);

        BaseResponseDto baseResponseDto = new BaseResponseDto(ResponseInfo.success(HttpStatus.CREATED.value(), ResponseMessage.SUCCESSFUL.getMessage()), recRecipeDto);
        return baseResponseDto;
    }

    public BaseResponseDto update(RecRecipeUpdateRequestDto recRecipeUpdateRequestDto) {
        boolean exists = recRecipeDao.existsById(recRecipeUpdateRequestDto.getId());
        if (!exists)
            throw new ResourceNotFoundException(ExceptionMessage.RESOURCE_NOT_FOUND.getMessage());

        RecRecipe recRecipe = RecRecipeMapper.INSTANCE.convertToRecRecipe(recRecipeUpdateRequestDto);
        recRecipe = recRecipeDao.save(recRecipe);
        RecRecipeDto recRecipeDto = RecRecipeMapper.INSTANCE.convertToRecRecipeDto(recRecipe);

        BaseResponseDto baseResponseDto = new BaseResponseDto(ResponseInfo.success(ResponseMessage.SUCCESSFUL.getMessage()), recRecipeDto);
        return baseResponseDto;
    }

    public BaseResponseDto delete(Long id) {
        recRecipeDao.deleteById(id);
        BaseResponseDto baseResponseDto = new BaseResponseDto(ResponseInfo.success(ResponseMessage.SUCCESSFUL.getMessage()), null);
        return baseResponseDto;
    }

    public BaseResponseDto findAll() {
        List<RecRecipe> recRecipeList = recRecipeDao.findAll();
        List<RecRecipeDto> recRecipeDtoList = RecRecipeMapper.INSTANCE.convertToRecRecipeDtoList(recRecipeList);
        BaseResponseDto baseResponseDto = new BaseResponseDto(ResponseInfo.success(ResponseMessage.SUCCESSFUL.getMessage()), recRecipeDtoList);
        return baseResponseDto;
    }

    public BaseResponseDto findById(Long id) {
        RecRecipe recRecipe = findByIdWithControl(id);
        RecRecipeDto recRecipeDto = RecRecipeMapper.INSTANCE.convertToRecRecipeDto(recRecipe);

        BaseResponseDto baseResponseDto = new BaseResponseDto(ResponseInfo.success(ResponseMessage.SUCCESSFUL.getMessage()), recRecipeDto);
        return baseResponseDto;
    }

    public RecRecipe findByIdWithControl(Long id) {
        Optional<RecRecipe> optionalRecRecipe = recRecipeDao.findById(id);

        RecRecipe recRecipe;
        if (optionalRecRecipe.isPresent())
            recRecipe = optionalRecRecipe.get();
        else
            throw new ResourceNotFoundException(ExceptionMessage.RESOURCE_NOT_FOUND.getMessage());

        return recRecipe;
    }
}
