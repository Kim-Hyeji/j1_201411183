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
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddressMain{
  public static void main(String[] args){
    PersonDAOImpl personDAOImpl = new PersonDAOImpl();
    PersonVO person = new PersonVO();
    Dimension dim=new Dimension(400,250);
    JFrame f=new JFrame("Address Book");
    f.setLocation(500,600);
    f.setPreferredSize(dim);
   
    JPanel panel=new JPanel(new GridLayout(7,2));
    f.getContentPane().add(panel);
    JLabel label1=new JLabel("Name");
    JLabel label2=new JLabel("Phone");
    JLabel label3=new JLabel("Address");
    JLabel label4=new JLabel("Email");
    JTextField name=new JTextField(25);
    JTextField phone=new JTextField(25);
    JTextField address=new JTextField(25);
    JTextField email=new JTextField(25);
    
    JButton enterButton = new JButton("Register");
    JButton searchButton = new JButton("Name Search");
    JButton deleteButton = new JButton("Delete");
    JButton findallButton = new JButton("Find All");
    JButton exitButton = new JButton("Exit");
    RegisterCommand rCommand=new RegisterCommand(name,phone,address,email);
    enterButton.addActionListener(rCommand);
    SearchCommand sCommand=new SearchCommand(name,phone,address,email);
    searchButton.addActionListener(sCommand);
    DeleteCommand dCommand=new DeleteCommand(name,phone,address,email);
    deleteButton.addActionListener(dCommand);
    FindAllCommand fCommand=new FindAllCommand();
    findallButton.addActionListener(fCommand);
    exitButton.addActionListener(new ExitCommand());
    panel.add(label1);
    panel.add(name);
    panel.add(label2);
    panel.add(phone);
    panel.add(label3);
    panel.add(address);
    panel.add(label4);
    panel.add(email);
    panel.add(enterButton);
    panel.add(searchButton);
    panel.add(deleteButton);
    panel.add(findallButton);
    panel.add(exitButton);
    
    f.pack();
    f.setVisible(true);
  }
}
