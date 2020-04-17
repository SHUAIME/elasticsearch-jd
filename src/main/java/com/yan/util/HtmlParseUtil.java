package com.yan.util;

import com.yan.entity.ESContent;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: yan
 * @Date: 2020/4/17 18:47
 * @Description: com.yan.util
 * @version: 1.0
 */
public class HtmlParseUtil {

    public static void main(String[] args) throws Exception {
        new HtmlParseUtil().parseJD("元尊").forEach(System.out::println);
    }

    public static List<ESContent> parseJD(String keywords) throws Exception {

        String url = "https://search.jd.com/Search?keyword=" + keywords+"&enc=utf-8";

        Document document = Jsoup.parse(new URL(url), 300000);

        Element element = document.getElementById("J_goodsList");
        Elements elments = element.getElementsByTag("li");

        ArrayList<ESContent> li = new ArrayList<>();

        for (Element el : elments){
            String title = el.getElementsByClass("p-name").eq(0).text();
            String price = el.getElementsByClass("p-price").eq(0).text();
            String img = el.getElementsByTag("img").eq(0).attr("source-data-lazy-img");

//            System.out.println(title);
//            System.out.println(price);
//            System.out.println(img);
            li.add(new ESContent(title,price,img));
        }
        return li;
    }
}
