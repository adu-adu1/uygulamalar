package com.projectteam3.recipeproject.app.rec.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "REC_RECIPE")
@Getter
@Setter
public class RecRecipe {
    @Id
    @SequenceGenerator(name = "RecRecipe", sequenceName = "REC_RECIPE_ID_SEQ")
    @GeneratedValue(generator = "RecRecipe")
    private Long id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Lob
    @Column(name = "DESCRIPTION", nullable = false)
    private String description;

}
