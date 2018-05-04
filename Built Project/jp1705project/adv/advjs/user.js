/* Day la kich ban xu ly cho user.html */
// View permission options

function generatePermission(){
	// Permission list
	var permiss = new Array();
	permiss[0] = "--Select--";
	permiss[1] = "members";
	permiss[2] = "authors";
	permiss[3] = "managers";
	permiss[4] = "administrators";
	permiss[5] = "super admin";
	
	var option = "<select name='slcAccPermiss' onchange=\"refreshPermis(this.form)\">";
	for (var i=0; i<permiss.length;i++){
		option += "<option value = '" + i +"'>";
		option += permiss[i];
		option += "</option>";
	}
	option += "</select>";
	document.write(option);
	console.log(option);
}

//show Role
function generateRoll(){
	var rol = new Array();
	rol[0] = "Users management";
	rol[1] = "Section Manager";
	rol[2] = "Category manager";
	rol[3] = "Article management";
	rol[4] = "Product Management";
	rol[5] = "Product group management";
  	rol[6] = "Product type management";
	rol[7] = "Product Management";
  	rol[8] = "Invoice management";
  	rol[9] = "Customer management";
	
	
	var rols = "<table cellspacing=0>";
	for(var i=0; i<rol.length; i++){
		if(i%3==0){
			rols+="<tr>";
		}
		
		rols += "<td>";
		rols += "<input type=\"checkbox\" id=\"chk"+ i +"\"/ disabled name=\"chks\"><label for=\"chk"+i+"\">"+rol[i]+ "</label>"
		rols += "</td>";
		
		if(i%3==2 || i==rol.length-1){
			rols += "</tr>";
		}
	}
	
	rols += "</table>";
	document.write(rols);
}

function setCheckbox(fn,dis,check){
		// duyet cac phan tu cua form
		for (var i=0; i<fn.elements.length;i++){
			if(fn.elements[i].type == "checkbox" && fn.elements[i].name == "chks"){
				fn.elements[i].disabled = dis;
				fn.elements[i].checked = check;
			}
		}
}

function refreshPermis(fn){
	// lay quyen thuc thi 
	var permis = parseInt(fn.slcAccPermiss.value);
	//kiem tra
	if(permis==4||permis==5){
		//admin , super
		this.setCheckbox(fn,true,true);
	}else if(permis==3){
		//manager
		this.setCheckbox(fn,false, true);
	}else if(permis==2){
		this.setCheckbox(fn,false, false);
	}else{
		//others
		this.setCheckbox(fn,true,false);
	}
}

function setFirstTime(fn){
	//f5, reset
	fn.reset();
	this.setCheckbox(fn,true,false);
}

function checkValidUser(fn){
	// lay du lieu tren nhung thanh phan bat buoc
	var userName = fn.txtAccName.value;
	var userPass = fn.txtAccPass.value;
	var userEmail = fn.txtAccEmail.value;
	var userPermis = parseInt(fn.slcAccPermiss.value);
	// khai bao cac bien chay theo xac nhan hop le
	var validUserName = true;
	var validUserPass = true;
	var validUserEmail = true;
	var validUserPermis = true;
	// bien ghi nhan thong bao 
	var message = "";
	
	// kiem tra ten tai khoan 
	if(userName.trim() == ""){
		validUserName = false;
		message = "Enter your username\n";
	}
	else{
		var us = userName.trim();
		if(us.length>=100){
			validUserName =false;
			message = "Your user name too long. Max lenght is 100 characters \n";
		}
		else{
			if(us.indexOf(" ")!= -1){
				validUserName = false;
				message = "Don't need space in your user name\n";
			}
		}
	}
	
	// kiem tra mat khau
	up = userPass.trim();
	if(up==""){
		validUserPass =false;
		message += "Enter your password\n";
	}
	else{
		if(up.length<6){
			validUserPass = false;
			message += "Your password is too short. Minimum is 5 characters \n";
		}else{
			// mat khau chua ten dang nhap ko dc
		}
	}
	
	// kiem tra hop thu
	um = userEmail.trim();
	if(um==""){
		validUserEmail = false;
		message += "Enter your email \n";
	}
	else{
		var pattern = /\w+@\w+[.]\w/;
		if(!um.match(pattern)){
			validUserEmail = false;
			message += "Not match form of email\n";
		}
	}
	
//kiem tra vai tro thuc thi cua author va manager
	if(userPermis==2||userPermis==3){
		for(var i=0; i<fn.elements.length; i++){
			if(fn.elements[i].type == "checkbox" && fn.elements[i].name == "chks"){
				if(fn.elements[i].checked){
					validUserPermis = true;
					break;
				}
				else{
					validUserPermis = false;
				}
			}
		}
	}
	
	if(!validUserPermis){
		message += "Choose at least roll!!!";
	}
	
	//xuat thong bao
	mess = message.trim();
	if(mess!=""){
		window.alert(mess);
		if(!validUserName){
			fn.txtAccName.focus();
			fn.txtAccName.select();
		}
		else if(!validUserPass){
			fn.txtAccPass.focus();
			fn.txtAccPass.select();
		}
		else if(!validUserEmail){
			fn.txtAccEmail.focus();
			fn.txtAccEmail.select();
		}
		else if(!validUserPermis){
			fn.slcAccPermiss.focus();
		}
	}

	return validUserEmail && validUserName && validUserPass && validUserPermis;
	
}

