<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'BookDetail.jsp' starting page</title>
    
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
  		<td align=right>
      	    <jsp:include page="mhead.jsp"></jsp:include>      	  		
      	</td>
  		</tr>
  		
  		<tr>
  		<td>
  			<table border="1" width=100%>        			
       			<tr><td rowspan=3><img width=100 height=100 src="<%=basePath%>/book/pic.do?isbn=${book.isbn}"/></td>
                    <td colspan=2 align=center style="color:red">${book.bname}</td>
                </tr>
       			<tr><td>��Ʒ�۸�</td><td>${book.price}</td></tr>
       			<tr><td>������</td><td>${book.press}</td></tr>
       			<tr><td height=300 colspan=3>ddd ����������������Ⱦtrddddddddddddy��ģ��ٿʾ�</td></tr>
       			<tr>
                    <td colspan=3 align=center><a href="<%=basePath%>/user/addShopCar.do?isbn=${book.isbn}">���빺�ﳵ</a>
                    &nbsp; <a href="<%=basePath%>/book/main.do">����</a>
                    </td>
                </tr>
    		</table>
  		
  		</td>
  		</tr>
  	
  	</table>
  </body>
</html>
