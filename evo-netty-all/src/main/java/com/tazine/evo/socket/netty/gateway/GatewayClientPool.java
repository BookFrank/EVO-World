package com.tazine.evo.socket.netty.gateway;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import io.netty.channel.Channel;

import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * @author frank
 * @date 2018/12/12
 */
public class GatewayClientPool {

    private static Random random = new Random();

    public static Map<String, Channel> channelPoolMap = Maps.newConcurrentMap();

    public static List<Channel> channels = Lists.newArrayList();

    public static void addToPool(String key, Channel channel) {
        System.out.println("加入连接池成功");
        channels.add(channel);
    }

    // 利用负载均衡算法随机寻找一个 Channel，用于发送数据
    public static Channel getChannel() {
        int r = random.nextInt(channels.size());
        System.out.println("当前 channel pos is " + r);
        return channels.get(r);
    }
}
