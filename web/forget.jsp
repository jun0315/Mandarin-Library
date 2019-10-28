<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en" class="no-js">
<head>
    <title>Login</title>

    <meta charset="UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>login</title>
    <link rel="stylesheet" type="text/css" href="css/normalize.css"/>
    <link rel="stylesheet" type="text/css" href="css/demo.css"/>
    <!--必要样式-->
    <link rel="stylesheet" type="text/css" href="css/component.css"/>
    <!--[if IE]>
    <script src="js/html5.js"></script>
    <![endif]-->
</head>

<body>
<div class="container demo-1">
    <div class="content">
        <div id="large-header" class="large-header">
            <canvas id="demo-canvas"></canvas>
            <div class="logo_box">
                <h3>Input your account,and we will send to your email</h3>
                <form action="ForgetPassword.do" name="f" method="post">
                    <div class="input_outer">
                        <span class="u_user"></span>
                        <input name="account" class="text" style="color: #FFFFFF !important" type="text"
                               placeholder="Your account">
                    </div>
                    <div class="mb2">
                        <button type="submit" class="act-but submit" id="button" style="color: #FFFFFF; width: 330px">
                            send email
                        </button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div><!-- /container -->
<%
    session = request.getSession();
    String account = (String) session.getAttribute("account");
    if (account != null) {
        response.sendRedirect("login");
    }
%>
<script>
    var error = '<%=request.getParameter("error")%>';
    if (error == 'yes') {
        alert("Account or password wrong!");
    }
</script>
<script src="js/TweenLite.min.js"></script>
<script src="js/EasePack.min.js"></script>
<script src="js/rAF.js"></script>
<script src="js/demo-1.js"></script>
<div style="text-align:center;">
</div>
</body>
</html>