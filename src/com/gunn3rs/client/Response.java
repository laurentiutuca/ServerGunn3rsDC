package com.gunn3rs.client;

import java.io.Serializable;
import java.util.ArrayList;

public class Response implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ArrayList<String> clientsList = null;
	private ConfirmationType confType = ConfirmationType.DEFAULT;

	public Response(Client client,RequestType reqType) {
		switch (reqType) {
		case ACTIVE_USERS:
			clientsList = null;
			confType = ConfirmationType.USERLIST_SENT;
			break;
		case ALL_USERS:
			clientsList = null;
			confType = ConfirmationType.USERLIST_SENT;
			break;
		case CONNECT:
			confType = pendingConnection(client);
			break;
		default:
			confType = ConfirmationType.DEFAULT;
			break;
		}
	}
	
	private static ConfirmationType pendingConnection(Client client){
		return ConfirmationType.DEFAULT;
	}

}
