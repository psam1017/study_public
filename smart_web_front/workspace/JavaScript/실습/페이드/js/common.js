const sWrap = document.getElementById('sliderWrap');
const sList = document.getElementById('sliderList');
const lis = sList.querySelectorAll('li');
const btn = document.querySelectorAll('#btnList button');

// 첫번째 요소만 보이게 하고 링크도 적용되도록 구조변경

// prepend(), append() : 요소를 앞/뒤로 추가한다. 만약 기존의 요소를 인자로 입력하면 이동한다.
lis[1].style.opacity = 0;
lis[2].style.opacity = 0;
sList.append(lis[0]);

// state를 두어서 한 번 버튼 클릭 시 1초 지연시키기
let state = 1;

// 이벤트 함수
let moveNext = ()=> {
  const lis = sList.querySelectorAll('li');
  sList.append(lis[0]);
  setTimeout(()=>{
    lis[0].style.opacity = 1;
    lis[lis.length-1].style.opacity = 0;
  }, 1)
  setTimeout(()=> { state = 1 }, 1000)
}
let movePrev = ()=> {
  const lis = sList.querySelectorAll('li');
  sList.prepend(lis[lis.length-1]);
  setTimeout(()=>{
    lis[lis.length-2].style.opacity = 1;
    lis[lis.length-1].style.opacity = 0;
  }, 1)
  setTimeout(()=> { state = 1 }, 1000)
}

// 자동재생
let timer = setInterval(moveNext, 3000);

// 버튼에 이벤트 추가
btn[1].addEventListener('click', (e)=>{
  e.preventDefault();
  if ( state == 1) {
    state = 0;
    moveNext();
  }
})
btn[0].addEventListener('click', (e)=>{
  e.preventDefault();
  if ( state == 1) {
    state = 0;
    movePrev();
  }
})
