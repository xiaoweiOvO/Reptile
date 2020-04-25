package com.igeek.domain;

public class Music {
	
	
	private int rid;//1.排行榜id			---
	private int ranking;//2.排名			---
	private String sname;//3.歌名		000
	private String album;//4.专辑		000
	private String singer;//5.歌手		000
	private String duration;//6.时长		000
	private String list;//7.排行榜名称	---
	private String href;//8.歌曲页面		---
	private String pic;//9.专辑图片		000
	public Music() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Music(int rid, int ranking, String sname, String album, String singer, String duration, String list,
			String href, String pic) {
		super();
		this.rid = rid;
		this.ranking = ranking;
		this.sname = sname;
		this.album = album;
		this.singer = singer;
		this.duration = duration;
		this.list = list;
		this.href = href;
		this.pic = pic;
	}
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public int getRanking() {
		return ranking;
	}
	public void setRanking(int ranking) {
		this.ranking = ranking;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getAlbum() {
		return album;
	}
	public void setAlbum(String album) {
		this.album = album;
	}
	public String getSinger() {
		return singer;
	}
	public void setSinger(String singer) {
		this.singer = singer;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public String getList() {
		return list;
	}
	public void setList(String list) {
		this.list = list;
	}
	public String getHref() {
		return href;
	}
	public void setHref(String href) {
		this.href = href;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	@Override
	public String toString() {
		return "Music [rid=" + rid + ", ranking=" + ranking + ", sname=" + sname + ", album=" + album + ", singer="
				+ singer + ", duration=" + duration + ", list=" + list + ", href=" + href + ", pic=" + pic + "]";
	}
	
	
	
	

}
