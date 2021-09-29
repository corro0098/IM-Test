package com.corroyark.client;

import com.corroyark.common.handler.ReadHandler;
import com.corroyark.common.handler.WriteHandler;
import com.corroyark.utils.BufferKit;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;

public class ClientHandler implements java.nio.channels.CompletionHandler<Void, java.nio.channels.AsynchronousSocketChannel> {
    /**
     * 连接上服务器将触发该方法
     * @param result
     * @param asc
     */
    @Override
    public void completed(Void result, AsynchronousSocketChannel asc) {
        //读取服务端数据
        ByteBuffer def = BufferKit.getBuffer();
        asc.read(def, def, new ReadHandler(asc));
    }

    @Override
    public void failed(Throwable exc, AsynchronousSocketChannel asc) {
        System.out.println("连接出错");
    }
}
