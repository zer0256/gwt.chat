/**
 *
 */
package ru.dataarmor.chat.test.client;

import com.smartgwt.client.types.Overflow;
import com.smartgwt.client.widgets.HTMLPane;
import com.smartgwt.client.widgets.RichTextEditor;
import com.smartgwt.client.widgets.events.KeyPressEvent;
import com.smartgwt.client.widgets.events.KeyPressHandler;
import com.smartgwt.client.widgets.layout.VLayout;

/**
 *
 */
public class ChatViewerImpl extends VLayout implements ChatViewer {

	private Presenter presenter;

	private final ChatController controller;

	private RichTextEditor richTextEditor;

	private HTMLPane htmlPane;

	public ChatViewerImpl(ChatController controller) {
		super();
		setMargin(0);
		this.controller = controller;
		createControls();
	}

	private void createControls() {
		htmlPane = new HTMLPane();
		htmlPane.setWidth100();
		htmlPane.setHeight("70%");
		htmlPane.setShowEdges(true);

		richTextEditor = new RichTextEditor();
		richTextEditor.setHeight("30%");
		richTextEditor.setOverflow(Overflow.HIDDEN);
		richTextEditor.setCanDragResize(true);
		richTextEditor.setShowEdges(true);
		richTextEditor.setWidth100();

		richTextEditor.setValue("Привет!");

		richTextEditor.addKeyPressHandler(new KeyPressHandler() {

			@Override
			public void onKeyPress(KeyPressEvent event) {
				if ("Enter".equals(event.getKeyName())) {
					handleSendMessage(richTextEditor.getValue());
				}
			}
		});

		addMember(htmlPane);
		addMember(richTextEditor);
	}

	private void handleSendMessage(String message) {
		controller.sendMessage(message);
	}

	@Override
	public void setError(String error) {

	}

	@Override
	public void clearUserInput() {
		richTextEditor.setValue("");
		richTextEditor.redraw();
	}

	@Override
	public void setMessages(String messages) {
		htmlPane.setContents(messages);
		// htmlPane.setValue(messages);
		htmlPane.redraw();
	}

	@Override
	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}

}
