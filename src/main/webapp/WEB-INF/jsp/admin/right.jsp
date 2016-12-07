<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional
.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>jeecms-left</title>
<link href="/javacms/res/jeecms/css/admin.css" rel="stylesheet" type="text/css"/>
<link href="/javacms/res/common/css/theme.css" rel="stylesheet" type="text/css"/>
<link href="/javacms/res/common/css/jquery.validate.css" rel="stylesheet" type="text/css"/>
<link href="/javacms/res/common/css/jquery.treeview.css" rel="stylesheet" type="text/css"/>
<link href="/javacms/res/common/css/jquery.ui.css" rel="stylesheet" type="text/css"/>

<script src="/javacms/thirdparty/My97DatePicker/WdatePicker.js" type="text/javascript"></script>
<script src="/javacms/res/common/js/jquery.js" type="text/javascript"></script>
<script src="/javacms/res/common/js/jquery.ext.js" type="text/javascript"></script>
<script src="/javacms/res/common/js/jquery-ui.js" type="text/javascript"></script>
<script src="/javacms/res/common/js/jeecms.js" type="text/javascript"></script>
<script src="/javacms/res/jeecms/js/admin.js" type="text/javascript"></script>

<script src="/javacms/thirdparty/ueditor/ueditor.config.js" type="text/javascript" ></script>
<script src="/javacms/thirdparty/ueditor/ueditor.all.js" type="text/javascript" ></script>
<script src="/javacms/thirdparty/ueditor/lang/zh-cn/zh-cn.js" type="text/javascript" ></script>
<script src="/javacms/res/jeecms/js/FengTab.js" type="text/javascript"></script>
<link href="/javacms/res/common/css/jquery.flot.css" rel="stylesheet" type="text/css"/>
<!--[if lte IE 8]><![endif]-->
<script language="javascript" type="text/javascript" src="/javacms/res/common/js/excanvas.min.js"></script
>
<script src="/javacms/res/common/js/jquery.flot.min.js" type="text/javascript"></script>
<script src="/javacms/res/common/js/jquery.flot.time.min.js" type="text/javascript"></script>
<script src="/javacms/res/common/js/jquery.flot.categories.min.js" type="text/javascript"></script>
<script class="code" type="text/javascript">
$(function() {
    var dayPv = [],weekPv=[],monthPv=[],yearPv=[];
    <!--小时或者月pv-->
        dayPv.push([10, 11]);
        yearPv.push([6, 284]);
        yearPv.push([7, 392]);
        yearPv.push([8, 205]);
        yearPv.push([9, 1508]);
        yearPv.push([10, 3697]);
    <!--日期-->
    var datasets = {
        "day": {
            label: "PV统计",
            data: dayPv
        },
        "week": {
            label: "PV统计",
            data: weekPv
        },
        "month": {
            label: "PV统计",
            data: monthPv
        },
        "year": {
            label: "PV统计",
            data: yearPv
        }
    };
    var i = 0;
    $.each(datasets, function(key, val) {
        val.color = i;
        ++i;
    });
    function plotAccordingToChoices() {
        var data = [];
        data.push(datasets["day"]);
        if (data.length > 0) {
            $.plot("#placeholder1", data,{
                series: {
                    lines: {
                        show: true
                    },
                    points: {
                        show: true
                    }
                },
                grid: {
                    hoverable: true
                },
                yaxis: {
                    min: 0,tickDecimals: 0
                },
                pageX:"时间",
                xaxis: {
                    ticks: [0,1, 2, 3, 4, 5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23],
                    min:0,
                    max:23,
                    tickDecimals: 0
                 }  
            });
        }
        data = [];
        data.push(datasets["week"]);
        if (data.length > 0) {
            $.plot("#placeholder2", data,{
                series: {
                    lines: {
                        show: true
                    },
                    points: {
                        show: true
                    }
                },
                grid: {
                    hoverable: true
                },
                yaxis: {
                    min: 0,tickDecimals: 0
                },
                pageX:"时间",
                xaxis: {
                    minTickSize: [1, "day"],
                    mode: "time",timezone: "browser",
                    timeformat: "%m/%d"
                  }
            });
        }
        data = [];
        data.push(datasets["month"]);
        if (data.length > 0) {
            $.plot("#placeholder3", data,{
                series: {
                    lines: {
                        show: true
                    },
                    points: {
                        show: true
                    }
                },
                grid: {
                    hoverable: true
                },
                yaxis: {
                    min: 0,tickDecimals: 0
                },
                pageX:"时间",
                xaxis: {
                    minTickSize: [1, "day"],
                    mode: "time",timezone: "browser",
                    timeformat: "%m/%d"
                  }
            });
        }
        data = [];
        data.push(datasets["year"]);
        if (data.length > 0) {
            $.plot("#placeholder4", data,{
                series: {
                    lines: {
                        show: true
                    },
                    points: {
                        show: true
                    }
                },
                grid: {
                    hoverable: true
                },
                yaxis: {
                    min: 0,tickDecimals: 0
                },
                pageX:"时间",
                xaxis: {
                    ticks: [1, 2, 3, 4, 5,6,7,8,9,10,11,12],
                    min:1,
                    max:12,
                    tickDecimals: 0,
                    tickFormatter:function (val, axis) {
                          return val;
                    }
                }
            });
        }
    }
    plotAccordingToChoices();
    $("<div id='tooltip'></div>").css({
        position: "absolute",
        display: "none",
        border: "1px solid #fdd",
        padding: "2px",
        "background-color": "#fee",
        opacity: 0.80
    }).appendTo("body");
    $("#placeholder1,#placeholder2,#placeholder3,#placeholder4").bind("plothover", function (event, pos
, item) {
        if (item) {
            var x = item.datapoint[0].toFixed(0),
                y = item.datapoint[1].toFixed(0);
            $("#tooltip").html(item.series.label  + " = " + y)
            .css({top: item.pageY+5, left: item.pageX+5})
            .fadeIn(200);
        } else {
            $("#tooltip").hide();
        }
    });
});
$(function() {
    $("#tabs").tabs({
        event: "mouseover"
    });
    $("#contentTabs").tabs({
        event: "mouseover"
    });
    $("a[id^='check_']").each(function(i){
       var contentId=$(this).prop("id").split("check_")[1];
       $(this).bind('click', function() {
           $.post("content/o_ajax_check.do", {
                  ids:contentId
                }, function(data) {
                    if(data.success){
                         $("#tr_"+contentId).remove();
                         $.alert("提示","操作成功");
                    }else{
                         $.alert("提示","操作失败");
                    }
             }, "json");
        }); 
    });
    $("#dialog-reject-form").dialog({
        autoOpen: false,
        height: 300,
        width: 350,
        modal: true,
        buttons: {
            "提交": function rejectSubmit() {
                $.post("content/o_ajax_reject.do", {
                    ids:$("#contentId").val(),
                    rejectOpinion:$("#rejectOpinion").val()
                }, function(data) {
                    if(data.success){
                         $("#tr_"+contentId).remove();
                         $.alert("提示","操作成功");
                    }else{
                         $.alert("提示","操作失败");
                    }
                 }, "json");
                 $( this ).dialog( "close" );
            },
            "重置": function() {
                $("#rejectForm")[0].reset();
            }
        }
    });
    $("a[id^='reject_']").each(function(i){
      contentId=$(this).prop("id").split("reject_")[1];
      $("#contentId").val(contentId);
      $(this).bind('click', function() {
          $( "#dialog-reject-form" ).dialog("open");
      });   
    });
});
</script>
</head>
<body>
     <div class="page-positon ove">
    <div class="position-div">当前位置: 首页 > 欢迎页</div>
     </div>
     <div class="welcome-con">
       <span>已用内存: <em class="yync">166.78MB</em>剩余内存: <em class="sync">1589.72MB</em>最大内存: 1756.5MB
