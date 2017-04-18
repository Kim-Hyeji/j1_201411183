package headfirst.factory.pizzafm;

public class SMPizzaStore extends PizzaStore{
  Pizza createPizza(String item){
    Pizza pizza=null;
    if(item.equals("potato")){
      pizza=new SMStylePotatoPizza();
    }
    return pizza;
  }
}