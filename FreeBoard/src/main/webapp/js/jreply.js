/**
 * jreply.js
 * jquery 방식
 */

console.log('start');

// jquery방식의 Ajax호출
replyListFnc();
function replyListFnc() {
	$('.content li:not(:eq(0))').remove();
	$.ajax('replyList.do?bno=' + bno + '&page=1')
	.done(function(result) {
		console.log(result); // result == 배열 == [{}...{}]
		result.forEach((item) => {
			$('<li />').append(
				$('<span />').addClass('col-sm-2').text(item.replyNo), // 글번호
				$('<span />').addClass('col-sm-5').text(item.reply), // 댓글 내용
				$('<span />').addClass('col-sm-2').text(item.replyer), // 작성자
				$('<span />').addClass('col-sm-2').append($('<button>삭제</button>')) // 삭제버튼
			)
				.appendTo($('div.content ul'));
		});

	})
	.fail(function(err) {
		console.log(err);
	})
}

//삭제 이벤트
$('div.content ul').on('click', 'button', function(e) {
	console.log($(e.target).parent().parent().find('span:eq(0)').text());
	let rno = $(e.target).parent().parent().find('span:eq(0)').text();
	$.ajax({
		url: 'removeReply.do',
		data: { rno: rno },
		method: 'GET',
		dataType: 'json' // 문자열 => 자바스크립트 객체
	}) //삭제
		.done(function(result) {
			if (result.retCode == 'OK') {
				replyListFnc();
			}
		})
		.fail(function(err) {
			console.log(err);
		})
})

//등록
$('#addReply').on('click', function(e) {
	console.log('input start');
	let rdata = $('#reply').val();
	console.log(rdata);
	$.ajax({
		url: 'addReply.do',
		data: { bno: bno, reply: rdata, replyer: logId },
		method: 'GET',
		dataType: 'json'
	})
		.done(function(result) {
			if (result.retCode == 'OK') {
				console.log('OK');
				replyListFnc();
			}
		})
		.fail(function(err) {
			console.log(err);
		})
})




