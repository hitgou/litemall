<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <!-- <meta http-equiv="Content-Type" content="text/html; charset=utf-8" /> -->
    <meta name="renderer" content="webkit|ie-stand|ie-comp">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <!--引入CSS-->

    <!--引入JS-->
    <script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
    <link rel="stylesheet" href="style/chat/new2017/css/minichat.css?2019011801">

    <!-- 别删这段注释=====================start===================== -->

    <!--ie8下给他边框-->
    <!--[if IE 8]>
    <style>
        .newWindow {
            border:1px solid #ccc;
            width:358px;
            height:422px;
        }
        .newWindow.window_size400 {
            height:362px;
        }
    </style>
    <![endif]-->

    <!-- 别删这段注释=====================end===================== -->
    <script>
var company_id = "72195265";
var obj_id = 0; // 客服ID
var myid = "-1"; // 访客id
var system_version = 'zuyong'; // gongsi:公司内测版 zuyong:外网租用版
var enable_debug = '0'; // 系统调试   1:开 0:关
var enable_js_error = '0'; // JS报错提示 1:开 0:关
var enable_talk_collection = "1";  // 通讯采集开关 1:开启 0:关闭
var http_pro = (document.location.protocol == 'https:')?'https://':'http://';//区分HTTP和HTTPS
var g_comm_success = false;
var guidance_type = "1";//智能引导类型 1:发送消息建立对话 2:键入时建立对话
// 改进版插入错误信息
function insertErrorInfos2(err_from, err_type, err_detail)
{
	if (enable_debug == 0) return;
	var httprequest;
	if (window.XMLHttpRequest)
	{
		httprequest = new XMLHttpRequest();
	}
	else
	{
		httprequest = new ActiveXObject("Microsoft.XMLHTTP");
	}

  try
  {
    if(httprequest!=null)
    {
      err_from = window.encodeURIComponent(err_from);
      err_type = window.encodeURIComponent(err_type);
      err_detail = window.encodeURIComponent(err_detail);
      var senddata = "err_from="+err_from+"&err_type="+err_type+"&err_detail="+err_detail+"&company_id="+company_id+"&id6d="+obj_id;
      var url = "err_infos.php";
      httprequest.open("POST", url, true);
      httprequest.setRequestHeader("Content-Length", senddata.length);
      httprequest.setRequestHeader("CONTENT-TYPE", "application/x-www-form-urlencoded");
      httprequest.send(senddata);

      httprequest.onreadystatechange = function()
      {
        if(4==httprequest.readyState)
        {
          if(200==httprequest.status)
          {
            //alert(httprequest.responseText);
            //var dom = httprequest.responseXML;
          }
        }
      }
    }
  }
  catch(e){}
}

//页面脚本错误捕捉
// window.onerror = function(msg,url,line) {
// 	alert(msg);
// 	// insertErrorInfos2('2','windowError','{msg:"' + msg + '",url:"'+ url + '",line:"' + line + '",browser:"' + navigator.userAgent + '","time:"' + (new Date().getTime()) + '",guest_id:"' + myid + '"}');
// 	if (enable_js_error == 0) return true;
// }
//运维监控平台相关
var client_IP = '118.114.111.2';
var timeStamp = 1551753834081; // 开始时间 毫秒
if (timeStamp <= 0 || Math.abs(timeStamp - new Date().getTime()) > 100000) timeStamp = new Date().getTime();
var monitor_url = 'http://mon.53rj.com.cn/sendmon.jsp';
</script>
<div style="z-index:-100;height:0px;visibility: hidden;">
  <span id="plugin_snapshot" style="display: none;"></span>
  <iframe id="kh_gid" name="kh_gid" src="" width="1" height="1" frameborder="0"></iframe>
  <iframe id="scan_speed" name="scan_speed" src="" width="1" height="1" frameborder="0"></iframe>
</div>
<iframe id="iframe_fav" src="iframe_fav.php" style="display:none"></iframe>
<div id="iefav" class="hslice" style="display:none"><div class="entry-title">[深圳恩颂科技]</div></div><input type="hidden" id="kh_has_import" name="kh_has_import" value="-1">
    <style>
        .pc-service-right label{
            max-width: 200px;
            overflow: hidden;
            display: inline-block;
            text-overflow: ellipsis;
            float: left;
            white-space: nowrap;
        }
        .groups{
            box-sizing:border-box;
            padding-bottom: 25px;
        }
       /* 加载新的外链  */
              #pcWrap .pc-visitor-footer {bottom: 15px !important; }
       .pc-visitor-main {padding-bottom: 110px !important; }
       .talk.hasCallBack .pc-visitor-main {padding-bottom: 140px !important; }
       #float_to53{z-index: 210;position: absolute; bottom: 0; width: 100%; height: 18px; background: #f8f7f7;  font-size: 12px; text-align: center; line-height: 18px;}
       #float_to53 a{text-decoration: none;color: #8DA2B5;}
       #float_to53 a:hover{color: #218BFC; text-decoration: underline; }
       .sm_triangle{display: none !important; }
           </style>
</head>
<body onload="initial()">
<div class="img_bgmask"><span class="close_bgmask"></span><div class="view_img_wrap"><img src="" alt=""></div></div>
    <div class="newWindow ">
        <div class="window-content">
            <div class="content-left">
                    <div class="connectionFail font12 color-red" style="display: hidden"></div>
                    <div class="toasts"><div><span class="toastsBg font14">&nbsp;</span><span class="toastsText font14">异常</span></div></div><!-- 系统提示消息 -->
                <div id="pcWrap">
                    <div class="pc-visitor" style="display:block;height:100%;overflow:auto;overflow-x: hidden;">
                        <!-- 留言成功 -->
                        <div class="leaveMsg-suc color-grey-deep font13">
                            <div class="leaveBg"></div>
                            <div class="suc-text">
                                <p>已收到了您的留言</p><!-- 已收到了您的留言 -->
                                <p>我们会在第一时间内给予您回复!</p><!-- 我们会在第一时间内给予您回复 -->
                            </div>
                            <div class="close-suc font12">
                                <span class="close-suc-btn buttonType2 color-grey-middle font13">关闭窗口</span><!-- 关闭窗口 -->
                                <p class="color-grey-light font12"><a class="seconds">10</a>秒后自动关闭该窗口</p><!-- 秒后自动关闭该窗口 -->
                            </div>
                        </div>
                        <!--聊天前信息填写-->
                        <div class="before-talk">

                        </div>
                        <!--留言-->
                        <div class="leave-message">

                        </div>
                        <!--主动选择客服-->
                        <div class="select-customer" >

                        </div>
                        <!--聊天-->
                        <div class="talk" style="display:block;">
                            <div class="line-up">
                                <div>
                                    <p class="font12 color-grey-deep">当前客服接待能力已达上限，请耐心等候！</p><!-- 当前客服接待能力已达上限，请耐心等候！ -->
                                    <h6 class="font14 color-grey-deep">当前等待人数：<span class="personNum color-blue">0</span></h6><!-- 当前等待人数: -->
                                </div>
                                <div class='line-up-btnGroup fr'>
                                    <a class="font12 color-grey-middle toMessage buttonType2" onclick="getWlist(1)">转留言</a><!-- 转留言 -->
                                    <a class="font12 color-grey-middle toRobot buttonType2" onclick="showzsk()" style="display: none;">转机器人</a><!-- 转机器人 -->
                                </div>
                            </div>
                            <div class="pc-visitor-main">
                                <div class="sevice" style='display:block;'>
                                    <div class="pc-talk" >
                                                                                <p class="show_history show_history_hover"><label><a id="show_last_msg_button" onclick="get_record()">显示上次聊天记录</a></label></p>
                                                                                                                        <p class="system-remind"><label>欢迎您的咨询，期待为您服务!</label></p>
                                    </div>
                                    <div class="pc-robot" style="display:block;">

                                        <div class="pc-service" id="robot_start">
                                            <div class="pc-service-left" style="display: inline-block;"><img src="../img/upload/10195265/robot/201902191734328171.png" alt="头像"></div>
                                            <div class="pc-service-right">
                                                <p><label>恩颂小A</label><span id="robot_start_time"></span></p>
                                                <div class="pc-service-info pc-robot-info">
                                                    <h6 class="pc-robot-reply">你好，请问我有什么可以帮到您的？</h6>
                                                                                                    </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="pc-visitor-footer">
                                <div class="sm_triangle"></div>
                                <a class="triangle_to53" href="https://www.53kf.com/CustomerServiceSystem?kfcount=float" target="_blank">by <span class="hover_53" style="display: inline;font-size: 12px;line-height: 12px;">53KF</span></a>
                                <div class="net_callBack color-grey-middle">免费电话咨询，请放心接听<span class="net_callBack_wrap"><input class="net_callBack_input color-grey-middle" placeholder="输入手机号码" value="" type="text"><span class="net_callBack_btn" style="background: #CE3A5E">免费通话</span></span></div>
                                <p class="system-remind kf_input"><label>客服正在输入中...</label></p><!-- 客服正在输入中... -->
                                <div class="function-bar">
                                    <div class="face-lists toggleHidden"></div>
                                    <div class="guanlian-problem"></div>
                                    <div class="service-help toggleHidden"></div>
                                    <div class="cutbox toggleHidden">
                                        <p>屏幕截图</p>
                                        <p>截图时隐藏当前窗口</p>
                                    </div>
                                    <div class="cutbox_mac toggleHidden">
                                    	<p>1.⌘+control+shift+4</p>
                                    	<p>2.⌘+v，即可粘贴至输入框</p>
                                    </div>
                                    <div class="talk-function-bar">
                                        <div class="svgWrap">
                                            <?xml version="1.0" encoding="UTF-8"?>
                                                                                        <label class="changeColor-wrap">
                                            <svg data-title="表情" class="function-icon icon-face" width="24px" height="24px" viewBox="0 0 24 24" version="1.1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink"><!-- 表情 -->
                                                <g id="Page-1" stroke="none" stroke-width="1" fill="none" fill-rule="evenodd">
                                                    <g id="Imported-Layers-Copy-7">
                                                        <rect id="Rectangle-3" x="0" y="0" width="24" height="24"></rect>
                                                        <path class="svgColor" d="M5,12 C5,15.8656805 8.1343195,19 12,19 C15.8656805,19 19,15.8656805 19,12 C19,8.1343195 15.8656805,5 12,5 C8.1343195,5 5,8.1343195 5,12 Z M3,12 C3,7.02975 7.02975,3 12,3 C16.97025,3 21,7.02975 21,12 C21,16.97025 16.97025,21 12,21 C7.02975,21 3,16.97025 3,12 Z" id="Combined-Shape" fill="#8FA1B3" fill-rule="nonzero"></path>
                                                        <path class="svgColor" d="M9,8 C8.172,8 7.5,8.672 7.5,9.5 C7.5,10.328 8.172,11 9,11 C9.828,11 10.5,10.328 10.5,9.5 C10.5,8.672 9.828,8 9,8" id="Fill-2" fill="#8FA1B3"></path>
                                                        <path class="svgColor" d="M15,8 C14.172,8 13.5,8.672 13.5,9.5 C13.5,10.328 14.172,11 15,11 C15.828,11 16.5,10.328 16.5,9.5 C16.5,8.672 15.828,8 15,8" id="Fill-2-Copy" fill="#8FA1B3"></path>
                                                        <path class="svgColor" d="M9.55730755,18.9802954 C12.5582692,18.9802954 15.0860829,16.7646048 15.4989445,13.8196019 C15.5756198,13.2726656 15.1943979,12.7671285 14.6474616,12.6904532 C14.1005252,12.6137779 13.5949881,12.9949998 13.5183128,13.5419361 C13.2434436,15.5026194 11.5576081,16.9802954 9.55730755,16.9802954 C9.0050228,16.9802954 8.55730755,17.4280106 8.55730755,17.9802954 C8.55730755,18.5325801 9.0050228,18.9802954 9.55730755,18.9802954 Z" id="Oval-26" fill="#8FA1B3" fill-rule="nonzero" transform="translate(12.033030, 15.830470) rotate(39.000000) translate(-12.033030, -15.830470) "></path>
                                                    </g>
                                                </g>
                                            </svg>
                                            </label>
                                                                                                                                    <label class="function-icon-disabled">
                                            <svg data-title="截图" class="function-icon icon-cut" width="24px" height="24px"  viewBox="0 0 24 24" version="1.1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink"><!-- 截图 -->
                                                <g id="Page-1" stroke="none" stroke-width="1" fill="none" fill-rule="evenodd">
                                                    <g id="Group-15">
                                                        <g id="Group-81-Copy-6">
                                                            <rect id="Rectangle-81" x="0" y="0" width="24" height="24"></rect>
                                                        </g>
                                                        <g class="svgColor" transform="translate(4.000000, 4.000000)" fill-rule="nonzero" fill="#8FA1B3">
                                                            <path d="M3.5,14 C4.32842712,14 5,13.3284271 5,12.5 C5,11.6715729 4.32842712,11 3.5,11 C2.67157288,11 2,11.6715729 2,12.5 C2,13.3284271 2.67157288,14 3.5,14 Z M9.5510355,7.32174556 L11.2561548,9.22746708 C11.6426526,9.08048219 12.0619275,9 12.5,9 C14.4329966,9 16,10.5670034 16,12.5 C16,14.4329966 14.4329966,16 12.5,16 C10.5670034,16 9,14.4329966 9,12.5 C9,12.1413991 9.05393,11.7953943 9.1541219,11.4696536 L8,9.7 L6.8458781,11.4696536 C6.94607,11.7953943 7,12.1413991 7,12.5 C7,14.4329966 5.43299662,16 3.5,16 C1.56700338,16 0,14.4329966 0,12.5 C0,10.5670034 1.56700338,9 3.5,9 C3.93807254,9 4.35734745,9.08048219 4.74384524,9.22746708 L6.4489645,7.32174556 L2,0.5 L3,0 L8,5.58823529 L13,0 L14,0.5 L9.5510355,7.32174556 Z M12.5,14 C13.3284271,14 14,13.3284271 14,12.5 C14,11.6715729 13.3284271,11 12.5,11 C11.6715729,11 11,11.6715729 11,12.5 C11,13.3284271 11.6715729,14 12.5,14 Z M8,9 C8.55228475,9 9,8.55228475 9,8 C9,7.44771525 8.55228475,7 8,7 C7.44771525,7 7,7.44771525 7,8 C7,8.55228475 7.44771525,9 8,9 Z" id="Combined-Shape"></path>
                                                        </g>
                                                    </g>
                                                </g>
                                            </svg>
                                            </label>
                                                                                                                                    <label class="upload_box function-icon-disabled" style="position: relative;width:24px;height:24px">
                                                <svg data-title="发送文件及图片" class="function-icon upload_copy" style="position:absolute;top:-24px;left:0;" xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24">
                                                    <path class="svgColor" fill="#8FA1B3" d="M5,18 L19.0010872,18 C19.0005141,17.9998702 19.0001517,14.6674569 19,8.00276013 C19,8.00181211 16.294032,8.00089207 10.8820961,8 L9.88209609,6 L5.00673767,6 C5.00250242,6 5.00025653,10 5,18 Z M3,5.99188419 L3,4 L11.1181641,4 L12.1181641,6 L21,6 L21,8.00276013 L21,17.9972399 L21,20 L3,20 L3,18.0081158 L3,5.99188419 Z M13,17 L13,12.6666667 L15,14 L15,12 L12,10 L9,12 L9,14 L11,12.6666667 L11,17 L13,17 Z"/>
                                                </svg>
                                                <div data-title="发送文件及图片" class="function-icon" id="file-picker"></div><!-- 发送文件及图片 -->
                                            </label>

                                                                                                                                    <label class="function-icon-disabled">
                                            <svg data-title="热点问题" class="function-icon icon-hot" width="24px" height="24px" viewBox="0 0 24 24" version="1.1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink"><!-- 热点问题 -->
                                                <g stroke="none" stroke-width="1" fill="none" fill-rule="evenodd">
                                                    <g id="Group-81-Copy-9">
                                                        <rect id="Rectangle-81" x="0" y="0" width="24" height="24"></rect>
                                                        <path class="svgColor" d="M8.36429893,18.8289413 C9.73063846,18.9292579 11.3349938,19 12,19 C15.8659932,19 19,15.8659932 19,12 C19,8.13400675 15.8659932,5 12,5 C8.13400675,5 5,8.13400675 5,12 C5,12.9334813 5.18172934,13.8381842 5.53032851,14.6788664 C5.88219305,15.5274235 6.39972947,16.2992244 7.05025253,16.9497475 C7.58057379,17.4800687 7.81513896,18.1368736 7.78034883,18.782781 C7.96902857,18.7987713 8.16420494,18.8142504 8.36429893,18.8289413 Z M12,21 C10.7797335,21 5.61618829,20.7571475 4.55505929,20.3171374 C3.4550176,19.8609917 6.46504129,19.1929633 5.63603897,18.363961 C4.80703665,17.5349587 4.13900833,16.5449824 3.68286262,15.4449407 C3.24285253,14.3838117 3,13.2202665 3,12 C3,7.02943725 7.02943725,3 12,3 C16.9705627,3 21,7.02943725 21,12 C21,16.9705627 16.9705627,21 12,21 Z M11,16 L11,18 L13,18 L13,16 L11,16 Z M12.6104509,12.4976038 C13.4074876,12.4629533 14.1077049,12.0551122 14.5407202,11.444463 C14.3840377,11.6423026 14.190102,11.8124641 13.9633411,11.9587389 C13.7268824,12.1112694 13.4703124,12.2260924 13.2136687,12.3071516 C13.0621981,12.3549926 12.9487749,12.3801478 12.8939829,12.3884342 C12.7928032,12.4132899 12.6978709,12.4503543 12.6104509,12.4976038 Z M12.5,6.5 C10.5670034,6.5 9,8.06700338 9,10 L9,10.5 L11,10.5 L11,10 C11,9.17157288 11.6715729,8.5 12.5,8.5 C13.3284271,8.5 14,9.17157288 14,10 C14,10.8284271 13.3284271,11.5 12.5,11.5 C11.6756918,11.5 11,12.1724456 11,12.9989566 L11,15.5 L13,15.5 L13,13.5046844 C13,13.4454361 13.0519764,13.3773941 13.0900178,13.3678838 C13.4237612,13.3196847 13.9617585,13.1497617 14.5054089,12.7990736 C15.4319801,12.201378 16,11.2739628 16,10 C16,8.17357596 14.384759,6.5 12.5,6.5 Z" id="Combined-Shape" fill="#8FA1B3" fill-rule="nonzero"></path>
                                                        <g id="Group-18-Copy" transform="translate(9.000000, 6.000000)"></g>
                                                    </g>
                                                </g>
                                            </svg>
                                            </label>
                                                                                                                                                                                <label class="function-icon-disabled disabled">
                                            <svg data-title="评价" class="function-icon evaluation-icon function-icon-eval" width="24px" height="24px" viewBox="0 0 24 24" version="1.1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink">
                                                <!-- 评价 -->
                                                <g id="pc端" stroke="none" stroke-width="1" fill="none" fill-rule="evenodd">
                                                    <g class="svgStroke" id="Group-21" stroke="#8FA1B3" stroke-width="2">
                                                        <path d="M15.9619362,17.4531374 L15.2052738,13.0414566 L18.4105475,9.91708685 L13.9809681,9.27343129 L12,5.25955146 L10.0190319,9.27343129 L5.5894525,9.91708685 L8.79472625,13.0414566 L8.03806376,17.4531374 L12,15.3702243 L15.9619362,17.4531374 Z" id="Star"></path>
                                                    </g>
                                                </g>
                                            </svg>
                                            </label>
                                                                                    </div>
                                        <div class="imgWrap">
                                                                                        <label class="changeColor-wrap"><span data-title="表情" class="function-icon icon-face"></span></label><!-- 表情 -->
                                                                                                                                    <span data-title="截图" class="function-icon icon-cut function-icon-disabled"></span><!-- 截图 -->
                                                                                                                                    <span data-title="发送文件及图片" id="file-picker" class="function-icon icon-file fileUpload function-icon-disabled"></span><!-- 发送文件及图片 -->
                                                                                                                                    <span data-title="热点问题" class="function-icon icon-hot function-icon-disabled"></span><!-- 热点问题 -->
                                                                                                                                                                                <span data-title="评价" class="function-icon icon-eval function-icon-eval function-icon-disabled"></span><!-- 评价 -->
                                                                                    </div>
                                    </div>
                                    <div class="robot-function-bar">
                                        <span class="robotLinkTo robotToLword color-grey-middle" onclick="getWlist(1)">转留言</span><!-- 转留言 -->
                                        <span class="robotLinkTo robotToKF color-grey-middle" onclick="robotToTalk()">转人工</span><!-- 转人工 -->
                                    </div>
                                    <div class="footer-text">
                                        <span></span>
                                        <b></b>
                                    </div>
                                </div>
                                <div class="inputArea">
                                    <!-- <textarea class="color-grey-deep"></textarea> -->
                                    <span class="please_input color-grey-light font13">请输入文字或粘贴截图</span>
                                    <!-- <script name="editor" id="myEditor" name="content" type="text/plain"></script> -->
                                    <textarea id="myEditor" name="content" id="" ></textarea>
                                    <a id="btnSend" class="submit-btn-wrap font14 disabled" style="background-color:rgb(30, 137, 230)">发送<i class="submit-btn btnHover btnActive"></i></a><!-- 发送 -->
                                </div>
                                <div class="beStopped color-red" style="display:none;">
                                    抱歉，客服系统暂时无法使用！
                                </div><!-- 你已经被禁止对话！ -->
                                <div class="maskArea" style="display:none;">
                                    <div class="sm_triangle"></div>
                                    <a class="triangle_to53" href="https://www.53kf.com/CustomerServiceSystem?kfcount=float" target="_blank">by <span class="hover_53" style="display: inline;font-size: 12px;line-height: 12px;">53KF</span></a>
                                    <span>当前对话已结束，您可以<span style="margin:0 5px;" class="toNewChat color-blue" onclick="location.reload();">开始新对话</span>或<span class="toLword color-blue" style="margin:0 5px;" onclick="getWlist(1)">留言</span></span>
                                </div><!-- 当前对话已结束，您可以   开始新对话    或   留言 -->
                            </div>
                            <div id="float_to53"><a href="https://www.53kf.com/CustomerServiceSystem?kfcount=float" target="_blank">53KF 提供软件支持</a></div><!-- 53KF 提供软件支持 -->
                        </div>
                        <p class="by53kf">
                            <a class="toDeveloper" href="https://www.53kf.com/CustomerServiceSystem?kfcount=float" target="_blank">by 53KF</a>
                        </p>
                    </div>
                </div>
            </div>
        </div>
    </div>
