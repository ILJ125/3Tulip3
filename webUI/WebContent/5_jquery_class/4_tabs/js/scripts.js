$(function(){
	
	var topDiv=$('.tabSet');
	var anchors=topDiv.find('.tabs a');
	var panelDivs=topDiv.find('div.panel');
	
	anchors.show();
	panelDivs.hide();
	
	var lastAnchor=anchors.filter('.on'); // find()와 filter() 차이
	var lastPanel= $(lastAnchor.attr('href'));
	lastPanel.show();
	
	anchors.click(function(){
		//눌러진 요소에 클래스명 on 지정
		
		//1.현재 이벤트가 발생한 a 태그와 그 href(패널)을 얻어와서변수에 지정
		var currentAnchor = $(this);
		var currentPanel = $(currentAnchor.attr('href')); // id를 찾아줘서 id를 쓴거와 같은 효과를 내기 위해서
		//2.기존 a 태그(lastAnchors)에서 on 클래스 젝거
		lastAnchor.removeClass('on');
		//3.현재 이벤트가 발생한 a 태그에 on 클래스를 추가
		currentAnchor.addClass('on');
		//4.기존 패널 (lastPanel)을 감추기
		lastPanel.hide();
		//5.현재 패널을 href(패널) 변수 잡은걸 보이기
		currentPanel.show();
		//6. 현재 a태그와 현재 패널을 lastAnchor, lastPanel 에 지정하기
		lastAnchor=currentAnchor;
		lastPanel=currentPanel;
		
	})
});