package kr.ezen.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//클래스를 컨트롤러로 등록
@Controller
//reflection 기법으로 자동 호출
//클라이언트에서 요청을 하면 Hello객체를 자동으로 생성함
//singleton 패턴(컨테이너 안에서 한번만 만들어짐)
public class Hello {
	int a = 100; //instance 변수
	static int sa = 300;
	
	//reflection 객체는 public 과private 둘다 불러올수 있음
//	@RequestMapping("/hello")
//	public void helloPrint(){
//		System.out.println("Hello Spring");
//		System.out.println("a");
//		System.out.println("sa");
		
		//기본적으로 private은 외부에서 호출 불가,
		//스프링에서는 호출가능(reflection을 사용하기 때문에)
//		@RequestMapping("/hello")
//		private void helloPrint(){
//			System.out.println("Hello Spring");
//			System.out.println(a);
//			System.out.println(sa);	
//	}
		//스태틱 메서드는 스태틱 변수만 사용가능하기 때문에 
		//인스턴스 메서드로 사용하는 것이 편함.
		@RequestMapping("/hello")
		private static void helloPrint(){
			System.out.println("Hello Spring");
//			System.out.println(a);
			System.out.println(sa);	
		}
}
