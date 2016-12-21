<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'BuyDetail.jsp' starting page</title>
    
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
      <tr><td align="left"><h2>购买记录</h2></td></tr>
      
      <!-- 查询条件 -->
      <tr>
      	<td>
      	   <form action="<%=basePath%>back/BuyRecordSvl" method="post">
      		<table>
      		   <tr><td align=left>用户名 </td><td><input type="text" name="uname" value="${uname}"/></td></tr>
               <tr>
                   <td align=left>开始日期 </td><td><input type="text" name="beginDate" value="${beginDate}" class="easyui-datebox"/></td>
                   <td align=left>结束日期 </td><td><input type="text" name="endDate" value="${endDate}" class="easyui-datebox"/></td>
                   <td><input type=submit value="查询"/></td>
               </tr>
      		</table>
      	   </form>
      	</td>
      </tr>
      
      
      <tr>
      	<td align=left>
      	  <table border="1" width=100%> 
      	   <tr><td>用户名</td><td>书名--购买数量(本)</td><td>书单价</td><td>出版社</td><td>作者</td><td>购买日期</td><td>总付款</td></tr>
      	  	
      	  	<c:forEach var="br" items="${records}">
      	  	  <tr><td>${br.uname}</td><td>${br.bname}--${br.bcount}</td><td>${br.price}</td><td>${br.press}</td>
      	  	  <td>托尔斯泰</td><td>${br.buytime}</td><td>${br.allmoney}</td></tr>
      	  	 </c:forEach>
      	  	  
      	<tr>
      	<td colspan=8>
      		<table id="tblTurnPage" cellSpacing="0" cellPadding="1" width="100%" border="0" style="font-family:arial;color:red;font-size:12px;">	    		
	    			<tr>
	    				<td>总记录数：${RecordAllCount}</td> 
	    				<td>总页数：${maxPageNo}</td>
	    				<td>当前页：${CurrentPageNo}</td>
	    				<td><a href="<%=basePath%>back/BuyRecordSvl?page=1&uname=${uname}&beginDate=${beginDate}&endDate=${endDate}">首页|</a>
	    				    <a href="<%=basePath%>back/BuyRecordSvl?page=${CurrentPageNo-1}&uname=${uname}&beginDate=${beginDate}&endDate=${endDate}">《前页|</a>
	    				    <a href="<%=basePath%>back/BuyRecordSvl?page=${CurrentPageNo+1}&uname=${uname}&beginDate=${beginDate}&endDate=${endDate}">后页》|</a>
	    				    <a href="<%=basePath%>back/BuyRecordSvl?page=${maxPageNo}&uname=${uname}&beginDate=${beginDate}&endDate=${endDate}">末页|</a></td>
	    				<td >跳转到:第<input type="text" size="3" >页<input type="button" value="go"></td>
	    			</tr>	    		
	    		</table>	    	
      	</td>
      </tr>
      	  	
      	  	
      	  </table>
    	
      	</td>
      </tr>
    </table>
  </body>
</html>
