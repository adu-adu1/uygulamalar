package com.projectteam3.recipeproject.app.rec.mapper;

import com.projectteam3.recipeproject.app.rec.dto.RecRecipeImageDto;
import com.projectteam3.recipeproject.app.rec.dto.RecRecipeImageSaveRequestDto;
import com.projectteam3.recipeproject.app.rec.dto.RecRecipeImageUpdateRequestDto;
import com.projectteam3.recipeproject.app.rec.entity.RecRecipeImage;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RecRecipeImageMapper {
    RecRecipeImageMapper INSTANCE = Mappers.getMapper(RecRecipeImageMapper.class);

    RecRecipeImage convertToRecRecipeImage(RecRecipeImageSaveRequestDto recRecipeImageSaveRequestDto);
    RecRecipeImage convertToRecRecipeImage(RecRecipeImageUpdateRequestDto recRecipeImageUpdateRequestDto);

    RecRecipeImageDto convertToRecRecipeImageDto(RecRecipeImage recRecipeImage);
    List<RecRecipeImageDto> convertToRecRecipeImageDtoList(List<RecRecipeImage> recRecipeImageList);
}
