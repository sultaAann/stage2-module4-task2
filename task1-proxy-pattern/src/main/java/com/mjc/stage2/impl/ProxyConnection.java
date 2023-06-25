package com.mjc.stage2.impl;


import com.mjc.stage2.Connection;

public class ProxyConnection implements Connection {
    private RealConnection realConnection;

    public ProxyConnection(RealConnection realConnection) {
        this.realConnection = realConnection;
    }

    public void reallyClose() {
        if (!isClosed()) realConnection.close();
    }

    @Override
    public void close() {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        Connection connection = connectionPool.getConnection();
        connectionPool.releaseConnection(connection);
        connectionPool.destroyPool();
    }

    @Override
    public boolean isClosed() {
        if (realConnection.isClosed() == true) return true;
        return false;
    }

}
