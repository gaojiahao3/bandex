<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/pages/common/taglibs.jsp" %>
<!DOCTYPE html>
<html>
<head>
	<title>用户管理列表</title>
    <%@ include file="/WEB-INF/pages/common/mainCss.jsp" %>
</head>
<body>

<div class="main administrator">

	<div class="main-top">    
            <h3>用户管理列表 <small>共<span>${apiRsp.count}</span>个</small></h3>              
    </div><!--main-top-->

<div class="panel panel-info">
          <table class="table table-hover">
            <thead>
              <tr>
                <th>序号</th>
                <th>手机号</th>
                <th>头像</th>
                <th>注册时间</th>
                <th>常用车队</th>
                <th>下单数量</th>
                <th>完成订单数量</th>
                <th>取消订单数量</th>
                <th>点评用户数</th>
              </tr>
            </thead>
            <tbody class="class-list">
            <c:forEach items="${apiRsp.results}" var="item">
              <tr>
                <td><strong>${item.number}</strong></td>
                <td>${item.phone}</td>
                <td><img alt="用户头像" src="${item.avatar}"></td>
                <td>${item.createDatetime}</td>
                <td>${item.commonUsedDirver}</td>
                <td>${item.orderNumber}</td>
                <td>${item.completeOrderNumber}</td>
                <td>${item.cancelOrderNumber}</td>
                <td>${item.commentNumber}</td>
              </tr>
            </c:forEach>  
            </tbody>
          </table>

</div><!--panel-info-->
    
    <div class="main-bottom">
		<jsp:include page="/WEB-INF/pages/common/pagination.jsp" flush="true">
			<jsp:param name="paginationObjectName" value="apiRsp" />
			<jsp:param name="pageNoName" value="" />
			<jsp:param name="requestUrl" value="${ctx}/customer/customerList" />
			<jsp:param name="refreshDiv" value="" />
		</jsp:include>
    </div><!--main-bottom-->

</div><!--main end-->
 
 

<%@ include file="/WEB-INF/pages/common/mainFooter.jsp" %>
<script type="text/javascript">
</script>
</body>
</html>
