package nim.utils;

import org.apache.log4j.Logger;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Kubbi on 2016/11/8.
 */
public class grep {
    private static Logger logger = Logger.getLogger(grep.class);
    /**
     * 字符串匹配多个子字符串
     * @param contents  源字符串
     * @param regs      多个子串
     * @param type      匹配模式 OR或 AND与,默认AND
     * @return
     */
    public static boolean grepLine(String contents, List<String> regs, String type){
        // 默认AND模式
        if(null==type || type.trim().isEmpty()){
            type = "AND";
        }else if(type.equalsIgnoreCase("or") || type.equalsIgnoreCase("and")){
        }else{
            logger.error("type must be and/or");
            return false;
        }

        Pattern pattern = compile(regs, type);
        Matcher matcher = pattern.matcher(contents);

        // 匹配到返回true
        if(matcher.find()){
            return true;
        }

        return false;
    }

    /**
     * 生成正则表达式
     * @param regs
     * @param type
     * @return
     */
    public static Pattern compile(List<String> regs, String type){
        String regex = "";

        if(null==regs || regs.isEmpty()){

        }else{
            for(int loop=0; loop<regs.size(); loop++){
                if(type.equalsIgnoreCase("or")){
                    regex += regs.get(loop);
                    if(loop<regs.size()-1){
                        regex += "|";
                    }
                }else{
                    regex += regs.get(loop);
                    if(loop<regs.size()-1){
                        regex += "(.*?)";  //非贪婪模式
                    }
                }
            }
        }

        return Pattern.compile(regex);
    }
}
