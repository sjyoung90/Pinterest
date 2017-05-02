<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" type="text/css" href="css/uploadStyle.css" />
<title>파일 업로드 Target</title>
<script type="text/javascript" src="js/savePhoto.js"></script>
</head>
<body>
<%
	String fileName = (String) request.getAttribute("fileName");
	System.out.println(fileName);
%>
<form class="uploadForm" action="photoServlet" method="post">
<div class="fileUpload">
	<header> 설명 추가하기 </header>
	<div class="img">
		<img src="<%=fileName %>" id="previewImg" class="previewImg"/>
	</div>
	<ul>
		<li class="selectBoard">
			<label for="board"> 보드 선택 </label>
			<select id="selectBoardNum">
				<option value="1">동물</option>
				<option value="2">디자인</option>
				<option value="3">패션</option>
				<option value="4">여행</option>
				<option value="5">추가하기</option>
			</select>
		</li>
		<li>
			<label> 설명 </label>
			<div class="textField">
				<textarea id="description" name="description" class="content" placeholder="무슨 사진인가요?">  </textarea>
			</div>
		</li>
		<li>
			<label> 등록 날짜 </label>
		</li>
	</ul>
	<div class="buttonDiv">
		<input type="submit" value="등록" onclick="savePhoto()"/>
		<input type="reset" value="취소"/>
	</div>
</div>
</form>
</body>
</html>