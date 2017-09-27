<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	String path = request.getContextPath();
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="/static/default/css/swiper.3.2.0.min.css">
<link rel="stylesheet" type="text/css" href="/static/default/css/common.css">
<link rel="stylesheet" type="text/css" href="/static/default/css/inside.css">
<link rel="stylesheet" type="text/css" href="/static/default/css/cm_pagination.css">
<script type="text/javascript" src="/static/default/js/jquery.min.js"></script>
<script type="text/javascript" src="/static/default/js/swiper.3.2.0.min.js"></script>
<script type="text/javascript" src="/static/default/js/promo_v2.js"></script>
<script type="text/javascript" src="/static/default/js/common.js"></script>
<link rel="shortcut icon" href="/static/default/images/favicon.ico">
<title>南昌南泰建筑装饰有限公司|南昌全包装修公司|南昌室内装修</title>
<meta name="keywords" content="南泰装饰,南昌装修,南昌装修网,南昌家装,南昌室内装修,南昌装修效果图,南昌一站式装修,南昌装修全包">
<meta name="description" content="南昌南泰装饰，有行业最前沿的VR展厅，提供装修效果图，装修设计案例，装修预算报价，装修知识等家装服务，一站式装修服务，省心省时更省钱！">
</head>

<body>
<div class="top_div">
    <div class="top">
        <div class="left_tel">咨询热线：<span>13667007868</span></div>
        <div class="right">
            <div class="user">
                                    <a href="javascript:void(0);" class="login">登录</a>&nbsp;|&nbsp;
                    <a href="javascript:void(0);" class="reg">注册</a>
                                </div>
            <div class="wechat"><img src="/static/default/images/s_icon/head-wechat.png" class="wpic" />
                <div class="wcode"><img src="/upload/image/170209/4_589bc2dad65d9.jpg" width="100" height="100" /></div>
            </div>
            <div class="bdsharebuttonbox sharesapn"><a href="javascript:void(0)" style="margin:0" class="bds_more bdshare" data-cmd="more"></a></div>
        </div>
    </div>
</div>
<div class="relo_div login_div">
    <div class="lo_top">
        <a href="javascript:void(0);" class="login_a hover">用户登录</a>
        <a href="javascript:void(0);" class="register_a">免费注册</a>
    </div>
    <form action="" method="post" name="form1">
        <input type="text" placeholder="请输入您的帐号" class="user" name="username" id="login_u" />
        <input type="password" placeholder="请输入您的密码" class="pwd" name="pwd" id="login_p" />
        <input type="text" placeholder="请输入验证码" class="voify" name="voify" id="login_code" />
        <div class="lo_voify">
            <img src="/home/captcha.html?t=508" onclick="this.src='/home/captcha.html?t='+Math.random();" />
        </div>
        <input name="login" type="button" value="登 录" class="login_m" onclick="submit_login()" />
    </form>
    <div class="login_bot">还没有账号？请<a href="javascript:void(0);" class="quick_re">快速注册</a>。</div>
</div>
<div class="relo_div register_div">
    <div class="lo_top">
        <a href="javascript:void(0);" class="login_a">用户登录</a>
        <a href="javascript:void(0);" class="register_a hover">免费注册</a>
    </div>
    <form action="/user/register" method="post" name="form2">
        <input type="text" placeholder="请输入您的帐号" class="user" name="user" id="reg_u" />
        <input type="password" placeholder="请输入您的密码" class="pwd" name="pwd" id="reg_p" />
        <input type="text" placeholder="请输入您的手机号码" class="tel" name="tel" id="reg_tel" />
        <input type="text" placeholder="请输入验证码" class="voify" name="voify" id="reg_code" />
        <div class="lo_voify">
            <img src="/home/captcha.html?t=917" onclick="this.src='/home/captcha.html?t='+Math.random();" />
        </div>
        <input type="button" value="确定注册" class="login_m" onclick="submit_reg()" />
    </form>
    <div class="login_bot">已有账号？<a href="javascript:void(0);" class="quick_lo">快速登录</a>。</div>
