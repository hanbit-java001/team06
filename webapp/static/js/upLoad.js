$(function() {
	$(".btnApply").on("click", function() {
		var photoSelect = $("#photoSelect").get(0);

		if (photoSelect == "") {
			alert("파일을 선택하세요.");
			$("#photoSelect").focus();
			return;
		}

		var data = new FormData();

		for (var i=0;i<photoSelect.files.length;i++) {
			var file = photoSelect.files[i];

			data.append("photoSelect", file);
		}

		$.ajax({
			url: "/api/gallery/upLoad",
			method: "POST",
			data: data,
			contentType: false,
			processData: false
		}).done(function(result) {
			var photoName = result.photoName;

			console.log(result);
			alert(photoName + "를 올렸습니다.");

			location.href = "/gallery/upLoad";
		});
	});
});