package com.corroyark.client;

import com.corroyark.common.Address;
import com.corroyark.common.Console;
import com.corroyark.common.handler.WriteHandler;
import com.corroyark.utils.Writer;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;

/**
 * @author : Siriosion.Lee
 * @version : 1.0.0
 * @Date : 2021.09.28
 * @description : Client
 */

public class Client {
    public static void main(String[] args) throws Exception {
        //打开客户端
        AsynchronousSocketChannel asc = AsynchronousSocketChannel.open();
        //连接服务器
        asc.connect(Address.loc, asc, new ClientHandler());

        //获取用户输入信息
        while(true) {
            String content = Console.reader.readLine();
            if("stop".equals(content)){
                break;
            }
            ByteBuffer buffer = ByteBuffer.wrap(content.getBytes());
            Writer.write(buffer, asc);
        }
    }
}
