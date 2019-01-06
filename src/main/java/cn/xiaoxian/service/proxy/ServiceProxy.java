package cn.xiaoxian.service.proxy;

import java.util.Arrays;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;

public class ServiceProxy {
	
	public void beforeInvoke(Object args) {
		Logger.getLogger(ServiceProxy.class).info("【业务方法执行之前调用】参数："+args);
	}
	
	public void afterInvoke() {
		Logger.getLogger(ServiceProxy.class).info("【业务方法执行之后调用】");
	}
	
	
	public void returnInvoke(Object val) {
		Logger.getLogger(ServiceProxy.class).info("【返回通知】返回值="+val);
	}
	
	
	public void throwInvoke(Exception e) {
		Logger.getLogger(ServiceProxy.class).error("【抛出异常】:"+e);
	}
	
	
	public Object arroundInvoke(ProceedingJoinPoint point) throws Throwable{
		Logger.getLogger(ServiceProxy.class).info("【before】执行参数："+Arrays.toString(point.getArgs()));
		Object proceed = point.proceed(new Object[] {"www.xiaoxian.com"});
		Logger.getLogger(ServiceProxy.class).info("【after】返回结果:"+proceed);
		return true;
	}

}
