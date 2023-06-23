package kr.ezen.test2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ReqParam {
	@RequestMapping("/requestForm")
	public String main() {
		return "scoreForm";
	}
	
	@RequestMapping("/requestParam")
//	public String main(String kor) { 아래와 동일
	public String main(@RequestParam(name="kor", required=false) String kor) {
		System.out.println("국어 : " + kor);
		return "score";
	}
	@RequestMapping("/requestParam2")
	public String main2(@RequestParam(name="kor", required=true) String kor) {
		System.out.println("국어 : " + kor);
		return "score";
	}
	
	@RequestMapping("/requestParam3")
	public String main3(@RequestParam(required=false, defaultValue="80") String kor) {
		System.out.println("국어 : " + kor);
		return "score";
	}
	
	////////////////
	@RequestMapping("/requestParam4")
	// http://localhost:8090/test2/requestParam4?kor ====> 400에러 kor="" 빈공백으로 요청
	// http://localhost:8090/test2/requestParam4 ==> kor=null 500 에러
	public String main4(int kor) { //required=false
		System.out.println("국어 : " + kor);
		return "score";
	}
	
	@RequestMapping("/requestParam5")
	// http://localhost:8090/test2/requestParam5?kor ====> 400에러
	// http://localhost:8090/test2/requestParam5 ====> 400에러
	public String main5(@RequestParam int kor) { //required=true
		System.out.println("국어 : " + kor);
		return "score";
	}
	
	@RequestMapping("/requestParam6")
	public String main6(@RequestParam(required=false, defaultValue="100") int kor) { 
		System.out.println("국어 : " + kor);
		return "score";
	}
	
	@RequestMapping("/requestParam7")
//	http://localhost:8090/test2/requestParam7?kor=77
	// kor로 넘어오는 값을 eng로 대체
	public String main7(@RequestParam(name="kor", defaultValue="100") int eng) { 
		System.out.println("국어 : " + eng);
		return "score";
	}
	
	// @RequestParam 생략 가능 : 기본형 매개변수, String 매개변수 앞에서 
	
	
	
	
	
}
