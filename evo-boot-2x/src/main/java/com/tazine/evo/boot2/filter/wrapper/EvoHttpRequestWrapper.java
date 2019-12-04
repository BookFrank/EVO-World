package com.tazine.evo.boot2.filter.wrapper;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.IOException;
import java.util.zip.GZIPInputStream;

/**
 * @author jiaer.ly
 * @date 2019/12/03
 */
@Slf4j
public class EvoHttpRequestWrapper extends HttpServletRequestWrapper {

    private HttpServletRequest request;

    public EvoHttpRequestWrapper(HttpServletRequest request) {
        super(request);
        this.request=request;
    }

    @Override
    public ServletInputStream getInputStream() throws IOException {
        ServletInputStream stream = request.getInputStream();
        int len = stream.available();
        String contentEncoding = request.getHeader("Content-Encoding");
        if (null != contentEncoding && contentEncoding.indexOf("gzip") != -1) {
            try {
                final GZIPInputStream gzipInputStream = new GZIPInputStream(stream);
                ServletInputStream newStream = new ServletInputStream() {
                    @Override
                    public int read() throws IOException {
                        return gzipInputStream.read();
                    }

                    @Override
                    public boolean isFinished() {
                        return false;
                    }

                    @Override
                    public boolean isReady() {
                        return false;
                    }

                    @Override
                    public void setReadListener(ReadListener readListener) {}
                };
                return newStream;
            } catch (Exception e) {
                log.error("uncompress content fail.", e);
            }
        }
        return stream;
    }
}
