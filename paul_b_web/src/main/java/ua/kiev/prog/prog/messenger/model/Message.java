package ua.kiev.prog.prog.messenger.model;

import java.time.LocalDateTime;
import java.util.UUID;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Message {
	private static 	Gson gson = new GsonBuilder().setPrettyPrinting().create();
	private	String from;
	private	String to;
	private	String text;
	
	private final UUID uuid = UUID.randomUUID();
	private final LocalDateTime dateTime = LocalDateTime.now();
	
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

	public UUID getUuid() {
		return uuid;
	}



	public LocalDateTime getDateTime() {
		return dateTime;
	}
	
}
