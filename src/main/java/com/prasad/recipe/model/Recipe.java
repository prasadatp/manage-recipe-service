/**
 * 
 */
package com.prasad.recipe.model;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * This is model class of Recipe
 *
 */
@Entity
public class Recipe {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private boolean veg;
	private Timestamp creationTimestamp;
	private Integer suitableForNoOfPeople;
	@OneToMany(cascade = CascadeType.ALL)
	private List<Ingredients> ingredients;
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
	 * @return the creationTimestamp
	 */
	public Timestamp getCreationTimestamp() {
		return creationTimestamp;
	}

	/**
	 * @param creationTimestamp the creationTimestamp to set
	 */
	public void setCreationTimestamp(Timestamp creationTimestamp) {
		this.creationTimestamp = creationTimestamp;
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
	public List<Ingredients> getIngredients() {
		return ingredients;
	}

	/**
	 * @param ingredients the ingredients to set
	 */
	public void setIngredients(List<Ingredients> ingredients) {
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
		return "Recipe [id=" + id + ", name=" + name + ", veg=" + veg + ", creationTimestamp=" + creationTimestamp
				+ ", suitableForNoOfPeople=" + suitableForNoOfPeople + ", ingredients=" + ingredients
				+ ", cookingInstructions=" + cookingInstructions + "]";
	}


}
