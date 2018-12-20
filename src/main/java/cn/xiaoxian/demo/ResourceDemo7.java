package cn.xiaoxian.demo;

import java.io.IOException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.xiaoxian.util.ResourceUtils;

public class ResourceDemo7 {
	public static void main(String[] args) throws IOException {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		ResourceUtils resourceUtil =  ctx.getBean("resourceUtils",ResourceUtils.class);
        resourceUtil.print();
	}

}
