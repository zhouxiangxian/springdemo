package cn.xiaoxian.forget;

import java.text.SimpleDateFormat;
import java.util.Timer;
import java.util.TimerTask;

class MyTimer extends TimerTask{

	@Override
	public void run() {
    System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS").format(new java.util.Date()));		
	}
	
}


public class MyTimerDemo {
	public static void main(String[] args) {
		Timer timer=new Timer();
		timer.schedule(new MyTimer(), 0,1000);
	}

}
