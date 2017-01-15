<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../common/jspHeadFile.jsp"%>

<html>
<head>
<meta charset="utf-8">
<title>用户列表</title>
<link href="<%=basePath%>common/css/base.css" rel="stylesheet" type="text/css">
<link href="<%=basePath%>common/css/toefl.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="<%=basePath%>common/easyUI/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="<%=basePath%>common/easyUI/themes/icon.css">
<link rel="stylesheet" type="text/css" href="<%=basePath%>common/easyUI/demo/demo.css">
<script type="text/javascript" src="<%=basePath%>common/easyUI/jquery.min.js"></script>
<script type="text/javascript" src="<%=basePath%>common/easyUI/jquery.easyui.min.js"></script>
<script type="text/javascript" src="<%=basePath%>common/js/validate.js"></script>
</head>

<body>
	<div align="center" style="text-align: center;">
		<a href="###" style="font-size:24">个人信息</a>
	</div>

	<div align="center" style="margin-top: 30px;float:left;height: 600px;">


		<img src='<%=basePath%>common/image/1430718890753.jpg' height="80px"><br>
		您已经上传了图像&nbsp;&nbsp; &nbsp;&nbsp;<a  href="##"><font color="red">重新上传</font>
		</a>
		<div style="margin-top: 50px" id="imageDiv">

				<input type="file" name="image" id="image"><br> 
				<font size="3" color="red">图片建议大小为150px
					X 150px，<br>大小不能超过2m、图片格式为jpg、png格式</font><br> 
					<input type="submit"  value="提交" />


		</div>
		<div style="margin-top: 50px">
			<a href='<%=basePath%>picser/productByUser.html' style="font-size: 24px;color: red"> 查看作品</a>
		</div>
	</div>



		<div align="center" style="margin-top: 30px">
			<input type="hidden" name="sysUser.userId" value="21"
				id="userAction_sysUser_userId" />

			<table>
				<tr>
					<td style="font-size:16px; padding:20px 0;">用户名</td>
					<td><input type="text"   value="乔丹"  class="userCenter_input" /> <font color="red"
						size="5">*</font>
					</td>
				</tr>

				<tr>
					<td style="font-size:16px ;padding:20px 0;">性别</td>
					<td><input type="radio"  checked="checked" value="true" />
						<label>男</label> 
						<input type="radio"  value="false" />
						<label >女</label>

					</td>
				</tr>
				<tr>
					<td style="font-size:16px ;padding:20px 0;">职业</td>
					<td><select>
							<option value="11">平面设计师</option>
							<option value="12">网页设计师</option>
							<option value="13" selected="selected">三维动画师</option>
							<option value="16">flash动画师</option>
							<option value="17">GUI设计师</option>
							<option value="15">设计爱好者</option>
							<option value="18">学生</option>
					</select></td>
				</tr>
				<tr>
					<td style="font-size:16px ;padding:20px 0;">邮箱</td>
					<td><input type="text"  value="qiaodan@126.com"  class="userCenter_input" /><font color="red" size="5">*</font>
					</td>
				</tr>
				<tr>
					<td style="font-size:16px ;padding:20px 0;">电话</td>
					<td><input type="text"  value="15810889080"  class="userCenter_input" /><font color="red" size="5">*</font>
					</td>
				</tr>
				<tr>

					<td style="font-size:16px ;padding:20px 0;">出生日期</td>
					<td><input type="text" 	value="1967-01-02"  class="easyui-datebox" /> <font	color="red" size="5">*</font>
					</td>
				</tr>
				<tr>
					<td colspan="2" style="font-size:16px ;padding:20px 0;"><font color="red" size="3">*为必输项 </font>
					</td>
				</tr>
				<tr>
					<td><input type="submit" 
					 value="提交" style="height:30px;width:60px" /></td>
					<td><input type="reset" value="重置"
						style="height:30px;width:60px" />
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a
						href='userPassword.jsp'>
							<font color="red">密码修改</font>
					</a></td>
				</tr>
			</table>

		</div>


</body>

</html>
