<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>예약하기</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">

<%-- AJAX 사용하려면 jquery 원본 필요 --%>
<script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>

<%-- datepicker--%>
<link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<link rel="stylesheet" href="/css/booking/style.css" type="text/css">
</head>
<body>
	<div id="wrap" class="container">
		<header class="d-flex align-items-center justify-content-center">
			<div class="display-4">통나무 팬션</div>
		</header>
		<nav> 
			<ul class="nav nav-fill">
				<li class="nav-item"><a href="#" class="nav-link text-white font-weight-bold">펜션소개</a></li>
				<li class="nav-item"><a href="#" class="nav-link text-white font-weight-bold">객실보기</a></li>
				<li class="nav-item"><a href="/booking/make-booking-view" class="nav-link text-white font-weight-bold">예약하기</a></li>
				<li class="nav-item"><a href="/booking/booking-list-view" class="nav-link text-white font-weight-bold">예약목록</a></li>
			</ul>
		</nav>
		<section class="contents py-4" >
			<h2 class="text-center font-weight-bold py-4">예약 하기</h2>
			<div class="d-flex justify-content-center">
				<div class="booking-box">
					<div class="subject-text my-2 font-weight-bold">이름</div>
					<input type="text" id="name" class="form-control">
					
					<div class="subject-text my-2 font-weight-bold">예약날짜</div>
					<input type="text" id="date" class="form-control">
					
					<div class="subject-text my-2 font-weight-bold">숙박일수</div>
					<input type="text" id="day" class="form-control">
					
					<div class="subject-text my-2 font-weight-bold">숙박인원</div>
					<input type="number" id="headcount" class="form-control">
					
					<div class="subject-text my-2 font-weight-bold">전화번호</div>
					<input type="text" id="phoneNumber" class="form-control">
					
					<button type="button" id="makeBookingBtn" class="btn btn-warning w-100 mt-3">예약하기</button>
				</div>
			</div>	
				
		</section>
		<footer>
		<small>제주특별자치도 제주시 애월읍</small><br>
		<small>사업자등록번호:111-222-255222 / 농어촌민박사업자지정 / 대표:김통목</small><br>
		<small>Copyright 2025 tongnamu. All right reserved.</small>
		</footer>
	</div>
	
<script>
	$(document).ready(function() {
		//날짜선택
		$('#date').datepicker({
			//오늘 날짜 이후부터 조회
			minDate:0
			, dateFormat: "yy-mm-dd"
		});
		
		$('#makeBookingBtn').on('click', function() {
			//alert("클릭");
			let name = $('#name').val().trim();
			if (!name) {
				alert("이름을 입력하세요.");
				return;
			}
			
			let date = $('#date').val() //직접입력안하기때문에 trim제거해도됨
			if (!date) {
				alert("날짜를 선택해주세요.");
				return;
			}
			
			let day = $('#day').val().trim();
			if (!day) {
				alert("숙박일을 입력하세요.");
				return;
			}
			
			if (isNaN(day)) { //숫자가 아닐 때 참 or 위의 스크립트에서 타입을 number로 하면됨
				alert("숙박일은 숫자만 가능합니다.");
				return;
			}
			
			let headcount = $('#headcount').val().trim();
			if (!headcount) {
				alert("숙박인원을 입력하세요.");
				return;
			}
			
			let phoneNumber = $('#phoneNumber').val().trim();
			if (!phoneNumber) {
				alert("전화번호를 입력하세요.");
				return;
			}
			
			$.ajax({
				type:"POST"
				, url:"/booking/add-booking"
				, data:{"name":name, "date":date, "day":day, "headcount":headcount, "phoneNumber":phoneNumber}
			
				, success:function(data) {
					if (data.code == 200) {
						alert("예약되었습니다.");
						location.href = "/booking/booking-list-view";
					} //else도 해주긴해야함
				}
				, error:function(request, status, error) {
					alert("예약하는데 실패했습니다. 관리자에게 문의해주세요.");
				}
			});
		});
	});
</script>	
</body>
</html>