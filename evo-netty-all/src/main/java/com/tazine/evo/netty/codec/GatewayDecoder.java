package com.tazine.evo.netty.codec;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;

/**
 * GatewayDecoder
 *
 * @author frank
 * @date 2018/12/14
 */
public class GatewayDecoder extends LengthFieldBasedFrameDecoder {

    /**
     * 判断传送客户端传送过来的数据是否按照协议传输，头部信息的大小应该是 int+byte+long+int = 4+1+8+4 = 17
     */
    private static final int HEADER_SIZE = 17;

    private int type;

    private byte flag;

    private long sessionId;

    private int length;

    private byte[] body;

    /**
     * GatewayDecoder
     *
     * @param maxFrameLength      解码时每个帧数据的最大长度
     * @param lengthFieldOffset   存放该帧数据的长度数据的起始位置
     * @param lengthFieldLength   记录该帧数据长度的字段本身的长度
     * @param lengthAdjustment    修改帧数据长度字段中定义的值
     * @param initialBytesToStrip 解析时需要跳过的字节数
     * @param failFast            为true，当frame长度超过maxFrameLength时报TooLongFrameException，false-读取完整个帧再报异常
     */
    public GatewayDecoder(int maxFrameLength, int lengthFieldOffset, int lengthFieldLength,
                          int lengthAdjustment, int initialBytesToStrip, boolean failFast) {
        super(maxFrameLength, lengthFieldOffset, lengthFieldLength, lengthAdjustment, initialBytesToStrip, failFast);
    }

    @Override
    protected Object decode(ChannelHandlerContext ctx, ByteBuf in) throws Exception {
        if (in == null) {
            return null;
        }
        if (in.readableBytes() < HEADER_SIZE) {
            throw new Exception("消息格式错误，可读信息段小于头部信息长度");
        }

        // 读的过程中，readIndex的指针也在移动
        type = in.readInt();

        flag = in.readByte();

        sessionId = in.readLong();

        length = in.readInt();

        if (in.readableBytes() < length) {
            throw new Exception("length描述长度与body实际长度不符");
        }
        ByteBuf buf = in.readBytes(length);
        body = new byte[buf.readableBytes()];
        buf.readBytes(body);

        GatewayMessage gatewayMessage = GatewayMessage.builder()
            .type(type).flag(flag).sessionId(sessionId).length(length).body(body).build();
        return gatewayMessage;
    }
}
