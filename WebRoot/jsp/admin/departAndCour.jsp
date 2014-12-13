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
<script type="text/javascript">
	function addDepart(obj){
		jQuery("#addDepartment").css("left",jQuery(obj).offset().left);
		jQuery("#addDepartment").css("top",jQuery(obj).offset().top+jQuery(obj).outerHeight());
		jQuery("#addDepartment").show();            
	}
	function editDepart(obj,id,name,snum,tnum){
		jQuery("#editDepartment").css("left",jQuery(obj).offset().left);
		jQuery("#editDepartment").css("top",jQuery(obj).offset().top+jQuery(obj).outerHeight());
		
		jQuery("#editDeName").val(name);
		jQuery("#editDeSNum").val(snum);
		jQuery("#editDeTNum").val(tnum);
		jQuery("#editDeId").val(id);
		
		jQuery("#editDepartment").show();            
	}
	function hideEditD(){
		jQuery("#editDepartment").hide();
	}
	function check(){
	if(document.getElementById("addDeName").value == "" || document.getElementById("addDeName").value == null || 
		document.getElementById("addDeSNum").value == "" || document.getElementById("addDeSNum").value == null ||
		document.getElementById("addDeTNum").value == "" || document.getElementById("addDeTNum").value == null
		){
		alert("请填写完整信息！");
		return false;
	}
		return true;
		
	}
	function checkeditD(){
	if(document.getElementById("editDeName").value == "" || document.getElementById("editDeName").value == null || 
		document.getElementById("editDeSNum").value == "" || document.getElementById("editDeSNum").value == null ||
		document.getElementById("editDeTNum").value == "" || document.getElementById("editDeTNum").value == null
		){
		alert("请填写完整信息！");
		return false;
	}
		return true;
		
	}
	function hide(){
		jQuery("#addDepartment").hide();
	}
	function hide2(){
		jQuery("#addCourse").hide();
	}
	function check2(){
	if(document.getElementById("addCName").value == "" || document.getElementById("addCName").value == null || 
		document.getElementById("addCHour").value == "" || document.getElementById("addCHour").value == null 
		){
		alert("请填写完整课程信息！");
		return false;
	}
		return true;
		
	}
	function checkEditC(){
	if(document.getElementById("editCName").value == "" || document.getElementById("editCName").value == null || 
		document.getElementById("editCHour").value == "" || document.getElementById("editCHour").value == null 
		){
		alert("请填写完整课程信息！");
		return false;
	}
		return true;
		
	}
	function addCourse(obj){
		 $.ajax({
			
				url : "loadDepartment.action",
				type : 'POST',
				dataType : 'text',
				ContentType : 'application/json; charset=utf-8',
				success : function(data) {
					var zNodes = JSON.parse(data);
					$.each(zNodes, function (id, name) {
                        $("#addCDepartment").append("<option value=" + name.id + ">" + name.name + "</option>");
                    });
                      jQuery("#addCourse").css("left",jQuery(obj).offset().left);
			          jQuery("#addCourse").css("top",jQuery(obj).offset().top+jQuery(obj).outerHeight());
			                      
			     
			      		
			      		
			          jQuery("#addCourse").show();
			
				},
				error : function(msg) {
					alert('无法取得相关信息！');
				}
			});
	}
	function editCourse(obj,id,name,examtype,hours,departmentid,book){
		 $.ajax({
			
				url : "loadDepartment.action",
				type : 'POST',
				dataType : 'text',
				ContentType : 'application/json; charset=utf-8',
				success : function(data) {
					var zNodes = JSON.parse(data);
					$.each(zNodes, function (id, name) {
                        $("#editCDepartment").append("<option value=" + name.id + ">" + name.name + "</option>");
                    });
                      jQuery("#editCourse").css("left",jQuery(obj).offset().left);
			          jQuery("#editCourse").css("top",jQuery(obj).offset().top+jQuery(obj).outerHeight());            
			      
			       	  jQuery("#editCName").val(name);
			       	  jQuery("#editCHour").val(hours);
			       	  jQuery("#editCExamType").val(examtype);
			       	  jQuery("#editCDepartment").val(departmentid);
			       	  jQuery("#editCBook").val(book);
			       	  jQuery("#editCourId").val(id);
			          jQuery("#editCourse").show();
			
				},
				error : function(msg) {
					alert('无法取得课程信息！');
				}
			});
	}
	function hideEditC(){
		jQuery("#editCourse").hide();
	}
