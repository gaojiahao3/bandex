<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/pages/common/taglibs.jsp" %>
<!DOCTYPE html>
<html>
<head>
	<title>后台管理员</title>
    <%@ include file="/WEB-INF/pages/common/mainCss.jsp" %>
</head>
<body>
<div class="main administrator">
	<div class="main-top">    
            <h3>正式司机 <small>共<span>${apiRsp.count}</span>个</small></h3>              
    </div><!--main-top-->

	<div class="panel panel-info">
          <table class="table table-hover">
            <thead>
              <tr>
                <th width="100">序号</th>
                <th class="th-name">司机编号</th>
                <th width="100">国家</th>
                <th width="100">城市</th>
                <th width="100">司机姓名</th>
                <th width="100">性别</th>
                <th width="100">手机</th>
                <th width="100">车辆类型</th>
                <th width="50">状态</th>
              </tr>
            </thead>
            <tbody class="class-list">
            <c:forEach items="${apiRsp.results}" var="item" varStatus="status">
              <tr>
                <td><strong>${status.index+1}</strong></td>
                <td><strong>${item.username}</strong>
                	<span class="row-actions"><a href="javascript:editAdmin('${item.id}');"><span class="glyphicon glyphicon-edit"></span>编辑</a></span>
                	<span class="row-actions"><a href="javascript:editAdminRole('${item.id}');"><span class="glyphicon glyphicon-user"></span>角色设置</a></span>
                </td>
                <td>${item.countryName}</td>
                <td>${item.regionName}</td>
                <td>${item.realname}</td>
                <td>${item.sex}</td>
                <%-- <td><fmt:formatDate value="${item.dateJoined}" pattern="yyyy-MM-dd HH:mm"/></td>
                <td><fmt:formatDate value="${item.lastLogin}" pattern="yyyy-MM-dd HH:mm"/></td> --%>
                <td>${item.phone}</td>
                <td>${item.carTypeName}</td>
                <td>
                	<c:choose>
                	<c:when test="${item.status eq 'active'}">
                		<span class="glyphicon glyphicon-ok-sign text-success" title="启用"></span>
                	</c:when>
                	<c:otherwise>
                		<span class="glyphicon glyphicon-remove-sign text-danger" title="禁用"></span>
                	</c:otherwise>
                	</c:choose>
                </td>
              </tr>
            </c:forEach>  
            </tbody>
          </table>
	</div><!--panel-info-->
    
    <div class="main-bottom">
		<jsp:include page="/WEB-INF/pages/common/pagination.jsp" flush="true">
			<jsp:param name="paginationObjectName" value="apiRsp" />
			<jsp:param name="pageNoName" value="" />
			<jsp:param name="requestUrl" value="${ctx}/system/admin/list" />
			<jsp:param name="refreshDiv" value="" />
		</jsp:include>
    </div><!--main-bottom-->

</div><!--main end-->

<%@ include file="/WEB-INF/pages/common/mainFooter.jsp" %>
<script type="text/javascript">
function batchOperate(batchOperateType,idArr){
	var operateTitle="";
	var url="";
	if(batchOperateType=="delete"){
		operateTitle="批量删除";
		url="${ctx}/system/admin/delete";
	}else if(batchOperateType=="disable"){
		operateTitle="批量禁用";
		url="${ctx}/system/admin/disable";
	}else if(batchOperateType=="enable"){
		operateTitle="批量启用";
		url="${ctx}/system/admin/enable";
	}
	ajaxSubmit(url,{ids:idArr.join(",")},reload,operateTitle+"成功","确认"+operateTitle+"？");
}
function editAdmin(id){
	openDialog({
		frame:true,
		title:"修改信息",
	    height:600,
	    width:800,
		url:"${ctx}/system/driver/driverDetail/"+id
	});	
}

function editAdminRole(id){
	openDialog({
		frame:true,
		title:"编辑用户角色",
	    height:380,
	    width:600,
		url:"${ctx}/system/admin/roleEdit/"+id
	});	
}


$(function(){
	/*全选 取消全选*/	
	bindCheckAll();
	$("#createAdminBtn").on("click",function(){
		openDialog({
			frame:true,
			title:"添加账号",
		    height:300,
		    width:400,
			url:"${ctx}/system/admin/create"
		});
	});
	$("#batchOperateBtn").click(function(){
		var batchOperateType=$("#batchOperateType").val();
		var check_name = document.getElementsByName("list-checkbox");
		var idArr=new Array();
		for(var i=0;i<check_name.length;i++){
			if(check_name[i].checked){
				idArr.push(check_name[i].value);
			}
		}
		if(batchOperateType!="" && idArr.length>0){
			batchOperate(batchOperateType,idArr);
		}
	});
});
</script>
</body>
</html>
