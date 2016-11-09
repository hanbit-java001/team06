$(function() {
      getPhotos();

      function addPhotoList(i, memberEmail, photoUrl, photoLike, readCount) {
         var photoHTML = "";
         photoHTML += "<div class='col-lg-3 col-md-4 col-xs-6 thumb'>";
         photoHTML += "<a class='thumbnail' href='#'>";
         photoHTML += "<img class='img-responsive' ";
         photoHTML += "src='" + photoUrl + "'> ";
         photoHTML += "</a>";
         photoHTML += memberEmail + "<br>";
         photoHTML += "<div class='icon-group'>"
         photoHTML += "<span class='like-icon' photoLike='" + photoLike + "' onclick='sumLike(photoId);'><i class='fa fa-thumbs-o-up'></i>"
         photoHTML += "<span class='num'>" + photoLike + "</span></span><br>";
         photoHTML += "<span class='read-icon' onclick='sumRead();'><i class='fa fa-eye' aria-hidden='true'></i>" + readCount + "</span>";
         photoHTML += "</div>";
         photoHTML += "</div>";

         $(".photo-container").append(photoHTML);

//         $(".like-icon").on("click", function() {
//            $(this).append(photoLike + 1);
            //     	 var photoLike = $(this).attr("photoLike")
            //     	 photoLike = photoLike+1;
            //     	 $(this+">.num").text(photoLike);
         });
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

               addPhotoList(i, memberEmail, photoUrl, photoLike, readCount);
            }

//            $.ajax({
//               url: "/api/sumLike/gallery/galleryList",
//               method: "POST",
//               data: {
//                  photoId: photoId
//               }
//            }).done(function(readC) {
//
//            });
//         });

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
$("#finder-bar").on("keyup", function(event) {
   if (event.keyCode != 13) {
      return;
   }
   var findWord = $("#finder-bar").val();

   $.ajax({
      url: "/find/gallery/galleryList",
      method: 'POST',
      data: {
         findWord: findWord
      }
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
   });
});
});
});