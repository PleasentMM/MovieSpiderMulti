package parse;

import bean.Movie;
import utils.HttpUtils;
import utils.RegexUtils;

public class MovieParser extends HttpUtils {
    /**
     * @param html
     * @param movieId
     * @return Movie
     * */
    public static Movie parser(String html, int movieId) {
        Movie movie = new Movie();

        movie.setId(movieId);
        String movieInfo = RegexUtils.regexHtml("<script type=\"application/ld\\+json\">([\\s\\S]*?)</script>",html).get("group1");


        return movie;
    }
}
