package headfirst.command.undo;

public class PlayCommand implements Command{
  DVD dvd;
  int level;
  public PlayCommand(DVD dvd){
    this.dvd=dvd;
  }
  public void execute(){
    level=dvd.getLevel();
    dvd.play();  
  }
  public void undo(){
    dvd.dim(level);
  }
}