$(function(){
	//1번
	//Date 객체 사용:(현재)년,월,일 가져오기
	var today = new Date();
	$('.year').text(today.getFullYear());
	$('.month').text(today.getMonth());
	$('.date').text(today.getDate());
	
	//2.
	//input.text의 focus 이벤트, focus제거(=blur)이벤트
	$('#keyword').focus(function(){
		$(this).css("background-position","0 -500px");
				});
	$('#keyword').blur(function(){
		$(this).css("background-position","0 0");
	});
	//3.
	var last_tab=$('.tab_btn1');//이전에 보여진 탭의 imgs src
	$('#tabmenu dt').click(function(){
		//(1)모든 dd를 숨긴다.
		$('#tabmenu dd').hide();
		//(2)선택한 dd를 보여준다.
		$(this).next().show();
		//(1) 이전 탭 out.img로 바꾸고 현재 탭을 over로
			//(3)-1 last_tab을 img out로 변경
			var src=last_tab.find('img').attr('src').replace(/over/gi,"out");//last_tab의 이미지 src의 over을  out로 바꾼거를 변수 src에저장.
			last_tab.find('img').attr('src',src);
			last_tab.show();
			//(3)-2 현재 누른 탭을 img를 over로 변경
		src =$(this).find('img').attr('src').replace(/out/gi,"over");
		$(this).find('img').attr('src',src);
		$(this).show();
			//(3)-3 현재 누른 탭을 last_tab에 저장
		last_tab=$(this);
	});
	//4.bxSlider
	var slider =$('#best_bg ul').bxSlider({
		minSlides : 5,
		maxSlides : 5,
		slideMargin : 10,
		slideWidth : 150,
		auto : true,
		speed : 200,
		pager : false,
		controls : false
		
	});
	// 이전버튼
	   $('.prev_btn').click(function(){
	      slider.goToPrevSlide();
	   });
	   
	   // 다음버튼
	   $('.next_btn').click(function(){
		   slider.goToNextSlide();
	
	   });
	//5.로그인 
	  $('.login_wrap img').click(function(){
		  $('#login_f').css({'top':'0px'});
		  $('.login_close_btn img').click(function(){
			  $('#login_f').css({'top':'-500px'});
		  });
	  }); 
	  
	//6.   

});