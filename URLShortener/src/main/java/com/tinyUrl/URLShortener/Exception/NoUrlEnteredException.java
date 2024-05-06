package com.tinyUrl.URLShortener.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NoUrlEnteredException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	public NoUrlEnteredException(String message){
		super(message);
	}
}
