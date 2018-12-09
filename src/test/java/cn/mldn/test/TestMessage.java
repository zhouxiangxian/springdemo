package cn.mldn.test;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.mldn.service.IMessageService;
import cn.mldn.vo.Emp;
import junit.framework.TestCase;

public class TestMessage {
	private static ApplicationContext ctx = null;
	static { // 静态代码块优先于所有的代码执行，目的是为了静态属性初始化
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
	}

	@Test
	public void getGetInfo() {
		IMessageService bean = ctx.getBean("msg", IMessageService.class);
		Logger.getLogger(TestMessage.class).info(bean.getInfo());
		TestCase.assertEquals(bean.getInfo(), "www.xiaoxian.com");
	}

	@Test
	public void testDeptConstructor() {
		Emp emp = ctx.getBean("emp", Emp.class);
		Logger.getLogger(TestMessage.class).info(emp);
	}
}
