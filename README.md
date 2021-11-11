# oodt-api

html 영역을 캔버스 이용하여 이미지 변환후 
서버로 저장

index2.jsp 


document.getElementById("btn_convert1").addEventListener("click", function() {
html2canvas(document.getElementById("html-content-holder")).then(function (canvas) {
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
