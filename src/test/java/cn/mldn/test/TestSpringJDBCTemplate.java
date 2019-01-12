package cn.mldn.test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import cn.xiaoxian.vo.News;

public class TestSpringJDBCTemplate {
	public static void main(String[] args) {
		 ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		 JdbcTemplate bean = ctx.getBean("jdbcTemplate",JdbcTemplate.class);
		 int currentPage=1;
		 int lineSize=5;
		 String sql="SELECT nid,title,pubdate,note FROM news WHERE title LIKE ? lIMIT ?,?";
		 List<News> queryResult = bean.query(sql, new Object[] {"%%",(currentPage-1)*lineSize,lineSize}, new RowMapper<News>() {

			@Override
			public News mapRow(ResultSet rs, int rowNum) throws SQLException {
				News vo=new News();
				vo.setNid(rs.getInt(1));
				vo.setTitle(rs.getString(2));
				vo.setPubdate(rs.getDate(3));
				vo.setNote(rs.getString(4));
				return vo;
			}
			 
		 });
		 Iterator<News> iterator = queryResult.iterator();
		 while(iterator.hasNext()) {
			 News next = iterator.next();
			 Logger.getLogger(TestSpringJDBCTemplate.class).info(next);
		 }
	}

	
}
