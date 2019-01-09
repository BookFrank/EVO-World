package com.tazine.evo.netty;

import com.google.common.base.Charsets;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.bytes.ByteArrayDecoder;
import io.netty.handler.codec.bytes.ByteArrayEncoder;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * CodecClientTests
 *
 * @author frank
 * @date 2019/01/09
 */
public class CodecClientTests {

    private EventLoopGroup group = new NioEventLoopGroup();

    public static void main(String[] args) {
        new CodecClientTests().codec();
    }

    public void codec(){
        try {
            Bootstrap b = new Bootstrap();
            b.group(group)
                .channel(NioSocketChannel.class)
                .handler(new TestCodecChannelInitializer());

            ChannelFuture future = b.connect("127.0.0.1", 8088).sync();
            for (int i = 0; i < 10000; i++) {
                String msg = "Can't lose, I got juice" + "\r\n";
                System.out.println(msg);
                future.channel().writeAndFlush(msg);
                TimeUnit.SECONDS.sleep(2);
            }
            future.channel().closeFuture().sync();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            group.shutdownGracefully();
        }
    }

    private class TestCodecChannelInitializer extends ChannelInitializer<SocketChannel> {
        @Override
        protected void initChannel(SocketChannel sc) throws Exception {
            sc.pipeline().addLast(new StringDecoder());
            sc.pipeline().addLast(new StringEncoder());
            sc.pipeline().addLast(new TestCodecHandler());
        }
    }

    private class TestCodecHandler extends SimpleChannelInboundHandler<Object> {
        @Override
        protected void channelRead0(ChannelHandlerContext channelHandlerContext, Object obj) throws Exception {
            byte[] msg = (byte[])obj;
            System.out.println("收到心跳数据:" + new String(msg));
        }
    }
}
