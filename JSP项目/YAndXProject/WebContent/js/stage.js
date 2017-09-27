function validateStu() {
	var email = document.getElementById("email").value;
	var pwd = document.getElementById("pwd").value;
	var name = document.getElementById("name").value;
	var phone = document.getElementById("phone").value;
	var Array
	if (email == null || eamil == undefined || no.trim() == "" || pwd == null || pwd == undefined || pwd.trim() == "") {
		errMsgSpan.innerHTML = "请输入账号和密码！";
		return false;
	}
	return true;
}