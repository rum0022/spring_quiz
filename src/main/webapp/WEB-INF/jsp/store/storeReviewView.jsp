<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
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
	<div id="wrap">
		<header class="bg-info d-flex align-items-center">
			<h1 class="text-white font-weight-bold ml-4">배탈의 민족</h1>
		</header>
		<section class="contents">
		<c:forEach items="${storeList}" var="store">
			<div class="display-4 my-3">${store.name} - 리뷰</div>
		</c:forEach>	
			
			<%-- 리뷰영역 --%>
			<c:if test="${empty reviewList}">
				<div class="display-4 font-weight-bold">작성된 리뷰가 없습니다.</div>
			</c:if>
			<c:if test="${not empty reviewList}">
				<c:forEach items="${reviewList}" var="review">
				<div class="review mb-3">
					<div class="border border-info p-3">
						<span class="font-weight-bold">${review.userName}</span>
						
						<%-- 별 표시 --%>
						<div class="star-area d-inline">
							<c:set var="point" value="${review.point}" />
							<c:forEach begin="1" end="5">
								<c:choose>
									<c:when test="${point > 0.5}">
										<img src="/img/star_fill.png" width="20" alt="star">
										<c:set var="point" value="${point - 1}" />
									</c:when>
									<c:when test="${point == 0.5}">
										<img src="/img/star_half.png" width="20">
										<c:set var="point" value="${point - 0.5}" />
									</c:when>
									<c:when test="${point == 0}">
										<img src="/img/star_empty.png" width="20">
									</c:when>
								</c:choose>
							</c:forEach>
						</div>
						
						<small class="text-secondary d-block my-2">${review.createdAt}</small>
						<div class="my-2">${review.review}</div>
						<small class="menu-box rounded p-1">${review.menu}</small>
					</div>
				</div>
				</c:forEach>
			</c:if>
			</section>
		
			
		<footer>
			<hr>
			<h2>(주) 우와한형제</h2>
			<h4 class="text-secondary">고객센터: 1500-1500</h4>
		</footer>
	</div>
</body>
</html>