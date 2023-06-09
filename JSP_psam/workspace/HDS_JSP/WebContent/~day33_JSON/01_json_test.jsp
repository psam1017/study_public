<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSON</title>
</head>
<body>
	<table>
		<tr>
			<td class="td1"><h2>실시간 검색 순위</h2></td>
			<td class="td2"><div id="ranking">키워드</div></td>
		</tr>
	</table>
</body>
<script>
	window.onload = function(){
		let ranking = document.getElementById("ranking");
		let xhr = new XMLHttpRequest();
		let obj;
		let str;
		let words = new Array();
		
		xhr.open("GET", "data.json", true);
		xhr.send();
		
		xhr.onreadystatechange = function(){
			if(xhr.readyState == 4){
				if(xhr.status == 200){
					obj = JSON.parse(xhr.responseText);
					
					for(let i = 0; i < obj.searchWord.length; i++){
						str = "[" + obj.searchWord[i].rank + "]" + obj.searchWord[i].name;
						words[i] = str;
					}
				}
			}
		}
		
		let i = 0;
		let interval = setInterval(function(){
			if(i == obj.searchWord.length){
				i = 0;
			}
			ranking.innerHTML = "<h3>" + words[i] + "</h3>";
			i++;
		}, 1000);
		
		setTimeOut(function(){
			clearInterval(interval);
		}, 10000);
	}
</script>
</html>