package com.projectteam3.recipeproject.app.crd.mapper;

import com.projectteam3.recipeproject.app.crd.dto.CrdCreditCardDto;
import com.projectteam3.recipeproject.app.crd.dto.CrdCreditCardSaveRequestDto;
import com.projectteam3.recipeproject.app.crd.dto.CrdCreditCardUpdateRequestDto;
import com.projectteam3.recipeproject.app.crd.entity.CrdCreditCard;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CrdCreditCardMapper {
    CrdCreditCardMapper INSTANCE = Mappers.getMapper(CrdCreditCardMapper.class);

    CrdCreditCard convertToCrdCreditCard(CrdCreditCardSaveRequestDto crdCreditCardSaveRequestDto);
    CrdCreditCard convertToCrdCreditCard(CrdCreditCardUpdateRequestDto crdCreditCardUpdateRequestDto);

    CrdCreditCardDto convertToCrdCreditCardDto(CrdCreditCard crdCreditCard);
    List<CrdCreditCardDto> convertToCrdCreditCardDtoList(List<CrdCreditCard> crdCreditCardList);
}
