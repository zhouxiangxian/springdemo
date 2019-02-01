package cn.xiaoxian.action;

import java.text.SimpleDateFormat;

import org.apache.log4j.Logger;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.util.JSONPObject;

import cn.xiaoxian.vo.Member;
import net.sf.json.JSONObject;

@Controller
public class MemberAction {
	private Logger log=Logger.getLogger(MemberAction.class);
	@RequestMapping(value="/info",produces="text/plain;charset=UTF-8")
	public @ResponseBody String info() {
		return "www.xiaoxian.com";
	}
	
	@RequestMapping(value="/echo/{msgParam}",produces="text/plain;charset=UTF-8")
	public @ResponseBody String echo(@PathVariable("msgParam") String xiaoxian) {
		return "Echo:"+xiaoxian;
	}
	
	
	@RequestMapping(value="/member",method=RequestMethod.PUT, produces="application/json;charset=UTF-8")
	public @ResponseBody Object edit(Member vo) {
		log.info("修改用户信息:"+vo);
		JSONObject obj=new JSONObject();
		obj.put("flag", true);
		return obj;
	}
	
	@RequestMapping(value="/member",method=RequestMethod.POST, produces="application/json;charset=UTF-8")
	public @ResponseBody Object add(Member vo) {
		log.info("增加用户信息:"+vo);
		JSONObject obj=new JSONObject();
		obj.put("flag", true);
		return obj;
	}
	
	@RequestMapping(value="/member/{mid:\\d+}",method=RequestMethod.DELETE, produces="application/json;charset=UTF-8")
	public @ResponseBody Object delete(@PathVariable("mid") int mid) {
		log.info("删除用户信息mid="+mid);
		JSONObject obj=new JSONObject();
		obj.put("flag", true);
		return obj;
	}
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(java.util.Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
	}

}