</span>欢迎登录jeecms演示站<a class="change-inf" href="personal/v_profile.do">修改个人信息</a>您上次登录的时间是: 2016-12-07

     </div>
     <div class="home-main">
       <div class="home-main-l f_l">
         <div class="item count">
           <div class="item-nav"><a><i></i>网站数据统计</a></div>
           <div class="item-list">
             <span class="first">今日</span><span>本周</span><span>本月</span><span class="end">总</span>
           </div>
           <div class="item-con">
             <div>
             <table cellpadding="0" cellspacing="0">
               <tbody>
                 <tr>
                   <td>
                     <div class="home-view">
                       <div class="home-view-img"><img src="/javacms/res/jeecms/images/view-icon.png"
></div>
                       <div class="home-view-txt"><span>0</span><p>网站访问量</p></div>
                     </div>
                   </td>
                   <td>
                     <div class="home-publish">
                       <div class="home-view-img"><img src="/javacms/res/jeecms/images/publish-icon.png"
></div>
                       <div class="home-view-txt"><span>0</span><p>发布文章数</p></div>
                     </div>
                   </td>
                   <td>
                     <div class="home-examine">
                       <div class="home-view-img"><img src="/javacms/res/jeecms/images/examine-icon.png"
></div>
                       <div class="home-view-txt"><span>0</span><p>待审核文章</p></div>
                     </div>
                   </td>
                 </tr>
                 <tr>
                   <td>
                     <div class="home-comment">
                       <div class="home-view-img"><img src="/javacms/res/jeecms/images/comment-icon.png"