</div>
<div class="i_close"><img src="/static/default/images/s_icon/i-close.png" /></div>
<script>
    window._bd_share_config={"common":{"bdSnsKey":{},"bdText":"","bdMini":"2","bdPic":"","bdPopupOffsetLeft":"-160","bdPopupOffsetTop":"-15","bdStyle":"0","bdSize":"16"},"share":{}};with(document)0[(getElementsByTagName('head')[0]||body).appendChild(createElement('script')).src='http://bdimg.share.baidu.com/static/api/js/share.js?v=89860593.js?cdnversion='+~(-new Date()/36e5)];
    //登录  注册
    $('.relo_div .login_a,.relo_div .quick_lo,.user .login').click(function(){
        hide();
        cmask();
        $('.register_div').hide();
        $('.i_close').show();
        $('.login_div').fadeIn();
    })
    $('.relo_div .register_a,.relo_div .quick_re,.user .reg').click(function(){
        hide();
        cmask();
        $('.login_div').hide();
        $('.i_close').show();
        $('.register_div').fadeIn();
    })
    $('.i_close').click(function(){
        hide();
        $('.login_div,.register_div').fadeOut();
        $(this).hide();
    })
</script>
<script type="text/javascript">
    function submit_reg()
    {
        var u = $('#reg_u').val();
        var p = $('#reg_p').val();
        var tel = $('#reg_tel').val();
        var code = $('#reg_code').val();

        if (u.length < 6 || u.length > 32) {
            alert('用户名6~32位');
            return false;
        }
        if (p.length < 6 || p.length > 32) {
            alert('密码6~32位');
            return false;
        }

        $.post('/user/reg', {u:u, p:p, tel:tel, code: code}, function(msg){
            msg = eval ('(' + msg + ')');
            if (msg.code == '1') {
                window.location.reload();
                return;
            } else {
                alert(msg.msg);
                return;
            }
        })
    }
    function submit_login()
    {
        var u = $('#login_u').val();
        var p = $('#login_p').val();
        var code = $('#login_code').val();

        $.post('/user/login', {u:u, p:p, code: code}, function(msg){
            msg = eval ('(' + msg + ')');
            if (msg.code == '1') {
                window.location.reload();
                return;
            } else {
                alert(msg.msg);
                return;
            }
        })
    }
</script>
<div class="head_div">
    <a href="#" class="logo"><img src="/static/default/images/replace/logo.png" height="87" /></a>
    <div class="location">南昌 <span><img src="/static/default/images/arrow/img-down.png" /></span></div>
    <ul class="nav_ul">
                <li><a href="/home/" class="nav-1 ">首页</a></li>
        <li><a href="/cases/" class="nav-2 ">案例</a></li>
        <li><a href="/package/" class="nav-3 ">套餐</a></li>
        <li><a href="/team/" class="nav-4 hover">团队</a></li>
        <li><a href="/material/" class="nav-5 ">材料</a></li>
        <li><a href="/project/" class="nav-6 ">工程</a></li>
        <li><a href="/mall/" class="nav-7 " >商城</a></li>
        <li><a href="/raiders/" class="nav-8 ">装修攻略</a></li>
    </ul>
