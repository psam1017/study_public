// 각 리스트의 썸네일을 클릭시 큰 이미지가 바뀌도록
// 좌우버튼을 누를경우 썸네일리스트가 한칸씩 움직이도록

const photo = document.getElementById('photo');
const ul = document.querySelector("#photoList ul");
const li = ul.querySelectorAll("li");
const button = document.querySelectorAll("#btnWrap > a");

let distance = 0;
let thumbPage = 0;
const thumbFirstPage = 0;
const thumbLastPage = li.length - 3;
const liWidth = li[0].clientWidth;
// clientWidth : width와 양 옆의 padding 값을 포함하는 값이다.

changeByThumbs();
buttonFunction();

function changeByThumbs(){
    li.forEach((element, index) => {
        element.addEventListener("click", function(e){
            e.preventDefault();
            let imgPath = this.firstChild.href; // li의 첫 번째 자식 요소는 a 태그이다. 그것의 href는 각 이미지에 연결되어 있다.
            photo.setAttribute("src", imgPath);
        });
    });
}

function buttonFunction(){
    button[1].addEventListener("click", function(e){
        e.preventDefault();
        if(thumbPage == thumbLastPage){
            return;
        }
        thumbPage++;
        distance -= liWidth;
        ul.style.transform = `translateX(${distance}px)`;
    })

    button[0].addEventListener("click", function(e){
        e.preventDefault();
        if(thumbPage == thumbFirstPage){
            return;
        }
        thumbPage--;
        distance += liWidth;
        ul.style.transform = `translateX(${distance}px)`;
    })
}