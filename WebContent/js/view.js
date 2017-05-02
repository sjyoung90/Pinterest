function mainLayout(){
	var header = document.createElement("header");
	header.setAttribute("id", "header");
	var headerBackground = document.createElement("div");
	headerBackground.setAttribute("class", "headerBackground");
	var headerContainer = document.createElement("div");
	headerContainer.setAttribute("class", "headerContainer");
	headerContainer.setAttribute("id", "headerContainer");
	var title = document.createElement("div");
	title.setAttribute("class", "title");
	title.innerHTML = "찜ZZim";
	
	headerContainer.appendChild(title);
	headerContainer.appendChild(loginPart()); // 로그인폼 생성 함수
	headerBackground.appendChild(headerContainer);
	header.appendChild(headerBackground);

	var wrapper = document.createElement("div");
	wrapper.setAttribute("id", "wrapper");
	var columns = document.createElement("div");
	columns.setAttribute("id", "columns");
	
	//pin 생성 함수. for문으로 생성. 서블릿으로 요청 보냄 : requestToServlet
	
	var zzim = document.getElementById("zzim");
	zzim.appendChild(header);
	zzim.appendChild(wrapper);
	
	document.body.appendChild(document.createElement("div"));
}

function loginPart(){
//	var form = document.createElement("form");
//	form.setAttribute("action", "login");
//	form.setAttribute("method", "post");
	var login = document.createElement("div");
	login.setAttribute("class", "login");
	var idText = document.createTextNode("ID : ");
	var inputID = document.createElement("input");
	inputID.setAttribute("type", "text");
	inputID.setAttribute("id", "userID");
	inputID.setAttribute("maxlength", 20);
	inputID.setAttribute("placeholder", "아이디");
	inputID.setAttribute("required", "required");
	var pwText = document.createTextNode("PW : ");
	var inputPW = document.createElement("input");
	inputPW.setAttribute("type", "text");
	inputPW.setAttribute("id", "userPW");
	inputPW.setAttribute("maxlength", 16);
	inputPW.setAttribute("placeholder", "비밀번호");
	inputPW.setAttribute("required", "required");
	var submitButton = document.createElement("input");
	submitButton.setAttribute("type", "submit");
	submitButton.setAttribute("value", "로그인");
	submitButton.addEventListener("click", function(){
		requestLogin();
	} );
	
	var joinButton = document.createElement("input");
	joinButton.setAttribute("type", "button");
	joinButton.setAttribute("value", "회원가입");
	
	login.appendChild(idText);
	login.appendChild(inputID);
	login.appendChild(pwText);
	login.appendChild(inputPW);
	login.appendChild(submitButton);
	login.appendChild(joinButton);
	
//	form.appendChild(login);
	
	return login;
}

function memberPart(id){console.log("memberPart");
	var memberDiv = document.createElement("div");
	memberDiv.setAttribute("class", "memberDiv");
	var uploadButton = document.createElement("input");
	uploadButton.setAttribute("type", "button");
	uploadButton.setAttribute("value", "사진 올리기");
	uploadButton.addEventListener("click", function(){
		uploadFileView();
	} );
	var welcomeMessage = id + " 님 환영합니다.";
	var welcomeText = document.createTextNode(welcomeMessage);
	var updateButton = document.createElement("input");
	updateButton.setAttribute("type", "button");
	updateButton.setAttribute("value", "정보 수정");
	var logoutButton = document.createElement("input");
	logoutButton.setAttribute("type", "button");
	logoutButton.setAttribute("value", "로그아웃");
	console.log(welcomeMessage);
	memberDiv.appendChild(uploadButton);
	memberDiv.appendChild(welcomeText);
	memberDiv.appendChild(updateButton);
	memberDiv.appendChild(logoutButton);
	
	var headerContainer = document.getElementById("headerContainer");
	headerContainer.replaceChild(memberDiv, headerContainer.lastChild);
}

function makePin(imgSrc, explainText){
	var pin = document.createElement("div");
	pin.setAttribute("class", "pin");
	var img = document.createElement("img");
	img.setAttribute("src", imgSrc);
	var p = document.createElement("p");
	p.setAttribute("class", "imgExplain");
	p.innerHTML = explainText;
	
	pin.appendChild(img);
	pin.appendChild(p);
	
	return pin;
}

