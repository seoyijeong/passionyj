<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>     
<!DOCTYPE html>
<html>
<head>                                                        
  <title>Bootstrap Example</title>                            
  <meta charset='utf-8'>                                      
  <meta name='viewport' content='width=device-width, initial-scale=1'>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>                                  
  <link href='https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css' rel='stylesheet'>
  <script src='https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js'></script>  
</head>  
<body>
<div class="container w-50 mt-5 p-5 shadow">
   <form action="memberInsert.do" method="post">
      <h4>회원가입</h4>            
      <div class="row">
      	<div class="col-md-8 pe-0">
      		<input class="form-control mb-2" type="text" id="id" name="id" placeholder="아이디">
      	</div>
     	<div class="col-md-4">
     		<a class="btn btn-outline-info w-100" onclick="idCheck()">중복체크</a>
     	</div>
      </div>
      
      <input class="form-control mb-2" type="text" name="pw" placeholder="비밀번호">
      <input class="form-control mb-2" type="text" name="name" placeholder="이름">
      <input class="form-control mb-2" type="text" name="age" placeholder="나이">
      <input class="form-control mb-2" type="text" name="email" placeholder="이메일">
      <input class="form-control mb-2" type="text" name="tel" placeholder="전화번호">
      <!-- 주소 -->
      <div class="row mb-2">
         <div class="col-md-6">
            <input class="form-control mb-2" type="text" id="sample4_postcode" name="zipcode" placeholder="우편번호" readonly>
         </div>
         <div class="col-md-6 p-0 ps-2">
            <a class="btn btn-sm btn-outline-secondary p-2" onclick="sample4_execDaumPostcode()">우편번호 찾기</a><br>
         </div>
      </div>
      
      <input class="form-control mb-2" type="text" name="roadAddr" id="sample4_roadAddress" placeholder="도로명주소" readonly>
      <input class="form-control mb-2" type="text" name="jibunAddr" id="sample4_jibunAddress" placeholder="지번주소" readonly>
      <!-- <span id="guide" style="color:#999;display:none"></span> -->
      <input class="form-control mb-2" type="text" id="sample4_detailAddress" name="detailAddr" placeholder="상세주소">
      <div class="text-center mt-3">
         <input type="submit" class="btn btn-primary" value="가입">
         <input type="reset" class="btn btn-info" value="취소">
      </div>
   </form>
</div>

<!-- The Modal -->
<div class="modal fade" id="chkModal">
  <div class="modal-dialog">
    <div class="modal-content">

      <!-- Modal Header -->
      <div class="modal-header">
        <h4 class="modal-title">중복체크 확인</h4>
        <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
      </div>

      <!-- Modal body -->
      <div class="modal-body text-center" id="chkMsg">
        
      </div>

      <!-- Modal footer -->
      <div class="modal-footer">
        <button type="button" class="btn btn-danger" data-bs-dismiss="modal">닫기</button>
      </div>

    </div>
  </div>
</div>
<script>
	function idCheck(){
		var uid = $("#id").val();
		
		$.ajax({
			url:"<c:url value='memberIdCheck.do'/>",
			type: "get",
			data:{"uid":uid}, // 서버에 전송할 데이터
			success: function(responseData){
				// responseData = "yes" or "no", yes:사용가능 no:사용불가
				
				if(responseData == "yes"){
					$("#chkMsg").html("사용가능한 아이디 입니다!!");		
				}else{
					$("#chkMsg").html("사용할 수 없는 아이디 입니다!!");
				}
				$("#chkModal").modal("show");
			},
			error : function(){
				$("#chkMsg").html("서버 에러 입니다!!!");
				$("#chkModal").modal("show");
			} 
		});
		
		
		
	}
</script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="js/zipcode.js"></script>
</body>
</html>