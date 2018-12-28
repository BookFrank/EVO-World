package com.tazine.evo.netty;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * EvoNettySession
 *
 * @author frank
 * @date 2018/12/15
 */
public class EvoNettySession {

    private static final Logger logger = LoggerFactory.getLogger(EvoNettySession.class);

    ///** 网络连接channel */
    //private Channel channel;
    //
    //private User user;
    //
    ///** ip地址 */
    //private String ipAddr;
    //
    //private boolean reconnected;
    //
    ///** 拓展用，保存一些个人数据  */
    //private Map<String, Object> attrs = new HashMap<>();
    //
    //public IoSession(Channel channel) {
    //    this.channel = channel;
    //    this.ipAddr = ChannelUtils.getIp(channel);
    //}
    //
    ///**
    // * 向客户端发送消息
    // * @param packet
    // */
    //public void sendPacket(Packet packet) {
    //    if (packet == null) {
    //        return;
    //    }
    //    if (channel != null) {
    //        channel.writeAndFlush(packet);
    //    }
    //}
    //
    //public boolean isClose() {
    //    if (channel == null) {
    //        return true;
    //    }
    //    return !channel.isActive() ||
    //        !channel.isOpen();
    //}
    //
    ///**
    // * 关闭session
    // * @param reason {@link SessionCloseReason}
    // */
    //public void close(SessionCloseReason reason) {
    //    try {
    //        if (this.channel == null) {
    //            return;
    //        }
    //        if (channel.isOpen()) {
    //            channel.close();
    //            logger.info("close session[{}], reason is {}", getUser().getUserId(), reason);
    //        } else {
    //            logger.info("session[{}] already close, reason is {}", getUser().getUserId(), reason);
    //        }
    //    } catch (Exception e) {
    //    }
    //}

}
