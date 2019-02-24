package ua.kiev.prog.prog.messenger.controller;

import java.io.IOException;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.MediaType;

import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;

import ua.kiev.prog.prog.messenger.model.Message;
import ua.kiev.prog.prog.messenger.model.Packet;
import ua.kiev.prog.prog.messenger.service.MessageService;

/**
 * Servlet implementation class MessageController
 */
@WebServlet("/MessageController")
public class MessageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static Gson gson = new GsonBuilder().setPrettyPrinting().create();
	private static MessageService messageService = MessageService.getMessageService();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MessageController() {
		super();
		// TODO Auto-generated constructor stub
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		response.setContentType(MediaType.TEXT_HTML);
//		String htmlString = "<h2>Hello from MessageController servlet</h2><br>";
//		response.getWriter().append(htmlString);
//		response.getWriter().append("Served at: ").append(request.getPathInfo());
		
		String login = (String) request.getAttribute("login");
		messageService.deliver(login);
		String jsonResponce = gson.toJson(messageService.deliver(login)).toString();
		
		response.getWriter().append(jsonResponce);

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String requestData = request.getReader().lines().collect(Collectors.joining());

		try {
			Packet packet = gson.fromJson(requestData, Packet.class);
			for (Message message : packet.getMessages()) {
				messageService.receive(message);
			}
			
//			response.getWriter().append(message.toString());
			
			String jsonResponse = gson.toJson(messageService.deliver(packet.getFrom()));
			response.getWriter().append(jsonResponse);
		} catch (JsonSyntaxException e) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		}
	}

}
