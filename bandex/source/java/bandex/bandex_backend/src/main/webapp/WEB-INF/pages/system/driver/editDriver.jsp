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
		<label class="col-sm-2 control-label" for="countryName"><strong class="necessary">*</strong>国家：</label>
		<div class="col-sm-4">
			<input class="form-control" type="text" id="countryName" name="countryName" value="${apiRsp.countryName}">
		</div>
		<label class="col-sm-2 control-label" for="regionName"><strong class="necessary">*</strong>城市：</label>
		<div class="col-sm-4">
			<input class="form-control" type="text" id="regionName" name="regionName" value="${apiRsp.regionName}">
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-2 control-label" for="realname"><strong class="necessary">*</strong>司机姓名：</label>
		<div class="col-sm-4">
			<input class="form-control" type="text" id="realname" name="realname" value="${apiRsp.realname}">
		</div>
		<label class="col-sm-2 control-label" for="phone"><strong class="necessary">*</strong>手机号码：</label>
		<div class="col-sm-4">
			<input class="form-control" type="text" id="phone" name="phone" value="${apiRsp.realname}">
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-2 control-label" for="sex"><strong class="necessary">*</strong>司机性别：</label>
		<div class="col-sm-4">
			<select id="sex" name="sex" type="text" class="form-control" placeholder="请选择性别">
                <option value="男">男</option>
                <option value="女">女</option>
            </select>
		</div>
		<label class="col-sm-2 control-label" for="sex"><strong class="necessary">*</strong>车辆类型：</label>
		<div class="col-sm-4">
			<input class="form-control" type="text" id="sex" name="sex" value="${apiRsp.sex}">
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-2 control-label" for="carLength"><strong class="necessary">*</strong>车长：</label>
		<div class="col-sm-4">
			<input class="form-control" type="text" id="carLength" name="carLength" value="${apiRsp.carLength}">
		</div>
		<label class="col-sm-2 control-label" for="carMaxWeight"><strong class="necessary">*</strong>车载重量</label>
		<div class="col-sm-4">
			<input class="form-control" type="text" id="carMaxWeight" name="carMaxWeight" value="${apiRsp.carMaxWeight}">
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-2 control-label" for="idcard"><strong class="necessary">*</strong>身份证号：</label>
		<div class="col-sm-4">
			<input class="form-control" type="text" id="idcard" name="idcard" value="${apiRsp.idcard}">
		</div>
		<label class="col-sm-2 control-label" for="settlementRate"><strong class="necessary">*</strong>分成比例：</label>
		<div class="col-sm-4">
			<input class="form-control" type="text" id="settlementRate" name="settlementRate" value="${apiRsp.settlementRate}">
		</div>
	</div>
	<div class="modal-footer">
		<!-- <button type="button" class="btn btn-default" data-dismiss="modal" id="diglog_close_btn-js" onclick="javascript:closeDialog();">关闭</button> -->
		<button type="submit" class="btn btn-success loading-btn" data-loading-text="Loading..." autocomplete="off"><span class="glyphicon glyphicon-ok"></span>添加</button>		
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