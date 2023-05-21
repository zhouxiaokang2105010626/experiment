<%--
  Created by IntelliJ IDEA.
  User: 23222
  Date: 2023/4/4
  Time: 19:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>首页</title>
    <style>
        a{
            text-decoration: none;
            color: white;
            font-size: 18px;
        }
        h3{

            height: 38px;
            margin: 100px auto;
            text-align: center;
            line-height: 38px;
            background: mediumpurple;
            border-radius:5px;
        }
    </style>
</head>
<body>
<h3>
    <a href="${pageContext.request.contextPath}/course/allcourse">WELCOME TO STUMANAGEMENT</a>
</h3>
</body>
</html>
