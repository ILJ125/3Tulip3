
$(function(){
	
	$('.accordion').each(function(){
		var allDt = $(this).find('dt'); //3개
		var allDd = $(this).find('dd');
		
		allDd.hide();
		
		//마우스 올라갔을 때 색깔 노랑이로
		
		//커서
		allDt.css('cursor','pointer');
		//클릭 이벤트
		allDt.click(function(){
			$(this).next().toggle();
		});
	});
	
	
});