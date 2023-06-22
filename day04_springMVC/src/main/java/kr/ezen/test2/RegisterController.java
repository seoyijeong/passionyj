package kr.ezen.test2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RegisterController {
	@RequestMapping("/member/form")
	public String register() {
		return "registerForm";
	}
	@RequestMapping("/member/save")
	public String memberInfo(MemberDTO dto, Model model) {
		return "registerInfo";
	}

}
