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
				<button type="button"></button>
			</div>
			<button type="button" id="addBtn" class="btn btn-success form-control">추가</button>
	</div>
	
<script>
 	$(document).ready(function() {
 		//추가버튼 클릭
 		$('#addBtn').on('click', function() {
 			//alert("클릭");
 			// validation 체크
 			let name = $("#name").val().trim(); //앞뒤여백 트림함수로 제거
 			if (!name) {
 				alert("사이트명을 입력하시오.")
 				return;
 			}
 			
 			let url = $("#url").val().trim();
 			if (!url) {
 				alert("주소를 입력하시오.")
 				return;
 			}
 			
 			//http 또는 https 프로토콜까지 모두 입력 (둘다 아닐 때로 조건을 둬야함!)
 			if(url.startsWith("http:") == false
 					&& !url.startsWith("https:")) {
 				alert("주소 형식이 잘못 되었습니다.")
 				return;
 			}
 			
 			console.log(name);
 			console.log(url);
 			
 			//AJAX 통신
 			$.ajax({ //키,벨류를 보내야하므로 딕셔너리{} 넣어준것
 				//request
 				type:"POST"
 				, url:"/lesson06/add-bookmark"
 				, data:{"name":name, "url":url}
 				//response - call back 함수
 				, success:function(data) { // data : Json String => parsing(jquery ajax함수가 파싱해줌) => dictionary
 					//alert(data.code)
 					if (data.code == 200) { // or data.result == "성공"
 						//목록화면으로 이동
 						location.href = "/lesson06/after-add-bookmark-view"; //get방식으로 이동
 					}
 				}
 				
 				, error: function(request, status, error) { // 실패했을때
					alert("추가하는데 실패했습니다. 관리자에게 문의해주세요.");
				}
 			});
 		});
 	});
</script>	
</body>
</html>