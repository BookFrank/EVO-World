package com.tazine.evo.socket.netty.server;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.net.InetAddress;

/**
 * TestServerHandler，是责任链模式中的处理者
 * SimpleChannelInboundHandler 负责数据进入并在ChannelPipeline中按照从上至下的顺序查找调用对应的 InBoundHandler
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
     * 当连接建立的时候触发，channel 从不活跃转到活跃状态触发
     *
     * @param ctx Context
     * @throws Exception e
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("RemoteClientAddress : " + ctx.channel().remoteAddress() + " active !");

        final Channel channel = ctx.channel();
        if (channel.isOpen() && channel.isActive()) {
            ctx.writeAndFlush("Welcome to " + InetAddress.getLocalHost().getHostName() + " service!\n");
        }
        super.channelActive(ctx);
    }

    /**
     * 当连接关闭时触发，channel 从活跃转到不活跃状态触发 co
     *
     * @param ctx ctx
     * @throws Exception e
     */
    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("RemoteClientAddress : " + ctx.channel().remoteAddress() + " inactive !");
        final Channel channel = ctx.channel();
        if (!channel.isOpen() && !channel.isActive()) {
            System.out.println("Bye Bye");
        }
        super.channelInactive(ctx);
    }
}