package com.sd.dao.v2;

import java.sql.*;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ConnectionFactory{
  private static Connection conn=null;
  private ConnectionFactory(){}
  public static Connection getConnection(){
    try{
      String path=System.getProperty("user.dir");
      path+="/src/mysql.properties";
      Properties prop=new Properties();
      prop.load(new FileInputStream(path));
      Class.forName("com.mysql.jdbc.Driver");
      //4´Ü°è
      //getConnection(String url, String user, String password)
      //conn=DriverManager.getConnection("jdbc:mysql://localhost/test","root","1234");
      conn=DriverManager.getConnection(
           prop.getProperty("URL")+"?useSSL=true",
           prop.getProperty("USER"),
           prop.getProperty("PASSWORD")
       );
    }catch(Exception e){
      e.printStackTrace();
    }
    return conn;
    }
  }