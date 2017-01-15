<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../common/jspHeadFile.jsp"%>

<html>
<head>
<meta charset="utf-8">
<title>用户列表</title>

<link href="<%=basePath%>common/css/base.css" rel="stylesheet" type="text/css">
<link href="<%=basePath%>common/css/toefl.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="<%=basePath%>common/easyUI/jquery.min.js"></script>
<script type="text/javascript" src="<%=basePath%>common/js/validate.js"></script>
</head>

<script language="javascript">

    <%--判断用户是否因输入的职位重名而跳转到该页面--%>
    function init() {
        var message = "";
        <%if (request.getAttribute("message") != null) {%>
        message = '<s:property value ="#request.message"/>'
        <%}%>
        if (message != "") {
            alert(message);
        }
    }

    <%--判断用户输入内容是否符合规范--%>
    function check() {
        var jobName = $("#jobName").val().trim();
        var jobDesc = $("#jobDesc").val().trim();
        if (!(f_check_length(jobName,1,20) && f_check_ZhOrNumOrLett(jobName))) {
            alert("职位名由1-10位汉字、字母、数字，_，-组成，请重新输入");
            $("#jobName")[0].select();
            $("#jobName").focus();
            return false;
        }
        if (!(f_check_length(jobDesc,10,200))) {
            alert("职位描述由5-100字符组成，请重新输入");
            $("#jobDesc")[0].select();
            $("#jobDesc").focus();
            return false;
        }
        return true;
    }

</script>

<body onload="init()">
	<div align="center" style="text-align: center;">
		<a href="###" style="font-size:24">职业信息</a>
	</div>
    <s:form method="post" namespace="/job" action="jobAction" onsubmit="check()">
        <s:hidden name="sysJob.jobId" />
        <div align="center" style="margin-top: 30px">
            <table>
                <tr>
                    <td>职位名称：</td>
                    <td><s:textfield name="sysJob.jobName" id="jobName" /><font color="red" size="5">*</font></td>
                </tr>
                <tr>
                    <td>职位描述：</td>
                    <td><s:textarea cols="50" rows="10" name="sysJob.jobDesc" id = "jobDesc" /><font color="red" size="5">*</font>
                    </td>
                </tr>
                <tr>
                    <td colspan="2"><font color="red" size="3">*为必输项 </font>
                    </td>
                </tr>
                <tr>
                    <td><s:submit value="提交" cssStyle="height:30px;width:60px" method="update" /></td>
                    <td><s:reset value="重置" cssStyle="height:30px;width:60px" /></td>
                </tr>
            </table>
        </div>
    </s:form>




</body>

</html>
