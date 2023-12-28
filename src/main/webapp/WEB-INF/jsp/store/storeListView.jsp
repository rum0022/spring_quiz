<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>배탈의 민족</title>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>

<link rel="stylesheet" href="/css/store/style2.css" type="text/css">
</head>
<body>
	<div id="wrap">
		<header class="bg-info d-flex align-items-center">
			<h1 class="text-white font-weight-bold ml-4">배탈의 민족</h1>
		</header>
		
		<section class="contents">
			<div class="display-4 my-3">우리동네 가게</div>
			<%--가게영역 --%>
					<c:forEach items="${storeList}" var="store">
					<div class="content mt-4">
						<a href="/store/store-review?storeId=${store.id}">
							<div class="store-box border border-info rounded p-3">
									<h3 class="font-seight-bold mb-3">${store.name}</h3>
									<h4>전화번호 : ${store.phoneNumber}</h4>
									<h4>주소 : ${store.address}</h4>
							</div>	
						</a>			
					</div>	
				    </c:forEach>					
		</section>
						
		<footer>
			<hr>
			<h3>(주)우와한형제</h3>
			<h4 >고객센터 : 1500-1500</h4>
		
		</footer>
	</div>
</body>
</html>