package com.gunn3rs.client;

import java.io.Serializable;

public class ClientServerRequest implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private RequestType reqType;
	private Client client;
	/**
	 * @return the reqType
	 */
	public RequestType getReqType() {
		return reqType;
	}
	/**
	 * @param reqType the reqType to set
	 */
	public void setReqType(RequestType reqType) {
		this.reqType = reqType;
	}
	/**
	 * @return the client
	 */
	public Client getClient() {
		return client;
	}
	/**
	 * @param client the client to set
	 */
	public void setClient(Client client) {
		this.client = client;
	}
	
}
