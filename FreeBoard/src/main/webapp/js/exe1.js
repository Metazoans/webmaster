/**
 * exe1.js
 * 
 */

console.log('exe1.js start');

let delBtn = document.querySelector('#delBtn');
delBtn.addEventListener('click', delStr);

function delStr() {
	console.log('click event');
	let str = document.querySelectorAll('.container span');
	let inputStr = userValue.value;
	
	str.forEach(function(span) {
		if(span.innerHTML == inputStr) {
			span.remove();
			userValue.value = '';
		}
	})
	userValue.focus();
	
//	for(let i = 0; i < str.length; i++) {
//		if(str[i].innerHTML == inputStr){
//			str[i].remove();
//			userValue.value = '';
//		}
//		userValue.focus();
//	}
	
	
}





