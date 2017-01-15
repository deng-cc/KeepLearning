<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../common/jspHeadFile.jsp"%>

<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>系统登录</title>
<link href="<%=basePath%>common/css/base.css" rel="stylesheet" type="text/css">
<link href="<%=basePath%>common/css/toefl.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="<%=basePath%>common/js/jquery.min.js"></script>
<script type="text/javascript" src="<%=basePath%>common/js/validate.js"></script>

</head>

<script language="javascript">
    var basePath = "";
    <%--更换验证码图片--%>
    function changeCode(){
        //相同的图片路径会导致浏览器不刷新图片，更换访问路径。
        $("#validateImage")[0].src = basePath + "login/loginAction!findValidateCode?date" + new Date().getTime();
    }

    <%--文本框全选--%>
    function selectText(text) {
        text.select();
        text.focus();
    }

    <%--检查基本的账号密码输入规范--%>
    function checkInfor() {
        //@todo checkInfor():验证码undone
        var loginName = $("#loginName").val().trim();
        var password = $("#password").val().trim();
        //验证码可以在前台验证，但是验证码的目的是防止恶意破解密码，因此要放在服务器端验证
        //var validateCode = $("#validateCode").val().trim();
        if (!(f_check_length(loginName,5,10) && f_check_NumLett(loginName))) { //@todo f_check_NumLett(loginName)未发挥作用
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
        /*
        if (!(f_check_length(validateCode,4,4) && f_check_NumOrLett(validateCode))) {
            alert("验证码由4位数字和字母组成，请重新输入");
            $("#validateCode")[0].select();
            $("#validateCode").focus();
            return false;
        }
        */
        return true;
    }

    <%--用户登录异常的文本显示--%>
    function init() {
        basePath = "<%=basePath%>";
        //changeCode();
        var state = "4";
        <%
        if (request.getAttribute("state") != null) {
        %>
            state = '<s:property value="#request.state"/>';
        <%
        }
        %>
        if (state == "0") {
            alert("用户名输入错误");
            $("#loginName").select();
            $("#loginName").focus();
        }
        if (state == "1") {
            alert("密码输入错误");
            $("#password").select();
            $("#password").focus();
        }
        if (state == "2") {
            alert("验证码输入错误");
            $("#validateCode").select();
            $("#validateCode").focus();
        }
        if (state == "3") {
            alert("用户被锁定,无法登录，请拨打电话，解锁当前用户");
        }
    }
</script>

<body onload="init()">
	<div class="doc1180">
		<div class="header">
			<div class="logo">
				<a href="####"><img src="<%=basePath%>common/image/logo.png">
				</a>
			</div>
		</div>
	</div>
	<div class="doc1180">
		<div class="login">                                             <%--//@tips 如果不使用return，会执行该js并提交请求。加上return，在js返回true才提交请求 --%>
            <s:form method="post" target="_parent" namespace="/login" action="loginAction" onsubmit="return checkInfor()" >
                <div class="login_left">
                    <h3 class="login_h3">欢迎登录图友网</h3>
                    <div class="login_sr">
                        用户名：
                        <s:textfield cssClass="login_inputYhm" id="loginName" name="loginName" onfocus="selectText(this)" value="admin"/>

                    </div>
                    <div class="login_sr">
                        密码： &nbsp;&nbsp;
                        <s:password cssClass="login_inputMm" showPassword="true" name="password" id="password" onfocus="selectText(this)" value="12345"/>
                    </div>
                        <%--
                        <div class="login_sr">
                            <div style="float:left">验证码&nbsp;&nbsp;&nbsp;&nbsp;</div>
                            &nbsp;&nbsp; <input type="text" name="validateCode" maxlength="4" class="login_inputYzm" style="float:left;" />
                            <div class="login_inputYzmPic" 提交style="float:left">
                                <img src="<%=basePath%>picser/login/loginAction!findValidateCode" id="validateImage" onclick="changeCode()">
                            </div>
                            <span class="login_inputYzmH" onclick="changeCode()">换一张</span>
                        </div>
                        --%> <% //@todo 验证码的功能有缺陷，此处暂时去掉，后续完善 %>
                    <div>
                        <s:submit type="button" cssStyle="height:30px; width:50px" method="login" value="登录" />
                        <%--//@tips 点击提交，会提交请求到s:form指定的namespace（/login）下的指定action（loginAction）中的指定method（login）--%>
                    </div>
                    <div class="login_zcymm">
                        <a href="register.jsp">注册帐号</a>
                    </div>
                </div>
            </s:form>




			<div class="login_right">
				<div class="login_rightH3">您也可以使用以下方式登录：</div>
				<div class="login_sanfang">
					<a href="###"><img src="<%=basePath%>common/image/login_wb.png">新浪微博</a>
				</div>
				<div class="login_sanfang">
					<a href="###"><img src="<%=basePath%>common/image/login_qq.png">QQ登录</a>
				</div>
				<div class="login_sanfang">
					<a href="###"><img src="<%=basePath%>common/image/login_qw.png">腾讯微博</a>
				</div>
				<div class="login_sanfang">
					<a href="###"><img src="<%=basePath%>common/image/login_rr.png">人人网</a>
				</div>
			</div>
		</div>
	</div>

</body>
</html>

