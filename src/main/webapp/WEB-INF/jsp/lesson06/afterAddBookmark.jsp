<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">

<%-- AJAX 사용하려면 jquery 원본 필요 --%>
<script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>
</head>
<body>
	<div class="container">
		<h1>즐겨 찾기 목록</h1>
		<table class="table text-center">
			<thead>
				<tr>
					<th>No.</th>
					<th>이름</th>
					<th>주소</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${bookmarkList}" var="bookmark">
				<tr>
					<td>${bookmark.id}</td>
					<td>${bookmark.name}</td>
					<td><a href="${bookmark.url}" target="_blank">${bookmark.url}</a></td>
					<td>
					<%-- 1) value로 값넣기(한개밖에안됨) --%>
					<!-- <button type="button" class="del-btn btn btn-danger" value="${bookmark.id}">삭제</button> -->
					
					<%-- 1) data로 값넣기(여러개가능) 대문자 절대안됨! --%>
					<button type="button" class="del-btn btn btn-danger" data-bookmark-id="${bookmark.id}">삭제</button>
					</td>
				</tr>
			</c:forEach>	
			</tbody>
		</table>
	
	</div>
<script>
	$(document).ready(function () {
		// 삭제버튼 클릭
		$('.del-btn').on('click', function(e) {
			// 1) button value에 담은 값 가져오기
				 // 1. let id = $(this).val();
				 // 2. let id = $(this).attr("value");
				 // 3. let id = e.target.value;
		 
		   // 2) data를 이용하여 값 가져오기
		   // 태그영역 : data-bookmark-id
		   // 스크립트 영역 : .data('bookmark-id')
		   let id = $(this).data('bookmark-id');
		 	//alert(id);
			
		 // ajax
		 $.ajax({ // delete는 포스트방식으로
			type:"DELETE"
			, url:"/lesson06/delete-bookmark"
			, data:{"id":id}
		 
		 	, success:function(data) {
		 		if (data.code == 200) {
		 			// 성공
		 			location.reload(true); //새로고침 그자리에서 그행만 사라진다.
		 		} else if (data.code == 500) {
		 			// 실패
		 			alert(data.error_message);
		 		}
		 	}
		 	, error:function(request, status, error) {
		 		alert("삭제하는데 실패했습니다. 관리자에게 문의해주세요.");
		 	}
		 });
	  });
	});
</script>	
</body>
</html>