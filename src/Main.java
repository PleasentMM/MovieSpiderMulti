
import utils.GetHttp;

public class Main {
    public static void main(String[] args) {
        GetHttp getHttp = new GetHttp();
        getHttp.MultiThreadgetHttp("https://movie.douban.com/top250",0);
    }
}
