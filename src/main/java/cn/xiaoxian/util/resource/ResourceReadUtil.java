package cn.xiaoxian.util.resource;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.springframework.web.method.HandlerMethod;

public class ResourceReadUtil {
	public static String getErrorPageValue(HandlerMethod handlerMethod) {
		// 取得验证规则
		String pageKey = handlerMethod.getBean().getClass().getSimpleName() + "."
				+ handlerMethod.getMethod().getName() + ".error.pages";
		String pageUrl=getValue(handlerMethod, pageKey);
		if(pageUrl==null||"".equals(pageUrl)) {
			pageUrl=getValue(handlerMethod, "error.page");
		}
		return pageUrl;
	}
	
	
	public static String getValue(HandlerMethod handlerMethod, String msgKey) {
		try {
		    Method getValueMethod = handlerMethod.getBean().getClass().getMethod("getValue", String.class, Object[].class);
			return (String) getValueMethod.invoke(handlerMethod.getBean(), msgKey, null);
		}catch (Exception e) {
			return "";
		}

	}

}
