package com.corroyark.server;

import com.corroyark.common.handler.ReadHandler;
import com.corroyark.common.handler.WriteHandler;
import com.corroyark.common.module.Client;
import com.corroyark.utils.BufferKit;
import com.corroyark.utils.ClientManager;
import com.corroyark.utils.GroupManager;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;

import static com.corroyark.utils.GroupManager.DEFAULT_GROUPID;

public class ServerHandler implements java.nio.channels.CompletionHandler<java.nio.channels.AsynchronousSocketChannel, AsynchronousServerSocketChannel> {
    /**
     * 有客户端连接将触发该方法
     * @param asc
     * @param ac
     */
    @Override
    public void completed(AsynchronousSocketChannel asc, AsynchronousServerSocketChannel ac) {
        //继续接收新的客户端连接
        ac.accept(ac, new ServerHandler());

        //保存客户端
        Client client = ClientManager.put(asc);
        GroupManager.put(DEFAULT_GROUPID, asc);

        System.out.println("有新链接" + client);
        //读取数据
        ByteBuffer def = BufferKit.getBuffer();
        asc.read(def, def, new ReadHandler(asc));

    }

    @Override
    public void failed(Throwable exc, AsynchronousServerSocketChannel ac) {
        System.out.println("连接失败");
    }
}
