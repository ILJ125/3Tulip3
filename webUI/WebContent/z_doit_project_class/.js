//dom이 완성 될 때 까지 기다릴 겁니다. 
$(function(){
// 수량이 바꼈을 때 table append 시킬 것이다.
	var record=[]; //테이블 목록에 추가된 메뉴를 갖고 있는 배열
	var bool=true; //주문목록에 있는 메뉴이면 false 로 새로 추가 안하고, 주문목록에 없는 메뉴이면 true로 새로 추가
	$('select').change(function(){
		var str =this.id.substr(4,1);
		//append 하는 function
		function add() {$('#listTable').append('<tr id="'+str+'" class="ordernum"><td width="150">'+$('#label'+str).attr('value')
				+'</td><td id="su'+str+'" width="100">'+$('#menu'+str+'Count').val()
				+'</td><td width="50"><input class="delete" type="button" value="삭제"></td></tr>');}
		for(var i=0;i<record.length;i++){
			alert(record[i]);
			//주문목록의 존재하는 메뉴를 추가 했을 때
			if(record[i]==str){
				var past_su=parseInt($('#su'+str).text());
				$('#su'+str).text(past_su+parseInt(this.value));
				bool=false;
				break;
			}
			//주문목록에 존재하지 않는 메뉴를 추가 했을 때
			else if(record[i]!=str){
				//수량 0이 아닌것 을 골랐을 때
				bool=true;
			}
		}
		//주문 목록에 추가
		if(bool){
			if(this.value !='0')
			{
				add();
				record[record.length]=str;
				alert("길이"+record.length);
			}
		}
		// 총합 구하기(테이블에 추가되는 안되든 음료를 추가했으니 값이 추가된다.)
		var original=parseInt($('#total').val());
		$('#total').val(original +($('#price'+str).attr('value')*this.value));
		$('#menu'+str+'Count').val('0');
	});
	//삭제
	$('#listTable').on('click','input',function(){
		var target=$(this).parent().parent();//tr
		//record 에서도 삭제 해야한다.
		for(var i=0;i<record.length;i++){
			if(record[i]==target.attr('id')){
				record.splice(i,1);
				alert(i+"번 요소 삭제 되었습니다.");
			}
		}
		//total에서 제거
		var original=parseInt($('#total').val());
		alert($('#price'+target.attr('id')).attr('value'));
		alert($(this).parent().prev().text());
		$('#total').val(original -(parseInt($('#price'+target.attr('id')).attr('value'))*parseInt($(this).parent().prev().text())));
		//삭제
		target.remove();
	});
});
