<%--
  Created by IntelliJ IDEA.
  User: AFTR
  Date: 17/04/2023
  Time: 8:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Session</title>
</head>
<body>
<h1>Iniciar sesión</h1>
<form action="/home/loginsession" method="post">
  <div>
    <label for="username">Username</label>
    <div>
      <input type="text" name="username" id="username">
    </div>
  </div>
  <div>
    <label for="password">Password</label>
    <div>
      <input type="password" name="password" id="password">
    </div>
  </div>
  <div>
    <input type="submit" value="Login">
  </div>
</form>
</body>
</html>
