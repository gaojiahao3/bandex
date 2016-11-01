<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/pages/common/taglibs.jsp" %>
<!DOCTYPE html>
<html>
<head>
	<title>添加司机</title>
    <%@ include file="/WEB-INF/pages/common/mainCss.jsp" %>
</head>
<body>
<div class="container">
	<form id="editForm" role="form" class="form-horizontal" action="${ctx}/system/driver/save" method="post">
	<input type="hidden" name="id" value="${apiRsp.id}">
	<div class="form-group">
		<label class="col-sm-2 control-label" for="countryName"><strong class="necessary">*</strong>国家</label>
		<div class="col-sm-4">
			<input type="text" id="countryName" name="countryName" value="${apiRsp.countryName}" readonly="readonly">
		</div>
		<label class="col-sm-2 control-label" for="regionName"><strong class="necessary">*</strong>城市</label>
		<div class="col-sm-4">
			<input type="text" id="regionName" name="regionName" value="${apiRsp.regionName}" readonly="readonly">
		</div>
	</div>
	<div class="form-group">
		<label class="control-label" for="realname"><strong class="necessary">*</strong>司机姓名</label>
		<input type="text" class="form-control" id="realname" name="realname" value="${apiRsp.realname}" readonly="readonly">
	</div>
	<div class="form-group">
		<label class="control-label" for="phone"><strong class="necessary">*</strong>手机</label>
		<input type="text" class="form-control" id="phone" name="phone" value="${apiRsp.phone}" readonly="readonly">
	</div>
	<div class="form-group">
		<label class="control-label" for="sex"><strong class="necessary">*</strong>性别</label>
		<input type="text" class="form-control" id="sex" name="sex" value="${apiRsp.sex}" readonly="readonly">
	</div>
	<div class="modal-footer">
	</div>
	</form>
</div>
<%@ include file="/WEB-INF/pages/common/mainFooter.jsp" %>
<script type="text/javascript">
$(function(){
	$("#editForm").bind('submit', function(event) {
		ajaxFormSubmit(this,reloadParent,null,null);
		event.preventDefault();
	});	
});
</script>
</body>
</html>