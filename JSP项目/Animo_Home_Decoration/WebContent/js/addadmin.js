function add(strEmail) { 
	var emailReg = /^[\w-]+(\.[\w-]+)*@[\w-]+(\.[\w-]+)+$/; 
	$.post("/Animo_Home_Decoration/Animo/Bnimo/Cnimo/add",
			$("#form").serialize(),
			function (data) {
		if(data.info == 'email'){
			var emailspan = document.getElementById("emailspan");
			emailspan.innerHTML="邮箱已被注册";
			emailspan.style.color="red";
			return;
		}
		if(data.info == 'defeated'){
			var emailspan = document.getElementById("info");
			emailspan.innerHTML="请填写内容";
			emailspan.style.color="red";
			return;
		}
		if(data.info == 'succeed'){
			alert("添加成功");
			window.location = "/Animo_Home_Decoration/Animo/Bnimo/Cnimo/addinterface";
		}
		}, "JSON");
	} 

function email(strEmail) { 
	var emailReg = /^[\w-]+(\.[\w-]+)*@[\w-]+(\.[\w-]+)+$/; 
	$.post("/Animo_Home_Decoration/Animo/Bnimo/Cnimo/add",
			$("#form").serialize(),
			function (data) {
		if(data.info == 'email'){
			var emailspan = document.getElementById("emailspan");
			emailspan.innerHTML="邮箱已被注册";
			emailspan.style.color="red";
			return;
		}
		}, "JSON");
	} 


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