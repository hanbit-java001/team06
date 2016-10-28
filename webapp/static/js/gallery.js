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
					photoUrl = photoV.photoPath;
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

	function outNameGenerate(photoN){
		var fileObj, pathHeader, pathMiddle, pathEnd, allFilename, fileName, extName;
		fileObj = photoN;

		pathHeader = fileObj.lastIndexOf("\\");
		pathMiddle = fileObj.lastIndexOf(".");
		pathEnd = fileObj.length;
		fileName = fileObj.substring(pathHeader+1, pathMiddle);
		extName = fileObj.substring(pathMiddle+1, pathEnd);
		allFilename = fileName+"."+extName;

		return fileName; // 파일명
	}

//	function getThumbnail(photoP) {
//		File image = new File(photoP);
//		File thumbnail = new File("C:/poroporo/thumbnail.png");
//		if (image.exists()) {
//		    thumbnail.getParentFile().mkdirs();
//		    Thumbnails.of(image).size(400, 300).outputFormat("png").toFile(thumbnail);
//		}
//		return thumbnail
//	}
});