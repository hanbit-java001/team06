<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<script type="text/javascript" src="https://static.nid.naver.com/js/naverLogin_implicit-1.0.2.js" charset="utf-8"></script>
	<script type="text/javascript" src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no" />
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
				PoroPoro는 세계인들이 참여,공감하며<br> 즐길 수 있는 무료 사진공유 사이트입니다.<br><br> PoroPoro에 가입하세요!<br>
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
			<hr color="444444">
			<div id="naver_id_login"></div>
		</div>
	</div>
	<script type="text/javascript">
		var naver_id_login = new naver_id_login("WUeDOqZsNJxhXOLW8uN7", "http://203.236.209.189:8282/");
		var state = naver_id_login.getUniqState();
		naver_id_login.setButton("green", 3, 40);
		naver_id_login.setDomain(".service.com");
		naver_id_login.setState(state);
		// 	naver_id_login.setPopup();
		naver_id_login.init_naver_id_login();
	</script>
	<script type="text/javascript">
	//네이버 사용자 프로필 조회
	naver_id_login.get_naver_userprofile("naverSignInCallback()");
		// 네이버 사용자 프로필 조회 이후 프로필 정보를 처리할 callback function
		function naverSignInCallback() {
			var email = naver_id_login.getProfileData('email');
			alert(naver_id_login.getAccessToken());
			$.ajax({
				url: "/api/security/naverlogin",
				method: "POST",
				data: {
					email: email
				}
			}).done(function(result) {
				processAfterLogin(result.email);
			}).fail(function() {
				alert("로그인을 실패하였습니다./n잠시후 다시한번 시도해주세요.");
			});
		}
		function processAfterLogin(email) {
			alert(email + "님 반갑습니다.");
		}

	</script>
	<script src="/static/plugins/jquery/jquery-3.1.0.min.js"></script>
	<script src="/static/plugins/bootstrap/js/bootstrap.min.js"></script>
	<script src="/static/js/gallery.js"></script>
	<script src="/static/js/common.js"></script>
	<script src="/static/js/main.js"></script>
</body>

</html>