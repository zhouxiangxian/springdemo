package cn.xiaoxian.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.xiaoxian.util.SplitPageUtil;
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
	
	
	@RequestMapping(value="/member/{mid:\\d+}",method=RequestMethod.GET, produces="application/json;charset=UTF-8")
	public @ResponseBody Object get(@PathVariable("mid") int mid) {
		log.info("查询用户信息mid="+mid);
		Member member=new Member();
		member.setMid(mid);
		member.setHiredate(new Date());
		member.setName("小卡");
		member.setSalary(9988.89);
		return member;
	}
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(java.util.Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
	}
	
	
	@RequestMapping(value="/member/{condition}",method=RequestMethod.PATCH, produces="application/json;charset=UTF-8")
	public @ResponseBody  Object list(@PathVariable("condition") String condition,SplitPageUtil spu) {
		log.info("当前查询condition:"+condition+"spu="+spu);
		List<Member> allMembers=new ArrayList<Member>();
		Member member=null;
		for(int x=(spu.getCurrentPage()-1)*spu.getLineSize();x<spu.getCurrentPage()*spu.getLineSize();x++) {
			member=new Member();
			member.setMid(x);
			member.setName("小卡-"+x);
			member.setHiredate(new Date());
			member.setSalary(2000.0);
			allMembers.add(member);
		}
		Map<String,Object> resultMap=new HashMap<String,Object>();
		resultMap.put("memberCount", "10000");
		resultMap.put("allMembers", allMembers);
		resultMap.put("condition", condition);
		return resultMap;
		
	}

}
