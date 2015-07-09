package ru.dataarmor.chat.test.client;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class ChatPlace extends Place {

	private static final String PLACE_NAME = "chat";

	public String getPlaceName() {
		return PLACE_NAME;
	}

	public static class Tokenizer implements PlaceTokenizer<ChatPlace> {

		@Override
		public String getToken(ChatPlace place) {
			return place.getPlaceName();
		}

		@Override
		public ChatPlace getPlace(String token) {
			return new ChatPlace();
		}
	}

}
