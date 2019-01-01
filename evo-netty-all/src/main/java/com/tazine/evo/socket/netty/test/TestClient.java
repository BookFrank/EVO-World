package com.tazine.evo.socket.netty.test;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.bytes.ByteArrayDecoder;
import io.netty.handler.codec.bytes.ByteArrayEncoder;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 基于 Netty 的事件客户端
 *
 * @author frank
 * @date 2018/11/05
 */
public class TestClient {

    private void connect(String host, int port) {
        EventLoopGroup group = new NioEventLoopGroup();

        try {
            Bootstrap b = new Bootstrap();
            b.group(group)
                .channel(NioSocketChannel.class)
                .handler(new TimeClientChannelInitializer());

            // 连接服务端
            Channel ch = b.connect(host, port).sync().channel();

            // 控制台输入
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            while (true) {
                String line = in.readLine();
                if (line == null) {
                    continue;
                }
                /*
                 * 向服务端发送在控制台输入的文本 并用"\r\n"结尾
                 * 之所以用\r\n结尾 是因为我们在handler中添加了 DelimiterBasedFrameDecoder 帧解码。
                 * 这个解码器是一个根据\n符号位分隔符的解码器。所以每条消息的最后必须加上\n否则无法识别和解码
                 * */
                //ch.writeAndFlush(line);
                ch.writeAndFlush(line.getBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            group.shutdownGracefully();
        }
    }

    private class TimeClientChannelInitializer extends ChannelInitializer<SocketChannel> {
        @Override
        protected void initChannel(SocketChannel socketChannel) throws Exception {
            ChannelPipeline pipeline = socketChannel.pipeline();

            //pipeline.addLast("framer", new DelimiterBasedFrameDecoder(8192, Unpooled.copiedBuffer("#".getBytes())));
            // initChannel时，设置为登录用的
            //pipeline.addLast("encoder", new StringEncoder());
            //pipeline.addLast("decoder", new StringDecoder());

            pipeline.addLast("encoder", new ByteArrayEncoder());
            pipeline.addLast("decoder", new ByteArrayDecoder());

            // 以("\n")为结尾分割的解码器

            // 字符串解码和编码

            // 自己的逻辑 Handler，用于写自己的处理逻辑
            pipeline.addLast(new TestClientHandler());
        }
    }

    public static void main(String[] args) {
        //new TestClient().connect("127.0.0.1", 8080);
        new TestClient().connect("127.0.0.1", 8888);
    }
}
