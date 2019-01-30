package ua.kiev.prog.prog.messenger.service;

import ua.kiev.prog.prog.messenger.model.Message;

public class MessageService {
	
	private static MessageService instance;
	public static MessageService getMessageService() {
		if (instance == null) {
			instance = new MessageService();
		}
		return instance;
	}
	
	private MessageService() {
	}


	public void receive(Message message) {
		
	}
}
