package ru.dataarmor.chat.test.client;

import com.google.gwt.place.impl.AbstractPlaceHistoryMapper;
import ru.dataarmor.chat.test.client.AppPlaceHistoryMapper;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.impl.AbstractPlaceHistoryMapper.PrefixAndToken;
import com.google.gwt.core.client.GWT;

public class AppPlaceHistoryMapperImpl extends AbstractPlaceHistoryMapper<Void> implements AppPlaceHistoryMapper {
  
  protected PrefixAndToken getPrefixAndToken(Place newPlace) {
    if (newPlace instanceof ru.dataarmor.chat.test.client.ChatPlace) {
      ru.dataarmor.chat.test.client.ChatPlace place = (ru.dataarmor.chat.test.client.ChatPlace) newPlace;
      PlaceTokenizer<ru.dataarmor.chat.test.client.ChatPlace> t = GWT.create(ru.dataarmor.chat.test.client.ChatPlace.Tokenizer.class);
      return new PrefixAndToken("ChatPlace", t.getToken((ru.dataarmor.chat.test.client.ChatPlace) place));
    }
    if (newPlace instanceof ru.dataarmor.chat.test.client.LoginPlace) {
      ru.dataarmor.chat.test.client.LoginPlace place = (ru.dataarmor.chat.test.client.LoginPlace) newPlace;
      PlaceTokenizer<ru.dataarmor.chat.test.client.LoginPlace> t = GWT.create(ru.dataarmor.chat.test.client.LoginPlace.Tokenizer.class);
      return new PrefixAndToken("LoginPlace", t.getToken((ru.dataarmor.chat.test.client.LoginPlace) place));
    }
    return null;
  }
  
  protected PlaceTokenizer<?> getTokenizer(String prefix) {
    if ("ChatPlace".equals(prefix)) {
      return GWT.create(ru.dataarmor.chat.test.client.ChatPlace.Tokenizer.class);
    }
    if ("LoginPlace".equals(prefix)) {
      return GWT.create(ru.dataarmor.chat.test.client.LoginPlace.Tokenizer.class);
    }
    return null;
  }

}
