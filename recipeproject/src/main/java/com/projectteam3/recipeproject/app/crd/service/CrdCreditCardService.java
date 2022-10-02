package com.projectteam3.recipeproject.app.crd.service;

import com.projectteam3.recipeproject.app.crd.dao.CrdCreditCardDao;
import com.projectteam3.recipeproject.app.crd.dto.CrdCreditCardDto;
import com.projectteam3.recipeproject.app.crd.dto.CrdCreditCardSaveRequestDto;
import com.projectteam3.recipeproject.app.crd.dto.CrdCreditCardUpdateRequestDto;
import com.projectteam3.recipeproject.app.crd.entity.CrdCreditCard;
import com.projectteam3.recipeproject.app.crd.mapper.CrdCreditCardMapper;
import com.projectteam3.recipeproject.app.gen.dto.BaseResponseDto;
import com.projectteam3.recipeproject.app.gen.dto.ResponseInfo;
import com.projectteam3.recipeproject.app.gen.enums.ExceptionMessage;
import com.projectteam3.recipeproject.app.gen.enums.ResponseMessage;
import com.projectteam3.recipeproject.app.gen.exception.ResourceNotFoundException;
import com.projectteam3.recipeproject.app.gen.exception.ResourceUsedException;
import com.projectteam3.recipeproject.app.usr.entity.UsrUser;
import com.projectteam3.recipeproject.app.usr.service.UsrUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CrdCreditCardService {
    private final CrdCreditCardDao crdCreditCardDao;
    private final UsrUserService usrUserService;

    public BaseResponseDto save(Long userId, CrdCreditCardSaveRequestDto crdCreditCardSaveRequestDto) {
        controlCreditCardNotExists(crdCreditCardSaveRequestDto.getCardNo());

        UsrUser usrUser = usrUserService.findByIdWithControl(userId);
        CrdCreditCard crdCreditCard = CrdCreditCardMapper.INSTANCE.convertToCrdCreditCard(crdCreditCardSaveRequestDto);

        crdCreditCard.setUsrUser(usrUser);
        crdCreditCard = crdCreditCardDao.save(crdCreditCard);

        CrdCreditCardDto crdCreditCardDto = CrdCreditCardMapper.INSTANCE.convertToCrdCreditCardDto(crdCreditCard);

        BaseResponseDto baseResponseDto = new BaseResponseDto(ResponseInfo.success(HttpStatus.CREATED.value(), ResponseMessage.SUCCESSFUL.getMessage()), crdCreditCardDto);
        return baseResponseDto;
    }

    public BaseResponseDto update(Long userId, Long id, CrdCreditCardUpdateRequestDto crdCreditCardUpdateRequestDto) {
        boolean exists = crdCreditCardDao.existsById(id);
        if (!exists)
            throw new ResourceNotFoundException(ExceptionMessage.RESOURCE_NOT_FOUND.getMessage());

        controlCreditCardNotExists(crdCreditCardUpdateRequestDto.getCardNo());

        UsrUser usrUser = usrUserService.findByIdWithControl(userId);

        CrdCreditCard crdCreditCard = CrdCreditCardMapper.INSTANCE.convertToCrdCreditCard(crdCreditCardUpdateRequestDto);
        crdCreditCard.setId(id);
        crdCreditCard.setUsrUser(usrUser);
        crdCreditCard = crdCreditCardDao.save(crdCreditCard);
        CrdCreditCardDto crdCreditCardDto = CrdCreditCardMapper.INSTANCE.convertToCrdCreditCardDto(crdCreditCard);

        BaseResponseDto baseResponseDto = new BaseResponseDto(ResponseInfo.success(ResponseMessage.SUCCESSFUL.getMessage()), crdCreditCardDto);
        return baseResponseDto;
    }

    public BaseResponseDto delete(Long id) {
        crdCreditCardDao.deleteById(id);
        BaseResponseDto baseResponseDto = new BaseResponseDto(ResponseInfo.success(ResponseMessage.SUCCESSFUL.getMessage()), null);
        return baseResponseDto;
    }

    public BaseResponseDto findAllByUsrUser_Id(Long userId) {
        List<CrdCreditCard> crdCreditCardList = crdCreditCardDao.findAllByUsrUser_Id(userId);
        List<CrdCreditCardDto> crdCreditCardDtoList = CrdCreditCardMapper.INSTANCE.convertToCrdCreditCardDtoList(crdCreditCardList);

        BaseResponseDto baseResponseDto = new BaseResponseDto(ResponseInfo.success(ResponseMessage.SUCCESSFUL.getMessage()), crdCreditCardDtoList);
        return baseResponseDto;
    }

    public CrdCreditCard findByIdWithControl(Long id) {
        Optional<CrdCreditCard> optionalCrdCreditCard = crdCreditCardDao.findById(id);

        CrdCreditCard crdCreditCard;
        if (optionalCrdCreditCard.isPresent())
            crdCreditCard = optionalCrdCreditCard.get();
        else
            throw new ResourceNotFoundException(ExceptionMessage.RESOURCE_NOT_FOUND.getMessage());

        return crdCreditCard;
    }

    private void controlCreditCardNotExists(String cardNo) {
        CrdCreditCard crdCreditCard = crdCreditCardDao.findByCardNo(cardNo);
        if (crdCreditCard != null)
            throw new ResourceUsedException(ExceptionMessage.RESOURCE_USED.getMessage());
    }
}
