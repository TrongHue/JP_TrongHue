/* cac xu ly kich ban cho login.html */
function checkValidLogin(fn){
	var message = "";

	var userName = fn.txtUserName.value;
	var userPass = fn.txtUserPass.value;

	var validUserName = true;
	var validUserPass = true;

	userName = userName.trim();
	userPass = userPass.trim();

	if(userName==""){
		validUserName = false;
		message = "Please input your usename \n";
	}
	else{
		if(userName.indexOf(" ")!= -1){
			validUserName = false;
			message = "Username don't have space\n"
		}
		else{
			if(userName.length > 100){
				validUserName = false;
				message = "Username too long\n"
			}
			else{
				if(userName.indexOf("@")!=-1||userName.indexOf(".")!=-1){
					var pattern = /\w+@\w+[.]\w/;
					if(!userName.match(pattern)){
						validUserName = false;
						message= "Email is not valid\n";
					}
				}
			}
	}
		}

	// Check valid user password
	if(userPass == ""){
		validUserPass = false;
		message += "Please input your password \n";
	}
	else{
		if(userPass.length<6){
			validUserPass = false;
			message += "Your user password is less than 6 character \n";
		}
	}

	// Show message
	if(message!=""){
		window.alert(message);
		if(!validUserName){
			fn.txtUserName.focus();
			fn.txtUserName.select();
		}
		else if(!validUserPass){
			fn.txtUserPass.focus();
			fn.txtUserPass.select();
		}
	}

	// return result
	return validUserName && validUserPass;
}

function login(fn){
  if(this.checkValidLogin(fn)){
  fn.method = "POST"; // goi vao doPost
  fn.action = "/adv/user/login";
  fn.submit();
  }
}
