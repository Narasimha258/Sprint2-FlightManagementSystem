package com.cg.fms.exception;

public class SearchNotFoundException extends RuntimeException{
	
	
	private static final long serialVersionUID = 1L;

	public SearchNotFoundException(String msg) {
		
		super(msg);
	}

}
