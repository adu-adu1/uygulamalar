package com.projectteam3.recipeproject.app.rec.service;

import com.projectteam3.recipeproject.app.gen.dto.BaseResponseDto;
import com.projectteam3.recipeproject.app.gen.dto.ResponseInfo;
import com.projectteam3.recipeproject.app.gen.enums.ExceptionMessage;
import com.projectteam3.recipeproject.app.gen.enums.ResponseMessage;
import com.projectteam3.recipeproject.app.gen.exception.ResourceNotFoundException;
import com.projectteam3.recipeproject.app.rec.dao.RecRecipeImageDao;
import com.projectteam3.recipeproject.app.rec.dto.RecRecipeImageDto;
import com.projectteam3.recipeproject.app.rec.dto.RecRecipeImageSaveRequestDto;
import com.projectteam3.recipeproject.app.rec.dto.RecRecipeImageUpdateRequestDto;
import com.projectteam3.recipeproject.app.rec.entity.RecRecipe;
import com.projectteam3.recipeproject.app.rec.entity.RecRecipeImage;
import com.projectteam3.recipeproject.app.rec.mapper.RecRecipeImageMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RecRecipeImageService {

    private final RecRecipeImageDao recRecipeImageDao;
    private final RecRecipeService recRecipeService;

    public BaseResponseDto save(RecRecipeImageSaveRequestDto recRecipeImageSaveRequestDto) {
        RecRecipe recRecipe = recRecipeService.findByIdWithControl(recRecipeImageSaveRequestDto.getRecipeId());

        RecRecipeImage recRecipeImage = RecRecipeImageMapper.INSTANCE.convertToRecRecipeImage(recRecipeImageSaveRequestDto);
        recRecipeImage.setRecRecipe(recRecipe);

        recRecipeImage = recRecipeImageDao.save(recRecipeImage);

        RecRecipeImageDto recRecipeImageDto = RecRecipeImageMapper.INSTANCE.convertToRecRecipeImageDto(recRecipeImage);

        BaseResponseDto baseResponseDto = new BaseResponseDto(ResponseInfo.success(HttpStatus.CREATED.value(), ResponseMessage.SUCCESSFUL.getMessage()), recRecipeImageDto);
        return baseResponseDto;
    }

    public BaseResponseDto update(RecRecipeImageUpdateRequestDto recRecipeImageUpdateRequestDto) {
        Long id = recRecipeImageUpdateRequestDto.getId();
        Long recipeId = recRecipeImageUpdateRequestDto.getRecipeId();

        boolean exists = recRecipeImageDao.existsById(id);
        if (!exists)
            throw new ResourceNotFoundException(ExceptionMessage.RESOURCE_NOT_FOUND.getMessage());

        RecRecipe recRecipe = recRecipeService.findByIdWithControl(recipeId);

        RecRecipeImage recRecipeImage = RecRecipeImageMapper.INSTANCE.convertToRecRecipeImage(recRecipeImageUpdateRequestDto);
        recRecipeImage.setRecRecipe(recRecipe);
        recRecipeImage = recRecipeImageDao.save(recRecipeImage);

        RecRecipeImageDto recRecipeImageDto = RecRecipeImageMapper.INSTANCE.convertToRecRecipeImageDto(recRecipeImage);

        BaseResponseDto baseResponseDto = new BaseResponseDto(ResponseInfo.success(ResponseMessage.SUCCESSFUL.getMessage()), recRecipeImageDto);
        return baseResponseDto;
    }

    public BaseResponseDto delete(Long id) {
        recRecipeImageDao.deleteById(id);
        BaseResponseDto baseResponseDto = new BaseResponseDto(ResponseInfo.success(ResponseMessage.SUCCESSFUL.getMessage()), null);
        return baseResponseDto;
    }

    public BaseResponseDto findAllByRecRecipe_Id(Long recRecipeId) {
        List<RecRecipeImage> recRecipeImageList = recRecipeImageDao.findAllByRecRecipe_Id(recRecipeId);
        List<RecRecipeImageDto> recRecipeImageDtoList = RecRecipeImageMapper.INSTANCE.convertToRecRecipeImageDtoList(recRecipeImageList);

        BaseResponseDto baseResponseDto = new BaseResponseDto(ResponseInfo.success(ResponseMessage.SUCCESSFUL.getMessage()), recRecipeImageDtoList);
        return baseResponseDto;
    }

    public RecRecipeImage findByIdWithControl(Long id) {
        Optional<RecRecipeImage> optionalRecRecipeImage = recRecipeImageDao.findById(id);

        RecRecipeImage recRecipeImage;
        if (optionalRecRecipeImage.isPresent())
            recRecipeImage = optionalRecRecipeImage.get();
        else
            throw new ResourceNotFoundException(ExceptionMessage.RESOURCE_NOT_FOUND.getMessage());

        return recRecipeImage;
    }
}
