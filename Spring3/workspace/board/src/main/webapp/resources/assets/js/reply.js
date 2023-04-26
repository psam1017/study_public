/**
 * JavaScript 모듈화
 * 
 * 이벤트, ajax, DOM 요소를 나눠서 작성하여 모듈화하기
 * 함수들을 하나의 모듈처럼 묶음으로 구성하는 것을 의미한다.
 * 화면 내에서 Javascript를 처리하다 보면 이벤트 처리, DOM, Ajax 처리 등이 복잡하게 섞여있다.
 * 이러한 상황에서는 유지 및 보수가 어려우므로 Javascript 코드를 여러 부품으로 분리 및 조립하는 형식으로 설계한다.
 */
 
console.log("reply module")

// javascript object와 json의 차이
// javascript의 object는 key에 따옴표가 없고, json는 key에도 따옴표를 붙인다.
// JSON.stringify : json으로 바꾸기
// JSON.parse : javascript object로 바꾸기

let replyService = (function(){
	
	// 댓글 추가
	function add(reply, callback){
		console.log("add reply");
		
		$.ajax({
			url : "/replies/new",
			type : "post",
			data : JSON.stringify(reply),
			contentType : "application/json; charset=utf-8",
			dataType : "text",
			success : function(result){
				if(callback){
					callback(result);
				}
			}
		});
	}
	
	// 댓글 목록 보기
	// param은 게시글 번호와 요청한 페이지를 받아올 수 있는 객체이다.
	function getList(param, callback, error){
		let bno = param.bno;
		let page = param.page || 1; // let var = a || b; --> a가 값이 없으면(undefined) b이다.
		
		// get 방식으로 요청하는 함수이며, 가져온다는 의미가 아니다.
		// getJSON() : 빠르고 편하게 요청 후 JSON 데이터를 받아오기 위해 사용한다.
		// .json을 붙인 이유 : XML이 default로 설정되어 있어서 JSON 형식으로 전달 받기 위해 사용하는 것
		$.getJSON("/replies/" + bno + "/" + page + ".json", function(result){
			if(callback){
				callback(result);
			}
		}).fail(function(xhr, status, err){
			if(error){
				error(err);
			}
		});
	}
	
	// 댓글 삭제
	function remove(rno, callback){
		$.ajax({
			url : "/replies/" + rno,
			type : "delete",
			success : function(result){
				if(callback){
					callback(result);
				}
			}
		});
	}
	
	// 댓글 수정
	function modify(reply, callback){
		$.ajax({
			url : "/replies/" + reply.rno,
			type : "put",
			data : JSON.stringify(reply),
			contentType : "application/json; charset=utf-8",
			success : function(result){
				if(callback){
					callback(result);
				}
			}
		})
	}
	
	// 댓글 하나 조회
	function getReply(rno, callback){
		// json 밖에 안 들어오니까 get을 사용해도 된다.
		$.get("/replies/" + rno, function(reply){
			if(callback){
				callback(reply);
			
			}
		});
	}
	
	// 댓글 작성 시간
	// 작성 시간 기준 24시간 이후는 '연-월-일'
	// 24시간 이전은 '시:분:초'로 만든다.
	
	function displayTime(timeValue){
		let today = new Date();
		let date = new Date(timeValue);
		let gap = today.getTime() - date.getTime();
		
		if(gap < 1000 * 60 * 60 * 24){
			let hh = date.getHours();
			let mm = date.getMinutes();
			let ss = date.getSeconds();
			
			return [hh < 10 ? '0' + hh : hh, mm < 10 ? '0' + mm : mm, ss < 10 ? '0' + ss : ss].join(':');
		}
		else{
			let yy = date.getFullYear();
			let mm = date.getMonth() + 1;
			let dd = date.getDate();
			
			return [yy, mm < 10 ? '0' + mm : mm, dd < 10 ? '0' + dd : dd].join('-');
		}
	}
	
	return {add : add, getList : getList, remove : remove, modify : modify, getReply : getReply, displayTime : displayTime}
})();
