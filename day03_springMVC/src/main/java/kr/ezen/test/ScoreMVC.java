package kr.ezen.test;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
//public class ScoreMVC {
//	@RequestMapping("/scoreMVC")
//	public String aaa(int kor, int eng, int math, Model model) {
//		
//		int total = kor+eng+math;
//		double avg = total /3.0;	
//		String strAvg = String.format("%.2f", avg);
//		model.addAttribute("total", total);
//		model.addAttribute("avg", strAvg);
//		
//		return "scoreMVC";
//	}
//}

//ModelAndView = Model+View
public class ScoreMVC {
	@RequestMapping("/scoreMVC")
	public ModelAndView aaa(int kor, int eng, int math) {
		
		ModelAndView mv = new ModelAndView();
		
		int total = kor+eng+math;
		double avg = total /3.0;	
		String strAvg = String.format("%.2f", avg);
		
		mv.addObject("total", total);
		mv.addObject("avg", strAvg);
		
		mv.setViewName("scoreMVC");
		return mv;
	}
}
