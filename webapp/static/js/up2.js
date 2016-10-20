$(document).ready(function() {
	$('.upFile').fileupload({
		url : '/api/gallery/up',
		dataType : 'json',
		// replaceFileInput: false,
		add : function(e, data) {
			var uploadFile = data.files[0];
			var isValid = true;
			if (!(/png|jpe?g|gif/i).test(uploadFile.name)) {
				alert('png, jpg, gif 만 가능합니다');
				isValid = false;
			} else if (uploadFile.size > 5000000) { // 5mb
				alert('파일 용량은 5메가를 초과할 수 없습니다.');
				isValid = false;
			}
			if (isValid) {
				data.submit();
			}
		},
		progressall : function(e, data) {
			var progress = parseInt(data.loaded / data.total * 100, 10);
			$('#progress .bar').css('width', progress + '%');
		},
		done : function(e, data) {
			alert(data)
			var code = data.result.code;
			var msg = data.result.msg;
			if (code == '1') {
				alert(msg);
			} else {
				alert(code + ' : ' + msg);
			}
		},
		fail : function(e, data) {
			// data.errorThrown
			// data.textStatus;
			// data.jqXHR;
			alert('서버와 통신 중 문제가 발생했습니다');
			foo = data;
		}
	});
});