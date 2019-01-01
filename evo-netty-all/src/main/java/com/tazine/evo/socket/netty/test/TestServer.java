package com.tazine.evo.socket.netty.test;

import com.tazine.evo.socket.netty.server.ServerChannelHandler;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.Delimiters;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

/**
 * 基于 Netty 的 NIO 时间服务器
 *
 * @author frank
 * @date 2018/10/31
 */
public class TestServer {

    /**
     * 专门用于网络事件的处理，就是 Reactor 线程组；
     * 处理所有注册到本线程多路复用器 Selector 上的 Channel，调度和执行哭护短的接入
     * 服务端用于监听和接收客户端连接的 Reactor 线程组
     */
    private EventLoopGroup bossGroup = new NioEventLoopGroup();

    /**
     * 用于处理 SocketChannel 的网络读写，处理 /O 读写的 Reactor 线程组
     */
    private EventLoopGroup workerGroup = new NioEventLoopGroup();

    public void bind(int port){

        // 服务端为什么需要线程组？
        // 配置服务端的 NIO 线程组
        try {
            ServerBootstrap b = new ServerBootstrap();

            b.group(bossGroup, workerGroup)
                // 绑定服务端 Channel，作为 NIO 服务端，JDK 中需要创建 ServerSocketChannel
                .channel(NioServerSocketChannel.class)

                //服务端可连接队列数,对应TCP/IP协议listen函数中backlog参数
                .option(ChannelOption.SO_BACKLOG, 1024)

                //设置TCP长连接,一般如果两个小时内没有数据的通信时,TCP会自动发送一个活动探测数据报文
                .childOption(ChannelOption.SO_KEEPALIVE, true)

                //将小的数据包包装成更大的帧进行传送，提高网络的负载,即TCP延迟传输
                .childOption(ChannelOption.TCP_NODELAY, true)

                // 服务端收到消息以后做什么，通过 Handler 来体现
                .childHandler(new TimeServerChannelInitializer());

            // 绑定端口，同步等待成功
            ChannelFuture f = b.bind(port).sync();

            // 等待服务端监听端口关闭
            f.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }

    /**
     * I/O 事件的处理类，类似于 Reactor 模式中的 handler；
     * 主要用于处理网络 I/O 事件，例如记录日志、对消息进行编解码等
     */
    private class TimeServerChannelInitializer extends ChannelInitializer<SocketChannel>{
        @Override
        protected void initChannel(SocketChannel socketChannel) throws Exception {
            ChannelPipeline pipeline = socketChannel.pipeline();
            //pipeline.addLast("framer", new DelimiterBasedFrameDecoder(8192, Unpooled.copiedBuffer("#".getBytes())));
            //pipeline.addLast("framer", new DelimiterBasedFrameDecoder(8192, Delimiters.lineDelimiter()));
            pipeline.addLast("encoder", new StringEncoder());
            pipeline.addLast("decoder", new StringDecoder());
            //socketChannel.pipeline().addLast(new TestServerHandler());
            socketChannel.pipeline().addLast(new TestServerHandlerAdapter());
            socketChannel.pipeline().addLast(new TestServerHandlerAdapter2());
        }
    }

    public static void main(String[] args) {
        int port = 8888;
        new TestServer().bind(port);
    }
}
