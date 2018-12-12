package com.tazine.evo.socket.netty.proxy;

import io.netty.channel.*;

/**
 * ProxyBackendHandler，代理服务于真实服务之间的处理
 *
 * @author frank
 * @date 2018/12/12
 */
public class ProxyBackendHandler extends ChannelInboundHandlerAdapter {

    private final Channel inboundChannel;

    public ProxyBackendHandler(Channel inboundChannel) {
        this.inboundChannel = inboundChannel;
    }

    /**
     * 当代理服务客户端与真实服务连接成功后，开始读取代理客户端从真实服务器接收到的响应数据
     *
     * @param ctx context
     * @throws Exception e
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        ctx.read();
    }

    /**
     * 代理服务客户端收到真实服务发来数据后，就把数据通过真实服务器回写给真实客户端
     *
     * @param ctx context
     * @param msg message
     * @throws Exception e
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        inboundChannel.writeAndFlush(msg).addListener(new ChannelFutureListener() {
            @Override
            public void operationComplete(ChannelFuture future) {
                if (future.isSuccess()) {
                    ctx.channel().read();
                } else {
                    future.channel().close();
                }
            }
        });
    }
}
