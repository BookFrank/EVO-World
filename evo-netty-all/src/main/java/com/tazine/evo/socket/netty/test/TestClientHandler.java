package com.tazine.evo.socket.netty.test;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.Delimiters;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.util.ReferenceCountUtil;

/**
 * TestClientHandler
 *
 * @author frank
 * @date 2018/11/05
 */
public class TestClientHandler extends SimpleChannelInboundHandler<String> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        System.out.println("Server say : " + msg + msg.length());
        if (msg.equalsIgnoreCase("connect")){
            System.out.println("Client 更换协议成功");
            ChannelPipeline pipeline = ctx.pipeline();
            pipeline.remove("framer");
            pipeline.remove("encoder");
            pipeline.remove("decoder");


            pipeline.addFirst(new StringEncoder());
            pipeline.addFirst(new StringDecoder());
            pipeline.addFirst(new DelimiterBasedFrameDecoder(8092, Delimiters.lineDelimiter()));
        }
        ReferenceCountUtil.release(msg);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("Client channel is active");
        super.channelActive(ctx);
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("Client channel inactive");
        super.channelInactive(ctx);
    }
}
