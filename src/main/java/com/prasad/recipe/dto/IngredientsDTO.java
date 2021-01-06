/**
 * 
 */
package com.prasad.recipe.dto;

import io.swagger.annotations.ApiModelProperty;

/**
 * This Ingredients DTO for the service
 *
 */
public class IngredientsDTO {
	@ApiModelProperty(hidden = true)
	private Integer id;
	private String name;

	/**
	 * @param id
	 * @param name
	 */
	public IngredientsDTO(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

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

	@Override
	public String toString() {
		return String.format("Ingredients [id=%s, name=%s]", id, name);
	}

}
