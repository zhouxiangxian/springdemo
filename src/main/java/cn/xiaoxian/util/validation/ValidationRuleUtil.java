package cn.xiaoxian.util.validation;

import javax.servlet.http.HttpServletRequest;

public class ValidationRuleUtil {
	
	
	public static boolean isMime(String mimeRules[],String mime) {
		if(isString(mime)) {
			for(int x=0;x<mimeRules.length;x++) {
				if(mime.equals(mimeRules[x])) {
					return true;
				}
			}
		}
		return false;
	}
	
	public static boolean isString(String str) {
		if(str==null||"".equals(str)) {
			return false;
		}
		return true;
	}
	
	
	public static boolean isInt(String str) {
		if(isString(str)) {
			return str.matches("\\d+");
		}
		return false;
	}
	
	
	public static boolean isDouble(String str) {
		if(isString(str)) {
			return str.matches("\\d+(\\.\\d+)?");
		}
		return false;
	}
	
	
	public static boolean isDate(String str) {
		if(isString(str)) {
			return str.matches("\\d{4}-\\d{2}-\\d{2}");
		}
		return false;
	}
	
	
	public static boolean isDateTime(String str) {
		if(isString(str)) {
			return str.matches("\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}");
		}
		return false;
	}
	
	
	public static boolean isRand(HttpServletRequest request,String str) {
		if(isString(str)) {
			String rand=(String) request.getSession().getAttribute("rand");
			if(isString(rand)) {
				return rand.equals(str);
			}
		}
		return false;
	}

}
