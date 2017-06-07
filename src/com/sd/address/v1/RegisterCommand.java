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
 
public class  RegisterCommand extends JFrame
  implements ActionListener,Command{
  PersonDAOImpl personDAOImpl = new PersonDAOImpl();
  PersonVO p = new PersonVO();
  
  JTextField t1;
  JTextField t2;
  JTextField t3;
  JTextField t4;
  
  
  public RegisterCommand(JTextField t1, JTextField t2, JTextField t3, JTextField t4){
    this.t1=t1;
    this.t2=t2;
    this.t3=t3;
    this.t4=t4;
  }
  public void actionPerformed(ActionEvent e)
  {
    String actionCommand = e.getActionCommand();
    
    p.setName(t1.getText());
    p.setPhone(t2.getText());
    p.setAddress(t3.getText());
    p.setEmail(t4.getText());
    
    if(actionCommand.equals("Register")){
           personDAOImpl.insert(p);
           JOptionPane.showMessageDialog(null, "등록되었습니다.");
           
        }

      t1.setText("");
      t2.setText("");
      t3.setText("");
      t4.setText("");
        
  }
  
  }