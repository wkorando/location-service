package com.ibm.developer.location;

public class ServerException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5747861340856672011L;
	private String userMessage;

	public ServerException() {
		super();
	}

	public ServerException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ServerException(String message, Throwable cause) {
		super(message, cause);
	}

	public ServerException(String message) {
		super(message);
		this.userMessage = message;
	}

	public ServerException(Throwable cause) {
		super(cause);
	}

	public ServerException(String internalMessage, String userMessage) {
		super();
		this.userMessage = userMessage;
	}

	/**
	 * Message to be printed user. Defaults to standard error message.
	 * @return
	 */
	public String getUserMessage() {
		return userMessage;
	}
}
