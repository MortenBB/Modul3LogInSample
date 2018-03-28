<%-- 
    Document   : allOrders
    Created on : 20-03-2018, 13:41:27
    Author     : Morten
--%>

<%@page import="FunctionLayer.LogicFacade"%>
<%@page import="FunctionLayer.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>All Orders</title>
    </head>
    <body>
        <h1>Here is a list of your previous orders</h1>
        <%   User u = (User) session.getAttribute("user");            
            for (int i = 0; i < LogicFacade.getOrders(u).size(); i++) {
                out.print(LogicFacade.getOrders(u).get(i) + "<br>");
            }
        %>
    </body>
</html>
