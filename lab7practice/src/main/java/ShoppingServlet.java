/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import data.ProductDB;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import model.User;
import data.UserDB;
import java.util.List;
import model.Product;
/**
 *
 * @author Administrator
 */
@WebServlet(name="ShoppingServlet", urlPatterns={"/ShoppingServlet"})
public class ShoppingServlet extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        processRequest(request, response);
//    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
         String url = "/account.jsp";

        // get current action
        String action = request.getParameter("action");
        if (action == null) {
            action = "reload";  // default action
        }

        if (action.equals("reload")) {
            url = "/account.jsp";
        } else if (action.equals("signin")) {
            // get parameters from the request
            String name = request.getParameter("name");
            String visa = request.getParameter("visa");
            String address = request.getParameter("address");

            // store data in User object and save User object in database
            User user = new User(name, visa, address);

            if (UserDB.signin(user)) {
                
                List<Product> products = ProductDB.getAllProducts();
                request.setAttribute("products", products);

    
                // set User object in request object and set URL
                request.setAttribute("user", user);
                request.setAttribute("name", user.getName()); // Add user's name
                
                System.out.println("Signin");
                url = "/products.jsp";   // the "products" page
            } else {
                // Set error message in request object
//                String errorMessage = "No data found, login failed.";
//                request.setAttribute("errorMessage", errorMessage);
                System.out.println("No data found, login failed.");
                url = "/account.jsp"; // Redirect back to the login page
            }
        }

        // Forward the request to the selected URL
        getServletContext()
            .getRequestDispatcher(url)
            .forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
