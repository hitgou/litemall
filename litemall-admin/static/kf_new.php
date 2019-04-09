//{"cmd":"IMWK","workers":[],"dwid":72195265};
	$53.data('u_stat_id','');
	(function(window,undefined){
		if($53.data('api_uuid') == ""){
			$53.data('api_uuid','8ba83dfc9d42be9ad1e4d0eb65a95a51');
       		$53.setUuid('8ba83dfc9d42be9ad1e4d0eb65a95a51');
		}
        $53.setHost('www16.53kf.com');
        $53.setSign('da61b2a93385fbbcbf3628b606295d4b');
        var _kfApi = $53.createApi();
    	function KfStat(){
            this.data = {
                stat_id:'',
                product_key:''
            };
            this.put = function(key,value){
                    var _this = this;
                    if((key !== 'stat_id' && key !== 'product_key') || value == '' || value == null){
                        return false;
                    }
                    _this.data[key] = value;
                    if(key == 'stat_id'){
                        _kfApi.push('cmd','jzl');
                        _kfApi.push('stat_id',value);
                        _kfApi.query();
//                        var data = [["jzl_stat_id_72195265",value,-1]];
//                        $53.setKfCookie(data);
                    }
                };
        }
        var _53stat = new KfStat();
        window._kfApi = _kfApi;
        window._53stat = _53stat;
})(window);		(function(window,undefined){
			if(typeof _kfApi == 'undefined') var _kfApi = $53.createApi();
            window.hz6d_KfStat = function(id,stat_id){
        		if((typeof id == "undefined") || id == "" || (typeof stat_id == "undefined") || stat_id == "") return false;
        		_kfApi.push('cmd','stat');
                _kfApi.push('id',id);
                _kfApi.push('stat_id',stat_id);
                _kfApi.query();
            }
	    })(window);	$53.data('tpl','crystal_blue');
        $53.setWorkers([]);
        $53.setGroups([]);
        $53.setOnline('0');
    

	// record once visit uuid
	if($53.getCookie('53uvid') != 1) {
		$53.setCookie('53uvid',1);
		$53.data('page_type',1);
	} else {
		$53.data('page_type',2);
	}
	//$53.data('visit_uuid','');
