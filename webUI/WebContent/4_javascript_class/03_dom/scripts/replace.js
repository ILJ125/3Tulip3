// window.onload = function(){	
document.addEventListener('DOMContentLoaded', function() {

	var list = document.getElementById('list');
	var pic = document.getElementById('pic');
	var del = document.getElementById('del');

	// 리스트에서 선택(클릭했을 때)
	list.onclick = function(evt)
	{	var isbn=evt.target.getAttribute('data-isbn');

//	<img srt='xxx.gif' width='100' heigth '80';
	var img = document.createElement('img');
	img.src ='images/'+isbn +'.jpg';
	
	img.height =150;
	img.width=100;
	
	//맨처음은 자식이 없어서 붙이기 하구 두번째 부터바꿔치기 ㄱㄱ
	if(pic.getElementsByTagName('img').length > 0){
		pic.replaceChild(img,pic.lastChild);

	}else{
	pic.appendChild(img);
	del.disabled=false;
	}

	}
	del.onclick=function(){
		pic.empty;
	}

//	 삭제 버튼 누르면 pic 아래 자식(img 태그)를 지운다

//	 };
});