package ru.dataarmor.chat.test.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface ChatServiceAsync
{

    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see ru.dataarmor.chat.test.client.ChatService
     */
    void sendMessage( java.lang.String userName, java.lang.String message, AsyncCallback<Void> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see ru.dataarmor.chat.test.client.ChatService
     */
    void login( java.lang.String userName, AsyncCallback<Void> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see ru.dataarmor.chat.test.client.ChatService
     */
    void getAllMessages( AsyncCallback<java.lang.String> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see ru.dataarmor.chat.test.client.ChatService
     */
    void out( java.lang.String userName, AsyncCallback<Void> callback );


    /**
     * Utility class to get the RPC Async interface from client-side code
     */
    public static final class Util 
    { 
        private static ChatServiceAsync instance;

        public static final ChatServiceAsync getInstance()
        {
            if ( instance == null )
            {
                instance = (ChatServiceAsync) GWT.create( ChatService.class );
            }
            return instance;
        }

        private Util()
        {
            // Utility class should not be instanciated
        }
    }
}
