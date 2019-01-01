package com.tazine.evo.socket.netty.test;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * TestServerHandlerAdapter
 *
 * @author frank
 * @date 2019/01/01
 */
public class TestServerHandlerAdapter extends ChannelInboundHandlerAdapter {

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("TestServerHandlerAdapter Active");
        super.channelActive(ctx);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        String message = (String)msg;
        System.out.println("TestServerHandlerAdapter 收到 : " + message + message.length());
        ctx.writeAndFlush("TestServerHandlerAdapter Received your message");
        ctx.fireChannelRead(msg);
    }
}
