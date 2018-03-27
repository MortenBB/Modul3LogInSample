<%-- 
    Document   : order
    Created on : 20-03-2018, 13:41:14
    Author     : Morten
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Order</title>
    </head>
    <body>
        <h1>Place your order here</h1>
         <form name="order" action="MakeBricks" method="POST">
            <input type="number" name="length" required="" placeholder="Length" required/>
            <input type="number" name="width" required="" placeholder="Width" min="4" required/>
            <input type="number" name="height" required="" placeholder="Height" required/>
            <input type="submit" name="btn1" value="Order"/>           
         </form>
    </body>
</html>
