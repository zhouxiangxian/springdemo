package cn.xiaoxian.demo;

import java.io.IOException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.xiaoxian.util.ResourceUtils;

public class TestTask {
	public static void main(String[] args) throws IOException {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
	}

}
