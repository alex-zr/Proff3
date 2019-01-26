package ua.kiev.prog;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AnketaServlet", urlPatterns = "/anketa")
public class AnketaServlet extends HttpServlet {


    static final int QUESTION_1_YES = 0;
    static final int QUESTION_1_NO = 1;

    static final int QUESTION_2_YES = 2;
    static final int QUESTION_2_NO = 3;

    static final String TEMPLATE = "<html>" +
            "<head><title>Prog.kiev.ua</title></head>" +
            "<body><h1>%s</h1></body></html>";

    final int[] results = new int[4];

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        final String q1 = request.getParameter("question1");
        final String q2 = request.getParameter("question2");

        final int idx1 = "yes".equals(q1) ? QUESTION_1_YES : QUESTION_1_NO;
        final int idx2 = "yes".equals(q2) ? QUESTION_2_YES : QUESTION_2_NO;

        results[idx1]++;
        results[idx2]++;

        String res = "<p> Question 1: yes = " + results[QUESTION_1_YES] + ", no =  " + results[QUESTION_1_NO] + "</p>";
        res += "<p>Question 2: yes = " + results[QUESTION_2_YES] + ", no =  " + results[QUESTION_2_NO] + "</p>";

        response.setContentType("text/html");
        response.getWriter().println(String.format(TEMPLATE, res));


    }
}
