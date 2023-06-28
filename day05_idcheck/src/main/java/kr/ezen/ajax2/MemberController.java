package kr.ezen.ajax2;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.ezen.model.MemberDAO;
import kr.ezen.model.MemberDTO;
import kr.ezen.myBatis.MemberMapper;

@Controller
public class MemberController {
	
	@Autowired
	//필요한 의존 객체의 “타입"에 해당하는 빈을 찾아 주입한다.
	//RootConfig 에 빈을 
//	private MemberDAO dao;
	private MemberMapper mapper;
	
	@RequestMapping("/memberList.do")
	public String memberList(Model model) {		
//		List<MemberDTO> memberList = dao.memberList();
		List<MemberDTO> memberList = mapper.memberList();
		model.addAttribute("list", memberList);
		
		return "memberList";
	}
	
	@RequestMapping("/memberRegister.do")
	public String memberRegister() {
		
		return "memberRegister";
	}
	
	@RequestMapping("/memberInsert.do")
	public String memberInsert(MemberDTO dto) {
//		dao.memberInsert(dto);
		mapper.memberInsert(dto);
		
		return "redirect:memberList.do";
	}
	
	@RequestMapping("/memberInfo.do")
	public String memberInfo(int no, Model model) {
//		MemberDTO dto = dao.memberInfo(no);
		MemberDTO dto = mapper.memberInfo(no);
		
		model.addAttribute("dto", dto);
		return "memberInfo";
	}
	
	@RequestMapping("/memberUpdate.do")
	public String memberUpdate(MemberDTO dto) {
//		dao.memberUpdate(dto);
		mapper.memberUpdate(dto);
		
		return "redirect:memberList.do";
	}
	
	@RequestMapping("/memberDelete.do")
	public String memberDelete(int no) {
//		dao.deleteMember(no);
		mapper.deleteMember(no);
		
		return "redirect:memberList.do";
	}
	
	// Message Converter API : jackson
	// ==> JSON 형식 자바객체로 변환, 또는 그 반대 변환
	
	// 비동기 전송데이터는 HTTP MSG의 body 담아서 전송한다.
	
	// @ResponseBody : 서버에서 클라이언트에 응답할 때, 자바객체를 HTTP 응답 MSG body에 변환해서
	// 클라이언트에 전송
	
	// @RequestBody : 클라이언트에서 서버로 데이터를 보낼때, HTTP 요청 MSG의 body에 담긴 값을
	// 자바객체로 변환해서 전송
	
	// 최근에는 주로 JSON형식, 예전에는 XML형식
	
	@RequestMapping("/memberAjaxList.do")
	public @ResponseBody List<MemberDTO> memberAjaxList() {		
		List<MemberDTO> memberList = mapper.memberList();		
		return memberList;
	}
	
	@RequestMapping("/memberIdCheck.do")
	@ResponseBody
	public String memberIdCheck(@RequestParam("uid") String uid) {		
		MemberDTO dto = mapper.idCheck(uid);
		if(dto !=null || "".equals(uid.trim())) {
			return "no";
		}
		
		return "yes";
	}
	
	
}
