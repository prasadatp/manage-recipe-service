package com.prasad.recipe.exception;

import java.util.Date;

import javax.validation.ConstraintViolationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
/**
 * This is Custom Exception Handler class 
 *
 */
@RestControllerAdvice(basePackages = "com.prasad.recipe")
public class RecipeExceptionHandler {

	private static final Logger log = LoggerFactory.getLogger(RecipeExceptionHandler.class);

	/**
	 * Resource not found exception.
	 *
	 * @param exception of RecipeNotFoundException
	 * @param request   the WebRequest
	 * @return the response entity
	 */
	@ExceptionHandler(RecipeNotFoundException.class)
	public ResponseEntity<ErrorDetails> resourceNotFoundException(RecipeNotFoundException exception,
			WebRequest request) {
		log.error(exception.getMessage(), exception);
		ErrorDetails errorDetails = new ErrorDetails(new Date(), exception.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}

	/**
	 * All other exception handler.
	 *
	 * @param exception of Exception
	 * @param request   the WebRequest
	 * @return the response entity
	 */
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> recipeExcpetionHandler(Exception exception, WebRequest request) {
		log.error(exception.getMessage(), exception);
		ErrorDetails errorDetails = new ErrorDetails(new Date(), exception.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	/**
	 * Constraint Violation exception handler.
	 *
	 * @param exception of ConstraintViolationException
	 * @param request   the WebRequest
	 * @return the response entity
	 */

	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<ErrorDetails> handleConstraintViolationException(ConstraintViolationException exception,
			WebRequest request) {
		log.error(exception.getMessage(), exception);
		ErrorDetails errorDetails = new ErrorDetails(new Date(), exception.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);

	}

	/**
	 * Method Argument Not Valid exception handler.
	 *
	 * @param exception of MethodArgumentNotValidException
	 * @param request   the WebRequest
	 * @return the response entity
	 */
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorDetails> handleMethodArgumentTypeMismatchException(
			MethodArgumentNotValidException exception, WebRequest request) {
		log.error(exception.getMessage(), exception);
		ErrorDetails errorDetails = new ErrorDetails(new Date(), exception.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);

	}

	/**
	 * Message Not Readable Exception exception handler.
	 *
	 * @param exception of HttpMessageNotReadableException
	 * @param request   the WebRequest
	 * @return the response entity
	 */
	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<ErrorDetails> handleHttpMessageNotReadableException(HttpMessageNotReadableException exception,
			WebRequest request) {
		log.error(exception.getMessage(), exception);
		ErrorDetails errorDetails = new ErrorDetails(new Date(), exception.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);

	}
}
