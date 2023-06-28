package kr.ezen.myBatis;
//DAO를 간편하게 mapping
//1. MemgerMapper.xml 에서 설정
//2. myBatis :mysql에서 DAO 역할을 대신 한다.
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.ezen.model.MemberDTO;

@Mapper
public interface MemberMapper {
	//추상 메서드
	List<MemberDTO> memberList();
	
	int memberInsert(MemberDTO dto);
	
	int deleteMember(int no);
	
	MemberDTO memberInfo(int no);
	
	int memberUpdate(MemberDTO dto);
	
	MemberDTO idCheck(String uid);
}
