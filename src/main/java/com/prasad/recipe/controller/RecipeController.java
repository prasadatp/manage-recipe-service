package com.prasad.recipe.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prasad.recipe.dto.RecipeDTO;
import com.prasad.recipe.service.RecipeService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
/**
 * This is Controller for manage recipe service
 *
 */
@RestController
@RequestMapping("/recipes")
public class RecipeController {

	@Autowired
	RecipeService service;

	/**
	 * Recipe This method return Recipe of given id.
	 * @param id
	 * @return  RecipeDTO
	 *
	 */
	@GetMapping("/{id}")
	@ApiOperation(value = "Finds recipe by ID")
	public RecipeDTO getById(
			@ApiParam(value = "ID value for the recipe you need to retrieve", required = true) @PathVariable Integer id) {
		return service.getById(id);
	}

	/**
	 * This method will save recipe details into the application.
	 * @param recipe
	 * @return RecipeDTO 
	 *  
	 */
	@PostMapping("/")
	@ApiOperation(value = "Insert recipe details into application", notes = "Recipe ID not required it is auto genarated")
	public RecipeDTO saveRecipe(@Valid @RequestBody RecipeDTO recipeDTO) {
		return service.save(recipeDTO);
	}

	/**
	 * This method will update recipe details into the application. 
	 * @param Recipe
	 * @return RecipeDTO 
	 *
	 */
	@PutMapping("/")
	@ApiOperation(value = "Update recipe info")
	public RecipeDTO updateRecipe(@Valid @RequestBody RecipeDTO recipeDTO) {
		return service.update(recipeDTO);

	}

	/**
	 * This method will delete Recipe recored of given id.
	 * @param id
	 * @return String 
	 * 
	 */
	@DeleteMapping("/{id}")
	@ApiOperation(value = "Delete recipe by ID")
	public String deleteById(
			@ApiParam(value = "ID value for the recipe you need to delete", required = true) @PathVariable Integer id) {
		return service.deleteById(id);
	}

	/**
	 * This method will give all the Recipes. 
	 * @return List 
	 *
	 */
	@GetMapping("/")
	@ApiOperation(value = "Retrieve all the Recipes")
	public List<RecipeDTO> getAllRecipes() {
		return service.findAll();
	}

}
