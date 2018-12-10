package com.tazine.evo.socket.netty.server;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.net.InetAddress;

/**
 * ServerChannelHandler
 *
 * @author frank
 * @date 2018/11/05
 */
public class ServerChannelHandler extends SimpleChannelInboundHandler<String> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        // 通信方地址
        System.out.println(ctx.channel().remoteAddress() + " Say : " + msg);

        // 响应客户端消息 必须加 \n 否则可能会出错
        ctx.writeAndFlush(" Received your message,\n ");
    }

    /**
     * 当连接建立的时候触发
     *
     * @param ctx Context
     * @throws Exception e
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("RamoteAddress : " + ctx.channel().remoteAddress() + " active !");

        ctx.writeAndFlush("Welcome to " + InetAddress.getLocalHost().getHostName() + " service!\n");

        super.channelActive(ctx);
    }

    /**
     * 当连接关闭时触发
     *
     * @param ctx ctx
     * @throws Exception e
     */
    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("RamoteAddress : " + ctx.channel().remoteAddress() + " inactive !");
        super.channelInactive(ctx);
    }
}