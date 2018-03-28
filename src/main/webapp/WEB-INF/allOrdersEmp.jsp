<%-- 
    Document   : allOrdersEmp
    Created on : 27-03-2018, 21:58:17
    Author     : Morten
--%>

<%@page import="FunctionLayer.LogicFacade"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>All Orders</title>
    </head>
    <body>
        <h1>Here is a list of all orders</h1>
        <%for (int i = 0; i < LogicFacade.getOrders().size(); i++) {
                out.print(LogicFacade.getOrders().get(i)+"<br>");}%>
                <h2>To mark an order as sent enter the order id below </h2>
        <form name="sent" action="EmpControl" method="POST">
            <input type="number" name="id" required="" placeholder="Order id" required/>            
            <input type="submit" name="btn1" value="Mark as sent"/>           
         </form>
    </body>
</html>
