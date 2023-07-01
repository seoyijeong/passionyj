package kr.ezen.config;
//java xml 설정은 config로 함

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

//servlet-context.xml 대체
@Configuration
@EnableWebMvc
@ComponentScan(basePackages= {"kr.ezen.bbs","kr.ezen.controller"})
public class ServletConfig implements WebMvcConfigurer{
	//파일 업로드 크기 상수선언
	private final int MAX_SIZE = 10*1024*1024;
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {		
		registry.addResourceHandler("/**").addResourceLocations("/resources/");
	}
	
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		InternalResourceViewResolver bean = new InternalResourceViewResolver();
		bean.setPrefix("/WEB-INF/views/");
		bean.setSuffix(".jsp");
		registry.viewResolver(bean);
	}
	@Bean
	//파일 업로드
	//멀티파트 리졸버 리턴
	//스프링 xml을 자바 코드로 
	//org.springframework.web.multipart.commons.CommonsMultipartResolver
	public MultipartResolver multipartResolver() {
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
		multipartResolver.setMaxUploadSize(MAX_SIZE);
		multipartResolver.setMaxUploadSizePerFile(MAX_SIZE);
		multipartResolver.setMaxInMemorySize(0);
		
		return multipartResolver;
	}
}
