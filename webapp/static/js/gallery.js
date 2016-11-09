$(function() {
      getPhotos();

      function addPhotoList(i, memberEmail, photoUrl, photoLike, readCount) {
         var photoHTML = "";
         var photoHTML2 = "";
         photoHTML += "<div class='col-lg-3 col-md-4 col-sm-6 col-xs-12 mbr-gallery-item'>";
         photoHTML += "<figcaption class='mbr-figure__caption mbr-figure__caption--std-grid'>";
         photoHTML += "<div class='mbr-caption-background'></div>";
         photoHTML += "<small class='mbr-figure__caption-small'>"+memberEmail;
         photoHTML += "</small><span class='mbr-figure__caption-small'><i class='fa fa-thumbs-o-up'></i>"+photoLike+"</span>";
         photoHTML += "</figcaption>";
         photoHTML += "<a href='#lb-gallery2-6' data-slide-to='"+i+"' data-toggle='modal'>";
         photoHTML += "<img alt='' src='"+photoUrl+"'>";
         photoHTML += "<span class='icon glyphicon glyphicon-zoom-in'></span>";
         photoHTML += "</a>";
         photoHTML += "</div>";

         $(".mbr-gallery-row").append(photoHTML);

         photoHTML2 += "<div class='item active'>";
         photoHTML2 += "<img alt='' src='"+photoUrl+"'>";
         photoHTML2 += "</div>";

         $(".carousel-inner").append(photoHTML2);

//         $(".like-icon").on("click", function() {  active
//            $(this).append(photoLike + 1);
            //     	 var photoLike = $(this).attr("photoLike")
            //     	 photoLike = photoLike+1;
            //     	 $(this+">.num").text(photoLike);

      }

      function getPhotos() {
         $.ajax({
            url: "/api/gallery/galleryList",
            method: "POST",
         }).done(function(mapListPhotos) {
            $(".mbr-gallery-row").empty();
            var totalCount = mapListPhotos.totalCount;

            for (var i = 0; i < mapListPhotos.galleryList.length; i++) {
               var photoV = mapListPhotos.galleryList[i];

               var memberEmail = photoV.memberEmail;
               var photoUrl = "";
               var photoLike = photoV.photoLike;
               var readCount = photoV.readCount;
               var photoId = photoV.photoId;

               if (photoV.photoPath !== undefined && photoV.photoPath != null) {
                  photoUrl = photoV.photoPath;
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
    			  $(".mbr-gallery-row").empty();

    			  for (var i = 0; i < findListPhotos.galleryList.length; i++) {
    				  var photoV = findListPhotos.galleryList[i];

    				  var memberEmail = photoV.memberEmail;
    				  var photoUrl = "";
    				  var photoLike = photoV.photoLike;
    				  var readCount = photoV.readCount;
    				  var photoId = photoV.photoId;

    				  if (photoV.photoPath !== undefined && photoV.photoPath != null) {
    					  photoUrl = photoV.photoPath;
    					  console.log("photoUrl=" + photoUrl);
    				  } else {
    					  throw new RuntimeException(e.getMessage(), e);
    				  }

    				  addPhotoList(photoId, memberEmail, photoUrl, photoLike, readCount);
    			  }
    		  });
    	  });

  });
