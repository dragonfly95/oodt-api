<%@ page language="java" contentType="text/html;charset=utf-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>

    <div id="html-content-holder" style="background-color: #F0F0F1; color: #00cc65; width: 500px;
        padding-left: 25px; padding-top: 10px;">
        <strong>Codepedia.info</strong><hr />
        <h2 style="color: #3e4b51;">
            Html to canvas, and canvas to proper image
        </h2>
        <p style="color: #3e4b51;">
            <b>Codepedia.info</b> is a programming blog. Tutorials focused on Programming ASP.Net,
            C#, jQuery, AngularJs, Gridview, MVC, Ajax, Javascript, XML, MS SQL-Server, NodeJs,
            Web Design, Software</p>
        <p style="color: #3e4b51;">
            <b>html2canvas</b> script allows you to take "screenshots" of webpages or parts
            of it, directly on the users browser. The screenshot is based on the DOM and as
            such may not be 100% accurate to the real representation as it does not make an
            actual screenshot, but builds the screenshot based on the information available
            on the page.
        </p>
    </div>
    <input id="btn-Preview-Image" type="button" value="Preview" />
    <a id="btn-Convert-Html2Image" href="#">Download</a>
    <input type="button" value="Preview & Convert" id="btnConvert" >
    <br />
    <h3>Preview :</h3>
    <div id="previewImage">
    </div>

    <button id="btn_convert1">화면캡쳐</button>

<script src="https://code.jquery.com/jquery-3.1.0.js"></script>
<script src="https://cdn.polyfill.io/v2/polyfill.min.js"></script>
<script src="static/html2canvas.min.js" type="text/javascript"></script>
<script>

 document.getElementById("btn_convert1").addEventListener("click", function() {
	html2canvas(document.getElementById("html-content-holder")).then(function (canvas) {
        // document.getElementById("previewImage").appendChild(canvas);
        // var anchorTag = document.createElement("a");
        // document.body.appendChild(anchorTag);
        // anchorTag.href = canvas.toDataURL();
        // anchorTag.download = "filename.jpg";
        // anchorTag.click();
        // anchorTag.target = '_blank';

        var imgDataUrl = canvas.toDataURL('image/png');

        var blobBin = atob(imgDataUrl.split(',')[1]);	// base64 데이터 디코딩
        var array = [];
        for (var i = 0; i < blobBin.length; i++) {
            array.push(blobBin.charCodeAt(i));
        }
        var file = new Blob([new Uint8Array(array)], {type: 'image/png'});	// Blob 생성
        var formdata = new FormData();	// formData 생성
        formdata.append("file", file, "2.png");	// file data 추가
       // formdata.append("filename", "1.png");
        $.ajax({
            type : 'post',
            url : '/saveImage',
            data : formdata,
            processData : false,	// data 파라미터 강제 string 변환 방지!!
            contentType : false,	// application/x-www-form-urlencoded; 방지!!
            success : function (data) {
                console.log(data);
            }
        });
    });
 });

</script>
</body>
</html>