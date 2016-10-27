$(function() {
	getPhotos();
	function addPhotoList(photoName, photoUrl, totalCount) {
		var photoHTML = "";
		photoHTML += "<div class='col-lg-3 col-md-4 col-xs-6 thumb'>";
		photoHTML += "<a class='thumbnail' href='#'>";
		photoHTML += "<img class='img-responsive' ";
		photoHTML += "src='"+photoUrl+"' ";
		photoHTML += "style='background-image:";
		photoHTML += " url("+photoUrl+");'>";
		photoHTML += "</a>";
		photoHTML += photoName;
		photoHTML += "<br>총 : "+totalCount+"개";
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
				outNameGenerate(photoV.photoName);
				var photoUrl = "";

				if (photoV.photoPath !== undefined && photoV.photoPath != null) {
					photoUrl = photoV.photoPath;
					console.log("photoUrl="+photoUrl);
				} //else {
//					throw new RuntimeException(e.getMessage(), e);
//				}

				addPhotoList(photoName, photoUrl, totalCount);
			}
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
});