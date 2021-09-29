package com.corroyark.common.module;

import java.nio.channels.AsynchronousSocketChannel;
import java.util.UUID;

public class Client {
    private String id = UUID.randomUUID().toString();
    private String alias = id;
    private AsynchronousSocketChannel asc;

    public Client(AsynchronousSocketChannel asc) {
        this.asc = asc;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public AsynchronousSocketChannel getAsc() {
        return asc;
    }

    public void setAsc(AsynchronousSocketChannel asc) {
        this.asc = asc;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id='" + id + '\'' +
                ", alias='" + alias + '\'' +
                ", asc=" + asc +
                '}';
    }
}
