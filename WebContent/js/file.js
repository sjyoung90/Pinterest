

function ajaxFunction() {
	var url = "FileServlet";
	
	var req = null;

	if (window.XMLHttpRequest) {
		req = new XMLHttpRequest();

		try {
			req.open("POST", url, true);
		} catch (e) {
			alert(e);
		}
		req.setRequestHeader("Content-type", "multipart/form-data");
		req.send(document.getElementById('txtFile').files[0]); // 파일 포인터 넘겨줌
	} else if (window.ActiveXObject) {
		req = new ActiveXObject("Microsoft.XMLHTTP");

	}
}