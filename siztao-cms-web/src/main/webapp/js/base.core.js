
// 游戏中心2个人物图片的切换
function gameimg(obj){
	var gameimg = document.getElementById('gameimg'+obj);
	gameimg.style.display = 'block';
	for(var i=1;i<=2;i++){
		if (i!=obj) {
			var gameimg1 = document.getElementById('gameimg'+i);
			gameimg1.style.display = 'none';
		}
	}
}
function gameimgend(obj){
	var gameimg = document.getElementById('gameimg'+obj);
	gameimg.style.display = 'none';
}

function rotationimg(){
	var rotationimg = document.getElementById('rotation').getElementsByTagName('li');
	
}

//轮换图
var index = 1;
function rotation(obj) {
	// 图片
	var img = document.getElementById('topic-img'+obj);
	img.style.display = 'block';
	for(var i=1;i<=6;i++){
		if (i!=obj) {
			var img1 = document.getElementById('topic-img'+i);
			img1.style.display = 'none';
		}
	}
	// 文字
	var span = document.getElementById('category-span'+obj);
	span.style.display = 'block';
	for(var i=1;i<=6;i++){
		if (i!=obj) {
			var span1 = document.getElementById('category-span'+i);
			span1.style.display = 'none';
		}
	}
	// 图标
	$('#topic_slider'+obj).addClass('on1')
	for(var i=1;i<=6;i++){
		if (i!=obj) {
			$('#topic_slider'+i).removeClass('on1')
		}
	}
	index = obj;
}

function autorun(){
	if (index==7) {
		index=1;
	}
	rotation(index);
	index++; 
	setTimeout('autorun()',3000);
}
// window.onload = autorun;

var index2 = 1;
function bgmimg(obj) {
  // 图片
  var img = document.getElementById('bgm-rmw-img'+obj);
  img.style.display = 'block';
  for(var i=1;i<=3;i++){
    if (i!=obj) {
      var img1 = document.getElementById('bgm-rmw-img'+i);
      img1.style.display = 'none';
    }
  }

  // 文字
  var text = document.getElementById('bgm-rsm-li'+obj);
  text.style.display = 'block';
  for(var i=1;i<=3;i++){
    if (i!=obj) {
      var text1 = document.getElementById('bgm-rsm-li'+i);
      text1.style.display = 'none';
    }
  }

  obj = idnex2;
}
function bgmautorun(){
  if (index2 == 4) {
    index2 = 1;
  }
  bgmimg(index2);
  index2++;
  setTimeout('bgmautorun()',3000);
}

function zidong(){
  autorun();
  bgmautorun();
}
window.onload = zidong;


// 新番部分tab

$(function(){
	//Default Action  
    $(".bgm-body-ul1").hide(); //隐藏所有
    // var i2 = '<i class="b-icon-arrow-l-d"></i>';
    $("ul.bgm-tabs li:first").addClass("w-on").show(); //激活第一个标签
    $("ul.bgm-tabs li p:first").addClass("tabw-sp").show();
    $(".bgm-body-ul1:first").show(); //显示第一个标签内容

     //在单击事件
    $("ul.bgm-tabs li").click(function() { 
    	$(".bgm-body-ul1").hide(); 
        var index = $(this).index();
  		$('.bgm-body-ul1').eq(index).show();

        $("ul.bgm-tabs li").removeClass("w-on");  
        $(this).addClass("w-on");

        $("ul.bgm-tabs li p").removeClass("tabw-sp");
    	$("ul.bgm-tabs li p").eq(index).addClass("tabw-sp");
    });
});  


// 导航栏部分
// 特别蛋疼的写法 不会写只能这样
$(function(){
    // 监听滚动事件
  $(window).scroll(function(){
    // 获得div的高度

    var h = $(".num").offset().top;
    if($(this).scrollTop()>h && $(this).scrollTop() < h+100){
    // 滚动到指定位置
      $(".index-nav").css("top","20px");
    }
  });
})

$(function(){
    // 监听滚动事件
  $(window).scroll(function(){
    // 获得div的高度

    var h = $(".top-sbt").offset().top;
    if($(this).scrollTop()>h && $(this).scrollTop() < h+100){
    // 滚动到指定位置
      $(".index-nav").css("top","238px");
    }
  });
})



