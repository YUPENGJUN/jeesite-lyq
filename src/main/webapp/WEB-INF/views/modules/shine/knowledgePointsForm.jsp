<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>知识点管理管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			//$("#name").focus();
			$("#inputForm").validate({
				submitHandler: function(form){
					loading('正在提交，请稍等...');
					form.submit();
				},
				errorContainer: "#messageBox",
				errorPlacement: function(error, element) {
					$("#messageBox").text("输入有误，请先更正。");
					if (element.is(":checkbox")||element.is(":radio")||element.parent().is(".input-append")){
						error.appendTo(element.parent().parent());
					} else {
						error.insertAfter(element);
					}
				}
			});
		});
	</script>
	<script type="text/javascript">
		$(function(){
			$("#a1").click(function(){
				$("#b2").attr("value","");
				$("#a2").hide();
			});
			$("#a2").click(function(){
				$("#b1").attr("value","");
				$("#a1").hide();
			});
		}); 
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li><a href="${ctx}/shine/knowledgePoints/">知识点管理列表</a></li>
		<li class="active"><a href="${ctx}/shine/knowledgePoints/form?id=${knowledgePoints.id}">知识点管理<shiro:hasPermission name="shine:knowledgePoints:edit">${not empty knowledgePoints.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="shine:knowledgePoints:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="knowledgePoints" action="${ctx}/shine/knowledgePoints/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>		
		<div class="control-group">
			<label class="control-label">标题：</label>
			<div class="controls">
				<form:input path="title" htmlEscape="false" maxlength="255" class="input-xlarge "/>
			</div>
		</div>
		<div id="a1" class="control-group">
			<label class="control-label">指向URL：</label>
			<div class="controls">
				<form:input id="b1" path="url" htmlEscape="false" maxlength="255" class="input-xlarge "/><h6 style="color: #3d6c9e">温馨提示:指向URL和相关附件URL只能填一个</h6>
			</div>
		</div>
		<div id="a2" class="control-group">
			<label class="control-label">相关附件URL：</label>
			<div class="controls">
				<form:input id="b2" path="annexUrl" htmlEscape="false" maxlength="255" class="input-xlarge "/><h6 style="color: #3d6c9e">温馨提示:指向URL和相关附件URL只能填一个</h6>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">知识内容：</label>
			<div class="controls">
				<form:textarea rows="5" cols="20" path="knowledgeContent" htmlEscape="false" maxlength="4000" class="input-xlarge "/>
			</div>
		</div>
		<%-- <div class="control-group">
			<label class="control-label">状态：</label>
			<div class="controls">
				<form:input path="status" htmlEscape="false" maxlength="255" class="input-xlarge "/>
			</div>
		</div> --%>
		<div class="form-actions">
			<shiro:hasPermission name="shine:knowledgePoints:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>