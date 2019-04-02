package utils;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.List;

public class GetHttpContent extends HttpUtils{

    /**
     * @param url
     * @param charset
     * @return ArrayList<String>
     * */

    private static Object writeObjectHelper = new Object();
    private static int  count = 0;

    public static synchronized ArrayList<String> getContent(String url, String charset) {
        ArrayList<String> result = new ArrayList<>();
        try {
            System.getProperties().setProperty("proxySet", "true");
            System.getProperties().setProperty("http.proxyHost", "139.217.24.50");
            System.getProperties().setProperty("http.proxyPort", "3128");

            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
            connection.setRequestMethod("POST");
            connection.setConnectTimeout(3000);
            connection.setDoOutput(true);
            connection.setDoOutput(true);
            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(connection.getInputStream(),charset)
                );
                String line = null;
                while ((line = reader.readLine()) != null) {
                    result.add(line);
                }
                reader.close();
            }
            connection.disconnect();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 保存符合要求的网址
     * */
    public static synchronized void WriteURLtoFile() {
        File file = new File("Movie.txt");
        String href = null;
        if (WaitURLsize() > 0) {
            href = getWaitRUL();
            if (href != null) {
                System.out.println("Get href!" + href);
                try {
                    FileWriter writer = new FileWriter(file);
                    writer.write(href);
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    public class WriteThread extends Thread{
        @Override
        public void run() {
            while (true) {
                if (WaitURLsize() > 0) {
                    WriteURLtoFile();
                } else {
                    System.out.println("写入线程准备就绪" + this.getName());
                    count++;
                    synchronized (writeObjectHelper) {
                        try {
                            writeObjectHelper.notify();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    count--;
                }
            }
        }
    }

    public static void runWriteThread() {
        for (int i = 0; i < 2; i++) {
            new GetHttpContent().new WriteThread().start();
        }
    }

}
