package kr.ezen.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceView;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

//servlet-context.xml을 java코드로 대체
//어노테이션 기반 작업(추상화)
@Configuration
@EnableWebMvc //mvc 사용
@ComponentScan(basePackages = {"kr.ezen.member2"})
public class ServletConfig implements WebMvcConfigurer{
	@Override  //resource 해당
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		//레지스트리에 등록
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/**");
		
	}
	@Override //view resolve에 해당
	public void configureViewResolvers(ViewResolverRegistry registry) {
		InternalResourceViewResolver bean = new InternalResourceViewResolver();
		bean.setPrefix("/WEB-INF/views/");
		bean.setSuffix(".jsp");
		registry.viewResolver(bean);
	}
}
