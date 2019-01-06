package cn.xiaoxian.util;

import java.text.SimpleDateFormat;


public class XiaoXianTask {
	public void runJob()  {
		System.out.println("【当前日期】"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new java.util.Date()));
	}

}
