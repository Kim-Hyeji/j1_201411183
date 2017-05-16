package headfirst.command.undo;

public class RemoteLoader{
  public static void main(String[] args){
    RemoteControlWithUndo remoteControl=new RemoteControlWithUndo();
    Light light=new Light("Living Room");
    DVD dvd=new DVD("DVD Room");
    LightOnCommand lightOn=new LightOnCommand(light);
    LightOffCommand lightOff=new LightOffCommand(light);
    PlayCommand play=new PlayCommand(dvd);
    StopCommand stop=new StopCommand(dvd);
    remoteControl.setCommand(0,lightOn,lightOff);
    remoteControl.setCommand(1,play, stop);
    remoteControl.onButtonWasPushed(0);
    remoteControl.offButtonWasPushed(0);
    remoteControl.undoButtonWasPushed();
    remoteControl.onButtonWasPushed(1);
    remoteControl.offButtonWasPushed(1);
    System.out.println(remoteControl);
    remoteControl.undoButtonWasPushed();
  
 }
}