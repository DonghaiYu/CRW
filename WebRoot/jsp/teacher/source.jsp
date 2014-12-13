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

<title>山东科技大学课程资源网(教师资源下载)</title>
<link rel="stylesheet" href="css/zTreeStyle/zTreeStyle.css"
	type="text/css"></link>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<script type="text/javascript" src="js/common/jquery-1.11.1.js"></script>
<script type="text/javascript"
	src="js/common/jquery.ztree.all-3.5.min.js"></script>
<script type="text/javascript" src="js/common/json2.js"></script>
</head>

<body>
	<script type="text/javascript">
		function setFontCss(treeId, treeNode) {
			return {};
 		};
 			var setting = {
			view : {
				fontCss : setFontCss,
				showLine : false, //是否显示节点间的连线  
				checkable : false, //每个节点上是否显示 CheckBox  
				selectedMulti : false
			},
			data : {
				simpleData : {
					enable : true,
					idKey : "id",
					pIdKey : "pId",
					rootPId : "0"
				}
			},
			treeNodeKey : "id", 
			treeNodeParentKey : "pId"

		};
		function createTree() {
			$.ajax({
				url : "loadZTree.action",
				type : 'POST',
				dataType : 'text',
				ContentType : 'application/json; charset=utf-8',
				success : function(data) {

					var zNodes = JSON.parse(data);
					var t = $("#tree");
					t = $.fn.zTree.init(t, setting, zNodes);
				},
				error : function(msg) {
					alert('树加载异常！');
				}
			});
		}
		jQuery(document).ready(function() {
			createTree();

		});
	</script>
	<div id="main">
		<div>
			<jsp:include page="../../jsp/common/maintop.jsp" flush="true" />
		</div>
		<div id="content">
			<div id="leftmenu" style="width:20%; float: left;padding-top: 20px;" >
				<ul id="tree" class="ztree">
				</ul>

			</div>
			<div id="showdetail" style="float:left;padding-top: 20px;width: 70%;">
				<iframe name="showdetaile_iframe"  width="100%" height="500px" src="jsp/common/detail.jsp">
				
				</iframe>
			</div>
		</div>

	</div>
</body>
</html>
