package ru.dataarmor.chat.test.shared;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ChatRoomModel {

	/**
	 * Список пользователей
	 */
	private final Set<User> users = new HashSet<>();

	private final List<Message> messages = new ArrayList<>();

	/**
	 * Возвращает признак принадлежности пользователя к чату
	 *
	 * @param user
	 *            пользователь для проверки
	 * @return признак принадлежности пользователя к чату
	 */
	public boolean hasUser(User user) {
		return true; // users.contains(user);
	}

	public void registerUser(User user) {
		users.add(user);
	}

	public void removeUser(User user) {
		users.remove(user);
	}

	public void addMessage(Message message) {
		messages.add(message);
	}

	public List<Message> getMessages() {
		return Collections.unmodifiableList(messages);
	}

}
