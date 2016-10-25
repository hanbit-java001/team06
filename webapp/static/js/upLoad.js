$(function() {
	$("input").change(function(){
		var data = $("#photoSelect").attr.value("files[]");
//		console.log(data);
	});

	$(".btnApply").on("click", function() {
		var photoSelect = [];
		 photoSelect.push($("#photoSelect").val());

		 console.log($("#photoSelect"));
//
//		for(var j=0;j<photoSelect.length; j++){
//			photoSelect = $("#photoSelect").get(j);
////			console.log(photoSelect);
		}
		if (photoSelect != "") {

			function nameing() {
				 var fileObj, pathHeader, pathMiddle, pathEnd, allFilename, fileName, extName;
				 fileObj = photoSelect.value

				 pathHeader = fileObj.lastIndexOf("\\");
		         pathMiddle = fileObj.lastIndexOf(".");
		         pathEnd = fileObj.length;
		         fileName = fileObj.substring(pathHeader+1, pathMiddle);
		         extName = fileObj.substring(pathMiddle+1, pathEnd);
		         allFilename = fileName+"."+extName;

		         return allFilename; // 실제파일명
			}

			var data = new FormData();
			console.log(data);

			for (var i=0;i<photoSelect.files.length;i++) {
				var file = photoSelect.files[i];

				data.append(nameing(), file);
				console.log(data);
			}

			$.ajax({
				url: "/api/gallery/upLoad",
				method: "POST",
				data: data,
				contentType: false,
				processData: false
			}).done(function(result) {
				console.log(result);
				var photoName = "";
				var photoNames = "";

				for(var i=0;i<result.length;i++){
					photoName = result[i];
					photoNames = photoNames + photoName + "\n";

					console.log(photoName);
					console.log(photoNames);

				}
				console.log(photoNames);
				alert(photoNames + "파일을 올렸습니다.");
//				location.href = "/gallery/upLoad";
			});

		}else {alert("파일을 선택해주세요!");
			$("#photoSelect").focus();

			return false;
		}
	});
});