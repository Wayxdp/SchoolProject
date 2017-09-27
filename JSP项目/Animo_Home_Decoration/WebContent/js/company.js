
//判断邮箱是否正确
function checkEmail(strEmail) { 
var emailReg = /^[\w-]+(\.[\w-]+)*@[\w-]+(\.[\w-]+)+$/; 
$.post("/Animo_Home_Decoration/customer/userreg",
		$("#form").serialize(),
		function (data) {
	if(data.info == 'email'){
		var emailspan = document.getElementById("emailspan");
		emailspan.innerHTML="邮箱已被注册";
		emailspan.style.color="red";
		return;
	}
	if( emailReg.test(strEmail.value) ){
		document.getElementById("emailspan").innerHTML="";
	}else{
		var emalispan =document.getElementById("emailspan");
		emalispan.innerHTML="邮箱格式错误";
		emalispan.style.color="red";
		return;
	}
	}, "JSON");
} 

function checkMobile( s ){   
	var regu =/^[1][3][0-9]{9}$/; 
	var re = new RegExp(regu); 
	if (re.test(s.value)) { 
		document.getElementById("phonespan").innerHTML="";
		return true; 
	}else{ 
		var phonespan =document.getElementById("phonespan")
		phonespan.innerHTML="手机号格式错误";
		phonespan.style.color="red";
		return false; 
	} 

}

//判断密码是否一致
function check()  
{  
   var pw1 = document.getElementById("pwd1");  
   var pw2 = document.getElementById("pwd2"); 
   var pwdspan = document.getElementById("pwd2span");
   if(pw1.value==pw2.value)  
   {  
	   pwdspan.innerHTML="";
	   return true;
   }else{  
	   pwdspan.style.color="red";  
	   pwdspan.innerHTML="密码不一致错误";  
	   return false;
   }
}

function pwd(){
	 var pwd1 = document.getElementById("pwd1");
	 var pwd1span = document.getElementById("pwd1span");
	 if(pwd1.value.length<6){
			pwd1span.innerHTML="密码长度小于6位";
			pwd1span.style.color="red";
			return; 
	 }else{
		 pwd1span.innerHTML="";
	 }
}

function reg() {
	$.post("/Animo_Home_Decoration/company/regverify", $("#form").serialize(),
			function(data) {
				if (data.info == 'email') {
					var emailspan = document.getElementById("emailspan");
					emailspan.innerHTML = "邮箱格式错误";
					emailspan.style.color = "red";
					return;
				}
				if (data.info == 'lengthpassword') {
					var pwd1span = document.getElementById("pwd1span");
					pwd1span.innerHTML = "密码长度小于6位";
					pwd1span.style.color = "red";
					return;
				}
				if (data.info == 'password') {
					var pwdspan = document.getElementById("pwd2span");
					pwdspan.innerHTML = "密码不一致";
					pwdspan.style.color = "red";
					return;
				}
				if (data.info == 'phone') {
					var phonespan = document.getElementById("phonespan");
					phonespan.innerHTML = "手机格式错误";
					phonespan.style.color = "red";
					return;
				}
				if (data.info == 'defeated') {
					var info = document.getElementById("info");
					info.innerHTML = "内容不能为空";
					info.style.color = "red";
					return;
				}
				if (data.info == 'succeed') {
					window.location = "/Animo_Home_Decoration/index/companylogin";
				}
			}, "JSON");
}



function login(){
	$.post("/Animo_Home_Decoration/company/loginverify", $("#form").serialize(),
			function(data) {
				if (data.info == 'noemail') {
					var emailspan = document.getElementById("emailspan");
					emailspan.innerHTML = "邮箱不存在";
					emailspan.style.color = "red";
					return;
				}
				if(data.info == 'password'){
					var pwdspan = document.getElementById("pwdspan");
					pwdspan.innerHTML = "密码错误";
					pwdspan.style.color = "red";
					return;
				}
				if(data.info == 'defeated'){
					var info = document.getElementById("info");
					info.innerHTML = "内容不为空";
					info.style.color = "red";
					return;
				}
				if(data.info == 'check'){
					var info = document.getElementById("info");
					info.innerHTML = "账号审核中";
					info.style.color = "red";
					return;
				}
				if(data.info == 'forbidden'){
					var info = document.getElementById("info");
					info.innerHTML = "账号被禁用";
					info.style.color = "red";
					return;
				}
				
				if (data.info == 'succeed') {
					window.location = "/Animo_Home_Decoration/";
				}
			}, "JSON");
}