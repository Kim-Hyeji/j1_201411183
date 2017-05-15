package headfirst.singleton.classic;

public class Singleton{
  private static Singleton uniqueInstance;
  private static int numCalles=0;
  
  private Singleton(){
  }
  
  public static Singleton getInstance(){
    if(uniqueInstance == null){
      System.out.println("creating..");
      uniqueInstance = new Singleton();
    }
    System.out.println("creating..");
    System.out.println("num called "+numCalles++);
    return uniqueInstance;
  }
  
}
  
