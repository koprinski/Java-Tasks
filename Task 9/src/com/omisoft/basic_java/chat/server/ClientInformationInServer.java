package com.omisoft.basic_java.chat.server;

import java.net.Socket;

/**
 * Class with instances for the client
 * All the information needed for the client
 * @author bkoprinski
 *
 */
class ClientInformationInServer 
{
    public Socket mSocket = null;
    public ClientMessagesReadThread mClientListener = null;
    public SendMessageThread mClientSender = null;
}