function uploadView(imgSrc){
	var form = document.createElement("form");
	form.setAttribute("class", "uploadForm");
	form.setAttribute("action", "photoServlet"); //서블릿 정리...
	form.setAttribute("method", "post");
	
	var fileUpload = document.createElement("div");
	fileUpload.setAttribute("class", "fileUpload");
	var header = document.createElement("header");
	header.innerHTML = "설명 추가하기";

	var imgDiv = document.createElement("div");
	imgDiv.setAttribute("class", "login");
	var img = document.createElement("img");
	img.setAttribute("src", imgSrc);
	img.setAttribute("id", "previewImg");
	img.setAttribute("class", "previewImg");
	
	imgDiv.appendChild(img);
	
	var ul = document.createElement("ul");
	var selectli = document.createElement("li");
	selectli.setAttribute("class", "selectBoard");
	var boardLabel = document.createElement("label");
	boardLabel.setAttribute("for", "board");
	boardLabel.innerHTML = "보드 선택";
	var selectBoard = document.createElement("select");
	selectBoard.setAttribute("id", "selectBoardNum");
	var option1 = document.createElement("option");
	option1.setAttribute("value", 1); // 배열 만들어서 수정...나중에..
	option1.innerHTML = "동물";
	var option2 = document.createElement("option");
	option2.setAttribute("value", 2); // 배열 만들어서 수정...나중에..
	option2.innerHTML = "디자인";
	var option3 = document.createElement("option");
	option3.setAttribute("value", 3); // 배열 만들어서 수정...나중에..
	option3.innerHTML = "패션";
	var option4 = document.createElement("option");
	option4.setAttribute("value", 4); // 배열 만들어서 수정...나중에..
	option4.innerHTML = "여행";
	
	selectli.appendChild(boardLabel);
	selectBoard.appendChild(option1);
	selectBoard.appendChild(option2);
	selectBoard.appendChild(option3);
	selectBoard.appendChild(option4);
	selectli.appendChild(selectBoard);
	ul.appendChild(selectli);
	
	var explainli = document.createElement("li");
	var explainLabel = document.createElement("label");
	explainLabel.innerHTML = "설명";
	var textDiv = document.createElement("div");
	textDiv.setAttribute("class", "textField");
	var textArea = document.createElement("textarea");
	textArea.setAttribute("id", "description");
	textArea.setAttribute("name", "description");
	textArea.setAttribute("class", "content");
	textArea.setAttribute("placeholder", "무슨 사진인가요?");

	explainli.appendChild(explainLabel);
	textDiv.appendChild(textArea);
	explainli.appendChild(textDiv);
	ul.appendChild(explainli);
	
	var dateli = document.createElement("li");
	var today = "2014-02-20"; // 오늘 날짜..나중에..ex) 2014-02-20
	
	dateli.innerHTML = today;
	ul.appendChild(dateli);
	
	var buttonDiv = document.createElement("div");
	buttonDiv.setAttribute("class", "buttonDiv");
	var submitButton = document.createElement("input");
	submitButton.setAttribute("type", "submit");
	submitButton.setAttribute("value", "등록");
	var resetButton = document.createElement("input");
	resetButton.setAttribute("type", "reset");
	resetButton.setAttribute("value", "취소");
	
	buttonDiv.appendChild(submitButton);
	buttonDiv.appendChild(resetButton);
	
	fileUpload.appendChild(header);
	fileUpload.appendChild(imgDiv);
	fileUpload.appendChild(ul);
	fileUpload.appendChild(buttonDiv);
	
	form.appendChild(fileUpload);
}

function uploadFileView(){
	//overlay div영역 추가
	var overlay = document.createElement("div");
	overlay.setAttribute("id", "overlay");
	overlay.setAttribute("class", "overlay");
	
	var form = document.createElement("form");
	form.setAttribute("id", "myForm");
	form.setAttribute("enctype", "multipart/form-data");
	form.setAttribute("method", "post");
	form.setAttribute("action", "FileServlet"); //서블릿 정리...
	form.setAttribute("onsubmit", "ajaxFunction()");
	
	var inputFile = document.createElement("input");
	inputFile.setAttribute("type", "file");
	inputFile.setAttribute("name", "txtFile");
	inputFile.setAttribute("id", "txtFile");
	
	var submitButton = document.createElement("input");
	submitButton.setAttribute("type", "submit");
	submitButton.setAttribute("id", "submitID");
	submitButton.setAttribute("name", "submit");
	submitButton.setAttribute("value", "등록");
	
	form.appendChild(inputFile);
	form.appendChild(submitButton);
	overlay.appendChild(form);
	
	document.body.replaceChild(overlay, document.body.lastChild);
	
	overlay.onclick = restore;
}
