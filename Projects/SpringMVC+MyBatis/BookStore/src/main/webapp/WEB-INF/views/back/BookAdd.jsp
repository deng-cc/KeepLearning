<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'BookAdd.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">	
	<link rel="stylesheet" type="text/css" href="<%=basePath%>css/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>css/themes/icon.css">	
	<script type="text/javascript" src="<%=basePath%>js/jquery.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/jquery.easyui.min.js"></script>
  </head>
  
  <body>
    <table align="center" width=90%>
      <jsp:include page="bhead.jsp"></jsp:include>   	
      <tr><td align="left"><h2>新书上架</h2></td></tr>
      <tr>
      	<td>
      	<form action="<%=basePath%>back/BookAddSvl" method="post" enctype="multipart/form-data">
      		<table border="0" width=60% align="center">  		
      		
      			<tr><td>书号ISBN</td><td><input type="text" name="isbn"/></td></tr>
       			<tr><td>书名</td><td><input type="text" name="bname"/><span id="NameNull"></span></td></tr>       			
       			<tr><td>出版社</td><td><input type="text" name="press"/></td></tr>
       			<tr><td>出版日期</td><td><input type="text" name="pdate" class="easyui-datebox"/></td></tr>
       			<tr><td>价格</td><td><input type="text" name="price" class="easyui-numberbox" value=0 precision="2"/></td></tr>
       			<tr><td>图片上传</td><td><input type="file" name="pic"/></td></tr>
       			<tr><td colspan=2 align=center><input type=submit value=提交 />${msg}</td></tr>
    		</table>
    	</form>
      	</td>
      </tr>
    </table>
  </body>
</html>
