package ua.kiev.prog.prog.messenger.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Message {
	private static 	Gson gson = new GsonBuilder().setPrettyPrinting().create();
	private	String from;
	private	String to;
	private	String text;
	
	public Message(String from, String to, String text) {
		this.from = from;
		this.to = to;
		this.text = text;
	}

	
	
	public String getFrom() {
		return from;
	}



	public String getTo() {
		return to;
	}



	public String getText() {
		return text;
	}

	@Override
	public String toString() {
		return gson.toJson(this);
	}
}
