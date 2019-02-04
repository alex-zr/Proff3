package ua.kiev.prog.prog.messenger.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Message {
	private static 	Gson gson = new GsonBuilder().setPrettyPrinting().create();
	private	int from;
	private	int to;
	private	String text;
	
	public Message(int from, int to, String text) {
		this.from = from;
		this.to = to;
		this.text = text;
	}

	public int getFrom() {
		return from;
	}

	public int getTo() {
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
