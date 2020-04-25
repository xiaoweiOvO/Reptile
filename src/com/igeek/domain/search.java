package com.igeek.domain;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.igeek.service.musicService;

public class search {

	public static void main(String[] args) throws SQLException {
		String url = "https://www.kugou.com/yy/rank/home/1-37361.html?from=rank";
		//拿到所有榜单的名称和地址
		Document document = null;
		//创建榜单数组
		List<RankList> ranks = new ArrayList<RankList>();
		try {
			document = Jsoup.connect(url).get();
			Elements elements = document.select("div.pc_temp_main");
			Element element = null;
			for (Element e : elements) {
				element = e;
			}
			Elements es = element.select("div.pc_temp_side div ul li a");
			for (Element element2 : es) {
				//创建对象
				RankList rl = new RankList();
				String title = element2.attr("title");
				String href = element2.attr("href");
				rl.setName(title);
				rl.setHref(href);
				ranks.add(rl);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//遍历榜单数组
		for (int i = 0; i < ranks.size(); i++) {
			RankList ranklist = ranks.get(i);
			String href = ranklist.getHref();
			try {
				document = Jsoup.connect(href).get();
				Elements elements1 = document.select("div.pc_temp_title");
				String list = null;
				for (Element element : elements1) {
					//1.排行榜名称
					list = element.select("h3").text();
				}
				//2排行榜rid
				int rid = i+1;
				//创建Music数组
				List<Music> mList = new ArrayList<Music>();
				//获取歌曲部分
				Elements elements2 = document.select("div.pc_temp_songlist ul li");
				for (Element element : elements2) {
					//创建Music对象 排名 页面 时长 
					Music music = new Music();
					String gnum = element.select("span.pc_temp_num").text();
					//3.排名
					int ranking = Integer.valueOf(gnum);
					//4.页面
					String href2 = element.select("a").attr("href");
					//5.时长
					String duration = element.select("span.pc_temp_time").text();
					//设置属性
					music.setRid(rid);
					music.setHref(href2);
					music.setList(list);
					music.setRanking(ranking);
					music.setDuration(duration);
					//添加
					mList.add(music);
				}
				//遍历mList数组     添加歌名 专辑 歌手    歌词
				musicService ms = new musicService();
				for(int x=0;x<mList.size();x++) {
					Music m = mList.get(x);
					String url2 = m.getHref();
					document = Jsoup.connect(url2).get();
					//6.歌名
					String sname = document.select("span.audioName").text();
					int index = sname.indexOf('-');
					sname = sname.substring(index+2);
					
					//专辑和歌手部分
					Elements elements12 = document.select("div.content div div div p a[target='_blank']");
					//7.专辑
					String album = elements12.get(0).text();
					//8.歌手
					String singer = elements12.get(1).text();
					//9.图片
					String pic = document.select("div.albumImg img").attr("src");
					//添加剩余属性
					m.setSname(sname);
					m.setAlbum(album);
					m.setSinger(singer);
					m.setPic(pic);
					//判断该rid ranking位置是否已经存在数据
					Music mc = ms.findId1(m.getRid(), m.getRanking());
					
					if(mc==null) {
						System.out.println(m.getRid()+"--"+m.getRanking()+"不存在，添加完成");
						ms.save(m);
					}else {
						ms.update(m);
						System.out.println(m.getRid()+"--"+m.getRanking()+"已存在，替换完成");
					}
					
					if((i>=ranks.size()-1)&&(x>=mList.size()-1)) {
						System.out.println("爬取数据完成");
					}
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
