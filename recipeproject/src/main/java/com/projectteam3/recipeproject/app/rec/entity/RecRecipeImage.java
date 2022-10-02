package com.projectteam3.recipeproject.app.rec.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "REC_RECIPE_IMAGE")
@Getter
@Setter
public class RecRecipeImage {
    @Id
    @SequenceGenerator(name = "RecRecipeImage", sequenceName = "REC_RECIPE_IMAGE_ID_SEQ")
    @GeneratedValue(generator = "RecRecipeImage")
    private Long id;

    @Column(name = "LINK", nullable = false)
    private String link;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "ID_REC_RECIPE", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private RecRecipe recRecipe;
}
