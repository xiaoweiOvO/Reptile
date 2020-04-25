package com.igeek.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class JsoupUtils {
	public static void main(String[] args) {
//		List<String> urls = getPoemUrl();
//		for (String url : urls) {
//			System.out.println(url);
//		}
		getPoemData();

	}
	
	public static void getPoemData() {
		String url = "https://so.gushiwen.org/shiwenv_c35a60c1a8e2.aspx";
		
		Document document = null;
		
		try {
			document = Jsoup.connect(url).timeout(5000).get();
			//诗词内容
			Element element = document.select("div.sons div.cont").first();
			//System.out.println(element);
			//诗词标题
			String title = element.select("h1").first().text();
			//System.out.println(title);
			//诗词朝代和作者
			String autAndDyn = element.select("p.source a").text();
//			String[] autAndDyns = autAndDyn.split(" ");
//			String dynasty = autAndDyns[0];
//			String author = autAndDyns[1];
//			System.out.println(dynasty+";"+author);
//			for (Element element2 : elements) {
//				System.out.println(element2);
//			} 
			//诗词内容
			String content = element.select("div.contson").text();
			System.out.println(content);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static List<String> getPoemUrl() {
		
		List<String> urls = new ArrayList<String>();
		
		String url = "https://so.gushiwen.org/gushi/tangshi.aspx";
		Document document = null;
		try {
			document = Jsoup.connect(url).timeout(3000).get();
			
//			System.out.println(document);
			Elements elements = document.select("div.typecont a[href]");
			for (Element element : elements) {
//				System.out.println(element);
				String href = element.attr("href");
				urls.add("https://so.gushiwen.org"+href);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return urls;
		
	}

}
