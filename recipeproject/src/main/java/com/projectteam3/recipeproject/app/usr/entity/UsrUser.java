package com.projectteam3.recipeproject.app.usr.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "USR_USER")
@Getter
@Setter
public class UsrUser {

    @Id
    @SequenceGenerator(name = "UsrUser", sequenceName = "USR_USER_ID_SEQ")
    @GeneratedValue(generator = "UsrUser")
    private Long id;

    @Column(name = "NAME", length = 100)
    private String name;

    @Column(name = "SURNAME", length = 100)
    private String surname;

    @Column(name = "USERNAME", length = 100, unique = true, nullable = false)
    private String username;

    @Column(name = "PASSWORD", nullable = false)
    private String password;


}
