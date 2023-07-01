package kr.ezen.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.ezen.bbs.domain.BoardDTO;
import kr.ezen.service.BoardService;

//controller에는 controller를 불러옴
@Controller
@RequestMapping("/board")
public class BoardController {
	//BoardService 주입
	@Autowired
	private BoardService service;
	
	//list.do를 받기위한 어노테이션
	//redirect 는 get요청
	@GetMapping("/list.do")
	public String list(Model model) {
		List<BoardDTO> list= service.getList();
		model.addAttribute("list",list);
		return "board/boardList";
	}
	
	//웹 브라우저에 get방식으로 호출 
	@GetMapping("/register.do")
	public String register() {
		return "board/register"; //return 후에 @PostMapping("/board/register.do") 로 다시 요청
	}
	//글쓰기 버튼을 누르면 post 방식으로 내용이 전달되어 저장
	@PostMapping("/register.do")
	public String register(BoardDTO dto) {
		//저장된 register를 서비스로 전달
		service.register(dto);
		
		return "redirect:/board/list.do";
	}
	
	
}
