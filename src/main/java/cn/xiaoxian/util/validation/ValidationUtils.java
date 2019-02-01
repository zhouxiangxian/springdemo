package cn.xiaoxian.util.validation;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import cn.xiaoxian.util.resource.ResourceReadUtil;

public class ValidationUtils {
	private static Logger log = Logger.getLogger(ValidationUtils.class);

	public static Map<String, String> validate(HttpServletRequest request, HandlerMethod handlerMethod) {
		Map<String, String> errors = new HashMap<String, String>();
		// 取得验证规则
		String validationKey = handlerMethod.getBean().getClass().getSimpleName() + "."
				+ handlerMethod.getMethod().getName() + ".rules";
		log.info("【*****preHandler****】validationKey=" + validationKey);

		try {
			Method getValueMethod = handlerMethod.getBean().getClass().getMethod("getValue", String.class,
					Object[].class);
			String validationValue = (String) getValueMethod.invoke(handlerMethod.getBean(), validationKey, null);
			log.info("【*****preHandler****】validationValue=" + validationValue);
			String result[] = validationValue.split("\\|");
			for (int x = 0; x < result.length; x++) {
				String temp[] = result[x].split(":");
				String paramName = temp[0];
				String paramRule = temp[1];// 参数规则
				//参数内容
				String paramValue=request.getParameter(paramName);
				// log.info("参数名称：" + paramName + ",参数内容:" + request.getParameter(paramName));
				switch (paramRule) {
				case "string":
					if(!ValidationRuleUtil.isString(paramValue)) {
						String msg = (String) getValueMethod.invoke(handlerMethod.getBean(), "validation.string.msg", null);
						errors.put(paramName, msg);//保存错误信息
					}
					break;
				case "int":
					if(!ValidationRuleUtil.isInt(paramValue)) {
						String msg = (String) getValueMethod.invoke(handlerMethod.getBean(), "validation.int.msg", null);
						errors.put(paramName, msg);//保存错误信息
					}
					break;
				case "double":
					if(!ValidationRuleUtil.isDouble(paramValue)) {
						String msg = (String) getValueMethod.invoke(handlerMethod.getBean(), "validation.double.msg", null);
						errors.put(paramName, msg);//保存错误信息
					}
					break;
				case "date":
					if(!ValidationRuleUtil.isDate(paramValue)) {
						String msg = (String) getValueMethod.invoke(handlerMethod.getBean(), "validation.date.msg", null);
						errors.put(paramName, msg);//保存错误信息
					}
					break;
				case "datetime":
					if(!ValidationRuleUtil.isDateTime(paramValue)) {
						String msg = (String) getValueMethod.invoke(handlerMethod.getBean(), "validation.datetime.msg", null);
						errors.put(paramName, msg);//保存错误信息
					}
					break;
				case "rand":
					if(!ValidationRuleUtil.isRand(request,paramValue)) {
						String msg = (String) getValueMethod.invoke(handlerMethod.getBean(), "validation.rand.msg", null);
						errors.put(paramName, msg);//保存错误信息
					}
					break;
				default:
					break;
				}
			}
		} catch (NoSuchMethodException e1) {
			e1.printStackTrace();
		} catch (SecurityException e1) {
			e1.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(errors.size()==0) {
			//文件上传的验证处理
			CommonsMultipartResolver resolver = new CommonsMultipartResolver();
			if(resolver.isMultipart(request)) {
				String mimeKey=handlerMethod.getBean().getClass().getSimpleName() + "."+ handlerMethod.getMethod().getName() + ".mime.rule";
				String mimeValue = ResourceReadUtil.getValue(handlerMethod, mimeKey);
				if(mimeValue==null) {
					mimeValue=ResourceReadUtil.getValue(handlerMethod, "mime.rule");
				}
				String[] mimeRules = mimeValue.split("\\|");
				MultipartRequest mreq=(MultipartRequest)request;
				//取得全部的上传文件
				Map<String, MultipartFile> fileMap = mreq.getFileMap();
				if(fileMap.size()>0) {
					Iterator<Entry<String, MultipartFile>> iterator = fileMap.entrySet().iterator();
					while(iterator.hasNext()) {
						Entry<String, MultipartFile> me = iterator.next();
						if(me.getValue().getSize()>0) {
							if(!ValidationRuleUtil.isMime(mimeRules, me.getValue().getContentType())) {
								errors.put("file", ResourceReadUtil.getValue(handlerMethod, "validation.mime.msg"));
							}
						}
					}
				}
			}
		}
	
		
		
		return errors;
	}

}
