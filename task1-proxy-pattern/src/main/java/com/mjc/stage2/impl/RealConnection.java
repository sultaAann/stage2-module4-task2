package com.mjc.stage2.impl;


import com.mjc.stage2.Connection;

public class RealConnection implements Connection {
    private String url;
    private String login;
    private String password;
    private boolean isClosed;

    public RealConnection(String url, String login, String password) {
        this.url = url;
        this.login = login;
        this.password = password;
        this.isClosed = false;
    }

    @Override
    public void close() {
        url = null;
        login = null;
        password = null;
        isClosed = true;
    }

    @Override
    public boolean isClosed() {
        return isClosed;
    }
}
