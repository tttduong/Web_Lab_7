<%-- 
    Document   : account
    Created on : Nov 17, 2024, 7:56:24 PM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
    </head>
    <body>
        <h1>Please provide your account information.</h1>
        <form action="ShoppingServlet" method="post">
            <input type="hidden" name="action" value="signin"> 
            <table>
                <tr>
                    <td>
                        <label class="pad_top">Name:</label>
                    </td>
                    <td><input type="text" name="name" required></td>
                </tr>
                <tr>
                    <td><label class="pad_top">VISA Card Number:</label></td>
                    <td><input type="text" name="visa" required></td>
                </tr>
                <tr>
                    <td><label class="pad_top">Address:</label></td>
                    <td><input type="text" name="address" required></td>
                </tr>
                <tr>
                    <td><label>&nbsp;</label></td>
                    <td> <input type="submit" value="Submit" class="margin_left"></td>
                </tr>
            </table>
            
            
            
            
            
            
            
           
        </form>
    </body>
</html>
