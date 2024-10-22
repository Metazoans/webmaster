/**
 * ajax1.js
 * Asynchronous Javascript And Xml == AJAX(비동기방식 자바스크립트 and XML)
 * 
 */

/*
// 동기 방식(1~3까지 순차적으로 하나가 끝나면 다음 것이 실행)
console.log("1");
console.log("2");
console.log("3");

// 비동기 방식(순차적이지 않음) 1000 == 1초 후 함수 실행
setTimeout(function() {
	console.log("0");
}, 1000);
*/

// 비동기 방식 처리(ajax)
let xhtp = new XMLHttpRequest();
xhtp.open('get', 'memberJson.do');
xhtp.send(); // 서버의 resource를 가져옴

let data = [];
xhtp.onload = function() {
	let obj = JSON.parse(xhtp.responseText);
	console.log(obj);
	data = obj;
	console.log('1', data);

	for(let i=0; i<data.length; i++) {
		console.log(data[i]);
	}
}

console.log('2', data);



