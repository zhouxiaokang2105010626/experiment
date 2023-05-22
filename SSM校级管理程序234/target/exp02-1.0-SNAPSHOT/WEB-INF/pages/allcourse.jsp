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
<script src="https://cdn.staticfile.org/jquery/3.6.0/jquery.min.js"></script>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">
<body>



<div class="container">
    <div class="row clearfix">
        <h1 align="center">校级课程管理</h1><hr />
        <div>
            <div>
                <form class="form-inline" action="/course/querycoursename" method="post">
                <sapn stytle="color:red ;font-weight:bold">${error}</sapn>
                <input type="text" class="form-control" placeholder="课程名称" name="name" required>
                <input type="submit" class="btn btn-primary" value="提交">
                <button type="button" class="btn btn-primary">
                    <a href="${pageContext.request.contextPath}/course/toAddCourse" style="color: white;text-decoration-line: none">添加课程</a>
                </button>
                <span style="float: right;">用户名：${USER_SESSION.email}， <a href="${pageContext.request.contextPath}/course/login">退出</a></span>
                </form>

            </div>
            <div class="row clearfix">
                <table class="table table-hover table-striped">
                    <thead>
                    <tr>
                        <td>课程编号</td>
                        <td>课程名</td>
                        <td>课时数</td>
                        <td>课程封面</td>
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
                            <td><img style="width: 100px"; height="100px" src="${pageContext.request.contextPath}/images1/${course.getImg()}"></td>
                            <td>${course.school}</td>
                            <td>
                                <a href="${pageContext.request.contextPath}/course/toupdate?id=${course.id}">更新</a>
                                &nbsp;丨&nbsp;
                                <a href="${pageContext.request.contextPath}/course/deletecourse/${course.id}" class="delete-link">删除</a>

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


<!-- JavaScript 代码 -->
<script>
    $(function() {
        // 给所有删除链接绑定点击事件
        $('a.delete-link').on('click', function(event) {
            // 阻止默认事件（即跳转操作）
            event.preventDefault();

            // 弹出对话框，提示用户确认是否要删除该课程
            let confirmDelete = confirm('确认要删除课程吗？');

            // 根据用户的选择，执行删除操作或者不做任何操作
            if (confirmDelete) {
                // 发送 DELETE 请求，以删除该课程
                location.href = $(this).attr('href');
            } else {

            }
        });
    });
</script>
