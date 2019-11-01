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
            <div style="width: 100px; height: 37px; position: absolute; left: 5%; top: 2%">
                <a href="index.jsp">
                    <div style="width: 37%; height: 100%; float: left">
                        <img src="img/back.png" style="width: 100%; height: 100%">
                    </div>
                    <p style="font-size: 30px; margin: 0px; float: right; width: 63%; color: white">
                        <strong>BACK</strong>
                    </p>
                </a>
            </div>
            <div class="logo_box">
                <div style="width: 330px; height: 140px; vertical-align: center">
                    <h2>Input your account, and we will send to your email</h2>
                </div>
                <form action="ForgetPassword.do" name="f" method="post">
                    <div class="input_outer">
                        <span class="u_user"></span>
                        <input name="account" class="text" style="color: #FFFFFF !important" type="text"
                               placeholder="Your account">
                    </div>
                    <div class="mb2">
                        <button type="submit" class="act-but submit" id="button" style="color: #FFFFFF; width: 330px">
                            <strong>Send Email</strong>
                        </button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div><!-- /container -->

<script>
    var info = '<%=request.getParameter("forget")%>';
    if (info == 'yes') {
        alert("successfully send email!");
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