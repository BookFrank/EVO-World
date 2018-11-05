package com.tazine.evo.socket.bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * SocketHandler
 *
 * @author frank
 * @date 2017/10/31
 */
public class SocketHandler implements Runnable {

    private Socket socket;
    private BufferedReader br;
    private PrintWriter writer;

    public SocketHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new PrintWriter(socket.getOutputStream(), true);

            while (true) {
                String line = null;
                while ((line = br.readLine()) != null) {
                    System.out.println("收到消息：");
                    System.out.println("    " + line);
                    System.out.println("发送消息：");
                    System.out.println("    听不懂你在说什么？");
                    writer.println("  听不懂你在说什么？");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