<bgsound id="bgsoundSound"></bgsound>
<audio id="audioSound"></audio>
<script>
    // 让ie11以下和safari浏览器不支持粘贴qq截图
    // (function(){
    //     if($(".please_input").text().indexOf("QQ") < 0 ) return;
    //     var is_ie = (function isIE() {
    //         if(!!window.ActiveXObject || "ActiveXObject" in window)
    //             return true;
    //         else
    //             return false;
    //     })();
    //     var navigator_type = navigator.userAgent.toLowerCase();
    //     if ( (navigator_type.indexOf("safari") > -1 && navigator_type.indexOf("chrome") < 0) || is_ie ){
    //         $(".please_input").text($(".please_input").text().substr(0,3));
    //     };

    //     is_ie = null;
    // })()
</script>
<script src="js/new2017/basic.js?66"></script>
<!-- <script type="text/javascript" src="js/umeditor/third-party/template.min.js"></script>
<script type="text/javascript" charset="utf-8" src="js/umeditor/umeditor.config.js"></script>
<script type="text/javascript" charset="utf-8" src="js/umeditor/umeditor.min.js?2017112320"></script>
<script type="text/javascript" src="js/umeditor/lang/zh-cn/zh-cn.js"></script> -->

<script type="text/javascript" charset="utf-8" src="js/new2017/kindeditor/kindeditor-min.js?2018122801"></script>
<script type="text/javascript" src="js/new2017/kindeditor/lang/zh_CN.js?1"></script>

<style>
    .newWindow .ke-toolbar {display:none!important;}
    .newWindow .ke-statusbar {display:none;}
    .newWindow .ke-container {border:none;z-index: 10;position: relative;background: none;}
    .newWindow .ke-container div {background: none;}
    #pcWrap .pc-visitor-footer .inputArea .please_input {z-index: 9;}
    #file-picker div {width:24px!important;height:24px!important;}
</style>
<script>
    var kindeditor;
    KindEditor.ready(function(K) {
        kindeditor = K.create('textarea[name="content"]', {
            items : [],
            width:"100%",
            height:"56px",
            minHeight:"56px",
            cssData:'body {padding:5px 10px;} .ke-content {font-size: 13px;word-wrap: break-word;} .ke-content img {vertical-align: middle!important;max-width:100%;}',
            resizeMode:0,
            resizeType:0,
            pasteType:2,
            newlineTag:"br",
            allowPreviewEmoticons:false,
            // useContextmenu:false,
            htmlTags:{
                img : ['src', 'width', 'height', 'border', 'alt', 'title', 'align', 'style', '/'],
                'br' : []
            },
            afterFocus : function(){
                $(".face-lists").removeClass("active");
                $(".service-help").removeClass("active");
                $(".icon-hot").parent().removeClass("active");
                $(".cutbox_mac").removeClass("active").slideUp(100);
                $(".icon-cut").parent().removeClass("active");
                $(".changeColor-wrap").removeClass("active");
                $(".toggleHidden").slideUp(100);
            },
            afterCreate : function() { //设置编辑器创建后执行的回调函数
                var self = this;
                var $txt = $(".ke-edit-iframe").contents().find("body");
                $txt.attr("contenteditable","true");
                $(".please_input").hide();
                $(".submit-btn-wrap").removeClass("disabled");
                $txt.click(function(){
                    $(".please_input").hide();
                    $(".submit-btn-wrap").removeClass("disabled");
                })
                $txt.keyup(function (event) {
                    var content = $txt[0].innerText.length
                    if(content>0){
                        $(".please_input").hide();
                        $(".submit-btn-wrap").removeClass("disabled");
                    }else{
                        $(".please_input").show();
                        $(".submit-btn-wrap").addClass("disabled");
                    }
                    if(event.keyCode==13 && !event.ctrlKey && !event.shiftKey ){
                        //self.sync();
                        sendmsg();
                        $(".submit-btn-wrap").addClass("disabled");
                        return false;

                    };
                });

                // 复制粘贴
                var editerDoc = this.edit.doc;//得到编辑器的文档对象
                //监听粘贴事件, 包括右键粘贴和ctrl+v
                $(editerDoc).bind('paste', null, function (e) {
                   try {
                        var ele = e.originalEvent.clipboardData.items;
                        for (var i = 0; i < ele.length; ++i) {
                            //判断文件类型
                            if ( ele[i].kind == 'file' && ele[i].type.indexOf('image/') !== -1 ) {
                                $(".please_input").hide();
                                var file = ele[i].getAsFile();//得到二进制数据
                                var formData = new FormData();
                                formData.append("userupload",file);//name,value
                                //用jquery Ajax 上传二进制数据
                                $.ajax({
                                    url : http_pro+host+'/upload_img_file.php?company_id='+company_id,
                                    type : 'POST',
                                    data : formData,
                                    // 告诉jQuery不要去处理发送的数据
                                    processData : false,
                                    // 告诉jQuery不要去设置Content-Type请求头
                                    contentType : false,
                                    dataType : 'JSON',
                                    success : function(responseStr) {
                                        var src = responseStr.url;
                                        var imgTag = "<img src='"+src+"' border='0'/>";
                                        self.html(imgTag);
                                    },
                                    error : function(responseStr) {
                                        reader = new FileReader();
                                        reader.onload = function( e ){
                                            var img = new Image();
                                            var imgTag = "<img src='"+e.target.result+"' border='0'/>";
                                            self.html(imgTag);
                                        };
                                        reader.readAsDataURL( file );
                                    }
                                });
                            }
                        }
                   }catch (e){};
                });


                try {
                    // 拖拽上传
                    $(".sevice").get(0).addEventListener('dragover', function (e) {
                        e.preventDefault(); // 必须阻止默认事件
                    }, false);

                    $(".sevice").get(0).addEventListener('drop', dropFn, false);
                    editerDoc.addEventListener('drop', dropFn, false);

                    function dropFn(e){
                        e.preventDefault(); // 阻止默认事件
                        var file = e.dataTransfer.files[0]; //获取文件
                        if(file.type.split("/")[0]!='image') return;
                        var formData = new FormData();
                        formData.append("userupload",file);//name,value
                        //用jquery Ajax 上传二进制数据


                        $.ajax({
                            url : http_pro+host+'/upload_img_file.php?company_id='+company_id,
                            type : 'POST',
                            data : formData,
                            // 告诉jQuery不要去处理发送的数据
                            processData : false,
                            // 告诉jQuery不要去设置Content-Type请求头
                            contentType : false,
                            dataType : 'JSON',
                            success : function(responseStr) {
                                var src = responseStr.url;
                                var imgTag = "<img src='"+src+"' border='0'/>";
                                self.insertHtml(imgTag);
                            },
                            error : function(responseStr) {
                                reader = new FileReader();
                                reader.onload = function( e ){
                                    var img = new Image();
                                    var imgTag = "<img src='"+e.target.result+"' border='0'/>";
                                    self.insertHtml(imgTag);
                                };
                                reader.readAsDataURL( file );
                            },
                            complete : function(){
                            }
                        });
                    }
                }catch (e){};
            },
            afterChange:(function(){
                var str = "";
                return function(){
                    if(!this.isEmpty()){
                        $(".please_input").hide();
                        $(".submit-btn-wrap").removeClass("disabled");
                        if(this.html().length != str.length){
                            str = this.html();
                            showRobotProblem();
                        }
                    }else{
                        if(navigator.userAgent.indexOf("Edge") > -1){
                            $(".please_input").hide();
                            $(".submit-btn-wrap").removeClass("disabled");
                        }else{
                            $(".please_input").show();
                            $(".submit-btn-wrap").addClass("disabled");
                        }
                    }
                    if (g_comm_success && guidance_type == 2) {
                        zn_order();
                    }
                }
            })()
        });

    });


$(function(){
   // 图片预览==============================start=============================
    $(".talk").on("click",".upload-wrap img",function(){
        preview_img(this)
    });

    $(".talk").on("click",".pc-customer-info img",function(){
        preview_img(this)
    });

    $(".talk").on("click",".pc-service-info img",function(){
        preview_img(this)
    });
    function preview_img(obj){
        $(".img_bgmask").find(".view_img_wrap").css("width","100%");
        $(".img_bgmask").find("img").attr("src",$(obj).attr("src"));
        $(".img_bgmask").find("img").on("load",function(){
            $(".img_bgmask").show();
            $(".img_bgmask").find(".view_img_wrap").css({"margin-left":-($(".img_bgmask").find(".view_img_wrap").width()/2)+"px","margin-top":-($(".img_bgmask").find(".view_img_wrap").height()/2)+"px","left":"50%","top":"50%"});
        })
    }

    $("body").on("click",".close_bgmask",function(){
        $(".img_bgmask").hide();
        oX = $(".img_bgmask").width()/2,
        oY = $(".img_bgmask").height()/2;
    });

    // 滚轮缩放图片
    var addEvent = (function(window, undefined) {
        var _eventCompat = function(event) {
            var type = event.type;
            if (type == 'DOMMouseScroll' || type == 'mousewheel') {
                event.delta = (event.wheelDelta) ? event.wheelDelta / 120 : -(event.detail || 0) / 3;
            }
            //alert(event.delta);
            if (event.srcElement && !event.target) {
                event.target = event.srcElement;
            }
            if (!event.preventDefault && event.returnValue !== undefined) {
                event.preventDefault = function() {
                    event.returnValue = false;
                };
            }

            return event;
        };
        if (window.addEventListener) {
            return function(el, type, fn, capture) {
                if (type === "mousewheel" && document.mozFullScreen !== undefined) {
                    type = "DOMMouseScroll";
                }
                el.addEventListener(type, function(event) {
                    fn.call(this, _eventCompat(event));
                }, capture || false);
            }
        } else if (window.attachEvent) {
            return function(el, type, fn, capture) {
                el.attachEvent("on" + type, function(event) {
                    event = event || window.event;
                    fn.call(el, _eventCompat(event));
                });
            }
        }
        return function() {};
    })(window);

    addEvent(document.querySelector(".img_bgmask"), "mousewheel", function(event) {
        if (event.delta > 0) {
             $(".img_bgmask .view_img_wrap").css("width",($(".img_bgmask .view_img_wrap").width()+20)+"px");

        }else {
            $(".img_bgmask .view_img_wrap").css("width",($(".img_bgmask .view_img_wrap").width()-20)+"px");
        }
        $(".img_bgmask").find(".view_img_wrap").css({"margin-left":-($(".img_bgmask").find(".view_img_wrap").width()/2),"margin-top":-($(".img_bgmask").find(".view_img_wrap").height()/2)});
    });


    //图片拖动
    var oX = $(".img_bgmask").width()/2,
        oY = $(".img_bgmask").height()/2;

    $(".img_bgmask").on("mousedown",'.view_img_wrap',function(e){
        var obj = $(this),
            onOff = true,
            startX = e.pageX,
            startY = e.pageY,
            moveX,
            moveY;
        $(document).on("mousemove.drag",function(ev){

            // var ev = ev || window.event;
            // if(ev.preventDefault)ev.preventDefault();
            // else ev.returnvalue=false;

            onOff=false;
            moveX = ev.pageX-startX+oX;
            moveY = ev.pageY-startY+oY;
            obj.css({"left":moveX+"px","top":moveY+"px"});
            return false;
        });
        $(document).on("mouseup.drag",function(e){
            if(onOff) return false;
            oX = moveX;
            oY = moveY;
            $(document).off(".drag");
        })
    })

   // 图片预览==============================end=============================




// 关闭窗口========================================start=======================================

$(".leaveMsg-suc").on('click','.close-suc-btn',close_ly_window);

// 关闭窗口========================================end=======================================




// 检测是否支持svg 如果不支持，让地步的icon切换成png格式；

    if (typeof SVGRect == "undefined") {
        $('.svgWrap').remove();
        $(".imgWrap").show();
    }else {
        $('.svgWrap').show();
        $(".imgWrap").remove();
    }



    // 咨询============================start=====================================

    // 咨询填写失去焦点与获取焦点


    function ly_addEvent(obj){
        $(obj).on("focus",'.must',function(){
            $(this).removeClass("message-error").prev().find("a").removeClass("error-alert");
        });
        $(obj).on("input",'input',function(){
            $(this).removeClass("message-error").prev().find("a").removeClass("error-alert");
        });
        $(obj).on("blur",'.must',check_input);

        $(obj).on('keyup','.must',function(){
            var num = 0;
            for (var i = 0; i < $(obj+" .must").length; i++) {
                if ($(obj+" .must").eq(i).val() || $.trim($(obj+" .must").eq(i).text())) {
                    num++;
                    if (num == $(obj+" .must").length) {
                        $(".message-btn").removeClass('prevent-send');
                    }else {
                        $(".message-btn").addClass('prevent-send');
                    }
                };
            }
        })
    };
    ly_addEvent(".before-talk");
    ly_addEvent(".leave-message");

    // 咨询填写失去焦点与获取焦点====================end==================================




    // 咨询enter键 建立连接=================================start===================================

    $(".before-talk").on('keydown','input',function(e){
        var key = e.keyCode || e.which;
        if(key == 13){
            $(".before-talk").find(".message-btn").trigger("click");
        }
    })

    // 咨询enter键 建立连接================================end=======================================






    // 选择客服================================start===========================================
    // 分配部分点击下拉
    $(".select-customer").on("click", ">div>p", function() {
            if ($(this).next("div").find("a").length > 0) {
                if ($(this).next("div").is(":hidden")) {
                    $(this).addClass("slide-down");
                    $(this).next("div").slideDown(200);
                } else {
                    $(this).removeClass("slide-down");
                    $(this).next("div").slideUp(200);
                }
            }
        });
    // 选择客服==================================end========================================




    // 留言 ===================================start===================================

    $(".leave-message").on("click",".lword-object",function(e){

        // $(this).parent().find("ul").slideToggle(100);
        $(".lword-object-lists").slideToggle(100);
        e.stopPropagation();
    });
    $(".leave-message").on("click",".lword-object-lists li",function(e){
        if($(".lword-object-wrap").hasClass("is_appoint_group")){

            $(this).parents(".lword-object-wrap").find(".lword-object-lists").slideToggle(100);
            $(this).parents(".lword-object-wrap").find(".lword-object").text($(this).text()).removeClass("color-grey-light");
        }else {
            $(".lword-object-lists li").find("ul").hide();
            $(this).find("ul").show();
        };

        e.stopPropagation();
    });
    $(".leave-message").on('click','.person-lists li',function(){

        $(this).parents(".lword-object-wrap").find("p.lword-object").text($(this).parents('.person-lists').attr('data-text')+'/'+$(this).text()).removeClass("color-grey-light");

        $(".leave-message").find(".lword-object-wrap ul").slideUp(100);

    })

    // 留言 ====================================end================================




    // 工具栏===============================start====================================

    // 获得焦点时 移除手机号码input上面的红色边框
    $(".net_callBack_input").focus(function(){
        $(".net_callBack_input").removeClass("error");
    })

    // 加载表情
    var is_onload_face = false;
    function onload_face(){
        if (is_onload_face) return;
        is_onload_face = true;
        var faceArr = ['[拜拜]','[鄙视]','[打电话]','[打哈欠]','[大哭]',
                    '[大笑]','[得意]','[点赞]','[愤怒]','[鼓掌]',
                    '[嘿哈]','[滑稽]','[欢迎]','[奸笑]','[沮丧]',
                    '[开心]','[可伶]','[流汗]','[卖萌]','[破涕为笑]',
                    '[敲打]','[胜利]','[调皮]','[无语]','[捏脸]',
                    '[抱抱]','[摊手]','[比心]','[便便]','[加油]',
                    '[礼物]','[哈士奇]','[成交]','[心碎]','[月亮]'];
        var imgHtml="";
        for (var i = 1; i < 36; i++) {
            imgHtml += "<p><img title='"+faceArr[i-1]+"' src='img/face/53c_min/53c_" + i + ".gif?8'/></p>";
        }
        $(".face-lists").append(imgHtml);

        // 给表情图片绑定点击事件
        $(".face-lists>p>img").click(function() {
            $(".face-lists").toggle();
            // 清空与获得焦点解决火狐br标签与ie8的br问题
            $(".submit-btn-wrap").removeClass("disabled");
            kindeditor.insertHtml("<img style='width:32px;height:32px;' src='"+this.src+"' />");
            kindeditor.focus();
        });
    }

    // 点击热点问题
    $(".function-bar").on("click",".icon-hot",function(){
        //排队的时候 该功能不可用
        if($(".line-up").css("display")=='block') return;
        quickQA(this);

    });
    // 点击下载
    $(".function-bar").on("click",".download",function(){

        $(".service-help").removeClass("active").slideUp(100);
        $(".icon-hot").parent().removeClass("active");
        $(".face-lists").removeClass("active").slideUp(100);
        $(".changeColor-wrap").removeClass("active");
        $(".cutbox").removeClass("active").slideUp(100);
        $(".cutbox_mac").removeClass("active").slideUp(100);
        $(".icon-cut").parent().removeClass("active");
        // 排队的时候 该功能不可用
        if($(".line-up").css("display")=='block') return;
        saveas();
    });
    // 点击评价
    $(".function-bar").on("click",".function-icon-eval",function(){

        $(".service-help").removeClass("active").slideUp(100);
        $(".icon-hot").parent().removeClass("active");
        $(".face-lists").removeClass("active").slideUp(100);
        $(".changeColor-wrap").removeClass("active");
        $(".cutbox").removeClass("active").slideUp(100);
        $(".cutbox_mac").removeClass("active").slideUp(100);
        $(".icon-cut").parent().removeClass("active");
        // 排队的时候 该功能不可用
        if($(".line-up").css("display")=='block') return;
        vote_open();
    });


    // 点击笑脸图标打开表情包

    $(".function-bar").on('click',".icon-face",function(event){
        onload_face();//加载表情
        $(".service-help").removeClass("active").slideUp(100);
        $(".icon-hot").parent().removeClass("active");
        $(".changeColor-wrap").removeClass("active");
        $(".cutbox").removeClass("active").slideUp(100);
        $(".cutbox_mac").removeClass("active").slideUp(100);
        $(".icon-cut").parent().removeClass("active");

        if($(".face-lists").hasClass("active")){
            $(".face-lists").removeClass("active");
            $(".face-lists").slideUp(100);
            $(this).parent().removeClass("active");
        }else {
            $(".face-lists").addClass("active");
            $(".face-lists").slideDown(100);
            $(this).parent().addClass("active");
        };
    });
    //点击截图 打开截图功能表
    $(".function-bar").on("click",".icon-cut",function(e){
        if($(".line-up").css("display")=='block'){
            return false;
        };
        $(".service-help").removeClass("active").slideUp(100);
        $(".icon-hot").parent().removeClass("active");
        $(".face-lists").removeClass("active").slideUp(100);
        $(".changeColor-wrap").removeClass("active");
        if(check_os == "Mac"){
        	if($(".cutbox_mac").hasClass("active")){
        		$(".cutbox_mac").removeClass("active").slideUp(100);
                $(this).parent().removeClass("active");
        	}else{
        		$(".cutbox_mac").addClass("active").slideDown(100);
        		$(this).parent().addClass("active");
        	}
        }else if(check_os == "Windows"){
	        if (check_browser == 'IE' || check_browser == 'Chrome') {
	            if($(".cutbox").hasClass("active")){
	                $(".cutbox").removeClass("active").slideUp(100);
	                $(this).parent().removeClass("active");
	            }else {
	                $(".cutbox").addClass("active").slideDown(100);
	                $(this).parent().addClass("active");
	            }
	        }else{
	            insert_snapshot3("www16.53kf.com","6356271");
	        }
        }
    })
    // 点击热点问题icon 打开更多问题
    $(".function-bar").on('click',".icon-hot",function(event){
        if($(".line-up").css("display")=='block'){
            return false;
        };

        $(".face-lists").removeClass("active").slideUp(100);
        $(".changeColor-wrap").removeClass("active");
        $(".cutbox").removeClass("active").slideUp(100);
        $(".cutbox_mac").removeClass("active").slideUp(100);
        $(".icon-cut").parent().removeClass("active");

        if($(".service-help").hasClass("active")){
            $(".service-help").removeClass("active").slideUp(100);
            $(this).parent().removeClass("active");
        }else {
            $(".service-help").addClass("active").slideDown(100);
            $(this).parent().addClass("active");
        }

    });

    //截图功能
    $(".cutbox").on("click","p",function(){
        if($(".cutbox").hasClass("active")){
            $(".cutbox").removeClass("active").hide();
            $(".icon-cut").parent().removeClass("active");
        }else {
            $(".cutbox").addClass("active").slideDown(100);
            $(".icon-cut").parent().addClass("active");
        }
        if($(this).index()==0){
            insert_snapshot3("www16.53kf.com","6356271");
        }else{
            insert_snapshot3("www16.53kf.com","6356271","hide");
        }
    })



    // 鼠标移入之后 图标上面显示提示文字
    var iconTimer = null;
    $(".function-bar").on("mouseenter", ".function-icon", function() {

        if($(".line-up").css("display")=='block' && $(this).parents("label.changeColor-wrap").length<=0 || $(this).parent().hasClass("disabled")){
            return false;
        };

        var that = this;
        iconTimer = setTimeout(function(){
            var text = $(that).attr("data-title");
            var clientX = $(that).offset().left-88-$(".function-bar").offset().left;
            $(".footer-text span").text(text);
            $(".footer-text").css("left", clientX + "px");

            // 解决IE11上传图标渲染异常BUG
            $(".footer-text").css("z-index","15");

        },500)
    });
    $(".function-bar").on("mouseleave", ".function-icon", function() {
        clearTimeout(iconTimer);
        $(".footer-text").css("z-index","-1");
    });



    // 还原功能条所有状态
    function functionBar_return() {
        $(".face-lists").removeClass("active");
        $(".service-help").removeClass("active");
        $(".icon-hot").parent().removeClass("active");
        //$(".svgColor").attr("fill",'#8FA1B3');
        $(".cutbox").removeClass("active").slideUp(100);
        $(".cutbox_mac").removeClass("active").slideUp(100);
        $(".icon-cut").parent().removeClass("active");
        $(".changeColor-wrap").removeClass("active");
        $(".toggleHidden").slideUp(100);
    };
    function lword_return(){
        $(".lword-object-wrap").find("ul").slideUp(100);
    }
    $(document).on("click",function(event){
        var obj = event.srcElement ? event.srcElement:event.target;
        if($(".talk").css("display")=='block' && (obj.tagName!="svg" && obj.tagName!="path" && obj.tagName!="SPAN")){
            functionBar_return();
        };
        if($(".leave-message").css("display")=='block'){
            lword_return();
        }
    });

    // 工具栏===============================end====================================




    //评价=================================start=====================================

    // 点击星星选择
    $(".pc-visitor-main").on("click", ".evaluation ul li", function() {
        $(this).parent().addClass("used");
        var index = $(this).index();
        // 循环 通过当前的星星序列号来变化
        $(this).parent().children("li").each(function() {
            if ($(this).index() <= index) {
                $(this).addClass("li-active");
            } else {
                $(this).removeClass("li-active");
            }
        });

        $(this).parents('.evaluation').find('label').text(voteArr[index])

    });

    //在星星上移动，星星颜色变化；
     $(".pc-visitor-main").on("mouseenter", ".evaluation ul li",function(){
        if($(this).parent().hasClass("used")){return false;}
        var index = $(this).index();
        // 循环 通过当前的星星序列号来变化
        $(this).parent().children("li").each(function() {
            if ($(this).index() <= index) {
                $(this).addClass("li-active");
            } else {
                $(this).removeClass("li-active");
            }
        });

        $(this).parents('.evaluation').find('label').text(voteArr[index])

    });
    //鼠标移出，星星变回原五星
    $(".pc-visitor-main").on("mouseleave", ".evaluation ul",function(){
        if($(this).hasClass("used")){return false;}
        $(this).children("li").addClass("li-active");
        $(this).parents('.evaluation').find('label').text(voteArr[4]);
    })

    // 评价里面的发送提交被点击后
    $(".pc-visitor-main").on("click", ".evaluation-btn", function() {
        save_vote();
        $(this).parent().remove();

    });

    //评价==============================start================================









// 发送消息 ==============================start==============================================


    // 请输入 ================start ===================
    $(".please_input").click(function(){
        $(this).hide();
        kindeditor.focus();
    })

    // um.addListener('focus', function() {
    //     $(".please_input").hide();
    // });
    $("body").on("click",".inputArea",function(){
        $(".please_input").hide();
    });
    // um.addListener('contentChange', function() {
    //     $(".please_input").hide();
    // });

    $(".talk").on("click",function(e){
        if($(e.target).parents(".inputArea").length<=0 && kindeditor.isEmpty()){
            $(".please_input").show();
        }
    });


    // 请输入 ================ end ===================


    $(".pc-visitor-footer").on("click",".submit-btn-wrap",function(){
        sendmsg();
        $(".submit-btn-wrap").addClass("disabled");
        kindeditor.focus();
    });




// 发送消息 =============================end==================================================



// 右边 ========================================start======================================================

    //轮播切换
    var timer = null;
    var imgLength = $(".dot").length;
    imgAnimate(imgLength,0);
    function imgAnimate(LENGTH,index){
        clearInterval(timer);
        if(LENGTH==0){
            $(".js_hide_guanggao").hide();
            //$(".content-right-mid-wrap").css("padding-bottom","0");
            return false;
        }
        if(LENGTH<=1){
            $(".guanggao-bottom").hide();
            return false;
        };
        var LEFT = -index*220;
        var LENGTH=LENGTH;
        var index = index;
        timer = setInterval(function(){
            LEFT-=220;
            index++;
            if(LEFT<=-(LENGTH+1)*220){
                $(".guanggao-wrap").css("left",0);
                LEFT=-220;
            }
            if(index==LENGTH){
                index=0;
            };
            $(".guanggao-wrap").animate({left:LEFT+"px"},500);
            $(".dotWrap").find("i").eq(index).addClass("active").animate({"width":"14px"},220).siblings().removeClass("active").animate({"width":"7px"},220);
        },3000)
    };

    // 小圆点点击事件
    $(".dotWrap").on('click','i',function(){
        clearInterval(timer);
        var index = $(this).index();
        $(".guanggao-wrap").css("left",-220*index);
        $(".dotWrap").find("i").eq(index).addClass("active").animate({"width":"14px"},220).siblings().removeClass("active").animate({"width":"7px"},220);
        imgAnimate($(".dot").length,index);

    });


    // 切换公司简介跟客服简介
    $(".content-right-top").on("click",'div',function(){
        $(this).addClass("active").siblings().removeClass("active");
        $(".content-right-mid>div").eq($(this).index()).show().siblings().hide();
    });
})

