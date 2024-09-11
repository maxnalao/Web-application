<%-- 
    Document   : Showfood
    Created on : Sep 11, 2024, 2:36:46 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Tan.Product" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Poge</title>
    </head>
    <form action="Tanfood">
        <body>
        <html>
            <head>
                <title>Tanfood</title>
                <title>เพิ่มสินค้า</title>
            <head>
                </body>
            <form action="Tanfood" method="post">
                <h1>เพิ่มสินค้า</h1>
                <label for="Productname">ชื่อสินค้า:</label>
                <input type="text" id="Productname" name="Productname" required><br/>

                <label for="Productcount">จำนวนสินค้า:</label>
                <input type="number" id="Productcount" name="Productcount" min="1" required><br/>

                <label for="Productdate">วันที่ซื้อสินค้า (dd/mm/yyyy):</label>
                <input type="text" id="Productdate" name="Productdate" placeholder="dd/mm/yyyy" pattern="\d{2}/\d{2}/\d{4}" title="วันที่ต้องเป็นรูปแบบ dd/mm/yyyy" required><br/>

                <fieldset>
                    <legend>ช่องทางการชำระเงิน:</legend>
                    <label>
                        <input type="radio" id="P1" name="ProductPayment" value="ปลายทาง">ปลายทาง
                    </label>
                    <label>
                        <input type="radio" id="P2" name="ProductPayment" value="คิวอาโค้ด">คิวอาโค้ด
                    </label>
                    <label>
                        <input type="radio" id="P3" name="ProductPayment" value="บัตรเครดิต">บัตรเครดิต
                    </label>
                </fieldset>

                <input type="submit" value="สั่งสินค้า">
            </form>
            </body>
        </html>
