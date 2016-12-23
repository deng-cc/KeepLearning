<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'register.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="<%=basePath%>js/jquery-1.4.2.min.js"></script>
	<script type="text/javascript">	
	
	 function unameValid(){
	   var uname = document.myform.uname.value;
	   var desUrl = "<%=basePath%>RegisterSvl?uname=" + uname;
	   $.ajax({
   			type: "GET",
   			url: desUrl,  
   			dataType : "text",
   			timeout : 3000, 			
   			success: function(msg){     			
			      document.getElementById("unameAlert").innerHTML = msg;
   			},
   			error: function(){
   			   alert( "连接超时，请重新连接" );
   			  
   			}
   			
		}); 
	 }
	
	  function checkUserInfo(){
       			if(document.myform.uname.value==""){
					alert("用户名不能为空");
					return false;
       			}
				if(document.getElementById("pwd").value==""){
					alert("密码不能为空");
					return false;
       			}
				if(document.myform.pwd2.value != document.myform.pwd.value){
					alert("密码与密码确认不一致");
					return false;
       			}
	 }
			
	</script>

  </head>

<body >
	<table align="center" width=70%>
      <tr>
      	<td align=right>
      	   
      	  		welcome you tom &nbsp;<a href="#">购物车</a>
      	  		&nbsp;<a href="#">退出</a> 
      	   
      	    	<a href="#">登录</a>      	   
      			<a href="#">后台</a>
      			
      	</td>
      </tr>
      <tr>
      	<td>
				<form action="#" name="myform" onsubmit="return checkUserInfo()">
						<table  border="0" cellpadding="0" cellspacing="0" align="center">
							<tr><td height=100></td></tr>
							<tr>
							  <td width="107" height="36">用户名：</td>
							  <td width="524"><INPUT name="uname" id="uname" type="text" maxlength="16" onblur="unameValid()">
								<span id="unameAlert"></span>
							  </td>
							</tr>
							<tr>
							  <td width="107" height="36">密码：</td>
							  <td width="524"><INPUT name="pwd" id="pwd" type="password"></td>
							</tr>
							<tr>
							  <td width="107" height="36">确认密码：</td>
							  <td width="524"><INPUT name="pwd2" type="password"></td>
							</tr>
							<tr>
							<td width="107" height="36">性别：</td>
							<td width="524">
								<INPUT name="gen" type="radio"   value="男" checked>男&nbsp; 
								<INPUT name="gen" type="radio" value="女" >女
							</td>
						   </tr>
							<tr>
							<td width="107" height="36">电子邮件：</td>
							<td width="524"><INPUT name="email" type="text"></td>
						  </tr>   
							<tr>
								<td colspan=2 >
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" value="提交"> &nbsp; <a href="#">返回</a>
								</td>
							</tr>
						</table>
			   </form>
      	</td>
      </tr>    
    </table>
</body>


</html>