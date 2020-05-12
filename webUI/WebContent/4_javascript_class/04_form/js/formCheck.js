window.onload = function(){

		var frm = document.getElementById('frm');
		var inputs = document.querySelectorAll("input");
		
		frm.onsubmit = function(e){
			
				e.preventDefault(); //자기 자신의 이벤트 막기
		
			//추가 된 사항을 검사
		if(frm.agree.checked==false){
			alert('이용약관에 동의 해 주세요.');
			return;
		}
			//다시 전송
			frm.submit();
		}


	}