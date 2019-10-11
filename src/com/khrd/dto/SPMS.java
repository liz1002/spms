package com.khrd.dto;

public class SPMS {
	private int no;
	private String name;
	private String content;
	private String startdate;
	private String enddate;
	private String Progress;
	
	public SPMS() {}
	
	public SPMS(int no, String name, String content, String startdate, String enddate, String progress) {
		super();
		this.no = no;
		this.name = name;
		this.content = content;
		this.startdate = startdate;
		this.enddate = enddate;
		Progress = progress;
	}
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getStartdate() {
		return startdate;
	}
	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}
	public String getEnddate() {
		return enddate;
	}
	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}
	public String getProgress() {
		return Progress;
	}
	public void setProgress(String progress) {
		Progress = progress;
	}
	
	@Override
	public String toString() {
		return "spms [no=" + no + ", name=" + name + ", content=" + content + ", startdate=" + startdate + ", enddate="
				+ enddate + ", Progress=" + Progress + "]";
	}	
}
