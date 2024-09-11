/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import Controller.DBConnection;
import Tan.Product;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/Tanfood"})
public class Tanfood extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {
            HttpSession session = request.getSession();
            Product product = (Product) session.getAttribute("product");

            boolean name = product == null;
            {
                product = new Product();
                product.setProductname(request.getParameter("Productname"));
                product.setProductcount(request.getParameter("Productcount"));
                product.setProductdate(request.getParameter("Productdate"));
                product.setProductPayment(request.getParameter("ProductPayment"));
                session.setAttribute("product", product);

                DBConnection dbConnection = new DBConnection();
                if (!dbConnection.insertNewProduct(product)) {
                    System.out.println(">>>Tanfood ERROR");
                }
                session.setAttribute("product", product);
                ServletContext sc = getServletContext();
                RequestDispatcher rd = sc.getRequestDispatcher("/addNewfood.jsp");
                rd.forward(request, response);
                // If product exists, you could implement logic to display or update product information
                //out.println("<html><body><b>Product already exists:</b> " 
                     //   + product.getProductname() + "; "
                     //   + product.getProductcount() + "; "
                      //  + product.getProductdate() + "; "
                       // + (product.getProductPayment().equals("cash") ? "Cash" : "Installment") + "<br/><br/>");
              //  out.println("<h1>Update Product Information</h1>");
              //  out.println("<form action='Tanfood' method='post'>");
               // out.println("Product Name: <input type='text' name='Productname' value='" + product.getProductname() + "'><br/>");
               // out.println("Product Count: <input type='text' name='Productcount' value='" + product.getProductcount() + "'><br/>");
               // out.println("Product Date: <input type='text' name='Productdate' value='" + product.getProductdate() + "'><br/>");
               // out.println("Payment Type: ");
              //  out.println("<input type='radio' name='ProductPayment' value='cash' " + (product.getProductPayment().equals("cash") ? "checked" : "") + "> Cash ");
                //out.println("<input type='radio' name='ProductPayment' value='installment' " + (product.getProductPayment().equals("installment") ? "checked" : "") + "> Installment <br/>");
                //out.println("<input type='submit' value='Update'>");
               // out.println("</form>");
                //session.setAttribute("product", product);
            }

        } catch (Exception e) {
            response.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = response.getWriter()) {
                out.print("<html><body>");
                out.print("Error: " + e.getMessage());
                out.print("</body></html>");
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Servlet for handling product information";
    }
}
