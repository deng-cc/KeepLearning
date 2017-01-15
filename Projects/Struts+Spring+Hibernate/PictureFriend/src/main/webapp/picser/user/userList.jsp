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
                  
                  
                  	<tr style="height: 30px">
                  	
                  	
                  		<td ><img src='<%=basePath%>common/image/1430723990029.jpg' height="80px"></td>
                  	
                  	
                  	<td><a target="_blank" href="userDetail.jsp" style="color: red">科比</a></td>
                  	<td>
                    	<div class="myPost_hf" >三维动画师</div>
                    </td>
                    <td>
                    	<div class="myPost_hf" >
                    		男
                    	</div>
                    </td>
                    <td>
                    	<div class="myPost_hf" >kebi@126.com</div>
                    </td>
                    <td>
                    	<div class="myPost_hf" >
                    			正常
								</div>
                    </td>
                    <td>
                        <div class="myPost_time">
                    			<a href='####' style="color: red">锁定</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="">解禁</a>
                        </div>
                    </td>
                  	 </tr>
                  	 
                  	 
                  
                  	<tr style="height: 30px">
                  		<td ><img src='<%=basePath%>common/image/1430718890753.jpg' height="80px"></td>
                  	
                  	<td><a target="_blank" href="http://localhost:80/picturefriend1/user/userAction!findById?findByIdResult=query&&sysUser.userId=21" style="color: red">乔丹</a></td>
                  	<td>
                    	<div class="myPost_hf" >三维动画师</div>
                    </td>
                    <td>
                    	<div class="myPost_hf" >
                    	
                    		男
                    	
                    	
                    	</div>
                    </td>
                    <td>
                    	<div class="myPost_hf" >qiaodan@126.com</div>
                    </td>
                    <td>
                    	<div class="myPost_hf" >
							
							
                    			正常
                    		
								</div>
                    </td>
                    <td>
                        <div class="myPost_time">
                        	
							
                    			<a href='http://localhost:80/picturefriend1/user/userAction!lockUser?sysUser.userId=21' style="color: red">锁定</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="">解禁</a>
                    		
                        </div>
                    </td>
                  	 </tr>
                  
                  	<tr style="height: 30px">
                  	
                  	
                  		<td ><img src='<%=basePath%>common/image/1430445170379125x125.jpg' height="80px"></td>
                  	
                  	
                  	<td><a target="_blank" href="userDetail.jsp" style="color: red">李伟2233sss</a></td>
                  	<td>
                    	<div class="myPost_hf" >三维动画师</div>
                    </td>
                    <td>
                    	<div class="myPost_hf" >
                    	
                    		男
                    	
                    	
                    	</div>
                    </td>
                    <td>
                    	<div class="myPost_hf" >liwei1@126.com</div>
                    </td>
                    <td>
                    	<div class="myPost_hf" >
                    			正常
								</div>
                    </td>
                    <td>
                        <div class="myPost_time">
                    			<a href='##' style="color: red">锁定</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="">解禁</a>
                    		
                        </div>
                    </td>
                  	 </tr>
                  
                  
                  
                  
                  
                  
                  
                 
                  
                  
                </table>

            </div>
        </div>
        <div class="pageList">
        	<ul>
        	<li><a href='http://localhost:80/picturefriend1/user/userAction!findByPage?page=1' class="pret">首页</a></li>
            <li><a href="###" onclick="lastPage()" class="pret">上一页</a></li>
            <li><a href="###" onclick="nextPage()" class="next">下一页</a></li>
            <li><a href= 'http://localhost:80/picturefriend1/user/userAction!findByPage?page=1' class="pret">末页</a></li>
            <li>当前第<input type="text" value='1' name="page" style="height: 30px;width: 30px"  disabled="disabled"/>页</li>
            <li>共1页</li>
            </ul>
        </div>
  </div>
</div>
</body>
</html>
