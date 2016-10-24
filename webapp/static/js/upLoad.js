$(function() {
	$(".btnApply").on("click", function() {
		var photoSelect = $("#photoSelect").get(0);

		if (photoSelect != "") {

			function nameing() {
				 var fileObj, pathHeader , pathMiddle, pathEnd, allFilename, fileName, extName;
				 fileObj = photoSelect.value

				 pathHeader = fileObj.lastIndexOf("\\");
		         pathMiddle = fileObj.lastIndexOf(".");
		         pathEnd = fileObj.length;
		         fileName = fileObj.substring(pathHeader+1, pathMiddle);
		         extName = fileObj.substring(pathMiddle+1, pathEnd);
		         allFilename = fileName+"."+extName;

		         return fileName; // 순수 파일명
			}

			var data = new FormData();

			for (var i=0;i<photoSelect.files.length;i++) {
				var file = photoSelect.files[i];

				data.append(nameing(), file);
			}

			$.ajax({
				url: "/api/gallery/upLoad",
				method: "POST",
				data: data,
				contentType: false,
				processData: false
			}).done(function(result) {
				var photoName = result;

				console.log(result);
				alert(photoName + "를 올렸습니다.");

				location.href = "/gallery/upLoad";
			});

		}else {alert("파일을 선택해주세요!");
			$("#photoSelect").focus();

			return false;
		}
	});
});