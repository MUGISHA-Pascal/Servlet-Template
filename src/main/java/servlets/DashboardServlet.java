package servlets;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/DashboardServlet")
public class DashboardServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if(session == null || session.getAttribute("user")==null){
            response.sendRedirect("/login.html?error=please login first");
            return;
        }
        String username = (String) session.getAttribute("user");
        Cookie[] cookies = request.getCookies();
        String userCookie = "Not Found";
            if(cookies != null){
                for(Cookie cookie : cookies){
                    if("username".equals(cookie.getName())){
                        userCookie=cookie.getValue();
                    }
                }


        }
            response.setContentType("text/html");
        response.getWriter().println("<!DOCTYPE html>");
        response.getWriter().println("<html><head><title>Dashboard</title></head><body>");
        response.getWriter().println("<h1>Welcome, " + username + "!</h1>");
        response.getWriter().println("<p>Cookie Username: " + userCookie + "</p>");
        response.getWriter().println("<a href='LogoutServlet'>Logout</a>");
        response.getWriter().println("</body></html>");
    }
}
