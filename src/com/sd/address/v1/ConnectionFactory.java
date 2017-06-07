package com.sd.address.v1;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ConnectionFactory {
    private static Connection conn=null;
    private static Statement stmt=null;
    private ConnectionFactory() {}
    public static Connection getConnection() {
        try {
            String path = System.getProperty("user.dir");
            path += "/src/mysql.properties";
            Properties prop = new Properties();
            prop.load(new FileInputStream(path));
            System.out.println("* DB connecting..."+prop.getProperty("URL"));
            Class.forName("com.mysql.jdbc.Driver");
            if(conn == null)
                conn = DriverManager.getConnection(
                    prop.getProperty("URL")+"?useSSL=true",
                    prop.getProperty("USER"),
                    prop.getProperty("PASSWORD")
                );
            String mySql="CREATE TABLE address(id int(64) NOT NULL AUTO_INCREMENT,";
            mySql+="name varchar(255) NOT NULL, phone varchar(255) NOT NULL, address varchar(255) NOT NULL,email varchar(255) NOT NULL,UNIQUE (id))";
            stmt=conn.createStatement();
            stmt.execute(mySql);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
}