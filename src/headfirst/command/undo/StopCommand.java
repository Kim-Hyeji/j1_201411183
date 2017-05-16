package headfirst.command.undo;

public class StopCommand implements Command{
  DVD dvd;
  int level;
  public StopCommand(DVD dvd){
    this.dvd=dvd;
  }
  public void execute(){
    level=dvd.getLevel();
    dvd.stop();  
  }
  public void undo(){
    dvd.dim(level);
  }
}