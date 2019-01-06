package cn.mldn.test;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.mldn.service.IMessageService;
import cn.xiaoxian.service.IDeptService;
import cn.xiaoxian.vo.Dept;
import cn.xiaoxian.vo.Emp;
import junit.framework.TestCase;

public class TestMessage {
	public static void main(String[] args) {
		
		 ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
	     cn.xiaoxian.service.IMessageService bean = ctx.getBean("messageServiceImpl",cn.xiaoxian.service.IMessageService.class);
	     bean.remove("zhou xiang xian ");
	}

	
}
