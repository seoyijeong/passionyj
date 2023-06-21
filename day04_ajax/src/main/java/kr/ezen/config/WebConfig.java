package kr.ezen.config;

import java.nio.charset.CharsetEncoder;

import javax.servlet.Filter;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

//web.xml을 대체하여 자바코드로 설정
//에러나면 오른쪽 클릭 하여 메소드 불러오기
public class WebConfig extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	protected Class<?>[] getRootConfigClasses() {
		//root context 대신 java 코드
		//여러개의 클래스를 받기 위해 배열로 리턴
		return new Class[] {RootConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {

		return new Class[] {ServletConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		// url 맵핑 (디스패처 서블릿이 모든 요청을 받음)
		return new String[] {"/"};
	}

	@Override
	protected Filter[] getServletFilters() {
		// 한글 필터(필터도 여러 종류가 있기 때문에 배열로 리턴)
		CharacterEncodingFilter ef = new CharacterEncodingFilter();
		ef.setEncoding("UTF-8");
		ef.setForceEncoding(true);
		return new Filter[] {ef};
	}



}
