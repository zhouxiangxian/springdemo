package cn.xiaoxian.service.proxy;

import java.util.Arrays;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
@Component
@Aspect
public class ServiceProxy {
	@Before(value="execution(* cn.xiaoxian.service..*.*(..)) and args(id)",argNames="id")
	public void beforeInvoke(Object args) {
		Logger.getLogger(ServiceProxy.class).info("【业务方法执行之前调用】参数："+args);
	}
	@After("execution(* cn.xiaoxian.service..*.*(..))")
	public void afterInvoke() {
		Logger.getLogger(ServiceProxy.class).info("【业务方法执行之后调用】");
	}
	
	@AfterReturning(value="execution(* cn.xiaoxian.service..*.*(..))",argNames="n",returning="n")
	public void returnInvoke(Object val) {
		Logger.getLogger(ServiceProxy.class).info("【返回通知】返回值="+val);
	}
	
	@AfterThrowing(value="execution(* cn.xiaoxian.service..*.*(..))",argNames="e",throwing="e")
	public void throwInvoke(Exception e) {
		Logger.getLogger(ServiceProxy.class).error("【抛出异常】:"+e);
	}
	
	@Around("execution(* cn.xiaoxian.service..*.*(..))")
	public Object arroundInvoke(ProceedingJoinPoint point) throws Throwable{
		Logger.getLogger(ServiceProxy.class).info("【before】执行参数："+Arrays.toString(point.getArgs()));
		//Object proceed = point.proceed(new Object[] {"www.xiaoxian.com"});
		Object proceed = point.proceed(point.getArgs());
		Logger.getLogger(ServiceProxy.class).info("【after】返回结果:"+proceed);
		return true;
	}

}