//显示客服名片信息
function showWorkerCard(data){
    if (data['fk_header_url'] != '') {
        kf_header = data['fk_header_url'];
        $(".pc-talk .pc-service-left>img").attr('src',kf_header);
    }
    // if (kf_card == 1) {
    //     for(var x in data){
    //         if (x == 'fk_header_url') {
    //             if(data[x] != '') $("#kf_header").attr('src',data[x]);
    //         }else if(x == 'bname' && data[x] == ''){
    //             $("#tab_card_"+x).text(infos[45]);//客服
    //         }else if(x == 'intro_pc'){
    //             if (data[x] != '') {
    //                 var reg = new RegExp("<[^<]*>", "gi");// 去除标签的正则表达式
    //                 $("#tab_card_"+x).text(data[x].replace(reg, ""));
    //             }else{
    //                 $("#tab_card_"+x).parent().hide();
    //             }
    //         }else if (data[x] != '') {
    //             $("#tab_card_"+x).text(data[x]);
    //         }else{
    //             $("#tab_card_"+x).parent().hide();
    //         }
    //     }
    //     $(".window-content").addClass('on-talking');//显示客服名片
    // }
}

//显示对话框自定义格式的内容
function display_talk_msg(msg){
    $(".pc-talk").append(msg);
    basic.scrollPage();
}

//显示机器人对话框内容
function display_robot_msg(msg,type){
    var show_msg = msg;
    var msg_time = getTime2();
    if (type == 'me') {//访客消息
        show_msg = '<div class="pc-customer"><p><label>'+infos[49]+'</label><span>'+msg_time+'</span></p><div class="pc-customer-info" style="background-color:'+minicolor_fkqp+';"><div class="textWrap" style="color:'+minicolor_fkxx+';">'+msg+'</div><i></i></div></div>';
    }else if (type == 'wait') {//系统提示：人工客服接入中...
        show_msg = '<p class="system-remind system-wait"><label>'+infos[74]+'</label></p>';
    }else if (type == 'no_kf') {//由于当前人工客服不在线，你可以选择 给我们留言
        show_msg = '<p class="system-remind"><label>'+infos[75]+'<a class="color-blue" style="cursor:pointer;"onclick="getWlist(1)">'+infos[10]+'</a></label></p>';
    }
    $(".pc-robot").append(show_msg);
    if (robot_cannot_answer_times == 2) {//机器人超过两次无法回答访客的问题，给予系统提示
        if (lword_type == '2') {
            var sys_msg = '<p class="system-remind"><label>'+infos[7]+'<a class="color-blue" style="cursor:pointer;" onclick="robotToTalk();">'+infos[8]+'</a></label></p>';
        }else{
            var sys_msg = '<p class="system-remind"><label>'+infos[7]+'<a class="color-blue" style="cursor:pointer;" onclick="robotToTalk();">'+infos[8]+'</a>'+infos[9]+'<a class="color-blue" style="cursor:pointer;"onclick="getWlist(1)">'+infos[10]+'</a></label></p>';
        }
        $(".pc-robot").append(sys_msg);
        robot_cannot_answer_times = 0;
    }
    basic.scrollPage_robot();

}

//显示机器人答案
function answer_dialog(q_id, answer, rela_ques){
    var msg_time = getTime2();
    if(q_id != '0'){
        var html = '';
        if(rela_ques != ''){
            html += '<div class="question-lists"><p>'+infos[34]+'</p><ul class="questions">';//相关问题：
            for(var i=0;i<rela_ques.length;i++){
                if(is_huawei_robot == 1)
                    html += '<li onmouseup="this.style.color=\'#62778C\'" onclick="robot_main(\''+rela_ques[i].question+'\')">'+rela_ques[i].question+'</li>';
                else
                    html += '<li onmouseup="this.style.color=\'#62778C\'" onclick="show_robot_dialog(\''+rela_ques[i].id+'\', \''+rela_ques[i].question+'\',\''+rela_ques[i].answer+'\')">'+rela_ques[i].question+'</li>';
            }
            html += '</ul></div>';
        }

        var msg = '<div class="pc-service"><div class="pc-service-left" style="display: inline-block;"><img src="'+zsk_zsktb_url+'" alt="'+infos[11]+'"></div><div class="pc-service-right"><p><label>'+zsk_name+'</label><span>'+msg_time+'</span></p><div class="pc-service-info pc-robot-info"><div class="pc-robot-answer" id="'+q_id+'" style="overflow-x:auto;">'+answer+'</div><div class="pc-robot-eval"><p class="user-unuser"><a class="user answer_helpful buttonType2" data-value="4">'+infos[35]+'</a><a class="unuser buttonType2">'+infos[36]+'</a></p><div class="df"><p>'+infos[37]+'</p><ul><li data-value="0">'+infos[38]+'</li><li data-value="1">'+infos[39]+'</li><li data-value="2">'+infos[40]+'</li><li class="otherOption" data-value="3">'+infos[41]+'</li></ul><div class="triangleUp"></div></div></div>'+html+'</div></div></div>';

    }else{
        var msg = '<div class="pc-service"><div class="pc-service-left" style="display: inline-block;"><img src="'+zsk_zsktb_url+'" alt="'+infos[11]+'"></div><div class="pc-service-right" ><p><label>'+zsk_name+'</label><span>'+msg_time+'</span></p><div class="pc-service-info"><div style="overflow-x:auto;">'+answer+'</div></div></div></div>';

        robot_cannot_answer_times += 1;
    }
    display_robot_msg(msg,'robot');
}

//显示客服消息
function display_kf_msg(msg,talkname,style,msg_time){
    if (talkname == undefined) talkname = obj_name;
    if (talkname == '') talkname = infos[45];//客服
    if (style == undefined) style = "color:"+minicolor_kfxx+";background-color:"+minicolor_kfqp+";";
    if (msg_time == undefined) msg_time = getTime2();
    var qrcode_str = '';
    if (qrcode_url != '') {//80 微信扫码&nbsp;咨询同步
        qrcode_str = '<span class="qr_code_53kf"><span class="qr_box_53kf"><span class="qr_img_53kf"><img src="'+qrcode_url+'" alt=""></span><em>'+infos[80]+'</em></span></span>';
    }
    var show_msg = '<div class="pc-service"><div class="pc-service-left" style="display: inline-block;"><img src="'+kf_header+'" alt="'+infos[11]+'"></div><div class="pc-service-right" ><p><label>'+talkname+'</label><span>'+msg_time+'</span>'+qrcode_str+'</p><div class="pc-service-info" style="'+style+'"><div style="overflow-x:auto;">'+msg+'</div></div></div></div>';
    $(".pc-talk").append(show_msg);
    //处理二维码的hover
    if (qrcode_url != '') {
        $(".pc-service-right").on("mouseover",".qr_code_53kf",function(){
            $(this).find(".qr_box_53kf").css("display","block")
            var offsetTop = $(this).offset().top;
            var $insertEm = $(this).find(".qr_box_53kf em"),$insertImg = $(this).find(".qr_img_53kf");
            if(offsetTop<119){
                $(this).find(".qr_box_53kf").css("bottom","-126px");
                $insertImg.insertAfter($insertEm);
                // $insertImg.css("margin-top","5px");
                $insertEm.css("margin-top","5px");
            }else{
                $(this).find(".qr_box_53kf").css("bottom","21px");
                $insertEm.insertAfter($insertImg);
                $insertImg.css("margin-top",0);
                $insertEm.css("margin-top",0);
            }
        })
        $(".pc-service-right").on("mouseout",".qr_code_53kf",function(){
            $(this).find(".qr_box_53kf").css("display","none")
        })
    }
    basic.scrollPage();
}

//显示访客消息
function display_fk_msg(msg,fk_msgid,msg_time){
    if (fk_msgid == undefined) {
        var fk_msgid_str = '';
    }else{
        var fk_msgid_str = ' id="'+fk_msgid+'" class="info-status"';
    }
    if (msg_time == undefined) msg_time = getTime2();
    var show_msg = '<div class="pc-customer"><p><label>'+infos[49]+'</label><span>'+msg_time+'</span></p><div class="pc-customer-info" style="background-color:'+minicolor_fkqp+';"><div class="textWrap" style="color:'+minicolor_fkxx+';">'+msg+'</div><i'+fk_msgid_str+'></i></div></div>';
    $(".pc-talk").append(show_msg);
    basic.scrollPage();
    if (fk_msgid_str != '') {
        try{
            m_qstResTimer[fk_msgid] = setTimeout(function(){
                $("#"+fk_msgid).addClass("onError");
            },20000);
        }catch(e){}

    }
}

//显示系统消息
function display_sys_msg(msg,alter){
    try{
        if(alter==1){
            $('.onlyone').remove();
            var show_msg = '<p class="system-remind onlyone"><label>'+msg+'</label></p>';
        }else{
            var show_msg = '<p class="system-remind"><label>'+msg+'</label></p>';
        }
        $(".pc-talk").append(show_msg);
        basic.scrollPage();
    }catch(e){}
}

//显示图文公告信息
function diaplay_cinfo_msg(msg){
    $(".pc-talk").append(msg);
    basic.scrollPage();
}

//显示收到文件消息
function display_fil_msg(name,url,sid,jid6d,type,file_cancel_id,size){//44 未知  68 下载  14 上传成功
    
    if(company_id==72177773) {
        var autoplay="autoplay='autoplay'";
    }else {
        var autoplay="";
    }
    if (file_cancel_id != undefined && file_cancel_id != '') {
        file_cancel_id = 'id="'+file_cancel_id+'"';
    }else{
        file_cancel_id = '';
    }
    if (size != undefined && size != '') {
        size = size>1024? Math.floor(size/1024)>1024? Math.floor(size/1024/1024)+"M":Math.floor(size/1024)+"KB":Math.floor(size)+"B";
    }else{
        size = infos[44];
    }
    if (sid == obj_id || sid == jid6d) {//收到客服发送
        if(type=='video' && !(!!window.ActiveXObject&&document.documentMode==8)){
            var msg = '<div class="pc-service"><div class="pc-service-left" style="display: inline-block;"><img src="'+kf_header+'" alt="'+infos[11]+'"></div><div class="pc-service-right" ><div class="upload-wrap kf-uploadFile" >'+'<div class="upload-file fl" style="width:260px;">'+'<video class="upload-video" '+autoplay+'  style="background-color:black;width:240px;height:180px;" src="'+url+'" controls="controls">抱歉，你的浏览器不支持视频播放</video></div>'+                        '</div>'+'</div></div></div>';
        }else if(type=='audio' && !(!!window.ActiveXObject&&document.documentMode==8)){
            var msg = '<div class="pc-service"><div class="pc-service-left" style="display: inline-block;"><img src="'+kf_header+'" alt="'+infos[11]+'"></div><div class="pc-service-right" ><div class="upload-wrap kf-uploadFile" style="width:262px;">'+'<div class="upload-file fl" style="width:262px;">'+'<audio class="upload-audio" '+autoplay+'  style="background-color:white;width:250px;height:55px;margin-left:-5px;" src="'+url+'" controls="controls">抱歉，你的浏览器不支持音频播放</audio></div>'+'</div>'+'</div></div></div>';
        }else{
            var msg = '<div class="pc-service file_cancel" '+file_cancel_id+'><div class="pc-service-left" style="display: inline-block;"><img src="'+kf_header+'" alt="'+infos[11]+'"></div><div class="pc-service-right" ><div class="upload-wrap kf-uploadFile">'+
                '<div class="upload-file fl">'+
                    '<p class="file-header">'+
                        '<span class="fileName">'+basic.beforeRender(name)+'</span>'+
                        '<span class="fileSize fr">'+size+'</span>'+
                    '</p>'+
                    '<div class="uploadStatus color-blue fr"><a href="'+url+'" target="_blank">'+infos[68]+'</a></div>'+
                    '<div class="statusIcon"></div>'+
                '</div>'+
            '</div></div></div>';
        }
    }else{//收到访客发送 
        if(type=='video' && !(!!window.ActiveXObject&&document.documentMode==8)){
            var msg = '<div class="pc-customer"><div class="pc-customer-info" style="background-color:'+minicolor_fkqp+';"><div class="textWrap" style="color:'+minicolor_fkxx+';"><video class="upload-video"'+autoplay+'  style="background-color:black;width:240px;height:180px;" controls="controls" src='+url+'></video></div></div></div>';
        }else if(type=='audio' && !(!!window.ActiveXObject&&document.documentMode==8)){
            var msg = '<div class="pc-customer"><div class="pc-customer-info" style="width:262px;"><div class="textWrap" style="color:white;width:262px;"><audio class="upload-audio"'+autoplay+' style="width:250px;height:55px;margin-left:-2px;" controls="controls" src='+url+'></audio></div></div></div>';
        }else{
            var msg = '<div class="upload-wrap kf-uploadFile">'+
                '<div class="upload-file fr">'+
                    '<p class="file-header">'+
                        '<span class="fileName">'+basic.beforeRender(name)+'</span>'+
                        '<span class="fileSize fr">'+size+'</span>'+
                    '</p>'+
                    '<div class="uploadStatus color-blue fr"><a href="'+url+'" target="_blank">'+infos[68]+'</a></div>'+
                    '<div class="statusIcon"></div>'+
                '</div>'+
            '</div>';
        }
    }
    display_talk_msg(msg);
}

