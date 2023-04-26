<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
	* {
	  -webkit-box-sizing: border-box;
	          box-sizing: border-box;
	}
	
	body {
	  padding: 0;
	  margin: 0;
	}
	
	#notfound {
	  position: relative;
	  height: 100vh;
	}
	
	#notfound .notfound {
	  position: absolute;
	  left: 50%;
	  top: 50%;
	  -webkit-transform: translate(-50%, -50%);
	      -ms-transform: translate(-50%, -50%);
	          transform: translate(-50%, -50%);
	}
	
	.notfound {
	  max-width: 520px;
	  width: 100%;
	  line-height: 1.4;
	  text-align: center;
	}
	
	.notfound .notfound-404 {
	  position: relative;
	  height: 200px;
	  margin: 0px auto 20px;
	  z-index: -1;
	}
	
	.notfound .notfound-404 h1 {
	  font-family: 'Montserrat', sans-serif;
	  font-size: 236px;
	  font-weight: 200;
	  margin: 0px;
	  color: #211b19;
	  text-transform: uppercase;
	  position: absolute;
	  left: 50%;
	  top: 20%;
	  -webkit-transform: translate(-50%, -50%);
	      -ms-transform: translate(-50%, -50%);
	          transform: translate(-50%, -50%);
	}
	
	.notfound .notfound-404 h2 {
	  font-family: 'Montserrat', sans-serif;
	  font-size: 28px;
	  font-weight: 400;
	  text-transform: uppercase;
	  color: #211b19;
	  background: #fff;
	  padding: 10px 5px;
	  margin: auto;
	  display: inline-block;
	  position: absolute;
	  bottom: 0px;
	  left: 0;
	  right: 0;
	}
	
	.notfound a {
	  font-family: 'Montserrat', sans-serif;
	  display: inline-block;
	  font-weight: 700;
	  text-decoration: none;
	  color: #fff;
	  text-transform: uppercase;
	  padding: 13px 23px;
	  background: #ff8b77;
	  font-size: 18px;
	  -webkit-transition: 0.2s all;
	  transition: 0.2s all;
	}
	
	.notfound a:hover {
	  color: #ff6300;
	  background: #211b19;
	}
	
	@media only screen and (max-width: 767px) {
	  .notfound .notfound-404 h1 {
	    font-size: 148px;
	  }
	}
	
	@media only screen and (max-width: 480px) {
	  .notfound .notfound-404 {
	    height: 148px;
	    margin: 0px auto 10px;
	  }
	  .notfound .notfound-404 h1 {
	    font-size: 86px;
	  }
	  .notfound .notfound-404 h2 {
	    font-size: 16px;
	  }
	  .notfound a {
	    padding: 7px 15px;
	    font-size: 14px;
	  }
	}
</style>
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

	<title>Error</title>

	<!-- Google font -->
	<link href="https://fonts.googleapis.com/css?family=Montserrat:200,400,700" rel="stylesheet">
	<title>error</title>
</head>
<body>
	<div id="notfound">
		<div class="notfound">
			<div class="notfound-404">
				<h1>Sorry</h1>
				<h2>Error - 작업을 다시 확인해 주세요.</h2>
			</div>
			<a href="javascript:history.go(-1)" style="color:#ff8b77; background:#fff">Go To Back</a>
			<a href="/board/list">Go TO Board</a>
		</div>
	</div>
</body>
</html>