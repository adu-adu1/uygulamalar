package com.projectteam3.recipeproject.app.rec.dao;

import com.projectteam3.recipeproject.app.rec.entity.RecRecipeImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecRecipeImageDao extends JpaRepository<RecRecipeImage, Long> {

    List<RecRecipeImage> findAllByRecRecipe_Id(Long recipeId);

}
