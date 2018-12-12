package com.tazine.evo.socket.netty.demo;

import com.google.common.base.Charsets;
import com.tazine.evo.socket.netty.server.NettyTimeServer;
import com.tazine.evo.socket.netty.server.ServerChannelHandler;
import com.tazine.evo.socket.netty.server.ServerChannelHandlerChain;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.FixedLengthFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;

/**
 * EchoServer
 *
 * @author frank
 * @date 2018/12/12
 */
public class EchoServer {

    private EventLoopGroup bossGroup = new NioEventLoopGroup();

    private EventLoopGroup workerGroup = new NioEventLoopGroup();

    public void start(int port){
        try {
            ServerBootstrap b = new ServerBootstrap();

            b.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .option(ChannelOption.SO_BACKLOG, 1024)
                    .childOption(ChannelOption.SO_KEEPALIVE, true)
                    .childOption(ChannelOption.TCP_NODELAY, true)
                    .childHandler(new EchoServerChannelInitializer());

            ChannelFuture f = b.bind(port).sync();

            f.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }

    private class EchoServerChannelInitializer extends ChannelInitializer<SocketChannel> {
        @Override
        protected void initChannel(SocketChannel ch) throws Exception {
            ch.pipeline().addLast(new FixedLengthFrameDecoder(20));
            ch.pipeline().addLast(new StringDecoder(Charsets.UTF_8));
            ch.pipeline().addLast(new EchoServerChannelHandler());
        }
    }

    public static void main(String[] args) {
        int port = 8080;
        new EchoServer().start(port);
    }
}
