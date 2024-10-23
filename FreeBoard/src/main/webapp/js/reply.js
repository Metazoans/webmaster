/**
 * reply.js
 * replyService 생성했던 메소드 호출
 * 
 * 
 * 
[백업 board.jsp]
<table id="replyList" class="table">
	<thead>
		<tr>
			<th>댓글번호</th>
			<th>내용</th>
			<th>작성자</th>
		</tr>
	</thead>
	<tbody>
	
	</tbody>
</table>

 */

let page = 1; // 댓글페이지 변수
let replyCnt = 0;

// 댓글 등록 버튼
document.querySelector('#addReply').addEventListener('click', addReplyHandlerFnc);

function addReplyHandlerFnc() {
	let reply = document.querySelector('#reply').value;
	
	if(!reply || !logId) {
		alert('필수값 없음');
		return;
	}
	
	svc.addReply({bno, reply, replyer: logId},
		result => {
			if(result.retCode == 'OK') {
//				let template = makeLi(result.retVal);
//				document.querySelector(".reply ul li").after(template); //li 바로 다음 위치에 추가
				page = 1;
				showList();
				svc.getReplyCount(bno, createPageList, err => console.log(err));
				
			} else if(result.retCode == 'FAIL') {
				alert('에러 발생');
			} else {
				alert('알수 없는 코드');
			}
		},
		err=> console.log(err)
	)
	
	document.getElementById('reply').value = '';
	document.getElementById('reply').focus();
}

// .pagination a 클릭이벤트
function linkMove() {
	document.querySelectorAll('nav ul.pagination a').forEach(function(aTag) {
		aTag.addEventListener('click', function(e) {
			e.preventDefault(); // 이동 차단
			
			page = aTag.dataset.page; // <a data-page="rno">rno</a>
			showList(); //목록 출력
			svc.getReplyCount(bno, createPageList, err => console.log(err));
		})
	})
}

// 댓글 페이지
svc.getReplyCount(bno, createPageList, err => console.log(err));
//createPageList();
function createPageList(result) {
	let totalCnt = result.totalCount;
	let startPage, endPage, realEnd;
	let prev, next;
	
	endPage = Math.ceil(page / 5) * 5;
	startPage = endPage - 4;
	realEnd = Math.ceil(totalCnt / 5);
	endPage = endPage > realEnd ? realEnd : endPage;
	
	prev = startPage > 1;
	next = endPage < realEnd;
	
	// 페이지 리스트 출력
	let list = '';
	
	list += '<li class="page-item">';
	if(prev) list += '<a class="page-link" href="#" aria-label="Previous" data-page="' + (startPage - 1) + '">';
	else list += '<a class="page-link disabled" aria-label="Previous">';
	list += '<span aria-hidden="true">&laquo;</span></a></li>';
	
	for(let p = startPage; p <= endPage; p++) {
		list += '<li class="page-item"><a class="page-link" href="#" data-page="' + p + '">' + p + '</a></li>';
	}
	
	list += '<li class="page-item">';
	if(next) list += '<a class="page-link" href="#" aria-label="Next" data-page="' + (endPage + 1) + '">';
	else list += '<a class="page-link disabled" aria-label="Next">';
	list += '<span aria-hidden="true">&raquo;</span></a></li>';
	
	document.querySelector('nav ul.pagination').innerHTML = list;
	
	linkMove();
}

// 댓글 목록
showList();
function showList() { // 목록 출력 함수로 변경
	// 출력 목록 지우기
	document.querySelectorAll('div.reply div.content li').forEach((li, idx) => {
		if(idx > 0) {
			li.remove();
		}
	})
	
	// 댓글 목록 출력
	svc.rlist({bno, page},
		function(result) {// successFnc
			for(let i=0; i<result.length; i++) {
				let template = makeLi(result[i]);
				document.querySelector(".reply ul").appendChild(template);
			}
			
		},
		function(err) { // errorFnc
			console.log('요기', err);
		}
	)
}

// 댓글 li 작성
function makeLi(rvo = {replyNo, reply, replyer}) {
	let template = document.querySelector(".reply ul li").cloneNode(true);
			
	template.querySelector('span').innerText = rvo['replyNo'];
	template.querySelector('span:nth-of-type(2)').innerText = rvo['reply'];
	template.querySelector('span:nth-of-type(3)').innerText = rvo['replyer'];
	template.querySelector('span:nth-of-type(4)').innerHTML = '<button onclick="deleteRow(event)">삭제</button>';
	
	return template;
}

// 댓글 삭제 함수
function deleteRow(e) {
	let rno = e.target.parentElement.parentElement.firstElementChild.innerText;
	
	// 삭제 기능 호출
	svc.removeReply(rno, // 삭제할 댓글 번호
		result => { // 정상처리 실행함수
			if(result.retCode == 'OK') {
				alert('정상 처리');
				e.target.parentElement.parentElement.remove();
				
				showList();

				svc.getReplyCount(bno, result => {
					createPageList;
					console.log(page);
					console.log(result.totalCount);
					if((result.totalCount / 5) < page){
						page--;
						showList();
						svc.getReplyCount(bno, createPageList, err => console.log(err));
					}
				}, err => console.log(err));
				
			} else if(result.retCode == 'FAIL') {
				alert('처리중 예외');
			} else {
				alert('알수 없는 코드');
			}
		},
		err => console.log(err) // 예외발생 실행함수
	)
}



