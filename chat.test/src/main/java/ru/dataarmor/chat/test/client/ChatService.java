package ru.dataarmor.chat.test.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("chat")
public interface ChatService extends RemoteService {

	void sendMessage(String userName, String message);

	void login(String userName);

	String getAllMessages();

	void out(String userName);

}
