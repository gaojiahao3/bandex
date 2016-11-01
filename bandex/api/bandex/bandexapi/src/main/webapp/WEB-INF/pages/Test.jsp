 <%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%@ page import="java.util.Date"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="/WEB-INF/myElFunction.tld" prefix="myFn" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<%--
<spring:eval var="usercenterServer" expression="@propertyConfigurer.getProperty('usercenter.server')" /> 
<spring:eval var="styleServer" expression="@propertyConfigurer.getProperty('style.server')" />
--%>
<%-- <spring:eval var="resourceVersion" expression="@propertyConfigurer.getProperty('release.version')" />

<spring:eval var="uploadServer" expression="@propertyConfigurer.getProperty('remoting.upload.serverUrl')" />
<spring:eval var="fileServer" expression="@propertyConfigurer.getProperty('file.server')" />
<spring:eval var="loginUrl" expression="@propertyConfigurer.getProperty('login.url')" />
<spring:eval var="userUrl" expression="@propertyConfigurer.getProperty('user.url')" />
<spring:eval var="snsServer" expression="@propertyConfigurer.getProperty('sns.server')" />
<spring:eval var="planServer" expression="@propertyConfigurer.getProperty('plan.server')" />
<spring:eval var="evaluationServer" expression="@propertyConfigurer.getProperty('evaluation.server')" />
<spring:eval var="startupServer" expression="@propertyConfigurer.getProperty('startup.server')" />
<spring:eval var="jobServer" expression="@propertyConfigurer.getProperty('job.server')" />
<spring:eval var="studyServer" expression="@propertyConfigurer.getProperty('study.server')" />
<spring:eval var="tongJiCodeFlag"  expression="@propertyConfigurer.getProperty('webSite.tongJiCode.show')" />
<c:if test="${empty resourceVersion}">
<c:set var="resourceVersion" value="<%=new Date().getTime()%>" />
</c:if> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	aaaaaaaaaaaaaaaaaaaaaaa
	<a id="totalRemindCountSpan"><i class="icon_msg_new">
	</i></a>
	<a id="totalRemindCount" style="margin-bottom: 2px;">
	</a>
	
	<div class="news-center">
		<ul>
			<li>
				<a href="${ctx}/myMessage/userLetter" class="cl9">私信</a>
				<span id="userLetterCount" class="red"> </span>
			</li>
			<li>
				<a href="${ctx}/myMessage/sysMsg" class="cl9">系统消息</a>
				<span id="commonMsgCount" class="red">  </span>
			</li>
		</ul>
	</div>
</body>
</html>
<script type="text/javascript" src="${ctx}/js/jquery-1.8.2.min.js"></script>
<script type="text/javascript" src="${ctx}/js/jquery.validate.min.js"></script>
<script type="text/javascript" src="${ctx}/js/common.js"></script>
<script type="text/javascript" src="${ctx}/js/ajax-pushlet-client.js"></script>
<script>
/**
 * 消息提醒推送
 */
 
$(window).load(function() {
	initPush('${usercenterServer}','49116');//${currentUserDto.userId}
	});
	
	
</script>