></div>
                       <div class="home-view-txt"><span>0</span><p>评论数</p></div>
                     </div>
                   </td>
                   <td>
                     <div class="home-message">
                       <div class="home-view-img"><img src="/javacms/res/jeecms/images/message-icon.png"
></div>
                       <div class="home-view-txt"><span>0</span><p>留言数</p></div>
                     </div>
                   </td>
                   <td>
                     <div class="home-member">
                       <div class="home-view-img"><img src="/javacms/res/jeecms/images/member-icon.png"
></div>
                       <div class="home-view-txt"><span>0</span><p>注册人数</p></div>
                     </div>
                   </td>
                 </tr>
               </tbody>
             </table>
             </div>
             <div>
             <table cellpadding="0" cellspacing="0">
               <tbody>
                 <tr>
                   <td>
                     <div class="home-view">
                       <div class="home-view-img"><img src="/javacms/res/jeecms/images/view-icon.png"
></div>
                       <div class="home-view-txt"><span>0</span><p>网站访问量</p></div>
                     </div>
                   </td>
                   <td>
                     <div class="home-publish">
                       <div class="home-view-img"><img src="/javacms/res/jeecms/images/publish-icon.png"
></div>
                       <div class="home-view-txt"><span>0</span><p>发布文章数</p></div>
                     </div>
                   </td>
                   <td>
                     <div class="home-examine">
                       <div class="home-view-img"><img src="/javacms/res/jeecms/images/examine-icon.png"
></div>
                       <div class="home-view-txt"><span>0</span><p>待审核文章</p></div>
                     </div>
                   </td>
                 </tr>
                 <tr>
                   <td>
                     <div class="home-comment">
                       <div class="home-view-img"><img src="/javacms/res/jeecms/images/comment-icon.png"
></div>
                       <div class="home-view-txt"><span>0</span><p>评论数</p></div>
                     </div>
                   </td>
                   <td>
                     <div class="home-message">
                       <div class="home-view-img"><img src="/javacms/res/jeecms/images/message-icon.png"
></div>
                       <div class="home-view-txt"><span>0</span><p>留言数</p></div>
                     </div>
                   </td>
                   <td>
                     <div class="home-member">
                       <div class="home-view-img"><img src="/javacms/res/jeecms/images/member-icon.png"
></div>
                       <div class="home-view-txt"><span>0</span><p>注册人数</p></div>
                     </div>
                   </td>
                 </tr>
               </tbody>
             </table>
             </div>
             <div>
             <table cellpadding="0" cellspacing="0">
               <tbody>
                 <tr>
                   <td>
                     <div class="home-view">
                       <div class="home-view-img"><img src="/javacms/res/jeecms/images/view-icon.png"
