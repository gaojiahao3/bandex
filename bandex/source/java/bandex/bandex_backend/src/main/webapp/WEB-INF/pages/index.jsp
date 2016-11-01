<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/pages/common/taglibs.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <title>CARGODD运营后台</title>
    <%@ include file="/WEB-INF/pages/common/css.jsp" %>
</head>
<body class="easyui-layout">

<div region="north" class="head">
    <span class="logo_text">CARGODD运营后台</span>
    <div class="user">
        你好，<b>${(not empty (sessionScope.adminDto.realname))?(sessionScope.adminDto.realname):(sessionScope.adminDto.username)}</b><span>|</span><a
            onclick="javascript:addTab('修改密码','${ctx}/system/admin/editPassword');" href="javascript:;" title="修改密码">修改密码</a><span>|</span><a href="${ctx}/logout" target="_top">退出</a>
    </div>
</div>

<div region="west" title="导航菜单" class="left">
    <div class="set-skin" id="set-skin">
        <a class="s1" href="javascript:;" rel="skin1" title="黑"></a>
        <a class="s2" href="javascript:;" rel="skin2" title="灰"></a>
        <a class="s3" href="javascript:;" rel="skin3" title="红"></a>
        <a class="s4" href="javascript:;" rel="skin4" title="紫"></a>
        <a class="s5" href="javascript:;" rel="skin5" title="蓝"></a>
        <a class="s6" href="javascript:;" rel="skin6" title="绿"></a>
    </div>
    <div id="aa" class="easyui-accordion">
		<jsp:include page="/WEB-INF/pages/leftMenu.jsp" />
    </div>
</div>

<div id="mainPanle" region="center" class="right">
    <div id="tabs" class="easyui-tabs man-tab" fit="true" border="false">
        <div title="首页" id="home">
            <div class="quick-menu">
            </div>
			<div id="mainPanle_frame">
			 	请稍等，正在加载数据...
			</div>
            <iframe name="" class="iframe-main" scrolling="auto" frameborder="0" src="" style="width:100%"></iframe>
        </div>
    </div>
</div>
<!--mainPanle-->

<%@ include file="/WEB-INF/pages/common/footer.jsp" %>
<script type="text/javascript">
    function createCookie(name, value, days) {
        if (days) {
            var date = new Date();
            date.setTime(date.getTime() + (days * 24 * 60 * 60 * 1000));
            var expires = "; expires=" + date.toGMTString();
        } else var expires = "";
        document.cookie = name + "=" + value + expires + "; path=/";
    }
    function readCookie(name) {
        var nameEQ = name + "=";
        var ca = document.cookie.split(';');
        for (var i = 0; i < ca.length; i++) {
            var c = ca[i];
            while (c.charAt(0) == ' ')c = c.substring(1, c.length);
            if (c.indexOf(nameEQ) == 0)return c.substring(nameEQ.length, c.length);
        }
        return null;
    }
    function eraseCookie(name) {
        createCookie(name, "", -1);
    }
    function switchStylestyle(styleName) {
        $('link[rel*=style][title]').each(function (i) {
            this.disabled = true;
            if (this.getAttribute('title') == styleName) this.disabled = false;
        });
        createCookie('style', styleName, 365);
    }
    function addTab(title, href, update) {
        var options = {
            title: title,
            content: createFrame(href),
            closable: true,
            cache: false,
            closed: true,
            width: $('#mainPanle').width() - 10,
            height: $('#mainPanle').height() - 26
        };
        var existed = $('#tabs').tabs('exists', title);
        if (existed) {
            var thisTab = $("#tabs").tabs('getTab', title);
            if (update) {
                $('#tabs').tabs('update', {
                    tab: thisTab,
                    options: options
                });
            }
            $('#tabs').tabs('select', title);
        } else {
            $('#tabs').tabs('add', options);
        }
    }
    function closeSelf() {
        var thisTab = $("#tabs").tabs("getSelected");
        var thisTabIndex = $("#tabs").tabs("getTabIndex", thisTab);
        $("#tabs").tabs("close", thisTabIndex);
    }
    function closeThenAddTab(title, href, update) {
        closeSelf();
        addTab(title, href, update);
    }
    function createFrame(url) {
        return '<iframe name="mainFrame" scrolling="auto" frameborder="0"  src="' + url + '" style="width:100%;height:100%;"></iframe>';
    }
    $(function () {
    	$("#mainPanle_frame").html('<iframe class="iframe-main" scrolling="auto" frameborder="0"  src="" style="width:100%;height:100%;"></iframe>');
        $(".iframe-main").load(function () {
            $(this).height($(window).height() - 100);
        });
        $('.set-skin a').click(function () {
            switchStylestyle(this.getAttribute("rel"));
            return false;
        });
        var c = readCookie('style');
        if (c) {
            switchStylestyle(c);
        }
    });
</script>
</body>
</html>