/**
 * 
 */

function checkAddProduct(){
	
	const productID = document.getElementById("productID");
	const pName = document.getElementById("pName");
	const unitPrice = document.getElementById("unitPrice");
	const unitsInStock = document.getElementById("unitsInStock");
	
	if(!check(/^P[0-9]{4,11}$/, productID, "[상품코드]\nP와 숫자를 조합하여 5~11자까지 만드세요\n첫 글자는 반드시 P로 시작하세요.")){
		return false;
	}
	
	if(pName.value.length < 4 || pName.value.length > 12){
		alert("[상품명]\n최소 5자에서 최대 11자까지 입력하세요.");
		pName.select();
		pName.focus();
		return false;
	}
	
	if(unitPrice.value.length == 0 || isNaN(unitPrice.value)){
		alert("[상품가격]\n숫자만 입력하세요.");
		unitPrice.select();
		unitPrice.focus();
		return false;
	}
	
	if(unitPrice.value < 0){
		alert("[상품가격]\n음수는 입력할 수 없습니다..");
		unitPrice.select();
		unitPrice.focus();
		return false;
	}
	
	if(unitsInStock.value.length == 0 || isNaN(unitsInStock.value)){
		alert("[재고수량]\n숫자만 입력하세요.");
		unitsInStock.select();
		unitsInStock.focus();
		return false;
	}
	
	if(unitsInStock.value < 0){
		alert("[재고수량]\n음수는 입력할 수 없습니다..");
		unitsInStock.select();
		unitsInStock.focus();
		return false;
	}
	
	document.newProduct.submit();
}

function check(regExp, e, text){
	
	if(regExp.test(e.value)){
		return true;
	}
	else{
		alert(text);
		return false;
	}
}
