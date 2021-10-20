package com.ketul.demo.exception;

import java.time.zone.ZoneRulesException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class CustomizeExceptionController extends ResponseEntityExceptionHandler{

	List<MultipleExceptionHandler> multipleExceptionHandler = new ArrayList<>();
	
//	@ExceptionHandler(UserNotFoundException.class)
//	public final ResponseEntity<Object> handleUserNotFoundException(UserNotFoundException ex, WebRequest request) throws Exception {
//		
//		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));
//		System.out.println(request);
//		return new ResponseEntity<Object>(exceptionResponse, HttpStatus.NOT_FOUND);
//	}
//	
//	@ExceptionHandler(Exception.class)
//	public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest request) throws Exception {
//		
//		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));
//		return new ResponseEntity<Object>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
//	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

		
		ex.getFieldErrors().forEach( fe -> {
			System.out.println(fe.getField() + "   "+ fe.getDefaultMessage());	
			multipleExceptionHandler.add(new MultipleExceptionHandler(fe.getField().toString(), fe.getDefaultMessage().toString()));
		});
		
		
//		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), "Validation Error", ex.getBindingResult().getFieldError().getDefaultMessage().toString());  

		// );
		
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), multipleExceptionHandler);  

		return new ResponseEntity<Object>(exceptionResponse, status.BAD_REQUEST);

	}
}
