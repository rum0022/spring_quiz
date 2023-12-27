<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>     
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>
<meta charset="UTF-8">
<link rel="stylesheet" href="/css/weather_history/style.css" type="text/css">
<title>날씨정보</title>
</head>
<body>
	<div id="wrap" class="container">
		<section class="contents d-flex">
			<aside class="col-2">
				<div class="d-flex justify-content-center mt-3">				
					<img src="/img/foot_logo2.png" alt="로고" width="100px">
				</div>
				<ul class="nav flex-column">
					<li class="nav-item font-weight-bold"><a href="http://localhost:8080/weather-history/add-weather-view" class="nav-link">날씨</a></li>
					<li class="nav-item font-weight-bold"><a href="#" class="nav-link">날씨입력</a></li>
					<li class="nav-item font-weight-bold"><a href="#" class="nav-link">테마날씨</a></li>
					<li class="nav-item font-weight-bold"><a href="#" class="nav-link">관측기후</a></li>
				</ul>
			</aside>
			<section class="content1 bg-warning col-10">
				<div class="container mt-4">
					<h3>과거날씨</h3>
					<table class="table text-center">
						<thead>
							<tr>
								<th>날짜</th>
								<th>날씨</th>
								<th>기온</th>
								<th>강수량</th>
								<th>미세먼지</th>
								<th>풍속</th>
							</tr>
						</thead>
						<tbody>
						<c:forEach items="${weatherHistory}" var="weather">
							<tr>
								<td><fmt:formatDate value="${weather.date}" pattern="yyyy년 MM월 dd일" /></td>
								<td>
									<c:choose>
										<c:when test="${weather.weather == '비'}">
										 	<img src="/img/rainy.jpg">
										</c:when>
										<c:when test="${weather.weather eq '흐림'}">
											<img src="/img/cloudy.jpg">
										</c:when>
										<c:when test="${weather.weather eq '맑음'}">
											<img src="/img/sunny.jpg">
										</c:when>
										<c:otherwise>
											<img src="/img/partlyCloudy.jpg">
										</c:otherwise>
									</c:choose>
								</td>
								<td>${weather.temperatures}</td>
								<td>${weather.precipitation}</td>
								<td>${weather.microDust}</td>
								<td>${weather.windSpeed}</td>
							</tr>
						</c:forEach>	
						</tbody>
					</table>
				</div>
			</section>
		</section>
		
		<footer class="bg-success d-flex align-items-center"> 
			<div class="d-flex">
				<img src="/img/foot_logo2.png" width=100px>
				<div class="ml-3">
					<div>(07062) 서울시 동작구 여의대방로16길 61</div>
					<div>Copyright@20XX KMA. All Rights RESERVED.</div>
				</div>
			</div>
		</footer>
		
		
	</div>
</body>
</html>