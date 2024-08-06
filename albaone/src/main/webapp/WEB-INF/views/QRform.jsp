<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.time.LocalDate" %>
<%@ page import="java.time.LocalTime" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>QR 출퇴근</title>
</head>
<body>
    <h1>QR 출퇴근</h1>
    <form action="QRcreate" method="post" modelAttribute="QR">
        <p>알바생명 : <input type="text" name="id"></p>
        <%
            LocalDate currentDate = LocalDate.now();
            LocalTime currentTime = LocalTime.now();
            
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
            
            String formattedDate = currentDate.format(dateFormatter);
            String formattedTime = currentTime.format(timeFormatter);
        %>
        <input type="hidden" name="today" value="<%= formattedDate %>">
        <input type="hidden" name="currentTime" value="<%= formattedTime %>">
        <p><input type="submit" value="QR 생성"></p>
    </form>
</body>
</html>
