<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/pages/common/taglibs.jsp" %>
<!DOCTYPE html>
<html>
<head>
	<title>配置项</title>
    <%@ include file="/WEB-INF/pages/common/mainCss.jsp" %>
</head>

<body>
<div class="main game-list">

	<div class="main-top">
    
            <h3>配置项 <small>共<span>${apiRsp.count}</span>个</small></h3>
    </div><!--main-top-->
    
    
    
<div class="panel panel-info">
  	<div class="panel-heading">
  		<div class="pin">
          <button type="button" class="btn btn-primary" onclick="javascript:initCache();"><span class="glyphicon glyphicon-cog"></span>初始化缓存</button>
          <button type="button" class="btn btn-primary" onclick="javascript:addSetting();" style="margin-left:20px;"><span class="glyphicon glyphicon-plus"></span>添加配置</button>
        </div>
  	</div>

    <table class="table table-hover" id="table">
      <thead>
        <tr>
        	<th width="300">描述</th>
			<th width="200">名称</th>
			<th>值</th>
        </tr>
      </thead>
	  <c:set var="pagingUrl" value="${ctx}/system/setting/list"/>
	  <c:set var="nextUrl" value=""/>
	  <c:if test="${not empty apiRsp and apiRsp.count gt 0 and apiRsp.curPage!=apiRsp.totalPages}">
	  <c:set var="nextUrl" value="${pagingUrl}?page=${apiRsp.curPage+1}"/>
	  </c:if>
		<tbody id="moreSettingListDiv" nextUrl="${nextUrl}">
		<c:forEach items="${apiRsp.results}" var="item">
			<tr>
				<td>${item.description}</td>
				<td>${item.name}</td>
				<td>${item.value}
					<span class="row-actions">
                		<a href="javascript:editSetting('${item.name}');"><span class="glyphicon glyphicon-edit"></span>编辑</a>
                	</span>
				</td>
			</tr>
		</c:forEach>
      </tbody>
    </table>

</div><!--panel-info-->
 

    <c:if test="${not empty nextUrl}">
	    <div class="load_more">
	    	<button id="loadingDiv" style="display:none" type="button" class="btn btn-default btn-block loading-btn">Loading...</button>
	    	<button id="moreDiv" style="display:" type="button" class="btn btn-default btn-block loading-btn" data-loading-text="Loading..." autocomplete="off">加载更多</button>
	    </div>
    </c:if>
    
    <%-- <div class="main-bottom">
		<jsp:include page="/WEB-INF/pages/common/pagination.jsp" flush="true">
			<jsp:param name="paginationObjectName" value="apiRsp" />
			<jsp:param name="pageNoName" value="" />
			<jsp:param name="requestUrl" value="${pagingUrl}" />
			<jsp:param name="refreshDiv" value="" />
		</jsp:include>
    </div> --%><!--main-bottom-->


</div><!--main end-->

<%@ include file="/WEB-INF/pages/common/mainFooter.jsp" %>
<script type="text/javascript">
function initCache(){
	ajaxSubmit("${ctx}/system/setting/initCache",{},null,"初始化成功","确认初始化全部配置项缓存？");
}
function addSetting(){
	openDialog({
		frame:true,
		title:"添加配置",
	    height:750,
	    width:700,
		url:"${ctx}/system/setting/edit"
	});
}
function editSetting(setting_name){
	openDialog({
		frame:true,
		title:"修改配置",
	    height:750,
	    width:700,
		url:"${ctx}/system/setting/edit?setting_name="+setting_name
	});
}
function bindInitEvents(){
	/*锁定操作栏*/
	$(".pin").pin();
}
$(function(){
	bindInitEvents();
	$("#moreDiv").loadingMore({
		dataDivId:'moreSettingListDiv',
		successCallback:function(){
			bindInitEvents();
		}
	});
});
</script>
</body>
</html>
