package cn.xiaoxian.util;

import java.text.SimpleDateFormat;


public class MyTask2 {
	protected void execSelf()  {
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new java.util.Date()));
	}

}
