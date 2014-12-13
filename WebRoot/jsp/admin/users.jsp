<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <link rel="stylesheet" href="css/common/detail.css"
	type="text/css"></link>
    <base href="<%=basePath%>">
    
    <title>用户管理</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
<script type="text/javascript" src="js/common/jquery-1.11.1.js"></script>
</head>
<script type="text/javascript">
	function editUser(obj,id,username,sex,tel,email,department,password,type){
		  
		   $.ajax({
			
				url : "loadDepartment.action",
				type : 'POST',
				dataType : 'text',
				ContentType : 'application/json; charset=utf-8',
				success : function(data) {
					var zNodes = JSON.parse(data);
					$.each(zNodes, function (id, name) {
                        $("#selectDepartment").append("<option value=" + name.id + ">" + name.name + "</option>");
                    });
                      jQuery("#edit").css("left",jQuery(obj).offset().left);
			          jQuery("#edit").css("top",jQuery(obj).offset().top+jQuery(obj).outerHeight());            
			          jQuery("#id").val(id);
			          jQuery("#username").val(username);
			          jQuery("#sex").val(sex);
			          jQuery("#tel").val(tel);
			          jQuery("#email").val(email);
			          jQuery("#selectDepartment").val(department);
			          
			          jQuery("#type").val(type);
			          jQuery("#edit").show();
			
				},
				error : function(msg) {
					alert('无法取得用户信息！');
				}
			});
		  
		  
		 
             
             
	}
	
	function hide(){
		jQuery("#edit").hide();
	}
	function hide2(){
		jQuery("#add").hide();
	}
	function check(){
	if(document.getElementById("add_username").value == "" || document.getElementById("add_username").value == null || 
		document.getElementById("add_password").value == "" || document.getElementById("add_password").value == null
		){
		alert("用户名或密码不能为空");
		return false;
	}
		return true;
		
	}
	function adduser(obj){
		 $.ajax({
			
				url : "loadDepartment.action",
				type : 'POST',
				dataType : 'text',
				ContentType : 'application/json; charset=utf-8',
				success : function(data) {
					var zNodes = JSON.parse(data);
					$.each(zNodes, function (id, name) {
                        $("#add_department").append("<option value=" + name.id + ">" + name.name + "</option>");
                    });
                      jQuery("#add").css("left",jQuery(obj).offset().left);
			          jQuery("#add").css("top",jQuery(obj).offset().top+jQuery(obj).outerHeight());            
			      
			          jQuery("#add").show();
			
				},
				error : function(msg) {
					alert('无法取得用户信息！');
				}
			});
	}
