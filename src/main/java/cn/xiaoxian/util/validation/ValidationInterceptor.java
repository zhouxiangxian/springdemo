package cn.xiaoxian.util.validation;

import java.lang.reflect.Method;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import cn.xiaoxian.util.resource.ResourceReadUtil;

public class ValidationInterceptor implements HandlerInterceptor {
	private Logger log=Logger.getLogger(ValidationInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		boolean flag=true;
		HandlerMethod handlerMethod=(HandlerMethod)handler;
		Map<String, String> errors = ValidationUtils.validate(request, handlerMethod);
		if(errors.size()>0) {
			flag=false;
			request.setAttribute("errors", errors);
			request.getRequestDispatcher(ResourceReadUtil.getErrorPageValue(handlerMethod)).forward(request, response);
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
