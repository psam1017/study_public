/**
 * 회원가입 유효성 검사
 */

var form = document.joinForm;

function join(){
	// value를 조건식 안에서 사용하면
	// 값이 있을 때 true, 값이 없을 때 false
	if(!form.id.value){
		alert("아이디를 입력해주세요.");
		form.id.focus();
		return;
	}
	if(form.id.value.length <= 4 || form.id.value.length >= 16){
		alert("아이디를 4자 이상, 16자 이하로 입력해주세요.");
		form.id.focus();
		return;
	}
	
	if(!form.name.value){
		alert("이름을 입력해주세요.");
		form.name.focus();
		return;
	}
	
	if(!form.password.value){
		alert("비밀번호를 입력해주세요.");
		form.password.focus();
		return;
	}
	
	//비밀번호 정규식(-> 구글에 '자바스크립트 비밀번호 정규식' 검색하면 잘 나온다!)
	//8자리 이상, 대문자, 소문자, 숫자, 특수문자 모두 포함되어 있는지 검사
	let reg = /^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[!@#$%^&*-?]).{8,}$/;
	let hanCheck = /[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]/;
	
	if(!reg.test(form.password.value)){
		alert("비밀번호는 8자리 이상, 대문자, 소문자, 숫자, 특수문자를 모두 포함시켜주세요.");
		form.password.focus();
		return;
	}
	
	//같은 문자를 4번 사용했는지 검사
	if(/(\w)\1\1\1/.test(form.password.value)){
		alert("비밀번호는 같은 문자를 4번 이상 사용할 수 없습니다.");
		form.password.focus();
		return;
	}
	
	//비밀번호 안에 아이디가 있는지 검사
//	if(form.password.value.search(form.id.value != -1)){
//		alert("비밀번호는 아이디를 포함할 수 없습니다.");
//		form.password.focus();
//		return;
//	}
	if(form.password.value.search(form.id.value) != -1){
		alert("비밀번호에 아이디를 포함할 수 없습니다.");
		form.password.focus();
		return;
	}
	
	//비밀번호 안에 한글이 있는지 검사
	//OS, 브라우저에 따라 한글이 아예 입력이 되지 않기도 한다.
	if(hanCheck.test(form.password.value)){
		alert("비밀번호에 한글을 사용할 수 없습니다.");
		form.password.focus();
		return;
	}
	
	//비밀번호에 공백(\s)이 있는지 검사
	if(form.password.value.search(/\s/) != -1){
		alert("비밀번호는 공백 없이 입력해주세요.");
		form.password.focus();
		return;
	}
	
	//비밀번호가 일치하는지 확인
	if(form.password_re.value != form.password.value){
		alert("비밀번호를 확인해주세요.");
		form.password_re.focus();
		return;
	}
	
	if(!form.id.readOnly){
		alert("아이디 중복 검사를 진행해주세요.");
		return;
	}
	form.submit();
}


//아이디 입력 칸을 클릭하면, 다시 활성화가 가능.
$("input[name='id']").on("click", function(){
	form.id.readOnly = false;
})

//아이디 중복 검사
function checkId(){
	var xhr = new XMLHttpRequest();
	
	xhr.open("GET", "join_ok.jsp?id=" + document.getElementById("id").value, true);
	xhr.send();
	
	xhr.onreadystatechange = function(){
		if(xhr.readyState == XMLHttpRequest.DONE && xhr.status == 200){
			//console.log(xhr.responseText);
			document.getElementById("result").innerHTML = xhr.responseText.trim();
			//join_ok.jsp에서 "사용가능한 아이디입니다."라는 메시지를 출력하기 때문에 "가능"을 search해야 한다.
			if(xhr.responseText.search("가능") != -1){
				form.id.readOnly = true;
			}
		}
	}
}
