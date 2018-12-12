package com.tazine.evo.socket.netty.proxy;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;

/**
 * ProxyChannelHandlerChain
 *
 * @author frank
 * @date 2018/12/12
 */
public class ProxyChannelHandlerChain extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        System.err.println("ProxyChannelHandlerChain InitChannel");
        socketChannel.pipeline().addLast(new ProxyFrontendHandler());
    }
}
