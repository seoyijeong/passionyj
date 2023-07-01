package kr.ezen.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ezen.bbs.domain.BoardDTO;
import kr.ezen.bbs.mapper.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService{
	//mapper 주입
	@Autowired
	private BoardMapper mapper;

	//BoardMapper를 주입 받아 insert 전달
	@Override
	public void register(BoardDTO dto) {
		//BoadrController에서 넘어온 register 값을 insert로 전달
		mapper.insert(dto);
	}

	@Override
	public List<BoardDTO> getList() {
		return mapper.getList();
	}
	
	
}
