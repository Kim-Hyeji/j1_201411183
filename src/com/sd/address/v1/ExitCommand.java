package com.sd.address.v1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class  ExitCommand extends JFrame
  implements ActionListener,Command{
  PersonDAOImpl personDAOImpl = new PersonDAOImpl();
  public ExitCommand(){  }
  public void actionPerformed(ActionEvent e)
  {
    String actionCommand = e.getActionCommand();
    if(actionCommand.equals("Exit")){
      personDAOImpl.close();
      System.exit(0);
}    
}
}