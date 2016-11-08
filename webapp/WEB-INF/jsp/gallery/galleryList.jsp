<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Gallery</title>

    <link href="/static/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="/static/plugins/font-awesome/css/font-awesome.min.css">
    <link href="/static/plugins/bootstrap/css/thumbnail-gallery.css" rel="stylesheet">
	<link rel="stylesheet" href="/static/css/common.css" />

</head>

<body>
    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="/">PoroPoro</a>
            </div>
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li>
                        <a href="/gallery/upLoad">upLoad</a>
                    </li>
                    <li id="main-menu-login">
                        <a href="/member/login">LogIn</a>
                    </li>
                    <li>
                        <a href="/member/join">Join</a>
                    </li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>

    <div>
	    <form class="finder-form" action="" method="post">
 		   <table>
 			   <tr>
  				  <td><input id="finder-bar" type="text" placeholder="사진 검색"></td>
 				   <td><input id="finder-btn" type="submit" value=" "></td>
  			  </tr>
		    </table>
  	    </form>
    </div>

    <!-- Page Content -->
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header"><br>&nbsp;&nbsp;&nbsp;&nbsp;Gallery</h1>
            </div>

         	   <div class="photo-container">


         	   </div>

        </div>

        <hr>

        <!-- Footer -->
        <footer>
            <div class="row">
                <div class="col-lg-12">
                    <p>Gallery Website Project @ Is 2016</p>
                </div>
            </div>
        </footer>

    </div>
    <!-- /.container -->

    <script src="/static/plugins/bootstrap/js/jquery.js"></script>
    <script src="/static/plugins/bootstrap/js/bootstrap.min.js"></script>
    <script src="/static/js/gallery.js"></script>
</body>

</html>
