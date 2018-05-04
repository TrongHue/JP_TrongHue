/*Cac xu ly kich ban cho layout.html*/
var  def = "-- tu khoa --";
var emp = "";

function setFirstTime(fn){
	fn.txtKeyword.value = def;
}

function setKeyword(fn,isClick){
	/* Lay gia tri tu o*/
	var value = fn.txtKeyword.value;
	
	/* Kiem tra */
	if(isClick){
		if(value.trim()==def){
		fn.txtKeyword.value = emp; 
		}
	}
	else{
		if(value.trim() == emp)
			fn.txtKeyword.value = def;
	}

}

function checkValidKeyword(fn){
	var value = fn.txtKeyword.value;
	value = value.trim();
	if(value==def||value==emp){
		var message = "Enter key word new";
		window.alert(message);
		fn.txtKeyword.focus();
		fn.txtKeyword.select();
	}
}