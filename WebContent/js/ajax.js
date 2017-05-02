function requestToServlet(method, url, params){
	var xmlHttp = new XMLHttpRequest();
	var result = null;
	
	xmlHttp.onreadystatechange = function() {
		if(xmlHttp.readyState==4 && xmlHttp.status==200){
			result = xmlHttp.responseText;
			console.log("Servlet : " + result);			
		}
		else {
			console.log("Ajax : " + xmlHttp.statusText);
		}
	};
	
	xmlHttp.open(method, url, false); // 비동기 요청 	
	xmlHttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");	
	xmlHttp.send(params);
	
	return result;
}