</script>
<body>

	<div id="main">
		<div >
			<jsp:include   page="../../jsp/common/maintop.jsp" flush="true"/>  
		</div>
		<div id="content">
			<div id="leftmenu" >
		
				
			</div>
			<div id="content_text">
			<input type="button" value="增加用户" onclick="adduser(this)" style="margin-left: 60px;">
			<div id="add" style="display:none; position:absolute;width:360px;background-color:#eeffdd; border:1px solid #BEC0BF;padding:5px;font-size:12px;">
  
			<form action="userManage!addUser.action" method="post" >
		  		<input type="text" id="add_id" name="add_id" style="display: none;">
		  		用户名：
		  		<input type="text" id="add_username" name="add_username"> <br />
		  		性别：
		  		<select  id="add_sex" name="add_sex"> 
		  			<option value="false">男</option>
		  			<option value="true">女</option>
		  		</select><br />
		  		电话：
		  		<input type="text" id="add_tel" name="add_tel" onkeyup="this.value=value.replace(/[^\d]/g,'')"    onbeforepaste=   "clipboardData.setData('text',clipboardData.getData('text').replace(/[^\d]/g,''))" ><br />
		  		Email：
		  		<input type="text" id="add_email" name="add_email"><br />
		  		所属部门：
		  		<select id="add_department" name="add_department"></select><br />
		  		密码：
		  		<input type="password" id="add_password" name="add_password"><br />
		  		用户类型：
		  		<select  id="add_type" name="add_type"> 
		  			<option value=2>学生</option>
		  			<option value=0>管理员</option>
		  			<option value=1>教师</option>
		  			
		  		</select><br />
		  		<input type="submit" value="提交" onclick="return check();">
		  		<input type="button" onclick="hide2()" value="取消">
  			</form>
  			</div>
			<table style="margin-left: 50px;">
			<p>当前系统普通用户：</p> <br />
			  <tr id="topic">
			  		<td ></td>
			  		<td ></td>
			  		<td >ID</td>
			  		<td style="text-align: center;">用户名</td>
			  		<td >创建时间</td>
			  		<td >身份</td>
			  		<td >TEL</td>
			  		<td >Email</td>
			
			  	</tr>
			  <c:forEach var="one" items="${users }">
			  	<tr class="item">
 			  		<td ><a href="userManage!deleteUser.action?deleteId=${one.id }" title="删除用户"><img src="images/common/delete.png" alt="delete"></a></td>
			  		<td ><a title="编辑" onclick="editUser(this ,'${one.id }','${one.username }','${one.sex }','${one.tel }','${one.email }','${one.department.id }','${one.password }','${one.type }');" ><img src="images/common/user_edit.png" alt="edit"></a></td>
			  		
			  		<td >${one.id}</td>
			  		<td >${one.username}</td>
			  		<td >${one.RDate }</td>
			  		<c:if test="${one.type == 1 }">
						<td>教师</td>
					</c:if>
					<c:if test="${one.type == 2 }">
						<td>学生</td>
					</c:if>
					
			  		<td >${one.tel }</td>
			  		<td >${one.email }</td>
			  	</tr>
			  </c:forEach>
  
  </table>
   <HR style="FILTER: alpha(opacity=100,finishopacity=0,style=2)" width="96%" color= "blue" SIZE=10>
  
  	共${resultNum }条数据；分${pageNum }页
 	<c:url value="userManage.action" var="first">  
       <c:param name="currentPage" value="1" />    
      </c:url>
      <a href="${first}">首页</a>
      
      <c:url value="userManage.action" var="last">  
       <c:param name="currentPage" value="${currentPage -1 }" />    
      </c:url>
      <c:choose>
       <c:when test="${currentPage==1}"> 
        上一页
       </c:when>
       <c:otherwise>
        <a href="${last}">上一页</a> 
       </c:otherwise>
      </c:choose>
      第${currentPage }页
      <c:url value="userManage.action" var="next">  
       <c:param name="currentPage" value="${currentPage + 1 }" />    
      </c:url>
         <c:choose>
       <c:when test="${currentPage==pageNum}"> 
       	 下一页
       </c:when>
       <c:otherwise>
        <a href="${next}">下一页</a> 
       </c:otherwise>
      </c:choose>
      <c:url value="userManage.action" var="end">  
       <c:param name="currentPage" value="${pageNum }" />    
      </c:url>
      <a href="${end}">尾页</a>
  <div id="edit" style="display:none; position:absolute;width:360px;background-color:#eeffdd; border:1px solid #BEC0BF;padding:5px;font-size:12px;">
  	<form action="userManage!editUser.action" method="post">
  		<input type="text" id="id" name="edit_id" style="display: none;">
  		用户名：
  		<input type="text" id="username" name="edit_username"> <br />
  		性别：
  		<select  id="sex" name="edit_sex"> 
  			<option value="false">男</option>
  			<option value="true">女</option>
  		</select><br />
  		电话：
  		<input type="text" id="tel" name="edit_tel" onkeyup="this.value=value.replace(/[^\d]/g,'')"    onbeforepaste=   "clipboardData.setData('text',clipboardData.getData('text').replace(/[^\d]/g,''))" ><br />
  		Email：
  		<input type="text" id="email" name="edit_email"><br />
  		所属部门：
  		<select id="selectDepartment" name="edit_department"></select><br />
  		密码：
  		<input type="password" id="password" name="edit_password"><br />
  		用户类型：
  		<select  id="type" name="edit_type"> 
  			<option value=0>管理员</option>
  			<option value=1>教师</option>
  			<option value=2>学生</option>
  		</select><br />
  		<input type="submit" value="确认修改">
  		<input type="button" onclick="hide()" value="取消">
  	</form>
  </div>
			</div>
		</div>

	</div>
</body>
</html>
