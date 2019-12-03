package com.tazine.evo.boot2.util;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/**
 * @author jiaer.ly
 * @date 2019/12/03
 */
public class GzipUtil {

    private static final String ENCODING = "UTF-8";

    public static final int BUFFER = 1024;
    public static final String EXT = ".gz";

    /**
     * 压缩
     *
     * @param data
     * @return
     * @throws Exception
     */
    public static byte[] compress(byte[] data) throws Exception {

        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        // 压缩
        GZIPOutputStream gos = new GZIPOutputStream(baos);

        gos.write(data, 0, data.length);
        gos.finish();

        byte[] output = baos.toByteArray();

        baos.flush();
        baos.close();
        return output;
    }

    /**
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public static void excute(HttpServletResponse response, String str)
        throws ServletException, IOException {

        byte[] data = str.toString().getBytes(ENCODING);

        try {
            byte[] output = compress(data);
            // 设置Content-Encoding，这是关键点！
            response.setHeader("Content-Encoding", "gzip");
            response.setContentType("text/plain;charset=utf-8");
            // 设置字符集
            response.setCharacterEncoding(ENCODING);
            // 设定输出流中内容长度
            response.setContentLength(output.length);

            OutputStream out = response.getOutputStream();
            out.write(output);
            out.flush();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 数据解压缩
     *
     * @param data
     * @return
     * @throws Exception
     */
    public static byte[] decompress(byte[] data) throws Exception {
        ByteArrayInputStream bais = new ByteArrayInputStream(data);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        // 解压缩
        decompress(bais, baos);

        data = baos.toByteArray();

        baos.flush();
        baos.close();

        bais.close();

        return data;
    }

    /**
     * 数据解压缩
     *
     * @param is
     * @param os
     * @throws Exception
     */
    public static void decompress(InputStream is, OutputStream os)
        throws Exception {

        GZIPInputStream gis = new GZIPInputStream(is);

        int count;
        byte data[] = new byte[BUFFER];
        while ((count = gis.read(data, 0, BUFFER)) != -1) {
            os.write(data, 0, count);
        }
        gis.close();
    }
}
