package com.stackroute.tldm.userauth.exception;

public class UserAlreadyExistsException extends Exception {

	public static final long serialVersionID = 1;

	public UserAlreadyExistsException(String message) {
		super(message);
	}

}
