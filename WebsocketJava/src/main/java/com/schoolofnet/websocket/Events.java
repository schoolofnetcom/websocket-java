package com.schoolofnet.websocket;

import com.corundumstudio.socketio.SocketIOServer;
import com.schoolofnet.websocket.model.Chat;

public class Events {
	private SocketIOServer server;
	
	public Events(SocketIOServer server) {
		this.server = server;
	}
	
	public void makeEvents() {
		this.server.addEventListener(EnumEvents.SEND_MESSAGE.toString(), Chat.class, (client, data, ackRequest) -> {
			server.getBroadcastOperations().sendEvent(EnumEvents.SEND_MESSAGE.toString(), data);
		});		
		
		this.server.addEventListener(EnumEvents.CHANGE_USER.toString(), Chat.class, (client, data, ackRequest) -> {
			data.setUser(data.getUser());
			client.sendEvent(EnumEvents.CHANGE_USER.toString(), data);
			
		});		
		
//		this.server.addEventListener(EnumEvents.SEND_MESSAGE.toString(), Chat.class, new DataListener<Chat>() {
//			@Override
//			public void onData(SocketIOClient client, Chat data, AckRequest ackRequest) {
//				System.out.println(data.getMessage());
//			}
//		});
	}
}
