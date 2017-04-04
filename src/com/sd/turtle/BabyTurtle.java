package com.sd.turtle;
import java.util.Observer;
import java.util.Observable;
import java.util.ArrayList;
import java.awt.geom.Point2D.Double;
import ch.aplu.turtle.*;

public class BabyTurtle extends Observable{
  Turtle baby;
  Double myCurpos;
  ArrayList<Observer> obs;
  public BabyTurtle(){
    baby=new Turtle();
    myCurpos=baby.getPos();
    obs=new ArrayList<Observer>();
  }
  public void addObserver(Observer o){
    obs.add(o);
  }
  public void notifyObservers(){
    for(Observer o:obs)
      o.update(this, 1);
  }
  
  protected void setChanged(){
    myCurpos=baby.getPos();
  }
  public void move(int x, int y){
    baby.moveTo(x,y);
  }
}