package kr.ezen.member2;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.ezen.model.MemberDAO;
import kr.ezen.model.MemberDTO;
import kr.ezen.myBatis.MemberMapper;
//Dispatcher Servlet(tomcat) :frontController 역할 ->controller(spring container)
//컴파일러에게 @Controller 컨트롤러라고 알려준다.
@Controller
public class MemberController {
	
	@Autowired //MemberDAO 자동연결
//	private MemberDAO dao;
	
	//@ComponentScan(basePackages = {"kr.ezen.model"})
	//설정해 놓지 않으면 객체가 생성되지 않기 때문에 interface로 만들어 두었던 MemberMapper로 사용
	//mapper로 주입 /자동처리
	private MemberMapper mapper;
	
	
	//@RequestMapping 이 memberList 를 불러온다.
	//Model : 바인딩 역할
	@RequestMapping("/memberList.do")
	public String memberList(Model model) {

//		List<MemberDTO> memberList = dao.memberList();
		List<MemberDTO> memberList = mapper.memberList();
		//포워딩(redirect 붙지 않은건 포워딩을 시켜준다.)
		model.addAttribute("list", memberList);
		
		return "memberList";
	}
	@RequestMapping("/memberRegister.do")
	//memberRegister() 홈페이지 연결만 하면 되므로 매개변수는 적지 않는다.
	public String memberRegister() {
		
		return "memberRegister";
	}
	
	@RequestMapping("/memberInsert.do")
	public String memberInsert(MemberDTO dto) {
		//dto를 넘겨야 register에서 입력한 값을 dto로 넘겨서 보조 컨트롤러(DS: dispatcher servler)에 넘긴다.
		//servlet : dto를 넘겨주면 dao가 받는다.
//		dao.memberInsert(dto);
		mapper.memberInsert(dto);
		return "redirect:memberList.do";
	}
	
	@RequestMapping("/memberInfo.do")
	//회원 번호를 넘기기(ds가 no=1를 받아서 넘김)
	public String memberInfo(int no, Model model) {
		//dto를 받아서 넘김
//		MemberDTO dto = dao.memberInfo(no);
		MemberDTO dto = mapper.memberInfo(no);
		model.addAttribute("dto", dto);
		return "memberInfo";
	}
	
	@RequestMapping("/memberUpdate.do")
	//수정할 것들이 전체가 아니더라도 dto로 다같이 묶어서 보냄
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
	
}
