/**
 *
 */
package ru.dataarmor.chat.test.server;

import java.util.List;

import ru.dataarmor.chat.test.client.ChatService;
import ru.dataarmor.chat.test.shared.ChatRoomModel;
import ru.dataarmor.chat.test.shared.Message;
import ru.dataarmor.chat.test.shared.User;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 *
 */
public class ChatServiceImpl extends RemoteServiceServlet implements
		ChatService {

	private static final String USER_CHAT_DELIM = ": ";

	private static final String LINE_SEPARATOR = "<br />";

	/**
	 * Модель чата
	 */
	private final ChatRoomModel chatRoomModel = new ChatRoomModel();

	/**
	 *
	 */
	private static final long serialVersionUID = -7029975429304792882L;

	/*
	 * (non-Javadoc)
	 * 
	 * @see maven.test.client.ChatService#sendMessage(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public void sendMessage(String userName, String message) {
		User user = new User(userName);
		if (chatRoomModel.hasUser(user)) {
			chatRoomModel.addMessage(new Message(message, user));
		}
	}

	@Override
	public void login(String userName) {
		chatRoomModel.registerUser(new User(userName));
	}

	@Override
	public String getAllMessages() {
		List<Message> allMessage = chatRoomModel.getMessages();
		StringBuilder builder = new StringBuilder();
		for (Message message : allMessage) {
			builder.append(message.getUser().getUserName());
			builder.append(USER_CHAT_DELIM);
			builder.append(message.getMessage());
			builder.append(LINE_SEPARATOR);
		}
		return builder.toString();
	}

	@Override
	public void out(String userName) {
		// TODO Auto-generated method stub

	}

}
