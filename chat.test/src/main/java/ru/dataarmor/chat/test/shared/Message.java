/**
 *
 */
package ru.dataarmor.chat.test.shared;

/**
 *
 */
public class Message {

	private final String message;

	private final User user;

	public Message(String message, User user) {
		this.message = message;
		this.user = user;
	}

	public String getMessage() {
		return message;
	}

	public User getUser() {
		return user;
	}

}
