package cn.xiaoxian.action;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cn.xiaoxian.util.action.AbstractAction;
import cn.xiaoxian.vo.Emp;

@Controller
@RequestMapping("/pages/emp/*")
public class EmpAction extends AbstractAction{
	private Logger log=Logger.getLogger(EmpAction.class);
	@RequestMapping("remove")
	public ModelAndView remove(@RequestParam(value="empno",defaultValue="18")int eid) {
		System.out.println(eid*2);
		return null;
	}
	
	
	@RequestMapping("echo")
	public ModelAndView echo(String msg) {
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("allEmps", new ArrayList<String>());
		map.put("empCount", 11);
		ModelAndView mav=new ModelAndView("emp/show");
		mav.addObject("info","【echo】="+msg);
		mav.addAllObjects(map);
		Logger.getLogger(EmpAction.class).info("【echo】="+msg);
		return mav;
	}
	
	
	@RequestMapping("list")
	public ModelAndView list(@RequestParam(value="cp",defaultValue="1")int currentPage,
			@RequestParam(value="ls",defaultValue="15")int lineSize,
			@RequestParam(value="kw",defaultValue="")String keyWord,
			@RequestParam(value="cl",defaultValue="ename")String column) {
		log.info("*********currentPage="+currentPage);
		log.info("*********lineSize="+lineSize);
		log.info("*********keyWord="+keyWord);
		log.info("*********column="+column);
		return null;
	}
	
	
	@RequestMapping("get")
	public ModelAndView get(int eid,HttpServletRequest request,HttpServletResponse response) {
		log.info("****contextPath="+request.getContextPath());
		HttpSession session=request.getSession();
		log.info("****sessionID="+session.getId());
		ServletContext application=request.getServletContext();
		log.info("****realPath="+application.getRealPath("/"));
		try {
			response.getWriter().write("Hello World!!!!!");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@RequestMapping("add")
	public ModelAndView add(Emp emp) {
		log.info("emp="+emp);
		return null;
	}
	

}
