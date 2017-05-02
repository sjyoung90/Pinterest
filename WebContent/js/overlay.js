function overlayPin(){ //오버레이로 보여줄 콘텐츠 추가
		//overlay 외부 div영역 추가
		var outer = document.createElement("div");
		outer.setAttribute("id", "outer");
		outer.setAttribute("class", "outer");
		document.body.appendChild(outer);
		
		//overlay div영역 추가
		var overlay = document.createElement("div");
		overlay.setAttribute("id", "overlay");
		overlay.setAttribute("class", "overlay");
		
		//header 영역 추가
		var overlayHeader = document.createElement("header");
		overlayHeader.setAttribute("id", "header");
		overlayHeader.setAttribute("class", "overlayHeader");
		var headerBackground = document.createElement("div");
		headerBackground.setAttribute("class", "headerBackground");
		var headerContainer = document.createElement("div");
		headerContainer.setAttribute("class", "headerContainer");
		var buttonDiv = document.createElement("div");
		buttonDiv.setAttribute("class", "buttonDiv");
		var zzimButton = document.createElement("input");
		zzimButton.setAttribute("type", "button");
		zzimButton.setAttribute("value", "찜하기");
		zzimButton.addEventListener("click", zzim, false); // 리스너 함수 만들기
		var closeButton = document.createElement("input");
		closeButton.setAttribute("type", "button");
		closeButton.setAttribute("value", "닫기");
		
		buttonDiv.appendChild(zzimButton);
		buttonDiv.appendChild(closeButton);
		headerContainer.appendChild(buttonDiv);
		headerBackground.appendChild(headerContainer);
		overlayHeader.appendChild(headerBackground);

		//overlay 이미지 추가
		var img = document.createElement("img");
		img.setAttribute("id", "img");
		img.setAttribute("src", this.getElementsByTagName("img")[0].getAttribute("src"));
		img.setAttribute("class", "overlayImg");
		
		//overlay 텍스트 추가
		var imgExplain = document.createElement("p");
		imgExplain.setAttribute("id", "explain");
		imgExplain.setAttribute("class", "overlayExplain");
		
		var originalP = this.getElementsByTagName("p");
		var originalText = originalP[0].firstChild.textContent;
		console.dir(originalP[0]);
		console.log(originalText);
		
		imgExplain.innerHTML = originalText;
		console.log(imgExplain);
		overlay.appendChild(overlayHeader);
		overlay.appendChild(img);
		overlay.appendChild(imgExplain);
		document.body.appendChild(overlay);
		
		overlay.onclick = restore;
		outer.onclick = restore;
	}
	
	function restore(){ //원래 상태로 복원
		document.body.removeChild(document.getElementById("overlay"));
		document.body.removeChild(document.getElementById("outer"));
	}
	
	function zzim(){ //해당 그림을 찜하면 회원의 보드에 사진이 추가됨
		//overlay 외부 div영역 추가
		var outer = document.createElement("div");
		outer.setAttribute("id", "outer");
		outer.setAttribute("class", "outer");
		document.body.appendChild(outer);
		
		//overlay div영역 추가
		var overlay = document.createElement("div");
		overlay.setAttribute("id", "overlay");
		overlay.setAttribute("class", "overlay");
	}