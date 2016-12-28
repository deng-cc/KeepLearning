<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<c:if test="${user != null}">
    welcome you ${user.uname} &nbsp;<a href="<%=basePath%>ShopCarSvl">购物车</a>&nbsp;<a href="<%=basePath%>/user/logout.do">退出</a>
    <c:if test="${user.role == 1}">
        <a href="<%=basePath%>back/addBook.do">后台</a>
    </c:if>
</c:if>
<c:if test="${user == null}">
 <a href="<%=basePath%>user/login.do">登录</a>
</c:if>

      	  		       	   
      	    	         	          	  	
      		
      			
      		      	
