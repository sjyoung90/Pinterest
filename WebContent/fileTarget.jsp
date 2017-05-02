<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" type="text/css" href="css/uploadStyle.css" />
<title>���� ���ε� Target</title>
<script type="text/javascript" src="js/savePhoto.js"></script>
</head>
<body>
<%
	String fileName = (String) request.getAttribute("fileName");
	System.out.println(fileName);
%>
<form class="uploadForm" action="photoServlet" method="post">
<div class="fileUpload">
	<header> ���� �߰��ϱ� </header>
	<div class="img">
		<img src="<%=fileName %>" id="previewImg" class="previewImg"/>
	</div>
	<ul>
		<li class="selectBoard">
			<label for="board"> ���� ���� </label>
			<select id="selectBoardNum">
				<option value="1">����</option>
				<option value="2">������</option>
				<option value="3">�м�</option>
				<option value="4">����</option>
				<option value="5">�߰��ϱ�</option>
			</select>
		</li>
		<li>
			<label> ���� </label>
			<div class="textField">
				<textarea id="description" name="description" class="content" placeholder="���� �����ΰ���?">  </textarea>
			</div>
		</li>
		<li>
			<label> ��� ��¥ </label>
		</li>
	</ul>
	<div class="buttonDiv">
		<input type="submit" value="���" onclick="savePhoto()"/>
		<input type="reset" value="���"/>
	</div>
</div>
</form>
</body>
</html>