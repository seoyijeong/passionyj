package kr.ezen.config;

import javax.sql.DataSource;


import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

//root-context.xml 을 java코드로 대체
//basePackages : java코드 주입
//어노테이션 환경 설정(변경되지 않는 객체)
@Configuration
@MapperScan(basePackages = "kr.ezen.myBatis")
//@MapperScan myBatis가 mapper를 만들어줌
@PropertySource({"classpath:/db.properties"})
//@ComponentScan(basePackages = {"kr.ezen.model"})
public class RootConfig {
	@Autowired
	//스프링 컨테이너
	ApplicationContext ac;
	
	@Autowired
	//properties의 속성값을 읽음
	private Environment env;
	
	
	//스프링 컨테이너에서 관리하는 객체
	//bean 두개를 만들어서 리턴을 함
	@Bean
	public DataSource hkSource() {
//		HikariConfig hcf = new HikariConfig();
//		hcf.setDriverClassName("com.mysql.cj.jdbc.Driver");
//		hcf.setJdbcUrl("jdbc:mysql://localhost:3306/testdb");
//		hcf.setUsername("yj");
//		hcf.setPassword("1234");
		HikariConfig hcf = new HikariConfig();
		hcf.setDriverClassName(env.getProperty("jdbc-driver"));
		hcf.setJdbcUrl(env.getProperty("jdbc-url"));
		hcf.setUsername(env.getProperty("jdbc-username"));
		hcf.setPassword(env.getProperty("jdbc-password"));
		
		HikariDataSource hkds = new HikariDataSource(hcf);
		
		return hkds;
	}
	@Bean
	public SqlSessionFactory sessionFactory() throws Exception{
		SqlSessionFactoryBean sfb = new SqlSessionFactoryBean();
		sfb.setDataSource(hkSource());
		sfb.setConfigLocation(ac.getResource("classpath:/config.xml"));
		sfb.setMapperLocations(ac.getResources("classpath:mybatis/*.xml"));
		return (SqlSessionFactory)sfb.getObject();
	}
}
