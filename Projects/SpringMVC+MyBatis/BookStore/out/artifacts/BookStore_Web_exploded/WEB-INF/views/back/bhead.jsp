<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

 <tr>
      	<td align=right>
      	    
      	  		����Ա: admin &nbsp;	  		       	         	    	         	          	  	
      		
      			<a href="#">�˳�</a>
      		      	
      	</td>       	
      </tr>
      <tr>
      	<td align=center>
      	    <a href="<%=basePath%>back/BookAddSvl">�����ϼ�</a> &nbsp;  <a href="#">�����ӿ��</a>  &nbsp;  <a href="#">���¼�</a> &nbsp;  <a href="#">�û�����</a>
      	    &nbsp;  <a href="#">�޸��ۼ�</a> &nbsp; <a href="<%=basePath%>back/BuyRecordSvl">�û������¼</a>
      	</td>
      	</tr> 
