<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>山东科技大学课程资源网(管理员首页)</title>
<link rel="stylesheet" type="text/css" href="css/common/main.css">
<link href="css/common/jquery.slideBox.css" rel="stylesheet" type="text/css" />

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<script type="text/javascript" src="js/common/jquery-1.11.1.js"></script>
<script src="js/common/jquery.slideBox.min.js" type="text/javascript"></script>

</head>

<body>

	<div id="main">
		<div >
			<jsp:include   page="../../jsp/common/maintop.jsp" flush="true"/>  
		</div>
		<div id="content" >
			<div id="intro" style="display:none; width: 350px;float: left;padding-left: 30px;height: 600px;">
				<p style="margin-top: 20px" class="li_content">山东科技大学建校于1951年，现已发展成为一所工科优势突出，行业特色鲜明，工学、理学、管理学、文学、法学、经济学、艺术学等多学科相互渗透、协调发展的省属重点大学。学校是山东省重点建设的应用基础型人才培养特色名校。</p>
<p class="li_content">学校在青岛、泰安、济南三地办学，总占地面积243万平方米（3640余亩），建筑面积142万平方米，固定资产总值17.95亿元、教学仪器设备总值4.69亿元。</p>
<p class="li_content">学校设有19个学院、9个教学系（部）、4个科研机构和1个独立学院。有9个博士后科研流动站；8个博士学位授权一级学科，43个博士学位授权二级学科；24个硕士学位授权一级学科，127个硕士学位授权二级学科；6个硕士专业学位类别，其中工程硕士包含19个授权领域；78个本科专业。</p>
			</div>
			<div id="indexPictures" class="slideBox" style="margin: 20px 30px;float: left;">
			  <ul class="items">
			    <li><a href="http://www.sdust.edu.cn/index__961B1ED2743D8B3C09557614BBAFB44A.htm" title="校园风景·花海之花" target="_blank"><img src="images/common/1.jpg"></a></li>
			    <li><a href="http://www.sdust.edu.cn/index__961B1ED2743D8B3C09557614BBAFB44A.htm" title="校园风景·小西湖" target="_blank"><img src="images/common/2.jpg"></a></li>
			    <li><a href="http://www.sdust.edu.cn/index__961B1ED2743D8B3C09557614BBAFB44A.htm" title="海洋之情·浪花" target="_blank"><img src="images/common/3.jpg"></a></li>
			    <li><a href="http://www.sdust.edu.cn/index__961B1ED2743D8B3C09557614BBAFB44A.htm" title="海洋之情·沙滩之沙" target="_blank"><img src="images/common/4.jpg"></a></li>
			  </ul>
			</div>
			<div id="content_text">
			
			<!-- <img alt="首页" src="images/common/mainindex.jpg" width="800" style="border-right-style: double;border-right-width: 5px;margin-left: 170px"> -->
			</div>
		</div>

	</div>
	<script>
jQuery(function($){
		var winNode = $("#intro");  
   	 winNode.fadeIn("slow"); 
	$('#indexPictures').slideBox({
		duration : 0.5,//滚动持续时间，单位：秒
		easing : 'swing',//swing,linear//滚动特效
		delay : 5 //滚动延迟时间，单位：秒
	
	});
	});
</script>
</body>
</html>
