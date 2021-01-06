package com.prasad.recipe;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.prasad.recipe.controller.RecipeController;

@SpringBootTest
class ManageRecipeServiceApplicationTests {
	@Autowired
	private RecipeController controller;
	@Test
	void contextLoads() {
		assertThat(controller).isNotNull();
	}

}
