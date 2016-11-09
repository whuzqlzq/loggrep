package nim.log;

import nim.utils.grep;
import org.apache.log4j.Logger;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kubbi on 2016/11/8.
 */
public class log {
    private static Logger logger = Logger.getLogger(log.class);
    public static void main(String args[]){
        String str = "VedioaaaArchebbbLog";
        List<String> regs = new ArrayList<>();
        regs.add("Vdio");
        regs.add("Ach");
        regs.add("Lg");
        logger.info( "匹配结果:" + grep.grepLine(str, regs, "OR") );
    }

    /**
     * 扫描path路径下的所有文件
     * @param path
     */
    public File[] listfiles(String path){
        File file = new File(path);
        File files[] = file.listFiles();

        return files;
    }

    public void filegrep(File[] files, List<String> regs, String type){
        for ( File file: files ) {
            try {
                BufferedReader br = new BufferedReader(new FileReader(file));
                String line;
                while((line=br.readLine())!=null){

                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
