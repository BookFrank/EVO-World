package com.tazine.evo.socket.netty.test;

import io.netty.channel.*;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.Delimiters;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

import java.net.InetAddress;

/**
 * TestServerHandler，是责任链模式中的处理者
 * SimpleChannelInboundHandler 负责数据进入并在ChannelPipeline中按照从上至下的顺序查找调用对应的 InBoundHandler
 *
 * @author frank
 * @date 2018/11/05
 */
public class TestServerHandler extends SimpleChannelInboundHandler<String> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        // 通信方地址
        System.out.println(ctx.channel().remoteAddress() + " Say : " + msg + msg.length());
        if (msg.equalsIgnoreCase("please")){
            ctx.writeAndFlush("connect#").addListener(new ChannelFutureListener() {
                @Override
                public void operationComplete(ChannelFuture channelFuture) throws Exception {
                    System.out.println("Server 更换协议成功");

                    ChannelPipeline pipeline = ctx.pipeline();
                    pipeline.remove("framer");
                    pipeline.remove("encoder");
                    pipeline.remove("decoder");

                    pipeline.addFirst(new StringEncoder());
                    pipeline.addFirst(new StringDecoder());
                    pipeline.addFirst(new DelimiterBasedFrameDecoder(8092, Delimiters.lineDelimiter()));
                }
            });
        }else {
            ctx.writeAndFlush(" Received your message#\n ");
        }
        ctx.fireChannelRead(msg);
        // 响应客户端消息 必须加 \n 否则可能会出错
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
            //ctx.writeAndFlush("Welcome to " + InetAddress.getLocalHost().getHostName() + " service!\n");
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