package com.corroyark.utils;

import com.corroyark.common.handler.WriteHandler;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;

public class Writer{
    /**
     * 发送消息工具方法
     * @param buffer 消息
     * @param clients 目标客户端集合
     */
    public static void write(ByteBuffer buffer, AsynchronousSocketChannel... clients) {
        for(int i = 0; i < clients.length; i++) {
            AsynchronousSocketChannel asc = clients[i];
            //发送消息
            asc.write(buffer, buffer, new WriteHandler(asc));
        }
    }
}
