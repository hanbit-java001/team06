$(function() {
	getPhotos();
	function addPhotoList(photoId,memberEmail, photoUrl, photoLike, readCount) {
		var photoHTML = "";
		photoHTML += "<div class='col-lg-3 col-md-4 col-xs-6 thumb'>";
		photoHTML += "<a class='thumbnail' href='#'>";
		photoHTML += "<img class='img-responsive' ";
		photoHTML += "src='"+photoUrl+"'> ";
		photoHTML += "</a>";
		photoHTML += memberEmail+"<br>";
		photoHTML += "<i class='fa fa-thumbs-o-up'>"+photoLike+"</i><br>"; //aria-hidden="+sumLike(photoId)+"
		photoHTML += "<i class='fa fa-thumbs-down'>"+photoLike+"</i><br>";
		photoHTML += readCount;
		photoHTML += "</div>";

		$(".photo-container").append(photoHTML);
	}

	function getPhotos(/*photoId*/) {
		$.ajax({
			url: "/api/gallery/galleryList",
			method: "POST",
//			data: {
//				photoId: photoId
//			}
		}).done(function(mapListPhotos) {
			$(".photo-container").empty();
			var totalCount = mapListPhotos.totalCount;

			for (var i=0;i<mapListPhotos.galleryList.length;i++) {
				var photoV = mapListPhotos.galleryList[i];

				var memberEmail = photoV.memberEmail;
				var photoUrl = "";
				var photoLike = photoV.photoLike;
				var readCount = photoV.readCount;
				var photoId = photoV.photoId;

				if (photoV.photoPath !== undefined && photoV.photoPath != null) {
					photoUrl = thumbGenerate(photoV.thumb);
//					console.log("photoUrl="+photoUrl);
				} //else {
//					throw new RuntimeException(e.getMessage(), e);
//				}

				addPhotoList(photoId, memberEmail, photoUrl, photoLike, readCount);
			}
			var totalHTML = "&nbsp&nbsp&nbsp&nbsp&nbsp총 : "+totalCount+"개<br>";
			$(".page-header").append(totalHTML);
		});
	}

	function thumbGenerate(photoThumb){
		var fileObj, pathHeader, pathMiddle, pathEnd, fileName, extName;
		fileObj = photoThumb;

		pathHeader = fileObj.indexOf("/")-1;
		pathMiddle = fileObj.lastIndexOf(".");
		pathEnd = fileObj.length;
		fileName = fileObj.substring(pathHeader+1, pathMiddle);
		extName = fileObj.substring(pathMiddle+1, pathEnd);

		return fileName; // 파일명
	}

	function showLikeIcon(photoId) {
		if (photoId) {
			$(".fa fa-thumbs-o-up").hide();
			$(".fa fa-thumbs-down").css("display", "inline-block");
		}
		else {
			$(".fa fa-thumbs-down").hide();
			$(".fa fa-thumbs-o-up").css("display", "inline-block");
		}
	}

	function sumLike(photoId) {
		$(".fa fa-thumbs-o-up").on("click", function() {
			$.ajax({
			url: "/api/sum/gallery/galleryList",
			method: "POST",
			data: {
				photoId: photoId
			}
		}).done(function(photoLike) {

			return;
		}
		});
	}

});