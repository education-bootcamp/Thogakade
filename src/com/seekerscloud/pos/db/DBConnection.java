package com.seekerscloud.pos.db;

import java.sql.Connection;

public class DBConnection {
    // 1 rule
    private static DBConnection dbConnection;
    private Connection connection;

    // 2 rule
    private DBConnection(){}

    // 3 rule
    public static DBConnection getInstance(){
        //
    }

    public Connection getConnection(){
        return connection;
    }

}
