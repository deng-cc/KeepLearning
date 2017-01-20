<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../common/jspHeadFile.jsp"%>


<html>
<head>
<meta charset="utf-8">
<title>系统管理员首页</title>
	<link href="<%=basePath%>common/css/base.css" rel="stylesheet" type="text/css">
	<link href="<%=basePath%>common/css/toefl.css" rel="stylesheet" type="text/css">
	<script type="text/javascript" src="<%=basePath%>common/js/jquery.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>common/js/validate.js"></script>
</head>
<script type="text/javascript">
    function showProductBySort() {
        document.getElementById("mainframe").src='<%=basePath%>picser/productBySort.html';
        //todo 此处函数应有参数，为保证暂时的页面链接正常，这里进行了删除
    }
    function showMain() {
        document.getElementById("mainframe").src='<%=basePath%>picser/main/main.jsp';
    }
    function userManage() {
            window.mainframe.location.href="userList.jsp";
            window.mainframe.location.href="<%=basePath%>user/userAction!findByPage?page=1";
    }
	function mainImage() {
		window.mainframe.location.href="mainImage.html";
	}
	function jobManage() {
		window.mainframe.location.href="<%=basePath%>job/jobAction!findAll";
	}
</script>
<body>
<div class="doc1180">

</div>
<div class="menu">
	<div class="doc1180">
		<div style="float: left; width:100px; height:50px;"><img style="height:50px"  src="<%=basePath%>common/image/logo.png"></div>
   	  <div class="menuLink">
   	  		
        	<ul class="fn-clear">
                <li><a href="###" onclick="showMain()">首页</a></li>
                <!--
                <li><a href='##' onclick='showProductBySort()'>原创</a></li>
                <li><a href='##' onclick='showProductBySort()'>素材</a></li>
                <li><a href='##' onclick='showProductBySort()'>转载</a></li>
                <li><a href='##' onclick='showProductBySort()'>欣赏</a></li>
                -->

                <s:iterator value="#session.productSorts"> <!--//@todo ongl表达式undone -->
                    <li><a href='##' onclick='showProductBySort()'><s:property value="sortName" /> </a> </li>
                </s:iterator>
                
                <li><a href="###" onclick="userManage()" >会员管理</a></li>
                <li><a href="###" onclick="mainImage()">首页设置</a></li>
                <li><a href="###" onclick="jobManage()">职位管理</a></li>
            </ul>
        </div>
        
	
         <div class="menuLink" style="margin-left: 150px">
        	<ul class="fn-clear">
            	<li><a href="<%=basePath%>login/loginAction!logout" >退出登陆</a></li>
            </ul>
        </div>
        
        
    </div>
</div>
<iframe height="590px" src="<%=basePath%>picser/main/main.jsp" scrolling="yes" id="mainframe"  width="99%" name="mainframe" onchange="" ></iframe>
</body>
</html>
