package com.tazine.evo.netty.codec;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.Delimiters;
import io.netty.handler.codec.bytes.ByteArrayDecoder;
import io.netty.handler.codec.bytes.ByteArrayEncoder;

/**
 * CodecServer
 *
 * @author frank
 * @date 2019/01/09
 */
public class CodecServer {

    private EventLoopGroup bossGroup = new NioEventLoopGroup();

    private EventLoopGroup workerGroup = new NioEventLoopGroup();

    public void start(int port) {
        try {
            ServerBootstrap bootstrap = new ServerBootstrap();

            //bootstrap.group(bossGroup, workerGroup)
            //    .channel(NioServerSocketChannel.class)
            //    .childHandler();

            // 绑定端口，同步等待
            ChannelFuture f = bootstrap.bind(port).sync();

            // 等待端口关闭
            f.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }

    private static class ServerInitializer extends ChannelInitializer<SocketChannel>{
        @Override
        protected void initChannel(SocketChannel socketChannel) throws Exception {
            ChannelPipeline pipeline = socketChannel.pipeline();
            pipeline.addLast(new DelimiterBasedFrameDecoder(8092, Delimiters.lineDelimiter()));
            pipeline.addLast(new ByteArrayEncoder());
            pipeline.addLast(new ByteArrayDecoder());
            pipeline.addLast(new CodecServerHandler());
        }
    }

    private static class CodecServerHandler extends ChannelInboundHandlerAdapter{
        @Override
        public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
            ctx.alloc().buffer();
            ctx.alloc().directBuffer();

            ctx.fireChannelActive();

            super.channelRead(ctx, msg);
        }
    }

    public static void main(String[] args) {
        CodecServer server = new CodecServer();
        server.start(8888);
    }
}
