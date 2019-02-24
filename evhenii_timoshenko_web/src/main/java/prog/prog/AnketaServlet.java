package prog.prog;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "AnketaServlet", urlPatterns = "/anketa")
public class AnketaServlet extends HttpServlet {
    static final int QUESTION_1_YES = 0;
    static final int QUESTION_1_NO = 1;
    static final int QUESTION_2_YES = 2;
    static final int QUESTION_2_NO = 3;
    static final int QUESTION_3_YES = 4;
    static final int QUESTION_3_NO = 5;
    final int[] results = new int[8];

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        final String q1 = request.getParameter("question1");
        final String q2 = request.getParameter("question2");
        final String q3 = request.getParameter("question3");

        final int idx1 = "yes".equals(q1) ? QUESTION_1_YES : QUESTION_1_NO;
        final int idx2 = "yes".equals(q2) ? QUESTION_2_YES : QUESTION_2_NO;
        final int idx3 = "yes".equals(q3) ? QUESTION_3_YES : QUESTION_3_NO;


        results[idx1]++;
        results[idx2]++;
        results[idx3]++;

        request.getRequestDispatcher("/statistic.jsp").forward(request, response);
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("/statistic.jsp").forward(request, response);
    }

    }