//	$53.data('in_time','');
	$53.data('company_id','72195265');
	$53.data('visit_num',$53.getCookie('53uvid'));

	var hz6d_referer = '&referer=' + $53.EN(window.location.href); //当前访问页面 
	var kf_success=1, kftype=2,
	powered_by_53kf_url = 'http://www.53kf.com',
	powered_by_53kf_txt = 'Powered by 53KF';
    
    
	var onliner_zdfq = $53.getCookie("onliner_zdfq72195265"); // onliner_zdfq: 0.初始值 2.点击接受 3.点击拒绝 
	if (onliner_zdfq == "")
	{
		onliner_zdfq = 0;
		document.cookie = "onliner_zdfq72195265=" + onliner_zdfq;
	}
	var hz6d_kf_type = 2;
	var hz6d_pos_model = 1;
	var hz6d_hidden = 0;
	var hz6d_close_icon = 0;
	var hz6d_icon_type = 0;
	
	function AccCallBack(){}
	// 加载ivt.php，即中间的接受邀请层 
	if (!$53("ivt_script") && !0){
		$53.createScript('ivt_script', 'https://www16.53kf.com/kf_ivt_new.php?arg=10195265&style=1&isonline=0&kfonline=0&lang=zh-cn&resize=yes&charset=GBK&kflist=off&kf=&zdkf_type=1&lnk_overflow=0&callback_id6ds='+ hz6d_referer + hz6d_from_page_new + '&tpl_name=crystal_blue&tpl_width=800&tpl_height=600&uid=8ba83dfc9d42be9ad1e4d0eb65a95a51&is_group=&' + Math.random() + "&talktitle=" + encodeURIComponent(document.title));
	}              var openurl = 'https://www16.53kf.com/webCompany.php?arg=10195265&style=1&language=zh-cn&charset=GBK&referer={hz6d_referer}{hz6d_keyword}&tpl=crystal_blue&uid=8ba83dfc9d42be9ad1e4d0eb65a95a51&is_group='.replace('&referer={hz6d_referer}',hz6d_referer).replace(/{hz6d_keyword}/gim,hz6d_from_page_new);
        $53.setUrl(openurl);
			function getIconEvent(event){
				var eventStr = '';
				switch (event) {
					case 'talk':
						if (2 == "1") {
							if (0 == "1") {
								var hz6d_zdyurl = "?arg=10195265&style=1&kflist=off&kf=&zdkf_type=1&lnk_overflow=0&callback_id6ds=&language=zh-cn&charset=GBK&referer={hz6d_referer}{hz6d_keyword}&tpl=crystal_blue";
								hz6d_zdyurl = hz6d_html_replace(hz6d_zdyurl);
								eventStr += 'onclick="window.open(\'' + hz6d_zdyurl + '\', \'_blank\', \'height=600,width=800,top=50,left=200,status=yes,toolbar=no,menubar=no,resizable=no,scrollbars=no,location=no,titlebar=no\')"';
							}else{
								eventStr += 'onclick="window.open(\'' + openurl + '&tfrom=1\', \'_blank\', \'height=600,width=800,top=50,left=200,status=yes,toolbar=no,menubar=no,resizable=no,scrollbars=no,location=no,titlebar=no\')"';
							}
						}else{
							eventStr += 'onclick="open_floatWindow();"';
						}
						break;
					case 'qq':
						var url = 'tencent://message/?uin='+icon_qq;
					    if(!!window.ActiveXObject || "ActiveXObject" in window)  
					        eventStr += 'onclick="window.open(\'' + url + '\')"';
					    else  
					        eventStr += 'onclick="window.open(\'' + url + '\',\'_self\')"';
						break;
					case 'weibo':
						eventStr += 'onclick="window.open(\'' + icon_weibo + '\',\'_blank\')"';
						break;
					default:
						break;
				}
				return eventStr;
			}

			function Fk(){
				this.icon = document.getElementById("lotto_icon");
				this.l = document.getElementById("lotto_redpacket");
				this.d = document.getElementById("lotto_decorate");
				this.r = document.getElementById("lotto_round");
				this.i = document.getElementById("lotto_inp");
				this.m = document.getElementById("lotto_message");
				this.w = document.getElementById("lotto_win");
				this.b = document.getElementById("lotto_btn");
				this.t = document.getElementById("lotto_btntext");
				this.s = document.getElementById("lotto_s");
				this.n = document.getElementById("lotto_name");
				this.p = document.getElementById("lotto_phonenum");
				this.u = document.getElementById("lotto_statu");
				this.lotto_click = false;
				
				
				this.pubicon = document.getElementById("icon_module"); 	// 获取公共icon模板外层div 
				this.loopmillisecond = 200; 							// 图标循环定位的毫秒，数值越大越慢，对CPU影响越小
				this.issmooth = false; 									// 浮动模式下是否平滑移动
				this.init();
			};
			Fk.prototype = {
				init : function(){
					var _this = this;
					var str01 = '.l_ninety_triangle:after {content: ""; height: 0; width: 0; position: absolute; left: 6px; top: 50%; border: 4px solid transparent; border-left: 5px solid #466080; border-right: none; margin-top: -4px; } .l_triangle:after {content: ""; height: 0; width: 0; position: absolute; left: 6px; top: 50%; border: 4px solid transparent; border-top: 5px solid #466080; border-bottom: none; margin-top: -3px; } .wx_talk:hover #qr_prev{display: block!important; } .phone_error{border:1px solid #F44024 !important; } .op_phone_error{border:2px solid #F04134 !important; } #free_call_53kf:hover{opacity:0.9;filter:alpha(opacity=90);} #make_talk_53kf:hover{opacity:0.9;filter:alpha(opacity=90);}.iconby53-choujiang,.iconby53-choujiang2{animation-name: ani; animation-timing-function: ease-in-out; animation-iteration-count: infinite; animation-duration: 1.5s; -webkit-animation-name: ani; -webkit-animation-timing-function: ease-in-out; -webkit-animation-iteration-count: infinite; -webkit-animation-duration: 1.5s; } @keyframes ani{0% {transform: scale(1); } 25% {transform: scale(1.2); } 50% {transform: scale(1); } 75% {transform: scale(1.2); } }';
					var str02 = '@font-face {font-family: "iconfont"; src: url("www16.53kf.com/walnutui/font/font_fkd/iconfont.eot?t=1546063377705"); /* IE9*/ src: url("www16.53kf.com/walnutui/font/font_fkd/iconfont.eot?t=1546063377705#iefix") format("embedded-opentype"), /* IE6-IE8 */ url("data:application/x-font-woff;charset=utf-8;base64,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") format("woff"), url("www16.53kf.com/walnutui/font/font_fkd/iconfont.ttf?t=1546063377705") format("truetype"); /* iOS 4.1- */ } .iconfont {font-family:"iconfont" !important; font-size:16px; font-style:normal; -webkit-font-smoothing: antialiased; -moz-osx-font-smoothing: grayscale; } .iconby53-Customerservice:before { content: "\\e9f5"; } .iconby53-iPhone:before { content: "\\e9f4"; } .iconby53-QR:before { content: "\\e9f3"; } .iconby53-QQ:before { content: "\\e9f2"; } .iconby53-GoTop:before { content: "\\e9f6"; } .iconby53-floatmax:before { content: "\\e9e1"; } .iconby53-floatmini:before { content: "\\e9e2"; } .iconby53-weibo:before { content: "\\e9f1"; } .iconby53-choujiang:before { content: "\\e9f8"; } .iconby53-choujiang2:before { content: "\\e9f7"; }';
					_this.setCss(str01);

					// iconfont ie8兼容处理
					if(navigator.appName == "Microsoft Internet Explorer"){
						var v = navigator.userAgent.match(/IE\s\d/);
						if(parseInt(v[0].substring(3)) == 8){
							_this.inCludeLink("https://www16.53kf.com/walnutui/font/font_fkd/iconfont.css");
						}else{
							_this.setCss(str02);
						}
					}else{
						_this.setCss(str02);
					}			

					// 点击空白收回
					document.onclick = function(){
						if (document.getElementById("phoneAsk")) {
							document.getElementById("phoneAsk").style.display = "none";
						}
					};

					// 菜单模式定位和hover二维码显示位置控制
					if(hz6d_icon_type == 0 && document.getElementById("qr_prev")){
						var qr_prev = document.getElementById("qr_prev");
						if(inv_left>=50){
							qr_prev.style.right = "65px";
						}else{
							qr_prev.style.right = "-120px";
						}
					}
					
					// 图标浮动模式开启
					if(position_mode == 1){
	    				_this.pubicon.style.position = "absolute";
	    				_this.pubicon.style.left = $53.getS().L + ($53.getWH().W -Math.ceil(_this.pubicon.clientWidth))*(inv_left/100) + "px";
	    				_this.pubicon.style.top = $53.getS().T + ($53.getWH().H -Math.ceil(_this.pubicon.clientHeight))*(inv_top/100) + "px";
						var pw = $53.getS().L;
						var ph = $53.getS().T;
						window.setInterval(function(){
							_this.iconScroll(_this.pubicon,pw,ph);
						},100);
					}
				},
				
				// 图标浮动定位
				iconScroll : function(el){
					var _this = this,
					pageW = $53.getWH().W,				// 页面总宽度
					pageH = $53.getWH().H,				// 页面总高度
					scrolledX = $53.getS().L,			// 图标水平滚动过的距离
					scrolledY = $53.getS().T,			// 图标垂直滚动过的距离
					height = Math.ceil(el.clientHeight),		// 图标高度
					width = Math.ceil(el.clientWidth),			// 图标宽度
					l = scrolledX + (pageW -Math.ceil(el.clientWidth))*(inv_left/100),		// new left
					t = scrolledY + (pageH -Math.ceil(el.clientHeight))*(inv_top/100),		// new top
					left = Math.ceil(el.style.left.replace("px", "")),						// old left
					top = Math.ceil(el.style.top.replace("px", ""));						// old top

					
					//超出窗口边界，直接移动到窗口边界再平滑移动 
					if (_this.issmooth == true)
					{
						if (left != l)
						{
							if (left < (scrolledX - width)) left = scrolledX - width;
							if (left > scrolledX + pageW) left = scrolledX + pageW;
							left = smoothMove(left, l);
						}
						if (top != t)
						{
							if (top < (scrolledY - height)) top = scrolledY - height;
							if (top > scrolledY + pageH) top = scrolledY + pageH;
							top = smoothMove(top, t);
						}
					}
					else if (_this.issmooth == false)
					{
						left = l;
						top = t;
						_this.issmooth = true;
					}

					el.style.left = left + "px";
					el.style.top = top + "px";
				},

				// 图标定位
				positionIcon : function(l,t){
					if(position_mode == 1) return false;
					var wid = $53.getWH().W;
				   	var hei = $53.getWH().H;
					var im = document.getElementById("icon_module");
					im.style.left = (wid-parseInt(im.clientWidth))*(l/100)+'px';
					im.style.top = (hei-parseInt(im.clientHeight))*(t/100)+'px';
				},
				// 抽奖图标定位
				lottoPositionIcon : function(left,top){
					var _this = this;
					try{
						if (_this.icon) {
							var wid=$53.getWH().W;
							var hei=$53.getWH().H;
							_this.icon.style.left =( wid-parseInt(_this.icon.style.width))*(left/100) + 'px';
							_this.icon.style.top = (hei-parseInt(_this.icon.style.height))*(top/100) + 'px';
						}
					}catch(e){}
				},
				setCss : function(str){
					var nod = document.createElement("style"), 
					css_str = str;
					nod.type="text/css";
					if(nod.styleSheet){
						//ie兼容
						nod.styleSheet.cssText = css_str;
					} else {
						nod.innerHTML = css_str; 
					}
					document.getElementsByTagName("head")[0].appendChild(nod);
				},
				phoneAskShow : function(){
					var pa = document.getElementById("phoneAsk"),
					inppc = document.getElementById("input-phonecall"),
					calltip = document.getElementById("calltip"),
					nex = calltip.nextElementSibling || calltip.nextSibling;
					if(inv_left>=50){
						pa.style.left = "-270px";
					}else{
						pa.style.left = "60px";
					}
					if(pa.style.display == "none"){
						pa.style.display = "block";
						this.phoneGoback();
					}else{
						pa.style.display = "none";
						inppc.value = "";
						inppc.className = inppc.className.replace( new RegExp( "(\\s|^)" + 'op_phone_error' + "(\\s|$)" ), " " ).replace(/(^\s+)|(\s+$)/g,'');
						calltip.style.display = 'block';
						nex.style.display = 'none';
					}
				},
				stopBubble:function(e){
					var e = window.event || arguments.callee.caller.arguments[0];

		            // 兼容处理
		            if (e.stopPropagation) {
		                e.stopPropagation();
		            }else{
		                // IE浏览器
		                e.cancelBubble=true;
		            }
				},
				phoneAskForm:function(){
					var inppc = document.getElementById("input-phonecall"),
					calltip = document.getElementById("calltip"),
					waittip = document.getElementById("waittip"),
					val = inppc.value,
					mobil = /^((0\d{2,3}-?\d{7,8})|(1[3-9]\d{9}))$/;
					if(!mobil.test(val)){
						calltip.style.display = 'none';
						var nex = calltip.nextElementSibling || calltip.nextSibling;
						nex.style.display = 'block';
						inppc.className += (inppc.className ? ' ' : '') + 'op_phone_error';
					}else{
						waittip.style.display = "block";
						inppc.value = "";
						$53.callPhone(val,callback_id6ds,'');
					}
				},
				phoneInpDown:function(){
					var inppc = document.getElementById("input-phonecall");
					inppc.className = inppc.className.replace( new RegExp( "(\\s|^)" + 'op_phone_error' + "(\\s|$)" ), " " ).replace(/(^\s+)|(\s+$)/g,'');
					
					var calltip = document.getElementById("calltip");
					calltip.style.display = 'block';
					var nex = calltip.nextElementSibling || calltip.nextSibling;
					nex.style.display = 'none';
				},
				phoneGoback:function(){
					var inppc = document.getElementById("input-phonecall"),
					waittip = document.getElementById("waittip");
					waittip.style.display = "none";
				},
				groupShow : function(obj){
					var nex = obj.nextElementSibling || obj.nextSibling;
					if(!!obj.className.match( new RegExp( "(\\s|^)" + 'l_triangle' + "(\\s|$)") )){
						obj.className = obj.className.replace( new RegExp( "(\\s|^)" + 'l_triangle' + "(\\s|$)" ), " " ).replace(/(^\s+)|(\s+$)/g,''); 
						nex.style.display = "none";
					}else{
						obj.className += (obj.className ? ' ' : '') + 'l_triangle';
						nex.style.display = "block";
					}
					this.positionIcon(inv_left,inv_top);
				},
				beforeSend : function(obj){
					var prev =  obj.previousElementSibling || obj.previousSibling ,
					val = prev.value,
					ww = document.getElementById("wrongword"),
					mobil = /^((0\d{2,3}-?\d{7,8})|(1[3-9]\d{9}))$/,
					befo = document.getElementById("before_send"),
					nex = befo.nextElementSibling || befo.nextSibling;

					if(!mobil.test(val)){
						ww.style.display = "block";
						prev.className += (prev.className ? ' ' : '') + 'phone_error';
					}else{
						ww.style.display = "none";
						prev.className = prev.className.replace( new RegExp( "(\\s|^)" + 'phone_error' + "(\\s|$)" ), " " ).replace(/(^\s+)|(\s+$)/g,''); 
						prev.value = "";
						befo.style.display = "none";
						nex.style.display = "block";
						$53.callPhone(val,callback_id6ds,'');
					}
				},
				afterSend : function(obj){
					var befo = document.getElementById("before_send"),
					nex = befo.nextElementSibling || befo.nextSibling;
					befo.style.display = "block";
					nex.style.display = "none";
				},
				clearError : function(obj){
					var ww = document.getElementById("wrongword");
					obj.className = obj.className.replace( new RegExp( "(\\s|^)" + 'phone_error' + "(\\s|$)" ), " " ).replace(/(^\s+)|(\s+$)/g,''); 
					ww.style.display = "none";
				},
				justNum : function(obj) {
					obj.value = obj.value.replace(/[^\d]/g,'');
				},
				inCludeLink : function(url){
					var link = document.createElement("link");
					link.rel = "stylesheet";
					link.type = "text/css";
					link.href = url;
					document.getElementsByTagName("head")[0].appendChild(link);
				},
				// 抽奖红包出现
				lottoShow : function(){
					var _this = this;
					if(_this.l.style.display == "none"){
						_this.b.setAttribute('data-class',0);
						_this.l.style.display = "block";
						_this.r.style.display = "block";
						_this.d.style.display = "none";
						_this.m.style.display = "none";
						_this.i.style.display = "none";
						_this.w.style.display = "none";
						_this.t.innerHTML = "立即抽奖";
						_this.s.style.display = "inline-block";
						clearInterval(_this.timout);
						_this.s.innerHTML = "(60s)";
						_this.timeGo();
					}else{
						return false;
					}
				},
				// 抽奖红包隐藏
				lottoHide : function(){
					clearInterval(this.timout);
					this.s.innerHTML = "(60s)";
					this.n.value = "";
					this.p.value = "";
					this.l.style.display = "none";
				},
				// 抽奖状态切换(待添加验证：该手机号码已领取奖励)
				lottoChange : function(obj,award_id){
					var _this = this;
					if(obj.getAttribute('data-class') == 0){
						obj.setAttribute('data-class',1);
						_this.r.style.display = "none";
						_this.d.style.display = "block";
						_this.m.style.display = "block";
						_this.i.style.display = "block";
						_this.t.innerHTML = "立即领取";
						_this.s.style.display = "inline-block";
						clearInterval(_this.timout);
						_this.s.innerHTML = "(60s)";
						_this.timeGo();
					}else if(obj.getAttribute('data-class') == 1){
						var mobil = /^1[3-9]\d{9}$/;
						if(_this.p.value == ""){
							_this.statuSh("请输入手机号码");
							return false;
						}else if(!mobil.test(_this.p.value)){
							_this.statuSh("请输入有效的手机号码");
						}else{
							if(_this.lotto_click){
								return false;
							}else{
								_this.lotto_click = true;
							}
							var name = _this.n.value;
							var mobile = _this.p.value;
							var callBackFunName = "award_callback_"+new Date().getTime();
							eval(callBackFunName + '= function(data){_this.createResult(data)}');
							var url = "https://www16.53kf.com/kfapi_award.php?company_id=72195265&style=1&guest_id=10735741353002&name="+encodeURIComponent(name)+"&mobile="+mobile+"&award_id="+award_id+"&callback="+callBackFunName;
							var id = 'kf_script_'+$53.counter;
							$53.createScript(id,url);
							$53.counter++;
							_this.t.innerHTML = "抽奖中...";
							_this.s.style.display = "none";
							clearInterval(_this.timout);
						}
					}else{
						if (2 == "1") {
							if (0 == "1") {
								var hz6d_zdyurl = "?arg=10195265&style=1&kflist=off&kf=&zdkf_type=1&lnk_overflow=0&callback_id6ds=&language=zh-cn&charset=GBK&referer={hz6d_referer}{hz6d_keyword}&tpl=crystal_blue";
								hz6d_zdyurl = hz6d_html_replace(hz6d_zdyurl);
								window.open(hz6d_zdyurl,'_blank', 'height=600,width=800,top=50,left=200,status=yes,toolbar=no,menubar=no,resizable=no,scrollbars=no,location=no,titlebar=no');
							}else{
								window.open(openurl+'&tfrom=1', '_blank', 'height=600,width=800,top=50,left=200,status=yes,toolbar=no,menubar=no,resizable=no,scrollbars=no,location=no,titlebar=no');
							}
						}else{
							open_floatWindow();
						}
						_this.l.style.display = "none";
					}
				},
				createResult:function(data){
					var _this = this;
					if(data.code == 200){
						try{
							document.getElementById('lotto_btn').setAttribute('data-class',2);
							_this.r.style.display = "none";
							_this.m.style.display = "none";
							_this.i.style.display = "none";
							_this.w.style.display = "block";
							_this.t.innerHTML = "咨询在线客服";
							_this.s.style.display = "none";
							_this.icon.style.display = "none";
						}catch(e){
							document.getElementsByClassName('checklotto')[0].style.display = 'none';
						}
					}else{
						_this.statuSh(data.info);
					}
					_this.lotto_click = false;		
				},
				// 状态提醒
				statuSh : function(str){
					var _this = this;
					_this.t.innerHTML = "立即抽奖";
					clearInterval(_this.timout);
					_this.s.innerHTML = "(60s)";
					_this.s.style.display = "inline-block";
					_this.timeGo();
					_this.u.innerHTML = str;
					_this.u.style.display = "block";
					_this.u.style.marginLeft = (-_this.u.offsetWidth/2) + "px";
					_this.u.style.left = "50%";
					var timer = setTimeout(function(){
						_this.u.style.display = "none";
						clearTimeout(timer);
					},1500)
				},
				// 60s倒计时
				timeGo : function() {
					var _this = this;
					var count = 60;
					_this.timout = setInterval(function(){
						count--;
						_this.s.innerHTML = "("+count+"s)";
						if(count == 0){
							clearInterval(_this.timout)
							_this.l.style.display = "none";
						}
					},1000)
				},
				// 返回顶部
				gotop : function(){
					var _this = this;
					var otp = document.documentElement.scrollTop || window.pageYOffset || document.body.scrollTop;
					function bodyscroll(e){
						e.preventDefault();
					}
					if(otp > 0){
						var timer = setInterval(function(){
							var ostop = document.documentElement.scrollTop || window.pageYOffset || document.body.scrollTop;
							var speed = Math.floor(-ostop/5);
							document.documentElement.scrollTop = document.body.scrollTop = ostop + speed;
							// 阻止滑轮和键盘事件
							window.addEventListener("wheel",bodyscroll,false)
							window.addEventListener("keydown",bodyscroll,false)
							if(ostop == 0){
								window.removeEventListener("wheel",bodyscroll,false)
								window.removeEventListener("keydown",bodyscroll,false)
								clearInterval(timer)
							}
						},30)
					}
					
				}
			};		function set_hz6d_bottom_logo() {
			try {
				if ('server' != "oem")
				{
					clearTimeout(set_hz6d_bottom_logo.timer);
					$53("hz6d_bottom_logo").style.textAlign = 'right';
					$53("hz6d_bottom_logo").style.textIndent = '0px';
					if("blue" == 'pink' || "blue" == 'yellow2'  || "blue" == 'blue2')
					{
						$53("hz6d_bottom_logo").style.lineHeight = $53("hz6d_bottom_logo").parentNode.offsetHeight + 'px';
						$53("hz6d_bottom_logo").style.position = 'relative';
						$53("hz6d_bottom_logo").style.top = '6px';
					}
					$53("hz6d_bottom_logo").style.backgroundImage = '';
					if ("1" == true) {
						$53("hz6d_bottom_logo").innerHTML  = '<a style="text-decoration:none;color:#999;display:inline-block;margin-right:8px;font-size:11px;;font-family: Microsoft YaHei;font-size:10px;-webkit-text-size-adjust:none" onmouseout="this.style.textDecoration=\'none\'" onmouseover="this.style.textDecoration=\'underline\'" target="_blank" href="' + powered_by_53kf_url + '">' + powered_by_53kf_txt + '</a>';
					}
					else {
						$53("hz6d_bottom_logo").innerHTML  = '<a style="text-decoration:none;color:#999;display:inline-block;margin-right:8px;font-size:11px;;font-family: Microsoft YaHei;font-size:10px;-webkit-text-size-adjust:none" onmouseout="this.style.textDecoration=\'none\'" onmouseover="this.style.textDecoration=\'underline\'" target="_blank" href="' + powered_by_53kf_url + '">' + $53("hz6d_bottom_logo").innerHTML + '</a>';
					}
					$53("hz6d_bottom_logo").style.display = '';
				}
			} catch(e) {
				set_hz6d_bottom_logo.timer = setTimeout(set_hz6d_bottom_logo,100);
			}
		}				var callback_id6ds = '';
				var icon_qq = '';
				var icon_weibo = '';
				var position_mode = '1'; 	// 0 固定 1 浮动
				var inv_left = '97';
				var inv_top = '87';
				var div = document.createElement("div");
				var html = '<div id="icon_module" style="position: fixed; z-index:999999;"><div id="icon_menu_module" style="width: 60px; background:#eb1e96; margin-bottom: -1px;box-sizing: border-box;padding:0 3px;font-size: 0;"><div class="online_talk zxzx sortmodule" event="{talk}" style="position: relative;width: 100%;height: 70px;cursor: pointer;text-align: center;"><span class=" iconfont iconby53-Customerservice" style="width:36px;height: 36px;font-size: 36px;line-height: 36px;text-align: center;color:#FFFFFF; margin-top:8px ;margin-bottom:4px ;display: inline-block;"></span><p style="font-size: 12px;color: #FFFFFF;letter-spacing: 0.63px;text-align: center;margin:0;">在线咨询</p><span class="border_line" style="position:absolute;width: 100%;height: 1px;left:0;bottom:0;background:#FFFFFF;opacity: 0.4;filter: alpha(opacity=40); display: block;"></span></div></div></div>';
				html = html.replace(/event="\{(.*?)\}"/g, function(match, contents){
					return getIconEvent(contents);
				});
				div.innerHTML = html;
				var doc = (document.body||document.documentElement);
				doc.insertBefore(div,doc.firstChild);
				var fk = new Fk();
				window.fk = fk;		function positionIcon(){
			if (1 == '0') {
				try{
					if (hz6d_icon_type == 3) {
						var wid = $53.getWH().W;
						var hei = $53.getWH().H;
						var im = document.getElementById("iconDivMain"+kf_icon_id) || document.getElementById("hz6d_kf_icon_"+kf_icon_id);
						im.style.position = 'fixed';
						im.style.right = 'auto';
						im.style.left = (wid-parseInt(im.clientWidth))*(97/100)+'px';
						im.style.bottom = 'auto';
						im.style.top = (hei-parseInt(im.clientHeight))*(87/100)+'px';
					}else if (hz6d_icon_type != -1) {
						fk.positionIcon(inv_left,inv_top);
					}
				}catch(e){}
			}
			try{
				if (0 == '1') {
					fk.lottoPositionIcon(100,40);
				}
			}catch(e){}
		}
		positionIcon();
		try{
			window.addEventListener("resize",function(){positionIcon()},false);
		}catch(e){
			window.attachEvent("onresize",function(){positionIcon()});
		}