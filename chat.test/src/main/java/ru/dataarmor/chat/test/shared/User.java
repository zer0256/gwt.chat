package ru.dataarmor.chat.test.shared;

/**
 * Модель пользователя
 */
public class User {

	/**
	 * Имя пользователя
	 */
	private final String userName;

	/**
	 * Конструктор
	 *
	 * @param userName
	 *            имя пользователя
	 */
	public User(String userName) {
		this.userName = userName;
	}

	public String getUserName() {
		return userName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (prime * result)
				+ ((userName == null) ? 0 : userName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		User other = (User) obj;
		if (userName == null) {
			if (other.userName != null) {
				return false;
			}
		} else if (!userName.equals(other.userName)) {
			return false;
		}
		return true;
	}

}
