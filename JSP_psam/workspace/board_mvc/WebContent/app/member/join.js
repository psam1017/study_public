/**
 * 회원가입
 */

$("#term").on("click", function(){
	if($(this).is(":checked")){
		$(".terms").prop("checked", true);
	}
	else{
		$(".terms").prop("checked", false);
	}
});

$(".term-detail a").toggle(
	function(e){
		e.preventDefault();
		$("#" + $(this).attr("href")).show();
	},
	function(e){
		e.preventDefault();
		$("#" + $(this).attr("href")).hide();
	}
);

let check = false;
function formSubmit(){
	var form = document.joinForm;

	// 값이 있으면 true
	if(!form.memberId.value || !check){
		alert("아이디를 확인해주세요.");
		return;
	}

	check = false;
	$(".terms").each(function(){
		if(!$(this).is(":checked")){
			check = true;
		}
	});

	if(check){
		alert("이용약관 동의가 필요합니다.");
		return;
	}

	form.submit();
}

function checkId(id){
	check = false;
	
	if(id == ""){
		$("#idCheck_text").text("아이디를 입력하세요.");
		return;
	}
	else{
		$.ajax({
			// 확장자가 me로 끝나면 web.xml을 거쳐서 MemberFrontController로 이동한다.
			url:contextPath + "/member/MemberCheckIdOk.me?memberId=" + id,
			type: "get",
			dataType: "json",
			success: function(result){
				if(result.status == "ok"){
					$("#idCheck_text").text("사용 가능").css("color", "blue");
					check = true;
				}
				else{
					$("#idCheck_text").text("사용 불가").css("color", "red");
				}
			},
			error: function(){
				console.log("아이디 중복 검사 비동기 통신에서 문제 발생");
			}
		});
	}
}

$("#memberId").on("blur", function(){
	checkId($(this).val());
});
