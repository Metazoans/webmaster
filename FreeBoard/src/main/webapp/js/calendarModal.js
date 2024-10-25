/**
 * calendarModal.js
 */

window.onclick = function(e) {
	if(e.target == document.querySelector('#exampleModal')) {
		modalClose();
	}
};

function modalShow(arg) {
	modalArg = arg;
	let body = document.querySelector('body');
	body.className = 'modal-open';
	body.style.overflow = 'hidden';
	body.style.paddingRight = '16px';
	
	// modal 태그
	let modal = document.querySelector('#exampleModal');
	modal.classList.add('show');
	modal.setAttribute('aria-modal', true);
	modal.setAttribute('role', 'dialog');
	modal.removeAttribute('aria-hidden');
	modal.style.display = 'block';
	
	start.value = arg.startStr;
	end.value = arg.endStr;
	
	let div = document.createElement('div');
	div.className = 'modal-backdrop fade show';
	body.appendChild(div);
	
	let btnX = document.querySelector('#exampleModal .btn-close');
	let btnClose = document.querySelector('#exampleModal .btn-secondary');
	
	btnX.addEventListener('click', modalClose);
	btnClose.addEventListener('click', modalClose);
	
}

function modalClose() {
	
	let body = document.querySelector('body');
	body.className = '';
	body.style.removeProperty;
	
	// modal 태그
	let modal = document.querySelector('#exampleModal');
	modal.classList.remove('show');
	modal.removeAttribute('aria-modal');
	modal.removeAttribute('role');
	modal.setAttribute('aria-hidden', true);
	modal.style.display = 'none';
	
	title.value = '';
	
	document.querySelector('.modal-backdrop').remove()
}

function modalSave() {
	// title, startStr, endStr
	let title = document.querySelector('#title').value;
    let start = document.querySelector('#start').value;
    let end = document.querySelector('#end').value;
    
    if (title) {
    	fetch('addEvent.do?title=' + title + '&start=' + start + '&end=' + end)
    		.then(resolve => resolve.json())
    		.then(result => {
  				if(result.retCode == 'OK') {
  					// title, start, end 값
  	  				// 화면에 출력
  	  				console.log(title)
  					calendar.addEvent({
    				  title: title,
    				  start: modalArg.start,
    				  end: modalArg.end,
    				  allDay: modalArg.allDay
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
    modalClose();
}

function startChange(event) {
	console.log(event.target.value);
	modalArg.start = new Date(event.target.value);
}
function endChange(event) {
	modalArg.end = new Date(event.target.value);
}