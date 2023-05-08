<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><meta charset="utf-8" /></head>
<body>
<h2>Привіт Spring MVC!</h2>
<form:form method = "GET" action = "/redirectToForm">
<%--    <table>--%>
<%--        <tr>--%>
<%--            <td>--%>
                <input type = "submit" value = "Перейти до форми"/>
<%--            </td>--%>
<%--        </tr>--%>
<%--    </table>--%>
</form:form>
</body>
</html>
