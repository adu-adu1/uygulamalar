package com.projectteam3.recipeproject.app.gen.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseInfo {
    private Integer code;
    private Boolean isSuccessful;
    private String message;

    public static ResponseInfo success(String message) {
        return new ResponseInfo(200, true, message);
    }

    public static ResponseInfo success(Integer code, String message) {
        return new ResponseInfo(code, true, message);
    }

    public static ResponseInfo error(Integer code, String message) {
        return new ResponseInfo(code, false, message);
    }
}
