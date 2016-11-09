<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="shortcut icon"
	href="/static/assets/images/logo-128x128-66.png" type="image/x-icon">
<meta name="description" content="">

<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Roboto:700,400&amp;subset=cyrillic,latin,greek,vietnamese">
<link rel="stylesheet"
	href="/static/assets/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/static/assets/socicon/css/socicon.min.css">
<link rel="stylesheet" href="/static/assets/mobirise/css/style.css">
<link rel="stylesheet" href="/static/assets/mobirise-slider/style.css">
<link rel="stylesheet" href="/static/assets/mobirise-gallery/style.css">
<link rel="stylesheet" href="/static/assets/mobirise/css/mbr-additional.css" type="text/css">
<link rel="stylesheet" href="/static/plugins/font-awesome/css/font-awesome.min.css">
<link rel="stylesheet" href="/static/css/common.css" />
<link rel="stylesheet" href="/static/css/main.css" type="text/css">



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
						<div>
						    <form id="finder-form" class="finder-form" onsubmit="return false;" name="finder-form" action="" method="post">
 							   <table>
 								   <tr>
  									  <td><input id="finder-bar" name="finder-bar" type="text" placeholder="사진 검색"></td>
 									   <td><input id="finder-btn" name="finder-btn" type="button" value=""><i class="fa fa-search" aria-hidden="true"></i></td>
  								  </tr>
							   </table>
  	    					</form>
    					</div>
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
										href="/">UPLOAD</a></li>
									<li class="afterLogin mbr-navbar__item" id="menuLogout"><a
										class="mbr-buttons__link btn text-black"
										href="/">LOGOUT</a></li>
								</ul>

							</div>
						</nav>
					</div>
				</div>
			</div>
		</div>
	</section>

	<section class="mbr-gallery mbr-section mbr-section--no-padding"
		id="gallery2-6">
		<!-- Gallery -->
		<div
			class="mbr-section__container mbr-gallery-layout-article mbr-section__container--first">
			<div>
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
				<div class="row mbr-gallery-row">
<!-- 					photo Conteiner -->

				</div>
			</div>
			<div class="clearfix"></div>
		</div>

		<!-- Lightbox -->
		<div data-app-prevent-settings=""
			class="mbr-slider modal fade carousel slide" tabindex="-1"
			data-keyboard="true" data-interval="false" id="lb-gallery2-6">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-body">

						<div class="carousel-inner">
