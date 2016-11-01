<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <title>api测试</title>
</head>
<body>
<div>
<form id="testForm" method="post" action="${ctx}/doApiTest">
API SERVER:
<input type="text" id="apiServer" name="apiServer" value="${defaultApiServer}" size="50"/><br>
API &nbsp;&nbsp;&nbsp;KEY:
<input type="text" id="apiId" name="apiId" value="${defaultApiId}" size="50"/><br>
API SECRET:
<input type="text" id="apiSecret" name="apiSecret" value="${defaultApiSecret}" size="50"/><br>
API &nbsp;列表：
<select id="functioncode" name="functioncode" style="width:335px">
	<c:forEach items="${functionCodeCatalogMap}" var="cata">
	<option value="${cata.key}">(${cata.key})${cata.value}</option>
	<c:forEach items="${functionCodeListMap[cata.key]}" var="item">
	<option value="${item.key}">------------(${item.key})${item.value}</option>
	</c:forEach>
	</c:forEach>
</select>
&nbsp;&nbsp;&nbsp;<a href="http://10.10.1.3:8090/wiki/display/epeit/API" target="_blank"><u>API文档</u></a>
<br>
API &nbsp;参数：&nbsp;<input type="button" value="增加一个参数" id="btnAddParam"/>
<table style="margin-left:100px">
<thead>
	<tr>
		<td width="50px" align="center">操作</td>
		<td width="150px" align="center">参数名称</td>
		<td width="150px" align="center">值</td>
	</tr>
</thead>
<tbody id="paramTable">
	<tr>
		<td><input type="button" value="删除" onclick="javascript:$(this).parent().parent().remove();"/></td>
		<td><input type="text" name="paramName" value=""/></td>
		<td><input type="text" name="paramValue" value=""/></td>
	</tr>
</tbody>
</table>
<br>
<input type="button" value="提交测试" id="btnSubmit"/>
</form>
</div>
<div>
</div>
<div>
<textarea rows="30" cols="100" id="apiRsp"></textarea>
</div>
<script type="text/javascript" src="${ctx}/js/jquery-1.8.2.min.js"></script>
<script type="text/javascript" src="${ctx}/js/jquery.validate.min.js"></script>
<script type="text/javascript" src="${ctx}/js/common.js"></script>
<script type="text/javascript">
$(function(){
	var successCallback=function(data){
		$("#apiRsp").val(JSON.stringify(data));
	};
	$("#testForm").validate({
		errorPlacement:function(error,element){
			var errorT = element.parent().next();
			error.appendTo(errorT);
		},
		rules:{
			apiServer:{
				required:true
			},
			apiId:{
				required:true
			},
			apiSecret:{
				required:true
			},
			functioncode:{
				required:true
			}
		},
		onkeyup: false,
		submitHandler:function(form){
			$("#apiRsp").val("");
			$(form).ajaxForm({successCallback:successCallback});
		}
	});	
	$("#btnSubmit").click(function(){
		$("#testForm").submit();
	});
	$("#btnAddParam").click(function(){
		var html='';
		html+='<tr>';
		html+='<td><input type="button" value="删除" onclick="javascript:$(this).parent().parent().remove();"/></td>';
		html+='<td><input type="text" name="paramName" value=""/></td>';
		html+='<td><input type="text" name="paramValue" value=""/></td>';
		html+='</tr>';
		$("#paramTable").append(html);
	});
});
</script>
</body>
</html>