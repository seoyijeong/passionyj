<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name='viewport' content='width=device-width, initial-scale=1'>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css' rel='stylesheet'>
<script src='https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js'></script>
</head>
<body>
	<div class="container w-50 mt-5 p-5 shadow">
		<p>id : ${member.id}</p>
		<p>pw : ${member.pw}</p>
		<p>name : ${member.name}</p>
		<p>age : ${member.age}</p>
		<p>email : ${member.email}</p>
		<p>phone : ${member.phone}</p>
		<p>birthday : ${member.birthday}</p>
		<p>hobbies : ${member.hobby}</p>
		
		<p>
			<c:forEach var="h" items = "${member.hobby}">
				${h}<br/>
			</c:forEach>
		
		</p>
		
<%-- 		<p>id : ${param.id}</p>
		<p>pw : ${param.pw}</p>
		<p>name : ${param.name}</p>
		<p>age : ${param.age}</p>
		<p>email : ${param.email}</p>
		<p>phone : ${param.phone}</p>
		<p>hobby : ${param.hobby}</p>
		<p>birthday : ${param.birthday}</p> --%>
		
		<p>hobby : ${param.hobby}</p>		
		<p>hobby : ${paramValues.hobby[0]}</p>
		<p>hobby : ${paramValues.hobby[1]}</p>
		<p>hobby : ${paramValues.hobby[2]}</p>
		
		
	</div>
</body>
</html>