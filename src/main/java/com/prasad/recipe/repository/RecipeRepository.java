package com.prasad.recipe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prasad.recipe.model.Recipe;

public interface RecipeRepository extends JpaRepository<Recipe, Integer> {

}
