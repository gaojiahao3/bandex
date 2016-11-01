<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/pages/common/taglibs.jsp" %>
<!DOCTYPE html>
<html>
<head>
	<title>编辑配置</title>
    <%@ include file="/WEB-INF/pages/common/mainCss.jsp" %>
</head>

<body>
<div class="container">

<form id="editForm" role="form" action="${ctx}/system/setting/save" method="post">
      <div class="modal-body">
		<div class="form-group">
		  <label class="control-label" for=""><strong class="necessary">*</strong>名称</label>
		  <c:choose>
		  	<c:when test="${not empty setting.id}">
		  		<input type="text" class="form-control" name="setting_name" value="${setting.name}" readonly="readonly">
		  	</c:when>
		  	<c:otherwise>
		  		<input type="text" class="form-control" name="setting_name" value="" placeholder="请输入名称" required="required">
		  	</c:otherwise>
		  </c:choose>
		</div>
		<div class="form-group">
		  <label class="control-label" for=""><strong class="necessary">*</strong>值</label>
		  <textarea name="setting_value" required="required" class="form-control description" placeholder="请输入值" onpropertychange="this.style.height = this.scrollHeight + 'px';" oninput="this.style.height = this.scrollHeight + 'px';">${setting.value}</textarea>
		</div>
		<div class="form-group">
		  <label class="control-label" for=""><strong class="necessary">*</strong>描述</label>
		  <input type="text" class="form-control" name="setting_description" value="${setting.description}" placeholder="请输入描述" required="required">  
		</div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" onclick="javascript:closeDialog();">关闭</button>
        <button type="submit" class="btn btn-success loading-btn" data-loading-text="Loading..." autocomplete="off"><span class="glyphicon glyphicon-ok"></span> 确认提交</button>
      </div>
</form>

</div>
<%@ include file="/WEB-INF/pages/common/mainFooter.jsp" %>
<script type="text/javascript">
$(function () {
    'use strict';
	$("#editForm").bind('submit', function(event) {
		ajaxFormSubmit(this,reloadParent,"提交成功！",null);
		event.preventDefault();
	});
	$('.description').each(function(){
   		$(this).height($(this)[0].scrollHeight);
	});
});
</script>
</body>
</html>
