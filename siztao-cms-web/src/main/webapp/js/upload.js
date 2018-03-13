/**
 * Created by gp on 2017/10/5.
 */
var fileName;
var fileExt;
$('#selectFile').click(function () {
    $('#file').click();
});

$('#file').change(function () {
    var file = $("#file").val();
    fileName = getFileName(file);
    fileExt = file.replace(/.+\./, "");   //正则表达式获取后缀
    $('#fileName').val(fileName);
});

function getFileName(o) {
    var pos = o.lastIndexOf("\\");
    return o.substring(pos + 1);
}

$('#upload').click(function () {
    var formData = new FormData($("#uploadForm")[0]);
    if (fileExt != "jpg" && fileExt != "png") {
        alert("请选择正确的文件");
    } else {
        $.ajax({
            url: 'upload',
            type: 'post',
            data: formData,
            dataType: "json",
            cache: false,
            contentType: false,
            processData: false,
            success: function (data) {
                console.log(data);
                if (data.path != "") {
                    $("#allUrl").attr("src", data.path);
                    alert("上传成功");
                }
            },
            error:function () {
                alert("上传失败")
            }
        });
    }
});



