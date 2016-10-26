$(function() {
	var photoId =

	function addPhotoList(photoName, photoUrl, totalCount) {
		var photoHTML = "";
		photoHTML += "<div class='col-lg-3 col-md-4 col-xs-6 thumb'>";
		photoHTML += "<a class='thumbnail' href='상세'>";
		photoHTML += "<img class='img-responsive' src="+photoUrl+" alt="">";
		photoHTML += photoName;
		photoHTML += "</a>";
		photoHTML += "<br>총 : "+totalCount+"개";
		photoHTML += "</div>";

		$(".photo-container").append(photoHTML);
	}

	function getPhotos(photoId) {
		$.ajax({
			url: "/api/gallery/main",
			method: "POST",
			data: {
				photoId: photoId
			}
		}).done(function(mapListPhotos) {
			$(".photo-container").empty();
			var totalCount = mapListPhotos.totalCount;

			for (var i=0;i<mapListPhotos.galleryList.length;i++) {
				var photoV = mapListPhotos.galleryList[i];

				var photoName = galleryList.photoName;
				var photoUrl = "";

				if (photoV.photoPath !== undefined && photoV.photoPath != null) {
					photoUrl = "/poroporo/files/" + galleryList.photoName;
				}

				addPhotoList(photoName, photoUrl, totalCount);
			}
		});
	}
});