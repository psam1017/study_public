// 사실상 슬라이더 등의 대표적인 기능은 실무에서는 플러그인을 사용한다.

// each() : 각각의 내용에 순차적으로 하나씩 명령어를 실행
// 일괄 적용이 아니라 개별 적용이라는 특징이 있다.
// index() : 해당 항목이 부모 요소에서 몇 번째인지 0부터 반환한다.
$("#sliderList li").each(function () {
    let n = $(this).index() + 1;
    $(this).css({ "background-image": `url(./images/bg${n}.jpg)` });
});

let num = 0;
let pos;
let isActive = false;
let lastI = $("#sliderList li").length - 1;
const firstS = $("#sliderList li").first();
const lastS = $("#sliderList li").last();

$(".prevBtn").on("click", function () {
    prevSlider();
});

$(".nextBtn").on("click", function () {
    nextSlider();
});

let timer =  setInterval(() => {
    nextSlider();
}, 5000);

function prevSlider() {
    if (!isActive) {
        isActive = true;
        if (num > 0) {
            num--;
            $("#btnNum a").removeClass();
            $(`#btnNum a:eq(${num})`).addClass("on");
            $("#sliderList").animate(
                { "margin-left": "+=100%" },
                1000,
                function () {
                    isActive = false;
                }
            );
        } else {
            num = lastI;
            $("#btnNum a").removeClass();
            $(`#btnNum a:eq(${num})`).addClass("on");
            $("#sliderList")
                .prepend(lastS)
                .css({ "margin-left": "-=100%" })
                .animate({ "margin-left": "+=100%" }, 1000, function () {
                    $(this)
                        .append(lastS)
                        .css({ "margin-left": `${-100 * lastI}%` });
                    isActive = false;
                });
        }
    }
}

function nextSlider() {
    if(!isActive){
        isActive = true;
        if (num < lastI) {
            num++;
            $("#btnNum a").removeClass();
            $(`#btnNum a:eq(${num})`).addClass("on");
            $("#sliderList").animate({ "margin-left": "-=100%" }, 1000, function(){
                isActive = false;
            });
        } else {
            num = 0;
            $("#btnNum a").removeClass();
            $(`#btnNum a:eq(${num})`).addClass("on");
            $("#sliderList")
                .append(firstS)
                .css({ "margin-left": "+=100%" })
                .animate({ "margin-left": "-=100%" }, 1000, function () {
                    $(this).prepend(firstS).css({ "margin-left": "0" });
                    isActive = false;
                });
        }
    }
}

$("#btnNum a").on("click", function () {
    if (!isActive) {
        isActive = true;
        $("#btnNum a").removeClass();
        $(this).addClass("on");
        pos = $(this).index() * -100;
        $("#sliderList").animate(
            { "margin-left": `${pos}%` },
            1000,
            function () {
                isActive = false;
            }
        );
        num = $(this).index();
    }
});
