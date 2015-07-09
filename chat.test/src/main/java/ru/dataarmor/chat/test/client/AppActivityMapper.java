package ru.dataarmor.chat.test.client;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;

public class AppActivityMapper implements ActivityMapper {

	private final ClientFactory clientFactory;

	public AppActivityMapper(ClientFactory clientFactory) {
		super();
		this.clientFactory = clientFactory;
	}

	@Override
	public Activity getActivity(Place place) {
		if (place instanceof LoginPlace) {
			return new LoginActivity(clientFactory);
		} else if (place instanceof ChatPlace) {
			return new ChatViewerActivity(clientFactory);
		}
		return null;
	}
}
