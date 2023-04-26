<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
	*{
		margin : 0;
		padding : 0;
	}
	ul{
		list-style : none;
	}
	body{
		margin: 20px auto;
		width: 400px;
	}
</style>
<title>Title</title>
</head>
<body>
	<div class="insert">
		<form>
			<input type="text" name="item">
			<input type="button" value="등록">
		</form>
	</div>
	<div id="todo_list">
	<!-- 목록 삽입 -->
		<ul>
		</ul>
	</div>
</body>
<script>
    document.addEventListener("DOMContentLoaded", function () {
        const xhr = new XMLHttpRequest();

        const insertItem = function (num, item) {
            let tagNew = document.createElement("li");
            tagNew.innerHTML = "<label><input type='checkbox' class='cb' name='" + num + "' value='" + num + "'></label>" + item;
            tagNew.setAttribute("class", num);
            tagNew.querySelector("input[type=checkbox]").addEventListener("click", deleteItem);
            let tagUl = document.querySelector("ul");
            tagUl.prepend(tagNew);
        };

        const deleteItem = function () {
            // 체크박스를 클릭하면 DB에서는 check를 true로, 해당 태그 삭제
            let item = this;
            let num = item.getAttribute("name");
            xhr.open("GET", "04.ajax_delete_item.jsp?num=" + num);
            xhr.send();
            xhr.onreadystatechange = function () {
                if (xhr.readyState !== XMLHttpRequest.DONE) {
                    return;
                }

                if (xhr.status === 200) {
                    const json = JSON.parse(xhr.response);
                    if (json.delete === "true") {
                        const pNode = item.parentNode.parentNode;
                        pNode.parentNode.removeChild(pNode);
                    }
                } else {
                    console.log("error", xhr.status, xhr.statusText);
                }
            }
        }
        
        const insertList = function(){
        	
            xhr.open("GET", "05.ajax_list_item.jsp");
            xhr.send();
            xhr.onreadystatechange = function () {
            	
            	if(xhr.readyState !== XMLHttpRequest.DONE){
            		return;
            	}
            	if(xhr.status === 200){
            		const json = JSON.parse(xhr.response);
            		for(let data of json.listData){
            			insertItem(data.num, data.item);
            		}
            		
            	} else {
                    console.log("error", xhr.status, xhr.statusText);
                }
            }
        }
        
        insertList();
        
        document.querySelector(".insert input[type=button]").addEventListener("click", function () {
            let item = document.querySelector(".insert input[name=item]");

            xhr.open(
                "GET",
                "03.ajax_insert_item.jsp?item=" + item.value
            );
            xhr.send();
            xhr.onreadystatechange = function () {
                if (xhr.readyState != XMLHttpRequest.DONE) {
                    return;
                }
                if (xhr.status === 200) {
                    const json = JSON.parse(xhr.response);
                    if (json.insert === "true") {
                        insertItem(json.num, item.value);
                        item.value = "";
                    }
                } else {
                    console.log("error", xhr.status, xhr.statusText);
                }
            };
        });
    });
</script>
</html>
