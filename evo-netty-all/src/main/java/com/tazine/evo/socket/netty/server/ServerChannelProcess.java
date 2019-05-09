package com.tazine.evo.socket.netty.server;

import com.google.common.base.Charsets;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * ServerChannelProcess
 *
 * @author frank
 * @date 2018/12/28
 */
public class ServerChannelProcess extends SimpleChannelInboundHandler<String> {

    @Override
    public void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {

        System.out.println("进入channel read");

        System.out.println(msg.getClass().getName() + msg);
        //if (msg instanceof ByteBuf){
        //    System.out.println("ByteBuf 好牛逼");
        //}

        //byte[] message = (byte[])msg;

        //System.out.println(new String(message, Charsets.UTF_8));
    }


}
