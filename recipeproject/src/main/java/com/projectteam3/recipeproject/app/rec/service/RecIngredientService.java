package com.projectteam3.recipeproject.app.rec.service;

import com.projectteam3.recipeproject.app.gen.dto.BaseResponseDto;
import com.projectteam3.recipeproject.app.gen.dto.ResponseInfo;
import com.projectteam3.recipeproject.app.gen.enums.ExceptionMessage;
import com.projectteam3.recipeproject.app.gen.enums.ResponseMessage;
import com.projectteam3.recipeproject.app.gen.exception.ResourceNotFoundException;
import com.projectteam3.recipeproject.app.gen.exception.ResourceUsedException;
import com.projectteam3.recipeproject.app.rec.dao.RecIngredientDao;
import com.projectteam3.recipeproject.app.rec.dto.RecIngredientDto;
import com.projectteam3.recipeproject.app.rec.dto.RecIngredientSaveRequestDto;
import com.projectteam3.recipeproject.app.rec.dto.RecIngredientUpdateRequestDto;
import com.projectteam3.recipeproject.app.rec.entity.RecIngredient;
import com.projectteam3.recipeproject.app.rec.mapper.RecIngredientMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RecIngredientService {
    private final RecIngredientDao recIngredientDao;

    public BaseResponseDto save(RecIngredientSaveRequestDto recIngredientSaveRequestDto) {
        controlIngredientNotExists(recIngredientSaveRequestDto.getName());

        RecIngredient recIngredient = RecIngredientMapper.INSTANCE.convertToRecIngredient(recIngredientSaveRequestDto);
        recIngredient = recIngredientDao.save(recIngredient);
        RecIngredientDto recIngredientDto = RecIngredientMapper.INSTANCE.convertToRecIngredientDto(recIngredient);


        BaseResponseDto baseResponseDto = new BaseResponseDto(ResponseInfo.success(HttpStatus.CREATED.value(), ResponseMessage.SUCCESSFUL.getMessage()), recIngredientDto);
        return baseResponseDto;
    }

    public BaseResponseDto update(RecIngredientUpdateRequestDto recIngredientUpdateRequestDto) {
        Long id = recIngredientUpdateRequestDto.getId();
        boolean exists = recIngredientDao.existsById(id);
        if (!exists)
            throw new ResourceNotFoundException(ExceptionMessage.RESOURCE_NOT_FOUND.getMessage());

        controlIngredientNotExists(recIngredientUpdateRequestDto.getName());

        RecIngredient recIngredient = RecIngredientMapper.INSTANCE.convertToRecIngredient(recIngredientUpdateRequestDto);
        recIngredient = recIngredientDao.save(recIngredient);

        RecIngredientDto recIngredientDto = RecIngredientMapper.INSTANCE.convertToRecIngredientDto(recIngredient);

        BaseResponseDto baseResponseDto = new BaseResponseDto(ResponseInfo.success(ResponseMessage.SUCCESSFUL.getMessage()), recIngredientDto);
        return baseResponseDto;
    }

    public BaseResponseDto delete(Long id) {
        recIngredientDao.deleteById(id);
        BaseResponseDto baseResponseDto = new BaseResponseDto(ResponseInfo.success(ResponseMessage.SUCCESSFUL.getMessage()), null);
        return baseResponseDto;
    }

    public BaseResponseDto findByName(String name) {
        RecIngredient recIngredient = recIngredientDao.findByName(name);
        if (recIngredient == null) {
            throw new ResourceNotFoundException(ExceptionMessage.RESOURCE_NOT_FOUND.getMessage());
        }

        RecIngredientDto recIngredientDto = RecIngredientMapper.INSTANCE.convertToRecIngredientDto(recIngredient);

        BaseResponseDto baseResponseDto = new BaseResponseDto(ResponseInfo.success(ResponseMessage.SUCCESSFUL.getMessage()), recIngredientDto);
        return baseResponseDto;
    }

    public RecIngredient findByIdWithControl(Long id) {
        Optional<RecIngredient> optionalRecIngredient = recIngredientDao.findById(id);

        RecIngredient recIngredient;
        if (optionalRecIngredient.isPresent())
            recIngredient = optionalRecIngredient.get();
        else
            throw new ResourceNotFoundException(ExceptionMessage.RESOURCE_NOT_FOUND.getMessage());

        return recIngredient;
    }

    private void controlIngredientNotExists(String name) {
        RecIngredient recIngredient = recIngredientDao.findByName(name);
        if (recIngredient != null)
            throw new ResourceUsedException(ExceptionMessage.RESOURCE_USED.getMessage());
    }
}
