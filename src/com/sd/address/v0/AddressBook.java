package com.sd.address.v0;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddressBook extends JFrame
 implements ActionListener

{
 
  public AddressBook(){  }
  public void actionPerformed(ActionEvent e)
  {
    String actionCommand = e.getActionCommand();
    if(actionCommand.equals("Enter Record")){
      JOptionPane.showMessageDialog(null, "��ϵǾ����ϴ�");
}
    else
      System.exit(0);
    
}
}
