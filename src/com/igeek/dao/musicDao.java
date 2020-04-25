package com.igeek.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;

import com.igeek.domain.Music;
import com.igeek.utils.C3p0Utils;

public class musicDao {
	//向表中插入music对象
	public void save(Music music) {
		QueryRunner queryRunner = new QueryRunner(C3p0Utils.getDataSource());
		String sql = "INSERT INTO list(rid,ranking,sname,album,singer,duration,list,href,pic) VALUES(?,?,?,?,?,?,?,?,?)";
		Object[] params = {music.getRid(),music.getRanking(),music.getSname(),music.getAlbum(),music.getSinger(),music.getDuration(),music.getList(),music.getHref(),music.getPic()};
		try {
			queryRunner.update(sql, params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//根据Music修改元素
	public void update(Music music) {
		QueryRunner queryRunner = new QueryRunner(C3p0Utils.getDataSource());
		String sql = "UPDATE list SET sname = ?,album = ?,singer = ?,duration = ?,list = ?,href = ?,pic = ? WHERE rid = ? AND ranking = ? ";
		Object[] params = {music.getSname(),music.getAlbum(),music.getSinger(),music.getDuration(),music.getList(),music.getHref(),music.getPic(),music.getRid(),music.getRanking()};
		try {
			queryRunner.update(sql, params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//根据 rid ranking查询元素
	public Music findId(int rid,int ranking) {
		QueryRunner queryRunner = new QueryRunner(C3p0Utils.getDataSource());
		String sql = "SELECT * FROM list WHERE rid = ? AND ranking = ?";
		Music m = null;
		try {
			m = queryRunner.query(sql, new BeanHandler<Music>(Music.class),rid,ranking);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return m;
	}
	//根据rid查询整个排行榜
	public List<Music> queryByRid(String listname) {
		QueryRunner queryRunner = new QueryRunner(C3p0Utils.getDataSource());
		String sql = "SELECT * FROM list WHERE list= ? ";
		List<Music> list = null;
		try {
			list = queryRunner.query(sql, new BeanListHandler<Music>(Music.class),listname);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	//查询榜单名称
	public List<String> queryList() {
		QueryRunner queryRunner = new QueryRunner(C3p0Utils.getDataSource());
		String sql = "SELECT list FROM list GROUP BY rid";
		List<String> list = null;
		try {
			list = queryRunner.query(sql, new ColumnListHandler<String>("list"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
}
