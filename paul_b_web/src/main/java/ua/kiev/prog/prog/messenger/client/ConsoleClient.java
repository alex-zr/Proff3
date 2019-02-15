package ua.kiev.prog.prog.messenger.client;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mashape.unirest.http.Unirest;

import ua.kiev.prog.prog.messenger.model.Message;

public class ConsoleClient {
	Gson gson = new GsonBuilder().setPrettyPrinting().create();
	private String clientID = "11";
	private String to = "server";
	String url = "http://localhost:8080/paul_b_web/ServletExample";
	public static void main(String[] args) {
		
		new ConsoleClient().start();
	}
	
	private void start() {
		send("Hello");
	}
	
	private void send(String text) {
		Message message = new Message(clientID, to, text);
		String json = gson.toJson(message);
		System.out.println(json);
	}
}
