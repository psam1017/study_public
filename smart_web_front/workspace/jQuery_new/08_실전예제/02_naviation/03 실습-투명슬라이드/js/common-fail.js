// 사실상 슬라이더 등의 대표적인 기능은 실무에서는 플러그인을 사용한다.

// each() : 각각의 내용에 순차적으로 하나씩 명령어를 실행
// 일괄 적용이 아니라 개별 적용이라는 특징이 있다.
// index() : 해당 항목이 부모 요소에서 몇 번째인지 0부터 반환한다.
$("#sliderList li").each(function () {
    let n = $(this).index() + 1;
    $(this).css({ "background-image": `url(./images/bg${n}.jpg)` });
});

let num = 0;
let isActive = false;
let lastI = $("#sliderList li").length - 1;

$(".prevBtn").on("click", function () {
    prevSlider();
});

$(".nextBtn").on("click", function () {
    nextSlider();
});

// let timer =  setInterval(() => {
//     nextSlider();
// }, 5000);
function prevSlider() {
    console.log(num)
    if(!isActive){
        isActive = !isActive;
        num--;
        if (num < 0) {
            num = lastI;
            $(`#sliderList li:eq(${num})`)
            .addClass("active")
            .css({ opacity: 0 })
            .animate({ opacity: 1 }, 1000, function () {
                $(`#sliderList li:eq(0)`).removeClass("active");
                isActive = !isActive;
            });
        } else {
            $(`#sliderList li:eq(${num})`)
            .addClass("active")
            .next()
            .css({ opacity: 1 })
            .animate({ opacity: 0 }, 1000, function () {
                    $(this).removeClass("active").css({ opacity: 1 });
                    isActive = !isActive;
                });
            }
            $("#btnNum a").removeClass();
        $(`#btnNum a:eq(${num})`).addClass("on");
    }
}

function nextSlider() {
    console.log(num)
    if(!isActive){
        isActive = !isActive;
        num++;
        if (num > lastI) {
            num = 0;
            $(`#sliderList li:eq(${lastI})`).removeClass("active");
        }
        $(`#sliderList li:eq(${num})`)
            .addClass("active")
            .css({ opacity: 0 })
            .animate({ opacity: 1 }, 1000, function () {
                $(this).prev().removeClass("active");
                isActive = !isActive;
        });
        $("#btnNum a").removeClass();
        $(`#btnNum a:eq(${num})`).addClass("on");
    }
}

// $("#btnNum a").on("click", function () {
//     if (!isActive) {
//         isActive = true;
//         $("#btnNum a").removeClass();
//         $(this).addClass("on");
//         // pos = $(this).index() * -100;
//         // $("#sliderList").animate(
//         //     { "margin-left": `${pos}%` },
//         //     1000,
//         //     function () {
//         //         isActive = false;
//         //     }
//         // );
//         num = $(this).index();
//     }
// });

$("#btnNum a").on("click", function () {
    if (!isActive) {
        isActive = !isActive;
        $("#btnNum a").removeClass();
        $(this).addClass("on");
        let prevNum = num;
        num = $(this).index();
        console.log(prevNum, num)
        $(`#sliderList li:eq(${num})`)
        .addClass("active")
        .css({opacity:0})
        .animate({opacity:1}, 2000);
        $(`#sliderList li:eq(${prevNum})`)
            .addClass("active")
            .animate({opacity:0}, 2000, function(){
                $(this).removeClass("active");
                isActive = !isActive;
        });
    }
});
