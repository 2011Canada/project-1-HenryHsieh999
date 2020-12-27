package com.revature.exceptions;

public class UnauthorizedException extends AbstractHttpException {

	public UnauthorizedException() {
		super("You do not have permissions to use this endpoint. Please see your administrator", 403);
	}
}
