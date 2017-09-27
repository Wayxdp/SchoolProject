<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	String path = request.getContextPath();
%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="UTF-8">
<title>个人中心</title>
<link rel="icon" href="<%=path %>/images/inco.png" type="image/x-icon"/>
	<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <meta name="keywords" content="首页">
    <meta name="description" content="首页">

    <!--[if lt IE 9]>
    <meta http-equiv="refresh" content="0;ie.html" />
    <![endif]-->

    <link rel="shortcut icon" href="favicon.ico">
    <link href="<%=path %>/css/bootstrap.min14ed.css?v=3.3.6" rel="stylesheet">
    <link href="<%=path %>/css/font-awesome.min93e3.css?v=4.4.0" rel="stylesheet">
    <link href="<%=path %>/css/animate.min.css" rel="stylesheet">
    <link href="<%=path %>/css/style.min862f.css?v=4.1.0" rel="stylesheet">
</head>
<body  class="fixed-sidebar full-height-layout gray-bg" style="overflow:hidden">
 <div id="wrapper">
        <!--左侧导航开始-->
        <nav class="navbar-default navbar-static-side" role="navigation">
            <div class="nav-close"><i class="fa fa-times-circle"></i>
            </div>
            
            <c:if test="${sessionScope.admin!=null }">
            <div class="sidebar-collapse">
                <ul class="nav" id="side-menu">
                    <li class="nav-header">
                        <div class="dropdown profile-element">
                            <span><img style="width: 80px;height: 80px;" alt="image" class="img-circle" src="<%=path %>/images/12312.gif" /></span>
                            <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                                <span class="clear">
                               <span class="block m-t-xs"><strong class="font-bold">${sessionScope.admin.name }</strong></span>
                                <span class="text-muted text-xs block">${sessionScope.admin.role }<b class="caret"></b></span>
                                </span>
                            </a>
                            <ul class="dropdown-menu animated fadeInRight m-t-xs">
                                <li><a href="<%=path%>/Animo/Bnimo/Cnimo/log_out_safely">安全退出</a>
                                </li>
                            </ul>
                        </div>
                        <div class="logo-element">康泰家装
                        </div>
                    </li>
                    <li>
                        <a href="#">
                            <i class="fa fa-home"></i>
                            <span class="nav-label" >个人中心</span>
                            <span class="fa arrow"></span>
                        </a>
                        <ul class="nav nav-second-level">
                            <li>
                                <a class="J_menuItem" href="<%=path %>/Animo/Bnimo/Cnimo/data" data-index="0">基本信息</a>
                            </li>
                            <li>
                                <a class="J_menuItem" href="<%=path %>/Animo/Bnimo/Cnimo/updatedata">修改密码</a>
                            </li>
                            <li>
                            <c:choose>
                               <c:when test="${sessionScope.admin.role == '超级管理员' }"><a class="J_menuItem" href="<%=path %>/Animo/Bnimo/Cnimo/addinterface">添加管理员</a></c:when> 
                            </c:choose>
                            </li>
                        </ul>

                    </li>
                    <li>
                        <a href="#">
                            <i class="fa fa fa-bar-chart-o"></i>
                            <span class="nav-label">装修公司管理</span>
                            <span class="fa arrow"></span>
                        </a>
                        <ul class="nav nav-second-level">
                            <li>
                                <a class="J_menuItem" href="<%=path%>/Animo/Bnimo/Cnimo/companys">所有装修公司</a>
                            </li>
                        </ul>
                          <ul class="nav nav-second-level">
                            <li>
                                <a class="J_menuItem" href="<%=path%>/Animo/Bnimo/Cnimo/checkcompany">装修公司审核</a>
                            </li>
                        </ul>
                    </li>

                    <li>
                        <a href="#">
                            <i class="fa fa-desktop"></i>
                            <span class="nav-label">设计师管理</span>
                            <span class="fa arrow"></span>
                        </a>
                        <ul class="nav nav-second-level">
                            <li>
                                <a class="J_menuItem" href="<%=path%>/Animo/Bnimo/Cnimo/desigeners">所有设计师</a>
                            </li>
                        </ul>
                        <ul class="nav nav-second-level">
                            <li>
                                <a class="J_menuItem" href="<%=path %>/Animo/Bnimo/Cnimo/allcheckdesigner">设计师审核</a>
                            </li>
                        </ul>
                    </li>

                    <li>
                        <a href="#">
                            <i class="fa fa-flask"></i>
                            <span class="nav-label">建材商管理</span>
                            <span class="fa arrow"></span>
                        </a>
                        <ul class="nav nav-second-level">
                            <li>
                                <a class="J_menuItem" href="<%=path%>/Animo/Bnimo/Cnimo/supplys">所有建材商</a>
                            </li>
                        </ul>
                        <ul class="nav nav-second-level">
                            <li>
                                <a class="J_menuItem" href="<%=path%>/Animo/Bnimo/Cnimo/checksupply">建材商审核</a>
                            </li>
                        </ul>
                    </li>

                    <li>
                        <a href="#">
                            <i class="fa fa-picture-o"></i>
                            <span class="nav-label">业主管理</span>
                            <span class="fa arrow"></span>
                        </a>
                        <ul class="nav nav-second-level">
                            <li>
                                <a class="J_menuItem" href="<%=path%>/Animo/Bnimo/Cnimo/customers">所有业主</a>
                            </li>
                        </ul>
                    </li>

                    <li>
                        <a href="#">
                            <i class="fa fa-table"></i>
                            <span class="nav-label">系统管理</span>
                            <span class="fa arrow"></span>
                        </a>
                        <ul class="nav nav-second-level">
                            <li>
                             <c:choose>
                               <c:when test="${sessionScope.admin.role == '超级管理员' }"><a class="J_menuItem" href="<%=path %>/Animo/Bnimo/Cnimo/alladmin">所有管理员</a></c:when> 
                            </c:choose>
                            </li>
                        </ul>
                    </li>

                </ul>
            </div>
            </c:if>
            
            <c:if test="${sessionScope.company1 !=null }">
            	<div class="sidebar-collapse">
                <ul class="nav" id="side-menu">
                    <li class="nav-header">
                        <div class="dropdown profile-element">
                            <span><img style="width: 80px;height: 80px;" alt="image" class="img-circle" src="<%=path %>/${sessionScope.company1.logo}" /></span>
                            <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                                <span class="clear">
                               <span class="block m-t-xs"><strong class="font-bold">${sessionScope.company1.company_name}</strong></span>
                                <span class="text-muted text-xs block">装修公司<b class="caret"></b></span>
                                </span>
                            </a>
                            <ul class="dropdown-menu animated fadeInRight m-t-xs">
                                <li><a href="<%=path%>/company/log_out_safely">安全退出</a>
                                </li>
                            </ul>
                        </div>
                        <div class="logo-element">康泰家装
                        </div>
                    </li>
                    <li>
                        <a href="#">
                            <i class="fa fa-home"></i>
                            <span class="nav-label" >个人中心</span>
                            <span class="fa arrow"></span>
                        </a>
                        <ul class="nav nav-second-level">
                            <li>
                                <a class="J_menuItem" href="<%=path%>/company/data" data-index="0">基本信息</a>
                            </li>
                            <li>
                                <a class="J_menuItem" href="<%=path%>/company/change_password">修改密码</a>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <a href="#">
                            <i class="fa fa fa-bar-chart-o"></i>
                            <span class="nav-label">用户管理</span>
                            <span class="fa arrow"></span>
                        </a>
                        <ul class="nav nav-second-level">
                            <li>
                                <a class="J_menuItem" href="<%=path%>/company/make_an_appointment">预约用户</a>
                            </li>
                        </ul>
                          <ul class="nav nav-second-level">
                            <li>
                                <a class="J_menuItem" href="#">用户咨询</a>
                            </li>
                        </ul>
                    </li>
					
					 <li>
                        <a href="#">
                            <i class="fa fa fa-bar-chart-o"></i>
                            <span class="nav-label">活动管理</span>
                            <span class="fa arrow"></span>
                        </a>
                        <ul class="nav nav-second-level">
                            <li>
                                <a class="J_menuItem" href="<%=path%>/company/Upload_the_activity">添加活动</a>
                            </li>
                        </ul>
                        <ul class="nav nav-second-level">
                            <li>
                                <a class="J_menuItem" href="<%=path%>/company/activityinterface">所有活动</a>
                            </li>
                        </ul>
                    </li>
					
                    <li>
                        <a href="#">
                            <i class="fa fa-desktop"></i>
                            <span class="nav-label">设计案例</span>
                            <span class="fa arrow"></span>
                        </a>
                        <ul class="nav nav-second-level">
                            <li>
                                <a class="J_menuItem" href="<%=path%>/company/show_cases">所有案例</a>
                            </li>
                        </ul>
                        <ul class="nav nav-second-level">
                            <li>
                                <a class="J_menuItem" href="<%=path%>/company/Case_to_upload">上传案例</a>
                            </li>
                        </ul>
                    </li>
                </ul>
            </div>
            </c:if>
            
             <c:if test="${sessionScope.supply1 !=null }">
            	<div class="sidebar-collapse">
                <ul class="nav" id="side-menu">
                    <li class="nav-header">
                        <div class="dropdown profile-element">
                            <span><img style="width: 80px;height: 80px;" alt="image" class="img-circle" src="<%=path %>/${sessionScope.supply1.logo}" /></span>
                            <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                                <span class="clear">
                               <span class="block m-t-xs"><strong class="font-bold">${sessionScope.supply1.name}</strong></span>
                                <span class="text-muted text-xs block">建材商<b class="caret"></b></span>
                                </span>
                            </a>
                            <ul class="dropdown-menu animated fadeInRight m-t-xs">
                                <li><a href="<%=path%>/supply/log_out_safely">安全退出</a>
                                </li>
                            </ul>
                        </div>
                        <div class="logo-element">康泰家装
                        </div>
                    </li>
                    <li>
                        <a href="#">
                            <i class="fa fa-home"></i>
                            <span class="nav-label" >个人中心</span>
                            <span class="fa arrow"></span>
                        </a>
                        <ul class="nav nav-second-level">
                            <li>
                                <a class="J_menuItem" href="<%=path %>/supply/data" data-index="0">基本信息</a>
                            </li>
                            <li>
                                <a class="J_menuItem" href="<%=path%>/supply/change_password">修改密码</a>
                            </li>
                        </ul>

                    </li>
                    <li>
                        <a href="#">
                            <i class="fa fa fa-bar-chart-o"></i>
                            <span class="nav-label">用户管理</span>
                            <span class="fa arrow"></span>
                        </a>
                        <ul class="nav nav-second-level">
                            <li>
                                <a class="J_menuItem" href="<%=path%>/supply/make_an_appointment">预约用户</a>
                            </li>
                        </ul>
                          <ul class="nav nav-second-level">
                            <li>
                                <a class="J_menuItem" href="#">用户咨询</a>
                            </li>
                        </ul>
                    </li>
					
					 <li>
                        <a href="#">
                            <i class="fa fa fa-bar-chart-o"></i>
                            <span class="nav-label">活动管理</span>
                            <span class="fa arrow"></span>
                        </a>
                        <ul class="nav nav-second-level">
                            <li>
                                <a class="J_menuItem" href="<%=path%>/supply/Upload_the_activity">添加活动</a>
                            </li>
                        </ul>
                          <ul class="nav nav-second-level">
                            <li>
                                <a class="J_menuItem" href="<%=path%>/supply/show_activiy">所有活动</a>
                            </li>
                        </ul>
                    </li>
                          <li>
                        <a href="#">
                            <i class="fa fa-desktop"></i>
                            <span class="nav-label">建材商品</span>
                            <span class="fa arrow"></span>
                        </a>
                        <ul class="nav nav-second-level">
                            <li>
                                <a class="J_menuItem" href="<%=path%>/supply/products">所有建材</a>
                            </li>
                        </ul>
                        <ul class="nav nav-second-level">
                            <li>
                                <a class="J_menuItem" href="<%=path%>/supply/Upload_the_goods">上传建材</a>
                            </li>
                        </ul>
                    </li>
                </ul>
            </div>
            </c:if>
            
            <c:if test="${sessionScope.designer1 !=null }">
            	<div class="sidebar-collapse">
                <ul class="nav" id="side-menu">
                    <li class="nav-header">
                        <div class="dropdown profile-element">
                            <span><img style="width: 80px;height: 80px;" alt="image" class="img-circle" src="<%=path %>/${sessionScope.designer1.headicon}" /></span>
                            <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                                <span class="clear">
                               <span class="block m-t-xs"><strong class="font-bold">${sessionScope.designer1.name}</strong></span>
                                <span class="text-muted text-xs block">设计师<b class="caret"></b></span>
                                </span>
                            </a>
                            <ul class="dropdown-menu animated fadeInRight m-t-xs">
                                <li><a href="<%=path%>/designer/log_out_safely">安全退出</a>
                                </li>
                            </ul>
                        </div>
                        <div class="logo-element">康泰家装
                        </div>
                    </li>
                    <li>
                        <a href="#">
                            <i class="fa fa-home"></i>
                            <span class="nav-label" >个人中心</span>
                            <span class="fa arrow"></span>
                        </a>
                        <ul class="nav nav-second-level">
                            <li>
                                <a class="J_menuItem" href="<%=path %>/designer/data" data-index="0">基本信息</a>
                            </li>
                            <li>
                                <a class="J_menuItem" href="<%=path%>/designer/change_password">修改密码</a>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <a href="#">
                            <i class="fa fa fa-bar-chart-o"></i>
                            <span class="nav-label">用户管理</span>
                            <span class="fa arrow"></span>
                        </a>
                        <ul class="nav nav-second-level">
                            <li>
                                <a class="J_menuItem" href="<%=path%>/designer/make_an_appointment">预约用户</a>
                            </li>
                        </ul>
                          <ul class="nav nav-second-level">
                            <li>
                                <a class="J_menuItem" href="<%=path%>/designer/allConsult">用户咨询</a>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <a href="#">
                            <i class="fa fa-desktop"></i>
                            <span class="nav-label">设计案例</span>
                            <span class="fa arrow"></span>
                        </a>
                        <ul class="nav nav-second-level">
                            <li>
                                <a class="J_menuItem" href="<%=path%>/designer/show_cases">所有案例</a>
                            </li>
                        </ul>
                        <ul class="nav nav-second-level">
                            <li>
                                <a class="J_menuItem" href="<%=path%>/designer/Case_to_upload">上传案例</a>
                            </li>
                        </ul>
                    </li>
                </ul>
            </div>
            </c:if>
            
            <c:if test="${sessionScope.customer1 !=null }">
            	<div class="sidebar-collapse">
                <ul class="nav" id="side-menu">
                    <li class="nav-header">
                        <div class="dropdown profile-element">
                            <span><img style="width: 80px; height: 80px;" alt="image" class="img-circle" src="<%=path %>/images/12312.gif" /></span>
                            <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                                <span class="clear">
                               <span class="block m-t-xs"><strong class="font-bold">${sessionScope.customer1.name}</strong></span>
                                <span class="text-muted text-xs block">业主<b class="caret"></b></span>
                                </span>
                            </a>
                            <ul class="dropdown-menu animated fadeInRight m-t-xs">
                                <li><a href="<%=path%>/customer/log_out_safely">安全退出</a>
                                </li>
                            </ul>
                        </div>
                        <div class="logo-element">康泰家装
                        </div>
                    </li>
                    <li>
                        <a href="#">
                            <i class="fa fa-home"></i>
                            <span class="nav-label" >个人中心</span>
                            <span class="fa arrow"></span>
                        </a>
                        <ul class="nav nav-second-level">
                            <li>
                                <a class="J_menuItem" href="<%=path %>/customer/data" data-index="0">基本信息</a>
                            </li>
                            <li>
                                <a class="J_menuItem" href="<%=path%>/customer/change_password">修改密码</a>
                            </li>
                        </ul>

                    </li>
                    <li>
                        <a href="#">
                            <i class="fa fa fa-bar-chart-o"></i>
                            <span class="nav-label">收藏管理</span>
                            <span class="fa arrow"></span>
                        </a>
                        <ul class="nav nav-second-level">
                            <li>
                                <a class="J_menuItem" href="<%=path%>/customer/designercollect">设计师收藏</a>
                            </li>
                        </ul>
                          <ul class="nav nav-second-level">
                            <li>
                                <a class="J_menuItem" href="<%=path%>/customer/supplycollect">建材商收藏</a>
                            </li>
                        </ul>
                            <ul class="nav nav-second-level">
                            <li>
                                <a class="J_menuItem" href="<%=path%>/customer/companycollect">装修公司收藏</a>
                            </li>
                        </ul>
                    </li>
					
					     <li>
                        <a href="#">
                            <i class="fa fa fa-bar-chart-o"></i>
                            <span class="nav-label">预约管理</span>
                            <span class="fa arrow"></span>
                        </a>
                        <ul class="nav nav-second-level">
                            <li>
                                <a class="J_menuItem" href="<%=path%>/customer/designerorder">设计师预约</a>
                            </li>
                        </ul>
                            <ul class="nav nav-second-level">
                            <li>
                                <a class="J_menuItem" href="<%=path%>/customer/companyorder">装修公司预约</a>
                            </li>
                        </ul>
                    </li>
					
                    <li>
                        <a href="#">
                            <i class="fa fa-desktop"></i>
                            <span class="nav-label">案例收藏</span>
                            <span class="fa arrow"></span>
                        </a>
                        <ul class="nav nav-second-level">
                            <li>
                                <a class="J_menuItem" href="<%=path%>/customer/designercasecollect">设计师案例</a>
                            </li>
                        </ul>
                        <ul class="nav nav-second-level">
                            <li>
                                <a class="J_menuItem" href="<%=path%>/customer/companycasecollect">装修公司案例</a>
                            </li>
                        </ul>
                        <ul class="nav nav-second-level">
                            <li>
                                <a class="J_menuItem" href="<%=path%>/customer/productcollect">商品收藏案例</a>
                            </li>
                        </ul>
                    </li>
                </ul>
            </div>
            </c:if>
            
        </nav>
        <!--左侧导航结束-->
        <!--右侧部分开始-->
        <div id="page-wrapper" class="gray-bg dashbard-1">
            <div class="row border-bottom">
                <nav class="navbar navbar-static-top" role="navigation" style="margin-bottom: 0">
                    <div class="navbar-header"><a class="navbar-minimalize minimalize-styl-2 btn btn-primary " href="#"><i class="fa fa-bars"></i> </a></div>
                    <ul class="nav navbar-top-links navbar-right">
                        <li class="dropdown hidden-xs">
                            <a class="right-sidebar-toggle" aria-expanded="false">
                                <i class="fa fa-tasks"></i> 主题
                            </a>
                        </li>
                    </ul>
                </nav>
            </div>
            <div class="row content-tabs">
                <button class="roll-nav roll-left J_tabLeft"><i class="fa fa-backward"></i>
                </button>
                <nav class="page-tabs J_menuTabs">
                    <div class="page-tabs-content">
                        <a href="<%=path %>/background/adminindex.jsp" class="active J_menuTab" target="iframe0" data-id="index_v1.html">首页</a>
                    </div>
                </nav>
                <button class="roll-nav roll-right J_tabRight"><i class="fa fa-forward"></i>
                </button>
                <div class="btn-group roll-nav roll-right">
                    <button class="dropdown J_tabClose" data-toggle="dropdown">关闭操作<span class="caret"></span>

                    </button>
                    <ul role="menu" class="dropdown-menu dropdown-menu-right">
                        <li class="J_tabShowActive"><a>定位当前选项卡</a>
                        </li>
                        <li class="divider"></li>
                        <li class="J_tabCloseAll"><a>关闭全部选项卡</a>
                        </li>
                        <li class="J_tabCloseOther"><a>关闭其他选项卡</a>
                        </li>
                    </ul>
                </div>
                <a href="login.html" class="roll-nav roll-right J_tabExit"><i class="fa fa fa-sign-out"></i> 退出</a>
            </div>
            <div class="row J_mainContent" id="content-main">
                <iframe class="J_iframe" name="iframe0" width="100%" height="100%" src="<%=path %>/background/adminindex.jsp" frameborder="0" data-id="index_v1.html" seamless>
                </iframe>
            </div>
            <div class="footer">
                <div class="pull-right">Copyright&copy;Wgssmart</div>
            </div>
        </div>
        <!--右侧部分结束-->
        <!--右侧边栏开始-->
        <div id="right-sidebar">
            <div class="sidebar-container">

                <ul class="nav nav-tabs navs-3">

                    <li class="active">
                        <a data-toggle="tab" href="#tab-1">
                            <i class="fa fa-gear"></i> 主题
                        </a>
                    </li>
                </ul>

                <div class="tab-content">
                    <div id="tab-1" class="tab-pane active">
                        <div class="sidebar-title">
                            <h3> <i class="fa fa-comments-o"></i> 主题设置</h3>
                            <small><i class="fa fa-tim"></i> 你可以从这里选择和预览主题的布局和样式，这些设置会被保存在本地，下次打开的时候会直接应用这些设置。</small>
                        </div>
                        <div class="skin-setttings">
                            <div class="title">主题设置</div>
                            <div class="setings-item">
                                <span>收起左侧菜单</span>
                                <div class="switch">
                                    <div class="onoffswitch">
                                        <input type="checkbox" name="collapsemenu" class="onoffswitch-checkbox" id="collapsemenu">
                                        <label class="onoffswitch-label" for="collapsemenu">
                                            <span class="onoffswitch-inner"></span>
                                            <span class="onoffswitch-switch"></span>
                                        </label>
                                    </div>
                                </div>
                            </div>
                            <div class="setings-item">
                                <span>固定顶部</span>

                                <div class="switch">
                                    <div class="onoffswitch">
                                        <input type="checkbox" name="fixednavbar" class="onoffswitch-checkbox" id="fixednavbar">
                                        <label class="onoffswitch-label" for="fixednavbar">
                                            <span class="onoffswitch-inner"></span>
                                            <span class="onoffswitch-switch"></span>
                                        </label>
                                    </div>
                                </div>
                            </div>
                            <div class="setings-item">
                                <span>
                        固定宽度
                    </span>

                                <div class="switch">
                                    <div class="onoffswitch">
                                        <input type="checkbox" name="boxedlayout" class="onoffswitch-checkbox" id="boxedlayout">
                                        <label class="onoffswitch-label" for="boxedlayout">
                                            <span class="onoffswitch-inner"></span>
                                            <span class="onoffswitch-switch"></span>
                                        </label>
                                    </div>
                                </div>
                            </div>
                            <div class="title">皮肤选择</div>
                            <div class="setings-item default-skin nb">
                                <span class="skin-name ">
                         <a href="#" class="s-skin-0">
                             默认皮肤
                         </a>
                    </span>
                            </div>
                            <div class="setings-item blue-skin nb">
                                <span class="skin-name ">
                        <a href="#" class="s-skin-1">
                            蓝色主题
                        </a>
                    </span>
                            </div>
                            <div class="setings-item yellow-skin nb">
                                <span class="skin-name ">
                        <a href="#" class="s-skin-3">
                            黄色/紫色主题
                        </a>
                    </span>
                            </div>
                        </div>
                    </div>
                </div>

            </div>
        </div>
        <!--右侧边栏结束-->
    </div>
	<script src="<%=path %>/js/jquery.min.js?v=2.1.4"></script>
    <script src="<%=path %>/js/bootstrap.min.js?v=3.3.6"></script>
    <script src="<%=path %>/js/plugins/metisMenu/jquery.metisMenu.js"></script>
    <script src="<%=path %>/js/plugins/slimscroll/jquery.slimscroll.min.js"></script>
    <script src="<%=path %>/js/plugins/layer/layer.min.js"></script>
    <script src="<%=path %>/js/hplus.min.js?v=4.1.0"></script>
    <script type="text/javascript" src="<%=path %>/js/contabs.min.js"></script>
    <script src="<%=path %>/js/plugins/pace/pace.min.js"></script>
</body>
</html>