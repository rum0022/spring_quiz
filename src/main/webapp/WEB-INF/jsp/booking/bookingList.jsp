<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>예약목록보기</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">

<%-- AJAX를 사용하려면 jquery 원본 필요 --%>
<script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>

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
				<li class="nav-item"><a href="/booking/booking-list-view" class="nav-link text-white font-weight-bold">예약하기</a></li>
				<li class="nav-item"><a href="/booking/make-booking-view" class="nav-link text-white font-weight-bold">예약목록</a></li>
			</ul>
		</nav>
		<section class="contents py-4">
			<h2 class="text-center font-weight-bold py-4">예약 목록 보기</h2>
			<table class="table text-center">
				<thead>
					<tr>
						<th>이름</th>
						<th>예약날짜</th>
						<th>숙박일수</th>
						<th>숙박인원</th>
						<th>전화번호</th>
						<th>예약상태</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${bookingList}" var="booking">
			    	<tr>
			    		<td>${booking.name}</td>
			    		<td><fmt:formatDate value="${booking.date}" pattern="yyyy년 M월 d일"/></td>
			    		<td>${booking.day}</td>
			    		<td>${booking.headcount}</td>
			    		<td>${booking.phoneNumber}</td>
			    		<td>
				    		<c:choose>
				    			<c:when test="${booking.state == '대기중'}">
				    			<font color="blue">${booking.state}</font>
				    			</c:when>
				    			<c:when test="${booking.state == '확정'}">
				    			<font color="green">${booking.state}</font>
				    			</c:when>
				    			<c:when test="${booking.state == '취소'}">
				    			<font color="red">${booking.state}</font>
				    			</c:when>
				    		</c:choose>
			    		</td>
			    		<td><button type="button" class="deleteBtn btn btn-danger" data-booking-id="${booking.id}">삭제</button></td>
			    	</tr>
			    </c:forEach>	
			    </tbody>
			</table>
		</section>
		<footer>
		<small class="text-secondary">
		제주특별자치도 제주시 애월읍<br>
		사업자등록번호:111-222-255222 / 농어촌민박사업자지정 / 대표:김통목<br>
		Copyright 2025 tongnamu. All right reserved.
		</small>
		</footer>
	</div>
<script>
	$(document).ready(function() {
		//삭제버튼클릭
		$('.deleteBtn').on('click', function(e) {
			
			let id = $(this).data('booking-id');
			//alert(id);
			
			$.ajax({
				type:"delete"
				, url:"/booking/delete-booking"
				, data:{"id":id}
			
				, success:function(data) {
					if (data.code == 200) {
						location.reload(true);
					} else if (data.code == 500) {
						alert(data.error_message);
					}
				}
				, error:function(request, status, error) {
					alert("삭제하는데 실패했습니다. 관리자에게 문의해주세요.")
				}
			});
		});
	});
</script>	
</body>
</html>