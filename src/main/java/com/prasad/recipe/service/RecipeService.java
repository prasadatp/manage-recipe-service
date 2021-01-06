/**
 * 
 */
package com.prasad.recipe.service;

import java.util.List;

import com.prasad.recipe.dto.RecipeDTO;

/**
 *This Recipe Service Interface
 *
 */
public interface RecipeService {
	public RecipeDTO save(RecipeDTO recipeDTO);

	public RecipeDTO update(RecipeDTO recipeDTO);

	public String deleteById(Integer id);

	public List<RecipeDTO> findAll();

	public RecipeDTO getById(Integer id);

}
