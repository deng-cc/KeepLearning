<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../common/jspHeadFile.jsp"%>
<html>
<head>
<meta charset="utf-8">
<title>首页</title>
<link href="<%=basePath%>common/css/base.css" rel="stylesheet" type="text/css">
<link href="<%=basePath%>common/css/toefl.css" rel="stylesheet" type="text/css">
<link href="<%=basePath%>common/css/globle.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="<%=basePath%>common/js/jquery.min.js"></script>
<script type="text/javascript" src="<%=basePath%>common/js/validate.js"></script>
<script type="text/javascript" src="<%=basePath%>common/js/lrtk.js"></script>

</head>
<script type="text/javascript">
function init() {
	showBigPicture();
}
function showSort() {
	window.location.href = "productBySort.html";
}
function showUser(userId) {
	window.open("http://localhost:80/picturefriend1/user/UserAction!findById?findByIdResult=query&&sysUser.userId=" + userId);
}
</script>

<body onload="init()">

	<div class="doc1180 paddingT20 fn-clear">
		<!--页面左侧内容-->
		<div class="doc850 fn-left">
			<div class="ppt">
				<!-- 代码 开始 -->
				<div id="playBox">
					<div class="pre"></div>
					<div class="next"></div>
					<div class="smalltitle">
						<ul>
							<li class="thistitle"></li>


							<li></li>

							<li></li>

							<li></li>

							<li></li>

							<li></li>


						</ul>

					</div>
					<ul class="oUlplay">
						<li><a href="###" target="_blank"><img
								src='../../common/image/1430657519022zhuye1.jpg'>
						</a>
						</li>
						<li><a href="###" target="_blank"><img
								src='../../common/image/1430657529632zhuye2.jpg'>
						</a>
						</li>
						<li><a href="###" target="_blank"><img
								src='../../common/image/1430657537108zhuye3.jpg'>
						</a>
						</li>
						<li><a href="###" target="_blank"><img
								src='../../common/image/1430657544377zhuye4.jpg'>
						</a>
						</li>
						<li><a href="###" target="_blank"><img
								src='../../common/image/1430657551978zhuye5.jpg'>
						</a>
						</li>
						<li><a href="###" target="_blank"><img
								src='../../common/image/1430657559075zhuye6.jpg'>
						</a>
						</li>
					</ul>
				</div>
				<!-- 代码 结束 -->

			</div>
			<div class="toefl_tuijian">
				<!-- 最新作品开始 -->

				<div>
					<div class="toefl_h3" style="float:right">
						<a onclick="showSort()" href="javascript:void(0);">更多原创</a>
					</div>
					<div style="clear:both"></div>
				</div>
				<div class="toefl_dl">

					<div style="float:left;margin-left: 3px">
						<a onclick='showProductDetail(15)' href='javascript:void(0);'>
							<img src='../../common/image/1430715169655.jpg' width="280px"
							height="165px"> </a>
						<div class="camLiDes">
							<b> <a onclick='showProductDetail(15)'
								href='javascript:void(0);' style='color:#a6ce38;'> 原创作品-牛头人3
							</a> </b> - <a style='color:#ff0084;' onclick='showSort(1)'
								href="javascript:void(0);"> 原创 </a><br /> 2015-05-04 上传<br />
							作者:<a onclick="showUser(24)" href='javascript:void(0);'
								style='color:#a6ce38;'> 杜兰特 </a>
						</div>
					</div>

					<div style="float:left;margin-left: 3px">
						<a onclick='showProductDetail(16)' href='javascript:void(0);'>
							<img src='../../common/image/1430715215193.jpg' width="280px"
							height="165px"> </a>
						<div class="camLiDes">
							<b> <a onclick='showProductDetail(16)'
								href='javascript:void(0);' style='color:#a6ce38;'> 原创作品-牛头人4
							</a> </b> - <a style='color:#ff0084;' onclick='showSort(1)'
								href="javascript:void(0);"> 原创 </a><br /> 2015-05-04 上传<br />
							作者:<a onclick="showUser(24)" href='javascript:void(0);'
								style='color:#a6ce38;'> 杜兰特 </a>
						</div>
					</div>

					<div style="float:left;margin-left: 3px">
						<a onclick='showProductDetail(25)' href='javascript:void(0);'>
							<img src='../../common/image/1430716544968.jpg' width="280px"
							height="165px"> </a>
						<div class="camLiDes">
							<b> <a onclick='showProductDetail(25)'
								href='javascript:void(0);' style='color:#a6ce38;'> 转载-童年的记忆1
							</a> </b> - <a style='color:#ff0084;' onclick='showSort(1)'
								href="javascript:void(0);"> 原创 </a><br /> 2015-05-04 上传<br />
							作者:<a onclick="showUser(24)" href='javascript:void(0);'
								style='color:#a6ce38;'> 杜兰特 </a>
						</div>
					</div>

					<div style="clear:both"></div>
				</div>

				<div>
					<div class="toefl_h3" style="float:right">
						<a onclick="showSort(2)" href="javascript:void(0);">更多素材</a>
					</div>
					<div style="clear:both"></div>
				</div>
				<div class="toefl_dl">

					<div style="float:left;margin-left: 3px">
						<a onclick='showProductDetail(19)' href='javascript:void(0);'>
							<img src='../../common/image/1430715794475.jpg' width="280px"
							height="165px"> </a>
						<div class="camLiDes">
							<b> <a onclick='showProductDetail(19)'
								href='javascript:void(0);' style='color:#a6ce38;'> 素材-盒子 </a> </b> -
							<a style='color:#ff0084;' onclick='showSort(2)'
								href="javascript:void(0);"> 素材 </a><br /> 2015-05-04 上传<br />
							作者:<a onclick="showUser(24)" href='javascript:void(0);'
								style='color:#a6ce38;'> 杜兰特 </a>
						</div>
					</div>

					<div style="float:left;margin-left: 3px">
						<a onclick='showProductDetail(22)' href='javascript:void(0);'>
							<img src='../../common/image/1430715794475.jpg' width="280px"
							height="165px"> </a>
						<div class="camLiDes">
							<b> <a onclick='showProductDetail(22)'
								href='javascript:void(0);' style='color:#a6ce38;'> 素材-杯子 </a> </b> -
							<a style='color:#ff0084;' onclick='showSort(2)'
								href="javascript:void(0);"> 素材 </a><br /> 2015-05-04 上传<br />
							作者:<a onclick="showUser(24)" href='javascript:void(0);'
								style='color:#a6ce38;'> 杜兰特 </a>
						</div>
					</div>

					<div style="float:left;margin-left: 3px">
						<a onclick='showProductDetail(38)' href='javascript:void(0);'>
							<img src='../../common/image/1430723666891.jpg' width="280px"
							height="165px"> </a>
						<div class="camLiDes">
							<b> <a onclick='showProductDetail(38)'
								href='javascript:void(0);' style='color:#a6ce38;'>
									素材-乔丹上传的-1 </a> </b> - <a style='color:#ff0084;' onclick='showSort(2)'
								href="javascript:void(0);"> 素材 </a><br /> 2015-05-04 上传<br />
							作者:<a onclick="showUser(21)" href='javascript:void(0);'
								style='color:#a6ce38;'> 乔丹 </a>
						</div>
					</div>

					<div style="clear:both"></div>
				</div>

				<div>
					<div class="toefl_h3" style="float:right">
						<a onclick="showSort(3)" href="javascript:void(0);">更多转载</a>
					</div>
					<div style="clear:both"></div>
				</div>
				<div class="toefl_dl">

					<div style="float:left;margin-left: 3px">
						<a onclick='showProductDetail(26)' href='javascript:void(0);'>
							<img src='../../common/image/1430716572304.jpg' width="280px"
							height="165px"> </a>
						<div class="camLiDes">
							<b> <a onclick='showProductDetail(26)'
								href='javascript:void(0);' style='color:#a6ce38;'> 转载-童年的记忆2
							</a> </b> - <a style='color:#ff0084;' onclick='showSort(3)'
								href="javascript:void(0);"> 转载 </a><br /> 2015-05-04 上传<br />
							作者:<a onclick="showUser(24)" href='javascript:void(0);'
								style='color:#a6ce38;'> 杜兰特 </a>
						</div>
					</div>

					<div style="float:left;margin-left: 3px">
						<a onclick='showProductDetail(27)' href='javascript:void(0);'>
							<img src='../../common/image/1430716589153.jpg' width="280px"
							height="165px"> </a>
						<div class="camLiDes">
							<b> <a onclick='showProductDetail(27)'
								href='javascript:void(0);' style='color:#a6ce38;'> 转载-童年的记忆3
							</a> </b> - <a style='color:#ff0084;' onclick='showSort(3)'
								href="javascript:void(0);"> 转载 </a><br /> 2015-05-04 上传<br />
							作者:<a onclick="showUser(24)" href='javascript:void(0);'
								style='color:#a6ce38;'> 杜兰特 </a>
						</div>
					</div>

					<div style="float:left;margin-left: 3px">
						<a onclick='showProductDetail(28)' href='javascript:void(0);'>
							<img src='../../common/image/1430716609360.jpg' width="280px"
							height="165px"> </a>
						<div class="camLiDes">
							<b> <a onclick='showProductDetail(28)'
								href='javascript:void(0);' style='color:#a6ce38;'> 转载-童年的记忆4
							</a> </b> - <a style='color:#ff0084;' onclick='showSort(3)'
								href="javascript:void(0);"> 转载 </a><br /> 2015-05-04 上传<br />
							作者:<a onclick="showUser(24)" href='javascript:void(0);'
								style='color:#a6ce38;'> 杜兰特 </a>
						</div>
					</div>

					<div style="clear:both"></div>
				</div>

				<div>
					<div class="toefl_h3" style="float:right">
						<a onclick="showSort(4)" href="javascript:void(0);">更多欣赏</a>
					</div>
					<div style="clear:both"></div>
				</div>
				<div class="toefl_dl">

					<div style="float:left;margin-left: 3px">
						<a onclick='showProductDetail(52)' href='javascript:void(0);'>
							<img src='../../common/image/1430724122185.jpg' width="280px"
							height="165px"> </a>
						<div class="camLiDes">
							<b> <a onclick='showProductDetail(52)'
								href='javascript:void(0);' style='color:#a6ce38;'>
									欣赏-科比上传的-3 </a> </b> - <a style='color:#ff0084;' onclick='showSort(4)'
								href="javascript:void(0);"> 欣赏 </a><br /> 2015-05-04 上传<br />
							作者:<a onclick="showUser(22)" href='javascript:void(0);'
								style='color:#a6ce38;'> 科比 </a>
						</div>
					</div>

					<div style="float:left;margin-left: 3px">
						<a onclick='showProductDetail(54)' href='javascript:void(0);'>
							<img src='../../common/image/1430724179710.jpg' width="280px"
							height="165px"> </a>
						<div class="camLiDes">
							<b> <a onclick='showProductDetail(54)'
								href='javascript:void(0);' style='color:#a6ce38;'>
									欣赏-科比上传的-5 </a> </b> - <a style='color:#ff0084;' onclick='showSort(4)'
								href="javascript:void(0);"> 欣赏 </a><br /> 2015-05-04 上传<br />
							作者:<a onclick="showUser(22)" href='javascript:void(0);'
								style='color:#a6ce38;'> 科比 </a>
						</div>
					</div>

					<div style="float:left;margin-left: 3px">
						<a onclick='showProductDetail(75)' href='javascript:void(0);'>
							<img src='../../common/image/1430724973045.jpg' width="280px"
							height="165px"> </a>
						<div class="camLiDes">
							<b> <a onclick='showProductDetail(75)'
								href='javascript:void(0);' style='color:#a6ce38;'>
									欣赏-詹姆斯上传的-1 </a> </b> - <a style='color:#ff0084;' onclick='showSort(4)'
								href="javascript:void(0);"> 欣赏 </a><br /> 2015-05-04 上传<br />
							作者:<a onclick="showUser(23)" href='javascript:void(0);'
								style='color:#a6ce38;'> 詹姆斯 </a>
						</div>
					</div>

					<div style="clear:both"></div>
				</div>

			</div>
		</div>
		<!--页面左侧内容 end-->
		<!--页面右侧内容-->
		<div class="doc280 fn-right">
			<div class="toefl_indexSign">
				<div class="toefl_SignNum">
					<p>今日已经有24人</p>
					<p>使用图友</p>
				</div>
			</div>
			<!--热门小组-->
			<div class="index_itemR">
				<div class="index_itemRtitle">
					<h3>热门设计师</h3>
				</div>
				<div class="index_itemRHot">

					<dl>
						<dt>
							<a href="###"><img
								src="../../common/image/1430445170379125x125.jpg" width="48"
								height="48"> </a>
						</dt>
						<dd>
							<div class="fn-clear">

								<span class="index_itemRHotName" onclick="showUser()">李伟2233sss</span>
								<span class="index_itemRHotNum">三维动画师</span> <br> <span
									class="index_itemRHotNum">注册时间：2015-04-26</span>
							</div>
						</dd>
					</dl>

					<dl>
						<dt>
							<a href="###"><img src="../../common/image/1430718890753.jpg"
								width="48" height="48"> </a>
						</dt>
						<dd>
							<div class="fn-clear">

								<span class="index_itemRHotName" onclick="showUser()">乔丹</span>
								<span class="index_itemRHotNum">三维动画师</span> <br> <span
									class="index_itemRHotNum">注册时间：2015-05-03</span>
							</div>
						</dd>
					</dl>

					<dl>
						<dt>
							<a href="###"><img src="../../common/image/1430724435168.jpg"
								width="48" height="48"> </a>
						</dt>
						<dd>
							<div class="fn-clear">

								<span class="index_itemRHotName" onclick="showUser()">詹姆斯</span>
								<span class="index_itemRHotNum">flash动画师</span> <br> <span
									class="index_itemRHotNum">注册时间：2015-05-03</span>
							</div>
						</dd>
					</dl>

					<dl>
						<dt>
							<a href="###"><img src="../../common/image/1430723990029.jpg"
								width="48" height="48"> </a>
						</dt>
						<dd>
							<div class="fn-clear">

								<span class="index_itemRHotName" onclick="showUser()">科比</span>
								<span class="index_itemRHotNum">三维动画师</span> <br> <span
									class="index_itemRHotNum">注册时间：2015-05-03</span>
							</div>
						</dd>
					</dl>

					<dl>
						<dt>
							<a href="###"><img src="../../common/image/1430725414603.jpg"
								width="48" height="48"> </a>
						</dt>
						<dd>
							<div class="fn-clear">

								<span class="index_itemRHotName" onclick="showUser()">麦迪</span>
								<span class="index_itemRHotNum">学生</span> <br> <span
									class="index_itemRHotNum">注册时间：2015-05-04</span>
							</div>
						</dd>
					</dl>

				</div>

			</div>
			<!--最新公开课-->
			<div class="index_itemR">
				<div class="index_itemRtitle">
					<h3>最新评论</h3>
				</div>
				<div class="index_itemROpen">

					<dl>
						<dt class="now">
							<a href="###"><img src="../../common/image/1430724435168.jpg"
								width="48" height="48"> </a>
						</dt>
						<dd>
							<div class="index_itemROpenTitle">
								<a href="###"> 非常漂亮的制作，样子很精美，很朴素整洁，非常适合做手机桌面 </a>
							</div>
							<div class="index_itemROpenText">
								<span>詹姆斯</span><span>2015-05-04 16:12:20</span>
							</div>
						</dd>
					</dl>


					<dl>
						<dt class="now">
							<a href="###"><img src="../../common/image/1430724435168.jpg"
								width="48" height="48"> </a>
						</dt>
						<dd>
							<div class="index_itemROpenTitle">
								<a href="###"> 非常漂亮的制作，样子很精美，很朴素整洁，非常适合做手机桌面 </a>
							</div>
							<div class="index_itemROpenText">
								<span>詹姆斯</span><span>2015-05-04 16:12:18</span>
							</div>
						</dd>
					</dl>


					<dl>
						<dt class="now">
							<a href="###"><img src="../../common/image/1430724435168.jpg"
								width="48" height="48"> </a>
						</dt>
						<dd>
							<div class="index_itemROpenTitle">
								<a href="###"> 非常漂亮的制作，样子很精美，很朴素整洁，非常适合做手机桌面 </a>
							</div>
							<div class="index_itemROpenText">
								<span>詹姆斯</span><span>2015-05-04 16:12:15</span>
							</div>
						</dd>
					</dl>


					<dl>
						<dt class="now">
							<a href="###"><img src="../../common/image/1430724435168.jpg"
								width="48" height="48"> </a>
						</dt>
						<dd>
							<div class="index_itemROpenTitle">
								<a href="###"> 非常漂亮的制作，样子很精美，很朴素整洁，非常适合做手机桌面 </a>
							</div>
							<div class="index_itemROpenText">
								<span>詹姆斯</span><span>2015-05-04 16:12:13</span>
							</div>
						</dd>
					</dl>


					<dl>
						<dt class="now">
							<a href="###"><img src="../../common/image/1430724435168.jpg"
								width="48" height="48"> </a>
						</dt>
						<dd>
							<div class="index_itemROpenTitle">
								<a href="###"> 非常漂亮的制作，样子很精美，很朴素整洁，非常适合做手机桌面 </a>
							</div>
							<div class="index_itemROpenText">
								<span>詹姆斯</span><span>2015-05-04 16:12:10</span>
							</div>
						</dd>
					</dl>




				</div>

			</div>



		</div>
		<!--页面右侧内容 end-->

	</div>

	<!-- 代码结束 -->
</body>
</html>
