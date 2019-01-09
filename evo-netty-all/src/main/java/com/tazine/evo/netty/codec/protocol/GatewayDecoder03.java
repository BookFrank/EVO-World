package com.tazine.evo.netty.codec.protocol;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ReplayingDecoder;

import java.util.List;

/**
 * 使用 ReplayingDecoder 能够解决粘包/拆包问题
 *
 * @author frank
 * @date 2019/01/09
 */
public class GatewayDecoder03 extends ReplayingDecoder {

    /**
     * 判断传送客户端传送过来的数据是否按照协议传输，头部信息的大小应该是 int+byte+long+int = 4+1+8+4 = 17
     */
    private static final int HEADER_SIZE = 17;

    private int type;

    private byte flag;

    private long sessionId;

    private int length;

    private byte[] body;

    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf in, List<Object> list)
        throws Exception {

        if (in == null) {
            return;
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

        body = new byte[length];
        in.readBytes(body);

        GatewayMessage gatewayMessage = GatewayMessage.builder()
            .type(type).flag(flag).sessionId(sessionId).length(length).body(body).build();
        list.add(gatewayMessage);
    }
}