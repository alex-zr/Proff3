package ua.kiev.prog.prog.messenger.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.entity.ContentType;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import ua.kiev.prog.prog.messenger.model.Message;

/**
 * Servlet implementation class Receiver
 */

public class Receiver extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Gson gson = new GsonBuilder().setPrettyPrinting().create();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Receiver() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	response.setContentType(ContentType.TEXT_HTML.toString());
		response.getWriter().append("Served at: ").append(request.getContextPath()).append("get");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Message message = new Gson().fromJson(request.getReader(), Message.class);
		response.setContentType(ContentType.APPLICATION_JSON.toString());
		response.getWriter().append(message.toString());
	}

}
