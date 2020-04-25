package com.igeek.domain;

public class RankList {

	private String name;
	private String href;
	public RankList() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RankList(String name, String href) {
		super();
		this.name = name;
		this.href = href;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getHref() {
		return href;
	}
	public void setHref(String href) {
		this.href = href;
	}
	@Override
	public String toString() {
		return "RankList [name=" + name + ", href=" + href + "]";
	}
	
	
	
	
	
	
}
