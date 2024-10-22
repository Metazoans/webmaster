/**
 * basic.js
 */

console.log("basic.js")

let name = "홍길동";	// string
let age = 20;	// number
let obj = {name: "홍길동"
		  ,age: 20
		  ,showInfo: function() {
			  return this.name + " - " + this.age;
		  }};

console.log(obj.name);
console.log(obj['age']);
console.log(obj.showInfo());

// DOM = Document Object Model
// <li></li>
let li = document.createElement("li");
li.innerText = 'Cherry';

let ul = document.querySelector('#show ul');	// css의 선택자
ul.appendChild(li);

console.log(ul);	// 아이디 show의 ul태그의 내용

document.querySelectorAll('#show ul li').forEach(function(fruit) {
	fruit.style.color = 'red';
	fruit.addEventListener('click', function(e) {
		fruit.remove();
	});
	console.log(fruit.innerHTML);
});

let table = document.querySelector('#show table tbody');
let tr = document.createElement("tr");
let th = document.createElement("th");
let td = document.createElement("td");

th.innerText = '이름';
td.innerText = name;

tr.appendChild(th);
tr.appendChild(td);

table.appendChild(tr);


let data = [obj];
data.push({name: "박민수", age: 22});
data.push({name: "송민혁", age: 25});

makeList();

function makeList() {
	document.querySelector('#show table:nth-of-type(2)').className = 'table';
	
	for(let i = 0; i < data.length; i++) {
		let tr = document.createElement('tr');
		let td = document.createElement('td');
		
		td.innerHTML = data[i]['name'];
		tr.appendChild(td);

		td = document.createElement('td');
		td.innerHTML = data[i]['age'];
		tr.appendChild(td);
		
		document.querySelector('#show table:nth-of-type(2) tbody').appendChild(tr);
	}
}






