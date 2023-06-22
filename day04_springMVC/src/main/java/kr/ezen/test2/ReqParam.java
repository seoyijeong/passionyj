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

	@RequestMapping("requestParam")
//	public String main(String kor) { //@RequestParam 생략됨
	//name="kor", required=false false로 정해놓으면 name= 값을 적지 않아도 받아올수 잇다.
	//required :필수사항
	//웹 브라우저(클라이언트)가 값을 입력 했을때 : http://localhost:8086/test2/requestParam2?kor=90
		public String main(@RequestParam(name="kor", required=false) String kor) {
		System.out.println("국어 : " + kor);
		return "score";
	}
	@RequestMapping("requestParam2")
	public String main2(@RequestParam(name="kor", required=true) String kor) {
	System.out.println("국어 : " + kor);
	return "score";
	}
	@RequestMapping("requestParam3")
	//defaultValue="80" 브라우저에서 값을 입력하지 않으면 기본값으로 콘솔창에 국어:80으로 지정
	public String main3(@RequestParam(required=false, defaultValue="80") String kor) {
	System.out.println("국어 : " + kor);
	return "score";
	}
	@RequestMapping("requestParam4")
	//http://localhost:8086/test2/requestParam4?kor ->400에러 ""빈공백으로 요청/int를 넣어주어야함(클라이언트에러)
	//http://localhost:8086/test2/requestParam4 ->500에러(서버에러) kor=null
	public String main4(int kor) { //required=false
	System.out.println("국어 : " + kor);
	return "score";
	}
	@RequestMapping("requestParam5")
	public String main5(@RequestParam int kor) {//required=true(값 입력 필수!)
	System.out.println("국어 : " + kor);
	return "score";
	}
	@RequestMapping("requestParam6")
	public String main6(@RequestParam(required=false, defaultValue="100") int kor) {//required=true(값 입력 필수!)
	System.out.println("국어 : " + kor);
	return "score";
	}
	@RequestMapping("requestParam7")
	//kor로 넘어오는 값을 eng로 대체
	public String main7(@RequestParam(name="kor", defaultValue="100") int eng) {//required=true(값 입력 필수!)
	System.out.println("국어 : " + eng);
	return "score";
	}
}

//@requestParam 생략가능: 기본형 매개변수, String 매개변수 앞에서