//显示上次聊天记录
function showLastMsg(msg,type,time){
    var show_msg = '';

    if (type == 'w') {
        var style = "color:"+minicolor_kfxx+";background-color:"+minicolor_kfqp+";";
        show_msg = '<div class="pc-service"><div class="pc-service-left" style="display: inline-block;"><img src="'+kf_header+'" alt="'+infos[11]+'"></div><div class="pc-service-right" ><p><label>'+obj_name+'</label><span>'+time+'</span></p><div class="pc-service-info" style="'+style+'"><div style="overflow-x:auto;">'+msg+'</div></div></div></div>';
    }else if (type == 'v') {
        show_msg = '<div class="pc-customer"><p><label>'+infos[49]+'</label><span>'+time+'</span></p><div class="pc-customer-info" style="background-color:'+minicolor_fkqp+';"><div class="textWrap" style="color:'+minicolor_fkxx+';">'+msg+'</div><i></i></div></div>';
    }
    $(".pc-talk").html(show_msg+$(".pc-talk").html());
}


</script>

</body>
<script type="text/javascript">
var conn_prompt_num = 0;
var is_first_talk = 1;
try{
    //var http_pro = (document.location.protocol == 'https:')?'https://':'http://';//区分HTTP和HTTPS
    var infos = {"0":"\u8bf7\u8f93\u5165\u6709\u6548\u7684","1":"\u624b\u673a","2":"\u7559\u8a00\u5185\u5bb9","3":"\u4e0d\u80fd\u4e3a\u7a7a","4":"\u53d1\u9001\u5e76\u54a8\u8be2","5":"\u5fc5\u586b","6":"\u63d0\u4ea4\u7559\u8a00","7":"\u5f88\u62b1\u6b49\u6211\u4eec\u7684\u673a\u5668\u4eba\u65e0\u6cd5\u56de\u7b54\u60a8\u7684\u95ee\u9898\uff0c\u4f60\u53ef\u4ee5\u9009\u62e9","8":"\u4eba\u5de5\u54a8\u8be2","9":"\u6216","10":"\u7ed9\u6211\u4eec\u7559\u8a00","11":"\u5934\u50cf","12":"\u5f53\u524d\u5ba2\u670d\u7e41\u5fd9\uff0c\u4f60\u53ef\u4ee5\u9009\u62e9","13":"\u673a\u5668\u4eba\u54a8\u8be2","14":"\u4e0a\u4f20\u6210\u529f","15":"\u8bf7\u60a8\u4e3a\u6211\u7684\u670d\u52a1\u8bc4\u5206\uff1a","16":"\u6ee1\u610f","17":"\u53d1\u9001\u63d0\u4ea4","18":"\u611f\u8c22\u60a8\u7684\u8bc4\u4ef7\uff0c\u6211\u4eec\u4f1a\u7ee7\u7eed\u52aa\u529b!","19":"\u7559\u8a00","20":"\u5168\u90e8\u5ba2\u670d","21":"\u5168\u90e8\u90e8\u95e8","22":"\u79bb\u7ebf","23":"\u5728\u7ebf","24":"\u4f4d\u5ba2\u670d\u5728\u7ebf","25":"\u672a\u5206\u914d\u90e8\u95e8","26":"\u5168\u90e8\u5206\u7ec4","27":"\u667a\u80fd\u673a\u5668\u4eba\uff08\u81ea\u52a9\u7b54\u7591\uff09","28":"\u7559\u8a00\u5bf9\u8c61","29":"\u8bf7\u9009\u62e9\u7559\u8a00\u5bf9\u8c61","30":"","31":"\u63d0\u4ea4\u5931\u8d25\uff0c\u8bf7\u68c0\u67e5\u7f51\u7edc\u8fde\u63a5","32":"\u6392\u961f","33":"\u7e41\u5fd9","34":"\u76f8\u5173\u95ee\u9898\uff1a","35":"\u6709\u7528","36":"\u65e0\u7528","37":"\u8ba9\u60a8\u89c9\u5f97\u6ca1\u7528\u7684\u539f\u56e0\uff1a","38":"\u7b80\u5355","39":"\u590d\u6742","40":"\u65e0\u5173","41":"\u5176\u4ed6","42":"\u6b22\u8fce\u60a8\u7684\u54a8\u8be2\uff0c\u671f\u5f85\u4e3a\u60a8\u670d\u52a1!","44":"\u672a\u77e5","45":"\u5ba2\u670d","46":"\u53c2\u6570\u9519\u8bef\uff01","47":"\u65e0\u6548\u7684cmd\uff01","48":"\u65e0\u70ed\u95e8\u95ee\u9898","49":"\u6211","50":"\u8bf7\u8f93\u5165\u53d1\u9001\u5185\u5bb9","51":"\u5bf9\u8bdd\u5df2\u7ed3\u675f\uff0c\u4e0d\u80fd\u53d1\u9001\u6d88\u606f\u3002","52":"\u5c1a\u672a\u4e0e\u5ba2\u670d\u5efa\u7acb\u5bf9\u8bdd\uff0c\u4e0d\u80fd\u8bc4\u5206!","53":"\u60a8\u5df2\u7ecf\u8bc4\u8fc7\u5206\uff01","54":"\u7531\u4e8e\u7f51\u7edc\u539f\u56e0\uff0c\u63d0\u4ea4\u8bc4\u5206\u5931\u8d25","55":"\u8bf7\u586b\u5199\u7559\u8a00\u5185\u5bb9\uff01","56":"\u79d2\u540e\u81ea\u52a8\u4e3a\u60a8\u5206\u914d\u5ba2\u670d\u63a5\u5f85...","57":"\u60a8\u592a\u4e45\u6ca1\u6709\u64cd\u4f5c\uff0c\u9875\u9762\u5df2\u8fc7\u671f\uff0c\u8bf7\u5728\u5237\u65b0\u540e\u91cd\u65b0\u64cd\u4f5c\uff01","58":"\u6765\u81ea\u624b\u673a\u5ba2\u670d\u7aef\uff1a<a href=\"http:\/\/www.53kf.com\" target=\"_blank\">http:\/\/www.53kf.com<\/a>","59":"\u7f51\u7edc\u8fde\u63a5\u5df2\u4fee\u590d\uff0c\u60a8\u53ef\u4ee5\u7ee7\u7eed\u53d1\u9001\u5bf9\u8bdd","60":"\u662f\u5426\u63a5\u53d7","61":"\u7684\u8bc4\u5206\u8bf7\u6c42\uff1f","62":"\u5efa\u7acb\u5bf9\u8bdd\u5931\u8d25\uff0c\u8bf7\u68c0\u67e5\u7f51\u7edc\u73af\u5883\u540e\u91cd\u8bd5","63":"\u6587\u4ef6\u53d1\u9001\u5931\u8d25\uff0c\u8bf7\u68c0\u67e5\u7f51\u7edc\u73af\u5883\u540e\u91cd\u8bd5","64":"\u672a\u5206\u7ec4","65":"\u6682\u65e0\u804a\u5929\u8bb0\u5f55","66":"\u83b7\u53d6\u6570\u636e\u5931\u8d25","67":"\u663e\u793a\u4e0a\u6b21\u804a\u5929\u8bb0\u5f55","68":"\u4e0b\u8f7d","69":"\u611f\u8c22\u4f60\u7684\u53cd\u9988","70":"\u4ee5\u4e0a\u4e3a\u5386\u53f2\u8bb0\u5f55","71":"\u53d1\u9001\u6210\u529f\uff0c\u8bf7\u7559\u610f\u4f60\u7684\u7535\u8bdd\u8fdb\u884c\u63a5\u542c","72":"\u5f53\u524d\u5ba2\u670d\u6b63\u5728\u901a\u8bdd\u4e2d\uff0c\u8bf7\u7b49\u5f85\u5ba2\u670d\u56de\u62e8","73":"\u8bf7\u8f93\u5165\u6709\u6548\u7684\u624b\u673a\u53f7\u7801!","74":"\u4eba\u5de5\u5ba2\u670d\u63a5\u5165\u4e2d...","75":"\u7531\u4e8e\u5f53\u524d\u4eba\u5de5\u5ba2\u670d\u4e0d\u5728\u7ebf\uff0c\u4f60\u53ef\u4ee5\u9009\u62e9 ","76":"\u56de\u547c\u529f\u80fd\u5df2\u5173\u95ed","77":"\u4e0e\u5ba2\u670d\u53f7\u7801\u76f8\u540c\uff0c\u8bf7\u786e\u8ba4\u540e\u91cd\u8bd5","78":"\u77ed\u65f6\u95f4\u5b58\u5728\u76f8\u540c\u7684\u547c\u53eb\uff0c\u8bf7\u52ff\u91cd\u590d\u53d1\u8d77","79":"\u5f53\u524d\u901a\u8bdd\u7e41\u5fd9\uff0c\u8bf7\u7a0d\u540e\u62e8\u6253","80":"\u5fae\u4fe1\u626b\u7801&nbsp;\u54a8\u8be2\u540c\u6b65"};//语言包
    var check_num_status = 0; //验证码是否检测通过
    var minchat_style = 1;
    var khchat_style = "0";//定制版标示，0为默认，1为华为定制
    var locate = "cn";
    var lytype = "0";
    var lyurl = "";
    var company_tpl = 'minichat2';
    var enable_talk_collection = "1";  // 通讯采集开关 1:开启 0:关闭
    var host = "www16.53kf.com";
    var base_host = "53kf.com";
    var master_host = "tb.53kf.com";
    var commond_version = "123456"; //webClient.js的版本号，上发到服务端
    
    var copartner = "";
    var username = unescape("");
    var userinfo = unescape("");
    var contact = unescape("");
    var question = unescape("");
    var talkpage = "http://localhost:9527/#/login?redirect=%2Fdashboard";
    var frompage = "http://localhost:9527/";
    var talktitle = getCookie3("talktitle_72195265");
    var land_page = "http://localhost:9527/#/dashboard";
    var guest_ip_info = "四川成都[电信]";
    var talk_type = 0;//会话类型
    var origin_type = 0;//流失标记
    var origin_time = 0;//流失时间
    var search_engine = "";
    var keyword = "";
    
    //设置相关
    var kfpf = "1";
    if (company_tpl == 'minichat2') kfpf = "1";
    var vote_true = false;
    var vote_value = "1";//默认评分
    var cname = "深圳恩颂科技";
    var isold = 0;
    var mytempid = "0";
    var myfirst_tempid = "0";
    var conn_prompt = "您好，欢迎您的咨询，请问有什么需要帮助的吗？";
    var m_conn_prompt_list = new Array(); // 所有客服接通提示
        var intelligent_guidance = "0";//智能导航开关
    var m_prompt_guide_list = new Array();//智能导航
        var prompt_cookie = getCookie3("prompt_guide_72195265");
    var prompt_guide_size = 0;//智能导航已发送条数
    var wait_host = "wait.53kf.com";//智能导航域名
    var admin_bname = "客服";//主账号昵称

    var busy_prompt = "对不起，线路繁忙，请稍候，您也可以给我们留言！";
    var close_prompt = "感谢您的咨询！谢谢，再见！";
    var m_close_prompt_list = new Array(); // 所有客服结束提示
        var lword_prompt = "您好，现在客服不在线，请留言。如果没有留下您的联系方式，客服将无法和您联系！";
    var reject_prompt = "无法连接客服，您已被阻止！";
    var close_bro_prompt = "您即将离开咨询页面，离开后不能继续与客服人员沟通，您确定离开吗？点击确定离开，点击取消继续与客服人员沟通";
    var zdkf_auto = "15";
    var worker_id = "";
            var wids = "";
        var worker_name = "";
    var zdyly_ck = "";
    var online_cnt = "0";
    var is_wlist = "0";
    
    var arg = "10195265";
    var style = "1";
    var style_id = "106262622";
    var verify_key = "a6dbf69947ca351bb327f9f5fbfc87fe";
    
    var is_fav = "1";  // 是否弹出IE收藏夹
    var zsk = "1";
    
    var m_zsk_all = new Array();                    // 所有机器人信息
            
        var re2 = new Object();
        re2.id = "2c0e8d5845b65ef5062e10d4c63ddf7c";
        re2.auto_login = "0";
        re2.state = "1";
        re2.auto_hidden = "1";
        re2.name = "恩颂小A";
        re2.robot_ly = "1";
        re2.prompt = "你好，请问我有什么可以帮到您的？";
        re2.zsktb_url = "../img/upload/10195265/robot/201902191734328171.png";
        m_zsk_all.push(re2);
    
    var m_robid = "2c0e8d5845b65ef5062e10d4c63ddf7c";                // 机器人id
    var zsk_prompt = "你好，请问我有什么可以帮到您的？";           // 机器人问候语
    var zsk_name = "恩颂小A";               // 机器人昵称
    var zsk_auto_login = "0";   // 机器人自动上线
    var zsk_state = "1";             // 机器人状态
    var zsk_auto_hidden = "1"; // 机器人客服在线时隐身
    var zsk_robot_ly = "1";       // 机器人留言链接
    var zsk_zsktb_url = "../img/upload/10195265/robot/201902191734328171.png";     // 机器人头像
    var zsk_un_prompt = "对不起，您还在吗？";//机器人不明白的回答
    var robot_ass = "1";        //机器人优先接待
  
    var m_typeId = 0;                               // 机器人问题类别
    var m_oquesArray = new Array();                 // 保存其他类别问题
    var m_typeArray = new Array();                  // 保存类别
  
    var ly_first = true; // 首次留言
    var contact_first = true; // 首次联系方式

    //留言界面
    var is_ly_custom = ''; //留言定制版
    var ly_captcha = '2';//留言验证码是否开启

    var m_replyMode = '3'; // 留言回复方式

    var m_lwordObject = '0'; // 留言对象
    var lword_object = '<tr><td align="right" valign="middle" class="leaveword_left_td">留言对象:</td><td align="left" valign="middle"><select id="object_select" name="object_select" style="width:166px;" onchange="set_ly_obj(this.value)"><option value="zdgs">公司</option></select></td></tr>'; // 留言对象项
    var ly_assign_type = '1';
    var ly_assign_obj = 'zdgs';
    var ly_assign_value = '';
    
    var zdkf_type = '1';
    var m_cardImport = -1; // 名片是否导入
    var m_lyszc = 'on'; // 留言时注册
    var m_regStat = '0'; // 对话前注册

    var is_zdkf = '1'; // 指定客服功能是否开通
    var kf_status = '1'; //是否显示客服繁忙程度

    var brief = "https://www16.53kf.com/iframe_brief.php?style_id=106262622&language=cn&arg=10195265"; // 公司简介接口
    var logo = "https://www16.53kf.com/iframe_logo.php?arg=10195265&style_id=106262622&is_zdylogo=1&company_id=72195265&key=1&ykey=1"; // logo接口

    var ly_isImportTimer = 0; // 留言时检测是否导入定时器
    var ly_isImportTryNum = 0; // 留言时检测是否导入计数

    var auto_disconnect = "0";  // 系统自动断开时间
    var disconnect_prompt = "您已经很长时间没有发送信息了，再过3分钟，系统将会自动断开对话";  // 系统自动断开自定义提示
    var lnk_param = "%5C%7D%E2j"; // lnk参数
    var lnk_fire = "a34a3f965dcdfe7ad075d894c15b9780d9e3ac80eee05570e78cf53f86d7fdddbf94ec8f199f475b6fa1a668c1718588"; // 防火墙lnk校验参数
    var kf_expand = "1"; // 是否展开

    var kf_auto_tip = "0"; // 客服无响应提示
    var kf_auto_tip_phrase = "不好意思，客服现在正忙，请稍等……"; // 客服无响应提示语

    var m_phrase_prompt_list = new Array(); // 所有客服无响应提示语
      
    var m_busy_prompt_time_list = new Array(); // 所有客服繁忙提示语时间
    
    var imkf_no_talk_time = "600"; // IM客服无响应时间(s)

    var refreshkey = "1"; // 屏蔽F5
    var shieldrkey = "1"; // 屏蔽右键
    var tfrom = "2"; // 1:图标 2:邀请框 3:固定链接 6:新版访客端
    var is_group = "0"; // 1:集团挂码
    var chatrobot = 1;// 1:更新统计表 2:更新成功了 3:不用更新统计表
    var talk_his_table = "talk_his_d11";// talk_his切表用
    var message_table = "message_d11";// message切表用

    var company_activity = "";// 活动公告

    var voteArr = [];//评分数组
            voteArr.unshift("满意  ");
            voteArr.unshift("较好  ");
            voteArr.unshift("一般  ");
            voteArr.unshift("较差  ");
            voteArr.unshift("恶劣  ");
    
    var firewall = "0";// 访客防火墙
    var firewall_uuid = "6a94e3fd196dc593c6bfec267ba6348f";// 访客防火墙 uuid 作为页面识别
    var firewall_image_times = "3";// 访客防火墙 uuid 作为页面识别
  
    var verify_code = "0";// 访客验证码
    var fire_level = "1";
    var fire_set = "0";
    var verify_key = "a6dbf69947ca351bb327f9f5fbfc87fe";
    var is_verify = "0";
  
    var lnkopentime = "1551753834";// 访客端打开时间
    var kf_card = "1";//客服名片
    var kf_card_column = "bname,phone,email,qq";//客服名片选项
    var is_powerby = "Y";//版权信息是否显示
    var ucust_id = ""; //客户网站会员ID
    var u_stat_id = '';
    var uid = 'b90ad1b66ae9b3115f4c5aa08e57bad7';
    var select_ground_id = 0;
    var select_ground_name = "";
    var open_time = new Date().getTime();//窗口打开时间
    var isoldkf = 0;//是否老访客
    var company_logo = "https://www16.53kf.com/img/upload/10195265/mobile/temp/mobile_53kf_1550564757.png";//公司logo
    var kf_header = 'style/chat/new2017/image/png/company-logo-default.png';//默认头像
    if (company_logo != '') kf_header = company_logo;
    var adminHeaderUrl = ""; //主账号头像
    var fk_music = "";             //访客端音效
    var color_kfqp = "#f0f0f7";         // 客服气泡颜色
    var color_fkqp = "rgb(31, 140, 232)";         // 访客气泡颜色
    var color_fkxx = "rgb(255, 255, 255)";         // 访客消息颜色
    var color_kfxx = "#bf2c7b";         // 客服消息颜色
    var color_fsan = "rgb(30, 137, 230)";         // 发送按钮颜色

    var minicolor_kfqp = "rgb(239, 243, 246)";         // 浮动窗口客服气泡颜色
    var minicolor_fkqp = "rgb(31, 140, 232)";         // 浮动窗口访客气泡颜色
    var minicolor_fkxx = "rgb(255, 255, 255)";         // 浮动窗口访客消息颜色
    var minicolor_kfxx = "rgb(58, 60, 76)";         // 浮动窗口客服消息颜色
    var minicolor_fsan = "rgb(30, 137, 230)";         // 浮动窗口发送按钮颜色
    var reg_prompt = "您好，欢迎您的咨询！为了给您提供更好的服务与咨询，请输入以下信息："; // 注册提示语
    var fkzc_fields = new Array();//咨询前注册选项
            var fkzc_field = new Object();
        fkzc_field.name = "姓名";
        fkzc_field.field_name = "name";
        fkzc_field.isMust = "1";
        fkzc_field.isZdy = "0";
        fkzc_fields.push(fkzc_field);
            var fkzc_field = new Object();
        fkzc_field.name = "手机";
        fkzc_field.field_name = "mobile";
        fkzc_field.isMust = "1";
        fkzc_field.isZdy = "0";
        fkzc_fields.push(fkzc_field);
        var fkly_fields = new Array();//留言选项
            var fkly_field = new Object();
        fkly_field.name = "姓名";
        fkly_field.field_name = "name";
        fkly_field.isMust = "1";
        fkly_field.isZdy = "0";
        fkly_fields.push(fkly_field);
            var fkly_field = new Object();
        fkly_field.name = "手机";
        fkly_field.field_name = "mobile";
        fkly_field.isMust = "1";
        fkly_field.isZdy = "0";
        fkly_fields.push(fkly_field);
        var lword_type = "1"; //  留言类型 1:表单留言   2:离线对话
    var ly_conn_prompt = "欢迎您的咨询，以便为您提供更优质的服务，请输入您的手机号码";//接通提示
    var ly_guide_time = "3";// 引导提示延迟时间
    var ly_guide_prompt = "当前客服已离线，请留下您的手机号码，我们会在工作日内主动与你联系！";//引导提示
    var ly_end_prompt = "感谢您的咨询，当前客服已离线，我们会在工作日内与你联系！";//结束提示
    var robot_cannot_answer_times = 0;//机器人无法回答访客的问题的次数
    var fk_history = "1";//显示上次聊天记录
    var close_ly_window_timer = 0;//留言成功自动关闭窗口定时器
    var callback_phone = '';//客服网络回拨电话
    var net_callBack = "0";//网络回拨功能是否开启
    var mtalk_host = "mtalk.53kf.com";//第三方接口host
    var saverec_code = "5f3f354a72853ea32e02f142392eb64c6c4260ce78eb2eb5fcf8bf12a5d74872";//聊天记录下载验证码
    var lnk_overflow = "0";//发送lnk用，0:正常  1:走溢出，java不用判断排班  2:没有客服接待，直接进留言
    var wx_public_account = "0";//是否公总号授权  0,1
    var wx_drainage = "1";//是否开启微信访客端引流   0,1
    var qrcode_url = '';//公众号二维码图片
    var finger_id = "";//浏览器指纹
    var ip = "118.114.111.2";//浏览器指纹
    var is_assist = 0;//是否使用过辅助方式获取访客编号
    var is_get_guest_id = "";//是否使用浏览器指纹获取访客id
    var finger_host = "fingerprintjs.53kf.com";//浏览器指纹域名
    var kfs3_host = "kfs3.53kf.com";   
	var show_robotToTalk = "1";//访客说话时，才显示转人工
	var comeinfo = {"logo":"","title":"","content":"","curl":""};//访客来的图文信息
	var custmsg = "";//访客来的图文信息
    var lword_tempid = "0";//离线对话时用的talk_id
    var is_huawei_robot = "0";//是否使用华为机器人
    var guest_id = "10735741353002";
}catch(e){}

