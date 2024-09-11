<%-- 
    Document   : addNewfood.jsp
    Created on : Sep 11, 2024, 2:37:04 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Tan.Product" %>

<h2>เก็บข้อมูลสำเร็จ</h2>
        <%
        Product product = (Product) session.getAttribute("product");
    %>
    ชื่อสินค้า: <%= product.getProductname() %></p>
    จำนวนสินค้า: <%= product.getProductcount() %></p>
    วันที่ซื้อสินค้า: <%= product.getProductdate() %></p>
    ช่องทางการจ่ายเงิน: <%= product.getProductPayment() %></p>
</html>

