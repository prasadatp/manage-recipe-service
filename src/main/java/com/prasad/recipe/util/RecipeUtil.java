/**
 * 
 */
package com.prasad.recipe.util;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.prasad.recipe.dto.IngredientsDTO;
import com.prasad.recipe.dto.RecipeDTO;
import com.prasad.recipe.model.Ingredients;
import com.prasad.recipe.model.Recipe;

/**
 * @author Prasad
 * Util class for building RecipeDTO and Recipe model and vice versa
 */
public class RecipeUtil {
	
	/**
	 * This Class will have all static methods only,no need to instantiate this class
	 */
	private RecipeUtil() {
		super();
	}
	/**
	 * This method will create RecipeDTO from Recipe model object
	 * @param Recipe
	 * @return RecipeDTO 
	 */
	public static RecipeDTO createRecipeDTOFromRecipe(Recipe recipe) {
		RecipeDTO recipeDTO = new RecipeDTO();		
		recipeDTO.setId(recipe.getId());
		recipeDTO.setName(recipe.getName());
		recipeDTO.setVeg(recipe.isVeg());
		recipeDTO.setCreationDate(recipe.getCreationTimestamp());
		recipeDTO.setSuitableForNoOfPeople(recipe.getSuitableForNoOfPeople());
		recipeDTO.setIngredients(recipe.getIngredients().stream().map(ingredient-> new IngredientsDTO(ingredient.getId(), ingredient.getName())).collect(Collectors.toList()));
		recipeDTO.setCookingInstructions(recipe.getCookingInstructions());
		return recipeDTO;
	}
	/**
	 * This method will create List of RecipeDTO from List Recipe model object
	 * @param List<Recipe>
	 * @return List<RecipeDTO> 
	 */
	public static List<RecipeDTO> createRecipesDTOsListFromRecipes(List<Recipe> listOfRecipes) {
		List<RecipeDTO> listOfRecipesWithDTOs = new ArrayList<>();
		listOfRecipes.forEach(recipe -> {
			RecipeDTO recipeDTO = new RecipeDTO();
			recipeDTO.setId(recipe.getId());
			recipeDTO.setName(recipe.getName());
			recipeDTO.setVeg(recipe.isVeg());
			recipeDTO.setCreationDate(recipe.getCreationTimestamp());
			recipeDTO.setSuitableForNoOfPeople(recipe.getSuitableForNoOfPeople());
			recipeDTO.setIngredients(recipe.getIngredients().stream().map(ingredient-> new IngredientsDTO(ingredient.getId(), ingredient.getName())).collect(Collectors.toList()));
			recipeDTO.setCookingInstructions(recipe.getCookingInstructions());
			listOfRecipesWithDTOs.add(recipeDTO);
		});
		return listOfRecipesWithDTOs;
	}
	/**
	 * This method will create Recipe model object from RecipeDTO
	 * @param RecipeDTO
	 * @return Recipe
	 */
	public static Recipe createRecipeFromRecipeDTO(RecipeDTO recipeDTO ) {
		Recipe recipe =new Recipe();
		recipe.setId(recipeDTO.getId());
		recipe.setName(recipeDTO.getName());
		recipe.setVeg(recipeDTO.isVeg());
		recipe.setCreationTimestamp(new Timestamp(System.currentTimeMillis()));
		recipe.setSuitableForNoOfPeople(recipeDTO.getSuitableForNoOfPeople());
		recipe.setIngredients(recipeDTO.getIngredients().stream().map(ingredient-> new Ingredients(ingredient.getId(), ingredient.getName())).collect(Collectors.toList()));
		recipe.setCookingInstructions(recipeDTO.getCookingInstructions());
		return recipe;
		
	}

}
