package ru.dataarmor.chat.test.client;

import ru.dataarmor.chat.test.shared.User;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

public class LoginActivity extends AbstractActivity implements
		LoginViewer.Presenter {

	private final ClientFactory clientFactory;

	private LoginViewer loginViewer;

	public LoginActivity(ClientFactory clientFactory) {
		this.clientFactory = clientFactory;
	}

	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		loginViewer = new LoginViewer();
		loginViewer.setPresenter(this);
		panel.setWidget(loginViewer);
	}

	@Override
	public void goTo(Place place) {
		clientFactory.getPlaceController().goTo(place);
	}

	@Override
	public void setUserName(final User user) {
		clientFactory.getChatService().login(user.getUserName(),
				new AsyncCallback<Void>() {

					@Override
					public void onSuccess(Void result) {
						clientFactory.setUser(user);
						loginViewer.hide();
						loginViewer.setVisible(false);
						goTo(new ChatPlace());
					}

					@Override
					public void onFailure(Throwable caught) {
						// TODO:
					}

				});
	}

}