try{
    $.get("wnn_debug.php",{"type":"finger","flag":"is_get_guest_id","info":ip+","+guest_id+","+is_get_guest_id,"company_id":company_id});
    var ios_version = navigator.userAgent.toLowerCase().match(/cpu iphone os (.*?) like mac os/)[1].replace(/_/g,".");
    if(ios_version == "11.4.1" && is_get_guest_id ==1) is_get_guest_id = 0;//ios 11.4.1浏览器指纹失效，不使用
}catch (e){}

function first_get()
{
    if(getCookie2("guest_id")!="")
  {
    myid = getCookie2("guest_id");
  }
}

// 获取cookie
function getCookie3(name)
{
  var search = name+"=";
  if(document.cookie.length>0)
  {
    offset = document.cookie.indexOf(search);
    if(offset!=-1)
    {
      offset += search.length
      end = document.cookie.indexOf(";", offset)
      if(end==-1)
      {
        end = document.cookie.length;
      }
      return decodeURI(document.cookie.substring(offset, end));
    } 
  }
  return "";
}


// 设置conn_prompt
function set_conn_prompt(cp)
{
    if(company_id<=0 || mytempid<=0) return;
    try
    {
    var httprequest = createHttpRequest();
    if(httprequest!=null)
    {
      var url = "impl/rpc_set_prompt.php";
      var senddata = "check_id=11917718fe939f3106d35a30074bcd30&company_id="+company_id+"&temp_id="+mytempid+"&conn_prompt="+UrlEncode(cp)+"&message_table="+message_table;

      httprequest.open("POST", url, true);
     // httprequest.setRequestHeader("Content-Length", senddata.length);
      httprequest.setRequestHeader("CONTENT-TYPE", "application/x-www-form-urlencoded");
      httprequest.send(senddata);

      httprequest.onreadystatechange = function()
      {
        if(4==httprequest.readyState)
        {
          if(200==httprequest.status)
          {

          }
        }
      }
    }
  }
  catch(e){}
}

