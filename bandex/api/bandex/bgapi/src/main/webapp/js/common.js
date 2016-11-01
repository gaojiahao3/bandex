// 常用封装
(function($){
	/**
	 * 功能:ajax提交后,取得返回数据,调用设置的回调函数
	 */
	ajaxSubmit=function(options){
		var defaults = {
			url: "",
			data: null,
			type: "get",
			dataType: "json",
			successCallback: null,
			errorCallback:null,
			divId: null
		};
		var config = $.extend(defaults, options);
		var url=config.url;
		if(url.indexOf("?")!=-1){
			url+="&t="+Math.random();
		}else{
			url+="?t="+Math.random();
		}
		$.ajax({
			url: url,
			data: config.data,
			type: config.type,
			dataType: config.dataType,
			async: config.async,
			jsonp: config.jsonp,
			success: function (data) {
				if (config.dataType == "html") {
                    try {
                        data = JSON.parse(data);
                    } catch (e) {
                        //console.info(e.name + e.message);
                    }
                }
				if (data && data.hasException) {
                    PopUp({title:"异常",type:"error",content:data.msg});
                    return;
                }
                if(data && data.needLogin){
					callFloatLogin(data);
                    return;
				}
				if(data && data.needRedirect){
					window.location.href=data.redirectUrl;
                    return;
				}
				var successCallback=config.successCallback;
				var dataType=config.dataType;
				if(successCallback!=undefined && successCallback!=null && typeof(successCallback)=="function"){
					if(dataType=="json" || dataType=="jsonp"){
						successCallback.call(this, data);
					}else{
						successCallback.call(this, data, config.divId);
					}
				}else{
					if(dataType=="json" || dataType=="jsonp"){
						if(!(data && data.isSuccess && (data.msg==null || data.msg==""))){
							PopUp({type:"alert", content:data.msg});
						}
					}else{
						$("#"+config.divId).html(data);
					}
				}
			},
			error:config.errorCallback
		});
	};
	
	/**
	 * 浮窗登录
	 */
	callFloatLogin=function(data){
		var usercenterServer=data.usercenterServer;
		var previousUrl=data.previousUrl;
		var loghtml="<div class='popup_box ts_myworld_login_box'><form id='floatLoginForm' method='post' action='"+usercenterServer+"/doFloatLogin'><input type='hidden' name='previousUrl' value='"+previousUrl+"'/><h1 class='fs_20 msyh tac fc_grey_6 bold'>登&nbsp;&nbsp;&nbsp;&nbsp;录</h1><a href='javascript:;' class='pop_wrap_close'>关闭</a><div class='form_login fs_12 fc_grey_6'><div class='fr'><div class='e'><font id='floatLoginFormErrMsg'></font></div><div class='t'>邮箱：</div><div class='f ilb js_ilb'><input type='text' name='username' id='fe_login_email' class='fe_text' placeholder='请输入邮箱'><i class='i_people'></i></div><div class='e'><!--出错信息--></div></div><div class='fr'><div class='t'>密码：</div><div class='f ilb js_ilb'><input type='password' name='password' id='fe_login_password' class='fe_text' placeholder='请输入密码'><i class='i_lock'></i></div><div class='e'><!--请输入密码。--></div></div><div class='fr'><div class='t'>&nbsp;</div><div class='f'> <span class='auto_login'><input type='checkbox' name='rememberLogin' value='true'  id='fe_login_autologin' class='fe_checkbox'><label for='fe_login_autologin'>自动登录</label></span> <a href='"+usercenterServer+"/findPwd/toFindPassword' class='forget_password lc_green'>忘记密码？</a></div></div><div class='fr'><div class='t'>&nbsp;</div><div class='f'> <a href='javascript:;' class='abtn_gxxl js_submit_ajax'><b>登&nbsp;&nbsp;&nbsp;&nbsp;录</b></a> </div></div><div class='t'>&nbsp;</div><div class='f'><p class='fc_grey_9 tac'>还没有账号？您可以</p><p style='text-align:center;'><a href='"+usercenterServer+"/register' class='abtn_oxxl'><b>立即注册优渡网账号</b></a></p></div></div></form></div>";
		var popup,popmask;
		popup=$(loghtml).appendTo($("body"));
		var _scrollHeight = document.body.scrollTop || document.documentElement.scrollTop,//获取当前窗口距离页面顶部高度
			_windowHeight = $(window).height(),//获取当前窗口高度
			_windowWidth = $(window).width(),//获取当前窗口宽度
			_popupHeight=380,//获取弹出层高度
			_popupWeight=300,//获取弹出层宽度
			_posiTop=(_windowHeight - _popupHeight)/2+ _scrollHeight,
			_posiLeft=(_windowWidth - _popupWeight)/2;	
		popup.css({"position":"absolute","z-index":"11111111","left":_posiLeft +"px","top":_posiTop +"px","width":_popupWeight +"px","height":_popupHeight+"px"}).show();
		popmask=$("<iframe frameborder=\"0\" scrolling=\"no\" style=\"width:" + _windowWidth + "px; height:" + $(document).innerHeight() + "px; position:absolute;top:0;left:0;z-index:98;opacity:0.3;filter:alpha(opacity=30);\"></iframe><div class=\"pop_wrap_mask\" style=\"width:" + _windowWidth + "px; height:" + $(document).innerHeight() + "px;\"></div>").appendTo($("body"));
		popup.delegate(".pop_wrap_close","click",function(){
			popup.remove();
			popmask.remove();
		});				
		popup.delegate(".fe_text","focus",function(){
			$(this).siblings("label").hide();
		});
		popup.delegate(".fe_text","blur",function(){
			if($(this).val()==""){
				$(this).siblings("label").show();
			}
		});
		$("#floatLoginForm .js_submit_ajax").click(function(){
			$("#floatLoginForm").ajaxForm({
				successCallback:function(data){
					if(data.isSuccess){
						var cookieList=data.cookieList;
						for(var i=0;i<cookieList.length;i++){
							var cookie=cookieList[i];
							try {
								$.cookie(cookie.name,cookie.value,{expires:cookie.maxAge, path:cookie.path, domain:cookie.domain, secure:cookie.secure});
							} catch (e) {
								//console.info(e.name + e.message);
							}
						}
						$("#floatLoginFormErrMsg").attr("color","green").html("登录成功！");
						var remindUserLetterCount = "";
						var remindCommonMsgCount = "";
						var totalRemindCount = "";
						var remind ="";
						if(data.headerDto.remindList[1].count>0&&data.headerDto.remindList[1].count<=9){
							remindUserLetterCount +="("+data.headerDto.remindList[1].count+")";
						}else{
							if(data.headerDto.remindList[1].count > 9) {
								remindUserLetterCount +="(9+)";
							}
						}
						if(data.headerDto.remindList[0].count>0&&data.headerDto.remindList[0].count<=9){
							remindCommonMsgCount +="("+data.headerDto.remindList[0].count+")";
						}else{
							if(data.headerDto.remindList[0].count > 9) {
								remindCommonMsgCount +="(9+)";
							}
						}
						if(data.headerDto.totalRemindCount>0&&data.headerDto.totalRemindCount<=9) {
							totalRemindCount +="("+data.headerDto.totalRemindCount+")";
							remind += "<b></b>"; 
						}else {
							if(data.headerDto.totalRemindCount > 9) {
								totalRemindCount +="(9+)";
								remind += "<b></b>";
							}
						}
						$("#userLetterCount").html(remindUserLetterCount);
						$("#commonMsgCount").html(remindCommonMsgCount);
						
 						var headerHtml = "<li><a href='"+usercenterServer+"'/home>"+data.currentUserDto.nickName+"</a>&nbsp;<a id='totalRemindCountSpan' onMouseover='meover(this);' onMouseout='meout(this);'><i class='icon_msg_new'>"+remind+"</i></a><a id='totalRemindCount'>"+totalRemindCount+"</a></li><li><a href='"+usercenterServer+"/logout'>退出</a></li>";
 						$("#login_top").html(headerHtml);
						popup.remove();
						popmask.remove();
						initPush(usercenterServer, data.currentUserDto.userId);
					}else{
						$("#floatLoginFormErrMsg").attr("color","red").html(data.msg);
						if(data.isInactive){
							setTimeout(function () {
								popup.remove();
								popmask.remove();
								window.location.href=data.emailActiveUrl;
						    }, 2000);
						}
					}
				}
			});			
		});
	};
	
	/**
	 * 功能:默认序列化form表单，进行ajax提交,取得返回数据,调用设置的回调函数
	 */
	$.fn.ajaxForm=function(options){
		var url=$(this).attr("action");
		var data=$(this).serialize();
		var defaults = {
			url: url,
			data: data,
			type: "post"
		};
		var config = $.extend(defaults, options);
		ajaxSubmit(config);
	};
	
	/**
	 * 功能:ajax跨域
	 */
	ajaxJsonp=function(options){
		var defaults = {
			type:"post",
			dataType:"jsonp",
			async:false,
			jsonp: "jsonpCallback"
		};
		var result=$.extend({},options,defaults);
		ajaxSubmit(result);
	};
	
	$.fn.ajaxFormJsonp=function(options){
		var url=$(this).attr("action");
		var data=$(this).serialize();
		var defaults = {
			url: url,
			data: data
		};
		var config = $.extend(defaults, options);
		ajaxJsonp(config);
	};
	
	/**
	 * 功能:模拟alert,msg为显示的内容
	 */
	Alert=function(msg,okfun){
		PopUp({title:"消息框！",type:"alert",content:msg,ok:okfun});
	};
	
	/**
	 * 功能:模拟confirm,msg为显示的内容,okfun点击确定后的回调函数,cancelfun点击取消后的回调函数
	 */
	Confirm=function(msg,okfun,cancelfun){
		PopUp({title:"消息框！",type:"confirm",ok:okfun,cancel:cancelfun,content:msg});
	};
	
	/**
	 * 功能:模拟prompt,msg为显示的内容,okfun点击确定后的回调函数,cancelfun点击取消后的回调函数
	 */
	Prompt=function(msg,okfun,cancelfun){
		PopUp({title:"消息框！",type:"prompt",ok:okfun,cancel:cancelfun,content:msg});
	};

	/**
	 * 功能:弹出对话框
	 */
	PopUp=function(inputOptions){
		var defaults = {
			title:"提示对话框",
			width:"",
			height:"",
			type:"",
			content:"",
			close:function(){
				//关闭弹出框后，调用传入的操作
			},
			ok:function(){
				//点击“确定”，调用传入的操作
			},
			cancel:function(){
				//点击“取消”，调用传入的操作
			}
		};
		var options = $.extend(defaults, inputOptions);
		var optcont=options.content;
		var popup,popmask;
		var pophtml="<div class=\"pop_wrap\"><div class=\"pop_wrap_header\"><h2>"+ options.title +"</h2><a href=\"javascript:;\" class=\"pop_wrap_close\">关闭</a></div><div class=\"pop_wrap_cont\"></div></div>";
		popup=$(pophtml).appendTo($("body"));
		switch(options.type){
			case "ok":
				conthtml="<p class=\"e_yes\"><i>成功</i>"+optcont+"</p><p class=\"popup_abtn\"><a href=\"javascript:;\" class=\"abtn_gl\"><b>确定</b></a></p>";
				break;
			case "error":
				conthtml="<p class=\"e_error\"><i>错误</i>"+optcont+"</p><p class=\"popup_abtn\"><a href=\"javascript:;\" class=\"abtn_gl\"><b>确定</b></a></p>";
				break;
			case "warn":
				conthtml="<p class=\"e_warning\"><i>警告</i>"+optcont+"</p><p class=\"popup_abtn\"><a href=\"javascript:;\" class=\"abtn_gl\"><b>确定</b></a>&nbsp;&nbsp;&nbsp;&nbsp;<a href=\"javascript:;\" class=\"abtn_ol\"><b>取消</b></a></p>";
				break;
			case "confirm":
				conthtml="<p class=\"e_confirm\"><i>选择</i>"+optcont+"</p><p class=\"popup_abtn\"><a href=\"javascript:;\" class=\"abtn_gl\"><b>确定</b></a>&nbsp;&nbsp;&nbsp;&nbsp;<a href=\"javascript:;\" class=\"abtn_ol\"><b>取消</b></a></p>";
				break;
			case "alert":
				conthtml="<p class=\"e_tip\"><i>提示</i>"+optcont+"</p><p class=\"popup_abtn\"><a href=\"javascript:;\" class=\"abtn_gl\"><b>确定</b></a></p>";
				break;
			case "prompt":
				conthtml="<p class=\"e_tip\"><i>提示</i>"+optcont+"<input type=\"text\" value=\"\" class=\"promptval\" /></p><p class=\"popup_abtn\"><a href=\"javascript:;\" class=\"abtn_gl\"><b>确定</b></a>&nbsp;&nbsp;&nbsp;&nbsp;<a href=\"javascript:;\" class=\"abtn_ol\"><b>取消</b></a></p>";
				break;
			default:
				conthtml=$(optcont).clone().show();
				break;
		};
		popup.find(".pop_wrap_cont").append(conthtml);
		//var wrapWidth=popup.width();
		//var wrapHeight=popup.height();
		var _scrollHeight = document.body.scrollTop || document.documentElement.scrollTop,//获取当前窗口距离页面顶部高度
			_windowHeight = $(window).height(),//获取当前窗口高度
			_windowWidth = $(window).width(),//获取当前窗口宽度
			_popupHeight,//获取弹出层高度
			_popupWeight,//获取弹出层宽度
			_posiTop,_posiLeft;
		if(options.height!=""){
			_popupHeight=options.height;
		}else{
			_popupHeight=popup.height();
		}
		if(options.width!=""){
			_popupWeight = options.width;
		}else{
			_popupWeight=popup.width();
		}
		_posiLeft =(_windowWidth - _popupWeight)/2;
		_posiTop =(_windowHeight - _popupHeight)/2+ _scrollHeight;
		popup.css({"position":"absolute","z-index":"11111111","left":_posiLeft +"px","top":_posiTop +"px","width":_popupWeight +"px","height":_popupHeight+"px"}).show();
		popmask=$("<iframe frameborder=\"0\" scrolling=\"no\" style=\"width:" + _windowWidth + "px; height:" + $(document).innerHeight() + "px; position:absolute;top:0;left:0;z-index:98;opacity:0.3;filter:alpha(opacity=30);\"></iframe><div class=\"pop_wrap_mask\" style=\"width:" + _windowWidth + "px; height:" + $(document).innerHeight() + "px;\"></div>").appendTo($("body"));
		popup.delegate(".pop_wrap_close","click",function(){
			popup.remove();
			popmask.remove();
			options.close();
		});
		popup.delegate(".abtn_gl","click",function(){
			var promptval=$(".promptval").val();
			popup.remove();
			popmask.remove();
			options.close();
			if(options.type=="prompt"){
				options.ok.call(this,promptval);	
			}else{
				options.ok.call(this,true);	
			}
		});		
		popup.delegate(".abtn_ol","click",function(){
			popup.remove();
			popmask.remove();
			options.close();
			options.cancel();
		});		
	};	
	
	
	/**
	 * 功能:用json数据写入所有select
	 */
	$.fn.writeJsonSelect=function(url){
		var _this=$(this);
		var name=_this.attr("name");
		if(name==""){
			alert("下拉框的name不能为空！");	
			return;
		}
		$.getJSON(url,function(data){
			//var sec,i,opt="";
			var sec,opt="";
			_this.each(function(){
				$.each(data,function(int,cate){		
					sec=cate[name];
					$.each(sec,function(subint,subcate){
						opt += "<option value="+subcate["selectId"]+">"+subcate["selectName"]+"</option>";	
					});
				});	
				_this.html(opt);
			});		
		});
	};

    /**
     * 功能:日期下拉框，选择正确的日期后填入隐藏域
     */
    $.fn.startEndYear=function(options){
        var defaults={
            startYear:"",
            startMonth:"",
            startYearSel:"",
            startMonthSel:"",
            endYear:"",
            endMonth:"",
            endYearSel:"",
            endMonthSel:""
        };
        $.extend(defaults,options);
        $(this).each(function(){
            var _this=$(this),
                selObj=_this.find("select"),
                sobjY=selObj.eq(0),
                sobjM=selObj.eq(1),
                eobjY=selObj.eq(2),
                eobjM=selObj.eq(3);
            var now=new Date(),
                nowY=now.getFullYear(),
                nowM=now.getMonth()+1;
            var stY,stM,enY,enM;
            if(defaults.startYear!=""){
                stY=defaults.startYear;
            }else{
                stY=nowY;
            };
            if(defaults.startMonth!=""){
                stM=parseInt(+defaults.startMonth);
            }else{
                stM=1;
            };
            if(defaults.endYear!=""){
                enY=defaults.endYear;
            }else{
                enY=nowY;
            };
            if(defaults.endMonth!=""){
                enM=parseInt(+defaults.endMonth);
            }else{
                enM=now.getMonth()+1;
            };
            var YearReg=/\d{4}/g;
            if(!stY.toString().match(YearReg)||!enY.toString().match(YearReg)){
                alert("请输入4位数字年份！");
                return;
            };
            if(enY<1970||stY<1970||enY>nowY||stY>nowY||((enY==stY)&&(enM>nowM||stM>nowM))){
                alert("必须是从1970年1月到当前月份！");
                return;
            };
            if(enY<stY){
                alert("结束年份必须大于等于起始年份！");
                return;
            };
            if(enY==stY){
                if(enM<stM){
                    alert("结束日期必须大于超始日期！");
                    return;
                }
            };
            var writeSelect=function(){
                var sYhtml="<option value=''>年</option>",eYhtml="<option value=''>年</option>",curyear,sYsel="",eYsel="";
                for(var i=0;i<=nowY-1970;i++){
                    curyear=nowY-i;
                    if(curyear==defaults.startYearSel&&defaults.startYearSel!=""){
                        sYsel = " selected='selected'";
                    }else{
                        sYsel ="";
                    }
                    if(curyear==defaults.endYearSel&&defaults.endYearSel!=""){
                        eYsel = " selected='selected'";
                    }else{
                        eYsel ="";
                    }
                    sYhtml += "<option value='"+curyear+"'"+sYsel+">"+curyear+"</option>";
                    eYhtml += "<option value='"+curyear+"'"+eYsel+">"+curyear+"</option>";
                };
                sobjY.html(sYhtml);
                eobjY.html(eYhtml);
                var sMhtml="<option value=''>月</option>",eMhtml="<option value=''>月</option>",curmon,sMsel="",eMsel="";
                for(var i=1;i<=12;i++){
                    curmon=i;
                    if(curmon==defaults.startMonthSel&&defaults.startMonthSel!=""){
                        sMsel = " selected='selected'";
                    }else{
                        sMsel ="";
                    }
                    if(curmon==defaults.endMonthSel&&defaults.endMonthSel!=""){
                        eMsel = " selected='selected'";
                    }else{
                        eMsel ="";
                    }
                    if(i<10){
                        curmon = "0"+curmon;
                    }
                    sMhtml += "<option value='"+curmon+"'"+sMsel+">"+curmon+"</option>";
                    eMhtml += "<option value='"+curmon+"'"+eMsel+">"+curmon+"</option>";
                };
                sobjM.html(sMhtml);
                eobjM.html(eMhtml);
                _this.find("input[type='hidden']").eq(0).val(sobjY.val()+sobjM.val());
                _this.find("input[type='hidden']").eq(1).val(eobjY.val()+eobjM.val());
            };
            writeSelect();
            selObj.each(function(){
                var thsval=$(this).val();
                $(this).change(function(){
                    var sYval=sobjY.val();
                    var sMval=sobjM.val();
                    var eYval=eobjY.val();
                    var eMval=eobjM.val();
                    if(sYval==""){
                        sYval=nowY;
                    }
                    if(eYval==""){
                        eYval=nowY;
                    }
                    if(sMval==""){
                        sMval=nowM;
                    }
                    if(eMval==""){
                        eMval=nowM;
                    }
                    var startTime=sYval+""+sMval,
                        endTime=eYval+""+eMval;
                    if(startTime>endTime){
                        alert("开始日期必须小于或等于结束日期!");
                        $(this).val(thsval);
                        return;
                    }else{
                        _this.find("input[type='hidden']").eq(0).val(sobjY.val()+sobjM.val());
                        _this.find("input[type='hidden']").eq(1).val(eobjY.val()+eobjM.val());
                    }
                });
            });
        });
    };


    /**
     * 功能:日期下拉框，选择正确的日期后填入隐藏域
     */
    $.fn.jobYearMonthSelect=function(options){
        var defaults={
            startYear:"",
            startMonth:"",
            startYearSel:"",
            startMonthSel:"",
            endYear:"",
            endMonth:"",
            endYearSel:"",
            endMonthSel:""
        };
        $.extend(defaults,options);
        $(this).each(function(){
            var _this=$(this),
                selObj=_this.find("select"),
                sobjY=selObj.eq(0),
                sobjM=selObj.eq(1),
                eobjY=selObj.eq(2),
                eobjM=selObj.eq(3);
            var now=new Date(),
                nowY=now.getFullYear(),
                nowM=now.getMonth()+1;
            var stY,stM,enY,enM;
            if(defaults.startYear!=""){
                stY=defaults.startYear;
            }else{
                stY=nowY;
            };
            if(defaults.startMonth!=""){
                stM=parseInt(+defaults.startMonth);
            }else{
                stM=1;
            };
            if(defaults.endYear!=""){
                enY=defaults.endYear;
            }else{
                enY=nowY;
            };
            if(defaults.endMonth!=""){
                enM=parseInt(+defaults.endMonth);
            }else{
                enM=now.getMonth()+1;
            };
            var YearReg=/\d{4}/g;
            if(!stY.toString().match(YearReg)||!enY.toString().match(YearReg)){
                alert("请输入4位数字年份！");
                return;
            };
            if(enY<1970||stY<1970||enY>nowY||stY>nowY||((enY==stY)&&(enM>nowM||stM>nowM))){
                alert("必须是从1970年1月到当前月份！");
                return;
            };
            if(enY<stY){
                alert("结束年份必须大于等于起始年份！");
                return;
            };
            if(enY==stY){
                if(enM<stM){
                    alert("结束日期必须大于超始日期！");
                    return;
                }
            };
            var selectbY = sobjY.find('option').val();
            var selectbM = sobjM.find('option').val();
            var selecteY = eobjY.find('option').val();
            var selecteM = eobjM.find('option').val();
            var writeSelect=function(){
                var sYhtml="<option value=''>年</option>",eYhtml="<option value=''>年</option>",curyear,sYsel="",eYsel="";
                for(var i=0;i<=nowY-1970;i++){
                    curyear=nowY-i;
                    if(parseInt(curyear)==parseInt(selectbY)){
                        sYsel = " selected='selected'";
                    }else{
                        sYsel ="";
                    }
                    if(parseInt(curyear)==parseInt(selecteY)){
                        eYsel = " selected='selected'";
                    }else{
                        eYsel ="";
                    }
                    sYhtml += "<option value='"+curyear+"'"+sYsel+">"+curyear+"</option>";
                    eYhtml += "<option value='"+curyear+"'"+eYsel+">"+curyear+"</option>";
                };
                sobjY.html(sYhtml);
                eobjY.html(eYhtml);
                var sMhtml="<option value=''>月</option>",eMhtml="<option value=''>月</option>",curmon,sMsel="",eMsel="";
                for(var i=1;i<=12;i++){
                    curmon=i;
                    if(parseInt(curmon)==parseInt(selectbM)){
                        sMsel = " selected='selected'";
                    }else{
                        sMsel ="";
                    }
                    if(parseInt(curmon)==parseInt(selecteM)){
                        eMsel = " selected='selected'";
                    }else{
                        eMsel ="";
                    }
                    if(i<10){
                        curmon = "0"+curmon;
                    }
                    sMhtml += "<option value='"+curmon+"'"+sMsel+">"+curmon+"</option>";
                    eMhtml += "<option value='"+curmon+"'"+eMsel+">"+curmon+"</option>";
                };
                sobjM.html(sMhtml);
                eobjM.html(eMhtml);
                _this.find("input[type='hidden']").eq(0).val(sobjY.val()+sobjM.val());
                _this.find("input[type='hidden']").eq(1).val(eobjY.val()+eobjM.val());
            };
            writeSelect();
            selObj.each(function(){
                var thsval=$(this).val();
                $(this).change(function(){
                    var sYval=sobjY.val();
                    var sMval=sobjM.val();
                    var eYval=eobjY.val();
                    var eMval=eobjM.val();
                    if(sYval==""){
                        sYval=nowY;
                    }
                    if(eYval==""){
                        eYval=nowY;
                    }
                    if(sMval==""){
                        sMval=nowM;
                    }
                    if(eMval==""){
                        eMval=nowM;
                    }
                    var startTime=sYval+""+sMval,
                        endTime=eYval+""+eMval;
                    if(startTime>endTime){
                        alert("开始日期必须小于或等于结束日期!");
                        $(this).val(thsval);
                        return;
                    }else{
                        _this.find("input[type='hidden']").eq(0).val(sobjY.val()+sobjM.val());
                        _this.find("input[type='hidden']").eq(1).val(eobjY.val()+eobjM.val());
                    }
                });
            });
        });
    };



    /**
	 * 消息提醒推送
	 */
	initPush=function(ctx,currentUserId){
		if(currentUserId!=undefined && currentUserId!=null && currentUserId!=''){
			PL.webRoot=ctx+'/api/';
			PL._init();
			PL.userId=currentUserId;
			PL.joinListen('/topic/userMsgNotifyPusher');
		}		
	};
	onData=function(event){
		if(event!=undefined){
			var total_remind_count=event.get('total_remind_count');
			var user_letter_remind_count=event.get('user_letter_remind_count');
			var common_msg_remind_count=event.get('common_msg_remind_count');
			if(total_remind_count!=undefined && total_remind_count!=null && parseInt(total_remind_count)>0){
					$("#totalRemindCountSpan").html("<i class='icon_msg_new'><b></b></i>");
					var totalHtml = '';
					if(total_remind_count>0 && total_remind_count<=9) {
						totalHtml += "(" + total_remind_count +")";
					}else if(total_remind_count>9) {
						totalHtml += "(9+)";
					}
					$("#totalRemindCount").html(totalHtml);
					
					totalHtml = '';
					if(user_letter_remind_count>0 && user_letter_remind_count<=9) {
						totalHtml += "(" + user_letter_remind_count +")";
					}else if(user_letter_remind_count>9) {
						totalHtml += "(9+)";
					}
					$("#userLetterCount").html(totalHtml);
					
					totalHtml = '';
					if(common_msg_remind_count>0 && common_msg_remind_count<=9) {
						totalHtml += "(" + common_msg_remind_count +")";
					}else if(common_msg_remind_count>9) {
						totalHtml += "(9+)";
					}
					$("#commonMsgCount").html(totalHtml);
			}else{
				$("#totalRemindCountSpan").html("");
			}
		}		
	};
	
	/**
	 * 分页
	 */
	gotoPage=function(url,divId){
		if(divId!=null && divId!=""){
			ajaxSubmit({url:url, dataType:"html", divId:divId});
		}else{
			window.location.href=url;
		}		
	};
	jumptoPage=function(requestUrl,divId,totalPages){
		var jumptoPageNo=document.getElementById("jumptoPageNo").value;
		if(jumptoPageNo<=parseInt(totalPages)&& jumptoPageNo >0){
			gotoPage(requestUrl+'='+jumptoPageNo,divId);
		}else{
			alert("错误的页码！");
		}		
	};

	jumptoPageNum=function(requestUrl,totalPages){
		var jumptoPageNo=document.getElementById("jumptoPageNo").value;
		
		if(jumptoPageNo<=parseInt(totalPages)&& jumptoPageNo >0){
			var url=requestUrl.replace("PAGENO",jumptoPageNo);
		    window.location.href=url;}
		 else{
			alert("错误的页码！");
		 }		
       };
	
	//table隔行换色
	$.fn.TableTrOdd=function(){
		$(this).find('tbody tr:odd').css("background-color","#f6f6f6");
	};
	
	//checkbox全选,全选复选框的name与所有需要选中的复选框的name值要命名一样
	$.fn.selectAll=function(){
		$(this).click(function(){
			var selAll=$(this);
			var name=selAll.attr("name");
			if(selAll.is(":checked")){
				$("input[name='"+name+"']").attr("checked",true);
			}else{
				$("input[name='"+name+"']").removeAttr("checked");
			}
			$("input[name='"+name+"']").click(function(){
				var inp=$(this);
				if(!inp.is(":checked")){
					selAll.removeAttr("checked");
				}
			});
		});		
	};
	
	//左侧菜单收缩功能	$('.leftmenu_yu').LeftMenu(0);	参数为默认展开项的索引值
	$.fn.LeftMenu=function(defaultval){
		$(this).each(function(index,element){
			//设置默认展开项
			var This=$(this);
			$(element).find('li').find('ul').eq(defaultval).show();
			$(element).find('li').find('.btn1').eq(defaultval).css('background-position','left -12px');
			//点击事件
			$(element).find('li').find('.btn1').each(function(index,element){
				$(element).click(function(){
					if($(this).parent().next().css('display')=='block')
					{
						$(this).parent().next().hide();
						$(this).css('background-position','left top');
					}
					else
					{
						This.find('li').find('ul').hide();
						This.find('li').find('.btn1').css('background-position','left top');
						$(this).parent().next().css('display','block');
						$(this).css('background-position','left -12px');
					}
				});
			});
		});
	};
	
	//模拟placeholder
	$.fn.extend({         
		placeholder:function(){
			if("placeholder" in document.createElement("input")){ 
				return this; //如果原生支持placeholder属性，则返回对象本身         
			}else{                 
				return this.each(function(){                     
					var _this = $(this);                     
					_this.val(_this.attr("placeholder")).focus(function(){                         
						if(_this.val() === _this.attr("placeholder")){                             
							_this.val("");
						}                     
					}).blur(function (){                         
						if (_this.val().length === 0){                            
							_this.val(_this.attr("placeholder"));
						}                     
					});
				});
			}         
		}     
	});
	
	/**
	 * textarea maxlength
	 */
	$.fn.maxlength = function(){
		$("textarea[maxlength]").keypress(function(event){
			var key = event.which;
			//all keys including return.
			if(key >= 33 || key == 13) {
				var maxLength = $(this).attr("maxlength");
				var length = this.value.length;
				if(length >= maxLength) {
					event.preventDefault();
				}
			}
		});
	};
	
	$.fn.extend({
		divpopup:function(set){
			var config={
				postLeft:0,//定弹出层的左坐标
				postTop:0,//上坐标
				wh:0,//定小箭的位置，指向按钮的中间
				zIndex:0,
				close:false
			};
			var set=$.extend(config, set);
			var $this=$(this);
			$this.mouseover(function(){
				$this.show();
			});
			$this.mouseout(function(){
				$this.hide();
			});
			if(set.close){
				$this.hide();
			}
			else{
				$this.find(".jt").css({left:set.wh/2-18});
				$this.css({left:set.postLeft-10,top:set.postTop+29,zIndex:set.zIndex});				
				$this.show();	
			}
		}
	});
	var mOver=function(th,div){
		var $this=$(th);
		var psLeft=$this.offset().left;
		var psTop=$this.offset().top;
		var wh=$this.width();
		$(div).divpopup({
			postLeft:psLeft,
			postTop:psTop,
			zIndex:1,
			wh:wh
		});
	};
	var mOut=function(th,div){
		$(div).divpopup({
			postLeft:0,
			postTop:0,
			zIndex:0,
			wh:0,
			close:true
		});
	};
	
	$("#totalRemindCountSpan").mouseover(function(){
		mOver($(this),$(".news-popup"));		
	});
	$("#totalRemindCountSpan").mouseout(function(){	
		mOut($(this),$(".news-popup"));		
	});
	

})(jQuery);

