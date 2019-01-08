package com.tazine.evo.netty.util;

import com.tazine.evo.netty.app.EvoNettySession;
import io.netty.channel.Channel;
import io.netty.util.Attribute;
import io.netty.util.AttributeKey;

import java.net.InetSocketAddress;

/**
 * ChannelUtil
 *
 * @author frank
 * @date 2018/12/04
 */
public class ChannelUtil {

    public static AttributeKey<EvoNettySession> SESSION_KEY = AttributeKey.valueOf("session");

    /**
     * 添加新的会话
     *
     * @param channel
     * @param session
     * @return
     */
    public static boolean addChannelSession(Channel channel, EvoNettySession session) {
        Attribute<EvoNettySession> sessionAttr = channel.attr(SESSION_KEY);
        return sessionAttr.compareAndSet(null, session);
    }

    public static EvoNettySession getSessionBy(Channel channel) {
        Attribute<EvoNettySession> sessionAttr = channel.attr(SESSION_KEY);
        return sessionAttr.get();
    }

    public static String getIp(Channel channel) {
        return ((InetSocketAddress)channel.remoteAddress()).getAddress().toString().substring(1);
    }
}
