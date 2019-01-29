package ua.kiev.prog;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "HelloServlet", urlPatterns = "/hello")
public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session != null){
            Object userId = session.getAttribute("userId");
        }else{
            String nameParam = request.getParameter("login");
            String passParam = request.getParameter("password");
        }
        String nameParas = request.getParameter("login");
        String passParam = request.getParameter("password");

        request.getSession();
        session.setAttribute("useId", 13);

        request.setAttribute("userName", "Goron");
        //request.getRequestDispatcher("/index.jsp").forward();


        response.getWriter().print(nameParas = ": " + passParam);

    }
}