</div><div class="main_div">
	<div class="main_box">
    	<div class="te_location">当前位置：<a href="/">首页</a> > <a href="/team/">团队</a></div>
        <div class="assort_div">
            <form method="get" action="" id="form">
                                <input type="hidden" id="exp_cid" name="exp_cid" value="" />
                <input type="hidden" id="title_cid" name="title_cid" value="" />
                <input type="hidden" id="style" name="style" value="" />
        	<div class="list">
            	<div class="name">经验</div>
                <div class="right_a">
                    <a href="#" class="hover" onclick="return search_team('exp_cid', '')">全部</a>
                    <a href="#"  onclick="return search_team('exp_cid', 1)">2年</a><a href="#"  onclick="return search_team('exp_cid', 2)">3~6年</a><a href="#"  onclick="return search_team('exp_cid', 3)">6年以上</a>                </div>
            </div>
        	<div class="list">
            	<div class="name">级别</div>
                <div class="right_a">
                    <a href="#" class="hover" onclick="return search_team('title_cid', '')">全部</a>
                    <a href="#"  onclick="return search_team('title_cid', 1)">设计总监</a><a href="#"  onclick="return search_team('title_cid', 2)">专家设计师</a>                </div>
            </div>
        	<div class="list" style="display: none">
            	<div class="name">擅长</div>
                <div class="right_a">
                    <a href="#" class="hover" onclick="return search_team('style', '')">全部</a>
                    <a href="#"  onclick="return search_team('style', 1)">美式乡村</a><a href="#"  onclick="return search_team('style', 2)">现代简约</a><a href="#"  onclick="return search_team('style', 3)">田园风格</a><a href="#"  onclick="return search_team('style', 4)">欧式风格</a><a href="#"  onclick="return search_team('style', 5)">中式风格</a><a href="#"  onclick="return search_team('style', 6)">地中海</a><a href="#"  onclick="return search_team('style', 7)">混搭风格</a><a href="#"  onclick="return search_team('style', 8)">古典风格</a>                </div>
            </div>
            </form>
        </div>
        <div class="team_div">
                            <div class="group_list">
                    <a href="/team/detail/des-8.html" class="pic"><img src="/upload/image/170215/4_58a3e5d2a65ec.jpg" width="140"
                                                             height="140"/></a>

                    <div class="topic">谢旺<span>专家设计师</span></div>
                    <div class="intro">设计应有如中医的理念，调和系统以治疗有病的人，而非仅仅针对疾病本身。</div>
                    <div class="list">
                                                    <a href="/cases/detail/c-21.html"><img src="/upload/image/170211/4_589e698ad74f2.jpg" width="75" height="60"/></a>
                                                        <a href="/cases/detail/c-16.html"><img src="/upload/image/170209/4_589c15ac1ed03.png" width="75" height="60"/></a>
                                                </div>
                </div>
                                <div class="group_list">
                    <a href="/team/detail/des-7.html" class="pic"><img src="/upload/image/170205/4_58968e7de7fc8.jpg" width="140"
                                                             height="140"/></a>

                    <div class="topic">杨长鹏<span>专家设计师</span></div>
                    <div class="intro">设计生活才是设计的本身，做切实提升客户生活品质的设计。</div>
                    <div class="list">
                                                    <a href="/cases/detail/c-17.html"><img src="/upload/image/170209/4_589c1639a8841.jpg" width="75" height="60"/></a>
                                                        <a href="/cases/detail/c-15.html"><img src="/upload/image/170209/4_589c14eecec52.jpg" width="75" height="60"/></a>
                                                </div>
                </div>
                                <div class="group_list">
                    <a href="/team/detail/des-6.html" class="pic"><img src="/upload/image/170215/4_58a3e5ed62458.jpg" width="140"
                                                             height="140"/></a>

                    <div class="topic">孙慧敏<span>专家设计师</span></div>
                    <div class="intro">设计源于生活，细节成就品质。</div>
                    <div class="list">
                                                    <a href="/cases/detail/c-24.html"><img src="/upload/image/170211/4_589e6b5dda3ff.jpg" width="75" height="60"/></a>
                                                        <a href="/cases/detail/c-6.html"><img src="/upload/image/170207/4_58996953b3e2c.jpg" width="75" height="60"/></a>
                                                </div>
                </div>
                                <div class="group_list">
                    <a href="/team/detail/des-5.html" class="pic"><img src="/upload/image/170215/4_58a3e5fc27583.jpg" width="140"
                                                             height="140"/></a>

                    <div class="topic">邱萌<span>专家设计师</span></div>
                    <div class="intro">从总体规划到细节设计，为您提供完美服务。作为一名女性设计师，每次做设计都格外的关注储藏和收纳，整洁有序才是正确的打开方式。客户提出的要求会认真领会，随时与客户沟通共同完成双方心中优秀的方案。</div>
                    <div class="list">
                                                    <a href="/cases/detail/c-10.html"><img src="/upload/image/170207/4_58997915910cb.jpg" width="75" height="60"/></a>
                                                        <a href="/cases/detail/c-9.html"><img src="/upload/image/170207/4_589978b36b91c.jpg" width="75" height="60"/></a>
                                                        <a href="/cases/detail/c-2.html"><img src="/upload/image/170205/4_58967e88b3494.jpg" width="75" height="60"/></a>
                                                </div>
                </div>
                                <div class="group_list">
                    <a href="/team/detail/des-4.html" class="pic"><img src="/upload/image/170215/4_58a3e6136cd6e.jpg" width="140"
                                                             height="140"/></a>

                    <div class="topic">张敏<span>专家设计师</span></div>
                    <div class="intro">设计来源于生活，回归于生活。而我为你打造的就是简约而不简单的家居设计。</div>
                    <div class="list">
                                                    <a href="/cases/detail/c-23.html"><img src="/upload/image/170211/4_589e6afa4c4fe.jpg" width="75" height="60"/></a>
                                                        <a href="/cases/detail/c-22.html"><img src="/upload/image/170211/4_589e6a22d9e77.jpg" width="75" height="60"/></a>
                                                        <a href="/cases/detail/c-11.html"><img src="/upload/image/170209/4_589c125310796.jpg" width="75" height="60"/></a>
                                                </div>
                </div>
                                <div class="group_list">
                    <a href="/team/detail/des-3.html" class="pic"><img src="/upload/image/170215/4_58a3e6206c7d1.jpg" width="140"
                                                             height="140"/></a>

                    <div class="topic">朱雄军<span>专家设计师</span></div>
                    <div class="intro">自然品质的物质家园，不是简单地将自然要素引入室内，而是结合地方的自然环境特征进行创造性地营造环境特征进行创造性地营造。</div>
                    <div class="list">
                                                    <a href="/cases/detail/c-19.html"><img src="/upload/image/170211/4_589e684c247f3.jpg" width="75" height="60"/></a>
                                                        <a href="/cases/detail/c-7.html"><img src="/upload/image/170207/4_58996c50ac169.jpg" width="75" height="60"/></a>
                                                        <a href="/cases/detail/c-4.html"><img src="/upload/image/170207/4_58996546de2b4.jpg" width="75" height="60"/></a>
                                                </div>
                </div>
                                <div class="group_list">
                    <a href="/team/detail/des-2.html" class="pic"><img src="/upload/image/170215/4_58a3e630bad26.jpg" width="140"
                                                             height="140"/></a>

                    <div class="topic">朱永建<span>专家设计师</span></div>
                    <div class="intro">专注于室内外空间的设计与表达，擅长处理复杂而多变的功能空间；专注别墅豪宅、样板房设计；设计是取之于人而服务于人，根据人们的不足和所需，提供人于便利和舒适这才是设计的本能……</div>
                    <div class="list">
                                                    <a href="/cases/detail/c-27.html"><img src="/upload/image/170211/4_589e6cf8cd8f1.jpg" width="75" height="60"/></a>
                                                        <a href="/cases/detail/c-26.html"><img src="/upload/image/170211/4_589e6c74af730.jpg" width="75" height="60"/></a>
                                                        <a href="/cases/detail/c-14.html"><img src="/upload/image/170209/4_589c148282694.jpg" width="75" height="60"/></a>
                                                </div>
                </div>
                                <div class="group_list">
                    <a href="/team/detail/des-1.html" class="pic"><img src="/upload/image/170215/4_58a3e63de8388.jpg" width="140"
                                                             height="140"/></a>

                    <div class="topic">南朝（熊威）<span>设计总监</span></div>
                    <div class="intro">设计源于生活却高于生活，我的工作就是为客户实实在在解决问题并为其创造价值及附加值，生活中成为朋友，我每年不定期赴国外学习考察，前后很荣幸能为五百多位业主服务……</div>
                    <div class="list">
                                                    <a href="/cases/detail/c-25.html"><img src="/upload/image/170211/4_589e6bd88f5dd.jpg" width="75" height="60"/></a>
                                                        <a href="/cases/detail/c-20.html"><img src="/upload/image/170211/4_589e68c6dfec7.jpg" width="75" height="60"/></a>
                                                        <a href="/cases/detail/c-18.html"><img src="/upload/image/170209/4_589c16f1bc4ed.jpg" width="75" height="60"/></a>
                                                </div>
                </div>
                        </div>
        <div class="m-content-footer" style="margin-left: 30px"><div class="x_pagenobox"><div class="totaltitle">共<span class="totalCount">8</span>项 页码： </div><div class="paginator"><span class="this-page">1</span></div></div></div>
    </div>
