package cn.xiaoxian.util.validation;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class ValidationInterceptor implements HandlerInterceptor {
	private Logger log=Logger.getLogger(ValidationInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		boolean flag=true;
		HandlerMethod handlerMethod=(HandlerMethod)handler;
		//取得验证规则
		String validationKey=handlerMethod.getBean().getClass().getSimpleName()+"."+handlerMethod.getMethod().getName()+".rules";
		log.info("【*****preHandler****】validationKey="+validationKey);
		Method getValueMethod = handlerMethod.getBean().getClass().getMethod("getValue",String.class,Object[].class);
		try {
			String validationValue =(String) getValueMethod.invoke(handlerMethod.getBean(),validationKey,null);
			log.info("【*****preHandler****】validationValue="+validationValue);
		}catch(Exception e) {
			e.printStackTrace();
			flag=false;
		}
		return flag;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		log.info("【*****postHandle****】"+handler.getClass()+",modelAndView="+modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		log.info("【*****afterCompletion****】"+handler.getClass());
	}

}