<!-- 							photo scroll -->

						</div>
						<a class="left carousel-control" role="button" data-slide="prev"
							href="#lb-gallery2-6"> <span
							class="glyphicon glyphicon-menu-left" aria-hidden="true"></span>
							<span class="sr-only">Previous</span>
						</a> <a class="right carousel-control" role="button" data-slide="next"
							href="#lb-gallery2-6"> <span
							class="glyphicon glyphicon-menu-right" aria-hidden="true"></span>
							<span class="sr-only">Next</span>
						</a> <a class="close" href="#" role="button" data-dismiss="modal">
							<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
							<span class="sr-only">Close</span>
						</a>
					</div>
				</div>
			</div>
		</div>
	</section>

	<section class="mbr-gallery mbr-section mbr-section--no-padding"
		id="gallery2-7">
		<!-- Gallery -->
		<div
			class="mbr-section__container mbr-gallery-layout-article mbr-section__container--last">
			<div>
				<div class="row mbr-gallery-row">

					<div class="col-lg-3 col-md-4 col-sm-6 col-xs-12 mbr-gallery-item">

						<figcaption
							class="mbr-figure__caption mbr-figure__caption--std-grid">
							<div class="mbr-caption-background"></div>
							<small class="mbr-figure__caption-small">Type caption
								here</small>
						</figcaption>

						<a href="#lb-gallery2-7" data-slide-to="0" data-toggle="modal">
							<img alt="" src="/static/assets/images/slide1-small.jpg"> <span
							class="icon glyphicon glyphicon-zoom-in"></span>
						</a>
					</div>
					<div class="col-lg-3 col-md-4 col-sm-6 col-xs-12 mbr-gallery-item">

						<figcaption
							class="mbr-figure__caption mbr-figure__caption--std-grid">
							<div class="mbr-caption-background"></div>
							<small class="mbr-figure__caption-small">Type caption
								here</small>
						</figcaption>

						<a href="#lb-gallery2-7" data-slide-to="1" data-toggle="modal">
							<img alt="" src="/static/assets/images/slide2-small.jpg"> <span
							class="icon glyphicon glyphicon-zoom-in"></span>
						</a>
					</div>
					<div class="col-lg-3 col-md-4 col-sm-6 col-xs-12 mbr-gallery-item">

						<figcaption
							class="mbr-figure__caption mbr-figure__caption--std-grid">
							<div class="mbr-caption-background"></div>
							<small class="mbr-figure__caption-small">Type caption
								here</small>
						</figcaption>

						<a href="#lb-gallery2-7" data-slide-to="2" data-toggle="modal">
							<img alt="" src="/static/assets/images/slide3-small.jpg"> <span
							class="icon glyphicon glyphicon-zoom-in"></span>
						</a>
					</div>
					<div class="col-lg-3 col-md-4 col-sm-6 col-xs-12 mbr-gallery-item">

						<figcaption
							class="mbr-figure__caption mbr-figure__caption--std-grid">
							<div class="mbr-caption-background"></div>
							<small class="mbr-figure__caption-small">Type caption
								here</small>
						</figcaption>

						<a href="#lb-gallery2-7" data-slide-to="3" data-toggle="modal">
							<img alt="" src="/static/assets/images/slide4-small.jpg"> <span
							class="icon glyphicon glyphicon-zoom-in"></span>
						</a>
					</div>
					<div class="col-lg-3 col-md-4 col-sm-6 col-xs-12 mbr-gallery-item">

						<figcaption
							class="mbr-figure__caption mbr-figure__caption--std-grid">
							<div class="mbr-caption-background"></div>
							<small class="mbr-figure__caption-small">Type caption
								here</small>
						</figcaption>

						<a href="#lb-gallery2-7" data-slide-to="4" data-toggle="modal">
							<img alt="" src="/static/assets/images/slide5-small.jpg"> <span
							class="icon glyphicon glyphicon-zoom-in"></span>
						</a>
					</div>
					<div class="col-lg-3 col-md-4 col-sm-6 col-xs-12 mbr-gallery-item">

						<figcaption
							class="mbr-figure__caption mbr-figure__caption--std-grid">
							<div class="mbr-caption-background"></div>
							<small class="mbr-figure__caption-small">Type caption
								here</small>
						</figcaption>

						<a href="#lb-gallery2-7" data-slide-to="5" data-toggle="modal">
							<img alt="" src="/static/assets/images/slide6-small.jpg"> <span
							class="icon glyphicon glyphicon-zoom-in"></span>
						</a>
					</div>
					<div class="col-lg-3 col-md-4 col-sm-6 col-xs-12 mbr-gallery-item">

						<figcaption
							class="mbr-figure__caption mbr-figure__caption--std-grid">
							<div class="mbr-caption-background"></div>
							<small class="mbr-figure__caption-small">Type caption
								here</small>
						</figcaption>

						<a href="#lb-gallery2-7" data-slide-to="6" data-toggle="modal">
							<img alt="" src="/static/assets/images/slide7-small.jpg"> <span
							class="icon glyphicon glyphicon-zoom-in"></span>
						</a>
					</div>
					<div class="col-lg-3 col-md-4 col-sm-6 col-xs-12 mbr-gallery-item">

						<figcaption
							class="mbr-figure__caption mbr-figure__caption--std-grid">
							<div class="mbr-caption-background"></div>
							<small class="mbr-figure__caption-small">Type caption
								here</small>
						</figcaption>

						<a href="#lb-gallery2-7" data-slide-to="7" data-toggle="modal">
							<img alt="" src="/static/assets/images/slide8-small.jpg"> <span
							class="icon glyphicon glyphicon-zoom-in"></span>
						</a>
					</div>
				</div>
			</div>
			<div class="clearfix"></div>
		</div>

		<!-- Lightbox -->
		<div data-app-prevent-settings=""
			class="mbr-slider modal fade carousel slide" tabindex="-1"
			data-keyboard="true" data-interval="false" id="lb-gallery2-7">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-body">
						<ol class="carousel-indicators">
							<li data-app-prevent-settings="" data-target="#lb-gallery2-7"
								class=" active" data-slide-to="0"></li>
							<li data-app-prevent-settings="" data-target="#lb-gallery2-7"
								data-slide-to="1"></li>
							<li data-app-prevent-settings="" data-target="#lb-gallery2-7"
								data-slide-to="2"></li>
							<li data-app-prevent-settings="" data-target="#lb-gallery2-7"
								data-slide-to="3"></li>
							<li data-app-prevent-settings="" data-target="#lb-gallery2-7"
								data-slide-to="4"></li>
							<li data-app-prevent-settings="" data-target="#lb-gallery2-7"
								data-slide-to="5"></li>
							<li data-app-prevent-settings="" data-target="#lb-gallery2-7"
								data-slide-to="6"></li>
							<li data-app-prevent-settings="" data-target="#lb-gallery2-7"
								data-slide-to="7"></li>
						</ol>
						<div class="carousel-inner">
							<div class="item active">
								<img alt="" src="/static/assets/images/slide1.jpg">
							</div>
							<div class="item">
								<img alt="" src="/static/assets/images/slide2.jpg">
							</div>
							<div class="item">
								<img alt="" src="/static/assets/images/slide3.jpg">
							</div>
							<div class="item">
								<img alt="" src="/static/assets/images/slide4.jpg">
							</div>
							<div class="item">
								<img alt="" src="/static/assets/images/slide5.jpg">
							</div>
							<div class="item">
								<img alt="" src="/static/assets/images/slide6.jpg">
							</div>
							<div class="item">
								<img alt="" src="/static/assets/images/slide7.jpg">
							</div>
							<div class="item">
								<img alt="" src="/static/assets/images/slide8.jpg">
							</div>
						</div>
						<a class="left carousel-control" role="button" data-slide="prev"
							href="#lb-gallery2-7"> <span
							class="glyphicon glyphicon-menu-left" aria-hidden="true"></span>
							<span class="sr-only">Previous</span>
						</a> <a class="right carousel-control" role="button" data-slide="next"
							href="#lb-gallery2-7"> <span
							class="glyphicon glyphicon-menu-right" aria-hidden="true"></span>
							<span class="sr-only">Next</span>
						</a> <a class="close" href="#" role="button" data-dismiss="modal">
							<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
							<span class="sr-only">Close</span>
						</a>
					</div>
				</div>
			</div>
		</div>
	</section>

	<section
		class="mbr-section mbr-section--relative mbr-section--fixed-size"
		id="social-buttons1-6" style="background-color: rgb(255, 255, 255);">


		<div class="mbr-section__container container">
			<div class="mbr-header mbr-header--inline row"
				style="padding-top: 0px; padding-bottom: 0px;">
				<div class="col-sm-4">
					<h3 class="mbr-header__text">Share with Friends!</h3>
				</div>
				<div class="mbr-social-icons col-sm-8">
					<div class="mbr-social-likes social-likes_style-1"
						data-counters="false">
						<div
							class="mbr-social-icons__icon social-likes__icon facebook socicon-bg-facebook"
							title="Share link on Facebook">
							<i class="socicon socicon-facebook"></i>

						</div>
						<div
							class="mbr-social-icons__icon social-likes__icon plusone socicon-bg-googleplus"
							title="Share link on Google+">
							<i class="socicon socicon-googleplus"></i>

						</div>
						<div
							class="mbr-social-icons__icon social-likes__icon twitter socicon-bg-twitter"
							title="Share link on Twitter">
							<i class="socicon socicon-twitter"></i>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>

	<footer
		class="mbr-section mbr-section--relative mbr-section--fixed-size"
		id="footer1-9" style="background-color: rgb(255, 255, 255);">

		<div class="mbr-section__container container">
			<div class="mbr-footer mbr-footer--wysiwyg row"
				style="padding-top: 12.3px; padding-bottom: 12.3px;">
				<div class="col-sm-12">
					<p class="mbr-footer__copyright">Copyright (c) 2016 PoroPoro
						Service</p>
				</div>
			</div>
		</div>
	</footer>


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
	<script type="text/javascript" src="https://static.nid.naver.com/js/naverLogin_implicit-1.0.2.js" charset="utf-8"></script>
	<script type="text/javascript" src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
	<script src="/static/js/naverIdLoginInit.js"></script>
	<script src="/static/js/naverIdLoginCallbeck.js"></script>
	<script src="/static/plugins/bootstrap/js/bootstrap.min.js"></script>
	<script src="/static/js/common.js"></script>
	<script src="/static/js/naverIdLogOut.js"></script>


</body>
</html>