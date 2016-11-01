$(function() {
	getPhotos();
	function addPhotoList(photoName, photoUrl) {
		var photoHTML = "";
		photoHTML += "<div class='col-lg-3 col-md-4 col-xs-6 thumb'>";
		photoHTML += "<a class='thumbnail' href='#'>";
		photoHTML += "<img class='img-responsive' ";
		photoHTML += "src='"+photoUrl+"'> ";
		photoHTML += "</a>";
		photoHTML += photoName;
		photoHTML += "</div>";

		$(".photo-container").append(photoHTML);
	}

	function getPhotos(/*photoId*/) {
		$.ajax({
			url: "/api/gallery/main",
			method: "POST",
//			data: {
//				photoId: photoId
//			}
		}).done(function(mapListPhotos) {
			$(".photo-container").empty();
			var totalCount = mapListPhotos.totalCount;

			for (var i=0;i<mapListPhotos.galleryList.length;i++) {
				var photoV = mapListPhotos.galleryList[i];

				var photoName = photoV.photoName;
				var photoUrl = "";

				if (photoV.photoPath !== undefined && photoV.photoPath != null) {
					photoUrl = thumbGenerate(photoV.thumb);
					console.log("photoUrl="+photoUrl);
				} //else {
//					throw new RuntimeException(e.getMessage(), e);
//				}

				addPhotoList(photoName, photoUrl);
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

});