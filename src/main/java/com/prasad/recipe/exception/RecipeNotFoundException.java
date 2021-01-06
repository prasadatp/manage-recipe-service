package com.prasad.recipe.exception;
/**
 * This is Exception application will throw when Recipe not found 
 *
 */
public class RecipeNotFoundException extends RuntimeException {

	/* The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new recipe not found exception.
	 *
	 * @param message the message
	 */
	public RecipeNotFoundException(String message) {
		super(message);
	}
}
