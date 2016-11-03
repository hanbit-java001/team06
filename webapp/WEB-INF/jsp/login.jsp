<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no" />
<meta name="msapplication-tap-highlight" content="no" />
<link rel="stylesheet" href="/static/plugins/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/static/plugins/font-awesome/css/font-awesome.min.css">
<link rel="stylesheet" href="/static/plugins/material/iconfont/material-icons.css">
<link rel="stylesheet" href="/static/css/common.css" />
<link rel="stylesheet" href="/static/css/main.css" />
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
					</ul>
				</div>
			</div>
		</div>

		<div class="main-content">
			<div class="main-content-body login-form">
				<div class="form-group">
		   			<label for="txtEmail" class="input-required">E-mail</label>
		   			<input type="text" class="form-control" id="txtEmail" placeholder="이메일">
				</div>
				<div class="form-group">
		   			<label for="txtPassword" class="input-required">Password</label>
		   			<input type="password" class="form-control" id="txtPassword" placeholder="비밀번호">
				</div>
				<div class="bottom-buttons">
					<button class="btnLogin btn btn-success">L</button>
					<button class="btnLoginCancel btn btn-default">C</button>
					<div id="naver_id_login"></div>
				</div>

			</div>
		</div>

		<div class="main-bottom">
			PoroPoro Is Open Free Shared PhotoSite !
		</div>

	</div>

<script type="text/javascript">
	var naver_id_login = new naver_id_login("WUeDOqZsNJxhXOLW8uN7", "http://localhost:8282/login");
	var state = naver_id_login.getUniqState();
	naver_id_login.setButton("green", 3,40);
	naver_id_login.setDomain(".service.com");
	naver_id_login.setState(state);
	naver_id_login.setPopup();
	naver_id_login.init_naver_id_login();
</script>

<script type="text/javascript">
	// 네이버 사용자 프로필 조회 이후 프로필 정보를 처리할 callback function
	function naverSignInCallback() {
		// naver_id_login.getProfileData('프로필항목명');
		// 프로필 항목은 개발가이드를 참고하시기 바랍니다.
		alert(naver_id_login.getProfileData('email'));
		alert(naver_id_login.getProfileData('nickname'));
		alert(naver_id_login.getProfileData('name'));
		alert(naver_id_login.getProfileData('id'));
		alert(naver_id_login.getProfileData('age'));
		alert(naver_id_login.getAccessToken());
	}

	// 네이버 사용자 프로필 조회
	naver_id_login.get_naver_userprofile("naverSignInCallback()");
</script>
<script type="text/javascript" src="https://static.nid.naver.com/js/naverLogin_implicit-1.0.2.js" charset="utf-8"></script>
<script src="/static/plugins/jquery/jquery-3.1.0.min.js"></script>
<script src="/static/plugins/bootstrap/js/bootstrap.min.js"></script>
<script src="/static/js/login.js"></script>
</body>
</html>