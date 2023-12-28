<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>배탈의 민족 리뷰</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>

<link rel="stylesheet" href="/css/store/style2.css" type="text/css">
</head>
<body>
<div id="wrap" class="container">
		<header class="d-flex align-items-center">
			<h1 class="text-white font-weight-bold  ml-4">배탈의 민족</h1>
		</header>
		
		<section class="contents">
			<c:forEach items="${reviews}" var="review">
				<div class="font d-flex align-items-center">${review.menu} - 리뷰</div>
					<div class="content mt-4">
								<div class=" mt-3 ml-3 mb-3">
									<h3>${review.userName}</h3>
									<small>${review.createdAt}</small><br>
									<span>${review.review}</span>
								</div>			
							</div>
					</c:forEach>					
		</section>
		<hr>	
			
		<footer>
			<div>
				<h3>(주)우와한형제</h3>
				<h4>고객센터 : 1500-1500</h4>
			</div>
		</footer>
	</div>
</body>
</html>