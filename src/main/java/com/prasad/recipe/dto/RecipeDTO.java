package com.prasad.recipe.dto;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;

/**
 * This Recipe DTO for the service
 *
 */
public class RecipeDTO {
	@ApiModelProperty(hidden = true)
	private Integer id;
	@Size(min = 5, max = 50, message = "Enter between 5 and 50 Characters...")
	@NotEmpty
	private String name;
	private boolean veg;
	@ApiModelProperty(hidden = true)
	private Date creationDate;
	@Positive(message = "Please enter positive number")
	private Integer suitableForNoOfPeople;
	@NotEmpty
	private List<IngredientsDTO> ingredients;
	@NotEmpty
	private String cookingInstructions;

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the veg
	 */
	public boolean isVeg() {
		return veg;
	}

	/**
	 * @param veg the veg to set
	 */
	public void setVeg(boolean veg) {
		this.veg = veg;
	}

	/**
	 * @return the creationDate
	 */
	public Date getCreationDate() {
		return creationDate;
	}

	/**
	 * @param creationDate the creationDate to set
	 */
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	/**
	 * @return the suitableForNoOfPeople
	 */
	public Integer getSuitableForNoOfPeople() {
		return suitableForNoOfPeople;
	}

	/**
	 * @param suitableForNoOfPeople the suitableForNoOfPeople to set
	 */
	public void setSuitableForNoOfPeople(Integer suitableForNoOfPeople) {
		this.suitableForNoOfPeople = suitableForNoOfPeople;
	}

	/**
	 * @return the ingredients
	 */
	public List<IngredientsDTO> getIngredients() {
		return ingredients;
	}

	/**
	 * @param ingredients the ingredients to set
	 */
	public void setIngredients(List<IngredientsDTO> ingredients) {
		this.ingredients = ingredients;
	}

	/**
	 * @return the cookingInstructions
	 */
	public String getCookingInstructions() {
		return cookingInstructions;
	}

	/**
	 * @param cookingInstructions the cookingInstructions to set
	 */
	public void setCookingInstructions(String cookingInstructions) {
		this.cookingInstructions = cookingInstructions;
	}

	@Override
	public String toString() {
		return String.format(
				"RecipeDTO [id=%s, name=%s, veg=%s, creationDate=%s, suitableForNoOfPeople=%s, ingredientsList=%s, cookingInstructions=%s]",
				id, name, veg, creationDate, suitableForNoOfPeople, ingredients, cookingInstructions);
	}

}
