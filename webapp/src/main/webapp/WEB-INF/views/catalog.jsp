<%@ page import="ru.ryabtsev.enterprise.entity.Product" %>
<%@ page import="java.util.Collection" %>
<%@ page import="ru.ryabtsev.enterprise.field.FieldKeys" %><%--
  Created by IntelliJ IDEA.
  User: ryabtsev
  Date: 1/12/19
  Time: 1:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>
        table, th, td {
            border: 1px solid black;
            border-collapse: collapse;
            padding: 15px
        }

        table#t01, th#t01, td#t01 {
            border: none;
            padding: 15px
        }

        table#t01 th {
            border: none;
        }

        table#t01 td {
            border: none;
        }
    </style>
    <title>Products Catalog</title>
</head>
<body>
<h1>Products catalog</h1>

<table>
    <tbody>
    <%
        final Object productsObject = request.getAttribute(FieldKeys.PRODUCTS);
        final Collection<Product> products = (Collection<Product>)productsObject;
        int index = 1;
        for(final Product product: products) {
    %>
        <tr>
            <td align = "center"><%=index%>.</td>
            <td align = "left"><%=product.getName()%></td>
            <td align = "left"><%=product.getPrice()%></td>
            <td align = "left"><%=(product.getDescription() == null) ? "" : product.getDescription()%></td>
        </tr>
    <%
            ++index;
        }
    %>
    </tbody>
</table>

<p>Move to another site pages</p>
<table id="t01">
    <tbody>
        <tr>
            <td><a href="index">Main page</a></td>
            <td><a href="cart">Cart</a></td>
            <td><a href="order">Order</a></td>
            <td><a href="product">Product</a></td>
        </tr>
    </tbody>
</table>
</body>
</html>
