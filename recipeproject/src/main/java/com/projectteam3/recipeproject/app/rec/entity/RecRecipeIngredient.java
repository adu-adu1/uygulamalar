package com.projectteam3.recipeproject.app.rec.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "REC_RECIPE_INGREDIENT")
@Getter
@Setter
public class RecRecipeIngredient {
    @Id
    @SequenceGenerator(name = "RecRecipeIngredient", sequenceName = "REC_RECIPE_INGREDIENT_ID_SEQ")
    @GeneratedValue(generator = "RecRecipeIngredient")
    private Long id;

    @Column(name = "QUANTITY", nullable = false)
    private Long quantity;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "ID_REC_RECIPE", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private RecRecipe recRecipe;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "ID_REC_INGREDIENT", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private RecIngredient recIngredient;
}
