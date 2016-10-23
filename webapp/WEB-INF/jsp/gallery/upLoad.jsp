<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no" />
<meta name="msapplication-tap-highlight" content="no" />
<title>업로드</title>
<link rel="stylesheet"
	href="/static/plugins/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet"
	href="/static/plugins/font-awesome/css/font-awesome.min.css">
<link rel="stylesheet"
	href="/static/plugins/material/iconfont/material-icons.css">
<link rel="stylesheet" href="/static/css/common.css" />
<link rel="stylesheet" href="/static/css/member.css" />
</head>
<body>

	<header class="hanbit-header">
		<div id="btnGroupMain">
			<div id="btnMenu" class="hanbit-top-button">
				<i class="material-icons hanbit-abs-center">menu</i>
			</div>
		</div>

		<div id="btnGroupSub">
			<div class="btnBack hanbit-top-button">
				<i class="material-icons hanbit-abs-center">navigate_before</i>
			</div>
		</div>

		<div id="btnGroupRight">
			<div id="btnGroupUpdateMember">
				<div class="btnApply hanbit-top-button right">
					<i class="material-icons hanbit-abs-center">done</i>
				</div>
			</div>
		</div>
	</header>

	<div class="hanbit-container">
		<div class="form-group">
			<label for="photoSelect">사진선택</label> <input multiple type="file"
				class="form-control" id="photoSelect" placeholder="업로드사진">
		</div>
		<div class="bottom-buttons">
			<button class="btnApply btn btn-success">사진 올리기</button>
			<button class="btnBack btn btn-default">취소</button>
		</div>
	</div>

	<script src="/static/plugins/jquery/jquery-3.1.0.min.js"></script>
	<script src="/static/plugins/bootstrap/js/bootstrap.min.js"></script>
	<script src="/static/js/upLoad.js"></script>
<!-- 	<script src="//github.com/fyneworks/multifile/blob/master/jQuery.MultiFile.min.js" type="text/javascript" language="javascript"></script> -->
</body>
</html>