$(function() {
    $("input").change(function() {
        var x = document.getElementById("photoSelect");
        var txt = "";
        if ('files' in x) {
            for (var i = 0; i < x.files.length; i++) {
                txt += "<br><strong>" + (i + 1) + ". file</strong><br>";
                var file = x.files[i];
                var filePath = URL.createObjectURL(event.target.files[i]);
                txt += "<img src='" + filePath + "' height='200' ><br>";
                txt += "name: " + file.name + "<br>";
                txt += "size: " + file.size + " bytes <br>";
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
    });


    $(".btnApply").on("click", function() {
        var photoSelects = document.getElementById("photoSelect");
        var data = new FormData();
        if (photoSelects.files.length == 0) {
            alert("파일을 선택해주세요!");
            $("#photoSelect").focus();

            return false;
        } else {
            for (var j = 0; j < photoSelects.files.length; j++) {
                var photoSelect = photoSelects.files[j];
                //			console.log("photoSelect="+photoSelect.name);

                data.append(nameing(), photoSelect);
                //			console.log("data="+data);
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
            });
        }
    });
});