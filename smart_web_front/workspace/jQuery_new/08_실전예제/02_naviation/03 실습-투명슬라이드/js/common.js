// 배경 한꺼번에 적용하기
$("#sliderList li").each(function() {
    let n = $(this).index() + 1;
    $(this).css({ backgroundImage: `url(./images/bg${n}.jpg)`})
})
// 번호버튼 모양을 위한 span 추가 (for 게이지효과적용)
$("#btnNum a").wrapInner('<span>')

// 슬라이더구현
// 슬라이더구현을 위한 초기값 설정
let sLength = $("#sliderList li").length;
let num;
let classNum = 0;
let state = 1;

// nextSlider()
let nextSlider = ()=> {
  state = 0;
  classNum++;
  if (classNum == sLength) classNum = 0;
  $("#btnNum a").removeClass('on')
  $("#btnNum a:eq("+ classNum  +")").addClass('on')
  $("#sliderList li:eq(1)")
      .addClass('active')
      .css({ opacity: 0 })
      .animate({ opacity: 1 }, 1000, function() {
          $("#sliderList").append($("#sliderList li:eq(0)"));
          $("#sliderList li:last").removeClass('active');
          state = 1;
      })
}
// prevSlider()
let prevSlider = ()=> {
  state = 0;
  classNum--;
  if (classNum == -1) classNum = 3;
  $("#btnNum a").removeClass('on')
  $("#btnNum a:eq("+ classNum  +")").addClass('on')
  $("#sliderList li:last")
      .addClass('active')
      .css({ opacity: 0 })
      .animate({ opacity: 1 }, 1000, function() {
          $("#sliderList").prepend($(this));
          $("#sliderList li:eq(1)").removeClass('active');
          state = 1;
      })
}
// 자동슬라이더
let timer = setInterval(nextSlider, 3000);

// 슬라이더 좌우버튼
$(".nextBtn").on('click', function() {
  if (state == 1) nextSlider();
})
$(".prevBtn").on('click', function() {
  if (state == 1) prevSlider();
})
// 슬라이더 번호버튼
$("#btnNum a").on('click', function() {
  if ( state == 1 ) {
    state = 0;
    $("#btnNum a").removeClass('on')
    $(this).addClass('on')
    classNum = $(this).index();
    num = $(this).index()+1;
    if ( $(".slider"+num).hasClass('active') ) {
      state = 1;
      return;
    }
    $(".slider"+num).addClass('active')
                    .css({ opacity: 0 })
                    .animate({ opacity: 1 }, 1000, function() {
                        $("#sliderList li").not($(this)).removeClass('active')
                        for( i=1; i<4; i++ ) {
                          if ( num == 4 ) num = 0;
                          num++;
                          $("#sliderList").append($(".slider"+num))
                        }
                        state = 1;
                    })
  }
})

// 버튼공통
$("#btnPos a, #btnNum a").on('click', function(e) {
  e.preventDefault();
  clearInterval(timer)
  timer = setInterval(nextSlider, 3000)
})
