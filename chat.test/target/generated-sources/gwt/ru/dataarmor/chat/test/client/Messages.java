package ru.dataarmor.chat.test.client;

/**
 * Interface to represent the messages contained in resource bundle:
 * 	/home/zer0/gwt/chat.test/src/main/resources/ru/dataarmor/chat/test/client/Messages.properties'.
 */
public interface Messages extends com.google.gwt.i18n.client.Messages {
  
  /**
   * Translated "Enter your name".
   * 
   * @return translated "Enter your name"
   */
  @DefaultMessage("Enter your name")
  @Key("nameField")
  String nameField();

  /**
   * Translated "Send".
   * 
   * @return translated "Send"
   */
  @DefaultMessage("Send")
  @Key("sendButton")
  String sendButton();
}
