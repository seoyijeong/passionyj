<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html lang='en'>
<head>
<title>Bootstrap Example</title>
<meta charset='utf-8'>
<meta name='viewport' content='width=device-width, initial-scale=1'>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link
	href='https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css'
	rel='stylesheet'>
<script
	src='https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js'></script>
</head>
<body>
	<div class='container mt-3 w-50 rounded shadow p-5 mt-5'>
		<h2>파일 업로드</h2>
		<form action="<c:url value="/upload.do"/>" method="post"
			enctype="multipart/form-data">
			<h3 class="text-center mb-4">파일 업로드</h3>
			<input class="form-control mb-2" type="text" id="id" name="id"
				placeholder="아이디" /> <input class="form-control mb-2" type="text"
				id="name" name="name" placeholder="이름" />

			<div class="row mb-2">
				<div class="col-md-6 col-sm-6">
					<input type="button" class="form-control btn btn-outline-secondary"
						type="text" value="업로드파일 추가" onclick="fileAppend()" />
				</div>
				<div class="col-md-6 col-sm-6">
					<input type="button" class="form-control btn btn-outline-secondary"
						type="text" value="업로드파일 취소" onclick="fileRemove()" />
				</div>
			</div>
			<!-- 파일명 읽어오기 -->
			<!-- 파일을 읽어와 업로드 하기전 이미지가 보이기 -->
			<!-- 파일을 선택하는 순간 함수동작(호출) 하기 :onchange="preViewImg() -->
			<!-- 이미지 띄우기 <img src="">  -->
			<!-- 자신의 태그에서  -->
         <div id="div-file">
        <!--  <input type="file" class="form-control" name="file1" onchange="preViewImg(this)" />
         <img /> -->
         </div>

			<div class="text-center pt-4">
				<button class="btn btn-primary form-contorl">파일 업로드</button>
			</div>
		</form>
		<script>
   //여러개의 파일 업로드 하기
   var cnt =1;
   	function fileAppend(){
   		var fileElement ='<input type="file" class="form-control" name="file'+cnt+'" onchange="preViewImg(this)"/><img /><button type="button" class="btn-close"></button>';
   		
   		$("#div-file").append(fileElement);
   		cnt++;
   	}
   	function fileRemove(){
   		$("#div-file").empty();
   	}
   	/*   <input class="btn btn-primary form-contorl" name="file1" onchange="preViewImg(this)"/>
         <img src=""> */
   	function preViewImg(obj) { //자기 자신을 보이기
        console.log(obj.files);
        
   		//nextSibling : 바로 다음 형제 요소-> <img src="">
   		var imgTag = obj.nextSibling;
        console.log(imgTag);
        
   		if(obj.files && obj.files[0]){ //files : 내장객체
   			var fileReader = new FileReader(); //js 의 라이브러리
   			//fileReader.onload <- 파일을 성공적으로 읽었을 때 발생하는 이벤트
   			fileReader.onload = function(e) {
   				//이벤트 발생의 result 값(바이너리)을 src 에 담음
   				imgTag.width=100;
   				imgTag.hight=100;
   				imgTag.src = e.target.result;
   			}
   			//파일의 종류 2가지
   			//1. 바이너리 파일 :데이터를 있는 그대로 읽고 쓰는 파일(이미지,동영상) : 메모장에서 열면 파일이 깨져서 나옴
   			// 파일을 깨지지 않고 보내려면 text/html , base64 로 변환해야 깨지지 않고 텍스트 파일로 변환됨
   			//2. 텍스트 파일: 데이터를 문자로 변환한 파일(4byte 문자 ->2byte 변경 : 데이터가 날아감)
   			
   			//base64(2^6)는 binary Data를 텍스트로 손실 없이 안전하게 인코딩하는 방식
   			//바이너리 데이터의 훼손 없이 정확하개 데이터를 전달 할 수 있음.
   			
   			//바이너리 파일을 base64형식으로 변환해 줌
   			//일반 텍스트로 변환하기
   			//obj.files[0] :자기 자신의 이미지 하나씩 선택
   			fileReader.readAsDataURL(obj.files[0]);
   		} 
   	} 
   </script>
</body>
</html>
