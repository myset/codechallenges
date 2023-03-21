<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="org.springframework.format.datetime.DateFormatter" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <title>Test</title>
</head>
<body>
<%
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
    String dateString = simpleDateFormat.format(new Date());
    out.println("Server date is " + dateString);
%>
</body>
</html>