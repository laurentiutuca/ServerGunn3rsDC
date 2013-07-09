package com.gunn3rs.serverapi;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import com.gunn3rs.Factories.ClientConnectionFactory;
import com.gunn3rs.client.Client;
import com.gunn3rs.serverapiinterface.IServer;

public class Server implements IServer, Runnable {
	
	private static final ClientConnectionFactory ccf = new ClientConnectionFactory();

	private ServerSocket servSock = null;
	private ArrayList<Client> clients = null;

	public Server() throws IOException {
		servSock = new ServerSocket(10001);
		clients = new ArrayList<Client>();
	}

	@Override
	public void run() {
		while (true) {
			try {
				Socket newConnection = servSock.accept();
				ccf.getNewInstance(newConnection,this).run();
			} catch (IOException e) {
				System.err
						.println("Some error occured in listening on server socket");
				e.printStackTrace();
			}
		}

	}

	/**
	 * @return the servSock
	 */
	public ServerSocket getServSock() {
		return servSock;
	}

	/**
	 * @param servSock the servSock to set
	 */
	public void setServSock(ServerSocket servSock) {
		this.servSock = servSock;
	}

	/**
	 * @return the clients
	 */
	public ArrayList<Client> getClients() {
		return clients;
	}

	/**
	 * @param clients the clients to set
	 */
	public void setClients(ArrayList<Client> clients) {
		this.clients = clients;
	}

}
