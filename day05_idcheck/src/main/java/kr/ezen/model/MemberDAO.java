package kr.ezen.model;
//mapper 설정 이후에 필요 없음


import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO {

	// DI(Dependency Injection : 의존성 주입)
	@Autowired // 스프링 컨테이너에 있는 sqlSessionFactory를 주입해줌 
	private SqlSessionFactory sqlSessionFactory;
	
	// 회원 전체 리스트 가져오기
	public List<MemberDTO> memberList(){
		SqlSession sqlSession= sqlSessionFactory.openSession();
										 // 매개변수 : 메소드명을 관례적으로 사용			
		List<MemberDTO> list = sqlSession.selectList("memberList");
		sqlSession.close();
		return list;
	}
	
	// 회원저장
	public int memberInsert(MemberDTO dto) {
		// openSession()의 매개변수 기본값 false, 여기서 false는 생략됨
		// openSession(true)는 AutoCommit이 true라는 의미
		SqlSession sqlSession= sqlSessionFactory.openSession();
		int cnt = sqlSession.insert("memberInsert", dto);
		sqlSession.commit(); // openSession(true)면 commit() 생략가능
		sqlSession.close();
		return cnt;
	}
	
	public int deleteMember(int no) {
		SqlSession sqlSession= sqlSessionFactory.openSession();
		int cnt = sqlSession.delete("deleteMember", no);
		sqlSession.commit();
		sqlSession.close();
		return cnt;
	}
	
	public MemberDTO memberInfo(int no) {
		SqlSession sqlSession= sqlSessionFactory.openSession();
		MemberDTO dto = sqlSession.selectOne("memberInfo", no);
		sqlSession.close();
		return dto;
	}
	
	public int memberUpdate(MemberDTO dto) {
		SqlSession sqlSession= sqlSessionFactory.openSession();
		int cnt = sqlSession.update("memberUpdate", dto);
		sqlSession.commit();
		sqlSession.close();
		return cnt;
	}
	
	
}
