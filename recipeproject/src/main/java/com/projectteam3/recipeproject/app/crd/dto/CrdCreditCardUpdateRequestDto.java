package com.projectteam3.recipeproject.app.crd.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Getter
@Setter
public class CrdCreditCardUpdateRequestDto {

    @NotNull
    @Size(min = 16, max = 16)
    private String cardNo;

    @NotNull
    private Long cvv;

    @NotNull
    private Date expirationDate;

    @NotNull
    @Size(max = 100)
    private String cardholderName;
}
