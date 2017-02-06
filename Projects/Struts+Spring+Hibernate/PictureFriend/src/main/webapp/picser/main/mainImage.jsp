<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../common/jspHeadFile.jsp"%>

<html>
<head>
<meta charset="utf-8">
<title>首页图片设置</title>
<link href="<%=basePath%>common/css/base.css" rel="stylesheet" type="text/css">
<link href="<%=basePath%>common/css/toefl.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="<%=basePath%>common/js/jquery.min.js"></script>
<script type="text/javascript" src="<%=basePath%>common/js/validate.js"></script>
<script type="text/javascript" src="<%=basePath%>common/js/lrtk.js"></script>
</head>

<script type="text/javascript">
    function check() {
        if($("#image").val() == "") {
            alert("请选择文件！");
            return false;
        }
        return true;
    }

    function init() {
        basePath = "<%=basePath%>";

        <%
        if (request.getAttribute("msg") != null) {
        %>

        var message = '<s:property value="#request.msg"/>';
        alert(message);

        <%
        }
        %>
    }

</script>

<body onload="init()">
	<div class="castleInfo_title" style="text-align: center;">主页图片阅览</div>
	<div class="doc1180 paddingT20 fn-clear">
		<!--页面左侧内容-->
		<div class="doc850 fn-left">
			<div class="ppt">
				<!-- 代码 开始 -->
				<div id="playBox">
					<div class="pre"></div>
					<div class="next"></div>
                    <div class="smalltitle">
                        <ul>
                            <li class="thistitle"></li>
                            <s:if test="#request.allMain.size()!=0">
                                <s:iterator begin="1" value="#request.allMain">
                                    <li></li>
                                </s:iterator>
                            </s:if>
                        </ul>
                    </div>
					<ul class="oUlplay">
                        <s:iterator value="#request.allMain" var="image">
                            <li><a href="###" target="_blank">
                                <img src='<%=basePath%><s:property value="#image.imageUrl" /> '>
                            </a></li>
                        </s:iterator>
					</ul>
				</div>

			</div>

			<div class="castleInfo_title" style="text-align: center;">主页图片维护</div>
            <s:iterator value="#request.allMain" var="image">
            <div>
                <img src='<%=basePath%><s:property value="#image.imageUrl"/>'
                     style="height:400px;width: 700px"><br>
                <a href="<%=basePath%>main/mainAction!deleteMain?sysMain.mainId=<s:property value='#image.mainId' />" class="classInfo_ljbm">删除</a>
            </div>
            </s:iterator>

			<div style="margin-top: 100px">
                <s:form namespace="/main" action="mainAction" enctype="multipart/form-data" onsubmit="return check()">
                    图片上传：<input type="file" name="image" id="image">
                    <s:submit method="save" value="提交" />
                </s:form>
			</div>

			<div style="margin-top: 100px">
				<font size="3" color="red">主页图片建议大小为850px X
					330px，大小不能超过1m、图片格式为jpg、png格式</font>
			</div>
		</div>
	</div>
</body>
</html>
