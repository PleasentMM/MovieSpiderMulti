package utils;

import java.util.*;

public class HttpUtils {
    /**
     * 网页的多种编码格式
     * */
    public static final String UTF_8 = "UTF-8";
    public static final String GBK = "GBK";
    public static final String GB2132 = "GB2132";
    //等待爬取的URL队列
    private static List<String> waitURL = new ArrayList<>();
    //爬取过的URL
    private static Set<String> overURL = new HashSet<>();

    /**
     * @param href 待爬取网址
     */
    public static synchronized void addWaitURL(String href) {
        waitURL.add(href);
    }
    /**
     * @return waitURL size
     * */
    public static synchronized int WaitURLsize() {
        return waitURL.size();
    }
    /**
     * @return URL String
     * */
    public static synchronized String getWaitRUL() {
        //从等待队列之首获取网址
        String nextURL = waitURL.get(0);
        //并从等待队列移除
        waitURL.remove(0);
        return nextURL;
    }

    public static boolean containsOverURL(String url) {
        return overURL.contains(url);
    }

    public static void addOverURL(String url) {
        overURL.add(url);
    }

    public static void cleanOverURL() {
        overURL.clear();
    }
}
