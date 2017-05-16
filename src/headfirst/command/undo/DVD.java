package headfirst.command.undo;

public class DVD{
  String location;
  int level;
  public DVD(String location){
    this.location=location;
  }
  public void play(){
    level=1;
    System.out.println("DVD plays..");
  }
  public void stop(){
    level=0;
    System.out.println("DVD stops..");
  }
  public void dim(int level){
    this.level=level;
  }
  public int getLevel(){
    return level;
  }
}