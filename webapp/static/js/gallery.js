$(function() {
   getPhotos();

   function addPhotoList(photoId, memberEmail, photoUrl, photoLike, readCount) {
      var photoHTML = "";
      photoHTML += "<div class='col-lg-3 col-md-4 col-xs-6 thumb'>";
      photoHTML += "<a class='thumbnail' href='#'>";
      photoHTML += "<img class='img-responsive' ";
      photoHTML += "src='" + photoUrl + "'> ";
      photoHTML += "</a>";
      photoHTML += memberEmail + "<br>";
      photoHTML += "<div class='icon-group'>"
      photoHTML += "<span class='like-icon' onclick='sumLike(photoId);'><i class='fa fa-thumbs-o-up'></i>" + photoLike + "</span><br>";
      photoHTML += "<span class='read-icon' onclick='sumRead();'><i class='fa fa-eye' aria-hidden='true'></i>" + readCount + "</span>";
      photoHTML += "</div>";
      photoHTML += "</div>";

      $(".photo-container").append(photoHTML);
   }

   function getPhotos() {
      $.ajax({
         url: "/api/gallery/galleryList",
         method: "POST",
      }).done(function(mapListPhotos) {
         $(".photo-container").empty();
         var totalCount = mapListPhotos.totalCount;

         for (var i = 0; i < mapListPhotos.galleryList.length; i++) {
            var photoV = mapListPhotos.galleryList[i];

            var memberEmail = photoV.memberEmail;
            var photoUrl = "";
            var photoLike = photoV.photoLike;
            var readCount = photoV.readCount;
            var photoId = photoV.photoId;

            if (photoV.photoPath !== undefined && photoV.photoPath != null) {
               photoUrl = thumbGenerate(photoV.thumb);
               console.log("photoUrl=" + photoUrl);
            } else {
               throw new RuntimeException(e.getMessage(), e);
            }

            addPhotoList(photoId, memberEmail, photoUrl, photoLike, readCount);
         }
         var totalHTML = "&nbsp&nbsp&nbsp&nbsp&nbsp총 : " + totalCount + "개<br>";
         $(".page-header").append(totalHTML);
      });
   }

   function thumbGenerate(photoThumb) {
      var fileObj, pathHeader, pathMiddle, pathEnd, fileName, extName;
      fileObj = photoThumb;

      pathHeader = fileObj.indexOf("/") - 1;
      pathMiddle = fileObj.lastIndexOf(".");
      pathEnd = fileObj.length;
      fileName = fileObj.substring(pathHeader + 1, pathMiddle);
      extName = fileObj.substring(pathMiddle + 1, pathEnd);

      return fileName; // 파일명
   }

   $("#finder-btn").on("click", function() {
	   var params = jQuery("#finder-btn").serialize();
	   $.ajax({
           url: "/find/gallery/galleryList",
           method: 'POST',
           data:params
       }).done(function(findListPhotos) {
    	   $(".photo-container").empty();

           for (var i = 0; i < findListPhotos.galleryList.length; i++) {
              var photoV = findListPhotos.galleryList[i];

              var memberEmail = photoV.memberEmail;
              var photoUrl = "";
              var photoLike = photoV.photoLike;
              var readCount = photoV.readCount;
              var photoId = photoV.photoId;

              if (photoV.photoPath !== undefined && photoV.photoPath != null) {
                 photoUrl = thumbGenerate(photoV.thumb);
                 console.log("photoUrl=" + photoUrl);
              } else {
                 throw new RuntimeException(e.getMessage(), e);
              }

              addPhotoList(photoId, memberEmail, photoUrl, photoLike, readCount);
           }
           var totalHTML = "&nbsp&nbsp&nbsp&nbsp&nbsp총 : " + totalCount + "개<br>";
           $(".page-header").append(totalHTML);
       });
	});

//   function sumLike(photoId) {
//         var likeN = Document. + 1;
//         $(this).txet(likeN);
//
//         $.ajax({
//            url: "/api/sumLike/gallery/galleryList",
//            method: "POST",
//            data: {
//               photoId: photoId
//            }
//         }).done(function(readC) {
//
//         });
//   }

   function sumRead() {
      var iconClass = $(this).val();
      console.log(iconClass);
//      if (iconClass == "read-count") {
//         var readN = readCount + 1;
//         $(".read-count").append(readN);
//
//         $.ajax({
//            url: "/api/sumRead/gallery/galleryList",
//            method: "POST",
//            data: {
//               photoId: photoId
//            }
//         }).done(function(photoL) {
//
//         });
//
//      }
   }
});