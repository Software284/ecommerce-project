package com.lamichhane.ecommerce.exception.handler;



import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.lamichhane.ecommerce.exception.classes.ProductNotFoundException;
import com.lamichhane.ecommerce.exception.classes.StandardRestErrorResponse;
import com.lamichhane.ecommerce.exception.classes.StandardRestErrorResponse;



@ControllerAdvice
public class PortfolioExceptionHandler  {
		
		// Add an exception handler for ProductNotFoundException
		
			@ExceptionHandler
			public ResponseEntity<StandardRestErrorResponse> handleException(ProductNotFoundException exc) {
				
				// create CustomerErrorResponse
				
				StandardRestErrorResponse error = new StandardRestErrorResponse(
													HttpStatus.NOT_FOUND.value(),
													exc.getMessage(),
													System.currentTimeMillis());
				
				// return ResponseEntity
				
				return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
			}
			
			// Add another exception handler ... to catch any exception (catch all)

			@ExceptionHandler
			public ResponseEntity<StandardRestErrorResponse> handleException(Exception exc) {
				
				// create CustomerErrorResponse
				
				StandardRestErrorResponse error = new StandardRestErrorResponse(
													HttpStatus.BAD_REQUEST.value(),
													exc.getMessage(),
													System.currentTimeMillis());
				
				// return ResponseEntity
				
				return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
			}


		
		
}
