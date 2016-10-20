$(function() {
	$(".btnApply").on("click", function() {
		var photoSelect = $("#photoSelect").get(0);

		if (photoSelect == null) {
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
			var fileName = result.fileName;

			alert(fileName + "를 올렸습니다.");
			console.log(result);

			location.href = "/gallery/main";
		});
	});
});