package com.tazine.evo.netty.codec.protocol;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * GatewayEncoder
 *
 * @author rank
 * @date 2018/12/14
 */
public class GatewayEncoder extends MessageToByteEncoder<GatewayMessage> {

    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, GatewayMessage gatewayMessage, ByteBuf byteBuf)
        throws Exception {
        if (null == gatewayMessage) {
            throw new Exception("GatewayMessage is null");
        }

        byteBuf.writeInt(gatewayMessage.getType());
        byteBuf.writeByte(gatewayMessage.getFlag());
        byteBuf.writeLong(gatewayMessage.getSessionId());
        byteBuf.writeInt(gatewayMessage.getBody().length);
        byteBuf.writeBytes(gatewayMessage.getBody());
    }
}
