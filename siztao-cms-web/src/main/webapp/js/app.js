function rotation(obj) {
	// 图片
	var img = document.getElementById('img'+obj);
	img.style.display = 'block';
	for(var i=1;i<=4;i++){
		if (i!=obj) {
			var img1 = document.getElementById('img'+i);
			img1.style.display = 'none';
		}
	}
}

// tab

$(function(){
	$(".content-log").hide(); //隐藏所有
    $(".info-select li:first").addClass("active").show(); //激活第一个标签
    $(".content-log:first").show(); //显示第一个标签内容

    $(".info-select li").click(function() { 
    	$(".content-log").hide(); 
        var index = $(this).index();
  		$('.content-log').eq(index).show();

        $(".info-select li").removeClass("active");  
        $(this).addClass("active");
    });
}); 

var height = $(".content").outerHeight();
var height1 = $(".content-wrap").outerHeight();

$(function(){
    // 监听滚动事件
  $(window).scroll(function(){
    // 获得div的高度

    var h = $(".element1").offset().top;
    if($(this).scrollTop()>h && $(this).scrollTop() < h+100){
    // 滚动到指定位置
      $('.content').css("height",height+585+"px");
      $('.content-wrap').css("height",height1+585+"px");
    }
  });
})

$(function(){
    // 监听滚动事件
  $(window).scroll(function(){
    // 获得div的高度

    var h = $(".element2").offset().top;
    if($(this).scrollTop()>h && $(this).scrollTop() < h+100){
    // 滚动到指定位置
      $('.content').css("height",height+1300+"px");
      $('.content-wrap').css("height",height1+1300+"px");
    }
  });
})