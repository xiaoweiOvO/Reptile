package com.igeek.service;

import java.util.List;

import com.alibaba.fastjson.JSON;
import com.igeek.dao.musicDao;
import com.igeek.domain.Music;

public class musicService {
	
	private musicDao m = new musicDao();
	//插入
	public void save(Music music){
		m.save(music);
	}
	//修改
	public void update(Music music){
		m.update(music);
	}
	public Music findId1(int rid,int ranking) {
		Music music = m.findId(rid, ranking);
		return music;
	}
	
	//查询的返回结果全变为JSON格式
	//查询rid ranking
	public String findId(int rid,int ranking) {
		Music music = m.findId(rid, ranking);
		return JSON.toJSONString(music);
	}
	//查询rid列表
	public String findRid(String listname){
		List<Music> mList = m.queryByRid(listname);
		return JSON.toJSONString(mList);
	}
	//查询list名称
	public String findList(){
		List<String> list = m.queryList();
		return JSON.toJSONString(list);
	}
	

}
