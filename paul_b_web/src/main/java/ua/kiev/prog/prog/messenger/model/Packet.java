package ua.kiev.prog.prog.messenger.model;

import java.util.UUID;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Packet {
    private static Gson gson = new GsonBuilder().setPrettyPrinting().create();
    String from;
    private Message[] messages;
    private UUID[] receivedMessages;

    public Packet(String from, Message[] messages, UUID[] receivedMessages) {
        this.from = from;
        this.messages = messages;
        this.receivedMessages = receivedMessages;
    }

    public Message[] getMessages() {
        return messages;
    }

    public UUID[] getReceivedMessages() {
        return receivedMessages;
    }

    public String getFrom() {
        return from;
    }

    @Override
    public String toString() {
        return gson.toJson(this);
    }

}
