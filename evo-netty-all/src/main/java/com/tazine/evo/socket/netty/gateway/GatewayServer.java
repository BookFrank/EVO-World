package com.tazine.evo.socket.netty.gateway;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * Netty Gateway 服务器
 *
 * @author frank
 * @date 2018/12/12
 */
public class GatewayServer {

    private EventLoopGroup bossGroup = new NioEventLoopGroup();

    private EventLoopGroup workerGroup = new NioEventLoopGroup();

    public void start(int port) {
        try {
            ServerBootstrap b = new ServerBootstrap();

            b.group(bossGroup, workerGroup)
                .channel(NioServerSocketChannel.class)
                .option(ChannelOption.SO_BACKLOG, 1024)
                .childOption(ChannelOption.SO_KEEPALIVE, true)
                .childOption(ChannelOption.TCP_NODELAY, true)
                .childHandler(new GatewayChannelHandlerChain());

            ChannelFuture f = b.bind(port).sync();

            f.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }

    public static void main(String[] args) {
        int port = 9090;
        new GatewayServer().start(port);
    }
}