</div>
<div class="footerdiv">
    <div class="footer">
        <a href="#" target="_blank" class="foot_list foot_logo"></a>
        <dl class="foot_list">
            <dt><img src="/static/default/images/s_icon/foot-1.png" /> 关于我们</dt>
            <dd><a href="/raiders/detail/a-7.html">公司简介</a></dd>
            <dd><a href="/raiders/detail/a-8.html">企业文化</a></dd>
            <dd><a href="/raiders/detail/a-9.html">招贤纳士</a></dd>
            <dd><a href="/raiders/detail/a-10.html">联系我们</a></dd>
        </dl>
        <dl class="foot_list">
            <dt><img src="/static/default/images/s_icon/foot-2.png" /> 家装资讯</dt>
            <dd><a href="/raiders/c-3.html">公司新闻</a></dd>
            <dd><a href="/raiders/c-4.html">行业动态</a></dd>
            <dd><a href="/raiders/c-2.html">装修攻略</a></dd>
        </dl>
        <dl class="foot_list">
            <dt><img src="/static/default/images/s_icon/foot-3.png" /> 服务支持</dt>
            <dd><a href="/raiders/detail/a-11.html">服务范围</a></dd>
            <dd><a href="/raiders/detail/a-12.html">售后政策</a></dd>
            <dd><a href="/raiders/detail/a-13.html">客服服务</a></dd>
            <dd><a href="/raiders/detail/a-14.html">常见问题</a></dd>
        </dl>
        <dl class="foot_list">
            <dt>
                <img src="/static/default/images/s_icon/foot-4.png" /> 关注微信
            </dt>
            <dd class="wechat">
