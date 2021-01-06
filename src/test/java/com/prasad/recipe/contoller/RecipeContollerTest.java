/**
 * 
 */
package com.prasad.recipe.contoller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.prasad.recipe.controller.RecipeController;
import com.prasad.recipe.dto.IngredientsDTO;
import com.prasad.recipe.dto.RecipeDTO;
import com.prasad.recipe.service.RecipeService;

/**
 * This class is test class for RecipeContoller
 *
 */
@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
@WebMvcTest(RecipeController.class)
class RecipeContollerTest {
	@Autowired
	private MockMvc mockMvc;
	@MockBean
	RecipeService service;
	@Autowired
	ObjectMapper objectMapper;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
	}

	/**
	 * Test method for
	 * {@link com.prasad.recipe.controller.RecipeController#getById(java.lang.Integer)}.
	 * 
	 * @throws Exception
	 */
	@Test
	@WithMockUser(username = "prasad", password = "prasad", roles = "USER")
	void testGetById() throws Exception {
		Mockito.when(service.getById(1)).thenReturn(getRecipeDTO());
		mockMvc.perform(get("/recipes/1").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
	}

	/**
	 * Test method for
	 * {@link com.prasad.recipe.controller.RecipeController#saveRecipe(com.prasad.recipe.dto.RecipeDTO)}.
	 */
	@Test
	@WithMockUser(username = "prasad", password = "prasad", roles = "USER")
	void testSaveRecipe() throws Exception {
		RecipeDTO recipeDTO = getRecipeDTO();
		Mockito.when(service.save(recipeDTO)).thenReturn(recipeDTO);
		mockMvc.perform(post("/recipes/").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(recipeDTO))).andExpect(status().isOk());
	}

	/**
	 * Test method for
	 * {@link com.prasad.recipe.controller.RecipeController#updateRecipe(com.prasad.recipe.dto.RecipeDTO)}.
	 */
	@Test
	@WithMockUser(username = "prasad", password = "prasad", roles = "USER")
	void testUpdateRecipe() throws Exception {
		RecipeDTO recipeDTO = getRecipeDTO();
		Mockito.when(service.update(recipeDTO)).thenReturn(recipeDTO);
		mockMvc.perform(put("/recipes/").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(recipeDTO))).andExpect(status().isOk());
	}

	/**
	 * Test method for
	 * {@link com.prasad.recipe.controller.RecipeController#deleteById(java.lang.Integer)}.
	 */
	@Test
	@WithMockUser(username = "prasad", password = "prasad", roles = "USER")
	void testDeleteById() throws Exception {
		String responseMessage = "";
		Mockito.when(service.deleteById(1)).thenReturn(responseMessage);
		mockMvc.perform(get("/recipes/1").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
	}

	/**
	 * Test method for
	 * {@link com.prasad.recipe.controller.RecipeController#getAllRecipes()}.
	 * 
	 * @throws Exception
	 */
	@Test
	@WithMockUser(username = "prasad", password = "prasad", roles = "USER")
	void testGetAllRecipes() throws Exception {
		List<RecipeDTO> recipeDTOsList = Arrays.asList();
		Mockito.when(service.findAll()).thenReturn(recipeDTOsList);
		mockMvc.perform(get("/recipes/").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
	}

	private RecipeDTO getRecipeDTO() {
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
}
