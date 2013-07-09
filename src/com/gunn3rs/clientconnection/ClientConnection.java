package com.gunn3rs.clientconnection;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import com.gunn3rs.client.Client;
import com.gunn3rs.client.ClientServerRequest;
import com.gunn3rs.client.RequestType;
import com.gunn3rs.clientconnectioninterface.IClientConnection;
import com.gunn3rs.serverapi.Server;
import com.gunn3rs.serverapiinterface.IServer;

public class ClientConnection implements IClientConnection, Runnable {

	Client client = null;
	Socket clientSocket;
	ObjectInputStream ois = null;
	ObjectOutputStream oos = null;
	IServer server;

	public ClientConnection(Socket clientSocket, IServer server) {
		this.clientSocket = clientSocket;
		this.server = server;
	}

	@Override
	public void run() {
		try {
			oos = new ObjectOutputStream(clientSocket.getOutputStream());
			oos.flush();
			ois = new ObjectInputStream(clientSocket.getInputStream());
		} catch (IOException e) {
			System.err.println("Error in \"out\" or in \"in\" stream");
			e.printStackTrace();
			return;
		}

		try {
			ClientServerRequest csr = (ClientServerRequest) ois.readObject();
			if (csr.getReqType() != RequestType.CONNECT) {
				System.err.println("Connection failure");
				return;
			}

			synchronized (server) {
				((Server) server).getClients().add(csr.getClient());
			}

		} catch (ClassNotFoundException | IOException e) {
			System.err.println("Problem in read from inputstream of socket");
			e.printStackTrace();
		}

	}

}
