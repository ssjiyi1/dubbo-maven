<%@ page import="cn.zw.entity.Student" %>
<%@ page import="cn.zw.common.web.common.bean.Constants" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../../../common/jsp/common.jsp" %>
<html>
<head>
    <title>hello</title>


    <link rel="stylesheet" href="${ctx}/common/ace/assets/css/bootstrap.css"/>

    <!-- text fonts -->
    <link rel="stylesheet" href="${ctx}/common/ace/assets/css/ace-fonts.css"/>
    <!-- ace styles -->
    <link rel="stylesheet" href="${ctx}/common/ace/assets/css/ace.css"
          class="ace-main-stylesheet" id="main-ace-style"/>

    <link rel="stylesheet" href="${ctx}/common/ace/assets/css/font-awesome.css"/>

</head>
<style>

    body {
        padding: 0;
    }



    .container {
        margin: 0 auto;
        width: 980px;
        height: 600px;

    }

    .header {
        width: 100%;
        height: 100px;
        margin-top: 10px;
        border: 1px solid #abcdef;
    }

    .content {
        margin-top: 10px;
    }

    .content .content-left {
        float: left;
        width: 200px;
        height: 400px;
    }

    .content .content-right {
        float: left;
        width: 700px;
        height: 400px;
        margin-left: 50px;

    }

    .banner { position: relative; right: 20px; }
    .banner li { list-style: none; }
    .banner ul li { float: left; }
    .banner ul li img{ width:250px;
        height:320px ; }

    .someClass { background-color: #DDDDDC; background-image: none; }

</style>

<body>


<div class="container">
    <div class="header" style="position: relative">
        <h5>
            当前登陆用户:
            <%=  ((Student)request.getSession().getAttribute(Constants._USER_LOGIN_TAG)).getUname()  %>
        </h5>
        <div style="position: absolute;right: 0px;top: 0px;;">
            <input type="button" value="赞一下" onclick="javascript:sendNotify();" />
        </div>
        <div id="weather" style="position: absolute; right: 10px;bottom: 10px;"></div>


    </div>
    <div class="content">
        <div class="content-left">

            <div class="banner">
                <ul>
                    <li> <img src="${ctx}/common/img/1.jpg"/> </li>
                    <li><img src="${ctx}/common/img/2.jpg"/></li>
                    <li><img src="${ctx}/common/img/3.jpg"/></li>
                </ul>
            </div>


        </div>
        <div class="content-right ">
            <table id="__student_list"></table>
            <div id="__student_pager"></div>
        </div>
    </div>
</div>


</div>
<script type="text/javascript" src="${ctx}/common/js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="${ctx}/common/js/public/student.js"></script>
<script type="text/javascript" src="${ctx}/common/js/utils.js"></script>
<script type="text/javascript" src="${ctx}/common/ace/assets/js/bootstrap.js"></script>
<script type="text/javascript" src="${ctx}/common/ace/assets/js/jqGrid/jquery.jqGrid.src.js"></script>
<script type="text/javascript" src="${ctx}/common/ace/assets/js/jquery.dataTables.js"></script>
<script type="text/javascript" src="${ctx}/common/ace/assets/js/jquery.dataTables.bootstrap.js"></script>
<script src="${ctx}/common/ace/assets/js/jqGrid/i18n/grid.locale-cn.js" type="text/javascript"></script>


<script src="${ctx}/common/js/jquery.slicebox.js" type="text/javascript"></script>
<script src="${ctx}/common/js/unslider.js" type="text/javascript"></script>



<script type="text/javascript">


    /**
     *  发送通知信息
     */
    function sendNotify(){
        var enter_data=prompt("请输入点什么吧...","么么哒");//将输入的内容赋给变量 name ，
        if(enter_data){
            ///*getWebRootPath()*/+
            $.GetHttp( "/web/praise/add?data="+enter_data, function (data, status) {
            });


        }

    }


</script>




</body>
</html>
