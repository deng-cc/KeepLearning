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
	<script type="text/javascript">
	
		var xmlhttp;

		function loadXMLDoc(url)
		{
		xmlhttp=null;		
		// ��� Mozilla��������Ĵ��룺
		if (window.XMLHttpRequest)
		  {
		  xmlhttp=new XMLHttpRequest()
		  }		
		// ��� IE �Ĵ��룺
		else if (window.ActiveXObject)
		  {
		  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP")
		  }
		if (xmlhttp!=null)
		  {
		  xmlhttp.onreadystatechange=receiveUnameValid;               //ע��ص�����
		  xmlhttp.open("GET",url,true);                               //������������첽��get����
		  xmlhttp.send(null)
		  }
		else
		  {
		  alert("�����������֧��XMLHTTP")
		  }
		}
		
		
		function receiveUnameValid(){
			 if (xmlhttp.readyState==4)
			  {
			  // ���Ϊ "OK"
			  if (xmlhttp.status==200)
			    {
			      var responsevalue = xmlhttp.responseText;
			      document.getElementById("unameAlert").innerHTML = responsevalue;
			    }
			  else
			    {
			    alert("Problem retrieving XML data")
			    }
			  }
		}
	
	
	 function unameValid(){
	    var uname = document.myform.uname.value;
	    var url = "<%=basePath%>RegisterSvl?uname=" + uname;
	    loadXMLDoc(url);
	 }
	
	  function checkUserInfo(){
       			if(document.myform.uname.value==""){
					alert("�û�������Ϊ��");
					return false;
       			}
				if(document.getElementById("pwd").value==""){
					alert("���벻��Ϊ��");
					return false;
       			}
				if(document.myform.pwd2.value != document.myform.pwd.value){
					alert("����������ȷ�ϲ�һ��");
					return false;
       			}
	 }
			
	</script>

  </head>

<body >
	<table align="center" width=70%>
      <tr>
      	<td align=right>
      	   
      	  		welcome you tom &nbsp;<a href="#">���ﳵ</a>
      	  		&nbsp;<a href="#">�˳�</a> 
      	   
      	    	<a href="#">��¼</a>      	   
      			<a href="#">��̨</a>
      			
      	</td>
      </tr>
      <tr>
      	<td>
				<form action="#" name="myform" onsubmit="return checkUserInfo()">
						<table  border="0" cellpadding="0" cellspacing="0" align="center">
							<tr><td height=100></td></tr>
							<tr>
							  <td width="107" height="36">�û�����</td>
							  <td width="524"><INPUT name="uname" id="uname" type="text" maxlength="16" onblur="unameValid()">
								<span id="unameAlert"></span>
							  </td>
							</tr>
							<tr>
							  <td width="107" height="36">���룺</td>
							  <td width="524"><INPUT name="pwd" id="pwd" type="password"></td>
							</tr>
							<tr>
							  <td width="107" height="36">ȷ�����룺</td>
							  <td width="524"><INPUT name="pwd2" type="password"></td>
							</tr>
							<tr>
							<td width="107" height="36">�Ա�</td>
							<td width="524">
								<INPUT name="gen" type="radio"   value="��" checked>��&nbsp; 
								<INPUT name="gen" type="radio" value="Ů" >Ů
							</td>
						   </tr>
							<tr>
							<td width="107" height="36">�����ʼ���</td>
							<td width="524"><INPUT name="email" type="text"></td>
						  </tr>   
							<tr>
								<td colspan=2 >
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" value="�ύ"> &nbsp; <a href="#">����</a>
								</td>
							</tr>
						</table>
			   </form>
      	</td>
      </tr>    
    </table>
</body>


</html>