</script>
</head>

<body>

	<div id="main">
		<div >
			<jsp:include   page="../../jsp/common/maintop.jsp" flush="true"/>  
		</div>
		<div id="content_text" style="overflow-x:hidden;overflow-y:scroll;height:350px;width: 40%;margin-left: 40px;float: left;margin-top: 50px;">
		 <input type="button" value="新增部门" onclick="addDepart(this)">
			  <div id="addDepartment" style="display:none; position:absolute;width:360px;background-color:#eeffdd; border:1px solid #BEC0BF;padding:5px;font-size:12px;">
			  	<form action="depart_cour!addDepartment.action" method="post">
			  		<table>
			  			<tr><td>部门（学院）名称：</td><td><input type="text" name="addDeName" id="addDeName"></td></tr>
			  			<tr><td>教师总数</td><td><input type="text" name="addDeSNum" id="addDeSNum" onkeyup="this.value=value.replace(/[^\d]/g,'')"    onbeforepaste=   "clipboardData.setData('text',clipboardData.getData('text').replace(/[^\d]/g,''))" ></td></tr>
			  			<tr><td>学生总数</td><td><input type="text" name="addDeTNum" id="addDeTNum" onkeyup="this.value=value.replace(/[^\d]/g,'')"    onbeforepaste=   "clipboardData.setData('text',clipboardData.getData('text').replace(/[^\d]/g,''))" ></td></tr>
			  			<tr><td><input type="submit" value="提交" onclick="return check();"><input type="reset" value="重置"></td><td><input type="button" onclick="hide()" value="取消"></td></tr>
			  		</table>
			  	</form>
			  </div>
		<table >
				<tr id="topic">
 			  		<td ></td>
			  		<td ></td>
			  		
			  		<td >ID</td>
			  		<td >名称</td>
			  		<td >学生数目</td>
			  		<td >教师数目</td>
			  		
			  	</tr>
			<c:forEach var="one" items="${departments }">
			  
			  	<tr class="item">
 			  		<td ><a href="depart_cour!deleteDepartment.action?deleteDId=${one.id }" title="删除部门"><img src="images/common/delete.png" alt="delete"></a></td>
			  		<td ><a title="编辑" onclick="editDepart(this,'${one.id}','${one.name}','${one.studentSum }','${one.teacherSum }')"><img src="images/common/user_edit.png" alt="edit"></a></td>
			  		
			  		<td >${one.id}</td>
			  		<td >${one.name}</td>
			  		<td >${one.studentSum }</td>
			  		<td >${one.teacherSum }</td>
			  		
			  	</tr>
			  </c:forEach>
			  </table>
			  </div>
			  <div style="overflow-x:hidden;overflow-y:scroll;height:350px;width: 40%;margin-left: 40px;float: left;margin-top: 50px;">
			  <input type="button" value="新增课程" onclick="addCourse(this)">
			  <div id="addCourse" style="display:none; position:absolute;width:360px;background-color:#eeffdd; border:1px solid #BEC0BF;padding:5px;font-size:12px;">
			  	<form action="depart_cour!addCourse.action" method="post">
			  		<table>
			  			<tr><td>课程名称：</td><td><input type="text" name="addCName" id="addCName"></td></tr>
			  			<tr><td>课时</td><td><input type="text" name="addCHour" id="addCHour" onkeyup="this.value=value.replace(/[^\d]/g,'')"    onbeforepaste=   "clipboardData.setData('text',clipboardData.getData('text').replace(/[^\d]/g,''))" ></td></tr>
			  			<tr><td>考察方式</td><td>
			  			<select name="addCExamType">
			  				<option value=0>闭卷考试</option>
			  				<option value=1>开卷考试</option>
			  				<option value=2>作业</option>
			  			</select>
			  			</td></tr>
			  			<tr><td>所属部门（学院）</td><td>
			  			<select name="addCDepartment" id="addCDepartment">
			  			
			  			</select>
			  			</td></tr>
			  			<tr><td>参考书</td><td><input type="text" name="addCBook"></td></tr>
			  			
			  			<tr><td><input type="submit" value="提交" onclick="return check2();"><input type="reset" value="重置"></td><td><input type="button" onclick="hide2()" value="取消"></td></tr>
			  		</table>
			  	</form>
			  </div>
			  <table >
				<tr id="topic">
 			  		<td ></td>
			  		<td ></td>
			  		
			  		<td >ID</td>
			  		<td >名称</td>
			  		<td >课时</td>
			  		<td >考察方式</td>
			  		<td >所属学院</td>
			  		
			  	</tr>
			<c:forEach var="one" items="${courses }">
			  
			  	<tr class="item">
 			  		<td ><a href="depart_cour!deleteCourse.action?deleteCId=${one.id }" title="删除课程"><img src="images/common/delete.png" alt="delete"></a></td>
			  		<td ><a title="编辑" onclick="editCourse(this,'${one.id}','${one.name}','${one.examType }','${one.hours }','${one.department.id }','${one.bookname }')"><img src="images/common/user_edit.png" alt="edit"></a></td>
			  		
			  		<td >${one.id}</td>
			  		<td >${one.name}</td>
			  		<td >${one.hours }</td>
			  	
			  		<c:if test="${one.examType == 0 }">
						<td>闭卷考试</td>
					</c:if>
					<c:if test="${one.examType == 1 }">
						<td>开卷考试</td>
					</c:if>
					<c:if test="${one.examType == 2 }">
						<td>作业</td>
					</c:if>
			  		<td >${one.department.name }</td>
			  		
			  	</tr>
			  </c:forEach>
			  </table>
		</div>
	</div>
	<div id="editDepartment" style="display:none; position:absolute;width:360px;background-color:#eeffdd; border:1px solid #BEC0BF;padding:5px;font-size:12px;">
		<form action="depart_cour!editDepartment.action" method="post">
			<table>
	  			<tr><td></td><td><input type="text" name="editDeId" id="editDeId" style="display: none;"></td></tr>
	  			<tr><td>部门（学院）名称：</td><td><input type="text" name="editDeName" id="editDeName"></td></tr>
	  			<tr><td>教师总数</td><td><input type="text" name="editDeSNum" id="editDeSNum" onkeyup="this.value=value.replace(/[^\d]/g,'')"    onbeforepaste=   "clipboardData.setData('text',clipboardData.getData('text').replace(/[^\d]/g,''))"  ></td></tr>
	  			<tr><td>学生总数</td><td><input type="text" name="editDeTNum" id="editDeTNum" onkeyup="this.value=value.replace(/[^\d]/g,'')"    onbeforepaste=   "clipboardData.setData('text',clipboardData.getData('text').replace(/[^\d]/g,''))" ></td></tr>
	  			<tr><td><input type="submit" value="提交" onclick="return checkeditD();"><input type="reset" value="重置"></td><td><input type="button" onclick="hideEditD()" value="取消"></td></tr>
			</table>
		</form>
	</div>
	
	 <div id="editCourse" style="display:none; position:absolute;width:360px;background-color:#eeffdd; border:1px solid #BEC0BF;padding:5px;font-size:12px;">
			  	<form action="depart_cour!editCourse.action" method="post">
			  		<table>
			  		<tr><td></td><td><input type="text" name="editCourId" id="editCourId" style="display: none;"></td></tr>
			  			<tr><td>课程名称：</td><td><input type="text" name="editCName" id="editCName"></td></tr>
			  			<tr><td>课时</td><td><input type="text" name="editCHour" id="editCHour" onkeyup="this.value=value.replace(/[^\d]/g,'')"    onbeforepaste=   "clipboardData.setData('text',clipboardData.getData('text').replace(/[^\d]/g,''))" ></td></tr>
			  			<tr><td>考察方式</td><td>
			  			<select name="editCExamType" id="editCExamType">
			  				<option value=0>闭卷考试</option>
			  				<option value=1>开卷考试</option>
			  				<option value=2>作业</option>
			  			</select>
			  			</td></tr>
			  			<tr><td>所属部门（学院）</td><td>
			  			<select name="editCDepartment" id="editCDepartment">
			  			
			  			</select>
			  			</td></tr>
			  			<tr><td>参考书</td><td><input type="text" name="editCBook" id="editCBook"></td></tr>
			  			
			  			<tr><td><input type="submit" value="提交" onclick="return checkEditC();"><input type="reset" value="重置"></td><td><input type="button" onclick="hideEditC()" value="取消"></td></tr>
			  		</table>
			  	</form>
			  </div>

</body>
</html>