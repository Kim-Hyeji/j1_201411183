package headfirst.singleton.chocolate;

public class ChocolateBoiler{
  private boolean empty;
  private boolean boiled;
  private static ChocolateBoiler uniqueInstance;
  private static int numCalles=0;
  
  private ChocolateBoiler(){
    empty=true;
    boiled=false;
  }
  
  public static ChocolateBoiler getInstance(){
    if(uniqueInstance == null){
      System.out.println("creating..");
      uniqueInstance = new ChocolateBoiler();
    }
    System.out.println("creating..");
    System.out.println("num called "+numCalles++);
    return uniqueInstance;
  }
  public void fill(){
    if(isEmpty()){
      empty=false;
      boiled=false;
    }
  }
  public void drain(){
    if(!isEmpty()&&isBoiled()){
      empty=true;
    }
  }
  public void boil(){
    if(!isEmpty() && !isBoiled()){
      boiled =true;
    }
  }
  public boolean isEmpty(){
    return empty;
  }
  public boolean isBoiled(){
    return boiled;
  }
}
  
