<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户登录</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="style.css">
    <style>
        * {
            box-sizing: border-box;
        }
        body {
            font-family: 'Oswald', sans-serif;
            background-color: #f8f9fa;
            margin: 80px 0;
        }
        h2 {
            text-align: center;
            margin-bottom: 20px;
            font-size: 36px;
            font-weight: bold;
            color: #495057;
        }
        form {
            display: flex;
            flex-direction: column;
            align-items: center;
            background-color: #fff;
            padding: 30px;
            margin: 0 auto;
            max-width: 400px;
            border-radius: 10px;
            box-shadow: 0 3px 6px rgba(0, 0, 0, 0.1);
        }
        label {
            margin-bottom: 5px;
            font-weight: bold;
            color: #495057;
        }
        input[type="text"],
        input[type="password"] {
            padding: 10px;
            width: 100%;
            margin-bottom: 15px;
            border-radius: 5px;
            border: none;
            background-color: #f8f9fa;
            box-shadow: inset 0 1px 2px rgba(0, 0, 0, 0.18);
        }
        input[type="submit"] {
            background-color: #0062cc;
            color: #fff;
            font-weight: bold;
            cursor: pointer;
            transition: background-color 0.2s ease-in-out;
            border: none;
            border-radius: 5px;
            padding: 12px;
            width: 100%;
            margin-top: 10px;
            box-shadow: 0 3px 6px rgba(0, 0, 0, 0.1);
        }
        input[type="submit"]:hover {
            background-color: #00aa00;
        }
        .signup-link {
            text-align: center;
            margin-top: 20px;
            font-size: 16px;
            color: #495057;
        }
        .signup-btn {
            background-color: #007bff;
            color: #fff;
            font-weight: bold;
            cursor: pointer;
            transition: background-color 0.2s ease-in-out;
            border: none;
            border-radius: 5px;
            padding: 12px 24px;
            box-shadow: 0 3px 6px rgba(0, 0, 0, 0.1);
        }
        .signup-btn:hover {
            background-color: #0062cc;
        }
        .msg {
            color: red;
            text-align: center;
            margin-top: 10px;
        }
        @media screen and (max-width: 768px) {
            h2 {
                font-size: 28px;
            }
        }
    </style>
</head>
<body>
<h2>用户注册</h2>
<form action="${pageContext.request.contextPath}/course/register1" method="post">
    <label for="email">邮箱</label>
    <input type="text" id="email" name="email" placeholder="请输入邮箱" required>
    <label for="password">密码</label>
    <input type="password" id="password" name="password" placeholder="请输入密码" required>
    <label for="code">验证码</label>
    <input type="text" id="code" name="code" value="" placeholder="请输入验证码"  required>
    <img src="/getcode" onclick="this.src='/getcode?time=' + new Date().getTime()" title="点击刷新" >
    <input type="submit" value="注册">
    <span class="msg">${msg}</span>
</form>


<script>
    // 表单校验
    (function () {
        var form = document.querySelector('form');
        var emailInput = form.querySelector('#email');
        var passwordInput = form.querySelector('#password');
        var codeInput = form.querySelector('#code');
        form.onsubmit = function (event) {
            event.preventDefault();
            var email = emailInput.value.trim();
            var password = passwordInput.value.trim();
            var code = codeInput.value.trim();
            if (!email) {
                alert('请输入邮箱');
                emailInput.focus();
                return false;
            }
            if (!password) {
                alert('请输入密码');
                passwordInput.focus();
                return false;
            }
            if (!code) {
                alert('请输入验证码');
                codeInput.focus();
                return false;
            }
            form.submit();
        };
    })();
</script>
</body>
</html>
