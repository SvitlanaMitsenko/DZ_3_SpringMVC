<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 05.05.2023
  Time: 12:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title></title>
</head>
<body>
<a href="/formPage/">Back</a>
<h2 align="center">Список отправленных сообщений</h2>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h3>Сообщения</h3></caption>
        <tr>
            <th>Имя</th>
            <th>Эл.адрес</th>
            <th>Предмет</th>
            <th>Сообщение</th>
        </tr>
        <c:forEach var="message" items="${messageList}">
        <tr>
            <td><c:out value="${message.userName}" /></td>
            <td><c:out value="${message.email}" /></td>
            <td><c:out value="${message.subject}" /></td>
            <td><c:out value="${message.messageText}" /></td>
        </tr>
        </c:forEach>

</div>
</body>
</html>
