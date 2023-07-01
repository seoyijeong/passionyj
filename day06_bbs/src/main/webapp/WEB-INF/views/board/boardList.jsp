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
<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css' rel='stylesheet'>       
<script src='https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js'></script>         
</head>
<body>
<div class="container">
<h3>스프링 게시판</h3>
<table class="table">
   <thead>
      <tr>
         <th>번호</th>
         <th>제목</th>
         <th>조회수</th>
         <th>글쓴이</th>
         <th>등록일</th>
      </tr>
   </thead>
   <tbody>
      <c:forEach var="dto" items="${list}">
      <tr>
         <td>${dto.bid}</td>
         <td><a href=""/>${dto.subject}</a></td>
         <td>${dto.hit}</td>
         <td>${dto.writer}</td>
         <td>${dto.reg_date}</td>
      </tr>
      </c:forEach>
      <tr>
         <td colspan="5" class="text-center">
            <button class="btn btn-primary" id="btn-write">글쓰기</button>
         </td>
      </tr>
   </tbody>
</table>