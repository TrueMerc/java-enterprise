<%--
  Created by IntelliJ IDEA.
  User: ryabtsev
  Date: 1/12/19
  Time: 3:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New product description</title>
</head>
    <form action="product-add" method="post">
        <table border="0" align="left" cellpadding="5">
            <tr>
                <td>Name:</td>
                <td>
                    <input type="text" name="nameField" value=""/>
                </td>
            </tr>
            <tr>
                <td>Price:</td>
                <td>
                    <input type="number" step="0.01" name="priceField" value="0.0"/>
                </td>
            </tr>
            <tr>
                <td>Description:</td>
                <td>
                    <input type="text" name="descriptionField" value=""/>
                </td>
            </tr>
            <tr>
                <td>
                    <button name="result" type="submit" value="1">Save</button>
                    <button name="result" type="submit" value="0">Cancel</button>
                </td>
            </tr>
        </table>
    </form>
</body>
</html>
