<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'main.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <table align="center" width=90%>
      <tr>
      	<td align=right><jsp:include page="mhead.jsp"></jsp:include>
      	</td>
      </tr>
      <tr>
      	<td>
      		<table border="1" width=100%>       		
      		    <c:forEach var="bk" items="${books}">
      				<tr><td rowspan=3><img width=100 height=100 src="<%=basePath%>BookPicSvl?isbn=${bk.isbn}"/></td><td colspan=2 align=center style="color:red"><a href="<%=basePath%>BookDetailSvl?isbn=${bk.isbn}">${bk.bname}</a></td></tr>
       				<tr><td>商品价格</td><td>${bk.price}</td></tr>
       				<tr><td>出版社</td><td>${bk.press}</td></tr>           		       			
       		    </c:forEach>
    	</table>
      	</td>
      </tr>
    </table>
  </body>
</html>
