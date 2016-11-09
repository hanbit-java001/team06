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
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:700,400&amp;subset=cyrillic,latin,greek,vietnamese">
<link rel="stylesheet" href="/static/assets/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/static/assets/socicon/css/socicon.min.css">
<link rel="stylesheet" href="/static/assets/mobirise/css/style.css">
<link rel="stylesheet" href="/static/assets/mobirise-slider/style.css">
<link rel="stylesheet" href="/static/assets/mobirise-gallery/style.css">
<link rel="stylesheet" href="/static/assets/mobirise/css/mbr-additional.css" type="text/css">
<link rel="stylesheet" href="/static/plugins/font-awesome/css/font-awesome.min.css">
<link rel="stylesheet" href="/static/css/main.css" type="text/css">
<link rel="stylesheet" href="/static/plugins/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/static/plugins/font-awesome/css/font-awesome.min.css">
<link rel="stylesheet" href="/static/plugins/material/iconfont/material-icons.css">
<link rel="stylesheet" href="/static/css/btnUp.css" />
<link rel="stylesheet" href="/static/css/commonUp.css" />
<link rel="stylesheet" href="/static/css/member.css" />
<link rel="stylesheet" href="/static/plugins2/css/jquery.fileupload-ui.css">
<link rel="stylesheet" href="/static/plugins2/css/jquery.fileupload.css">
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">


</head>
<body>
<section
		class="mbr-navbar mbr-navbar--freeze mbr-navbar--absolute mbr-navbar--auto-collapse"
		id="ext_menu-0">
		<div class="mbr-navbar__section mbr-section">
			<div class="mbr-section__container container">
				<div class="mbr-navbar__container">
					<div
						class="mbr-navbar__column mbr-navbar__column--s mbr-navbar__brand">
						<span class="mbr-navbar__brand-link mbr-brand mbr-brand--inline">
							<span class="mbr-brand__logo"><a
								href="/home"><img
									src="/static/assets/images/logo-128x128-15.png"
									class="mbr-navbar__brand-img mbr-brand__img" alt="PoroPoro"
									title="Free Photo Sharing Gallery"></a></span> <span
							class="mbr-brand__name"><a
								class="mbr-brand__name text-gray" href="/home">Free
									Photo <br>Sharing Gallery
							</a></span>
						</span>

					</div>
					<div id="fdiv">
 				<input id="finder-bar" class="form-control" name="finder-bar" type="text" placeholder="사진 검색">
 				<input class="btnApply btn btn-success" id="finder-btn" name="finder-btn" type="button" value="검색">
    		</div>
					<div class="mbr-navbar__hamburger mbr-hamburger">
						<span class="mbr-hamburger__line"></span>
					</div>
					<div class="mbr-navbar__column mbr-navbar__menu">
						<nav
							class="mbr-navbar__menu-box mbr-navbar__menu-box--inline-right">
							<div class="mbr-navbar__column">
								<ul
									class="mbr-navbar__items mbr-navbar__items--right float-left mbr-buttons mbr-buttons--freeze mbr-buttons--right btn-decorator mbr-buttons--active mbr-buttons--only-links">
									<li class="mbr-navbar__item" id="menuGallery"><a
										class="mbr-buttons__link btn text-black"
										href="/gallery/galleryList">GALLERY</a></li>
									<li class="beforeLogin mbr-navbar__item" id="menuJoin"><a
										class="mbr-buttons__link btn text-black"
										href="/member/join">JOIN</a></li>
									<li class="beforeLogin mbr-navbar__item" id="menuLogin"><a
										class="mbr-buttons__link btn text-black">LOGIN</a></li>
									<li class="afterLogin mbr-navbar__item" id="menuUpLoad"><a
										class="mbr-buttons__link btn text-black"
										href="/gallery/upLoad">UPLOAD</a></li>
									<li class="afterLogin mbr-navbar__item" id="menuLogout"><a
										class="mbr-buttons__link btn text-black"
										href="/security/logout">LOGOUT</a></li>
								</ul>

							</div>
						</nav>
					</div>
				</div>
			</div>

		</div>

	</section>

	<div class="hanbit-container">
		<div class="form-group">
			<label id="photoLabel" for="photoSelect"></label> <input multiple type="file"
				class="form-control btn btn-success fileinput-button" id="photoSelect" name="files[]" placeholder="업로드사진">

		</div>
		<div class="bottom-buttons">
			<button class="btnApply btn btn-success">사진 올리기</button>
			<button class="btnBack btn btn-default" onclick=location.href='/home'>취소</button>
		</div>
		<p id="filetxt"></p>
		<p id="hashtxt"></p>
	</div>



<script src="/static/assets/web/assets/jquery/jquery.min.js"></script>
	<script src="/static/assets/bootstrap/js/bootstrap.min.js"></script>
	<script src="/static/assets/smooth-scroll/SmoothScroll.js"></script>
	<script src="/static/assets/bootstrap-carousel-swipe/bootstrap-carousel-swipe.js"></script>
	<script src="/static/assets/masonry/masonry.pkgd.min.js"></script>
	<script src="/static/assets/imagesloaded/imagesloaded.pkgd.min.js"></script>
	<script src="/static/assets/social-likes/social-likes.js"></script>
	<script src="/static/assets/mobirise/js/script.js"></script>
	<script src="/static/assets/mobirise-gallery/script.js"></script>
	<script src="/static/js/home.js"></script>
	<script src="/static/js/gallery.js"></script>
	<script type="text/javascript" src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
	<script src="/static/plugins/bootstrap/js/bootstrap.min.js"></script>
	<script src="/static/js/common.js"></script>
	<script src="/static/js/upLoad.js"></script>
<!-- 	<script src="//github.com/fyneworks/multifile/blob/master/jQuery.MultiFile.min.js" type="text/javascript" language="javascript"></script> -->
</body>
</html>