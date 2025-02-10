<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Dashboard</title>
</head>
<body>
    <h1>Welcome to Your Dashboard</h1>

    <c:if test="${not empty sessionScope.user}">
        <p>Welcome, ${sessionScope.user}!</p>
        <p>Your session is active. If you wish to logout, click the button below.</p>
    </c:if>

    <c:if test="${empty sessionScope.user}">
        <p>You are not logged in. Please <a href="login.jsp">log in</a> first.</p>
    </c:if>

    <form action="LogoutServlet" method="get">
        <input type="submit" value="Logout">
    </form>
</body>
</html>
