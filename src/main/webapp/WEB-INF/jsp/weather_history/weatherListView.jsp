<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>     
<!DOCTYPE html>
<html>
<head>

<%--  bootstrap(datepicker 쓰려면 jquery 원본으로)  --%>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>
<meta charset="UTF-8">

<%-- 내가 만든 외부 스타일시트 --%>
<link rel="stylesheet" href="/css/weather_history/style.css" type="text/css">
<title>날씨정보</title>
</head>
<body>
	<div id="wrap">
		<div class="contents d-flex">
		<%-- 메뉴영역 --%>
			<nav class="col-2">
			<%-- 상단로고 --%>
				<div class="logo d-flex justify-content-center mt-3">				
					<img src="/img/foot_logo2.png" alt="로고" width="100px">
				</div>
				
				<%-- 메뉴 --%>
				<%-- flex-column 세로메뉴 --%>
				<ul class="nav flex-column mt-4">
					<li class="nav-item">
					<a href="http://localhost:8080/weather-history/weather-list-view" class="nav-link menu-font">날씨</a></li>
					<li class="nav-item">
					<a href="http://localhost:8080/weather-history/add-weather-view" class="nav-link menu-font">날씨입력</a></li>
					<li class="nav-item">
					<a href="#" class="nav-link menu-font">테마날씨</a></li>
					<li class="nav-item">
					<a href="#" class="nav-link menu-font">관측기후</a></li>
				</ul>
			</nav>
			
			<%--날씨 히스토리 --%>
			<section class="contents col-10 mt-3 ml-5">
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
		</div>
		
		<footer class="d-flex align-items-center"> 
			<div class="footer-logo ml-4">
				<img class="foot-logo-image" src="/img/foot_logo2.png" width=120px>
			</div>	
				<div class="copyright ml-4">
					<small class="text-secondary">
					(07062) 서울시 동작구 여의대방로16길 61<br>
					Copyright@20XX KMA. All Rights RESERVED.
				    </small>
				</div>
		</footer>
		
		
	</div>
</body>
</html>