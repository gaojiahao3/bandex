<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/pages/common/taglibs.jsp" %>
<!DOCTYPE html>
<html>
<head>
	<title>订单管理列表</title>
    <%@ include file="/WEB-INF/pages/common/mainCss.jsp" %>
</head>
<body>

<div class="main administrator">

	<div class="main-top">    
            <h3>订单管理列表 <small>共<span>${apiRsp.count}</span>个</small></h3>              
    </div><!--main-top-->

<div class="panel panel-info">
<div class="panel-heading">
  		<div class="pin">
          <form class="form-inline" role="form">
            
          </form>
        </div>
  </div>
          <table class="table table-hover">
            <thead>
              <tr>
                <th>序号</th>
                <th class="th-name">订单号</th>
                <th>下单人姓名</th>
                <th>下单人电话</th>
                <th>订单类型</th>
                <th>下单时间</th>
                <th>用车类型</th>
                <th>订单状态名称</th>
              </tr>
            </thead>
            <tbody class="class-list">
            <c:forEach items="${apiRsp.results}" var="item">
              <tr>
                <td><strong>${item.number}</strong></td>
                <td>${item.orderNo}
                 <span class="row-actions"><a href="javascript:details('${item.orderNo}');"><span class="glyphicon glyphicon-edit"></span>详情</a></span>
                 <span class="row-actions"><c:if test="{'${item.status}' eq 'locked'}"></iframe><a href="javascript:orderCancel('${item.orderNo}');"><span class="glyphicon glyphicon-edit"></span>强制取消</a></c:if></span>
                </td>
                <td>${item.customerName}</td>
                <td>${item.customerPhone}</td>
                <td>${item.orderType}</td>
                <td>${item.createDatetime}</td>
                <td>${item.carTypeName}</td>
                <td>${item.statusName}</td>
              </tr>
            </c:forEach>  
            </tbody>
          </table>

</div><!--panel-info-->
    
    <div class="main-bottom">
		<jsp:include page="/WEB-INF/pages/common/pagination.jsp" flush="true">
			<jsp:param name="paginationObjectName" value="apiRsp" />
			<jsp:param name="pageNoName" value="" />
			<jsp:param name="requestUrl" value="${ctx}/order/orderList" />
			<jsp:param name="refreshDiv" value="" />
		</jsp:include>
    </div><!--main-bottom-->

</div><!--main end-->
 
 

<%@ include file="/WEB-INF/pages/common/mainFooter.jsp" %>
<script type="text/javascript">

function details(orderNo){
	openDialog({
		frame:true,
		title:"订单详情",
	    height:700,
	    width:700,
		url:"${ctx}/order/orderDetails?orderNo="+orderNo
	});	
}

function orderCancel(orderNo){
	var operateTitle="";
	var url="";
	operateTitle="强制取消";
	url="${ctx}/order/orderCancel?orderNo="+orderNo;
	ajaxSubmit(url,{},reload,operateTitle+"成功","确认"+operateTitle+"？");
}


</script>
</body>
</html>
