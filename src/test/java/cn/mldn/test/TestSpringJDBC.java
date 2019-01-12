package cn.mldn.test;

import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class TestSpringJDBC {
	public static void main(String[] args) {
		 ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		 JdbcTemplate bean = ctx.getBean("jdbcTemplate",JdbcTemplate.class);
		 String sql="INSERT INTO news(title,pubdate,note)VALUES(?,?,?)";
		 int update = bean.update(sql, "深大体育场",new Date(),"每天运动一个小时。");
		 Logger.getLogger(TestSpringJDBC.class).info("更新:"+update);
	}

	
}
