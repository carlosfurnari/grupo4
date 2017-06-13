<%--
  Created by IntelliJ IDEA.
  User: rumm
  Date: 12/06/17
  Time: 02:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Entrar</title>
</head>
<form action="login" method="post" enctype='application/json'>
    <table>
        <tr>
            <td>User</td>
            <td><input name="username" /></td>
        </tr>
        <tr>
            <td>password</td>
            <td><input name="password" /></td>
        </tr>
    </table>
    <input type="submit" />
</form>
</html>
