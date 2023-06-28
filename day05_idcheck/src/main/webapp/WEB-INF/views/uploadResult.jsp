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
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css">
<script
	src='https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js'></script>
</head>
<body>
	<div class='container mt-3 w-50 rounded shadow p-5 mt-5'>
		<h2>파일 업로드</h2>
		<form action="" method="post">
			<h3 class="text-center mb-4">파일 업로드 확인</h3>
			<input class="form-control mb-2" type="text" id="id" value="${map.id}" disabled>
			<input class="form-control mb-2" type="text" id="name" value="${map.name}" disabled>
			<div class="">
				<table class="table table-borderless">
				<c:forEach var="fName" items="${map.fileList}">
					<tr>
						<td class="col-md-8">
						<!-- 업로드된 파일을 이미지로 직접 올리기 -->
							<img src="fileRepo/${fName}" width="100px"/>${fName}
						</td>
						<!-- 업로드 호출 :스크립트-->
						<td class="col-md-4"><a href="javascript:downloadFile('${fName}')"
							class="btn btn-sm btn-outline-success">다운로드 <i class="far fa-save"></i></a></td>
					</tr>
				</c:forEach>
					<tr>
						<td colspan="2"><a href="<c:url value="form.do"/>"
							class="btn btn-primary">다시 업로드하기</a></td>
					</tr>
				</table>
			</div>
		</form>
	</div>
	<script>
	//1. href="javascript:downloadFile('${fName}') == downloadFile(fileName) 
	//2. 다운로드 호출 하면 자바 스트립트가 실행 되고 
	//3. FileController :download(@RequestParam("fileName")) 매개변수를 넘겨줌 
		function downloadFile(fileName){
			location.href="<c:url value='download.do'/>?fileName="+fileName;
		}
	</script>

</body>
</html>
