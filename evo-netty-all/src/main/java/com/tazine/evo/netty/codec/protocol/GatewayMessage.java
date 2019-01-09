package com.tazine.evo.netty.codec.protocol;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * 网关下发给后端服务的统一消息格式
 *
 * @author frank
 * @date 2018/12/13
 */
@Data
@Builder
@AllArgsConstructor
public class GatewayMessage {

    /**
     * 数据源类型
     */
    private int type;

    /**
     * 信息类型：心跳、业务数据
     */
    private byte flag;

    /**
     * 消息源方 sessionId
     */
    private long sessionId;

    /**
     * 信息长度
     */
    private int length;

    /**
     * 信息
     */
    private byte[] body;
}
