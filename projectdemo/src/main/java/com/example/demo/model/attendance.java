package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class attendance {

	private int eid;	
	private String date;
	private String ename;	
	private String status;
	
	@Id
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "attendance [eid=" + eid + ", date=" + date + ", ename=" + ename + ", status=" + status + "]";
	}
	public attendance(int eid, String date,  String ename,String status) {
	
		this.eid = eid;
		this.date = date;
		this.ename = ename;
		this.status = status;
	}
	public attendance() {
	}

}
