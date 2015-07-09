package ru.dataarmor.chat.test.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

public class ChatController {

	private ChatViewer chatViewer;

	private final ClientFactory clientFactory;

	/**
	 * Контроллер
	 */
	public ChatController(ClientFactory user) {
		clientFactory = user;
	}

	public void sendMessage(String message) {
		message.replaceAll("<br/>", "");
		ChatServiceAsync chatService = clientFactory.getChatService();
		chatService.sendMessage(clientFactory.getUser().getUserName(), message,
				new AsyncCallback<Void>() {

					/*
					 * (non-Javadoc)
					 * 
					 * @see
					 * com.google.gwt.user.client.rpc.AsyncCallback#onSuccess
					 * (java.lang.Object)
					 */
					@Override
					public void onSuccess(Void result) {
						if (getChatViewer() != null) {
							chatViewer.clearUserInput();
							updateMessages();
						}
					}

					/*
					 * (non-Javadoc)
					 *
					 * @see
					 * com.google.gwt.user.client.rpc.AsyncCallback#onFailure
					 * (java.lang.Throwable)
					 */
					@Override
					public void onFailure(Throwable caught) {
						if (getChatViewer() != null) {
							getChatViewer().setError(caught.getMessage());
						}
					}

				});
	}

	/**
	 * Возвращает представление для отображения чата
	 *
	 * @return представление для отображения чата
	 */
	public ChatViewer getChatViewer() {
		return chatViewer;
	}

	/**
	 * Устанавливает представление для отображения чата
	 *
	 * @param chatViewer
	 *            представление для отображения чата
	 */
	public void setChatViewer(ChatViewer chatViewer) {
		this.chatViewer = chatViewer;
	}

	public void updateMessages() {
		clientFactory.getChatService().getAllMessages(
				new AsyncCallback<String>() {

					@Override
					public void onFailure(Throwable caught) {
						chatViewer.setError(caught.getMessage());
					}

					@Override
					public void onSuccess(String result) {
						chatViewer.setMessages(result);
					}

				});
	}

}
