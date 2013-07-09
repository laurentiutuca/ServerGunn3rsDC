package com.gunn3rs.Factories;

import java.net.Socket;

import com.gunn3rs.clientconnection.ClientConnection;
import com.gunn3rs.serverapiinterface.IServer;

public class ClientConnectionFactory {
	
	public ClientConnection getNewInstance(Socket sock,IServer server){
		return new ClientConnection(sock,server);
	}

}
