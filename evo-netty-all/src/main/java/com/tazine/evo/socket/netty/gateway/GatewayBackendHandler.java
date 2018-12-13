package com.tazine.evo.socket.netty.gateway;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * GatewayBackendHandler
 *
 * @author frank
 * @date 2018/12/12
 */
public class GatewayBackendHandler extends ChannelInboundHandlerAdapter {

    /**
     * GatewayClient 与真实服务器连接成功
     *
     * @param ctx context
     * @throws Exception e
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.err.println("GatewayClient 与真实服务器连接成功");
        super.channelActive(ctx);
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
        System.out.println("真实服务器响应：" + (String) msg);
    }
}
