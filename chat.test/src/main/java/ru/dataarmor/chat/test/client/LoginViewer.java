package ru.dataarmor.chat.test.client;

import ru.dataarmor.chat.test.shared.User;

import com.google.gwt.place.shared.Place;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.ButtonItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.events.ClickEvent;
import com.smartgwt.client.widgets.form.fields.events.ClickHandler;
import com.smartgwt.client.widgets.layout.VLayout;

public class LoginViewer extends VLayout {

	private Presenter presenter;

	public LoginViewer() {
		final DynamicForm form = new DynamicForm();
		form.setAutoFocus(true);
		form.setNumCols(3);
		form.setWidth(300);

		final TextItem firstName = new TextItem("userName");
		firstName.setTitle("Enter user name");
		firstName.setSelectOnFocus(true);
		firstName.setWrapTitle(false);
		firstName.setDefaultValue("Hodor");

		ButtonItem button = new ButtonItem("login", "Login");
		button.setStartRow(false);
		button.setWidth(80);
		button.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				presenter.setUserName(new User((String) firstName.getValue()));
			}

		});
		form.setFields(firstName, button);

		form.draw();
	}

	public interface Presenter {
		void goTo(Place place);

		void setUserName(User userName);

	}

	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}

}
