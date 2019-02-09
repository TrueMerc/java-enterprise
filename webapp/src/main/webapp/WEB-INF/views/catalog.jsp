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
    </style>
    <title>Products Catalog</title>
</head>
<body>
<h1>Products catalog</h1>

<table>
    <tbody>
        <th>Id</th>
        <th align="center">Product name</th>
        <th align="center">Price</th>
        <th align="center">Description</th>
        <th colspan="2">Actions</th>
        <%
            final Object productsObject = request.getAttribute(FieldKeys.PRODUCTS);
            final Collection<Product> products = (Collection<Product>)productsObject;
            int index = 1;
            for(final Product category: products) {
        %>
            <tr>
                <td align = "center"><%=index%>.</td>
                <td align = "left"><%=category.getName()%></td>
                <td align = "left"><%=category.getPrice()%></td>
                <td align = "left"><%=(category.getDescription() == null) ? "" : category.getDescription()%></td>
                <td align = "center">Edit</td>
                <td align = "center">Delete</td>
            </tr>
        <%
                ++index;
            }
        %>
    </tbody>
</table>

<p></p>
<form action="category-add">
    <button type="submit" class="green">Add new category</button>
</form>

<jsp:include page="footer.jsp"/>
</body>
</html>
