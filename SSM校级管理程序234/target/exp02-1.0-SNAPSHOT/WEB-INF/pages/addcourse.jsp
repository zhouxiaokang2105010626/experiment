<%--
  Created by IntelliJ IDEA.
  User: 23222
  Date: 2023/4/4
  Time: 20:30
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">
</head>
<body>
<form action="${pageContext.request.contextPath}/course/addcourse" method="post"enctype="multipart/form-data">

    <div class="container">
        <h1>新增课程表单</h1>
        <hr />
        <div class="form-group">
            <span class="input-group-addon">课程</span>
            <input type="text" class="form-control" name="name" required>
        </div>
        <div class="form-group">
            <span class="input-group-addon">学时</span>
            <input type="text" class="form-control"  name="hours" required>
        </div>
        <div class="form-group">
            <label>课程封面</label><br>
            <input type="file" name="file">
        </div>
        <div class="form-group">
            <label>学院</label>
            <select name="school" class="form-control">
                <option value="计算机学院">计算机学院</option>
                <option value="外国语学院">外国语学院</option>
                <option value="马克思学院">马克思学院</option>
                <option value="商学院">商学院</option>
            </select>
        </div>
        <input type="submit" class="btn btn-primary" value="OK">
        <input type="reset" class="btn btn-primary" value="Cancel">
    </div>

</form>
</body>
</html>
