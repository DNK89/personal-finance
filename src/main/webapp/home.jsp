<%@ page import="lv.dnk89.personalfinance.mvc.models.HomeModel" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><%= ((HomeModel)request.getAttribute("model")).getPageTitle() %></title>
</head>
<body>
    <h2><%= ((HomeModel)request.getAttribute("model")).getMenuTitle() %></h2>
</body>
</html>
