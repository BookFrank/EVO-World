package com.tazine.evo.socket.netty.server;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.Delimiters;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.handler.timeout.IdleStateHandler;

/**
 * ServerChannelHandlerChain 职责链
 * ChannelInitializer 用于初始化 ChannelPipeline，定义对channel的处理，在初始化的时候设置管道里消息的处理者。
 *
 * @author frank
 * @date 2018/11/16
 */
public class ServerChannelHandlerChain extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        ChannelPipeline pipeline = socketChannel.pipeline();

        // 以("\n")为结尾分割的解码器
        //pipeline.addLast("framer", new DelimiterBasedFrameDecoder(8192, Delimiters.lineDelimiter()));

        // 空闲状态检查  间隔无消息,断开连接
        pipeline.addLast("idleStateCheck", new IdleStateHandler(0, 0, 600));
        //pipeline.addLast("idleCheckHandler", new IdleStateCheckHandler());

        // 字符串解码和编码
        // 将比特流转换为默认编码的字符串，默认为 UTF-8
        pipeline.addLast("decoder", new StringDecoder());
        //pipeline.addLast("encoder", new StringEncoder());

        // 自己的逻辑 Handler，用于写自己的处理逻辑
        //pipeline.addLast(new TestServerHandler());
        pipeline.addLast(new ServerChannelProcess());

    }
}
