package com.ketul.demo.exception;

import java.util.Date;
import java.util.List;

import org.springframework.http.HttpStatus;

public class ExceptionResponse {
	private Date time;
	List<MultipleExceptionHandler> multipleExceptionHandler;
	
	public ExceptionResponse() {
		super();
	}

	public ExceptionResponse(Date time, List<MultipleExceptionHandler> multipleExceptionHandler) {
		super();
		this.time = time;
		this.multipleExceptionHandler = multipleExceptionHandler;
		
	}

	public Date getTime() {
		return time;
	}

	public List<MultipleExceptionHandler> getMultipleExceptionHandler() {
		return multipleExceptionHandler;
	}

	@Override
	public String toString() {
		return "ExceptionResponse [time=" + time + "" + "]";
	}

	
	

}
