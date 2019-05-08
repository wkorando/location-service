package com.ibm.developer.location;

public class ClientException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4543581053246460837L;
	private String userMessage;

	public ClientException() {
		super();
	}

	public ClientException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ClientException(String message, Throwable cause) {
		super(message, cause);
	}

	public ClientException(String message) {
		super(message);
		this.userMessage = message;
	}

	public ClientException(Throwable cause) {
		super(cause);
	}

	public ClientException(String internalMessage, String userMessage) {
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
