<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset='utf-8' />
<script src='dist/index.global.js'></script>
<script>
	

  document.addEventListener('DOMContentLoaded', async function() { //DOMContentLoaded -> 로딩후 스크립트 실행
    var calendarEl = document.getElementById('calendar');

  	// Ajax 호출
  	// new Promise(function(){}, function(){}) // 성공함수, 실패함수
  	// 프라미스 객체가 반환될 때 await 수행 코드 -> 그 다음 코드 실행 => async 함수 안에서만 작동
    var eventData = [];

	let resolve = await fetch('calData.do');	//	fetch('calData.do')
	let result  = await resolve.json();			//		.then(resolve => resolve.json())
	eventData = result;							//		.then(result => {
												//			eventData = result;
												//			makeCal();
												//			})
												//		.catch(err => console.log(err));
	
	console.log(eventData);
	
// 	function makeCal() { //기본 fetch 방식인 경우 실행 순서 맞추기 위해 작성한 내용
  	var calendar = new FullCalendar.Calendar(calendarEl, {
  	      headerToolbar: {
  	        left: 'prev,next today',
  	        center: 'title',
  	        right: 'dayGridMonth,timeGridWeek,timeGridDay'
  	      },
  	      initialDate: '2024-10-12',
  	      navLinks: true, // can click day/week names to navigate views
  	      selectable: true,
  	      selectMirror: true,
  	      
  	      select: function(arg) {
  	        var title = prompt('Event Title:');
  	        var start = arg.startStr;
  	        var end = arg.endStr;
  	        if (title) {
  	        	console.log(arg);
  	        	fetch('addEvent.do?title=' + title + '&start=' + start + '&end=' + end)
  	        		.then(resolve => resolve.json())
  	        		.then(result => {
  	        			console.log(result.retCode);
	  	  				if(result.retCode == 'OK') {
	  	  					// title, start, end 값
		  	  				// 화면에 출력
	  	  					calendar.addEvent({
	  	    				  title: title,
	  	    				  start: arg.start,
	  	    				  end: arg.end,
	  	    				  allDay: arg.allDay
	  	    				})
	  	  				} else if(result.retCode == 'FAIL') {
	  	  					alert('스케쥴 입력 실패');
	  	  				} else if(result.retCode == 'REPET'){
	  	  					alert('중복 입력');
	  	  				} else {
	  	  					alert('오류');
	  	  				}
  	        			
  	        		})
  	        		.catch(err => console.log(err));
 	        	
				
  	        }
  	        calendar.unselect()
  	      },
  	      eventClick: function(arg) {
  	        if (confirm('Are you sure you want to delete this event?')) {
  	          	var title = arg.event.title;
  	          	var start = arg.event.startStr;
  	          	var end = arg.event.endStr;
  	          	
  	          	fetch('removeEvent.do?title=' + title + '&start=' + start + '&end=' + end)
  	          		.then(resolve => resolve.json())
  	          		.then(result => {
	  	          		if(result.retCode == 'OK') {
			  	        	arg.event.remove();
	  	  				} else if(result.retCode == 'FAIL') {
	  	  					alert('스케쥴 삭제 실패');
	  	  				} else {
	  	  					alert('오류');
	  	  				}
  	          		})
  	          		.catch(err => console.log(err));
  	        }
  	      },
  	      editable: true,
  	      eventResizeStop: function(e) {
  	    	  console.log(e);
  	      },
  	      dayMaxEvents: true, // allow "more" link when too many events
  	      events: eventData
  	    });
    calendar.render(); // 화면 출력
// 	}

  });
  
</script>
<style>

  body {
    margin: 40px 10px;
    padding: 0;
    font-family: Arial, Helvetica Neue, Helvetica, sans-serif;
    font-size: 14px;
  }

  #calendar {
    max-width: 1100px;
    margin: 0 auto;
  }

</style>
</head>
<body>

  <div id='calendar'></div>

</body>
</html>

