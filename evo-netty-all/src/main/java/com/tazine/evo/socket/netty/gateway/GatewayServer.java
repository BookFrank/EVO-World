package com.tazine.evo.socket.netty.gateway;

import com.google.common.collect.Maps;
import io.netty.bootstrap.Bootstrap;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.util.Map;

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
                .childHandler(new GatewayServerHandlerChain());

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
        // 1. 启动 GatewayServer
        int serverPort = 9090;
        new Thread(() -> new GatewayServer().start(serverPort)).start();

        // 2. 根据 CS，建立 GatewayClient 与 TDS服务器的连接
        Map<String, Integer> tdsMap = Maps.newHashMap();
        tdsMap.put("127.0.0.1", 8080);
        tdsMap.forEach((ip, port) -> {
            System.out.println("开始连接：" + ip + " - " + port);
            // 创建代理服务器与真实服务器的连接
            Bootstrap b = new Bootstrap();
            b.group(new NioEventLoopGroup())
                .channel(NioSocketChannel.class)
                .handler(new GatewayClientHandlerChain())
                // TODO 不开启自动读
                .option(ChannelOption.AUTO_READ, false);
            ChannelFuture cf = b.connect(ip, port);
            final Channel gatewayClientChannel = cf.channel();

            cf.addListener(new ChannelFutureListener() {
                @Override
                public void operationComplete(ChannelFuture future) {
                    if (future.isSuccess()) {
                        // 连接成功，开始从代理服务器读取数据
                        System.err.println("GatewayClient连接真实服务器成功，将 channel 存入连接池中");
                        GatewayClientPool.addToPool("", gatewayClientChannel);
                        //inboundChannel.read();
                        gatewayClientChannel.writeAndFlush("Hi\r\n");
                    } else {
                        // Close the connection if the connection attempt has failed.
                        System.err.println("连接真实服务器失败");
                        //inboundChannel.close();
                    }
                }
            });
        });
    }
}
