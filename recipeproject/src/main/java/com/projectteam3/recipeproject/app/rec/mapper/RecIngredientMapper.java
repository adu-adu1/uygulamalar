package com.projectteam3.recipeproject.app.rec.mapper;

import com.projectteam3.recipeproject.app.rec.dto.RecIngredientDto;
import com.projectteam3.recipeproject.app.rec.dto.RecIngredientSaveRequestDto;
import com.projectteam3.recipeproject.app.rec.dto.RecIngredientUpdateRequestDto;
import com.projectteam3.recipeproject.app.rec.entity.RecIngredient;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RecIngredientMapper {
    RecIngredientMapper INSTANCE = Mappers.getMapper(RecIngredientMapper.class);

    RecIngredient convertToRecIngredient(RecIngredientSaveRequestDto recIngredientSaveRequestDto);
    RecIngredient convertToRecIngredient(RecIngredientUpdateRequestDto recIngredientUpdateRequestDto);

    RecIngredientDto convertToRecIngredientDto(RecIngredient recIngredient);
}
