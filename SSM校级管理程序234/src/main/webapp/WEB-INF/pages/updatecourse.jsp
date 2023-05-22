<%--
  Created by IntelliJ IDEA.
  User: 23222
  Date: 2023/4/4
  Time: 20:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>更新课程</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">
</head>
<body>
<form action="${pageContext.request.contextPath}/course/updatecourse"method="post"enctype="multipart/form-data">
    <div class="container">
        <h1>编辑课程表单</h1>
        <input hidden="hidden" type="text" value=${lists.id} name="id">
        <hr />
        <div class="form-group">
            <span class="input-group-addon">课程</span>
            <input type="text" class="form-control"value=${lists.name} name="name"required>
        </div>
        <div class="form-group">
            <span class="input-group-addon" >封面</span>
            <input type="file" name="file">
        </div>

        <div class="form-group">
            <span class="input-group-addon" >课时</span>
            <input type="text" class="form-control" value=${lists.hours} name="hours" required>
        </div>

        <div class="form-group">
            <span class="input-group-addon">学院</span>
            <input type="text" class="form-control" value=${lists.school} name="school" required>
        </div>
    <input type="submit" value="提交" />
</form>
</body>
</html>

