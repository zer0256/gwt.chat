package ru.dataarmor.chat.test.client;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

public class ChatViewerActivity extends AbstractActivity implements
		ChatViewer.Presenter {

	private final ClientFactory userInfoProvider;

	public ChatViewerActivity(ClientFactory userInfoProvider) {
		this.userInfoProvider = userInfoProvider;
	}

	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		ChatController controller = new ChatController(userInfoProvider);
		ChatViewerImpl viewer = new ChatViewerImpl(controller);
		controller.setChatViewer(viewer);
		viewer.setWidth100();
		viewer.setHeight100();
		panel.setWidget(viewer);
	}

	@Override
	public void goTo(Place place) {
		userInfoProvider.getPlaceController().goTo(place);
	}

}
