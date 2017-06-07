package com.sd.dao.v2;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class PersonDaoImpl implements PersonDao {
  PreparedStatement pstmt=null;
  ResultSet rs=null;
  Connection conn=ConnectionFactory.getConnection();
  public void insert(PersonV0 p){
    try{
      pstmt=conn.prepareStatement("INSERT INTO persons(name,address) VALUES(?,?)");
      pstmt.setString(1, p.getName());
      pstmt.setString(2, p.getAddress());
      System.out.println("* inserting.."+p.getName()+p.getAddress());
      pstmt.executeUpdate();
    }catch(SQLException e){
      e.printStackTrace();
    }
  }
  public List<PersonV0> findAll(){
    Statement stmt=null;
    List<PersonV0> persons=new ArrayList<PersonV0>();
    try{
      stmt=conn.createStatement();
      rs=stmt.executeQuery("SELECT * FROM persons");
      PersonV0 person=null;
      while(rs.next()){
        person = new PersonV0();
        person.setId(rs.getInt("id"));
        person.setName(rs.getString("name"));
        person.setAddress(rs.getString("address"));
        persons.add(person);
      }
    }catch (SQLException e){
      e.printStackTrace();
    } return persons;
      
  }
    public PersonV0 findById(int id){
      PersonV0 p=null;
      try{
        pstmt=conn.prepareStatement("SELECT * FROM persons WHERE id=?");
        pstmt.setInt(1, id);
        System.out.println("* finding by id..."+id);
        rs = pstmt.executeQuery();
        if(rs.next()){
          p = new PersonV0();
          p.setId(rs.getInt("id"));
          p.setName(rs.getString("name"));
          p.setAddress(rs.getString("address"));
       }
    }catch(SQLException e) {
            e.printStackTrace();
        }return p;
    }
    public void update(PersonV0 p){
      try{
        pstmt = conn.prepareStatement("UPDATE persons SET name=?,address=? WHERE id=?"); 
        pstmt.setString(1, p.getName());
        pstmt.setString(2, p.getAddress());
        pstmt.setInt(3, p.getId());
        System.out.println("* updating..."+p.getName());
        pstmt.executeUpdate();
      }catch(SQLException e) {
            e.printStackTrace();
        }
    }
    public void delete(int id){
      try{
        pstmt=conn.prepareStatement("DELETE FROM persons WHERE id=?");
        pstmt.setInt(1,id);
        int rows=pstmt.executeUpdate();
        if(rows==0){
          System.out.println("!can not delete..."+id+" does not exist!");
     } else if (rows > 0) {  
       System.out.println("* deleting..."+id);
     } 
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void close(){
     try{
        //statement는 꼭 닫아야한다.
        if(rs !=null) rs.close();
        if(pstmt !=null) pstmt.close();
        if(conn !=null) conn.close();
      
      }catch(Exception e){
        e.printStackTrace();
      };
  }
    }