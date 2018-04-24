package com.schoolofnet.websocket;

import com.corundumstudio.socketio.Configuration;
import com.corundumstudio.socketio.SocketIOServer;

public class App {
	public static void main(String[] args) {
		Configuration config = new Configuration();
		
		config.setHostname("127.0.0.1");
		config.setPort(9000);
		
		SocketIOServer server = new SocketIOServer(config);
		new Events(server).makeEvents();
		server.start();
	}
}
