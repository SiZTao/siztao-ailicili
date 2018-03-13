var index = 1;
function rotation(obj) {
	// 图片
	var img = document.getElementById('carousel'+obj);
	img.style.display = 'block';
	for(var i=1;i<=5;i++){
		if (i!=obj) {
			var img1 = document.getElementById('carousel'+i);
			img1.style.display = 'none';
		}
	}
	// 里面的A
	var slip = document.getElementById('slip'+obj);
	slip.style.display = 'block';
	for(var i=1;i<=5;i++){
		if (i!=obj) {
			var slip1 = document.getElementById('slip'+i);
			slip1.style.display = 'none';
		}
	}
	index = obj;
}



var indexnum = 2;
function sliimg(obj) {
	// 图片
	var img2 = document.getElementById('bacimg'+obj);
	img2.style.display = 'block';
	for(var i=1;i<=5;i++){
		if (i!=obj) {
			var img21 = document.getElementById('bacimg'+i);
			img21.style.display = 'none';
		}
	}
	// 里面的A
	var slip = document.getElementById('dlpa-'+obj);
	slip.style.display = 'block';
	for(var i=1;i<=5;i++){
		if (i!=obj) {
			var slip1 = document.getElementById('dlpa-'+i);
			slip1.style.display = 'none';
		}
	}
	// 介绍
	var jiesao = document.getElementById('banner-p'+obj);
	jiesao.style.display = 'block';
	for(var i=1;i<=5;i++){
		if (i!=obj) {
			var jiesao1 = document.getElementById('banner-p'+i);
			jiesao1.style.display = 'none';
		}
	}
	indexnum = obj;
}

function autorun(){
	if (index==6) {
		index=1;
	}
	rotation(index);
	index++;

	if (indexnum==6) {
		indexnum=1;
	}
	sliimg(indexnum);
	indexnum++; 
	setTimeout('autorun()',3000);
}
window.onload(autorun());