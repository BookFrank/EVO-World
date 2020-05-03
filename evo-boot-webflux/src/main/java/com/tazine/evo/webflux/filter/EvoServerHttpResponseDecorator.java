package com.tazine.evo.webflux.filter;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.tazine.evo.webflux.util.rest.RestResponseBuilder;
import com.tazine.evo.webflux.util.rest.entity.HttpResult;
import org.apache.commons.io.IOUtils;
import org.reactivestreams.Publisher;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.core.io.buffer.DataBufferFactory;
import org.springframework.core.io.buffer.DefaultDataBufferFactory;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.http.server.reactive.ServerHttpResponseDecorator;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.io.InputStream;

import static reactor.core.scheduler.Schedulers.single;

/**
 * @author jiaer.ly
 * @date 2020/04/30
 */
public class EvoServerHttpResponseDecorator extends ServerHttpResponseDecorator {

    public EvoServerHttpResponseDecorator(ServerHttpResponse delegate) {
        super(delegate);
    }

    @Override
    public Mono<Void> writeWith(Publisher<? extends DataBuffer> body) {

        final MediaType contentType = super.getHeaders().getContentType();
        if (body instanceof Mono) {
            final Mono<DataBuffer> monoBody = (Mono<DataBuffer>)body;


            DataBuffer bf = null;
            try {
                InputStream dataBuffer = monoBody.block().asInputStream();
                byte[] bytes = IOUtils.toByteArray(dataBuffer);
                String jsonRest = new String(bytes);

                JSONObject jsonObject = JSONObject.parseObject(jsonRest);

                HttpResult result = RestResponseBuilder.buildSuccessResponse(jsonObject);

                System.out.println(JSON.toJSONString(result));

                bf = new DefaultDataBufferFactory().wrap(JSON.toJSONBytes(result));

            } catch (IOException e) {
                e.printStackTrace();
            }

            return super.writeWith(Mono.just(bf));
        } else if (body instanceof Flux) {
            final Flux<DataBuffer> monoBody = (Flux<DataBuffer>)body;

            //try {
            //    InputStream dataBuffer = monoBody.collectList().block(). .asInputStream();
            //    byte[] bytes = IOUtils.toByteArray(dataBuffer);
            //    System.err.println(new String(bytes));
            //
            //} catch (IOException e) {
            //    e.printStackTrace();
            //}


            return super.writeWith(monoBody);
        }
        return super.writeWith(body);

    }

    @Override
    public Mono<Void> writeAndFlushWith(Publisher<? extends Publisher<? extends DataBuffer>> body) {
        return super.writeAndFlushWith(body);
    }
}
