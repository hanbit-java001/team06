<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no" />
<meta name="msapplication-tap-highlight" content="no" />
<link rel="stylesheet" href="/static/plugins/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/static/plugins/font-awesome/css/font-awesome.min.css">
<link rel="stylesheet" href="/static/plugins/material/iconfont/material-icons.css">
<link rel="stylesheet" href="/static/css/common.css" />
<link rel="stylesheet" href="/static/css/main.css" />
<title>PoroPoro</title>
</head>
<body>

	<div class="main-container">
		<div class="main-top">
			<div class="main-top-body">
				<div class="main-logo"><a href="/">PoroPoro</a></div>
				<div class="main-menu">
					<ul>
						<li id="menuGallery">Gallery</li>
						<li id="menuJoin" class="beforeLogin">Join</li>
						<li id="menuLogin" class="beforeLogin">LogIn</li>
						<li id="menuUpLoad" class="afterLogin">UpLoad</li>
						<li id="menuMypage" class="afterLogin">MyPage</li>
						<li id="menuLogout" class="afterLogin">LogOut</li>
					</ul>
				</div>
			</div>
		</div>

		<div class="main-content">
			<div class="main-content-body">
				PoroPoro는 세계인들이 참여,공감하며<br>
				 즐길 수 있는 무료 사진공유 사이트입니다.<br><br>
				PoroPoro에 가입하세요!<br>
				<button id="btnJoin" class="btn btn-primary">Free Join It !</button>
			</div>
		</div>

		<div class="main-bottom">
			PoroPoro Is Open Free Shared PhotoSite !
		</div>

		<div class="login-dialog">
			<div class="form-group">
	   			<label for="txtEmail" class="input-required">E-mail</label>
	   			<input type="text" class="form-control" id="txtEmail" placeholder="이메일">
			</div>
			<div class="form-group">
	   			<label for="txtPassword" class="input-required">Password</label>
	   			<input type="password" class="form-control" id="txtPassword" placeholder="비밀번호">
			</div>
			<div class="bottom-buttons">
				<button class="btnLogin btn btn-success">LogIn</button>
				<button class="btnLoginCancel btn btn-default">Cancel</button>
			</div>
		</div>
	</div>

<script src="/static/plugins/jquery/jquery-3.1.0.min.js"></script>
<script src="/static/plugins/bootstrap/js/bootstrap.min.js"></script>
<script src="/static/js/gallery.js"></script>
<script src="/static/js/common.js"></script>
<script src="/static/js/main.js"></script>
</body>
</html>