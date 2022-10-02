package com.projectteam3.recipeproject.app.crd.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class CrdCreditCardDto {

    private Long id;
    private String cardNo;
    private Long cvv;
    private Date expirationDate;
    private String cardholderName;
}
