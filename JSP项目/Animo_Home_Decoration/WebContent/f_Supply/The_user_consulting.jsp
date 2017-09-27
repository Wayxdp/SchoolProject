<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	String path = request.getContextPath();
%>
<html class="st2  oms">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<base href=".">
<title>康泰家装欢迎您！</title>
<link rel="icon" href="<%=path%>/images/inco.png" type="image/x-icon" />
<link rel="stylesheet" type="text/css"
	href="<%=path%>/css/default4.css">

<style type="text/css">
.main-color {
	background-color: #e41e26 !important
}
</style>
</head>
<body class="s1 lic10 lg-sc ">


	<div class="neck main-color" id="neck"></div>


	<div class="stage stage-nofoot" id="stage"
		style="height: 511px; width: 1202px;">
		<div class="inner msg-form">


			<form action="<%=path%>/supply/supplysucceed" name="leaveMessage"
				method="post">
				<input type="hidden" name="supplys" value="${requestScope.id }">

				<table width="95%" align="center" cellpadding="0" cellspacing="1">
					<tbody>
						<tr>
							<td class="tdHead">您的姓名：</td>
							<td><input name="name" type="text" size="50" id="name"
								class="text-1"><span class="required">*</span></td>
						</tr>

						<tr>
							<td class="tdHead">电话号码：</td>
							<td><input name="phone" type="text" id="phone" size="50"
								class="text-1"><span class="required">*</span></td>
						</tr>
						<tr>
							<td class="tdHead">电子邮件：</td>
							<td><input type="text" name="email" id="email" size="100"
								class="text-1"></td>
						</tr>
						<tr>
							<td class="tdHead">QQ号码：</td>
							<td><input type="text" name="qq" id="qq" size="50"
								class="text-1"></td>
						</tr>


						<tr>
							<td class="tdHead">留言内容：</td>
							<td><textarea name="message" id="message" cols="50" rows="5"
									class="textarea-1"></textarea><span class="required">*</span></td>
						</tr>
						<tr>
							<td class="tdHead"></td>
							<td>（<span class="required">*</span>）为必填项
							</td>
						</tr>
						<tr>
							<td height="45">
								<div align="center"></div>
							</td>
							<td>
								<table width="100%">
									<tbody>
										<tr>
											<td></td>
											<td width="40%"><input type="submit"
												style="width: 100px; height: 50px;" /></td>
											<td width="20%"></td>
										</tr>
									</tbody>
								</table>
							</td>
						</tr>
					</tbody>
				</table>

			</form>
			<div
				style="text-align: center; line-height: 50px; color: #CCC; margin: 0">
				powered by looyu</div>
		</div>
	</div>
	<div class="footer">
		<a class="license" href="http://www.talk99.cn/" target="_blank">&nbsp;</a>
	</div>

	<script type="text/javascript">
		var conf = {
			cardImage : 'http://jscss.dyrs.cc/icon/lyad3.png',
			deptName : '\u5BA2\u670D\u90E8',
			mail : '763625311@qq.com',
			visitorAuthen : false,
			permCustomizeUI : true,
			groupId : 10059956,
			missingTime : 5,
			meetingId : '',
			compName : '\u96C6\u56E2',
			mailLeaveMsg : true,
			robotNoAnswer : '',
			VId : 'f65fcf79135804e692faf769634e7f1a14',
			mainPage : 'http://www.talk99.cn',
			chatTypeTip : '',
			ad1Image : 'http://jscss.dyrs.cc/icon/lyad1.png',
			meeting : false,
			autoChat : 0,
			earlierMsg : true,
			phoneNoCode : 0,
			robotName : '',
			showLeaveMsg : true,
			winId : '31b1d276defc4585bdad27e5ba7ac100',
			showChatType : false,
			robotLink : '#',
			cardTarget : 'http://www.dyrs.com.cn/',
			custMissing : '\u975E\u5E38\u62B1\u6B49\uFF0C\u82E5\u56E0\u5BA2\u670D\u5FD9\u788C\u672A\u80FD\u53CA\u65F6\u56DE\u7B54\u60A8\u7684\u95EE\u9898\uFF0C\u8BF7\u7ED9\u6211\u4EEC\u7535\u8BDD\u6216\u8005\u53D1\u9001\u7535\u5B50\u90AE\u4EF6\u3002',
			version : 'static.soperson.com/cfile/talk99/160327',
			queueTimeoutTip : '',
			robotCard : '',
			license : 10,
			groupName : '\u96C6\u56E2\u804C\u5B88',
			excapeBusy : false,
			logoImage : 'http://jscss.dyrs.cc/icon/logo.jpg',
			compId : 20000192,
			phone : '13522565969',
			logoBKColor : '#FFFFFF',
			fontSize : 0,
			robotRedirect : 2,
			hello : '<a href=\"http://www.dyrs.com.cn/special/20170412/102565\" target=\"_blank\"><img src=\"http://img.dyrs.cc/store/939/275/000/34658ef47dc9c05c.jpg!c\" with=\"280\" alt=\"\" border=\"0\" /></a>',
			clientColor : '#e41e26',
			role : 0,
			chatId : -1,
			ad1Target : 'http://www.dyrs.com.cn/',
			compPhone : '13366409595',
			title : '\u4E1C\u6613\u65E5\u76DB\u6B22\u8FCE\u60A8\uFF01',
			autoOpinion : false,
			UId : 'ee7006c7be3ead4de500490de004657c76',
			clientStyle : 1,
			leaveMsgOption : 0,
			lang : 'sc',
			queueTip : '',
			ad2Target : 'http://www.dyrs.com.cn/',
			ad2Image : 'http://jscss.dyrs.cc/icon/lyad2.png',
			mobile : 0,
			showSelfSearch : false,
			logoTarget : 'http://www.dyrs.com.cn/',
			userName : 'jtkf501',
			command : 'leaveMessage',
			mobileChatColor : '',
			realName : '\u4E3D\u4E3D',
			showFreePhone : true,
			showSaveRecorder : true,
			service : '',
			robotHello : '',
			showQType : false,
			freePhoneId : '',
			siteId : 5418,
			miniStyle : '#ff5f53',
			queueTimeout : 0,
			queue : 0
		};
	</script>
	<script type="text/javascript" src="<%=path%>/js/util.js"></script>

</body>
</html>