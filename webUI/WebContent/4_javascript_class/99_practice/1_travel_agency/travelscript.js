window.onload = function() {
	var form=document.getElementById('frm');
	// 인원수 입력하기
	var traveler = document.getElementsByClassName('traveler')
	
	//여행자 인원수 에서 엔터 눌렀을때 합 계싼 이벤트
	for (var i = 0; i < traveler.length; i++) {
		traveler[i].onkeydown = function() {
			if (window.event.keyCode == 13) {
				if (isNumber(traveler)) {
					// 총합계 값
					document.getElementById('total').value = caltotal() + "원"
				} else {
					return;
				}
			}

		}
	}
	document.getElementById('submit').onclick=function(){
	//여군유무 ---------------------------------------------------------------------------
	var passport=document.getElementById('selectpassport');
	alert(passport.value);
	if(passport.value=='3'){
		alert("여권유무를 선택해 주세요");
		preventDefault;
	}
	passport.onchange=function(){
	if(passport.value=='0'){
		document.getElementById('passportnum').require=true;
	}
	}
	//제출하기 눌렀을 때에 이벤트
	
		
		form.submit;
	}

	// 텍스트에 숫자만 있는지 아닌지
	function isNumber(inputCost) {
		var check = /^[0-9]+$/;
		for (var i = 0; i < inputCost.length; i++) {
			if (check.test(inputCost[i].value) | inputCost[i].value == "") {
			} else {
				alert("숫자만 입력해 주세요.")
				return false;
			}
		}
		return true;
	}
	function ishangul(inputHangul){
		var check = /^[가-힣]+$/;
		for (var i = 0; i < inputHangul.length; i++) {
			if (check.test(inputHangul[i].value)) {
			} else {
				alert("한글만 입력해 주세요.")
				return false;
			}
		}
		return true;
	}
	// 성인, 아동, 유아 전부 더하기
	function caltotal() {
		var sum = 0;
		sum += document.getElementById('adult').value * 39000;
		sum += document.getElementById('young').value * 29000;
		sum += document.getElementById('baby').value * 19000;

		return sum;
	}

}
