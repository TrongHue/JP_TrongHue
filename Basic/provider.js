/* Cac xu ly cho provider.html*/
function checkValidProvider(fn){
	var name = fn.txtName.value;
	var check = fn.checkAgree.checked;
	if(name.trim()!="" && check){
		fn.login.disabled = false;
	}
	else{
		fn.login.disabled = true;
	}
	console.log(name);
	console.log(check);
}