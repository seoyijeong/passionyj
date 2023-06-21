<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>                                                        
  <title>Bootstrap Example</title>                            
  <meta charset='utf-8'>                                      
  <meta name='viewport' content='width=device-width, initial-scale=1'>                                  
  <link href='https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css' rel='stylesheet'>
  <script src='https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js'></script>  
</head>  
<body>
<div class='container w-50 shadow mt-5 p-5 rounded-3 border'>
<form action='memberInsert.do'>
	<table class="table table-borderless">
		<thead>
			<h3 colspan="2"  class="text-center">회원가입</h3>
		</thead>
		<tbody>
<!-- 			<tr>
				<td>회원번호</td>
				<td><input class="form-control" type="text" name="no"/></td>
			</tr> -->
			<tr>
				<td>아이디</td>
				<td><input class="form-control" type="text" name="id"/></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input class="form-control" type="text" name="pw"/></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input class="form-control" type="text" name="name"/></td>
			</tr>
			<tr>
				<td>나이</td>
				<td><input class="form-control" type="text" name="age"/></td>
			</tr>
			<tr>
				<td>이메일</td>
				<td><input class="form-control" type="text" name="email"/></td>
			</tr>
			<tr>
				<td>전화번호</td>
				<td><input class="form-control" type="text" name="tel"/></td>
			</tr>
			<tr>
				<td colspan="2" class="text-center pt-4">
					<input type="submit" class="btn btn-primary" value="가입"/>
					<input type="reset" value="취소" class="btn btn-warning"/>
					<a href="memberList.do" class="btn btn-info">리스트</a>
				</td>
			</tr>
		</tbody>
	</table>
</form>	
</div>
</body>
</html>