<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>知识点管理管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			
		});
		function page(n,s){
			$("#pageNo").val(n);
			$("#pageSize").val(s);
			$("#searchForm").submit();
        	return false;
        }
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/shine/knowledgePoints/">知识点管理列表</a></li>
		<shiro:hasPermission name="shine:knowledgePoints:edit"><li><a href="${ctx}/shine/knowledgePoints/form">知识点管理添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="knowledgePoints" action="${ctx}/shine/knowledgePoints/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>标题：</label>
				<form:input path="title" htmlEscape="false" maxlength="255" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>标题</th>
				<th>指向URL</th>
				<th>附件URL</th>
				<th>知识内容</th>
				<!-- <th>状态</th> -->
				<shiro:hasPermission name="shine:knowledgePoints:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="knowledgePoints">
			<tr>
				<td><a href="${ctx}/shine/knowledgePoints/form?id=${knowledgePoints.id}">
					${knowledgePoints.title}
				</a></td>
				<td>
					${knowledgePoints.url}
				</td>
				<td>
					${knowledgePoints.annexUrl}
				</td>
				<td>
					${knowledgePoints.knowledgeContent}
				</td>
				<%-- <td>
					${knowledgePoints.status} 
				</td> --%>
				<%-- <td>
					<fmt:formatDate value="${knowledgePoints.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td> --%>
				<shiro:hasPermission name="shine:knowledgePoints:edit"><td>
    				<a href="${ctx}/shine/knowledgePoints/form?id=${knowledgePoints.id}">修改</a>
					<a href="${ctx}/shine/knowledgePoints/delete?id=${knowledgePoints.id}" onclick="return confirmx('确认要删除该知识点管理吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>