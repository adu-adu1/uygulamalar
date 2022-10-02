package com.projectteam3.recipeproject.app.rec.dao;

import com.projectteam3.recipeproject.app.rec.entity.RecRecipeIngredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecRecipeIngredientDao extends JpaRepository<RecRecipeIngredient, Long> {
    List<RecRecipeIngredient> findAllByRecRecipe_Id(Long recipeId);

}
