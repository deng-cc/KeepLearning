<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../common/jspHeadFile.jsp"%>

<html>
<head>
<meta charset="utf-8">
<title>职位列表</title>
<link href="<%=basePath%>common/css/base.css" rel="stylesheet" type="text/css">
<link href="<%=basePath%>common/css/toefl.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="<%=basePath%>common/js/jquery.min.js"></script>
<script type="text/javascript" src="<%=basePath%>common/js/validate.js"></script>
</head>
<script language="javascript">
    function init() {
        var message = "";
        <%if (request.getAttribute("message") != null) {%>
        message = '<s:property value ="#request.message"/>'
        <%}%>
        if (message != "") {
            alert(message);
        }
    }
</script>
<body onload="init()">


	<div class="doc1180 fn-clear paddingT20">

		<div class="doc910 fn-left">
			<div class="flcb_cardMenu">
				<ul>
					<center>
						<font size="5">职位管理</font>
					</center>
				</ul>
			</div>
			<div class="myPost">
				<div class="myPost_Theme">
					<table width="100%" border="0" cellspacing="0" cellpadding="0"
						class="myPost_Table">
						<tr class="myPost_Th">
							<th class="last">职位名称</th>
							<th class="last">职位描述</th>
							<th class="last">操作</th>
						</tr>

                        <s:iterator var="job" value="#request.sysJobs" >
                            <tr style="height: 30px">
                                <td><div class="myPost_hf"><s:property value="#job.jobName" /></div>
                                </td>
                                <td><div class="myPost_hf"><s:property value="#job.jobDesc" /></div>
                                </td>
                                <td>
                                    <div class="myPost_time">
                                        <a href='<%=basePath%>job/jobAction!findById?sysJob.jobId=<s:property value="#job.jobId"/>' style="color: red">修改</a> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                        <a href='<%=basePath%>job/jobAction!delete?sysJob.jobId=<s:property value="#job.jobId" />' style="color: red">删除</a>
                                    </div></td>
                            </tr>
                        </s:iterator>

					</table>
				</div>
			</div>
			<div class="pageList">
				<ul>
					<li><a href='<%=basePath%>picser/job/createJob.jsp' class="pret">创建职业</a>
					</li>
				</ul>
			</div>
		</div>
	</div>
</body>
</html>