$(function(){
    // 监听滚动事件
  $(window).scroll(function(){
    // 获得div的高度

    var h = $(".container-row").offset().top;
    if($(this).scrollTop()>h && $(this).scrollTop() < h+100){
    // 滚动到指定位置
      $(".sortable1").css("background-color","#00a1d6");
      $(".sortable1").css("color","#FFF");
    }
  });
})
$(function(){
    // 监听滚动事件
  $(window).scroll(function(){
    // 获得div的高度

    var h = $(".daohang1").offset().top;
    if($(this).scrollTop()>h && $(this).scrollTop() < h+100){
    // 滚动到指定位置
      $(".sortable2").css("background-color","#00a1d6");
      $(".sortable2").css("color","#FFF");
      $(".sortable1").css("background-color","#f6f9fa");
      $(".sortable1").css("color","#000");
    }
  });
})

$(function(){
    // 监听滚动事件
  $(window).scroll(function(){
    // 获得div的高度

    var h = $(".vvvvv3").offset().top;
    if($(this).scrollTop()>h && $(this).scrollTop() < h+100){
    // 滚动到指定位置
      $(".sortable3").css("background-color","#00a1d6");
      $(".sortable3").css("color","#FFF");
      $(".sortable2").css("background-color","#f6f9fa");
      $(".sortable2").css("color","#000");
    }
  });
})

$(function(){
    // 监听滚动事件
  $(window).scroll(function(){
    // 获得div的高度

    var h = $(".bangumi-pmt-lis").offset().top;
    if($(this).scrollTop()>h && $(this).scrollTop() < h+100){
    // 滚动到指定位置
      $(".sortable3").css("background-color","#f6f9fa");
      $(".sortable3").css("color","#000");
    }
  });
})

$(function(){
    // 监听滚动事件
  $(window).scroll(function(){
    // 获得div的高度

    var h = $(".vvvvv2").offset().top;
    if($(this).scrollTop()>h && $(this).scrollTop() < h+100){
    // 滚动到指定位置
      // $(".sortable3").css("background-color","#00a1d6");
      // $(".sortable3").css("color","#FFF");
      $(".sortable3").css("background-color","#f6f9fa");
      $(".sortable3").css("color","#000");
    }
  });
})

$(function(){
    // 监听滚动事件
  $(window).scroll(function(){
    // 获得div的高度

    var h = $(".daohang2").offset().top;
    if($(this).scrollTop()>h && $(this).scrollTop() < h+100){
    // 滚动到指定位置
      // $(".sortable3").css("background-color","#00a1d6");
      // $(".sortable3").css("color","#FFF");
      $(".sortable2").css("background-color","#f6f9fa");
      $(".sortable2").css("color","#000");
    }
  });
})

$(function(){
    // 监听滚动事件
  $(window).scroll(function(){
    // 获得div的高度

    var h = $(".b-l").offset().top;
    if($(this).scrollTop()>h && $(this).scrollTop() < h+100){
    // 滚动到指定位置
      // $(".sortable3").css("background-color","#00a1d6");
      // $(".sortable3").css("color","#FFF");
      $(".sortable1").css("background-color","#f6f9fa");
      $(".sortable1").css("color","#000");
    }
  });
})

$('.sortable2').click(function() {
    $(".sortable2").css("background-color","#00a1d6");
    $(".sortable2").css("color","#FFF");
    $(".index-nav").css("top","20px");
    $(".sortable3").css("background-color","#f6f9fa");
});
$('.sortable3').click(function() {
    $(".sortable3").css("background-color","#00a1d6");
    $(".sortable3").css("color","#FFF");
    $(".index-nav").css("top","20px");
    $(".sortable2").css("background-color","#f6f9fa");
});

$('.btn_gotop').click(function() {
    $(".index-nav").css("top","238px");
});

// 下载手机客户端
$('.n-i-mlink').mousemove(function(){
  $('.n-i-mlink img').show();
});

$('.n-i-mlink').mouseout(function(){
  $('.n-i-mlink img').hide();
});