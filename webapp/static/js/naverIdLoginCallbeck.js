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

				callAjax({
					url: "/api/security/isLoggedIn",
					method: "GET",
					success: function(result) {
						if (result.email == "") {
							showMenu(false);
						}
						else {
							showMenu(true);
						}
					}
				});
			}).fail(function() {
				alert("잠시후 다시한번 시도해주세요.");
			});
		}
		function processAfterLogin(email) {
			alert(email + "님 반갑습니다.");
		}
		//네이버 사용자 프로필 조회
		if(naver_id_login.is_callback == true){
		naver_id_login.get_naver_userprofile("naverSignInCallback()");
		}