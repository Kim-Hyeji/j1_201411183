package com.sd.address.v1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JOptionPane;

public class PersonDAOImpl implements PersonDAO {
    Connection conn=ConnectionFactory.getConnection();
    PreparedStatement pstmt=null;
    ResultSet rs=null;
      
    public void insert(PersonVO person) {
        try {
            pstmt = conn.prepareStatement("INSERT INTO address(id,name,phone,address,email) VALUES(NULL,?,?,?,?)");
            pstmt.setString(1, person.getName());
            pstmt.setString(2, person.getPhone());
            pstmt.setString(3, person.getAddress());
            pstmt.setString(4, person.getEmail());
            System.out.println("* inserting..."+person.getName()+person.getPhone()+person.getAddress()+person.getEmail());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public PersonVO findByName(String name) {
        PersonVO person=null;
        try {
            pstmt = conn.prepareStatement("SELECT * FROM address WHERE name=?");
            pstmt.setString(1, name);
            System.out.println("* finding by name..."+name);
            rs = pstmt.executeQuery();
            if(rs.next()) {
                person = new PersonVO();
                person.setName(rs.getString("name"));
                person.setPhone(rs.getString("phone"));
                person.setAddress(rs.getString("address"));
                person.setEmail(rs.getString("email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return person;
    }
    public List<PersonVO> findAll() {
        Statement stmt=null;
        List<PersonVO> persons = new ArrayList<PersonVO>();
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM address");
            PersonVO person = null;
            while(rs.next()){
                person = new PersonVO();
                person.setName(rs.getString("name"));
                person.setPhone(rs.getString("phone"));
                person.setAddress(rs.getString("address"));
                person.setEmail(rs.getString("email"));
                persons.add(person);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if(stmt != null) stmt.close();
            } catch (Exception e) {};
 }
        System.out.println("* finding all..."+persons);
        return persons;
    }
    public void update(PersonVO person) {
        try {
            pstmt = conn.prepareStatement("UPDATE address SET name=?,phone=?,address=?,email=? WHERE id=?"); 
            pstmt.setString(1, person.getName());
            pstmt.setString(2, person.getPhone());
            pstmt.setString(3, person.getAddress());
            pstmt.setString(4, person.getEmail());
            System.out.println("* updating..."+person.getName());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public String delete(String name) {
        try {
            pstmt = conn.prepareStatement("DELETE FROM address WHERE name=?");
            pstmt.setString(1, name);
            int rows=pstmt.executeUpdate();
     if (rows == 0) {  
       System.out.println("!can not delete..."+name+" does not exist!");
     } else if (rows > 0) {
       System.out.println("* deleting..."+name);    
     }
        } catch (SQLException e) {
            e.printStackTrace();
        }return name;
    }
    
    public void close() {
        System.out.println("* closing all...");
        try {
            if (rs != null) rs.close();
            if (pstmt != null) pstmt.close();
            if (conn != null) conn.close();
        } catch (Exception e) {
     e.printStackTrace();
 }
    }
}