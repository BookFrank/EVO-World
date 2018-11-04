package com.tazine.evo.socket.bio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * BlockingIO Socket服务端
 *
 * @author frank
 * @date 2017/10/31
 */
public class BioTimeServer {

    public BioTimeServer(int port) {
        try {
            // 1. 启动一个 ServerSocket 监听本地端口
            ServerSocket serverSocket = new ServerSocket(port);

            // 2. 当外界 Socket 连接 ServerSocket 时，取出 Socket 连接开启一个线程处理
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("收到一个 socket");
                SocketHandler handler = new SocketHandler(socket);
                new Thread(handler).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new BioTimeServer(8080);
    }
}
