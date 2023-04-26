<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="container">
	<section>
		<h1>구매하기</h1>
		<h3>구매상품 : ${orderProductName }</h3>
		<span>${totalPrice }원</span>
		${info.orderName }
		<p>
		<div><label><input type="radio" name="method" value="신용카드" checked>신용카드</label></div>
		<div><label><input type="radio" name="method" value="가상계좌" checked>가상계좌</label></div>
		<p>
		<button id="payment-button">결제하기</button>
	</section>
</div>
</body>

<script src="https://js.tosspayments.com/v1"></script>
<script>
    var tossPayments = TossPayments("test_ck_D5GePWvyJnrK0W0k6q8gLzN97Eoq");
    var button = document.getElementById("payment-button");

    // var orderId = new Date().getTime();
    //
    button.addEventListener("click", function () {
        var method = document.querySelector('input[name=method]:checked').value; // "카드" 혹은 "가상계좌"

        var paymentData = {
            amount: ${totalPrice},
            orderId: '${info.orderNo}',
            orderName: '${orderProductName}',
            customerName: '${info.orderName}',
            successUrl: window.location.origin + "/order/success.do", // 성공시 리턴될  주소
            failUrl: window.location.origin + "/order/fail.do",  // 실패시 리턴될 주소
        };

        if (method === '가상계좌') {
            paymentData.virtualAccountCallbackUrl = window.location.origin + '/order/virtualAccountCallback.do'
        }

        tossPayments.requestPayment(method, paymentData);
    });
</script>

</html>