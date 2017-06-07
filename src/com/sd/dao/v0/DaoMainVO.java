package com.sd.dao.v0;

import java.sql.*;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class DaoMainVO{
  public static void main(String[] args){
    Connection conn=null;
    ResultSet rs=null;
    Statement stmt=null;
    
    try{
      String path=System.getProperty("user.dir");
      path+="/src/mysql.properties";
      Properties prop=new Properties();
      prop.load(new FileInputStream(path));
      Class.forName("com.mysql.jdbc.Driver");
      //4단계
      //getConnection(String url, String user, String password)
      //conn=DriverManager.getConnection("jdbc:mysql://localhost/test","root","1234");
      conn=DriverManager.getConnection(
           prop.getProperty("URL"),
           prop.getProperty("USER"),
           prop.getProperty("PASSWORD")
       );
      //String mysql="INSERT INTO persons(name,address) VALUES('v0-1','1 Hongji Dong')";
      //String mysql="CREATE TABLE persons(id int(64) NOT NULL AUTO_INCREMENT,";
      //mysql+="name varchar(255) NOT NULL, address varchar(255) NOT NULL, UNIQUE (id))";
      String mysql="select name from persons where id<4 order by id";
      stmt=conn.createStatement();
      //stmt.execute(mysql);
      rs=stmt.executeQuery(mysql);
      while(rs.next()){
        System.out.println(rs.getString("name"));
      }
    }catch(Exception e){
      e.printStackTrace();
    }finally{
      try{
        //statement는 꼭 닫아야한다.
        if(rs !=null) stmt.close();
        if(stmt !=null) stmt.close();
        if(conn !=null) conn.close();
      
      }catch(Exception e){};
  }
  }}