package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if(session != null){
            session.invalidate();
        }
        Cookie userCookie = new Cookie("username","");
        userCookie.setMaxAge(0);
        response.addCookie(userCookie);
        response.sendRedirect("login.html?message=Logged out successfully");
    }
}
