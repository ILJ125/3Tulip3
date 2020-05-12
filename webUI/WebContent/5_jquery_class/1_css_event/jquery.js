//dom이 완성 될 때 까지 기다릴 겁니다. 
$(function(){
//	$('#celebs tbody tr:odd').css({'background':'lightpink','color':'blue'});
	$('#celebs tbody tr:odd').addClass('table_striping');
	
	//tr에 마우스가 올라가면 강조하기
	$('#celebs tbody tr').hover(function(){
		$(this).addClass('td_mouseover');
	},function(){
		$(this).removeClass('td_mouseover');
	});
	
	$('#hideButton').click(function(){
		$('#intro img').fadeOut();
	});
	
	$('#showButton').click(function(){
		$('#intro img').fadeIn();
	});
	
	$('#toggleButton').click(function(){
		$('#intro img').toggle();
	});
});