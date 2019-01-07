package com.tazine.evo.socket.netty.test;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * TestServerHandler2
 *
 * @author frank
 * @date 2019/01/01
 */
public class TestServerHandler2 extends SimpleChannelInboundHandler<String> {

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("TestServerHandler2 : " + ctx.channel().remoteAddress() + " active !");

        final Channel channel = ctx.channel();
        if (channel.isOpen() && channel.isActive()) {
            //ctx.writeAndFlush("Welcome to " + InetAddress.getLocalHost().getHostName() + " service!\n");
        }
        super.channelActive(ctx);
    }


    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, String s) throws Exception {
        System.out.println("TestServerHandler2 Receive: " + s);
    }
}
