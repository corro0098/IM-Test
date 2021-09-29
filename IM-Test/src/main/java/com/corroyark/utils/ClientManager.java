package com.corroyark.utils;


import com.corroyark.common.module.Client;

import java.nio.channels.AsynchronousSocketChannel;
import java.util.HashMap;
import java.util.Map;

public class ClientManager {
    /**
     * 已连接客户端
     */
    public static final Map<String, Client> clients = new HashMap<>();

    /**
     * 添加新客户端
     * @param asc
     * @return
     */
    public static Client put(AsynchronousSocketChannel asc){
        Client client = new Client(asc);
        clients.put(client.getAlias(), client);
        return client;
    }

    /**
     * 获取指定别名的客户端
     * @param aliases 客户端名称
     * @return 指定客户端
     */
    public static AsynchronousSocketChannel[] get(String... aliases){
        AsynchronousSocketChannel[] channels = new AsynchronousSocketChannel[aliases.length];
        for(int i = 0; i < aliases.length; i++){
            channels[i] = clients.get(aliases[i]).getAsc();
        }
        return channels;
    }
}
