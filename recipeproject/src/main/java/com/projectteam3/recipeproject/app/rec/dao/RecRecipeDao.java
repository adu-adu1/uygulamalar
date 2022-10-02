package com.projectteam3.recipeproject.app.rec.dao;

import com.projectteam3.recipeproject.app.rec.entity.RecRecipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecRecipeDao extends JpaRepository<RecRecipe, Long> {
}
