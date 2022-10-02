package com.projectteam3.recipeproject.app.usr.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class UsrUserSaveRequestDto {

    @Size(max = 100)
    private String name;

    @Size(max = 100)
    private String surname;

    @Size(max = 100)
    @NotNull
    private String username;

    @NotNull
    private String password;
}
