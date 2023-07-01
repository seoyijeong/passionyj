package kr.ezen.bbs.mapper;

import java.util.List;

//myBatis ->Mapper

import org.apache.ibatis.annotations.Mapper;
//mapper를 불러오고 service와 연결 해야함

import kr.ezen.bbs.domain.BoardDTO;

//BoardServiceImpl 와 mapping
@Mapper
public interface BoardMapper {
	//게시글 등록
	//BoardService 에서 넘어온 insert 값을 BoardMapper로 넘김
	public void insert(BoardDTO dto);
	
	//service 계층(비즈니스 로직) 
	//persistence (영속성) interface DAO 구현 하기 위해
	//kr.ezen.service 에 serviceLayer를 추가해줌
	//BoardService
	//BoardServiceImpl 
	
	//게시판 리스트
	public List<BoardDTO> getList();
		
	
	
}
