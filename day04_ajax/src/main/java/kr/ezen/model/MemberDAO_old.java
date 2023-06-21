package kr.ezen.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MemberDAO_old {
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	// DB에 연결하기 위한 Connection 객체 생성 메서드
	public void getConnection() {
//		String url = "jdbc:oracle:thin:@localhost:1521:xe";
//		String user = "hr";
//		String pw = "1234";		
		String url = "jdbc:mysql://localhost:3307/testdb";
		String user = "jhkim";
		String pw = "1234";		
		
		try {
//			Class.forName("oracle.jdbc.driver.OracleDriver");
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			conn = DriverManager.getConnection(url, user, pw);
			System.out.println("데이터베이스 연결 성공~~!");
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
	// 회원 정보 저장
	public int memberInsert(MemberDTO dto) {
		String sql = "INSERT INTO member(id, pw, name, age, email, tel, zipcode, road_addr, jibun_addr, detail_addr) "
				   + "VALUES(?,?,?,?,?,?,?,?,?,?)";
//		String sql = "INSERT INTO member VALUES(mem_seq.nextVal,?,?,?,?,?,?)";
		
		getConnection();
		
		int cnt = -1;
		try {
			ps = conn.prepareStatement(sql);
			
//			ps.setInt(1, dto.getNo());
			ps.setString(1,dto.getId());
			ps.setString(2,dto.getPw());
			ps.setString(3,dto.getName());
			ps.setInt(4, dto.getAge());
			ps.setString(5, dto.getEmail());
			ps.setString(6, dto.getTel());
			ps.setString(7, dto.getZipcode());
			ps.setString(8, dto.getRoadAddr());
			ps.setString(9, dto.getJibunAddr());
			ps.setString(10, dto.getDtailAddr());
			// 정상적으로 수행되면 리턴값은 0보다 큼
			cnt = ps.executeUpdate();
			
		} catch (SQLException e) {			
			e.printStackTrace();
		} finally {
			dbClose();
		}
		
		return cnt;
	}
	
	// 회원전체 리스트 
	public ArrayList<MemberDTO> memberList(){
		ArrayList<MemberDTO> list = new ArrayList<MemberDTO>();
		
		String sql = "SELECT * FROM member";
		
		getConnection();
		
		try {			
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				int no = rs.getInt("no");
				String id = rs.getString("id");
				String pw = rs.getString("pw");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String email = rs.getString("email");
				String tel = rs.getString("tel");
				
				// dto로 묶기
				MemberDTO dto = new MemberDTO(no, id, pw, name, age, email, tel);
				list.add(dto);
			}
		} catch (SQLException e) {			
			e.printStackTrace();
		} finally {
			dbClose();
		}
		
		return list;
	}
	
	// 회원정보 조회
	public MemberDTO memberInfo(int no) {
		MemberDTO dto = null;
		String sql = "SELECT * FROM member WHERE no = ?";
		getConnection();
		
		try {			
			ps = conn.prepareStatement(sql);
			ps.setInt(1, no);
			rs = ps.executeQuery();
			
			// 한회원에 대한 정보만 가져오기 때문에
			// while문 필요없음
			if(rs.next()) {
				no = rs.getInt("no");
				String id = rs.getString("id");
				String pw = rs.getString("pw");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String email = rs.getString("email");
				String tel = rs.getString("tel");
				
				// dto로 묶기
				dto = new MemberDTO(no, id, pw, name, age, email, tel);				
			}
		} catch (SQLException e) {			
			e.printStackTrace();
		} finally {
			dbClose();
		}
		
		return dto;
	}
	
	// 회원 수정
	public int memberUpdate(MemberDTO dto) {
		String sql="UPDATE member SET age=?, email=?, tel=? "
				+ "WHERE no = ?";
		getConnection();
		int cnt = -1;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, dto.getAge());
			ps.setString(2, dto.getEmail());
			ps.setString(3, dto.getTel());
			ps.setInt(4, dto.getNo());
			
			cnt = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		
		
		return cnt;
	}
	
	
	// 회원 삭제
	public int deleteMember(int no) {
		String sql = "DELETE FROM member WHERE no = ?";
		getConnection();
		int cnt = -1;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, no);
			cnt = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		
		
		return cnt; 
	}
	
	
	
	// 자원반납
	public void dbClose() {
		try {
			if(rs!=null) rs.close();
			if(ps!=null) ps.close();
			if(conn!=null) conn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	
	
}
