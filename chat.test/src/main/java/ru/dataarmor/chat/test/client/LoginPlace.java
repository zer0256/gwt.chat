package ru.dataarmor.chat.test.client;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class LoginPlace extends Place {

	private static final String PLACE_NAME = "login";

	public String getPlaceName() {
		return PLACE_NAME;
	}

	public static class Tokenizer implements PlaceTokenizer<LoginPlace> {

		@Override
		public String getToken(LoginPlace place) {
			return place.getPlaceName();
		}

		@Override
		public LoginPlace getPlace(String token) {
			return new LoginPlace();
		}
	}

}
