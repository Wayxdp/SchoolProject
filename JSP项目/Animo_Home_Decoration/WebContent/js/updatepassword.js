function adminemail(){
	$.post("/Animo_Home_Decoration/Animo/Bnimo/Cnimo/update",
			$("#form").serialize(),
			function (data) {
				if(data.info == 'nopwd'){
					var emailspan = document.getElementById("adminspan");
					emailspan.innerHTML="密码错误";
					emailspan.style.color="red";
					return;
		}
		}, "JSON");
}

function designeremail(){
	$.post("/Animo_Home_Decoration/designer/updatechange_password",
			$("#form").serialize(),
			function (data) {
				if(data.info == 'nopwd'){
					var emailspan = document.getElementById("adminspan");
					emailspan.innerHTML="密码错误";
					emailspan.style.color="red";
					return;
		}
		}, "JSON");
}

function companyemail(){
	$.post("/Animo_Home_Decoration/company/updatechange_password",
			$("#form").serialize(),
			function (data) {
				if(data.info == 'nopwd'){
					var emailspan = document.getElementById("adminspan");
					emailspan.innerHTML="密码错误";
					emailspan.style.color="red";
					return;
		}
		}, "JSON");
}

function customeremail(){
	$.post("/Animo_Home_Decoration/customer/updatechange_password",
			$("#form").serialize(),
			function (data) {
				if(data.info == 'nopwd'){
					var emailspan = document.getElementById("adminspan");
					emailspan.innerHTML="密码错误";
					emailspan.style.color="red";
					return;
		}
		}, "JSON");
}

function supplyemail(){
	$.post("/Animo_Home_Decoration/supply/updatechange_password",
			$("#form").serialize(),
			function (data) {
				if(data.info == 'nopwd'){
					var emailspan = document.getElementById("adminspan");
					emailspan.innerHTML="密码错误";
					emailspan.style.color="red";
					return;
		}
		}, "JSON");
}

function admin(){
	$.post("/Animo_Home_Decoration/Animo/Bnimo/Cnimo/update",
			$("#form").serialize(),
			function (data) {
		if(data.info == 'nopwd'){
			var emailspan = document.getElementById("adminspan");
			emailspan.innerHTML="密码错误";
			emailspan.style.color="red";
			return;
		}
		if(data.info == 'pwdlength'){
			var emailspan = document.getElementById("pwd1span");
			emailspan.innerHTML="密码长度小于6位";
			emailspan.style.color="red";
			return;
		}
		if(data.info == 'no'){
			var emailspan = document.getElementById("pwd2span");
			emailspan.innerHTML="密码不一致错误";
			emailspan.style.color="red";
			return;
		}
		if(data.info == 'defeated'){
			var emailspan = document.getElementById("info");
			emailspan.innerHTML="内容不能为空";
			emailspan.style.color="red";
			return;
		}
		if(data.info == 'succeed'){
			alert("修改成功");
			window.location = "/Animo_Home_Decoration/Animo/Bnimo/Cnimo/updatedata";
		}
		}, "JSON");
}

function supply(){
	$.post("/Animo_Home_Decoration/supply/change_password",
			$("#form").serialize(),
			function (data) {
		if(data.info == 'nopwd'){
			var emailspan = document.getElementById("adminspan");
			emailspan.innerHTML="密码错误";
			emailspan.style.color="red";
			return;
		}
		if(data.info == 'pwdlength'){
			var emailspan = document.getElementById("pwd1span");
			emailspan.innerHTML="密码长度小于6位";
			emailspan.style.color="red";
			return;
		}
		if(data.info == 'no'){
			var emailspan = document.getElementById("pwd2span");
			emailspan.innerHTML="密码不一致错误";
			emailspan.style.color="red";
			return;
		}
		if(data.info == 'defeated'){
			var emailspan = document.getElementById("info");
			emailspan.innerHTML="内容不能为空";
			emailspan.style.color="red";
			return;
		}
		if(data.info == 'succeed'){
			alert("修改成功");
			window.location = "/Animo_Home_Decoration/Animo/Bnimo/Cnimo/updatedata";
		}
		}, "JSON");
}

