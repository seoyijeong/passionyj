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

// root-context.xml 대체
@Configuration
//매퍼를 하나씩 등록하는게 아닌 페키지 경로를 지정하여 이하 위치에있는 인터페이스들은 전부 맵퍼로 사용할수있다.
@MapperScan(basePackages="kr.ezen.bbs.mapper") 
@PropertySource({"classpath:/db.properties"})
@ComponentScan(basePackages = {"kr.ezen.service"})
public class RootConfig {
	
	@Autowired
	private Environment env;
	
	@Autowired
	ApplicationContext ac;
	
	@Bean
	public DataSource hkSource() {
		HikariConfig hcf = new HikariConfig();
//		hcf.setDriverClassName("com.mysql.cj.jdbc.Driver");
//		hcf.setJdbcUrl("jdbc:mysql://localhost:3307/testdb");
//		hcf.setUsername("jhkim");
//		hcf.setPassword("1234");
		
		hcf.setDriverClassName(env.getProperty("jdbc-driver"));
		hcf.setJdbcUrl(env.getProperty("jdbc-url"));
		hcf.setUsername(env.getProperty("jdbc-username"));
		hcf.setPassword(env.getProperty("jdbc-password"));
		
		HikariDataSource hkds = new HikariDataSource(hcf);
		
		return hkds;
	}
	
	@Bean
	public SqlSessionFactory sessionFactory() throws Exception {
		SqlSessionFactoryBean sfb = new SqlSessionFactoryBean();
		sfb.setDataSource(hkSource());
		sfb.setConfigLocation(ac.getResource("classpath:/config.xml"));
		// sfb.setMapperLocations(ac.getResources("classpath:/mybatis/*.xml"));
		return (SqlSessionFactory)sfb.getObject();
	}
	
}
