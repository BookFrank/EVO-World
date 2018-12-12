package com.tazine.evo.socket.netty.gateway;

import com.alibaba.fastjson.JSON;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * GatewayFrontendHandler，Gateway与客户端连接Channel处理
 *
 * @author frank
 * @date 2018/12/12
 */
//public class GatewayFrontendHandler extends SimpleChannelInboundHandler<String> {
public class GatewayFrontendHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.err.println("真实客户端与 Gateway 连接成功");
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("Gateway收到真实客户端发来的信息 : " + msg);
        Channel channel = GatewayClientPool.getChannel();
        System.out.println(JSON.toJSONString(channel));
        if (channel.isOpen() && channel.isActive()) {
            channel.writeAndFlush(msg + "\n");
        } else {
            System.err.println("Gateway 发送消息失败");
        }
    }

    //@Override
    //protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
    //    System.out.println("Gateway收到真实客户端发来的信息 : " + msg);
    //
    //    Channel channel = GatewayClientPool.getChannel();
    //    System.out.println(JSON.toJSONString(channel));
    //    if (channel.isOpen() && channel.isActive()) {
    //        channel.writeAndFlush(msg + "\n");
    //        ctx.writeAndFlush();
    //    }else {
    //        System.err.println("Gateway 发送消息失败");
    //    }
    //}

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        super.exceptionCaught(ctx, cause);
    }
}
