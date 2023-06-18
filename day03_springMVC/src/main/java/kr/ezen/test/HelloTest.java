package kr.ezen.test;

import java.lang.reflect.Method;

public class HelloTest {
	public static void main(String[] args) throws Exception {
//		Hello hello = new Hello();
//		hello.helloPrint();

		//Reflection :클래스 정보를 얻어와서 일반적으로 할 수 없는 것을 가능하게 해주는 기법
		//(Reflection APT를 이용)
		//java.lang.reflect 패키지에서 Reflection APT 제공
		
		// 
		Class helloClazz = Class.forName("kr.ezen.test.Hello");
		Hello hello = (Hello)helloClazz.newInstance();	
		
		//helloPrint()메소드를 얻어오기
		Method helloPrint= helloClazz.getDeclaredMethod("helloPrint");
		
		//기본값은 false(private이 선언되어도 접근가능)
		helloPrint.setAccessible(true);
		
		helloPrint.invoke(hello); //hello.helloPrint()와 같음
		
	}
}
