package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class emp {

	 private int eid;
	 private String ename;
	 private String dep;
	 private String tech;
	 private int sal;
	 

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getDep() {
		return dep;
	}
	public void setDep(String dep) {
		this.dep = dep;
	}
	public String getTech() {
		return tech;
	}
	public void setTech(String tech) {
		this.tech = tech;
	}
	public int getSal() {
		return sal;
	}
	public void setSal(int sal) {
		this.sal = sal;
	}
	@Override
	public String toString() {
		return "emp [id=" + eid + ", ename=" + ename + ", dep=" + dep + ", tech=" + tech + ", sal=" + sal + "]";
	}
	public emp(int eid, String ename, String dep, String tech, int sal) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.dep = dep;
		this.tech = tech;
		this.sal = sal;
	}
	public emp() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	 
	 
	 
}
