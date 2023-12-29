<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>즐겨찾기 추가하기</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">

<%-- AJAX 사용하려면 jquery 원본 필요 --%>
<script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>
</head>
<body>
	<div class="container">
		<h1>즐겨찾기 추가하기</h1>
			<div class="form-group">
				<label for="name" class="font-weight-bold  d-flex align-items-center mt-3">제목</label>
				<input type="text" id="name" name="name" class="form-control">
			<div class="form-group">
				<label for="url" class="font-weight-bold  d-flex align-items-center mt-3">주소</label>
				<input type="text" id="url" name="url" class="form-control">
			</div>
			<button type="button" id="joinBtn" class="btn btn-success form-control">추가</button>
	</div>
	
<script>
 	$(document).ready(function() {
 		$("#joinBtn").on('click', function() {
 			//alert("클릭");
 			// validation 처리
 			let name = $("#name").val();
 			if (!name) {
 				alert("사이트명을 입력하시오.")
 				return;
 			}
 			
 			let url = $("#url").val();
 			if (!url) {
 				alert("주소를 입력하시오.")
 			}
 			
 	
 			console.log(name);
 			console.log(url);
 			
 			//AJAX
 			$.ajax({
 				type:"POST"
 				, url:"/lesson06/quiz01/add-bookmark"
 				, data:{"name":name, "url":url}
 			
 				, success:function(data) {
 					alert(data);
 					if (data == "성공") {
 						location.href = "/lesson06/quiz01/after-add-bookmark-view";
 					}
 				}
 				
 				, error: function(request, status, error) { // 실패했을때
					alert(request);
					alert(status);
					alert(error);
				}
 			});
 		});
 	});
</script>	
</body>
</html>