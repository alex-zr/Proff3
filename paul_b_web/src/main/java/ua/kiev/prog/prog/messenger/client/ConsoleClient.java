package ua.kiev.prog.prog.messenger.client;

import java.awt.peer.SystemTrayPeer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import ua.kiev.prog.prog.messenger.model.Message;
import ua.kiev.prog.prog.messenger.model.Packet;

public class ConsoleClient {
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private String login = "11";
    private String to = "server";
    String url = "http://localhost:8080/paul_b_web/MessageController";

    List<UUID> receicedUuids = new ArrayList<>();

    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        new ConsoleClient().start();
    }

    private void start() {
        send("Hello");

        System.out.println("Enter your login: ");
        login = scanner.nextLine();
//        Thread th = new Thread(new GetThread());
        Thread senderThread = new Thread(this::run);// () -> {}
        Thread receiverThread = new Thread(this::receive);// () -> {}
        try {
            receiverThread.setDaemon(true);
            receiverThread.start();

            senderThread.setDaemon(true);

            senderThread.start();
            senderThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private void run() {

        try {
            System.out.println("Enter your message: ");
            while (true) {
                String text = scanner.nextLine();

                System.out.println(text);
                if (text.equals("ex"))
                    break;
                int res = send(text);
                if (res != 200) { // 200 OK
                    System.out.println("HTTP error occured: " + res + " ");
                    return;
                }
            }
        } finally {
            scanner.close();
        }
    }

    private int send(String text) {
        Message message = new Message(login, to, text);
        String json = gson.toJson(message);

        Packet packet = new Packet(login, new Message[]{message}, new UUID[]{});

        try {
            HttpResponse<String> response = Unirest.post(url).header("Content-Type", "application/json").body(packet)
                    .asString();
            return response.getStatus();
        } catch (UnirestException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return 0;
        }
    }

    private void receiveOnce() {
        try {
            Packet packet = new Packet(login, new Message[0], receicedUuids.toArray(new UUID[0]));
            HttpResponse<String> response = Unirest.post(url).header("Content-Type", "application/json")
                    .body(gson.toJson(packet))
                    .asString();

            int responceStatus = response.getStatus();
            if (responceStatus != 200) {
                System.out.println("Not received. Status: " + responceStatus);
                return;
            }

            Message[] messages = gson.fromJson(response.getBody(), Message[].class);
            for (Message m : messages) {
                System.out.println(m.getFrom() + ": " + m.getText());
                receicedUuids.add(m.getUuid());
            }
        } catch (UnirestException e) {
            e.printStackTrace();
        }
    }

    private void receive() {
        while (!Thread.interrupted()) {
            try {
                receiveOnce();
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

}
