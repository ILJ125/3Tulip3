/**
 * 
 */
$(document).ready(function(){
	
	$('#navigation li').hover(function(){
		$(this).animate({ paddingLeft:'+=15px'},200);
	},function(){
		$(this).animate({ paddingLeft:'-=15px'},200);
	});
	
	//자바 스크립트의 window 객체를 찾아서 스크롤 이벤트 
	$(window).scroll(function(){
		$('#navigation').css({'top':$(document).scrollTop() });
		//문서에서 탑값을 가져다가 다시 탑값에 지정 해주겠다.
		//스크롤을 내리고 올려도 navigation부분을 고정!
	});
	
});