package com.tazine.evo.elastic.client.config;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.xpack.client.PreBuiltXPackTransportClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * ES 配置类
 *
 * @author frank
 * @date 2018/08/10
 */
@Configuration
public class ElasticSearchConfig implements FactoryBean<TransportClient>, InitializingBean, DisposableBean {

    private static final Logger logger = LoggerFactory.getLogger(ElasticSearchConfig.class);

    /**
     * 名称
     */
    @Value("${spring.data.elasticsearch.cluster-name}")
    private String clusterName;

    /**
     * 节点
     */
    @Value("${spring.data.elasticsearch.cluster-nodes}")
    private String clusterNodes;

    private TransportClient transportClient;

    @Override
    public TransportClient getObject() throws Exception {
        return transportClient;
    }

    @Override
    public Class<?> getObjectType() {
        return TransportClient.class;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        buildClient();
    }

    protected void buildClient() {
        System.err.println(clusterName + clusterNodes);
        try {
            // 基于 XPACK 的 TCP 客户端
            PreBuiltXPackTransportClient preBuiltXPackTransportClient = new PreBuiltXPackTransportClient(settings());
            if (!"".equals(clusterNodes)) {
                // 节点用,号隔开，端口号用:隔开
                for (String nodes : clusterNodes.split(",")) {
                    String inetSocket[] = nodes.split(":");
                    String address = inetSocket[0];
                    Integer port = Integer.valueOf(inetSocket[1]);
                    preBuiltXPackTransportClient.addTransportAddress(new
                        InetSocketTransportAddress(InetAddress.getByName(address), port));
                }
                transportClient = preBuiltXPackTransportClient;
            }
        } catch (UnknownHostException e) {
            logger.error(e.getMessage());
        }
    }

    /**
     * 初始化默认的client
     */
    private Settings settings() {
        Settings settings = Settings.builder()
            .put("cluster.name", clusterName)
            .put("xpack.security.transport.ssl.enabled", false)
            .put("xpack.security.user", "elastic:changeme")
            // 设置client.transport.sniff为true来使客户端去嗅探整个集群的状态，把集群中其它机器的ip地址加到客户端中，这样做的好处是一般你不用手动设置集群里所有集群的ip到连接客户端，它会自动帮你添加，并且自动发现新加入集群的机器
            .put("client.transport.sniff", false)
            .build();
        //transportClient = new PreBuiltXPackTransportClient(settings);
        return settings;
    }

    @Override
    public void destroy() throws Exception {
        try {
            if (transportClient != null) {
                transportClient.close();
            }
        } catch (final Exception e) {
            logger.error("Error closing ElasticSearch client: ", e);
        }
    }
}
