package com.schoolofnet.websocket.model;

public class Chat {

	private String user;
	private String message;
	
	public Chat() {
		
	}
	
	public Chat(String message) {
		this.message = message;
	}
	
	public Chat(String user, String message) {
		this.setUser(user);
		this.setMessage(message);
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
