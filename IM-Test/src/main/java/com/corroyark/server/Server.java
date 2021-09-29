package com.corroyark.server;

import com.corroyark.common.Address;
import com.corroyark.common.Console;
import com.corroyark.common.handler.WriteHandler;
import com.corroyark.utils.ClientManager;
import com.corroyark.utils.GroupManager;
import com.corroyark.utils.Writer;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;

import static com.corroyark.utils.GroupManager.DEFAULT_GROUPID;


/**
 * @author : Siriosion.Lee
 * @version : 1.0.0
 * @Date : 2021.09.28
 * @description : Server
 */

public class Server {
    public static void main(String[] args) throws Exception {
        //打开服务端
        AsynchronousServerSocketChannel server = AsynchronousServerSocketChannel.open();
        //绑定主机
        server.bind(Address.loc);
        //接收客户端
        server.accept(server, new ServerHandler());

        //模拟服务端回复消息
        while(true) {
            String content = Console.reader.readLine();
            if("stop".equals(content)){
                break;
            }
            ByteBuffer buffer = ByteBuffer.wrap(content.getBytes());
            //指定用户发送
            /*System.out.println("请输入用户名");
            String cc = Console.reader.readLine();
            AsynchronousSocketChannel[] asc = ClientManager.get(cc);*/
            //群发
            AsynchronousSocketChannel[] asc = GroupManager.get(DEFAULT_GROUPID);
            Writer.write(buffer, asc);
        }
    }
}
