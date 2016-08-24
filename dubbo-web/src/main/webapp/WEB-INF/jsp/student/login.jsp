<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../../../common/jsp/common.jsp" %>
<html>
<head>
    <title>hello</title>
    <link rel="stylesheet" href="${ctx}/common/css/login-css.css"/>
</head>

<body>

<div class="htmleaf-container">
    <div class="wrapper">
        <div class="container">
            <h1>Welcome</h1>

            <form class="form" method="post" action="${ctx}/system/login">
                <input type="text" name="name" placeholder="用户名...">
                <input type="password" name="pwd" placeholder="密码...">
                <button type="submit" id="login-button">登陆</button>
            </form>

            <div id="error-info">

                ${info}

            </div>

        </div>
    <!-- 显示动画 -->
        <ul class="bg-bubbles">
            <li></li>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
        </ul>
    </div>
</div>

</div>
<script type="text/javascript" src="${ctx}/common/js/jquery-1.9.1.min.js"></script>
<script type="text/javascript">


    function GetQueryString(name)
    {
        var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
        var r = window.location.search.substr(1).match(reg);
        if(r!=null)return  unescape(r[2]); return null;
    }


    $(function(){
       var info = GetQueryString("info");
        if(info){
            $('form').fadeOut(500);
            $('form').fadeIn(500);
            $("#error-info").html(  decodeURI(info));
        }
    });




</script>
</body>
</html>
