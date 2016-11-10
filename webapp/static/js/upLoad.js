$(function() {
    $("input").change(function() {
        var x = document.getElementById("photoSelect");
        var txt = "";
        if ('files' in x) {
            for (var i = 0; i < x.files.length; i++) {
//                txt += "<br><strong>" + (i + 1) + ". file</strong><br>";
                var file = x.files[i];
                var filePath = URL.createObjectURL(event.target.files[i]);
                txt += "<div class='divp'>";
                txt += "<hr style='border: solid 1px green;'>";
                txt += "<img src='" + filePath + "' height='150' >";
                txt += "<input id='hashInput"+i+"' class='form-control' type='text' placeholder='해시태그는 , 를 넣어서 3개 까지만 입력해주세요.' onkeyup='' onblur=''><br>";
                txt += "<span class='file-name'>name: " + file.name + "<br></span>";
                txt += "<span class='file-size'>size: " + file.size + " bytes</span><br>";
                txt += "</div>";
            }
        } else {
            if (x.value == "") {
                txt += "Select one or more files.";
            } else {
                txt += "The files property is not supported by your browser!";
                txt += "<br>The path of the selected file: " + x.value;
            }
        }
        document.getElementById("filetxt").innerHTML = txt;
        hashTag();
    });

    function hashTag() {
    	$.ajax({
            url: "/hash/gallery/upLoad",
            method: 'POST',
        }).done(function(result) {
        	var hashName, hashNames, htmlTxt;
        	htmlTxt = "<h4 class'hTag' style='color: #9c9c9c;'>추천해시태그 : </h4><br><ul>";
        	for (var h = 0; h < result.length; h++) {
                hashName = result[h];
                hashNames = hashNames + hashName + "\n";

                htmlTxt += "<li class='liTag'>"+hashName+"</li>";
            }
        	htmlTxt += "</ul>";
        	$("#hashtxt").append(htmlTxt);
        });
	}

    $(".btnApply").on("click", function() {
        var photoSelects = document.getElementById("photoSelect");
        var hashTags;
        var data = new FormData();
        if (photoSelects.files.length == 0) {
            alert("파일을 선택해주세요!");
            $("#photoSelect").focus();

            return false;
        } else {
            for (var j = 0; j < photoSelects.files.length; j++) {
                var photoSelect = photoSelects.files[j];
                hashTags = document.getElementById("hashInput"+j).value;
//                			console.log("photoSelect="+photoSelect.name);
//                			console.log("hashInput="+hashTags);

                data.append(nameing(), photoSelect);
                data.append("hashTag"+j, hashTags)
//                console.log("data="+data.hashTag+j);
            }

            function nameing() {
                var fileObj, pathHeader, pathMiddle, pathEnd, allFilename, fileName, extName;
                fileObj = photoSelect.name

                pathHeader = fileObj.lastIndexOf("\\");
                pathMiddle = fileObj.lastIndexOf(".");
                pathEnd = fileObj.length;
                fileName = fileObj.substring(pathHeader + 1, pathMiddle);
                extName = fileObj.substring(pathMiddle + 1, pathEnd);
                allFilename = fileName + "." + extName;

                return allFilename; // 실제파일명
            }

            function enter(e) {
            	if(e.keyCode == 13){
            		e.cancelBubble = true;
            		$("#btn_search").click();
            		return false;
            	}
			}

            function hashValidate(e) {
            	uid.val()
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

                for (var i = 0; i < result.length; i++) {
                    photoName = result[i];
                    photoNames = photoNames + photoName + "\n";

                    //				console.log("photoName="+photoName);
                }
                //			console.log("photoNames="+photoNames);
                alert(photoNames + "파일을 올렸습니다.");
                //			location.href = "/gallery/upLoad";
                location.reload();
            });
        }
    });
});