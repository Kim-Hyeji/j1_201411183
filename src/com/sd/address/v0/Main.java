package com.sd.address.v0;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main{
  public static void main(String[] args){
    Dimension dim=new Dimension(400,250);
    JFrame f=new JFrame("Address Book");
    f.setLocation(500,600);
    f.setPreferredSize(dim);
   
    JPanel panel=new JPanel(new GridLayout(5,2));
    f.getContentPane().add(panel);
    JLabel label1=new JLabel("Name");
    JLabel label2=new JLabel("Address");
    JLabel label3=new JLabel("Phone");
    JLabel label4=new JLabel("Email");
    JTextField name=new JTextField(25);
    JTextField address=new JTextField(25);
    JTextField phone=new JTextField(25);
    JTextField email=new JTextField(25);
    
    JButton enterButton = new JButton("Enter Record");
    JButton exitButton = new JButton("Exit");
    enterButton.addActionListener(new AddressBook());
    exitButton.addActionListener(new AddressBook());
    panel.add(label1);
    panel.add(name);
    panel.add(label2);
    panel.add(address);
    panel.add(label3);
    panel.add(phone);
    panel.add(label4);
    panel.add(email);
    panel.add(enterButton);
    panel.add(exitButton);
    
    f.pack();
    f.setVisible(true);
  }
}