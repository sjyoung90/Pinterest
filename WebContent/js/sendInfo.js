function requestLogin(){
	var param = "&userID=a&userPW=a";
	var userID = document.getElementById("userID");
	var userPW = document.getElementById("userPW");
//	var param = "&userID=" + userID + "&userPW=" + userPW;
	var result = requestToServlet("POST", "index.do/login", param);
	console.log("result : " + result);
	if(result == "loginSuccess"){
		memberPart("a");
//		memberPart(userID);
	}else{
		//pwFail, idFail 처리
	}
}