></div>
                       <div class="home-view-txt"><span>0</span><p>网站访问量</p></div>
                     </div>
                   </td>
                   <td>
                     <div class="home-publish">
                       <div class="home-view-img"><img src="/javacms/res/jeecms/images/publish-icon.png"
></div>
                       <div class="home-view-txt"><span>0</span><p>发布文章数</p></div>
                     </div>
                   </td>
                   <td>
                     <div class="home-examine">
                       <div class="home-view-img"><img src="/javacms/res/jeecms/images/examine-icon.png"
></div>
                       <div class="home-view-txt"><span>0</span><p>待审核文章</p></div>
                     </div>
                   </td>
                 </tr>
                 <tr>
                   <td>
                     <div class="home-comment">
                       <div class="home-view-img"><img src="/javacms/res/jeecms/images/comment-icon.png"
></div>
                       <div class="home-view-txt"><span>0</span><p>评论数</p></div>
                     </div>
                   </td>
                   <td>
                     <div class="home-message">
                       <div class="home-view-img"><img src="/javacms/res/jeecms/images/message-icon.png"
></div>
                       <div class="home-view-txt"><span>0</span><p>留言数</p></div>
                     </div>
                   </td>
                   <td>
                     <div class="home-member">
                       <div class="home-view-img"><img src="/javacms/res/jeecms/images/member-icon.png"
></div>
                       <div class="home-view-txt"><span>0</span><p>注册人数</p></div>
                     </div>
                   </td>
                 </tr>
               </tbody>
             </table>
             </div>
             <div>
             <table cellpadding="0" cellspacing="0">
               <tbody>
                 <tr>
                   <td>
                     <div class="home-view">
                       <div class="home-view-img"><img src="/javacms/res/jeecms/images/view-icon.png"
></div>
                       <div class="home-view-txt"><span>7181</span><p>网站访问量</p></div>
                     </div>
                   </td>
                   <td>
                     <div class="home-publish">
                       <div class="home-view-img"><img src="/javacms/res/jeecms/images/publish-icon.png"
></div>
                       <div class="home-view-txt"><span>68</span><p>发布文章数</p></div>
                     </div>
                   </td>
                   <td>
                     <div class="home-examine">
                       <div class="home-view-img"><img src="/javacms/res/jeecms/images/examine-icon.png"
></div>
                       <div class="home-view-txt"><span>0</span><p>待审核文章</p></div>
                     </div>
                   </td>
                 </tr>
                 <tr>
                   <td>
                     <div class="home-comment">
                       <div class="home-view-img"><img src="/javacms/res/jeecms/images/comment-icon.png"
></div>
                       <div class="home-view-txt"><span>4</span><p>评论数</p></div>
                     </div>
                   </td>
                   <td>
                     <div class="home-message">
                       <div class="home-view-img"><img src="/javacms/res/jeecms/images/message-icon.png"
></div>
                       <div class="home-view-txt"><span>4</span><p>留言数</p></div>
                     </div>
                   </td>
                   <td>
                     <div class="home-member">
                       <div class="home-view-img"><img src="/javacms/res/jeecms/images/member-icon.png"
