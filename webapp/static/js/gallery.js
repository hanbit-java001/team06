$(function() {
	$(".btnApply").on("click", function() {
		var photoName = $("#photoName").val().trim();
		var photoSelect = $("#photoSelect").get(0);

		if (photoSelect == null) {
			alert("파일을 선택하세요.");
			$("#photoSelect").focus();
			return;
		}
		else if (photoName == "") {
			alert("제목을 입력하세요.");
			$("#photoName").focus();
			return;
		}

		var data = new FormData();

		data.append("photoName", photoName);

		for (var i=0;i<imgProfile.files.length;i++) {
			var file = imgProfile.files[i];

			data.append("photoSelect", file);
		}

		$.ajax({
			url: "/api/gallery/upLoad",
			method: "POST",
			data: data,
			contentType: false,
			processData: false
		}).done(function(result) {
			console.log(result);
		});
	});
});