package com.agcoassignment.userservice.exception;

import java.time.Instant;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class UserExceptionHandler {
	
	@ExceptionHandler(RuntimeException.class)
	public ProblemDetail onRuntimeException(RuntimeException ex) {
		
		ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, ex.getMessage());
		problemDetail.setTitle("Users Not Found");
        //problemDetail.setType(URI.create("https://localhost:8088/errors/not-found"));
        problemDetail.setProperty("errorCategory", "Generic");
        problemDetail.setProperty("timestamp", Instant.now());
        return problemDetail;
		
	}

}
