package ru.dataarmor.chat.test.client;

import ru.dataarmor.chat.test.shared.User;

public interface UserInfoProvider {

	void setUser(User user);

	User getUser();

}
