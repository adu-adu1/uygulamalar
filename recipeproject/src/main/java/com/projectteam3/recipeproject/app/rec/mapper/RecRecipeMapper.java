package com.projectteam3.recipeproject.app.rec.mapper;

import com.projectteam3.recipeproject.app.rec.dto.RecRecipeDto;
import com.projectteam3.recipeproject.app.rec.dto.RecRecipeSaveRequestDto;
import com.projectteam3.recipeproject.app.rec.dto.RecRecipeUpdateRequestDto;
import com.projectteam3.recipeproject.app.rec.entity.RecRecipe;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RecRecipeMapper {
    RecRecipeMapper INSTANCE = Mappers.getMapper(RecRecipeMapper.class);

    RecRecipe convertToRecRecipe(RecRecipeSaveRequestDto recRecipeSaveRequestDto);
    RecRecipe convertToRecRecipe(RecRecipeUpdateRequestDto recRecipeUpdateRequestDto);

    RecRecipeDto convertToRecRecipeDto(RecRecipe recRecipe);
    List<RecRecipeDto> convertToRecRecipeDtoList(List<RecRecipe> recRecipeList);
}
