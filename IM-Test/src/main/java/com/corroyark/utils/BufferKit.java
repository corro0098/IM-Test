package com.corroyark.utils;

import java.nio.ByteBuffer;

public class BufferKit {

    /**
     * 创建默认1024字节大小的缓冲曲
     * @return 该缓冲区
     */
    public static ByteBuffer getBuffer(){
        return ByteBuffer.allocate(1024);
    }
}
