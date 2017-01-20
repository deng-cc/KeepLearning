<%@ taglib prefix="c" uri="/struts-tags" %>
<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../common/jspHeadFile.jsp"%>

<html>
<head>
<meta charset="utf-8">
<title>用户列表</title>
<link href="<%=basePath%>common/css/base.css" rel="stylesheet" type="text/css">
<link href="<%=basePath%>common/css/toefl.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="<%=basePath%>common/js/jquery.min.js"></script>
<script type="text/javascript" src="<%=basePath%>common/js/validate.js"></script>
</head>

<script type="text/javascript">
    function nextPage() {
        var pageCount = <s:property value="#request.pageCount"/>;
        var curPage = <s:property value="page"/>
        if (curPage == pageCount) {
            alert("已经是最后一页了");
            return;
        }
        window.location.href='<%=basePath%>user/userAction!findByPage?page=' + (curPage + 1);
    }
    function lastPage() {
        var curPage = <s:property value="page"/>
        if (curPage == 1) {
            alert("已经是第一页了");
            return;
        }
        window.location.href='<%=basePath%>user/userAction!findByPage?page=' + (curPage - 1);
    }

</script>


<body>

<div class="doc1180 fn-clear paddingT20">
	
  <div class="doc910 fn-left">
    	<div class="flcb_cardMenu">
        	<ul>
            	<center><font size="5" >用户管理</font></center>
            </ul>
        </div>
        <div class="myPost">
            <div class="myPost_Theme">
            	<table width="100%" border="0" cellspacing="0" cellpadding="0" class="myPost_Table">

                    <tr class="myPost_Th">
                        <th class="last">照片</th>
                        <th class="last">用户姓名</th>
                        <th class="last">用户职业</th>
                        <th class="last">性别</th>
                        <th class="last">邮箱</th>
                        <th class="last">用户状态</th>
                        <th class="last">操作</th>
                    </tr>


                    <s:iterator value="#request.sysUsers" var="user">

                    <tr style="height: 30px">
                        <!--头像-->
                        <s:if test="#user.imageUrl==null">
                        <td><img src='<%=basePath%>common/image/touxiang.jpg' height="80px"></td>
                        </s:if>
                        <s:else>
                        <td><img src='<%=basePath%><s:property value="#user.imageUrl"/>' height="80px"></td>
                        </s:else>

                        <!--用户名-->
                        <td><a target="_blank"
                               href="<%=basePath%>user/userAction!findById?findByIdResult=query&sysUser.userId=<s:property value="#user.userId" />"
                               style="color: red"><s:property value="#user.userName" /></a>
                        </td>

                        <!--职位-->
                        <td><div class="myPost_hf" ><s:property value="#user.sysJob.jobName" /></div></td>

                        <!--性别-->
                        <td><div class="myPost_hf" >
                            <s:if test="#user.isMale">
                                男
                            </s:if>
                            <s:else>
                                女
                            </s:else>
                            </div></td>

                        <!--邮箱-->
                        <td><div class="myPost_hf" ><s:property value="#user.email" /></div></td>

                        <!--账户状态-->
                        <td><div class="myPost_hf" >
                            <s:if test="#user.isLock">
                                锁定
                            </s:if>
                            <s:else>
                                正常
                            </s:else>
                        </div></td>

                        <!--操作-->
                        <td>
                            <div class="myPost_time">
                            <s:if test="#user.isLock">
                                锁定&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                <a href="<%=basePath%>user/userAction!unLockUser?sysUser.userId=<s:property value="#user.userId"/>" style="color: green">解禁</a>
                            </s:if>
                            <s:else>
                                <a href="<%=basePath%>user/userAction!lockUser?sysUser.userId=<s:property value="#user.userId"/>" style="color: red">锁定</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;解禁
                            </s:else>
                            </div>
                        </td>
                    </tr>
                    </s:iterator>
                </table>

            </div>
        </div>
        <div class="pageList">
        	<ul>
        	<li><a href='<%=basePath%>user/userAction!findByPage?page=1' class="pret">首页</a></li>
            <li><a href="###" onclick="lastPage()" class="pret">上一页</a></li>
            <li><a href="###" onclick="nextPage()" class="next">下一页</a></li>
            <li><a href= "<%=basePath%>user/userAction!findByPage?page=<s:property value='#request.pageCount'/>" class="pret">末页</a></li>
            <li>当前第<input type="text" value="<s:property value='page'/>" name="page" style="height: 30px;width: 30px"  disabled="disabled"/>页</li>
            <li>共<s:property value="#request.pageCount" />页</li>
            </ul>
        </div>
  </div>
</div>
</body>
</html>
