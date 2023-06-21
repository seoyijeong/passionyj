package kr.ezen.myBatis;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.ezen.model.MemberDTO;

@Mapper
public interface MemberMapper {
	List<MemberDTO> memberList();
	
	int memberInsert(MemberDTO dto);
	
	int deleteMember(int no);
	
	MemberDTO memberInfo(int no);
	
	int memberUpdate(MemberDTO dto);
	
}
