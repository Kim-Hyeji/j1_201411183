package com.sd.address.v1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.util.Iterator;

public class  FindAllCommand extends JFrame
  implements ActionListener,Command{
  PersonDAOImpl personDAOImpl = new PersonDAOImpl();
  PersonVO p = new PersonVO();
    
  public FindAllCommand(){  }
  public void actionPerformed(ActionEvent e)
  {
    String actionCommand = e.getActionCommand();
    if(actionCommand.equals("Find All")){
      List persons=personDAOImpl.findAll();
      Iterator iter=persons.iterator();
      while(iter.hasNext()) {
            p=(PersonVO)iter.next();
            JOptionPane.showMessageDialog(null,"\n\nName: "+ p.getName()+"\n Address: "+p.getAddress()+"\n phone no: "+p.getPhone()+ "\n Email: " + p.getEmail());
            System.out.println(p.toString());
        }
      
}
  }}