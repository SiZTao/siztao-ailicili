function bmlbg(obj) {
	var bg = document.getElementById('bml-sp-bg');
	for(var i=1;i<=2;i++){
		if (i==obj) {
			bg.style.background = 'url(imgs/bml/bg'+i+'.jpg)';
			bg.style.backgroundPosition = 'center';
		}
	}
}