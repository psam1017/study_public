// 최초로 이벤트를 1회 생성함
addEventListener("wheel", wheelHandler, {passive: false});

// 키를 눌렀을 때 이벤트를 삭제함
addEventListener("keydown", function(e){
    removeEventListener("wheel", wheelHandler);
});

// 키를 떼면 다시 이벤트를 생성함
addEventListener("keyup", function(e){
    addEventListener("wheel", wheelHandler, {passive: false});
});