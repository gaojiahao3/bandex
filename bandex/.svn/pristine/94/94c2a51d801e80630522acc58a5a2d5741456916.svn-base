<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/pages/common/taglibs.jsp" %>
<!DOCTYPE html>
<html>
<head>
	<title>国家地区管理列表</title>
    <%@ include file="/WEB-INF/pages/common/mainCss.jsp" %>
</head>
<body>

<div class="main administrator">

	<div class="main-top">    
            <h3>国家地区管理列表 <small>共<span>${apiRsp.count}</span>个</small></h3>              
    </div><!--main-top-->

<div class="panel panel-info">
  <div class="panel-heading">
  		<div class="pin">
          <form class="form-inline" role="form">
            <div class="form-group">
                  <select id="batchOperateType" class="form-control">
                            <option value="">批量操作</option>
                            <option value="delete">删除</option>
                  </select>
            </div>
                  <div class="btn-group">
                    <button id="batchOperateBtn" type="button" class="btn btn-default">确认</button>
                  </div>
          </form>
          <button id="createAdminBtn" type="button" class="btn btn-primary"><span class="glyphicon glyphicon-plus"></span>添加国家地区</button>
        </div>
  </div>
          <table class="table table-hover">
            <thead>
              <tr>
               <th class="th-checkbox"><input type="checkbox" id="check-btn" class="tag" title="" data-original-title="全选/反选"></th>
                <th class="th-name">国家、地区名称</th>
                <th>CODE</th>
                <th>国家名称</th>
                <th>状态</th>
                <th>创建时间</th>
              </tr>
            </thead>
            <tbody class="class-list">
            <c:forEach items="${apiRsp.results}" var="item">
              <tr>
              <td><input type="checkbox" name="list-checkbox" value="${item.id}"></td>
                <td><strong>${item.name}</strong>
                <span class="row-actions"><a href="javascript:editCountryRegion('${item.id}');"><span class="glyphicon glyphicon-th-list"></span>编辑国家地区</a></span>
                </td>
                <td>${item.code}</td>
                <td>${item.parentName}</td>
                <td>${item.status}</td>
                <td>${item.createDatetime}</td>
              </tr>
            </c:forEach>  
            </tbody>
          </table>

</div><!--panel-info-->
    
    <div class="main-bottom">
		<jsp:include page="/WEB-INF/pages/common/pagination.jsp" flush="true">
			<jsp:param name="paginationObjectName" value="apiRsp" />
			<jsp:param name="pageNoName" value="" />
			<jsp:param name="requestUrl" value="${ctx}/system/countryRegion/list" />
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
		url="${ctx}/system/countryRegion/delete";
	}
	ajaxSubmit(url,{ids:idArr.join(",")},reload,operateTitle+"成功","确认"+operateTitle+"？");
}


function editCountryRegion(id){
	openDialog({
		frame:true,
		title:"编辑国家地区", 
	    height:700,
	    width:700,
		url:"${ctx}/system/countryRegion/edit?id="+id
	});	
}


$(function(){
	
	$("#createAdminBtn").on("click",function(){
		openDialog({
			frame:true,
			title:"添加国家地区",
		    height:700,
		    width:700,
			url:"${ctx}/system/countryRegion/edit"
		});
	});
	
	/*全选 取消全选*/	
	var check_btn = document.getElementById("check-btn");
	var check_name = document.getElementsByName("list-checkbox");
	check_btn.onclick = function(){
		for(var i=1; i<=check_name.length; i+=1){
			if(check_name[i-1].checked){
				check_name[i-1].checked = false;
			}else{
				check_name[i-1].checked = true;
			}
		}
	};
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
