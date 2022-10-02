package com.projectteam3.recipeproject.app.gen.dto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@RequiredArgsConstructor
public class BaseResponseDto{
    private Date date = new Date();
    private final ResponseInfo responseInfo;
    private final Object data;
}
