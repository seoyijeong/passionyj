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
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css" integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/" crossorigin="anonymous">
<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css' rel='stylesheet'>
<script src='https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js'></script>
</head>
<body>
	   <form action="<c:url value="/member/save"/>" method="post">
<input class="form-control mb-2" type="text" id="id" name="id" placeholder="아이디" autofocus>      
         <input class="form-control mb-2" type="text" name="pw" placeholder="비밀번호">
         <input class="form-control mb-2" type="text" name="name" placeholder="이름">
         <input class="form-control mb-2" type="text" name="age" placeholder="나이">
         <input class="form-control mb-2" type="text" name="email" placeholder="이메일">
         <input class="form-control mb-2" type="text" name="phone" placeholder="전화번호">
         <input class="form-control mb-2" type="text" name="birthday" placeholder="생일">
         <label><input type="checkbox" name="hobby" value="music"/>음악감상</label>
         <label><input type="checkbox" name="hobby" value="sports"/>운동</label>
         <label><input type="checkbox" name="hobby" value="movie"/>영화</label>
         
         <div>
            <input type="submit" class="btn btn-primary" value="가입"/>
         </div>
   </form>
</body>
</html>