// 发送访客消息，点发送按钮
function sendmsg(msg) {
    var is_empty = false;
    if (msg == undefined) {
        msg = $.trim(kindeditor.html());
        var blank = /<br \/>$/;
        if(blank.exec(msg)){
            msg = msg.replace(blank,'');
        }
        if (kindeditor.text().replace(/&nbsp;/g,'').replace(/ /g,'') == '') is_empty = true;
    }else{
        if (msg.replace(/&nbsp;/g,'').replace(/ /g,'') == '') is_empty = true;
    }

    if(is_empty){
        basic.toastOut(infos[50]);//发送内容不能为空，请重新输入。
        kindeditor.html("");
        return false;
    }
    kindeditor.html("");
    if(guidance_type == 1) zn_order();//智能引导

    //处理base64粘贴截图
    var reg = new RegExp("<img src=\"data:image/[^>]*;base64[^>]*\" />", "gi");
    if (reg.test(msg)) {
        msg = msg.replace(reg,function(img){
            // var base64_src = img.replace("<img src=\"","").replace("\" />","");
            var base64_src = img.replace(/<img[^>]*src=[\'\"\s]*([^\s\'\"]+)[^>]*>/ig,'$1');
            var img_str = '';
            $.ajax({
                type: "POST",
                url: http_pro+host+'/upload_img_file.php?company_id='+company_id,
                data: "type=base64&base64_src="+encodeURIComponent(base64_src),
                dataType: "json",
                async : false,
                success: function(result){
                    if (result.upload == 'success') {
                        img_str = '<img src="'+result.url+'" border="0"/>';
                    }
                }
            });
            return img_str;
        });
    }
    //检测输入字符 替换ASCII码小于32的
    for(var i=1;i<32;i++) { 
        special_char = String.fromCharCode(i);
    
        if(msg.indexOf(special_char) != -1 && (i != 13 && i != 10) ) {              
            reg_special = new RegExp(special_char, "ig");
            msg = msg.replace(reg_special,"");               
        }                 
    }
    msg = $.trim(msg);
    try{
        msg = msgFilter(msg);
    }catch(e){}
    //过滤超链接new lyc20140528
    var href_link = msg.match(/\[.[url|URL].=[A-Za-z0-9].*?\].*?\[\/.[url|URL].\]/g);
    if(href_link){
        var href_url = msg.toLowerCase().match(/\[.[url|URL].=.*?\]/g);
        if(href_url){
            var href_len = href_url.length;
            for(var i = 0; i < href_len; i++){
                var href_java = href_url[i].match(/javascript:/g);
                if(href_java) return false;
            }
        }
    }
    var show_msg = msg;
    show_msg = UBBEncode(show_msg);
    var reg = new RegExp("(\\[MOBILE\])(\\d+?)(\\[\\/MOBILE\\])","gim");
    var has_mobile = 0;
    if (reg.test(show_msg) == true) {
        has_mobile = 1;
    }
    show_msg = UBBCode(show_msg);
    msg = UBBEncode(msg);
    msg = $.trim(msg);
    if(m_success==false){
        if (lnkover==200) {// 更改成机器人咨询
            $(".robotToKF").show();
            robot_main(show_msg);
        }else if (lnkover == 6 && lword_type == '2') {
            if (!m_isSend_ly_conn) {
                var differ_time = getTime() - m_ly_conn_prompt_time;
                save_offline_talk(UBBEncode(ly_conn_prompt),'p',differ_time);
                m_isSend_ly_conn = true;
            }
            display_fk_msg(show_msg);
            setTimeout(function(){
                save_offline_talk(msg,'g',1);
            },1000);
            try{
                clearTimeout(m_ly_guide_timer);
            }catch(e){}
            if (has_mobile == 1) {
                if (m_show_ly_end && ly_end_prompt != '') {
                    display_kf_msg(UBBCode(UBBEncode(ly_end_prompt)));
                    m_show_ly_end = false;
                    m_show_ly_guide = false;
                    setTimeout(function(){
                        save_offline_talk(UBBEncode(ly_end_prompt),'p',2);
                    },2000);
                }
            }else{
                if (m_show_ly_guide && ly_guide_prompt != '') {
                    m_ly_guide_timer = setTimeout(function(){
                        display_kf_msg(UBBCode(UBBEncode(ly_guide_prompt)));
                        m_show_ly_guide = false;
                        setTimeout(function(){
                            save_offline_talk(UBBEncode(ly_guide_prompt),'p',1);
                        },1000);
                    },ly_guide_time*1000);
                }
            }
        }else if(lnkover==2 || lnkover==0){
            display_fk_msg(show_msg);
            msg_wait_arr.push(msg);
            if (is_line_up) {
                var show_msg_busy = infos[12]+'<a style="cursor:pointer;" class="color-blue" onclick="getWlist(1)">'+infos[10]+'</a>';
                if (zsk=="1" && (zsk_auto_login=="0" || zsk_state=="1") && zsk_auto_hidden=="0") {
                    show_msg_busy = infos[12]+'<a style="cursor:pointer;" class="color-blue" onclick="showzsk()">'+infos[13]+'</a>'+infos[9]+'<a class="color-blue" style="cursor:pointer;" onclick="getWlist(1)">'+infos[10]+'</a>';
                }
                display_sys_msg(show_msg_busy);
            }
        }else{
            basic.toastOut(infos[51]);//对话已结束，不能发送消息。
        }
        return;
    }else{
        if(msg==""){
            basic.toastOut(infos[50]);//发送内容不能为空，请重新输入。
            return;
        }
        var fk_msgid = 'msgid_'+ new Date().getTime();
        qstmsg(UrlEncode(msg),fk_msgid);
        display_fk_msg(show_msg,fk_msgid);
        try{
            clearTimeout(carousel_id);      
        }catch(e){}
    }
}

//插入图片对象操作
var to_insert_img_obj = {
    sendimg : function(urlstr){
        if(urlstr==""||urlstr=="请输入网络地址或点击浏览上传"){
            basic.toastOut('图片路径不能为空');
            return false;
        }
        var urlcode='[IMG]'+urlstr+'[/IMG]';
        to_insert_img_obj.sendimgmsg(urlcode);
        return true;
    },
    ajaxuploadimg:function(){
        $.ajaxFileUpload({
            url:'upload_img.php?type=visiter&company_id='+company_id,//处理图片脚本
            secureuri :false,
            fileElementId :'img_pic',//file控件id
            dataType : 'json',
            success : function(data, status){
                if(data.upload=='success'){
                    $("#src-input").val(data.url);
                }else if(data.upload=='fail'){
                    basic.toastOut("上传失败");//上传失败
                }
         
                if(data.filetype=='error'){
                    basic.toastOut("暂不支持该格式!");//暂不支持该格式!
                }
                if(data.maxsize=='true'){
                    basic.toastOut("上传文件/图片不能超过100M");//上传文件/图片不能超过100M
                }
              
            },
            error: function(data, status, e){
                alert(e);
            }
        });
    },
    sendimgmsg:function(msg){
        if (m_success==true || lnkover==200 || lnkover==6 || lnkover==0) {
            sendmsg(msg);
        }
    }
};

//图片上传返回
function imgUploadResponse(file,response){
    var msg = '[IMG]'+response.url+'[/IMG]';
    try{
        msg = msgFilter(msg);
    }catch(e){}
    var show_msg = msg;
    msg = UBBEncode(msg);
    msg = HtmlEncode(msg);
    msg = $.trim(msg);
    if(typeof(rec_stat)!="undefined" && rec_stat==1){
        if(lnkover==200){
            //更改成机器人咨询
            if(chatrobot==1) chatRobot();
            return;
        }else if (lnkover==6 && lword_type == '2') {
            save_offline_talk(msg,'g');
            $("#"+file.id).data({url:response.url});
            $("#"+file.id).find(".uploadStatus").text(infos[14]).css("color","#1E88E5");
            if($("#"+file.id).find(".upload-image").length){
                var url = $("#"+file.id).data('url');
                $("#"+file.id).html("<img src='"+url+"' />");
            };
        }else{
            display_sys_msg(UBBCode(UBBEncode(lword_prompt)));
        }
    }else{
        $("#"+file.id).data({url:response.url});
        qstmsg(UrlEncode(msg),file.id);
    }
}

function fileUploadResponse(file,response){
    var file_url = "http://"+host+"/down_file.php?type=srv&company_id="+company_id+"&file="+response.real_name;
    file_url = UrlEncode(file_url);
    if (lnkover==6 && lword_type == '2') {
        var msg_arr = file_url.split("*");
        var msg = "发送了文件：[URL="+file_url+"]"+msg_arr[1]+"[/URL]";
        save_offline_talk(msg,'g');
    }else{
        send_FIL(file_url,'cfile',file.size); // 发送文件给客服
    }
    $("#"+file.id).find(".uploadStatus").text(infos[14]).css("color","#1E88E5");//上传成功
    try{
        clearTimeout(carousel_id);
    }catch(e){}
}

// 评分
function vote_open(){
    if (vote_true || obj_id==0) return;
    // if (obj_id==0) {
    //     display_sys_msg(infos[52]);// 输出信息：尚未与客服建立对话，不能评分!
    //     return;
    // }
    $(".evaluation").remove();
    var new_div = '<div class="evaluation"><div><p>'+infos[15]+'<label>'+infos[16]+'</label></p><ul><li class="li-active"></li><li class="li-active"></li><li class="li-active"></li><li class="li-active"></li><li class="li-active"></li></ul></div><a class="evaluation-btn">'+infos[17]+'</a></div>';
    display_talk_msg(new_div);
}

var isIE = (document.all)?1:0;
var xmlhttp = null;

if(isIE)
{
  xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
}
else
{
  xmlhttp = new XMLHttpRequest();
}

// 取消评分
function cancel_vote()
{
  replayVote("2");//取消评分
}

// 提交评分
function save_vote(){
   
    if (myfirst_tempid == '') myfirst_tempid = mytempid;
    try{
        if(!vote_true){
            var vote_note = '';
            var starNum = $('.pc-talk').find('.evaluation .li-active').length;
            var vote_value = 5 - starNum;
            var url = "vote.php";
            vote_true = true;
            $(".svgWrap .function-icon-eval").parent().addClass("disabled");
            var senddata="company_id="+company_id+"&id6d="+obj_id+"&action=vote&vote="+vote_value+"&note="+UrlEncode(vote_note)+"&temp_id="+myfirst_tempid+"&guest_id="+myid+"&device=1";
    
            xmlhttp.open("POST",url,false);
            xmlhttp.setRequestHeader("CONTENT-TYPE","application/x-www-form-urlencoded");
            xmlhttp.send(senddata);

            replayVote("1");//评分成功
            display_sys_msg(infos[18]);//感谢您的评价，我们会继续努力!
        }else{
            display_sys_msg(infos[53]);//您已经评过分！
        }
    }catch(e){
        display_sys_msg(infos[54]);//由于网络原因，提交评分失败
    }
    cancel_vote();
}

//下载聊天记录
function saveas()
{
  if(lnkover==1 || lnkover==3 || lnkover==100)
  {
    if (myfirst_tempid == '') myfirst_tempid = mytempid;
    try
    {
      var time=new Date();
      var filename=time.toLocaleDateString();
      filename=filename+" "+cname+".htm";
      if(!!window.ActiveXObject || "ActiveXObject" in window){
        var a=document.createElement("a");
        a.href=http_pro+host+'/impl/rpc_download_html.php?company_id='+company_id+'&tempid='+myfirst_tempid+'&style_id='+style_id+'&company_tpl='+company_tpl+'&lang='+locate+'&saverec_code='+saverec_code+'&filename='+UrlEncode(filename)+'&gid='+myid;
        a.target="_blank";
        document.body.appendChild(a);
        a.click();
        document.body.removeChild(a);
      }else{
        var winSave=window.open(http_pro+host+'/impl/rpc_download_html.php?company_id='+company_id+'&tempid='+myfirst_tempid+'&style_id='+style_id+'&company_tpl='+company_tpl+'&lang='+locate+'&saverec_code='+saverec_code+'&filename='+UrlEncode(filename)+'&gid='+myid,'_blank','top=10000');
      }
    }
    catch(e){}
  }
}

// 发送注册信息
function do_send_reg(name, email, mobile, qq, weixin, company, addr, company_id, guest_id, id6d, zdyzc_obj){
    
    var mobile = UrlEncode(mobile);
    var name = UrlEncode(name);
    var email = UrlEncode(email);
    var qq = UrlEncode(qq);
    var weixin = UrlEncode(weixin);
    var company = UrlEncode(company);
    var addr = UrlEncode(addr);
    var company_id = UrlEncode(company_id);
    var guest_id = UrlEncode(guest_id);
    var id6d = UrlEncode(id6d);
    var talk_page = UrlEncode(talkpage);
    var tfrom = UrlEncode(tfrom);
    try{
        var zdyzc_obj = JSON.stringify(zdyzc_obj);
    }catch(e){
        var zdyzc_obj = '';
    }
    
    var zdyzc_str = UrlEncode(zdyzc_obj);
    var senddata = "action=import&name="+name+"&email="+email+"&mobile="+mobile+"&qq="+qq+"&weixin="+weixin+"&company="+company+"&addr="+addr+"&company_id="+company_id+"&guest_id="+guest_id+"&id6d="+id6d+"&arg="+arg+'&guest_uid='+ucust_id+'&zdyzc_str='+zdyzc_str+'&talk_page='+talk_page+'&tfrom='+tfrom+'&device=1';

    reg_data_url = "impl/guest_info.php?"+senddata;
    $.ajax({
        type: "GET",
        url: reg_data_url,
        success: function(msg) {
            connectTalk(); 
            m_hasreg = 1;  
        },
        error: function(e){
            basic.toastOut(infos[31]);//提交失败，请检查网络连接
            $("#to_link").text(infos[4]).removeClass("loading");//发送并咨询
        }     
    });    
}

// 检查mobile
function checkInputMobile(mobile)
{
  var regx = /^1\d{10}$/;
  if(!regx.test(mobile))
  {
    return false;
  }
  return true;
}

// 填写注册信息
function to_reg(){
    var fkzc_html = '<div class="message-h font13 color-grey-deep">'+UBBCode(UBBEncode(reg_prompt))+'</div>';
    for(var key=0;key<fkzc_fields.length;key++){
        if (fkzc_fields[key].isMust == 1) {
            fkzc_html += '<p class="message-name font12 color-grey-deep"><label class="color-red">*</label>'+fkzc_fields[key].name+'<a>'+infos[0]+fkzc_fields[key].name+'</a></p><input id="reg_'+fkzc_fields[key].field_name+'" type="text" class="must"/>';
        }else{
            fkzc_html += '<p class="message-name font12 color-grey-deep">'+fkzc_fields[key].name+'<a>'+infos[0]+fkzc_fields[key].name+'</a></p><input id="reg_'+fkzc_fields[key].field_name+'" type="text"/>';
        };
    }
    var color = color_fsan;
    if(company_tpl == 'minichat2') color = minicolor_fsan;
    fkzc_html += '<a class="message-btn prevent-send" id="to_link" onclick="to_link(this)" style="background-color:'+color+';">'+infos[4]+'</a>';//发送并咨询
    $(".before-talk").html(fkzc_html);
    $(".before-talk").show().siblings().hide();
    $(".by53kf").show();
}

// 点击开始对话
function to_link(obj){
    if($(obj).hasClass("prevent-btn")){
        return false;
    };
    for(var key=0;key<fkzc_fields.length;key++){
        var reg_field = fkzc_fields[key].field_name;
        var reg_value = $.trim($("#reg_"+fkzc_fields[key].field_name).val());
        var reg_ismust = fkzc_fields[key].isMust;
        var reg_iszdy = fkzc_fields[key].isZdy;
        
        if (!check_input('reg',reg_field,reg_ismust)) {
            return;
        };

        if (reg_iszdy == 1) {
            zdyzc_obj[fkzc_fields[key].name] = reg_value;
        }else{
            if (reg_field == 'name') {
                m_regName = reg_value;
            }
            if (reg_field == 'mobile') {
                m_regMobile = reg_value;
            }
            if (reg_field == 'email') {
                m_regEmail = reg_value;
            }
            if (reg_field == 'qq') {
                m_regQQ = reg_value;
            }
            if (reg_field == 'weixin') {
                m_regWeixin = reg_value;
            }
            if (reg_field == 'company') {
                m_regCompany = reg_value;
            }
            if (reg_field == 'addr') {
                m_regAddr = reg_value;
            }
        } 
    }
    $(obj).text("").addClass("loading");
    if(username!="") m_regName = username;
    do_send_reg(m_regName, m_regEmail, m_regMobile, m_regQQ, m_regWeixin, m_regCompany, m_regAddr, company_id, myid, obj_id,zdyzc_obj);
}

// 检查留言和注册时输入项
function check_input(type,field,isMust){
    var obj = '';
    if($.type(field)=='string'){
        if (type == 'reg') {
            obj='reg_'+field;
        }else if (type == 'ly') {
            obj='ly_'+field;
        }
    }else {
        obj=$(this).attr('id');
    };
    switch(obj){
            case 'reg_mobile':
                if (!$.trim($('#'+obj).val()).IsTelephone2() && $('#'+obj).val() != '') {
                    $('#'+obj).addClass("message-error").prev().find("a").addClass("error-alert");
                    return false; 
                }
                // if( !(/^1(3|4|5|7|8)\d{9}$/.test($('#'+obj).val())) && $('#'+obj).val() != ''){ 
                //     $('#'+obj).addClass("message-error").prev().find("a").addClass("error-alert");
                //     return false; 
                // }; 
            break;
            case 'ly_mobile':
                if (!$.trim($('#'+obj).val()).IsTelephone2() && $('#'+obj).val() != '') {
                    $('#'+obj).addClass("message-error").prev().find("a").addClass("error-alert");
                    return false; 
                }
                // if( !(/^1(3|4|5|7|8)\d{9}$/.test($('#'+obj).val())) && $('#'+obj).val() != ''){ 
                //     $('#'+obj).addClass("message-error").prev().find("a").addClass("error-alert");
                //     return false; 
                // }; 
            break;
            case 'reg_email':
                if (!$.trim($('#'+obj).val()).IsEmail() && $('#'+obj).val() != '') {
                    $('#'+obj).addClass("message-error").prev().find("a").addClass("error-alert");
                    return false; 
                }
                // if(!(/^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/.test($('#'+obj).val())) && $('#'+obj).val() != '') { 
                //     $('#'+obj).addClass("message-error").prev().find("a").addClass("error-alert");
                //     return false; 
                // }; 
            break;
            case 'ly_email':
                if (!$.trim($('#'+obj).val()).IsEmail() && $('#'+obj).val() != '') {
                    $('#'+obj).addClass("message-error").prev().find("a").addClass("error-alert");
                    return false; 
                }
                // if(!(/^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/.test($('#'+obj).val())) && $('#'+obj).val() != '') { 
                //     $('#'+obj).addClass("message-error").prev().find("a").addClass("error-alert");
                //     return false; 
                // }; 
            break;
            case 'reg_qq':
                if( isNaN($('#'+obj).val()) ) { 
                    $('#'+obj).addClass("message-error").prev().find("a").addClass("error-alert");
                    return false; 
                }; 
            break;
            case 'ly_qq':
                if( isNaN($('#'+obj).val()) ) { 
                    $('#'+obj).addClass("message-error").prev().find("a").addClass("error-alert");
                    return false; 
                }; 
            break;
    };
    if (isMust == undefined || isMust == 1) {
        if(!$('#'+obj).val()){
            $('#'+obj).addClass("message-error").prev().find("a").addClass("error-alert");
            return false;
        };
    }
    
    return true;
}
    
function getWlist(type){
    $(".talk .line-up").hide();
    $(".maskArea").hide();
    var wlist = "";
    if(type==0 || type==1){
        g_comm.QuitWait();
        g_comm.ShutDown(true);  // 断开GET连接
        if(typeof(arguments[1]) != "undefined") {//代表转接给机器人
            if(typeof(ret.tempid)!="undefined") {
                mytempid = ret.tempid;
            }
            $.ajax({
                type: "POST",
                url: "sendmsg.jsp",
                data: "cmd=SRBT&sid="+myid+"&did="+mytempid+"&companyId="+company_id+"&time="+getTime(),
                success: function(msg){
                    ret.tempid = parseInt(msg);  
                }
            });
        }
        lnkover = 6;
        if (lword_type == '1') {
            set_ly_items();
        }else{
            lnkReturnShow();
            get_ly_objs();
            $(".function-icon-eval").hide();
            $(".icon-hot").hide();
            $(".icon-download").hide();
            $(".download").hide();
            display_kf_msg(UBBCode(UBBEncode(ly_conn_prompt)));
            m_ly_conn_prompt_time = getTime();
        }
        handleCustMsg("lword");
    }else if(type==2){
        var hasonline = 0;
        wlist += "<h6 class='font13 color-grey-deep'>"+UBBCode(UBBEncode("欢迎光临！请选择以下客服人员开始咨询："))+"</h6><div class='groups'>";
        var dept_man_show = "1";
        var dept_over = false;

                    if(dept_man_show=="1"){  // 指定人员+显示分组
                            }else{  // 指定人员+隐藏分组
                if (kf_expand == 1) {// 20 全部客服
                    wlist += "<p class='slide-down'>"+infos[20]+"</p><div class='customer-lists'>";
                }else{
                    wlist += "<p>"+infos[20]+"</p><div style='display:none;' class='customer-lists'>";
                }
                                wlist += "</div>";
            }
        
        if(zsk=="1"){
            if(m_robid!=""){
                if(zsk_auto_login=="0"){
                    if(zsk_auto_hidden=="0"){
                        wlist += "<p class='slide-down'>"+infos[27]+"</p>";//智能机器人（自助答疑）
                        wlist += "<div class='customer-lists'><a class='font12 color-blue' onclick='showzsk()'>"+zsk_name+"</a></div>";
                    }
                }else{
                    if(zsk_state=="1"){
                        if(zsk_auto_hidden=="0"){
                            wlist += "<p class='slide-down'>"+infos[27]+"</p>";
                            wlist += "<div class='customer-lists'><a class='font12 color-blue' onclick='showzsk()'>"+zsk_name+"</a></div>";
                        }
                    }
                }
            }
        }
        wlist += "</div>";
    }
    return wlist;
}
   
// 获取留言项
function set_ly_items(){
    if(m_lyszc=="on"){
        if(isold==0){
            m_cardImport = 0;
            ly_items_table(m_cardImport);
        }else{
            m_cardImport = document.getElementById("kh_has_import").value;
            if(m_cardImport!=-1){
                ly_items_table(m_cardImport);
            }else{
                ly_isImportTimer = setInterval("ly_checkIsImport()", 500);
            }
        }
    }else{
        m_cardImport = 1;
        ly_items_table(m_cardImport);
    }
} 

// 留言时检测is_import_true()返回
function ly_checkIsImport(){
    m_cardImport = document.getElementById("kh_has_import").value;
    if(m_cardImport!=-1){
        clearInterval(ly_isImportTimer);
        ly_items_table(m_cardImport);
    }else{
        if(ly_isImportTryNum>=CONST_REG_OVERTIME){
            clearInterval(ly_isImportTimer);
            insertErrorInfos("2", "rpc", "is_import_true request failed!");
            m_cardImport = 0;
            ly_items_table(m_cardImport);
        }
        ly_isImportTryNum++;
    }
}

// 留言项字符串
function ly_items_table(isreg){

    var fkly_html = '<div class="message-h font13 color-grey-deep">'+UBBCode(UBBEncode(lword_prompt))+'</div>';
    var color = color_fsan;
    if(company_tpl == 'minichat2') color = minicolor_fsan;
    for(var key=0;key<fkly_fields.length;key++){
        if (fkly_fields[key].isMust == 1) {
            fkly_html += '<p class="message-name font12 color-grey-deep"><label class="color-red">*</label>'+fkly_fields[key].name+'<a>'+infos[0]+fkly_fields[key].name+'</a></p><input id="ly_'+fkly_fields[key].field_name+'" type="text" class="must"/>';
        }else{
            fkly_html += '<p class="message-name font12 color-grey-deep">'+fkly_fields[key].name+'<a>'+infos[0]+fkly_fields[key].name+'</a></p><input id="ly_'+fkly_fields[key].field_name+'" type="text"/>';
        };
    }
    if (ly_assign_obj != '' && ly_assign_obj != 'zdgs' && ly_assign_type == 0) {
        fkly_html += '<div class="leaveObj-wrap field-wrap" style="display:block;font-size:12px;">'+
            '<p class="message-name isInfo-msg"><label class="color-red">*</label><span>'+infos[28]+'</span><a style="display:none">'+infos[29]+'</a></p>'+
            '<div class="lword-object-wrap">'+
                '<p class="lword-object color-grey-light">'+infos[29]+'</p>'+
                '<ul class="lword-object-lists" style="display: none;"></ul>'+
            '</div>'+
        '</div>';
    }
    

    fkly_html += '<p class="message-name font12 color-grey-deep"><label class="color-red">*</label>'+infos[2]+'<a class="font12 color-red">'+infos[3]+'</a></p>';
    fkly_html += '<textarea id="ly_content" class="must"></textarea>';
    fkly_html += '<a class="message-btn prevent-send" id="submit_lword" onclick="submit_lword()" style="background-color:'+color+';">'+infos[6]+'</a>';
    try{//定制留言界面 预留方法
        fkly_html = get_ly_html(fkly_html);
    }catch(e){}
    $(".leave-message").html(fkly_html);
    get_ly_objs();
    if (ly_assign_obj == 'zdfz') $(".lword-object-wrap").addClass("is_appoint_group");
    $(".leave-message").show().siblings().hide();
    $(".by53kf").show();
    if(isreg==1){
        get_user_card();
    }else{
        set_ly_items_value(m_regName, m_regEmail, m_regMobile, m_regQQ, m_regWeixin, m_regCompany, m_regAddr);
    }
    if (origin_type != '1') {
        talk_type = 3;
        sendkafka('type', '1', '1');
        origin_type = 1;
    }
}

//获取留言对象
function get_ly_objs(){
    if(ly_assign_obj == 'zdgs' || ly_assign_obj == ''){
        m_lwordObject = 'zdgs';
        return;
    }
    $.ajax({
        type:'POST',
        url:'impl/rpc_ly_object.php',
        data:{check_id:'11917718fe939f3106d35a30074bcd30',company_id:company_id,lang:locate,style_id:'106262622',ly_assign_type:ly_assign_type,ly_assign_obj:ly_assign_obj,ly_assign_value:ly_assign_value},
        dataType:'JSON',
        success:function(data){
            setObjectSelectOption(data);
        }
    })
}

// 设置下拉框选项
function setObjectSelectOption(options){
    if(select_ground_id != 0){
        m_lwordObject = 'g#' + select_ground_id;
        // $('#object_select').append('<option value="g#'+select_ground_id+'">'+select_ground_name+'</option>');
        $(".lword-object").html(select_ground_name);
        $(".lword-object-lists").append('<li onclick="set_ly_obj(this)" data-val="g#'+select_ground_id+'">'+select_ground_name+'</li>');
        return;
    }
    if(options.status == 'error'){
        $(".leaveObj-wrap").remove();
        m_lwordObject = 'zdgs';
        return;
    }
    if(ly_assign_type == '0' && ly_assign_obj == 'zdfz'){
        m_lwordObject = 'g#' + options[0].group_id;
        $(".lword-object").html(options[0].group_name);
        for(var i = 0;i<options.length;i++){
            $('.lword-object-lists').append('<li onclick="set_ly_obj(this)" data-val="g#'+options[i].group_id+'">'+options[i].group_name+'</li>');
        }
    }
    if(ly_assign_type == '0' && ly_assign_obj == 'zdkf'){
        m_lwordObject = '0';
        var is_first_kf = true;
        for(var group_id in options){
            if(options[group_id].group_name == undefined || options[group_id].workers == undefined){
                continue;
            }
            if (options[group_id].group_name == '' || group_id == 0) options[group_id].group_name = infos[64];
            var workers = options[group_id].workers;
            var worker_str = '<ul data-text="'+options[group_id].group_name+'" class="person-lists slide-tpl" style="display: none;">';
            for(var id6d in workers){
                if (is_first_kf) {
                    $(".lword-object").html(options[group_id].group_name+'/'+workers[id6d].name);
                    m_lwordObject = 'w#' + id6d;
                    is_first_kf = false;
                }
                if (workers[id6d].name == '') workers[id6d].name = infos[45];
                worker_str += '<li class="person-list" onclick="set_ly_obj(this)" data-val="w#'+workers[id6d].id6d+'" title="'+workers[id6d].name+'">'+workers[id6d].name+'</li>';
            }
            worker_str += '</ul>';
            $('.lword-object-lists').append('<li class="lword-object-list" data-val="0">'+options[group_id].group_name+worker_str+'</li>');
        }
    }
    if(ly_assign_type == '1' && ly_assign_obj == 'zdfz'){
        m_lwordObject = 'g#' + options.group_id;
    }
    if(ly_assign_type == '1' && (ly_assign_obj == 'zdkf' || ly_assign_obj == 'zbkf')){
        m_lwordObject = 'w#' + options.id6d;
    }
}

// 获取名片
function get_user_card()
{
 try
  {
    var httprequest = createHttpRequest();
    if(httprequest!=null)
    {
      var url = "impl/rpc_user_card.php";
      var senddata = "check_id=11917718fe939f3106d35a30074bcd30&company_id="+company_id+"&guest_id="+myid;

      httprequest.open("POST", url, true);
      httprequest.setRequestHeader("CONTENT-TYPE", "application/x-www-form-urlencoded");
      httprequest.send(senddata);

      httprequest.onreadystatechange = function()
      {
        if(4==httprequest.readyState)
        {
          if(200==httprequest.status)
          {
        
            var dom = httprequest.responseXML;

            var workerArray = new Array();
            var list_cnt = 0;

            var rowList = XMLGetNodes(dom, "row");

            var row = XMLGetNode(rowList, 0);
            name = XMLGetNamedAttr(row, "name");
            mobile = XMLGetNamedAttr(row, "mobile");
            email = XMLGetNamedAttr(row, "email");
            qq = XMLGetNamedAttr(row, "qq");
            company = XMLGetNamedAttr(row, "company");
            addr = XMLGetNamedAttr(row, "addr");
            weixin = XMLGetNamedAttr(row, "weixin");
            
            set_ly_items_value(name, email, mobile, qq, weixin, company, addr);
          }
        }
      }
    }
  }
  catch(e){}
}

// 设置留言项的值
function set_ly_items_value(name, email, mobile, qq, weixin, company, addr){
    for(var key=0;key<fkly_fields.length;key++){
        if (fkly_fields[key].field_name == 'name') {
            try{
                document.getElementById("ly_name").value = name;
                if (name != '') {
                    $("#ly_name").hide();
                    $("#ly_name").prev().hide();
                }
            }catch(e){}
        }
        if (fkly_fields[key].field_name == 'email') {
            try{document.getElementById("ly_email").value = email;}catch(e){}
        }
        if (fkly_fields[key].field_name == 'mobile') {
            try{document.getElementById("ly_mobile").value = mobile;}catch(e){}
        }
        if (fkly_fields[key].field_name == 'qq') {
            try{document.getElementById("ly_qq").value = qq;}catch(e){}
        }
        if (fkly_fields[key].field_name == 'weixin') {
            try{document.getElementById("ly_weixin").value = weixin;}catch(e){}
        }
        if (fkly_fields[key].field_name == 'company') {
            try{document.getElementById("ly_company").value = company;}catch(e){}
        }
        if (fkly_fields[key].field_name == 'addr') {
            try{document.getElementById("ly_addr").value = addr;}catch(e){}
        }
    }
}

//设置留言对象
function set_ly_obj(obj){
    m_lwordObject = $(obj).attr("data-val");
}

// 提交留言
var ret = new Object();
function submit_lword(){
    if($("#submit_lword").hasClass("prevent-btn")){
        return false;
    };
    if(m_lwordObject == '0' || m_lwordObject == null){
        basic.toastOut(infos[29]);//请选择留言对象
        return false;
    }
    for(var key=0;key<fkly_fields.length;key++){
        var ly_field = fkly_fields[key].field_name;
        var ly_value = $.trim($("#ly_"+fkly_fields[key].field_name).val());
        var ly_ismust = fkly_fields[key].isMust;
        var ly_iszdy = fkly_fields[key].isZdy;
        
        if (!check_input('ly',ly_field,ly_ismust)) {
            return;
        }
    }
    var ly_content = $.trim($("#ly_content").val());
    if(ly_content==""){
        basic.toastOut(infos[55]);//请填写留言内容！
        return false;
    }
    if (ly_captcha != 2) {
        m_checkCodeType = 2;
        createCodeFreeze(myid, 1);
    }else{
        save_lword();
    }
}


function save_lword(){
    $("#submit_lword").text(" ").addClass("loading");
    var url = "lword.php";
    if(typeof(ret.tempid)!="undefined"){
        mytempid = ret.tempid;
    }
  
    if(m_lwordObject == '0' || m_lwordObject == null){
        basic.toastOut(infos[29]);//请选择留言对象
        return false;
    }
    m_lwordObject = m_lwordObject == 'zdgs' ? '' : m_lwordObject;
    var senddata = "action=import&company_id="+company_id+"&tempid="+mytempid+"&guest_id="+myid+"&land_page="+encodeURIComponent(land_page)+"&referer="+encodeURIComponent(talkpage)+"&referer1="+encodeURIComponent(frompage)+"&ly_mode=3&ly_object="+m_lwordObject+"&hasrobot="+chatrobot+"&ucust_id="+ucust_id+"&u_stat_id="+u_stat_id+"&talk_his_table="+talk_his_table+"&message_table="+message_table+"&tfrom="+tfrom+"&style_id="+style_id;

    for(var key=0;key<fkly_fields.length;key++){
        var ly_field = fkly_fields[key].field_name;
        var ly_value = $.trim($("#ly_"+fkly_fields[key].field_name).val());
        var ly_ismust = fkly_fields[key].isMust;
        var ly_iszdy = fkly_fields[key].isZdy;
        
        if (ly_iszdy == 1) {
            zdyzc_obj[fkly_fields[key].name] = ly_value;
        }else{
            if (ly_field == 'mobile') ly_field = 'phone';
            if (ly_field == 'weixin') ly_field = 'wechat';
            senddata += "&ly_"+ly_field+"="+UrlEncode(ly_value);
        } 
    }

    var ly_content = $.trim($("#ly_content").val());
    
    if(is_ly_custom!=1 && ly_captcha !=2){
      senddata += "&ly_check_num=0";
    }else{
      senddata += "&is_ly_custom=1";
    }
    
    if(contact_first) {
        var zdyzc_str = UrlEncode(JSON.stringify(zdyzc_obj));
        senddata += "&zdyzc_str=" + zdyzc_str;     
    }

    var postdata = senddata + "&ly_content="+UrlEncode(ly_content);
    if(contact_first){
        var postdata = senddata + "&ly_first=true&iscard="+m_cardImport+"&m_lyszc="+m_lyszc+"&ly_content="+UrlEncode(ly_content);
            contact_first = false;
    }

    $.ajax({
        type:'POST',
        url:url,
        data:postdata,
        success:function(data){
            ret = str_to_obj(data);
            if(parseInt(ret.guestid)>0){
                myid = ret.guestid;
                try {
                    setCookie2("guest_id", myid);
                    // setFlashGid();
                }catch(e){}
            };
            
            $(".leaveMsg-suc").show().siblings().hide();
            $(".by53kf").show();
            var sec = parseInt($(".leaveMsg-suc").find(".seconds").text());
            var _this = $(".leaveMsg-suc");
            close_ly_window_timer = setInterval(function(){
                sec--;
                _this.find(".seconds").text(sec);
                if(sec<=0){
                    close_ly_window();
                }
            },1000);

            if(origin_type == '1'){
                sendkafka('type','1','-1',origin_time);
                origin_type = 0;
            }
            if(talk_type != '1'){
                talk_type = 1;
                sendkafka('type','1','1');
            }
        },
        error:function(){
            basic.toastOut(infos[31]);//提交失败，请检查网络连接
            $("#submit_lword").text(infos[6]).removeClass("loading");//提交留言
        }
    })
}

function save_offline_talk(msg,type,differ_time){
    var url = "lword_offlineTalk.php";
    if(typeof(ret.tempid)!="undefined"){
        mytempid = ret.tempid;
    }
    if (mytempid == '') mytempid = lword_tempid;
    if (differ_time == undefined) differ_time = 0;
    m_lwordObject = m_lwordObject == 'zdgs' ? '' : m_lwordObject;
    var senddata = "company_id="+company_id+"&tempid="+mytempid+"&guest_id="+myid+"&land_page="+encodeURIComponent(land_page)+"&referer="+encodeURIComponent(talkpage)+"&referer1="+encodeURIComponent(frompage)+"&ly_mode=3&ly_object="+m_lwordObject+"&ucust_id="+ucust_id+"&u_stat_id="+u_stat_id+"&tfrom="+tfrom+"&style_id="+style_id+"&ly_type="+type+"&differ_time="+differ_time;

    var postdata = senddata + "&ly_content="+UrlEncode(msg);
    if(contact_first){
        var postdata = senddata + "&ly_first=true&ly_content="+UrlEncode(msg);
            contact_first = false;
    }
    

    
    $.ajax({
        type:'POST',
        url:url,
        data:postdata,
        success:function(data){
            ret = str_to_obj(data);
        },
        error:function(){
            
        }
    })
}

function close_ly_window(){
    if (company_tpl == 'minichat2') {
        window.location.reload(true);
        try{
            top.postMessage('53kf_min_window', '*');//强制对话框最小化
        }catch(e){}
    }else{
        basic.close_window();
    }
    try{
        if (close_ly_window_timer) {
            clearInterval(close_ly_window_timer);
        }
    }catch(e){}
}

//str:  a:1;b:2;c:3
//obj:  obj.a=1,obj.b=2,obj.c=3
function str_to_obj(str)
{
  var tmp  = new Object(); //split by ;
  var tmp2 = new Object(); //split by :
  var ret  = new Object(); //return object
  tmp = str.split(";");
  for(var i=0; i<tmp.length; i++)
  {
    tmp2 = tmp[i].split(":");
    ret[tmp2[0]] = tmp2[1];
  }
  
  return ret;
}

// 自助答疑
var exitTime = 0;
function showzsk(type){
    get_ly_objs();
    $(".talk .line-up").hide();
    $(".window-content").removeClass('on-talking');
    $(".connectionFail").hide();
    if (show_robotToTalk == '1' && is_wlist == '0' && robot_ass == '1' && type != 1) $(".robotToKF").hide();
    if(type!=1){
        g_comm.QuitWait();
    }
    g_comm.ShutDown(true);  // 断开GET连接
    clearInterval(m_autoTimer);
    m_leftTime = zdkf_auto;

    //显示机器人对话窗口
    var now = new Date();
    exitTime = now.getTime() + 5000;
    
    $("#robot_start_time").text(getTime2());
    $(".talk").show().siblings().hide();
    if (lword_type == '2') $(".robotToLword").hide();
    $(".pc-robot").show().siblings().hide();
    $(".talk-function-bar").hide().siblings(".robot-function-bar").show();
    rec_stat = 1;
    lnkover = 200;  // 机器人自助应答

    if(type==1){ // 转接过来的
        for(var i=0; i<m_zsk_all.length; i++){
            if(m_robid==m_zsk_all[i].id){
                zsk_name = m_zsk_all[i].name;
                zsk_prompt = m_zsk_all[i].prompt;
                zsk_zsktb_url = m_zsk_all[i].zsktb_url;
                break;
            }
        }
    }else{
        if(!m_busy){
            insertTalkTotal();  // 插入talk_total表
        }
    }
    saveRobotMsgInfo(zsk_prompt,"w");
    handleCustMsg("robot");
    if(origin_type != '1'){
        talk_type = 3;
        sendkafka('type','1','1');
        origin_type = 1;
    }
}


function showRobotProblem(){
    if(lnkover == 200) {
        var now = new Date();
        if (now.getTime() > exitTime) {
            var word =  $.trim(kindeditor.html()); 
            if (word != "") {
                get_tips(word);
            }else{
                $(".guanlian-problem").hide();
            }
            exitTime = now.getTime() + 1000;
        };
    }
}

//更新机器人次数
function chatRobot()
{
    try
  {
    var httprequest = createHttpRequest();
    if(httprequest!=null)
    {
      var senddata = "company_id="+company_id+"&tempid="+mytempid+"&chatrobot=1&talk_his_table="+talk_his_table+"&message_table="+message_table;

      var url = "lword.php";
      httprequest.open("POST", url, true);
     // httprequest.setRequestHeader("Content-Length", senddata.length);
      httprequest.setRequestHeader("CONTENT-TYPE", "application/x-www-form-urlencoded");
            httprequest.send(senddata);

      httprequest.onreadystatechange = function()
      {
        if(4==httprequest.readyState)
        {
          if(200==httprequest.status)
          {
                chatrobot = httprequest.responseText;
          }
        }
      }
    }
  }
  catch(e){}
}

// 显示客服列表
function to_main_kf(){
    try{
        $(".select-customer").html(getWlist(2));
        $(".select-customer").show().siblings().hide();
        $(".by53kf").show();
    }catch(e){
        return;
    }

    worker_id = 0;
    lnkover = 2;
    is_wlist = 3;
    rec_stat = 0;
}

// 客服状态
function kfState(max_link, cnt){
    var state = "";

    if(max_link!=cnt){
        if(kf_status==2){
            state = '';//隐藏繁忙程度
        }else{
            if(cnt == 0){
                state = '';//空闲
            }else if((cnt > 0) && (cnt < Math.ceil(max_link/2))){
                state = '';//正常状态
            }else if(cnt >= Math.ceil(max_link/2)){
                state = '<font color="#FF0000">('+infos[33]+')</font>';//繁忙
            }else{

            } 
        }
    }else{
        state = '<font color="#FF0000">('+infos[32]+')</font>';//排队
    }
    return state;
}

function robot_main(question) {
    $.ajax({
//        url: "fenci/robot_fenci.php",
        url: chang_robot_url(),
        dataType:"json",
        data: {cmd: "UQR", com_id: company_id, robot_id: m_robid, question: question,"guest_id" : myid},
        success: function(result) {
            if (result != null && result["q_id"] != "0") {
                var robot_answer = result["answer"];
                var q_id = result["q_id"];
                show_robot_dialog(q_id, question, robot_answer);
            } else {
                show_robot_dialog("0", question, UBBCode(UBBEncode(zsk_un_prompt)), true);
            }
        }
    });
}

//获得输入提示
function get_tips(word) {
    $.ajax({
//        url: "fenci/robot_fenci.php",
        url: chang_robot_url(),
        data: {cmd: "ACQ", com_id: company_id, robot_id: m_robid, word: word,"guest_id" : myid},
        success: function(result) {
            var result = eval("(" + result + ")");
            var rows = result.rows;
            var q_list = "";
            for (var i = 0; i < result.total; i++) {
                var question = rows[i]["question"];
                var answer = rows[i]["answer"];
                var q_id = rows[i]["q_id"];
                if(is_huawei_robot == 1)
                    q_list = q_list + "<p onclick=\"robot_main('" + question.replace(/'/g,"\\&#039;") + "')\" title='"+question.replace(/'/g,"&#039;")+"'>" + question + "</p>";
                else
                    q_list = q_list + "<p onclick=\"show_robot_dialog('" + q_id + "', '" + question.replace(/'/g,"\\&#039;") + "', '" + answer.replace(/&#039;/g,"\\&#039;") + "')\" title='"+question.replace(/'/g,"&#039;")+"'>" + question + "</p>";
            }
            if (q_list != ""){
                $(".guanlian-problem").html(q_list).show();
            } else {
                $(".guanlian-problem").hide();
            }
        }
    });
}

//用户反馈接口
function show_robot_dialog(q_id, question, answer, type) {
    $(".guanlian-problem").hide();
    customer_response(q_id, 5);
    question_dialog(question);
    // um.execCommand('cleardoc');
    kindeditor.html("");
    saveRobotMsgInfo(question,"v");
    if(typeof type == "undefined") saveRobotMsgInfo(answer,"w");
    $.ajax({
//        url: "fenci/robot_fenci.php",
        url: chang_robot_url(),
        data: {cmd: "GT", com_id: company_id, q_id: q_id,"guest_id" : myid,"question":question},
        dataType:"json",
        success: function(rela_ques) {
            answer_dialog(q_id, answer, rela_ques);
            if(chatrobot==1) chatRobot(); //统计机器人次数
            if(origin_type == '1'){
                sendkafka('type','1','-1',origin_time);
                origin_type = 0;
            }
            if(talk_type != 2){
                talk_type = 2;
                sendkafka('type','1','1');
            }
        }
    });
}

//用户反馈接口
function customer_response(q_id, val) {
    if (q_id != "0") {
        $.ajax({
//            url: "fenci/robot_fenci.php",
            url: chang_robot_url(),
            data: {cmd: "CR", com_id: company_id, robot_id: m_robid, q_id: q_id, val: val,"guest_id" : myid},
            success: function(result) {
                
            }
        });
    }
}

function chang_robot_url(){
    var url = "/fenci/robot_fenci.php";
    if(is_huawei_robot == "1"){
        url = "/client/client_robot_info.php";
    }

    return url;
}

//问题
function question_dialog(question){
    display_robot_msg(question,'me');
}

//显示上次聊天记录
var last_talk_id = 0;
function get_record(){
    $(".show_history").removeClass("show_history_hover");
    $("#show_last_msg_button").addClass("disabled");
    try{
        last_talk_id = last_talk_id ? last_talk_id : myfirst_tempid;
        var data = {
            "company_id" : company_id,
            "guest_id" : myid,
            "talk_id" : last_talk_id
        };
        $.ajax({
            type:"POST",
            url:"/impl/last_msg_info.php",
            data:data,
            timeout:30000,
            dataType:"JSON",
            success:function(res){
                if(res.code == "error"){
                    basic.toastOut(res.info);
                }else{
                    var info = res.info;
                    if(info == ""){
                        $("#show_last_msg_button").html(infos[65]);//暂无聊天记录
                    }else{
                        $("#show_last_msg_button").html(infos[70]);//以上为历史记录
                        last_talk_id = info[0].talk_id;
                        var tmp = "";
                        for (var i = 0; i < info.length; i++) {
                            var msg = info[i].msg;
                            if (i == 0) msg = UBBEncode(msg);
                            //处理图文消息
                            var imageText = new RegExp("(\\[imageText\])([\\s\\S]+?)(\\[\\/imageText\\])","gim");
                            var cinfo_msg = msg.replace(imageText,function($1,$2,$3){
                                return $3;
                            });
                            try{if(cinfo_msg != "") cinfo_msg = eval('('+cinfo_msg+')');}catch(e){}
                            try{//处理定制不兼容
                                if(cinfo_msg.logo != undefined && cinfo_msg.title != undefined && cinfo_msg.content != undefined && cinfo_msg.curl != undefined){
                                    if(info[i].type=="p") showLastCinfo("w",cinfo_msg.logo,cinfo_msg.title,cinfo_msg.content,cinfo_msg.curl,info[i].msg_time);
                                    else showLastCinfo("v",cinfo_msg.logo,cinfo_msg.title,cinfo_msg.content,cinfo_msg.curl,info[i].msg_time);
                                    continue;
                                }
                            }catch(e){continue;}

                            msg = UBBCode(info[i].msg);
                            msg = msg.replace(/(<br>)/g, "<br>");
                            msg=msg.replace(/\[voice\](.*?)\[\/voice\]/g,"<img style='cursor:pointer' src='../../style/setting/ver06/img/suspend/voice_tip.png'></img>");
                            if(info[i].type == "p"){
                                showLastMsg(msg,'w',info[i].msg_time);
                            }
                            if(info[i].type == "g"){
                                showLastMsg(msg,'v',info[i].msg_time);
                            }
                        }
                    }
                }
            },
            error:function(xhr,status,error){
                $("#show_last_msg_button").html(infos[66]);//获取数据失败
            }
        });
    }catch(e){}
}

function  showLastCinfo(type,logo,title,content,curl,msg_time){
    if(logo != "" && title != "" && content != "" && curl != ""){
        var comeinfo_msg = '<div class="pc_ptlink_bubble" onclick="window.open(\''+curl+'\',\'_blank\')" style="width: 230px;background-color: #fff;height:68px;box-sizing:border-box; padding:10px;"><div style="width: 48px;height: 48px; float: left;"><img src="'+logo+'" alt="" style="pointer-events:none; width: 100%;height:100%;"></div><div class="pc_ptlink_bubble_text" style="margin-left: 10px;float: left;height: 48px;width: 150px;"><p class="pc_ptlink_title" style="width:100%;margin-bottom: 10px;font-size: 12px ;line-height: 18px;overflow: hidden;text-overflow: ellipsis;white-space: nowrap;color:#28334B;">'+title+'</p><p class="pc_ptlink_price" style="color:#F44024;overflow: hidden;text-overflow: ellipsis;white-space: nowrap;font-size:12px;line-height: 20px">'+content+'</p></div></div>';
        if(type == "v") showLastMsg(comeinfo_msg,'v',msg_time);
        else  showLastMsg(comeinfo_msg,'w',msg_time);
    }
}

//机器人转人工
var robotToTalkClick = false;
function robotToTalk() {
    if (robotToTalkClick === true) return;
    robotToTalkClick = true;
    display_robot_msg('','wait');
    var data = {
        'company_id' : company_id,
        'style_id' : style_id,
        'guest_id' : myid
    };

    $.ajax({
        type:"POST",
        url:"/impl/get_new_talk.php",
        data:data,
        dataType : "json",
        success:function(data){
            if (data.is_online == 1) {
                wids = data.kf_list;
                lnk_overflow = data.lnk_overflow;
                firewall_uuid = data.firewall_uuid;
                lnk_param = data.lnk_param;
                is_wlist=0;
                m_clickLink=false;
                sendLNK();
            }else{
                $(".system-wait").remove();
                if (lword_type == '2') {
                    getWlist(1);
                }else{
					display_robot_msg('','no_kf');
				}
            }
            robotToTalkClick = false;
        },
        error:function(data){
            $(".system-wait").remove();
            display_robot_msg('','no_kf');
            robotToTalkClick = false;
        }
    });
}

// 关闭访客端，提示是否评分，
// 点取消,取消评分 
function  window_beforeunload(){
    if(lnkover==1){
        if(kfpf!=0 && !vote_true){
            if(enable_talk_collection==1){
                $.ajax({
                    type: "POST",
                    url: "impl/rpc_count.php",
                    data: "kf_id="+obj_id+"&kh_id="+myid+"&kh_up="+khtalk_up+"&kh_down="+khtalk_down+"&talk_id="+mytempid,
                    dataType: "xml",
                    success: function(data){
                    }
                });
            }
        }
    }
    // if(window.event) window.event.returnValue = close_bro_prompt;
}

function window_unload()
{
    try{document.cookie = "hz6d_open_talk_"+company_id+"=0";}catch(e){}
    if(m_setTalkLastTime) set_talk_last_time();
}

// 设置talk_last_time
function set_talk_last_time()
{
    if(company_id<=0 || mytempid<=0) return;
    try
    {
    var httprequest = createHttpRequest();
    if(httprequest!=null)
    {
      var url = "impl/rpc_set_time.php";
      var senddata = "check_id=11917718fe939f3106d35a30074bcd30&company_id="+company_id+"&temp_id="+mytempid+"&talk_his_table="+talk_his_table;

      httprequest.open("POST", url, true);
      //httprequest.setRequestHeader("Content-Length", senddata.length);
      httprequest.setRequestHeader("CONTENT-TYPE", "application/x-www-form-urlencoded");
      httprequest.send(senddata);

      httprequest.onreadystatechange = function()
      {
        if(4==httprequest.readyState)
        {
          if(200==httprequest.status)
          {
           
          }
        }
      }
    }
  }
  catch(e){}
}

//判断浏览器
var check_browser = checkBrowser();
function checkBrowser(){
    if (!!window.ActiveXObject || ("ActiveXObject" in window)) {
        return 'IE';
    }
    if (navigator.userAgent.indexOf('Firefox') != -1) {
        return 'Firefox';
    }
    if (navigator.userAgent.indexOf('TheWorld')!=-1 || navigator.userAgent.indexOf('Edge')!=-1 || navigator.userAgent.indexOf('MetaSr')!=-1 || navigator.userAgent.indexOf('BIDUBrowser')!=-1 || navigator.userAgent.indexOf('QQBrowser')!=-1) {
        return 'other';
    }
    if (navigator.userAgent.indexOf('Chrome') != -1) {
        var mimeTypes = navigator.mimeTypes;
        for (var mt in mimeTypes) {
            if (mimeTypes[mt]['type'] == 'application/vnd.chromium.remoting-viewer') {
                return '360';
            }
        }
        return 'Chrome';
    }
}
//判断操作系统
var check_os = checkOs();
function checkOs(){
    if(navigator.userAgent.indexOf("Window")>0){
        return "Windows";
    }else if(navigator.userAgent.indexOf("Mac OS X")>0) {
        return "Mac";
    }else if(navigator.userAgent.indexOf("Linux")>0) {
        return "Linux";
    }else{
        return "NUll";
    }
}

//遍历添加二维码
function addQrcode(){
    var $kf_msg = $(".pc-service-right>p");
    var qrcode_str = '<span class="qr_code_53kf"><span class="qr_box_53kf"><span class="qr_img_53kf"><img src="'+qrcode_url+'" alt=""></span><em>'+infos[80]+'</em></span></span>';
    for(var i = 0;i<$kf_msg.length;i++){
        if($kf_msg.eq(i).find(".qr_code_53kf").length<1){
            $kf_msg.eq(i).append(qrcode_str);
        }
    }
    var toppx = 185;
    if (company_tpl == 'minichat2') toppx = 119;
    $(".pc-service-right").on("mouseover",".qr_code_53kf",function(){
        $(this).find(".qr_box_53kf").css("display","block");
        var offsetTop = $(this).offset().top;
        var $insertEm = $(this).find(".qr_box_53kf em"),$insertImg = $(this).find(".qr_img_53kf");
        if(offsetTop<toppx){
            $(this).find(".qr_box_53kf").css("bottom","-126px");
            $insertImg.insertAfter($insertEm);
            $insertEm.css("margin-top","5px");
        }else{
            $(this).find(".qr_box_53kf").css("bottom","21px");
            $insertEm.insertAfter($insertImg);
            $insertImg.css("margin-top",0);
            $insertEm.css("margin-top",0);
        }
    })
    $(".pc-service-right").on("mouseout",".qr_code_53kf",function(){
        $(this).find(".qr_box_53kf").css("display","none");
    })
}

</script>

<script type="text/javascript">
setTimeout(function(){
    try{
        if(m_startInitial==false){
        insertErrorInfos2("2", "initial", "call initial() failed!"+talkpage);
        }
    }catch(e){}
}, 8000);

$(function(){
    //机器人接通问候语处理
    var zsk_prompt_timer = setInterval(function(){
        try{
            if (typeof(eval('UBBCode')) == 'function') {
                $(".pc-robot-reply").html(UBBCode(UBBEncode($(".pc-robot-reply").html())));
                clearInterval(zsk_prompt_timer);
            }
        }catch(e){}
    },100);
    //机器人相关处理
    $(".pc-robot").on("click", ".unuser", function(){
        $(this).addClass("active");
        $(this).parent().siblings("div").show();
        basic.scrollPage_robot();
    });
    $(".pc-robot").on("click",".answer_helpful",function(){
        var answer_reason_val = $(this).attr('data-value');
        var answer_id = $(this).parent().parent().prev().attr('id');
        $(this).parent().text(infos[69]);//感谢你的反馈
        $(".pc-robot-eval .df").hide();
        customer_response(answer_id, answer_reason_val);
    })
    $(".pc-robot").on("click",".df li",function(){
        var answer_reason_val = $(this).attr('data-value');
        var answer_id = $(this).parent().parent().parent().prev().attr('id');
        customer_response(answer_id, answer_reason_val);
    })
    $(".pc-robot").on("mousedown", ".pc-robot-eval ul li", function() {
        $(this).addClass("selected").siblings().removeClass("selected");
    });

    $(".pc-robot").on("mouseup", ".pc-robot-eval ul li", function() {
        $(this).parent().parent().fadeOut(200);
        $(this).parent().parent().siblings("p").text(infos[69]);//感谢你的反馈
    });
    //点击感叹号重发消息
    $(".talk").on("click",".onError", function(){
        var msg = $(this).prev().html();
        var msg = UBBEncode(msg);
        var msg = UrlEncode(msg);
        var fk_msgid = $(this).attr('id');
        qstmsg(msg,fk_msgid);
        $(this).removeClass('onError');
        try{
            m_qstResTimer[fk_msgid] = setTimeout(function(){
                $("#"+fk_msgid).addClass("onError");
            },20000);
        }catch(e){}
    });
    // 网络回呼
    var callBackClick = true;
    $(".net_callBack_btn").on("click",function(){
        if(!callBackClick) return;
        var $input = $(".net_callBack_input");
        var val = $input.val();
        var code = 0;//客服未设置回呼号码
        if(/^((0\d{2,3}-?\d{7,8})|(1[3-9]\d{9}))$/.test(val)){
            callBackClick = false;
            $.ajax({
                type: "POST",
                url: "impl/rpc_callback_phone.php?from=visitor",
                data: "company_id="+company_id+"&id6d="+obj_id+"&guest_id="+myid+"&call="+val+"&style_id="+style_id+"&land_page="+encodeURIComponent(land_page)+"&talk_page="+encodeURIComponent(talkpage)+"&from_page="+encodeURIComponent(frompage),
                dataType: "json",
                success:function(result){
                    var code = result.code;
                    if (code == 0) {
                        display_sys_msg(infos[71]);//发送成功，请留意你的电话进行接听
                        $(".talk").removeClass("hasCallBack");
                    }else if(code == 3){
                        $(".net_callBack_input").addClass("error");
                        basic.toastOut(infos[73]);
                    }else if(code == 4){
                        display_sys_msg(infos[76]);//回呼功能已关闭
                        $(".talk").removeClass("hasCallBack");
                    }else if(code == 8){
                        basic.toastOut(infos[77]);//与客服号码相同，请确认后重试
                    }else if(code == 12){
                        display_sys_msg(infos[78]);//短时间存在相同的呼叫，请勿重复发起
                    }else if(code == 13){
                        display_sys_msg(infos[79]);//当前通话繁忙，请稍后拨打
                    }else{
                        display_sys_msg(infos[72]);//当前客服正在通话中，请等待客服回拨
                    }
                    g_comm.SendCallBackPhone(code,val);
                    callBackClick = true;
                },
                error: function(data, status, e){
                    basic.toastOut(infos[31]);//提交失败，请检查网络连接
                    callBackClick = true;
                }
            });
        }else {
            $(".net_callBack_input").addClass("error");
            basic.toastOut(infos[73]);
        }
    });
    
});

</script>
<script type="text/javascript" FOR="snapShot_obj" EVENT="OnSend(a,b,c)">ocx_callback(a,b,c);</script>
<script src="min/?g=.js?newkh_2019022058" type="text/javascript"></script>
<script type="text/javascript">
try{
    var fp = new Fingerprint2();
    fp.get(function(result, components) {
        finger_id = result;
    });
}catch(e){}
</script><link rel="stylesheet" type="text/css" href="js/webuploader/webuploader.css">
<script type="text/javascript" src="js/webuploader/webuploader.min.js?2017112903"></script>
<script>
    // 上传=============================start==================================================
  


//解决离线对话不弹文件窗口问题
    setTimeout(function(){
        $("input.webuploader-element-invisible").removeClass('webuploader-element-invisible').css("opacity","0");
    },500)
    
    $(function(){


        var FileUpload = function(picker,uploadURL,acceptObj){

            this.picker = picker;
            this.uploadURL = uploadURL;
        };

        FileUpload.prototype = {
            init: function(){
                var upload = this.create();
                this.bindEvent(upload);
                return upload;
            },
            create: function(){
                var uploader = WebUploader.create({

                    // 选完文件后，是否自动上传。
                    auto: true,
                    swf: 'js/webuploader/Uploader.swf',
                    server: this.uploadURL,
                    pick: {
                        id: '#'+this.picker,
                    },
                    fileVal: 'userupload',
                    duplicate: true,
                });
                return uploader;
            },
            bindEvent: function(uploader){
                _this = this;
                has_opened = true;
                uploader.on('fileQueued', function(file) {
                    var msg_time = getTime2();
                    file.ext = file.ext.toLowerCase();

                    // 如果在排队中 阻止上传
                    if($(".line-up").css("display")=='block'){
                        uploader.cancelFile( file );
                        return false;
                    };
                    //如果存在文件在上传，阻止上传
                    if(this.getStats().progressNum>=1){
                        uploader.cancelFile( file );
                        return false;
                    }

                    var html,
                        data_id = file.id,
                        name = basic.beforeRender(file.name),
                        size = file.size>1024? Math.floor(file.size/1024)>1024? Math.floor(file.size/1024/1024)+"M":Math.floor(file.size/1024)+"KB":Math.floor(file.size)+"B";

                    if(file.size/1024/1024>=100){
                        basic.toastOut("上传文件/图片不能超过100M");//上传文件/图片不能超过100M
                        uploader.cancelFile( file );
                        return false;
                    };
                    var file_type_arr = ['jpeg','gif','png','jpg',"fla","pdf","txt","doc","xls","docx","xlsx","tmp","html","wps","ppt","swf","avi","mpeg","asf","wmv","rm","rmvb","mp3","ape","wma","wav","zip","rar","mp4"];

                    if($.inArray(file.ext,file_type_arr) == -1){
                        basic.toastOut("暂不支持该格式!");//暂不支持该格式!
                        uploader.cancelFile( file );
                        return false;
                    }

                    if(file.ext == 'jpg' || file.ext == 'png' || file.ext == 'gif' || file.ext == 'jpeg'){
                        
                        html = '<div class="pc-customer"><p><label>'+infos[49]+'</label><span>'+msg_time+'</span></p><div class="upload-wrap fk-uploadFile" id = "'+data_id+'">'+
                            '<div class="upload-image fr">'+
                            '<div class="process-wrap">'+
                            '<span class="processSmall"></span>'+
                            '</div>'+
                            '<div class="statusIcon"></div>'+
                            '</div>'+
                            '</div>'+
                            '</div>';

                        $(".pc-talk").append(html);
                        var $img = $("#"+file.id).find(".upload-image");
                        uploader.makeThumb( file, function( error, ret ) {
                            if ( error ) {
                                $img.text('预览错误');//预览错误
                            } else {
                                $img.append("<img src='"+ret+"' />");
                            }
                        });
                    }else {
                        html = '<div class="pc-customer"><p><label>'+infos[49]+'</label><span>'+msg_time+'</span></p><div class="upload-wrap fk-uploadFile" id = "'+data_id+'">'+
                                    '<div class="upload-file fr"">'+
                                        '<p class="file-header">'+
                                            '<span class="fileName" title="'+file.name+'">'+name+'</span>'+
                                            '<span class="fileSize fr">'+size+'</span>'+
                                        '</p>'+
                                        '<div class="process-wrap"><span class="processLong"><span class="processSmall"></span></span><span class="upload-button"></span></div>'+
                                        '<div class="uploadStatus">上传中</div>'+
                                        '<div class="statusIcon"></div>'+
                                    '</div>'+
                                    '</div>'+
                                '</div>';
                        $(".pc-talk").append(html);//36  上传中
                    }
                    $("#"+file.id).get(0).scrollIntoView();
                });

                //上传前
                uploader.on("beforeFileQueued", function(file) {
                    file.ext = file.ext.toLowerCase();
                    var file_type_arr = ['jpeg','gif','png','jpg',"fla","pdf","txt","doc","xls","docx","xlsx","tmp","html","wps","ppt","swf","avi","mpeg","asf","wmv","rm","rmvb","mp3","ape","wma","wav","zip","rar","mp4"];


                    //提前判断是否开启视音频
                    $.ajax({
                        type:"post",
                        url:http_pro+kfs3_host+"/index.php?m=Home&c=MediaUpload&a=before_upload&arg="+arg,
                        data:{
                            "company_id":company_id,
                        },
                        async:false,
                        success:function (mes) {
                            mes=JSON.parse(mes);
                            if(mes.status !='200') has_opened=false;
                            else has_opened=true;
                        }
                    });
                    //如果未开启过或是ie8或ie9，直接进入旧文件传输口
                    if(!has_opened) return true;

                    var userAgent = navigator.userAgent,
                        rMsie = /(msie\s|trident.*rv:)([\w.]+)/,
                        rFirefox = /(firefox)\/([\w.]+)/,
                        rOpera = /(opera).+version\/([\w.]+)/,
                        rChrome = /(chrome)\/([\w.]+)/,
                        rSafari = /version\/([\w.]+).*(safari)/;
                    var browser;
                    var version;
                    var ua = userAgent.toLowerCase();
                    function uaMatch(ua){
                        var match = rMsie.exec(ua);
                        if(match != null){
                            return { browser : "IE", version : match[2] || "0" };
                        }
                        var match = rFirefox.exec(ua);
                        if (match != null) {
                            return { browser : match[1] || "", version : match[2] || "0" };
                        }
                        var match = rOpera.exec(ua);
                        if (match != null) {
                            return { browser : match[1] || "", version : match[2] || "0" };
                        }
                        var match = rChrome.exec(ua);
                        if (match != null) {
                            return { browser : match[1] || "", version : match[2] || "0" };
                        }
                        var match = rSafari.exec(ua);
                        if (match != null) {
                            return { browser : match[2] || "", version : match[1] || "0" };
                        }
                        if (match != null) {
                            return { browser : "", version : "0" };
                        }
                    }
                    var browserMatch = uaMatch(userAgent.toLowerCase());
                    if (browserMatch.browser){
                        browser = browserMatch.browser;
                        version = browserMatch.version;
                    }
                    if(browser == 'IE' && parseInt(version) <= 9){
                        has_opened=false;
                        return true;
                    }
                    
                    //如果出现余额不足等问题，重置url，请求原php地址
                    if(file.flag==true){
                        this.options.formData={"company_id":company_id};
                        this.options.fileVal="userupload";
                        this.options.server=_this.uploadURL;
                        file.flag=false;
                        return true;
                    }
                    if(file.ext == 'mp4'||file.ext == 'mp3'||file.ext == 'wav'||file.ext == 'ogg'){
                        this.options.formData={"company_id":company_id};
                        this.options.fileVal="userfile";
                        this.options.server=http_pro+kfs3_host+"/index.php?m=Home&c=MediaUpload&a=upload&arg="+arg;
                    }
                        
                });

                $(".pc-talk").on('click', '.upload-button', function() {
                    uploader.cancelFile( $(this).parents(".upload-wrap").attr("id") );
                    $("#"+$(this).parents(".upload-wrap").attr("id")).find(".process-wrap").hide();
                    $("#"+$(this).parents(".upload-wrap").attr("id")).find(".uploadStatus").text("已取消上传").css("color","#8DA2B5");//已取消上传
                })


                // 重新上传
                $(".talk").on("click",".statusIcon",function(){
                    uploader.retry($(this).parents(".upload-wrap").attr("id"));
                    $(this).parents(".upload-wrap").find(".statusIcon").hide();
                    $(this).parents(".upload-wrap").find(".process-wrap").show();
                    $(this).parents(".upload-wrap").find(".uploadStatus").text("上传中").css("color","#8DA2B5");
                });


                // 文件上传过程中创建进度条实时显示。
                uploader.on('uploadProgress', function(file, percentage) {
                    
                    $("#"+file.id).find(".process-wrap .processSmall").css("width",Math.floor(percentage * 100) + "%");

                });
                // 文件上传成功，给item添加成功class, 用样式标记上传成功。
                uploader.on('uploadSuccess', function (file, response) {
                    //若开通了视音频服务且为视频音频文件
                    if(has_opened&&(file.ext == "mp4"||file.ext == 'mp3'||file.ext == 'wav'||file.ext == 'ogg')){
                        if(response.status=='101' || response.status=='102' || response.status=='103' || response.status=='104'){
                            //basic.toastOut("上传失败");
                            //basic.toastOut("空间不足");
                            //basic.toastOut("空间到期");
                            //basic.toastOut("流量不足");
                            videoUploadResponse(file,response,"cfile",file.name);
                            displayAsFile(file.id,file.name,file.size);
                            file.flag=true;
                            this.upload(file);
                            return false;
                        }else if(response.status=='200'){
                            if(file.ext=="mp4"){
                                //上传video-response
                                videoUploadResponse(file,response,"video",file.name);

                                var $video = $("#"+file.id).find(".upload-file");
                                $video.css("width","260px");
                                $video.find('.file-header').remove();
                                $video.prepend("<video class='upload-video' style='background-color:black;width:240px;height:180px;' src='"+response.url+"' controls='controls' >抱歉，你的浏览器不支持视频播放</video>");
                                $(".process-wrap,.uploadStatus").remove();
                                return true;
                            }else if(file.ext == 'mp3'||file.ext == 'wav'||file.ext == 'ogg'){
                                //上传audio-response
                                videoUploadResponse(file,response,"audio",file.name);
                                var $audio = $("#"+file.id).find(".upload-file");
                                $audio.css("width","262px");
                                $audio.find('.file-header').remove();

                                $audio.prepend("<audio class='upload-audio' style='background-color:white;width:250px;height:55px;margin-left: -5px;' src='"+response.url+"' controls='controls' >抱歉，你的浏览器不支持音频播放</audio>");
                                $(".process-wrap,.uploadStatus").remove();
                                return true;
                            }
                        }
                    }



                    //若为其他
                    var btn_type = response.type;
                    $("#"+file.id).find(".process-wrap").hide();
                    if(response.upload == 'success'){
                        if (btn_type == 'img') {
                            imgUploadResponse(file,response);
                        }else if(btn_type == 'file'){
                            fileUploadResponse(file,response);
                        }
                    }else {
                        $("#"+file.id).find(".uploadStatus").text("上传失败").css("color","#FF4C4C");//上传失败
                        $("#"+file.id).find(".statusIcon").show();
                    }
                });

                // 文件上传失败，显示上传出错。
                uploader.on('uploadError', function(file) {
                    $("#"+file.id).find(".process-wrap").hide();
                    $("#"+file.id).find(".uploadStatus").text("上传失败").css("color","#FF4C4C");//上传失败
                    $("#"+file.id).find(".statusIcon").show();
                });

                //完成上传完了，成功或者失败
                uploader.on('uploadComplete', function(file) {
                    //重置url
                    this.options.formData={"company_id":company_id};
                    this.options.fileVal="userupload";
                    this.options.server=_this.uploadURL;
                });

            }
        }

        var file_upload = new FileUpload('file-picker',http_pro+host+'/upload_img_file.php?company_id='+company_id);
        file_upload.init();
    });

        // 上传=============================end==================================================


        // 图片预加载防止图片闪烁 ============================

        (function(){
            //存放图片路径的数组
            var imgSrcArr = [
                "style/chat/new2017/image/png/toasts.png",
                "style/chat/new2017/image/svg/toasts.svg"
            ];

            var imgWrap = [];

            function preloadImg(arr) {
                for(var i =0; i< arr.length ;i++) {
                    imgWrap[i] = new Image();
                    imgWrap[i].src = arr[i];
                }
            }
            preloadImg(imgSrcArr);
        })()

        //视频上传返回
        function videoUploadResponse(file,response,type,filename){

            if(type=='video'||type=='audio'){
                var file_url = response.url+"*"+filename;
            }else{
                var file_url = http_pro+host+"/down_file.php?type=srv&company_id="+company_id+"&file="+response.real_name;
            }
            file_url = UrlEncode(file_url);
            send_FIL(file_url,type,file.size); // 发送文件给客服
            $("#"+file.id).find(".uploadStatus").text(infos[14]).css("color","#1E88E5");//上传成功
            try{
                clearInterval(carousel_id);
            }catch(e){}
        }
        //显示为视频或音频
        function displayAsVideoAudio(msg,fk_msgid,msg_time,identity,talkname) {

            if(fk_msgid == undefined) {
                var fk_msgid_str = '';
            }else{
                var fk_msgid_str = ' id="'+fk_msgid+'" class="info-status"';
            }
            if (talkname == undefined) talkname = obj_name;
            if (talkname == '') talkname = infos[45];//客服
    
            if (msg_time == undefined) msg_time = getTime2();

            var vdtype=(msg.indexOf("mp4")>-1)?"video":"audio";
            var message=msg.match(/[a-zA-z]+:\/\/[^\s]*/);
            var name=msg.split(message)[1].match(/[\w.]*\.[\w.]*/);
            if(identity=="fk"){
                if(msg.indexOf("mp4")>-1){
                    var show_msg = '<div class="pc-customer"><p><label>'+infos[49]+'</label><span>'+msg_time+'</span></p><div class="pc-customer-info" style="background-color:'+minicolor_fkqp+';"><div class="textWrap" style="color:'+minicolor_fkxx+';"><'+vdtype+' class="upload-'+vdtype+'" style="background-color:black;width:240px;height:180px;" controls="controls" src='+message+'></'+vdtype+'></div><i'+fk_msgid_str+'></i></div></div>';
                }else{
                    var show_msg = '<div class="pc-customer"><p><label>'+infos[49]+'</label><span>'+msg_time+'</span></p><div class="pc-customer-info" style="width:262px;"><div class="textWrap" style="color:'+minicolor_fkxx+';width:262px;"><'+vdtype+' class="upload-'+vdtype+'" style="width:250px;height:55px;margin-left:-2px;" controls="controls" src='+message+'></'+vdtype+'></div><i'+fk_msgid_str+'></i></div></div>';
                }
                //若为ie8及以下浏览器,覆盖show_msg为卡片文件格式
                if(!!window.ActiveXObject&&document.documentMode==8){
                     var show_msg = '<div class="upload-wrap kf-uploadFile">'+
                        '<div class="upload-file fr">'+
                            '<p class="file-header">'+
                                '<span class="fileName" style="min-height:18px;">'+name+'</span>'+
                                '<span class="fileSize fr">'+infos[44]+'</span>'+
                            '</p>'+
                            '<div class="uploadStatus color-blue fr"><a href="'+message+'" target="_blank">'+infos[68]+'</a></div>'+
                            '<div class="statusIcon"></div>'+
                        '</div>'+
                    '</div>';
                }
            }else if(identity=="kf"){
                if(msg.indexOf("mp4")>-1){
                    var show_msg = '<div class="pc-service"><div class="pc-service-left" style="display: inline-block;"><img src="'+kf_header+'" alt="'+infos[11]+'"></div><div class="pc-service-right" ><p><label>'+talkname+'</label><span>'+msg_time+'</span></p><div class="upload-wrap kf-uploadFile" >'+'<div class="upload-file fl" style="width:260px;">'+'<video class="upload-video"  style="background-color:black;width:240px;height:180px;" src="'+message+'" controls="controls">抱歉，你的浏览器不支持视频播放</video></div>'+                        '</div>'+'</div></div></div>';
                }else{
                    var show_msg = '<div class="pc-service"><div class="pc-service-left" style="display: inline-block;"><img src="'+kf_header+'" alt="'+infos[11]+'"></div><div class="pc-service-right" ><p><label>'+talkname+'</label><span>'+msg_time+'</span></p><div class="upload-wrap kf-uploadFile" style="width:262px;">'+'<div class="upload-file fl" style="width:262px;">'+'<audio class="upload-audio" style="background-color:white;width:250px;height:55px;margin-left:-5px;" src="'+message+'" controls="controls">抱歉，你的浏览器不支持音频播放</audio></div>'+'</div>'+'</div></div></div>';
                }
                //若为ie8及以下浏览器,覆盖show_msg为卡片文件格式
                if(!!window.ActiveXObject&&document.documentMode==8){
                     var show_msg = '<div class="pc-service"><div class="pc-service-left" style="display: inline-block;"><img src="'+kf_header+'" alt="'+infos[11]+'"></div><div class="pc-service-right" ><div class="upload-wrap kf-uploadFile">'+
                        '<div class="upload-file fl">'+
                            '<p class="file-header">'+
                                '<span class="fileName" style="min-height:18px;">'+name+'</span>'+
                                '<span class="fileSize fr">'+infos[44]+'</span>'+
                            '</p>'+
                            '<div class="uploadStatus color-blue fr"><a href="'+message+'" target="_blank">'+infos[68]+'</a></div>'+
                            '<div class="statusIcon"></div>'+
                        '</div>'+
                    '</div></div></div>';
                }
            }
            $(".pc-talk").append(show_msg);
            basic.scrollPage();
            if (fk_msgid_str != '') {
                try{
                    m_qstResTimer[fk_msgid] = setTimeout(function(){
                        $("#"+fk_msgid).addClass("onError");
                    },20000);
                }catch(e){}
            }
        }
        //显示为文件
        function displayAsFile(data_id,file_name,size) {
            var msg_time = getTime2();
            var name=basic.beforeRender(file_name);
            var html = '<div class="pc-customer"><p><label>'+infos[49]+'</label><span>'+msg_time+'</span></p><div class="upload-wrap fk-uploadFile" id = "'+data_id+'">'+
                        '<div class="upload-file fr">'+
                            '<p class="file-header">'+
                                '<span class="fileName" title="'+file_name+'">'+name+'</span>'+
                                '<span class="fileSize fr">'+size+'</span>'+
                            '</p>'+
                            '<div class="uploadStatus color-blue" style="color: rgb(30, 136, 229);">'+infos[14]+'</div>'+
                            '<div class="statusIcon"></div>'+
                        '</div>'+
                        '</div>'+
                    '</div>';
            $("#"+data_id).html(html);
        }
        //左下角by 53
        var timer;
        $(".sm_triangle").mouseenter(function(){
            clearTimeout(timer);
            $(".triangle_to53").show();
        })
        $(".sm_triangle").mouseleave(function(){
            timer = setTimeout(function(){
                $(".triangle_to53").hide();
            },500)
        })
        $(".triangle_to53").mouseenter(function(){
            clearTimeout(timer);
        })
        $(".triangle_to53").mouseleave(function(){
            $(".triangle_to53").hide();
        })
        $(".hover_53").mouseenter(function(){
            $(".hover_53").css("color","#79BAF3");
        })
        $(".hover_53").mouseleave(function(){
            $(".hover_53").css("color","#fff");
        })
</script>
</html>
