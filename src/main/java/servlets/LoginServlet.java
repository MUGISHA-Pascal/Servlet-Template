package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.net.http.HttpRequest;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected  void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
String username = request.getParameter("username");
String password = request.getParameter("password");
if("admin".equals(username) && "password123".equals(password)){
    HttpSession session = request.getSession();
    session.setAttribute("user",username);
    session.setMaxInactiveInterval(10*60);
    Cookie userCookie = new Cookie("username",username);
    userCookie.setMaxAge(10*60);
    response.addCookie(userCookie);
    response.sendRedirect("DashboardServlet");
}else{
    response.sendRedirect(("login.html?error=invalid credentials"));
}
    }
}
