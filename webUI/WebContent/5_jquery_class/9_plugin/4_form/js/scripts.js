$(function(){
	
	$('#signup form').validate({
		rules: {
			name: {required : true},
			email: {required : true,
					email:true},
			website:{url:true},
			password:{required : true ,minlength:6},
			passconf:{equalTo : '#password'}
		},
		success: function(label){
			label.addClass('valid');
			label.text('성공');
		}
	});
	$('.check-all').click(function(){
		$('.agree').prop('checked',this.checked);
		//checked 가 자바 스크립트 속성이어서 this 자바스크립트용어로 가져와야 한다.
	});
		
	$('.agree').click(function(){
			if($(this).prop('checked') == false){
				$('.check-all').prop('checked',false);
		}
	});
	
});