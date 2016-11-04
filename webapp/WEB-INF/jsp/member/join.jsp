<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no" />
<meta name="msapplication-tap-highlight" content="no" />
<title>회원가입</title>
<link rel="stylesheet" href="/static/plugins/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/static/plugins/font-awesome/css/font-awesome.min.css">
<link rel="stylesheet" href="/static/plugins/material/iconfont/material-icons.css">
<link rel="stylesheet" href="/static/css/common.css" />
<link rel="stylesheet" href="/static/css/member.css" />
</head>
<body>

	<div class="hanbit-container">
		<div class="form-group">
   			<label for="txtName" class="input-required">이름</label>
   			<input type="text" class="form-control" id="txtName" placeholder="이름">
		</div>
		<div class="form-group">
   			<label for="txtEmail" class="input-required">이메일</label>
   			<input type="text" class="form-control" id="txtEmail" placeholder="이메일">
		</div>
		<div class="form-group">
   			<label for="txtPassword" class="input-required">비밀번호</label>
   			<input type="password" class="form-control" id="txtPassword" placeholder="비밀번호">
		</div>
		<div class="form-group">
   			<label for="txtPasswordConfirm" class="input-required">비밀번호확인</label>
   			<input type="password" class="form-control" id="txtPasswordConfirm" placeholder="비밀번호확인">
		</div>
		<div class="bottom-buttons">
			<button class="btnApply btn btn-success">가입</button>
			<button class="btnBack btn btn-default">취소</button>
		</div>
	</div>

<script src="/static/plugins/jquery/jquery-3.1.0.min.js"></script>
<script src="/static/plugins/bootstrap/js/bootstrap.min.js"></script>
<script src="/static/js/member.join.js"></script>
</body>
</html>