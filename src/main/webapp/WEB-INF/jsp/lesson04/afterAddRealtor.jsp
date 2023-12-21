<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>
<meta charset="UTF-8">
<title>${title}</title>
</head>
<body>
	<div class="container">
		<h1>${title}</h1>
		<table class="table table-striped">
			<tr>
				<td>번호</td>
				<td>${realtor.id}</td>
			</tr>
			<tr>
				<td>상호명</td>
				<td>${realtor.office}</td>
			</tr>
			<tr>
				<td>전화번호</td>
				<td>${realtor.phoneNumber}</td>
			</tr>
			<tr>
				<td>주소</td>
				<td>${realtor.address}</td>
			</tr>
			<tr>
				<td>등급</td>
				<td>${realtor.grade}</td>
			</tr>
			<tr>
				<td>생성일</td>
				<td>${realtor.createdAt}</td>
			</tr>
			<tr>
				<td>수정일</td>
				<td>${realtor.updatedAt}</td>
			</tr>
		</table>
	</div>
</body>
</html>