jQuery(function(){
	//左侧漂浮模块
	$('.addleftbtn').click(function(){
		$(this).animate({left:'-19px'},100);
		$('.addleftbox').animate({left:'0',height:'37px'});
		$('.addleftbox').animate({height:'100%'});
	});
	$('.tit').find('a').click(function(){
		$('.addleftbox').animate({height:'37px'});
		$('.addleftbox').animate({left:'-176px',height:'37px'});
		$('.addleftbtn').animate({left:'0px'},2000);
	});
});

function meover(_this) {
	th = $(_this);
	div = $(".news-popup");
	var $this=$(th);
	var psLeft=$this.offset().left;
	var psTop=$this.offset().top;
	var wh=$this.width();
	$(div).divpopup({
		postLeft:psLeft,
		postTop:psTop,
		zIndex:1,
		wh:wh
	});
}
function meout(_this) {
	div = $(".news-popup");
	$(div).divpopup({
		postLeft:0,
		postTop:0,
		zIndex:0,
		wh:0,
		close:true
	});
}
+function($){
    'use strict';
    var oldKey = "/default/";
    var imglist =  $("img");
    $.each( imglist ,function( i ,l){
		var val = "";
		if ( $(l).data().width && $(l).data().height){
			val = "/"+$(l).data().width+"X"+$(l).data().height+"/";
			l.src = $(l).data().originalSrc.replace( oldKey , val);
		} else if($(l).data().originalSrc) {
			l.src = $(l).data().originalSrc;
		}
    });
}(jQuery);