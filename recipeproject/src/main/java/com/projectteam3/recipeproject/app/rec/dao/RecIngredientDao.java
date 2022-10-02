package com.projectteam3.recipeproject.app.rec.dao;

import com.projectteam3.recipeproject.app.rec.entity.RecIngredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecIngredientDao extends JpaRepository<RecIngredient, Long> {

    RecIngredient findByName(String name);
}
