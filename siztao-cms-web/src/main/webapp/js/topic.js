var video = $('.video-tv1')[0];
var video = $('.video-tv1');

$('.video-tv1').click(function(){
  if (video[0].paused){
    video[0].play();
    $("#xiaoTV").hide();
    $('#btnPlay').hide();
    $("#btnPlay2").show();
  }else{
    video[0].pause();
    $("#xiaoTV").show();
    $("#btnPlay2").hide();
    $("#btnPlay").show();
  }
});

//进度条

// 进度条走动
video.on('timeupdate', function() {
    var currentPos = video[0].currentTime; //获取当前时间
    var maxduration = video[0].duration; //得到视频的总时间
    var percentage = 100 * currentPos / maxduration; //走的%
    $('.timeBar').css('width', percentage+'%');
});

var timeDrag = false; //拖动状态
$('.progressBar').mousedown(function(e) {
    timeDrag = true;
    updatebar(e.pageX);
});
$(document).mouseup(function(e) {
   if(timeDrag) {
      timeDrag = false;
      updatebar(e.pageX);
   }
});
$(document).mousemove(function(e) {
   if(timeDrag) {
      updatebar(e.pageX);
   }
});
 
//更新进度条控件
var updatebar = function(x) {
   var progress = $('.progressBar');
   var maxduration = video[0].duration; //视频时间
   var position = x - progress.offset().left; //点击改变位置
   var percentage = 100 * position / progress.width();
 
   //检查是否在范围内
   if(percentage > 100) {
      percentage = 100;
   }
   if(percentage < 0) {
      percentage = 0;
   }
 
   //更新进度条和视频时间
   $('.timeBar').css('width', percentage+'%');
   video[0].currentTime = maxduration * percentage / 100;
   video[1].currentTime = maxduration * percentage / 100;
};


// 视频总时间和播放时间
// 总时间
video.on('loadedmetadata', function() {
  var duration = $('.duration');
  var total = parseInt(video[0].duration/1);
  var second = total%60;
  var minute = parseInt((total/60)/1);
  if (minute<10) {
    minute = '0'+minute
  }
  duration.text(minute+':'+second);
});

// 播放时间
video.on('timeupdate', function() {
  var current = $('.current');
  var go = parseInt(video[0].currentTime/1);
  var minute = Math.floor (go / 60);
  var second = (go % 60);
  if (minute<10) {
    minute = '0'+minute;
  }
  if (second<10) {
    current.text(minute+':'+'0'+second);
  }else{
    current.text(minute+':'+second);
  }
});


// 音量控制

//静音和开启
$('.muted').click(function() {
  video[0].muted=true;
  $('.muted').hide(); //隐藏
  $('.muted2').css("display", "block");
  $('.volume-span').text(0);
  video[0].volume = 0;
  return false;
});

$('.muted2').click(function() {
  video[0].muted=false;
  $('.muted').css("display", "block");
  $('.muted2').hide();
  $('.volume-span').text(100);
  video[0].volume = 1.0;
  return false;
});

$('.muted3').click(function() {
  video[0].muted=false;
  $('.muted').hide(); //隐藏
  $('.muted3').hide(); //隐藏
  $('.muted2').css("display", "block");
  $('.volume-span').text(0);
  video[0].volume = 0;
  return false;
});

// 音量条
video.on('timeupdate', function() {
   var volume = video[0].volume; //获取当前音量
   var percentage = 100 * volume; //走的%
   $('.volume').css('height', percentage+'%');
});

var volumeDrag = false; //拖动状态
$('.volumeBar').mousedown(function(e) {
   volumeDrag = true;
   updatevolume(e.pageY);
});
$(document).mouseup(function(e) {
   if(volumeDrag) {
      volumeDrag = false;
      updatevolume(e.pageY);
   }
});
$(document).mousemove(function(e) {
   if(volumeDrag) {
      updatevolume(e.pageY);
   }
});
 
//更新进度条控件
var updatevolume = function(Y) {
  var progress = $('.volumeBar')
  var position = (progress.offset().top+64.5) - Y;
  var percentage = 100 * position / progress.height();
  //检查是否在范围内
   if(percentage > 100) {
      percentage = 100;
   }
   if(percentage < 0) {
      percentage = 0;
   }
  $('.volume').css('height', percentage+'%');
  video[0].volume = percentage / 100;

  if(position > 64.5) {
      position = 64.5;
   }
   if(position < 0) {
      position = 0;
   }
   $('.volume-span').text(parseInt((position/0.645)/1));

   if (video[0].volume == 0) {
      $('.muted').hide(); //隐藏
      $('.muted3').hide(); //隐藏
      $('.muted2').css("display", "block");
   }else if (video[0].volume < 0.5) {
      $('.muted').hide(); //隐藏
      $('.muted2').hide(); //隐藏
      $('.muted3').css("display", "block");
   }else{
      $('.muted3').hide(); //隐藏
      $('.muted2').hide(); //隐藏
      $('.muted').css("display", "block");
   }
};
// 评论回复
$(".submit-comment").click(function(){
  var height = $(".t-main-inner").outerHeight();
  var height1 = $(".common").outerHeight();
  $(".t-main-inner").css("height",height+108+"px");
  $(".common").css("height",height1+109+"px");
  var text=$(".bdc-input").val();
  var li = '<li>'+
             '<img src="imgs/top/avatar.jpg">'+
             '<span class="comm_list-span">ExistSb</span>'+
             '<i class="comm_list-i3"></i>'+
             '<p class="comm_list-p">'+text+'</p>'+
             '<div class="elinfo">'+
              '<span>#5</span>'+
              '<span>2016-06-06 07:17</span>'+
              '<span class="elinfo1">赞(0)</span>'+
              '<span class="elinfo1">回复</span>'+
              '<span class="elinfo1 elinfo2">举报</span>'+
             '</div>'
            +'</li>';

  $(".comm_list").append(li);
})
$('.bdc-input').mousemove(function(){
  $('.b-icon-triangle-gray-left').css("background","url(imgs/icons.png) -841px -1046px no-repeat");
});

$('.bdc-input').mouseout(function(){
  $('.b-icon-triangle-gray-left').css("background","url(imgs/icons.png) -841px -982px no-repeat");
});