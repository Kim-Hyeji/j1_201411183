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

public class  DeleteCommand extends JFrame
  implements ActionListener,Command{
  PersonDAOImpl personDAOImpl = new PersonDAOImpl();
  PersonVO person = new PersonVO();
  
  JTextField t1;
  JTextField t2;
  JTextField t3;
  JTextField t4;
  public DeleteCommand(JTextField t1,JTextField t2,JTextField t3,JTextField t4){
    this.t1=t1;
    this.t2=t2;
    this.t3=t3;
    this.t4=t4;
  }
  public void actionPerformed(ActionEvent e)
  {
    String actionCommand = e.getActionCommand();
    String name=t1.getText();
    String phone=t2.getText();
    String address=t3.getText();
    String email=t4.getText();
    
    if(actionCommand.equals("Delete")){
      String p=personDAOImpl.delete(name);
      if(name.equals("")){
        JOptionPane.showMessageDialog(null, "삭제 할 이름을 입력해주세요.");
      } else{
        if (p==name)
          {
          JOptionPane.showMessageDialog(null, "삭제되었습니다.");
        }else{
          JOptionPane.showMessageDialog(null, "데이터가 없습니다.");
        }}
      t1.setText("");
      t2.setText("");
      t3.setText("");
      t4.setText("");
    }
    
}    
  }
