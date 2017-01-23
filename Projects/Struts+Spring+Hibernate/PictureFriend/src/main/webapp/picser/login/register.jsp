<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../common/jspHeadFile.jsp"%>

<html>
<head>
<meta charset="utf-8">
<title>注册页</title>
<link href="<%=basePath%>common/css/base.css" rel="stylesheet" type="text/css">
<link href="<%=basePath%>common/css/toefl.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="<%=basePath%>common/js/jquery.min.js"></script>
    <script type="text/javascript" src="<%=basePath%>common/js/jQuery.js"></script>
<script type="text/javascript" src="<%=basePath%>common/js/validate.js"></script>
<script language="javascript">
    function init() {
        var message="";
        <%
        if (request.getAttribute("message") != null) {
        %>
        message = '<s:property value ="#request.message"/>'
        <%
        }
        %>
        if (message !="") {
            alert(message);
        }
    }

    function checkInfor() {
        var loginName = $("#loginName").val().trim();
        var password = $("#password").val().trim();
        //验证码可以在前台验证，但是验证码的目的是防止恶意破解密码，因此要放在服务器端验证
        var email = $("#email").val().trim();
        if (!(f_check_length(loginName,5,10) && f_check_NumLett(loginName))) {
            alert("用户名由5-10位数字和字母组成，并由字母开头，请重新输入");
            $("#loginName")[0].select();
            $("#loginName").focus();
            return false;
        }
        if (!(f_check_length(password,5,10) && f_check_number(password))) {
            alert("密码由5-10位数字，请重新输入");
            $("#password")[0].select();
            $("#password").focus();
            return false;
        }
        if ( !f_check_email(email)) {
            alert("请输入正确的邮箱");
            $("#email")[0].select();
            $("#email").focus();
            return false;
        }
        return true;
    }

    <!--Ajax + JSON-->
    $(document).ready( function() {
        //使用 Ajax 的方式 判断登录
        $("#loginName").blur( function() {
            var url = "/ajax/ajaxAction!ajaxRegister";
            var params = {loginName : $("#loginName").val()};

            $.post(
                    url,  //服务器要接受的url
                    params,  //传递的参数
                    function validateLoginName(result){ //服务器返回后执行的函数 参数msg保存的是服务器发送到客户端的数据
                        //alert("服务器端返回的data --> " + result);
                        var msgObj = eval("(" + result + ")"); //jsonStr -> jsObj(jsonObj)
                        var passed = msgObj.status;
                        setMessage(msgObj.msg, passed);
                    },
                    'json' //数据传递的类型  json
            );

            function setMessage(message, passed) {
                var validateMessage = document.getElementById("loginNameMsg");
                var fontColor = "red";
                if(passed) {
                    fontColor = "green";
                }
                //对<div name="loginNameMsg">的地方设置其间的代码innerHTML为指定代码
                validateMessage.innerHTML = "<font color=" + fontColor + ">"
                        + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
                        + message + "</font>";
            }
        });
    });


</script>
</head>



<body  onload="init()">
<div class="doc1180">
	<div class="header">
    	<div class="logo"><a href="####"><img src="<%=basePath%>common/image/logo.png"></a></div>
    </div>
</div>
<div class="doc1180">
	<div class="login">
    	<div class="login_left">
       	  <h3 class="login_h3">新用户注册</h3>
            <s:form method="post" target="_parent" namespace="/user" action="userAction" onsubmit="return checkInfor()" >
                <div id="loginNameMsg"></div>
                <div class="login_sr">账号：<s:textfield cssClass="login_inputYhm" name="sysUser.loginName" id="loginName" /> </div>
                <div class="login_sr">密码：<s:password cssClass="login_inputMm" name="sysUser.password" id="password" /> </div>
                <div class="login_sr">邮箱：<s:textfield cssClass="login_inputEmail" name="sysUser.email" id="email" /> </div>
                <div>
                    <s:submit type="button" method="register" value="注册" cssStyle="height:30px;width: 50px" />
                </div>
            </s:form>

      </div>
      <div class="login_right">
      	<div class="login_rightH3">您也可以使用以下方式登录：</div>
        <div class="login_sanfang"><a href="###"><img src="<%=basePath%>common/image/login_wb.png">新浪微博</a></div>
        <div class="login_sanfang"><a href="###"><img src="<%=basePath%>common/image/login_qq.png">QQ登录</a></div>
        <div class="login_sanfang"><a href="###"><img src="<%=basePath%>common/image/login_qw.png">腾讯微博</a></div>
        <div class="login_sanfang"><a href="###"><img src="<%=basePath%>common/image/login_rr.png">人人网</a></div>
      </div>
    </div>
</div>





<iframe src="<%=basePath%>picser/main/bottom.jsp" width="100%" name="bottomframe" ></iframe>

</body>







</html>
