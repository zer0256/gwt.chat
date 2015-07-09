package ru.dataarmor.chat.test.client;

import com.google.gwt.place.shared.Place;

public interface ChatViewer {

	void setError(String error);

	void clearUserInput();

	void setMessages(String messages);

	void setPresenter(Presenter presenter);

	public interface Presenter {
		void goTo(Place place);
	}

}
