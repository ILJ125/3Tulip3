window.onload = function() {
	var imsi = document.querySelectorAll('td')
	// var imsi=document.getElementsByClassname('item');
	for (var i = 0; imsi.length; i++) {
		imsi[i].onclick = function() {
			// alert("OK");
			var price = this.getAttribute('price');
			alert(price);
		}

	}

}
