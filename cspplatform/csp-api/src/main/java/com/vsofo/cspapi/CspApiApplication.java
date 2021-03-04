package com.vsofo.cspapi;

import javax.sql.DataSource;

import com.baomidou.dynamic.datasource.annotation.DS;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@MapperScan("com.vsofo.**.mapper")
@ComponentScan("com.vsofo")
@Slf4j
@DS("h2")
public class CspApiApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(CspApiApplication.class, args);
	}

	@Autowired
	public DataSource h2Source;
	@Autowired
	Environment environment;

	@Override
	public void run(String... args) throws Exception {
		System.out.println("H2测试打印");
		JdbcTemplate jdbc = new JdbcTemplate(h2Source);
		System.out.println(h2Source.getConnection().toString());
		String s = jdbc.queryForObject("select 1 ;", String.class);
		log.info("H2测试打印结束");
		log.info("项目已启动，端口：" + environment.getProperty("local.server.port"));
	}

}
