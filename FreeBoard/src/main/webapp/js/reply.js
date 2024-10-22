/**
 * reply.js
 * replyService 생성했던 메소드 호출
 */

svc.rlist(160 //bno
	, function(result) {
		console.log(result);
		replyList(result);
	} // successFnc
	, function(err) {
		console.log('요기', err);
	} // errorFnc
)

function replyList(obj = []){
	let fields = ['replyNo', 'reply', 'replyer'];
	for(let i = 0; i < obj.length; i++) {
		let tr = document.createElement('tr');
		for(let j = 0; j<fields.length; j++) {
			let td = document.createElement('td');
			td.innerHTML = obj[i][fields[j]];
			tr.appendChild(td);
		}
		let td = document.createElement('button');
		td.innerHTML = "작성";
		
		document.querySelector('#replyList tbody').appendChild(tr);
	}
}


