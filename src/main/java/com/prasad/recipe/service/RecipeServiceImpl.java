/**
 * 
 */
package com.prasad.recipe.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prasad.recipe.dto.RecipeDTO;
import com.prasad.recipe.exception.RecipeNotFoundException;
import com.prasad.recipe.model.Recipe;
import com.prasad.recipe.repository.RecipeRepository;
import com.prasad.recipe.util.RecipeConstants;
import com.prasad.recipe.util.RecipeUtil;

/**
 *This Recipe Service implementation 
 *
 */
@Service
public class RecipeServiceImpl implements RecipeService {

	private static final Logger log = LoggerFactory.getLogger(RecipeServiceImpl.class);
	@Autowired
	RecipeRepository repository;
	/**
	 * This method will save recipe details into the application.
	 * @param recipeDTO of RecipeDTO
	 * @return recipeDTO of RecipeDTO
	 *
	 */
	@Override
	public RecipeDTO save(RecipeDTO recipeDTO) {
		log.debug("inside save method:");
		Recipe recipe = RecipeUtil.createRecipeFromRecipeDTO(recipeDTO);
		recipe = repository.save(recipe);
		recipeDTO = RecipeUtil.createRecipeDTOFromRecipe(recipe);
		return recipeDTO;
	}
	
	/**
	 * This method will update recipe details into the application. 
	 * @param recipeDTO of RecipeDTO
	 * @return recipeDTO of RecipeDTO
	 *
	 */
	@Override
	public RecipeDTO update(RecipeDTO recipeDTO) {
		log.debug("inside update method:");
		if (repository.existsById(recipeDTO.getId())) {
			Recipe recipe = RecipeUtil.createRecipeFromRecipeDTO(recipeDTO);
			recipeDTO = RecipeUtil.createRecipeDTOFromRecipe(repository.save(recipe));
			return recipeDTO;

		} else {
			throw new RecipeNotFoundException(RecipeConstants.NOT_FOUND_BY_GIVEN_ID + recipeDTO.getId());
		}

	}
	
	/**
	 * This method will delete Recipe recored of given id.
	 * @param id of Integer
	 * @return text message of type String 
	 * 
	 */
	@Override
	public String deleteById(Integer id) {
		log.debug("inside delete method:");
		if (repository.existsById(id)) {
			repository.deleteById(id);
			return RecipeConstants.RECIPE_DELETED;
		} else {
			throw new RecipeNotFoundException(RecipeConstants.NOT_FOUND_BY_GIVEN_ID + id);
		}

	}

	@Override
	public List<RecipeDTO> findAll() {
		log.debug("inside findAll method:");
		List<Recipe> listOfRecipes= repository.findAll();
		return RecipeUtil.createRecipesDTOsListFromRecipes(listOfRecipes);
	}

	@Override
	public RecipeDTO getById(Integer id) {
		log.debug("inside getById method:");
		Optional<Recipe> recipeOptional = repository.findById(id);
		if (recipeOptional.isPresent()) {
			return RecipeUtil.createRecipeDTOFromRecipe(recipeOptional.get());

		} else {
			throw new RecipeNotFoundException(RecipeConstants.NOT_FOUND_BY_GIVEN_ID + id);
		}
	}
}
