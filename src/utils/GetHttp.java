package utils;

import java.io.*;
import java.util.*;

public class GetHttp extends HttpUtils {

    private static File file;
    private static PrintWriter writer;
    //初步爬取的网址缓存
    private static List<String> waitURLcache = new ArrayList<>();
    //初步已爬取的网址辅助
    private static Set<String> overURLcache = new HashSet<>();
    //记录所有URL的深度经行爬取
    private static Map<String,Integer> cacheURLdepth = new HashMap<>();
    //爬取的最大深度
    private static int MAX_DEPTH = 6;
    //获取网页的空闲线程数
    private static int count = 0;
    //爬取网址创建最大线程数
    private static int MAX_THREAD = 8;
    //多线程控制的辅助类
    public static  Object GetHttpObject = new Object();

    public static void MultiThreadgetHttp(String url,int depth) {
        file = new File("MovieHttpsTop250.txt");
        try {
            writer = new PrintWriter(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        addURLcache(url,depth);
        //建立多线程
        for (int i = 0; i < MAX_THREAD; i++) {
            new GetHttp().new GetHttpThread().start();
        }
    }

    public static void getHttp(String url,int depth) {
        //判断当前url是否已经被爬取过
        if (!containsOverURLcache(url) || depth > MAX_DEPTH) {
            String href = null;
            //获取到网页的内容
            List<String> list = GetHttpContent.getContent(url,HttpUtils.UTF_8);
            //把解析到的网址加入到waitURL中
            for (String source:list) {
                //截取是电影信息的网址
                href = RegexUtils.regexString("<a.*href=.+</a>",source);
                if (href != null) {
                    href = href.substring(href.indexOf("href="));
                    if (href.charAt(5) == '\"') {
                        href = href.substring(6);
                    } else {
                        href = href.substring(5);
                    }
                    //截取到引号或者空格或者到">"结束
                    try {
                        href = href.substring(0,href.indexOf("\""));
                    } catch (Exception e) {
                        try {
                            href = href.substring(0,href.indexOf(" "));
                        } catch (Exception e1) {
                            href = href.substring(0,href.indexOf(">"));
                        }
                    }
                    if (href.startsWith("http:") || href.startsWith("https:")) {
                        addURLcache(href,depth);
                    }
                }
            }
            addOverURLcache(url);
            System.out.println(url+"网页爬取完成,已爬数量:" + overURLcache.size()
                    +",剩余爬取数量:" + waitURLcache.size());
            addToWaitURL();
        }

        if (waitURLcache.size() > 0) {
            synchronized (GetHttpObject) {
                GetHttpObject.notify();
            }
        } else {
            System.out.println("爬取结束");
        }
    }

    private static synchronized void addURLcache(String href,int depth) {
        waitURLcache.add(href);
        //判断URL是否已经存在
        if (!cacheURLdepth.containsKey(href)) {
            cacheURLdepth.put(href,depth+1);
        }
    }

    private static synchronized void addOverURLcache(String href) { overURLcache.add(href);}

    private static synchronized boolean containsOverURLcache(String string) {
        return overURLcache.contains(string);
    }

    private static synchronized void addToWaitURL() {
        if (overURLcache.size() > 0) {
            for (String str:overURLcache) {
                String http = null;
                http = RegexUtils.regexString("https://movie.douban.com/subject/\\d{8}.*",str);
                if (http !=null) {
                    addWaitURL(http);
                    WriteURLtoFile(http);
                    System.out.println(http);
                }
            }
        }
    }

    public static void WriteURLtoFile(String href) {
        try {
            writer.println(href);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static synchronized String getCacheURL()  {
        String nextURL = waitURLcache.get(0);
        waitURLcache.remove(0);
        return nextURL;
    }

    public class GetHttpThread extends Thread {
        @Override
        public void run() {
            System.out.println(Thread.getAllStackTraces());
            //设定一个死循环让线程一直存在
            while (true) {
                if (waitURLcache.size() > 0) {
                    //获取URL处理
                    String aURL = getCacheURL();
                    //调用爬取
                    getHttp(aURL,cacheURLdepth.get(aURL));
                } else {
                    System.out.println("当前线程准就绪，等待爬取"
                    +this.getName() + System.currentTimeMillis());
                    count++;
                    //建立一个对象，让线程进入等待状态，即wait()
                    synchronized (GetHttpObject) {
                        try {
                            GetHttpObject.wait();
                        } catch (Exception e){
                            e.printStackTrace();
                        }
                    }
                    count--;
                }
            }
        }
    }
}