></div>
                       <div class="home-view-txt"><span>0</span><p>注册人数</p></div>
                     </div>
                   </td>
                 </tr>
               </tbody>
             </table>
             </div>
           </div>
         </div>
         <script>
            $(".count").FengTab({titCell:".item-list",mainCell:".item-con",defaultIndex:0,trigger:"click",titOnClassName
:"on",showtime: 0});
        </script>
         <div class="item analysis">
           <div class="item-nav"><a><i></i>访问量分析</a></div>
           <div class="item-list">
             <span class="first">今日</span><span>本周</span><span>本月</span><span class="end">今年</span>

           </div>
           <div class="item-con">
             <div style="float:left; width:99%;height: 270px;">
                <div id="placeholder1" style="float:left; width:95%;height: 250px;"></div>
             </div>
             <div style="float:left; width:99%;height: 270px;">
                <div id="placeholder2" style="float:left;width:680%;height: 250px;"></div>
             </div>
             <div style="float:left; width:99%;height: 270px;">
                <div id="placeholder3"  style="float:left;width:680%;height: 250px;"></div>
             </div>
             <div style="float:left; width:99%;height: 270px;">
                <div id="placeholder4" style="float:left;width:680%;height: 250px;"></div>
             </div>
           </div>
         </div>
         <script>
            $(".analysis").FengTab({titCell:".item-list",mainCell:".item-con",defaultIndex:0,trigger:"click",titOnClassName
:"on",showtime: 0});
        </script>
       </div>
       <div class="home-main-r f_r">
         <div class="item channel">
           <div class="item-nav"><a><i></i>栏目访问量统计</a></div>
           <div class="item-list">
             <span class="first">今日</span><span>本周</span><span>本月</span><span class="end">总</span>
           </div>
           <div class="item-con">
             <div>
             <table cellpadding="0" cellspacing="0">
               <tbody>
                 <tr><td><span class="first">1</span>网络调查</td><td class="channel-count">0</td></tr>

                 <tr><td><span class="second">2</span>留言板</td><td class="channel-count">0</td></tr>

                 <tr><td><span class="third">3</span>招聘</td><td class="channel-count">0</td></tr>
                 <tr><td><span >4</span>下载</td><td class="channel-count">0</td></tr>
                 <tr><td><span >5</span>视频</td><td class="channel-count">0</td></tr>
                 <tr><td><span >6</span>图库</td><td class="channel-count">0</td></tr>
                 <tr><td><span >7</span>新闻</td><td class="channel-count">0</td></tr>
               </tbody>
             </table>
             </div>
             <div>
             <table cellpadding="0" cellspacing="0">
               <tbody>
                 <tr><td><span class="first">1</span>网络调查</td><td class="channel-count">0</td></tr>

                 <tr><td><span class="second">2</span>留言板</td><td class="channel-count">0</td></tr>

                 <tr><td><span class="third">3</span>招聘</td><td class="channel-count">0</td></tr>
                 <tr><td><span >4</span>下载</td><td class="channel-count">0</td></tr>
                 <tr><td><span >5</span>视频</td><td class="channel-count">0</td></tr>
                 <tr><td><span >6</span>图库</td><td class="channel-count">0</td></tr>
                 <tr><td><span >7</span>新闻</td><td class="channel-count">0</td></tr>
               </tbody>
             </table>
             </div>
             <div>
             <table cellpadding="0" cellspacing="0">
               <tbody>
                 <tr><td><span class="first">1</span>网络调查</td><td class="channel-count">0</td></tr>

                 <tr><td><span class="second">2</span>留言板</td><td class="channel-count">0</td></tr>

                 <tr><td><span class="third">3</span>招聘</td><td class="channel-count">0</td></tr>
                 <tr><td><span >4</span>下载</td><td class="channel-count">0</td></tr>
                 <tr><td><span >5</span>视频</td><td class="channel-count">0</td></tr>
                 <tr><td><span >6</span>图库</td><td class="channel-count">0</td></tr>
                 <tr><td><span >7</span>新闻</td><td class="channel-count">0</td></tr>
               </tbody>
             </table>
             </div>
             <div>
             <table cellpadding="0" cellspacing="0">
               <tbody>
                 <tr><td><span class="first">1</span>新闻</td><td class="channel-count">443</td></tr>

                 <tr><td><span class="second">2</span>图库</td><td class="channel-count">203</td></tr>

                 <tr><td><span class="third">3</span>下载</td><td class="channel-count">53</td></tr>
                 <tr><td><span >4</span>招聘</td><td class="channel-count">49</td></tr>
                 <tr><td><span >5</span>视频</td><td class="channel-count">38</td></tr>
                 <tr><td><span >6</span>网络调查</td><td class="channel-count">33</td></tr>
                 <tr><td><span >7</span>留言板</td><td class="channel-count">6</td></tr>
               </tbody>
             </table>
             </div>
           </div>
         </div>
         <script>
        $(".channel").FengTab({titCell:".item-list",mainCell:".item-con",defaultIndex:0,trigger:"click",titOnClassName
:"on",showtime: 0});
        </script>
       </div>
     </div>
</body>
</html>