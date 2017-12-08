<%@ page import="lv.dnk89.personalfinance.mvc.models.HomeModel" %>
<%@ page import="lv.dnk89.personalfinance.mvc.models.MainMenuItem" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><%= ((HomeModel)request.getAttribute("model")).getPageTitle() %></title>
</head>
<body>
    <h2><%= ((HomeModel)request.getAttribute("model")).getMenuTitle() %></h2>
    <ol>
        <%for (MainMenuItem item: ((HomeModel)request.getAttribute("model")).getMenuItems()) { %>
        <li><a href="<%= item.getLink() %>"><%= item.getText() %></a></li>
        <% } %>
    </ol>
</body>
</html>
