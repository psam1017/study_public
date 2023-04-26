// 1000 이상일 때만 #gnbList.on 선택자를 생성하여 반응형에 따른 기능 추가
$(".item").on("mouseenter", function () {
    $("#gnbList").addClass("on");
});
$(".item").on("mouseleave", function () {
    $("#gnbList").removeClass("on");
});

// 1000 미만
$(".menuView").on("click", function () {
    $("#gnb").addClass("on");
    $(".item").addClass("mobile");
    $(".snb").hide();
});
$(".menuClose").on("click", function () {
    $("#gnb").removeClass("on");
    $(".item").removeClass("mobile");
});

// live 대체 문법. js에서 만든 요소 다루기
$(document).on("click", ".mobile", function () {
    $(".snb").not($(this).children(".snb")).slideUp();
    $(this).children(".snb").slideToggle();
});

// -> 함수 싫행 후 999에서 1000으로 가면 내비게이션이 slideUp된 상태가 될 수 있다.
// resize로 변경
$(window).on("resize", function () {
    resizing();
});

function resizing() {
    if ($(window).width() >= 1000) {
        $(".snb").css({ "display": "block" });
        $("#gnb").removeClass("on");
        $(".item").removeClass("mobile");
        $(".menuView").hide();
    } else {
        $(".menuView").show();
        if ($("#gnb").hasClass("on")) {
            $(".menuView").hide();
        }
    }
}

// scrollTop, offsetTop 개념 외에도
// jQuery 메소드인
// position().top() 또는 position().let()
// offset().top() 또는 offset().let()
// 배너가 스크롤을 따라 이동
$(window).on("scroll", function () {
    let banPos = $(window).scrollTop();
    $("#banner")
        .stop()
        .animate({ top: banPos + 200 });
    $("#gnb").css({ position: "fixed" });
});

// gnb 주메뉴 클릭 시 해당 섹션으로 슬라이딩
$(".item > a").on("click", function (e) {
    e.preventDefault();
    let idName = $(this).attr("href");
    let secPos = $(idName).position().top;
    $("html, body").animate({ scrollTop: secPos });
});

// jQuery 문법을 참조하는 변수도 $() 안에서 사용해야 한다. 그냥 idName을 사용하면 $("#content1")과 같아진다.
// let idName = $(this).attr("href");
// let secPos = $(idName).position().top();