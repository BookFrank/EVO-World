package com.tazine.evo.socket.netty.gateway;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;

/**
 * @author jiaer.ly
 * @date 2018/12/12
 */
public class GatewayChannelHandlerChain extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        System.err.println("GatewayChannelHandlerChain InitChannel");
        socketChannel.pipeline().addLast(new GatewayFrontendHandler());
    }
}
