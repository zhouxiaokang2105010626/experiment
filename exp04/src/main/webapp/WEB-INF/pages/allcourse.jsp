<%--
  Created by IntelliJ IDEA.
  User: 23222
  Date: 2023/4/4
  Time: 19:05
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>课程展示页面</title>
</head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">
<body>
<div class="container">
    <div class="row clearfix">
        <h1 align="center">校级课程管理</h1><hr />
        <div>
            <div class="col-md-4">
                <button type="button" class="btn btn-primary">
                    <a href="${pageContext.request.contextPath}/course/toAddCourse" style="color: black;text-decoration-line: none">添加课程</a>
                </button>
                <button type="button" class="btn btn-primary" >
                    <a href="${pageContext.request.contextPath}/course/allcourse" style="color: black;text-decoration-line: none">显示全部课程</a>
                </button>
                <form class="form-inline" action="/course/querycoursename" method="post" style="float: right"
                    <sapn stytle="color:red ;font-weight:bold">${error}</sapn>
                    <input type="text" class="form-control" placeholder="课程名称" name="name" required>
                    <input type="submit" class="btn btn-primary" value="提交">
                </form>

            </div>
            <div class="row clearfix">
                <table class="table table-hover table-striped">
                    <thead>
                    <tr>
                        <td>课程编号</td>
                        <td>课程名</td>
                        <td>课时数</td>
                        <td>开课学院</td>
                        <td>操作</td>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="course" items="${list}">
                        <tr>
                            <td>${course.id}</td>
                            <td>${course.name}</td>
                            <td>${course.hours}</td>
                            <td>${course.school}</td>
                            <td>
                                <a href="${pageContext.request.contextPath}/course/toupdate?id=${course.id}">更新</a>
                                &nbsp;丨&nbsp;
                                <a href="${pageContext.request.contextPath}/course/deletecourse/${course.id}">删除</a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</body>
</html>

