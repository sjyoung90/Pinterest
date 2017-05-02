/*
 * 사진 파일과 텍스트를 저장하기 위한 Ajax
 */
function savePhoto(){
	var photoNum = 0;
	var fileName = encodingURIComponent(document.getElementById("previewImg").src);
	var explain = encodingURIComponent(document.getElementById("description"));
	var boardNum = document.getElementById("selectBoardNum").value;
	var uploadDate = new Date();
	
	var params = "?photoNum=" + photoNum + "&fileName=" + fileName + "&explain=" + explain + "&boardNum=" + boardNum + "&uploadDate=" + uploadDate;
	
	var xmlHttp = new XMLHttpRequest();
	
	var url = "photoServlet";
	
	
	//콜백 함수 호출
	xmlHttp.onreadystatechange = function() {
		console.log("onreadystatechange");
		if(xmlHttp.readyState==4 && xmlHttp.status==200){
			console.log("photoServlet : " + xmlHttp.responseText);
		}
		else {
			console.log(xmlHttp.statusText);
		}
	};
	console.log("open");
	xmlHttp.open("POST", url, true);
	//Ajax 헤더
	console.log("set");
	xmlHttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	console.log("send");
	//파라미터와 함께 Ajax 호출
	xmlHttp.send(params);
	
}

function processResult() {
	if(xmlHttp.readyState==4 && xmlHttp.status==200){
		console.log("photoServlet : " + xmlHttp.responseText);
	}
	else {
		console.log(xmlHttp.statusText);
	}
}