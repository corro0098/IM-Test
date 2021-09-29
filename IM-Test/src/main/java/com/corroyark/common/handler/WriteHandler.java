package com.corroyark.common.handler;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;

public class WriteHandler implements java.nio.channels.CompletionHandler<Integer, java.nio.ByteBuffer> {

    private AsynchronousSocketChannel asc;

    public WriteHandler(AsynchronousSocketChannel asc) {
        this.asc = asc;
    }

    /**
     * 写出将触发该方法
     * @param result 已发送数据的大小
     * @param buffer
     */
    @Override
    public void completed(Integer result, ByteBuffer buffer) {
        if(buffer.hasRemaining()){
            asc.write(buffer, buffer, this);
        }/*else {
            System.out.println("写出成功");
        }*/
    }

    @Override
    public void failed(Throwable exc, ByteBuffer buffer) {
        System.out.println("写出失败");
    }
}
