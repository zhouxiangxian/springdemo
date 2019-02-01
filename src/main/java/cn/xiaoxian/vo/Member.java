package cn.xiaoxian.vo;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
@SuppressWarnings("serial")
public class Member implements Serializable {
	private Integer mid;
	private String name;
	private Date hiredate;
	private Double salary;
	public Member() {
		
	}
	public Integer getMid() {
		return mid;
	}
	public void setMid(Integer mid) {
		this.mid = mid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getHiredate() {
		return hiredate;
	}
	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Member [mid=" + mid + ", name=" + name + ", hiredate=" + hiredate + ", salary=" + salary + "]";
	}
	

}
