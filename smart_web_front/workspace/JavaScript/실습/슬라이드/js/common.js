const sWrap = document.getElementById('sliderWrap');
const sList = document.getElementById('sliderList');
const lis = sList.querySelectorAll('li');
const btn = document.querySelectorAll('#btnList button');
const lisCopy1 = lis[0].cloneNode(true);
const lisCopy2 = lis[lis.length-1].cloneNode(true)
let lisNum = lis.length + 2;
let sNum = 20;
let state = 1;
sList.append(lisCopy1);
sList.prepend(lisCopy2);
// let pos = sList.clientWidth;
sList.style.width = `${lisNum*100}%`;
sList.style.transform = `translateX(-${20}%)`;

let nextSlider = ()=> {
  state = 0;
  if ( state == 0 ) {
    sNum += 20;
    sList.style.transition = '1s';
    sList.style.transform = `translateX(-${sNum}%)`;
    setTimeout(()=>{
      if ( sNum == 80 ) {
        sList.style.transition = '0s';
        sList.style.transform = `translateX(-${20}%)`;
        sNum = 20;
      }
      state = 1;
    }, 1000)
  }
}
let prevSlider = ()=> {
    state = 0;
    if ( state == 0 ) {
      sNum -= 20;
      sList.style.transition = '1s';
      sList.style.transform = `translateX(-${sNum}%)`;
      setTimeout(()=>{
        if ( sNum == 0 ) {
          sList.style.transition = '0s';
          sList.style.transform = `translateX(-${60}%)`;
          sNum = 60;
          state = 1;
        }
        state = 1;
      }, 1000)
    }
}

let timer = setInterval(nextSlider, 3000);
btn[0].addEventListener('click', ()=> {
  clearInterval(timer)
  if ( state == 1 ) {
    prevSlider();
  }
})
btn[1].addEventListener('click', ()=> {
  clearInterval(timer);
  if ( state == 1) {
    nextSlider();
  }
})
btn[2].addEventListener('click', ()=> {
  timer = setInterval(nextSlider, 3000);
})
