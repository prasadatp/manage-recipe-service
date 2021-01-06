package com.prasad.recipe.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.prasad.recipe.dto.IngredientsDTO;
import com.prasad.recipe.dto.RecipeDTO;
import com.prasad.recipe.exception.RecipeNotFoundException;
import com.prasad.recipe.model.Ingredients;
import com.prasad.recipe.model.Recipe;
import com.prasad.recipe.repository.RecipeRepository;
import com.prasad.recipe.util.RecipeConstants;
import com.prasad.recipe.util.RecipeUtil;

@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
class RecipeServiceImplTest {
	@InjectMocks
	RecipeServiceImpl service;
	@MockBean
	RecipeRepository repository;

	@Test
	void testSave() {
		try {
			Mockito.when(repository.save(any(Recipe.class))).thenReturn(getRecipe());
			service.save(getRecipeDTO());
		} catch (Exception e) {
			e.printStackTrace();
			fail("Exception should not have occured");
		}
	}

	@Test
	void testUpdateForIDExists() {
		Integer id = 1;
		Recipe inputRecipe = getRecipe();
		inputRecipe.setId(id);
		Mockito.when(repository.existsById(id)).thenReturn(true);
		inputRecipe.setSuitableForNoOfPeople(20);
		Mockito.when(repository.save(any(Recipe.class))).thenReturn(inputRecipe);
		RecipeDTO recipeDTO = service.update(RecipeUtil.createRecipeDTOFromRecipe(inputRecipe));
		assertNotNull(recipeDTO);
		assertEquals(recipeDTO.getSuitableForNoOfPeople(), inputRecipe.getSuitableForNoOfPeople());

	}

	@Test
	void testUpdateForIDNotExists() {
		RecipeDTO inputRrecipeDTO = getRecipeDTO();
		Integer id = 1;
		try {
			inputRrecipeDTO.setId(id);
			Mockito.when(repository.save(any(Recipe.class))).thenReturn(getRecipe());
			service.update(inputRrecipeDTO);
		} catch (RecipeNotFoundException exception) {
			assertThat(exception)
					.hasSameClassAs(new RecipeNotFoundException(RecipeConstants.NOT_FOUND_BY_GIVEN_ID + id));
		}
	}

	@Test
	void testDeleteForIDNotExists() {
		Integer id = 1;
		try {
			Mockito.when(repository.save(any(Recipe.class))).thenReturn(getRecipe());
			service.deleteById(id);
		} catch (RecipeNotFoundException exception) {
			assertThat(exception)
					.hasSameClassAs(new RecipeNotFoundException(RecipeConstants.NOT_FOUND_BY_GIVEN_ID + id));
		}
	}

	@Test
	void testDeleteForIDExists() {
		Integer id = 1;
		Mockito.when(repository.existsById(id)).thenReturn(true);
		String expected = service.deleteById(id);
		assertEquals(RecipeConstants.RECIPE_DELETED, expected);

	}

	@Test
	void testFindAll() {
		List<Recipe> recipesList = Arrays.asList(getRecipe());
		Mockito.when(repository.findAll()).thenReturn(recipesList);
		List<RecipeDTO> recipeDTOsList = service.findAll();
		assertNotNull(recipesList);
		assertEquals(recipesList.size(), recipeDTOsList.size());

	}

	@Test
	void testGetById() {
		Integer id = 1;
		when(repository.findById(id)).thenReturn(Optional.of(getRecipe()));
		RecipeDTO recipeDTO = service.getById(id);
		assertNotNull(recipeDTO);

	}

	private static RecipeDTO getRecipeDTO() {
		RecipeDTO recipeDTO = new RecipeDTO();
		recipeDTO.setName("Aloo Paratha");
		recipeDTO.setVeg(true);
		recipeDTO.setSuitableForNoOfPeople(10);
		recipeDTO.setIngredients(
				Arrays.asList(new IngredientsDTO(1, "2 potato"), new IngredientsDTO(2, "1 tablespoon coriander leaves"),
						new IngredientsDTO(3, "salt as required"), new IngredientsDTO(4, "1 cup wheat flour")));
		recipeDTO.setCookingInstructions("Step 1,Step 2,Step 3,Step 4");
		return recipeDTO;
	}

	private Recipe getRecipe() {
		Recipe recipe = new Recipe();
		recipe.setName("Aloo Paratha");
		recipe.setVeg(true);
		recipe.setSuitableForNoOfPeople(10);
		recipe.setIngredients(
				Arrays.asList(new Ingredients(1, "2 potato"), new Ingredients(2, "1 tablespoon coriander leaves"),
						new Ingredients(3, "salt as required"), new Ingredients(4, "1 cup wheat flour")));
		recipe.setCookingInstructions("Step 1,Step 2,Step 3,Step 4");
		return recipe;
	}

}
