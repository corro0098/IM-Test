package com.corroyark.common.handler;

import com.corroyark.utils.BufferKit;
import com.corroyark.utils.Writer;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;

public class ReadHandler implements java.nio.channels.CompletionHandler<Integer, java.nio.ByteBuffer> {
    private AsynchronousSocketChannel asc;

    public ReadHandler(AsynchronousSocketChannel asc) {
        this.asc = asc;
    }

    /**
     * 有数据读取将触发该方法
     * @param result
     * @param buffer
     */
    @Override
    public void completed(Integer result, ByteBuffer buffer) {
        //继续读取数据
        ByteBuffer def = BufferKit.getBuffer();
        asc.read(def, def, new ReadHandler(asc));

        System.out.println(new String(buffer.array(), 0, result));
    }

    @Override
    public void failed(Throwable exc, ByteBuffer buffer) {
        System.out.println("读取数据出错");
    }
}
