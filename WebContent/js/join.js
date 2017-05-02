	function makeJoinForm(){
		var body = document.getElementsByTagName("body")[0];
		
		var header = document.createElement("header");
		header.innerHTML = "Registration";

		//폼 만들고 속성 추가
		var form = document.createElement("form");
		form.setAttribute("id", "join");
		form.setAttribute("action", "join");
		form.setAttribute("method", "post");
		
		//전체 폼 요소 div영역
		var joinDiv = document.createElement("div");
		joinDiv.setAttribute("class", "join");
		
		//label과 input요소를 포함하는 <p> 태그
		var paragraphID = document.createElement("p");
		
		//아이디 입력 부분
		var labelID = document.createElement("label");
		labelID.setAttribute("for", "id");
		labelID.innerHTML = "아이디";
		var inputID = document.createElement("input");
		inputID.setAttribute("type", "text");
		inputID.setAttribute("id", "u_id");
		inputID.setAttribute("name", "u_id");
		inputID.setAttribute("maxlength", "16");
		inputID.setAttribute("placeholder", "아이디");
		
		paragraphID.appendChild(labelID);
		paragraphID.appendChild(inputID);
		
		//비밀번호 입력 부분
		var paragraphPW = document.createElement("p");
		
		var labelPW = document.createElement("label");
		labelPW.setAttribute("for", "pw");
		labelPW.innerHTML = "비밀번호";
		var inputPW = document.createElement("input");
		inputPW.setAttribute("type", "password");
		inputPW.setAttribute("id", "u_pw");
		inputPW.setAttribute("name", "u_pw");
		inputPW.setAttribute("maxlength", "16");
		inputPW.setAttribute("placeholder", "비밀번호");
		
		paragraphPW.appendChild(labelPW);
		paragraphPW.appendChild(inputPW);
		
		//이름 입력 부분
		var paragraphName = document.createElement("p");
		
		var labelName = document.createElement("label");
		labelName.setAttribute("for", "name");
		labelName.innerHTML = "이름";
		var inputName = document.createElement("input");
		inputName.setAttribute("type", "text");
		inputName.setAttribute("id", "u_name");
		inputName.setAttribute("name", "u_name");
		
		paragraphName.appendChild(labelName);
		paragraphName.appendChild(inputName);
		
		//성별 입력 부분
		var paragraphGender = document.createElement("p");
		
		var labelGender = document.createElement("label");
		labelGender.setAttribute("for", "gender");
		labelGender.innerHTML = "성별";
		var inputGender1 = document.createElement("input");
		inputGender1.setAttribute("type", "radio");
		inputGender1.setAttribute("name", "u_gender");
		inputGender1.setAttribute("value", "male");
		var labelGender1 = document.createElement("label");
		labelGender1.innerHTML = "남";
		var inputGender2 = document.createElement("input");
		inputGender2.setAttribute("type", "radio");
		inputGender2.setAttribute("name", "u_gender");
		inputGender2.setAttribute("value", "female");
		var labelGender2 = document.createElement("label");
		labelGender2.innerHTML = "여";
		
		paragraphGender.appendChild(labelGender);
		paragraphGender.appendChild(inputGender1);
		paragraphGender.appendChild(labelGender1);
		paragraphGender.appendChild(inputGender2);
		paragraphGender.appendChild(labelGender2);
		
		//생년월일 입력 부분
		var paragraphBirth = document.createElement("p");
		
		var labelBirth = document.createElement("label");
		labelBirth.setAttribute("for", "birth");
		labelBirth.innerHTML = "생년월일";
		var inputBirth = document.createElement("input");
		inputBirth.setAttribute("type", "date");
		inputBirth.setAttribute("id", "u_birth");
		inputBirth.setAttribute("name", "u_birth");
		
		paragraphBirth.appendChild(labelBirth);
		paragraphBirth.appendChild(inputBirth);
		
		joinDiv.appendChild(paragraphID);
		joinDiv.appendChild(paragraphPW);
		joinDiv.appendChild(paragraphName);
		joinDiv.appendChild(paragraphGender);
		joinDiv.appendChild(paragraphBirth);
		
		//버튼 div영역
		var buttonDiv = document.createElement("div");
		buttonDiv.setAttribute("class", "button");
		
		var paragraphButton = document.createElement("p");
		
		var inputSubmit = document.createElement("input");
		inputSubmit.setAttribute("type", "submit");
		inputSubmit.setAttribute("value", "가입");
		var inputReset = document.createElement("input");
		inputReset.setAttribute("type", "reset");
		inputReset.setAttribute("value", "취소");
		
		paragraphButton.appendChild(inputSubmit);
		paragraphButton.appendChild(inputReset);

		buttonDiv.appendChild(paragraphButton);
		
		form.appendChild(joinDiv);
		form.appendChild(buttonDiv);
		body.appendChild(header);
		body.appendChild(form);
	}
	
	