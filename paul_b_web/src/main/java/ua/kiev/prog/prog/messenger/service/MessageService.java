package ua.kiev.prog.prog.messenger.service;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ua.kiev.prog.prog.messenger.model.Message;

public class MessageService {

    //	private static List<List<Message>> messages = new List();
    private static Map<String, List<Message>> messages = new HashMap<>();
    private static Map<String, List<Message>> messagesQueue = new HashMap<>();


    private static MessageService instance;

    public static MessageService getMessageService() {
        if (instance == null) {
            instance = new MessageService();
        }
        return instance;
    }

    private MessageService() {
    }


    public synchronized void receive(Message message) {
        if (!messagesQueue.containsKey(message.getTo())) {
            messagesQueue.put(message.getTo(), new ArrayList<Message>());
            messages.put(message.getTo(), new ArrayList<Message>());
        }
        messagesQueue.get(message.getTo()).add(message);
    }

    public List<Message> deliver(String login) {
        if (messagesQueue.containsKey(login)) {
            return messagesQueue.get(login);
        } else {
            return new ArrayList<>();
        }
    }

}
