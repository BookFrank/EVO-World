package com.tazine.evo.socket.netty.proxy;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;

/**
 * ProxyFrontendHandler，代理服务器和客户端之间的处理
 *
 * @author frank
 * @date 2018/12/12
 */
public class ProxyFrontendHandler extends ChannelInboundHandlerAdapter {

    private volatile Channel outboundChannel;

    /**
     * 在客户端连接的同时，创建代理服务 TcpClient 与真实服务器连接
     *
     * @param ctx ChannelHandlerContext
     * @throws Exception e
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.err.println("ProxyFrontendHandler channelActive");

        // inBoundChannel 客户端连接代理服务器的 channel
        final Channel inboundChannel = ctx.channel();

        // 创建代理服务器与真实服务器的连接
        Bootstrap b = new Bootstrap();
        b.group(inboundChannel.eventLoop())
            .channel(ctx.channel().getClass())
            .handler(new ProxyBackendHandler(inboundChannel))
            .option(ChannelOption.AUTO_READ, false);
        ChannelFuture f = b.connect("127.0.0.1", 8080);
        outboundChannel = f.channel();

        // 当代理服务与真实服务连接成功后，开始读取客户端传来的数据
        f.addListener(new ChannelFutureListener() {
            @Override
            public void operationComplete(ChannelFuture future) {
                if (future.isSuccess()) {
                    // 连接成功，开始从代理服务器读取数据
                    System.err.println("连接真实服务器成功，开始从代理服务器读取数据");
                    inboundChannel.read();
                } else {
                    // Close the connection if the connection attempt has failed.
                    System.err.println("连接真实服务器失败");
                    inboundChannel.close();
                }
            }
        });
    }

    /**
     * 代理服务器收到客户端传来的数据后，就把数据通过代理服务的客户端发送给真实服务器
     *
     * @param ctx context
     * @param msg message
     * @throws Exception e
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.err.println("ProxyFrontendHandler channelRead");
        if (outboundChannel.isActive()) {
            //if (ByteBuf.class.isAssignableFrom(msg.getClass())){
            //proxyDefinition.getConnectionStats().appendBytesSent(((ByteBuf)msg).capacity());
            //}
            outboundChannel.writeAndFlush(msg).addListener(new ChannelFutureListener() {
                @Override
                public void operationComplete(ChannelFuture future) {
                    if (future.isSuccess()) {
                        // 接收到的数据发送成功，继续读取下一块数据
                        System.err.println("从客户端接收到的数据发送成功，继续读取客户端发来的下一块数据");
                        ctx.channel().read();
                    } else {
                        System.err.println("从客户端接收到的数据发送失败，继续读取客户端发来的下一块数据");
                        future.channel().close();
                    }
                }
            });
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        super.exceptionCaught(ctx, cause);
        cause.printStackTrace();
    }
}
