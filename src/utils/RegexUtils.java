package utils;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexUtils {
    /**
     * @param regex 要匹配的正则表达式
     * @param str 要匹配的语句
     * @return String
     * */
    public static String regexString(String regex, String str) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()) {
            return matcher.group();
        }
        return null;
    }

    /**
     * @param regex
     * @param html
     * @return Map<String,String>
     * */
    public static Map<String, String> regexHtml(String regex, String html) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(html);
        if (matcher.find()) {
            Map<String, String> map = new HashMap<>();
            for (int i = 0; i <= matcher.groupCount(); i++) {
                map.put("group" + i, matcher.group(i).trim());
            }
            return map;
        }
        return null;
    }
}
