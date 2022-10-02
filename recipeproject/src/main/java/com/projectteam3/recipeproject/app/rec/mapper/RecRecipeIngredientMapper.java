package com.projectteam3.recipeproject.app.rec.mapper;

import com.projectteam3.recipeproject.app.rec.dto.RecRecipeIngredientDto;
import com.projectteam3.recipeproject.app.rec.dto.RecRecipeIngredientSaveRequestDto;
import com.projectteam3.recipeproject.app.rec.dto.RecRecipeIngredientUpdateRequestDto;
import com.projectteam3.recipeproject.app.rec.entity.RecRecipeIngredient;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RecRecipeIngredientMapper {
    RecRecipeIngredientMapper INSTANCE = Mappers.getMapper(RecRecipeIngredientMapper.class);

    RecRecipeIngredient convertToRecRecipeIngredient(RecRecipeIngredientSaveRequestDto recRecipeIngredientSaveRequestDto);
    RecRecipeIngredient convertToRecRecipeIngredient(RecRecipeIngredientUpdateRequestDto recRecipeIngredientUpdateRequestDto);

    RecRecipeIngredientDto convertToRecRecipeIngredientDto(RecRecipeIngredient recRecipeIngredient);

    List<RecRecipeIngredientDto> convertToRecRecipeIngredientDtoList(List<RecRecipeIngredient> recRecipeIngredientList);
}
