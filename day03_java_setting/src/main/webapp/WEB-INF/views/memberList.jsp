<%@ page import="kr.ezen.model.MemberDTO"%>
<%@ page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	
	ArrayList<MemberDTO> memberList= (ArrayList<MemberDTO>)request.getAttribute("list");
%>    
<!DOCTYPE html>
<html lang='en'>                                                                                            
<head>                                                                                                      
  <title>Bootstrap Example</title>                                                                          
  <meta charset='utf-8'>                                                                                    
  <meta name='viewport' content='width=device-width, initial-scale=1'>                                      
  <link href='https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css' rel='stylesheet'>    
  <script src='https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js'></script>      
</head>                                                                                                     
<body>                                                                                                      
<div class='container mt-3'>                                                                                
  <h2>회원 리스트</h2>                                                                                      
  <table class='table'>                                                                                     
    <thead class='table-dark'>                                                                              
      <tr>                                                                                                  
        <th>번호</th>                                                                                       
        <th>아이디</th>                                                                                     
        <th>비밀번호</th>                                                                                   
        <th>이름</th>                                                                                       
        <th>나이</th>                                                                                       
        <th>이메일</th>                                                                                     
        <th>전화번호</th>                                                                                   
        <th>삭제</th>                                                                                       
      </tr>                                                                                                 
    </thead>                                                                                                
    <tbody>                                                                                                 

<% for(MemberDTO dto : memberList) { %>
	<tr>                                                                                                 
	  <td><%=dto.getNo() %></td>                                                                           
	  <td><a href='memberInfo.do?no=<%=dto.getNo()%>'><%=dto.getId()%></a></td>                          
	  <td><%=dto.getPw()%></td>                                                                           
	  <td><%=dto.getName()%></td>                                                                         
	  <td><%=dto.getAge()%></td>                                                                          
	  <td><%=dto.getEmail()%></td>                                                                        
	  <td><%=dto.getTel()%></td>                                                                          
	  <td><input type="button" class='btn btn-danger btn-sm' value="삭제" onclick="delMember(<%=dto.getNo() %>)"/></td>                                                                 
	</tr>                                                                                                
<%}%>
      <tr>                                                                                                    
      	<td colspan='8' class='text-center'><a href='memberRegister.do' class='btn btn-primary'>회원가입</a></td>
      </tr>                                                                                               
    </tbody>                                                                                              
  </table>                                                                                                
</div>   
<script>
	function delMember(no){
		location.href="memberDelete.do?no="+no;
	}
</script>

                                                                                                 
</body>                                                                                                   
</html>																									  