function designer(){
	$.post("/Animo_Home_Decoration/designer/updatechange_password",
			$("#form").serialize(),
			function (data) {
		if(data.info == 'nopwd'){
			var emailspan = document.getElementById("adminspan");
			emailspan.innerHTML="密码错误";
			emailspan.style.color="red";
			return;
		}
		if(data.info == 'pwdlength'){
			var emailspan = document.getElementById("pwd1span");
			emailspan.innerHTML="密码长度小于6位";
			emailspan.style.color="red";
			return;
		}
		if(data.info == 'no'){
			var emailspan = document.getElementById("pwd2span");
			emailspan.innerHTML="密码不一致错误";
			emailspan.style.color="red";
			return;
		}
		if(data.info == 'defeated'){
			var emailspan = document.getElementById("info");
			emailspan.innerHTML="内容不能为空";
			emailspan.style.color="red";
			return;
		}
		if(data.info == 'succeed'){
			alert("修改成功");
			window.location = "/Animo_Home_Decoration/designer/change_password";
		}
		}, "JSON");
}

function customer(){
	$.post("/Animo_Home_Decoration/customer/updatechange_password",
			$("#form").serialize(),
			function (data) {
		if(data.info == 'nopwd'){
			var emailspan = document.getElementById("adminspan");
			emailspan.innerHTML="密码错误";
			emailspan.style.color="red";
			return;
		}
		if(data.info == 'pwdlength'){
			var emailspan = document.getElementById("pwd1span");
			emailspan.innerHTML="密码长度小于6位";
			emailspan.style.color="red";
			return;
		}
		if(data.info == 'no'){
			var emailspan = document.getElementById("pwd2span");
			emailspan.innerHTML="密码不一致错误";
			emailspan.style.color="red";
			return;
		}
		if(data.info == 'defeated'){
			var emailspan = document.getElementById("info");
			emailspan.innerHTML="内容不能为空";
			emailspan.style.color="red";
			return;
		}
		if(data.info == 'succeed'){
			alert("修改成功");
			window.location = "/Animo_Home_Decoration/customer/change_password";
		}
		}, "JSON");
}

function company(){
	$.post("/Animo_Home_Decoration/company/updatechange_password",
			$("#form").serialize(),
			function (data) {
		if(data.info == 'nopwd'){
			var emailspan = document.getElementById("adminspan");
			emailspan.innerHTML="密码错误";
			emailspan.style.color="red";
			return;
		}
		if(data.info == 'pwdlength'){
			var emailspan = document.getElementById("pwd1span");
			emailspan.innerHTML="密码长度小于6位";
			emailspan.style.color="red";
			return;
		}
		if(data.info == 'no'){
			var emailspan = document.getElementById("pwd2span");
			emailspan.innerHTML="密码不一致错误";
			emailspan.style.color="red";
			return;
		}
		if(data.info == 'defeated'){
			var emailspan = document.getElementById("info");
			emailspan.innerHTML="内容不能为空";
			emailspan.style.color="red";
			return;
		}
		if(data.info == 'succeed'){
			alert("修改成功");
			window.location = "/Animo_Home_Decoration/company/change_password";
		}
		}, "JSON");
}

//判断新密码和旧密码是否一致
function check()  
{  
   var pwd2 = document.getElementById("pwd2");  
   var repassword = document.getElementById("repassword"); 
   var pwdspan = document.getElementById("pwd2span");
   if(pwd2.value==repassword.value)  
   {  
	   pwdspan.innerHTML="";
	   return true;
   }else{  
	   pwdspan.style.color="red";  
	   pwdspan.innerHTML="密码不一致错误";  
	   return false;
   }
}
//判断密码是否小于6位
function pwd(){
	 var pwd2 = document.getElementById("pwd2");
	 var pwd1span = document.getElementById("pwd1span");
	 if(pwd2.value.length<6){
			pwd1span.innerHTML="密码长度小于6位";
			pwd1span.style.color="red";
			return; 
	 }else{
		 pwd1span.innerHTML="";
		 return false;
	 }
}