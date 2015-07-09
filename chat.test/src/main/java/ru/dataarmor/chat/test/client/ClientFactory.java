package ru.dataarmor.chat.test.client;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.PlaceController;

public interface ClientFactory extends UserInfoProvider {

	PlaceController getPlaceController();

	ChatViewer getHelloView();

	LoginViewer getLoginView();

	EventBus getEventBus();

	ChatServiceAsync getChatService();

}
