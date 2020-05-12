window.onload = function() {
	// var buttons = [ document.getElementById('btn_1'),
	// document.getElementById('btn_2'), document.getElementById('btn_3'),
	// document.getElementById('btn_4') ];
	// var counts = [ document.getElementById('count_1').value,
	// document.getElementById('count_2').value,
	// document.getElementById('count_3').value,
	// document.getElementById('count_4').value ];
	// var prices = [
	// parseInt(document.getElementById('price_1').getAttribute('price')),
	// parseInt(document.getElementById('price_2').getAttribute('price')),
	// parseInt(document.getElementById('price_3').getAttribute('price')),
	// parseInt(document.getElementById('price_4').getAttribute('price')) ];

	// for (var i = 1; i <= 4; i++) {
	// document.getElementById('btn_' + i).onclick = function() {
	// for (var j = 1; j <= 4; j++) {
	// var count = parseInt(document.getElementById('count_' + j).value);
	// alert(count);
	//				
	// }
	//
	// }
	//
	// }

	document.getElementById('btn_1').onclick = function() {
		var count = document.getElementById('count_1');
		var su = count.value;
		total.value = gettotal() + (parseInt(su) * 36000);
	}
	document.getElementById('btn_2').onclick = function() {
		var count = document.getElementById('count_2');
		var su = count.value;
		total.value = gettotal() + (parseInt(su) * 5500);
	}
	document.getElementById('btn_3').onclick = function() {
		var count = document.getElementById('count_3');
		var su = count.value;
		total.value = gettotal() + (parseInt(su) * 20000);
	}
	document.getElementById('btn_4').onclick = function() {
		var count = document.getElementById('count_4');
		var su = count.value;
		total.value = gettotal() + (parseInt(su) * 39000);
	}
	function gettotal() {
		var total = parseInt(document.getElementById('total').value);
		return total;
	}
}
