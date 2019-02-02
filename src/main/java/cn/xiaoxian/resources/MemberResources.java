package cn.xiaoxian.resources;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import cn.xiaoxian.vo.Member;
@Path("/member")
@Component
@Scope("prototype")//描述本类不属于单例设计模式
public class MemberResources {
	@Path("/get")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Member  get() {
		Member member=new Member();
		member.setMid(1000);
		member.setHiredate(new Date());
		member.setName("小卡");
		member.setSalary(2300.0);
		return member;
	}
	@Path("/list")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Member> list(){
		List<Member> allMember=new ArrayList<Member>();
		Member member=null;
		for(int x=0;x<10;x++) {
			member=new Member();
			member.setMid(10+x);
			member.setHiredate(new Date());
			member.setName("小卡-"+x);
			member.setSalary(2300.0);
			allMember.add(member);
		}
		return allMember;
	}

}