<!--                <img src="/static/default/images/replace/code.jpg" width="90" height="90" />-->
                <img src="/upload/image/170209/4_589bc2dad65d9.jpg" width="90" height="90" />
            </dd>
        </dl>
        <dl class="foot_list" style="width:208px;">
            <dd class="foot-last">服务热线</dd>
            <dd class="foot-ftel">13667007868</dd>
            <dd class="foot-date">全年365天8:30 - 23:00</dd>
            <dd class="foot-kf"><a href="http://wpa.qq.com/msgrd?v=3&uin=289663630&site=qq&menu=yes">在线客服</a></dd>
        </dl>
    </div>
</div>
<div class="copyrightdiv">
    <div class="copyright">All Rights Reserved 版权所有：南昌南泰建筑装饰有限公司　赣ICP备16009460号-1　地址：南昌市青山湖南大道香江建材市场东一门正对面　技术支持：<a href="http://www.jxbh.cn" target="_blank">百恒网络</a></div>
</div>
<div class="nt-fixright">
    <a href="http://wpa.qq.com/msgrd?v=3&uin=289663630&site=qq&menu=yes" target="_blank"><div class="nt-fixqq" title="点击QQ交谈"></div></a>
    <div class="nt-fixtel">
        <div class="nt-fixhide"></div>
        <div class="nt-fixhidetel">13667007868</div>
    </div>
    <a href="http://wpa.qq.com/msgrd?v=3&uin=289663630&site=qq&menu=yes" target="_blank" class="nt-baiduqiao"></a>
    <div class="nt-fixweixin">
        <div class="nt-fixweixinhide">
            <img src="/upload/image/170209/4_589bc2dad65d9.jpg" width="135" alt="扫一扫关注微信公众号">
        </div>
    </div>
    <div class="nt-fixtop"></div>
</div>
<script type="text/javascript">
    var _hmt = _hmt || [];
    (function() {
        var hm = document.createElement("script");
        hm.src = "https://hm.baidu.com/hm.js?37d38f2c56ce7310184a439e963f49a0";
        var s = document.getElementsByTagName("script")[0];
        s.parentNode.insertBefore(hm, s);
    })();
</script>
<script type="text/javascript">
    function search_team(id, val) {
        $('#' + id).val(val);
        $('#form').submit();
        return false;
    }
</script>
</body>
</html>