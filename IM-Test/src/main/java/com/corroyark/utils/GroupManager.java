package com.corroyark.utils;

import java.nio.channels.AsynchronousSocketChannel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupManager {
    public static String DEFAULT_GROUPID= "ABC";
    /**
     * 群组集合
     */
    private static final Map<String, List<AsynchronousSocketChannel>> groups = new HashMap<>();

    /**
     * 添加group新成员
     * @param group 群组编号
     * @param asc 群成员
     */
    public static void put(String group, AsynchronousSocketChannel asc){
        List<AsynchronousSocketChannel> channels = groups.get(group);
        if(channels == null){
            channels = new ArrayList();
        }
        channels.add(asc);
        groups.put(group, channels);
    }

    /**
     * 获取群成员
     * @param group
     * @return
     */
    public static AsynchronousSocketChannel[] get(String group){
        List<AsynchronousSocketChannel> channels = groups.get(DEFAULT_GROUPID);
        return channels.toArray(new AsynchronousSocketChannel[0]);
    }
}
