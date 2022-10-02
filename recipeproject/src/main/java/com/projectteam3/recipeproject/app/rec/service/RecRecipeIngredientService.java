package com.projectteam3.recipeproject.app.rec.service;

import com.projectteam3.recipeproject.app.gen.dto.BaseResponseDto;
import com.projectteam3.recipeproject.app.gen.dto.ResponseInfo;
import com.projectteam3.recipeproject.app.gen.enums.ExceptionMessage;
import com.projectteam3.recipeproject.app.gen.enums.ResponseMessage;
import com.projectteam3.recipeproject.app.gen.exception.ResourceNotFoundException;
import com.projectteam3.recipeproject.app.rec.dao.RecRecipeIngredientDao;
import com.projectteam3.recipeproject.app.rec.dto.RecRecipeIngredientDto;
import com.projectteam3.recipeproject.app.rec.dto.RecRecipeIngredientSaveRequestDto;
import com.projectteam3.recipeproject.app.rec.dto.RecRecipeIngredientUpdateRequestDto;
import com.projectteam3.recipeproject.app.rec.entity.RecIngredient;
import com.projectteam3.recipeproject.app.rec.entity.RecRecipe;
import com.projectteam3.recipeproject.app.rec.entity.RecRecipeIngredient;
import com.projectteam3.recipeproject.app.rec.mapper.RecRecipeIngredientMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RecRecipeIngredientService {

    private final RecRecipeIngredientDao recRecipeIngredientDao;
    private final RecRecipeService recRecipeService;
    private final RecIngredientService recIngredientService;

    public BaseResponseDto save(RecRecipeIngredientSaveRequestDto recRecipeIngredientSaveRequestDto) {
        Long recipeId = recRecipeIngredientSaveRequestDto.getRecipeId();
        Long ingredientId = recRecipeIngredientSaveRequestDto.getIngredientId();

        RecRecipe recRecipe = recRecipeService.findByIdWithControl(recipeId);
        RecIngredient recIngredient = recIngredientService.findByIdWithControl(ingredientId);

        RecRecipeIngredient recRecipeIngredient = RecRecipeIngredientMapper.INSTANCE.convertToRecRecipeIngredient(recRecipeIngredientSaveRequestDto);
        recRecipeIngredient.setRecRecipe(recRecipe);
        recRecipeIngredient.setRecIngredient(recIngredient);

        recRecipeIngredient = recRecipeIngredientDao.save(recRecipeIngredient);

        RecRecipeIngredientDto recRecipeIngredientDto = RecRecipeIngredientMapper.INSTANCE.convertToRecRecipeIngredientDto(recRecipeIngredient);

        BaseResponseDto baseResponseDto = new BaseResponseDto(ResponseInfo.success(HttpStatus.CREATED.value(), ResponseMessage.SUCCESSFUL.getMessage()), recRecipeIngredientDto);
        return baseResponseDto;

    }

    public BaseResponseDto update(RecRecipeIngredientUpdateRequestDto recRecipeIngredientUpdateRequestDto) {
        Long id = recRecipeIngredientUpdateRequestDto.getId();
        Long recipeId = recRecipeIngredientUpdateRequestDto.getRecipeId();
        Long ingredientId = recRecipeIngredientUpdateRequestDto.getIngredientId();

        boolean exists = recRecipeIngredientDao.existsById(id);
        if (!exists)
            throw new ResourceNotFoundException(ExceptionMessage.RESOURCE_NOT_FOUND.getMessage());

        RecRecipe recRecipe = recRecipeService.findByIdWithControl(recipeId);
        RecIngredient recIngredient = recIngredientService.findByIdWithControl(ingredientId);

        RecRecipeIngredient recRecipeIngredient = RecRecipeIngredientMapper.INSTANCE.convertToRecRecipeIngredient(recRecipeIngredientUpdateRequestDto);
        recRecipeIngredient.setRecRecipe(recRecipe);
        recRecipeIngredient.setRecIngredient(recIngredient);
        recRecipeIngredient = recRecipeIngredientDao.save(recRecipeIngredient);

        RecRecipeIngredientDto recRecipeIngredientDto = RecRecipeIngredientMapper.INSTANCE.convertToRecRecipeIngredientDto(recRecipeIngredient);

        BaseResponseDto baseResponseDto = new BaseResponseDto(ResponseInfo.success(ResponseMessage.SUCCESSFUL.getMessage()), recRecipeIngredientDto);
        return baseResponseDto;
    }

    public BaseResponseDto delete(Long id) {
        recRecipeIngredientDao.deleteById(id);
        BaseResponseDto baseResponseDto = new BaseResponseDto(ResponseInfo.success(ResponseMessage.SUCCESSFUL.getMessage()), null);
        return baseResponseDto;
    }

    public BaseResponseDto findAllByRecRecipe_Id(Long recipeId) {
        List<RecRecipeIngredient> recRecipeIngredientList = recRecipeIngredientDao.findAllByRecRecipe_Id(recipeId);
        List<RecRecipeIngredientDto> recRecipeIngredientDtoList = RecRecipeIngredientMapper.INSTANCE.convertToRecRecipeIngredientDtoList(recRecipeIngredientList);

        BaseResponseDto baseResponseDto = new BaseResponseDto(ResponseInfo.success(ResponseMessage.SUCCESSFUL.getMessage()), recRecipeIngredientDtoList);
        return baseResponseDto;
    }
}
