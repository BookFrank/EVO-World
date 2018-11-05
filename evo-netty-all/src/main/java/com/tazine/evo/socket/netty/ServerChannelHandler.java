package com.tazine.evo.socket.netty;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @author frank
 * @date 2018/11/05
 */
public class ServerChannelHandler extends SimpleChannelInboundHandler<String> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        // 通信方地址
        System.out.println(ctx.channel().remoteAddress() + " Say : " + msg);

        // 响应客户端消息
        ctx.writeAndFlush(" Received your message,\n ");
    }
}