package com.gunn3rs.client;

import java.io.Serializable;

public class Client implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int uid;
	String clientName;
	boolean isActive;
	String ipConnected;
	int portConnected;

	public Client() {
		// TODO Auto-generated constructor stub
	}
	
	public Client(String clientName){
		this.clientName = clientName;
	}

	/**
	 * @return the uid
	 */
	public int getUid() {
		return uid;
	}

	/**
	 * @param uid
	 *            the uid to set
	 */
	public void setUid(int uid) {
		this.uid = uid;
	}

	/**
	 * @return the clientName
	 */
	public String getClientName() {
		return clientName;
	}

	/**
	 * @param clientName
	 *            the clientName to set
	 */
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	/**
	 * @return the isActive
	 */
	public boolean isActive() {
		return isActive;
	}

	/**
	 * @param isActive
	 *            the isActive to set
	 */
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	/**
	 * @return the ipConnected
	 */
	public String getIpConnected() {
		return ipConnected;
	}

	/**
	 * @param ipConnected
	 *            the ipConnected to set
	 */
	public void setIpConnected(String ipConnected) {
		this.ipConnected = ipConnected;
	}

	/**
	 * @return the portConnected
	 */
	public int getPortConnected() {
		return portConnected;
	}

	/**
	 * @param portConnected
	 *            the portConnected to set
	 */
	public void setPortConnected(int portConnected) {
		this.portConnected = portConnected;
	}

	public boolean equals(Client anotherClient){
		return this.clientName.equals(anotherClient.clientName);
	}
}
