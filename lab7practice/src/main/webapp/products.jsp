<%-- 
    Document   : products
    Created on : Nov 17, 2024, 8:02:42 PM
    Author     : Administrator
--%>

<%@page import="java.util.List"%>
<%@page import="model.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% 
            String name = (String) request.getAttribute("name");
            if (name == null) {
                name = "Guest";
            }
            
            // Lấy danh sách sản phẩm từ request
            List<Product> products = (List<Product>) request.getAttribute("products");
        %>
        <h1>Hi, <%= name %>!</h1>
        <h2>Please select your product and its quantity.</h2>
      
        <hr>
        
        <form>
            <label class="pad_top">Product:</label>
            <select name="product">
                <% 
                    if (products != null) {
                        for (Product product : products) {
                %>
                <option value="<%= product.getId() %>"><%= product.getName() %></option>
                <% 
                        }
                    } else {
                %>
                <option value="">No products available</option>
                <% 
                    } 
                %>
            </select>

            <label class="pad_top">Quantity:</label>
            <input type="num"/>
            <input type="submit" value="Add to card"/>
        </form>
       
    </body>
</html>
