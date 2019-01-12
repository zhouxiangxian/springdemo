package cn.xiaoxian.vo;

import java.io.Serializable;
import java.util.Date;

public class Emp implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer empno;
	private String ename;
	private Double sal;
	private Date hiredate;
	private Dept dept;
	public Dept getDept() {
		return dept;
	}
	public void setDept(Dept dept) {
		this.dept = dept;
	}
	public Date getHiredate() {
		return hiredate;
	}
	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}
	public Emp() {
		
	}
	public Integer getEmpno() {
		return empno;
	}
	public void setEmpno(Integer empno) {
		this.empno = empno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public Double getSal() {
		return sal;
	}
	public void setSal(Double sal) {
		this.sal = sal;
	}
	@Override
	public String toString() {
		return "Emp [empno=" + empno + ", ename=" + ename + ", sal=" + sal + ", hiredate=" + hiredate + ", dept=" + dept
				+ "]";
	}
	
	
}
