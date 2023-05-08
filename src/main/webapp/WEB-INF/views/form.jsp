<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 04.05.2023
  Time: 17:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<meta http-equiv="Content-Type" content="text/html;
      charset=utf-8">
<title></title>
<head>
    <style>
        body {
            background-color: lightgray;
        }
        form {
            width: 566px;
            color: white;
            font-size: 16px;
            font-family: sans-serif;
            margin: auto;
            overflow: hidden;
            margin-top: 40px;
        }
        .left_col {
            background-color: #333;
            width: 400px;
            padding: 20px 20px 70px 20px;
            float: left;
            border: 2px solid white;
            border-left: none;
        }
        .right_col {
            transform: rotate(270deg);
            width: 115px;
            height: 35px;
            float: left;
            background-color: #333;
            text-align: center;
            line-height: 35px;
            margin-top: 120px;
            position: relative;
            left: -43px;
            border: 2px solid white;
            border-top: none;
            font-size: 20px;
        }
        .dop_div {
            margin: 0 10px;
        }
        input, select, textarea {
            width: 100%;
            margin-bottom: 15px;
            padding: 10px;
            position: relative;
            font-size: 16px;
        }
        input, textarea {
            left: -10px;
        }
        input[type="submit"] {
            background-color: #6FB03A;
            font-weight: bold;
            color: white;
            font-size: 14px;
            letter-spacing: 1px;
            border: none;
        }
        .f2 {
            margin-top: 5px;
        }
        #hidden {
            width: 100px;
            height: 80px;
            padding: 0 285px 0 285px;
            text-align: center;
            color: green;
            font-weight: bold;
            display: none;
            font-size: 14pt;
        }
    </style>

    <script type="text/javascript">
        //  let d = new Date();
        //  alert("Today's date is " + d);

        function setSendingResult() {
            var obj = document.getElementById('hidden');
            //if ((Boolean)("${sendingResult}") == true) {
            if ("${sendingResult}" == "true") {
                obj.innerHTML = "Сообщение успешно отправлено!";
                obj.style.display = "inline";
                obj.style.color = "green";
                obj.style.backfround = "blue";
            } else {
                //obj.innerHTML = "Что-то пошло не так!";
                obj.style.display = "none";
                obj.style.color = "red";
            }
        }
        window.onload = setSendingResult;

        function hideMessageResult() {
            var obj = document.getElementById('hidden');
            obj.style.display = "none";
        }
    </script>
</head>
<body>
<form method="POST" action="/formPage" modelAttribute="${message}" accept-charset="utf-8" onClick="hideMessageResult()"
      contentType="text/html;charset=UTF-8">
    <div class="left_col">

        <%--@declare id="name"--%><%--@declare id="email"--%><%--@declare id="subject"--%><%--@declare id="message"--%><%--@declare id="submit"--%><label
            for="name">Имя&nbsp;<span style="color:green;">*</span></label><br/>
        <div class="dop_div"><input name="userName" type="text" onClick="hideMessageResult()"/></div>

        <label for="email">Ваш Email&nbsp;<span style="color:green;">*</span></label>
        <div class="dop_div"><input name="email" type="email"/></div>

        <label for="subject">Тема</label><br/>
        <select name="subject">
            <option>Техподдержка</option>
            <option>Жалоба</option>
            <option>Другое</option>
        </select><br/>

        <label for="message">Ваше сообщение</label><br/>
        <div class="dop_div"><textarea cols="70" , rows="6" name="messageText"></textarea></div>

        <label for="submit">Отправить</label><br/>
        <div class="dop_div"><input name="submit" type="submit" value="Отправить"/></div>
        <div> Пожалуйста, не стесняйтесь обращаться к нам, мы обязательно ответим на Ваше сообщение</div>
    </div>
    <div class="right_col">contact</div>

</form>
<div id="hidden" bgcolor="blue"></div>
<form method="GET" action="/redirectToList" class="f2">
    <table>
        <tr>
            <td> Количество отправленных сообщений = ${messageNumb}   </td>
        </tr>
        <tr>
            <td><input type="submit" value="Показать список" bgcolor="blue"/></td>
        </tr>
    </table>
</form>
</body>
</html>