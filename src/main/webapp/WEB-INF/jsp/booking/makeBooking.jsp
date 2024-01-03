<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">

<%-- AJAX 사용하려면 jquery 원본 필요 --%>
<script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>

<link rel="stylesheet" href="/css/booking/style.css" type="text/css">
</head>
<body>
	<div id="wrap" class="container">
		<header class="d-flex align-items-center justify-content-center">
			<h1>통나무펜션</h1>
		</header>
		<nav> 
			<ul class="nav nav-fill">
				<li class="nav-item"><a href="#" class="nav-link text-white font-weight-bold">펜션소개</a></li>
				<li class="nav-item"><a href="#" class="nav-link text-white font-weight-bold">객실보기</a></li>
				<li class="nav-item"><a href="#" class="nav-link text-white font-weight-bold">예약하기</a></li>
				<li class="nav-item"><a href="#" class="nav-link text-white font-weight-bold">예약목록</a></li>
			</ul>
		</nav>
		<section class="container" >
			<div class="content d-flex align-items-center justify-content-center">
				<h3>예약 목록 보기</h3>
			</div>
				<div class="form-group">
					<label for="name">이름</label>
					<input type="text" id="name" name="name" class="form-control col-6">
				</div>
				<div class="form-group">
					<label for="name">예약날짜</label>
					<input type="text" id="name" name="name" class="form-control col-6">
				</div>
				<div class="form-group">
					<label for="name">숙박일수</label>
					<input type="text" id="name" name="name" class="form-control col-6">
				</div>
				<div class="form-group">
					<label for="name">숙박인원</label>
					<input type="text" id="name" name="name" class="form-control col-6">
				</div>
				<div class="form-group">
					<label for="name">전화번호</label>
					<input type="text" id="name" name="name" class="form-control col-6">
				</div>
				
				<button type="button" class="btn btn-warning col-6">예약하기</button>
		</section>
		<footer>
		<small>제주특별자치도 제주시 애월읍</small><br>
		<small>사업자등록번호:111-222-255222 / 농어촌민박사업자지정 / 대표:김통목</small><br>
		<small>Copyright 2025 tongnamu. All right reserved.</small>
		</footer>
	</div>
</body>
</html>