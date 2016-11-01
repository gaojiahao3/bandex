<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/pages/common/taglibs.jsp" %>
<!DOCTYPE html>
<html>
<head>
	<title>${setting.description}</title>
    <%@ include file="/WEB-INF/pages/common/mainCss.jsp" %>
</head>

<body>

<div class="main irrigation">



	<div class="main-top">    
            <h3>${setting.description}</h3>    
    </div><!--main-top-->
    
  

<form id="editForm" action="${ctx}/system/setting/save" method="post">
<input type="hidden" name="setting_name" value="${setting_name}">
  <div class="panel panel-info">
    <div class="panel-heading">*认真核对</div>
    <div id="collapseOne" class="panel-collapse collapse in" role="tabpanel">

	<table class="table">
		<tbody>
			<c:if test="${inputType eq 'text'}">
				<tr>
					<th class="active" width="15%">值：</th>
					<td width="85%">
						<input type="text" name="setting_value" required="required" class="form-control" value="${setting.value}">
					</td>
				</tr>
			</c:if>
			<c:if test="${inputType eq 'textarea'}">
				<tr>
					<th class="active" width="15%">值：<p class="text-muted">多个以换行隔开</p></th>
					<td width="85%">
						<textarea name="setting_value" required="required" class="form-control description" onpropertychange="this.style.height = this.scrollHeight + 'px';" oninput="this.style.height = this.scrollHeight + 'px';">${setting.value}</textarea>
					</td>
				</tr>
			</c:if>
		</tbody>
	</table>
      
      
    </div>
  </div>
  
  
    

<div class="submit">
      <button type="submit" class="btn btn-success loading-btn" data-loading-text="Loading..." autocomplete="off"><span class="glyphicon glyphicon-ok"></span> 确认提交</button>
</div>
</form>



</div><!--main end-->

<%@ include file="/WEB-INF/pages/common/mainFooter.jsp" %>
<script type="text/javascript">
$(function(){
	/*textarea高度自适应*/
	$('.description').each(function(){
   		$(this).height($(this)[0].scrollHeight);
	});
	$("#editForm").bind('submit', function(event) {
		ajaxFormSubmit(this,null,"保存成功",null);
		event.preventDefault();
	});	
});
</script>
</body>
</html>
