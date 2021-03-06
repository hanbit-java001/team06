$(function() {
	$(".main-menu ul li").on("click", function() {
		var menuId = $(this).attr("id");

		if (menuId == "menuJoin") {
			location.href = "/member/join";
		}
		else if (menuId == "menuLogout") {
			location.href = "/security/logout";
		}
		else if (menuId == "menuGallery") {
			location.href = "/gallery/galleryList";
		}
		else if (menuId == "menuUpLoad") {
			location.href = "/gallery/upLoad";
		}
	});

	$(".btnLogin").on("click", function() {
		var email = $("#txtEmail").val();
		var password = $("#txtPassword").val();

		if (email == "") {
			alert("이메일을 입력하세요.");
			$("#txtEmail").focus();
			return;
		}
		else if (password == "") {
			alert("비밀번호를 입력하세요.");
			$("#txtPassword").focus();
			return;
		}

		$.ajax({
			url: "/api/security/login",
			method: "POST",
			data: {
				email: email,
				password: password
			}
		}).done(function(result) {
			processAfterLogin(result.name);
		}).fail(function() {
			alert("해당 아이디가 없습니다.");
		});
	});

	$(".btnLoginCancel").on("click", function() {
		history.back();
	});

	function processAfterLogin(name) {
		alert(name + "님 반갑습니다.");

		$("#txtEmail").val("");
		$("#txtPassword").val("");

		location.reload();
	}

	$("#txtEmail").focus();
});