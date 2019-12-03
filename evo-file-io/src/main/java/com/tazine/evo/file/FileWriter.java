package com.tazine.evo.file;

import com.tazine.evo.file.utils.GzipUtil;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * FileWriter
 *
 * @author frank
 * @date 2018/11/21
 */
public class FileWriter {

    public static void main(String[] args) {

        File file = new File("/Users/jiaer.ly/Desktop/gzip");
        try {
            //List<String> list = new ArrayList<>();
            //// Commons-io 读取文件
            //for (int i = 0; i < 10; i++) {
            //    list.add("" + i);
            //}
            //FileUtils.writeLines(file, list);

            String json = "[{\"name\":\"kobe\",\"team\":\"lakers\",\"num\":24},{\"name\":\"iverson\","
                + "\"team\":\"76ers\",\"num\":3}]";
            FileUtils.writeByteArrayToFile(file, GzipUtil.compress(json.getBytes()));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
