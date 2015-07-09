package ru.dataarmor.chat.test.client;

import ru.dataarmor.chat.test.shared.User;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.place.shared.PlaceController;

public class ClientFactoryImpl implements ClientFactory {

	private User user;

	private final EventBus eventBus = new SimpleEventBus();
	private final PlaceController placeController = new PlaceController(
			eventBus);
	private final LoginViewer helloView = new LoginViewer();
	private final ChatController controller = new ChatController(this);
	private ChatViewer chatView;

	private ChatServiceAsync chatService;

	@Override
	public PlaceController getPlaceController() {
		return placeController;
	}

	@Override
	public ChatViewer getHelloView() {
		return chatView;
	}

	@Override
	public LoginViewer getLoginView() {
		return helloView;
	}

	@Override
	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public User getUser() {
		return user;
	}

	@Override
	public EventBus getEventBus() {
		return eventBus;
	}

	@Override
	public ChatServiceAsync getChatService() {
		if (chatService == null) {
			chatService = GWT.create(ChatService.class);
		}
		return chatService;
	}

}
