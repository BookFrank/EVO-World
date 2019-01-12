package com.tazine.evo.netty.codec;

import com.alibaba.fastjson.JSON;
import com.tazine.evo.netty.codec.protocol.*;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.Delimiters;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * CodecServer
 *
 * @author frank
 * @date 2019/01/09
 */
@Slf4j
@Component
public class CodecServer {

    private static final int MAX_FRAME_LENGTH = 1024 * 1024;
    private static final int LENGTH_FIELD_LENGTH = 4;
    private static final int LENGTH_FIELD_OFFSET = 13;
    private static final int LENGTH_ADJUSTMENT = 0;
    private static final int INITIAL_BYTES_TO_STRIP = 0;

    private EventLoopGroup bossGroup = new NioEventLoopGroup();

    private EventLoopGroup workerGroup = new NioEventLoopGroup();

    public void start(int port) {
        try {
            ServerBootstrap bootstrap = new ServerBootstrap();

            bootstrap.group(bossGroup, workerGroup)
                .channel(NioServerSocketChannel.class)
                .option(ChannelOption.SO_BACKLOG, 1024)
                // 设置TCP长连接,一般如果两个小时内没有数据的通信时,TCP会自动发送一个活动探测数据报文
                .childOption(ChannelOption.SO_KEEPALIVE, true)
                // 将小的数据包包装成更大的帧进行传送，提高网络的负载,即TCP延迟传输
                .childOption(ChannelOption.TCP_NODELAY, true)
                .childHandler(new ServerInitializer());

            // 绑定端口，同步等待
            ChannelFuture f = bootstrap.bind(port).sync();

            System.out.println("CodecServer 启动");

            // 等待端口关闭
            f.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }

    private static class ServerInitializer extends ChannelInitializer<SocketChannel> {
        @Override
        protected void initChannel(SocketChannel socketChannel) throws Exception {
            ChannelPipeline pipeline = socketChannel.pipeline();

            // 1.
            //pipeline.addLast(new DelimiterBasedFrameDecoder(8092, Delimiters.lineDelimiter()));
            //pipeline.addLast(new StringEncoder());
            //pipeline.addLast(new StringDecoder());
            //pipeline.addLast(new CodecServerHandler());

            // 2.
            //pipeline.addLast(new GatewayDecoder(MAX_FRAME_LENGTH, LENGTH_FIELD_LENGTH, LENGTH_FIELD_OFFSET, LENGTH_ADJUSTMENT, INITIAL_BYTES_TO_STRIP, false));
            //pipeline.addLast(new GatewayDecoder03());
            //pipeline.addLast(new GatewayEncoder());

            // 3.
            pipeline.addLast(new CodecServerHandler());

        }
    }

    private static class CodecServerHandler extends ChannelInboundHandlerAdapter {

        @Override
        public void channelActive(ChannelHandlerContext ctx) throws Exception {
            System.out.println("连接成功");
        }

        @Override
        public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
            // 1. 测试使用换行符分隔与 StringDecoder 解码，在自己的 handler 中不释放消息，看内存会不会增加，发送消息不会增加内存
            //if (msg instanceof String) {
            //    System.out.println((String)msg);
            //    // 不加 fireChannelRead 不会触发 tailContext
            //    //ctx.fireChannelRead(msg);
            //} else {
            //    System.err.println("消息解析错误");
            //}

            // 2. 测试 GatewayDecoder 会不会增加堆外内存
            //if (msg instanceof GatewayMessage){
            //    log.info("[CodecReceive] " + JSON.toJSONString((GatewayMessage)msg));
            //}else {
            //    System.err.println("消息解析错误");
            //}

            // 3. 测试不释放 ByteBuf 会发生什么
            if (msg instanceof ByteBuf){
                //System.out.println("收到消息");
            }else {
                System.err.println("消息格式不是 ByteBuf" + msg.getClass().getName());
            }
            ctx.fireChannelRead(msg);
        }

        @Override
        public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
            cause.printStackTrace();
            log.error(cause.getMessage());
        }
    }

    public static void main(String[] args) {
        CodecServer server = new CodecServer();
        server.start(8888);
    }

}
