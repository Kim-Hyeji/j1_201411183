package headfirst.factory.pizzafm;

public class PizzaTestDrive { 
 public static void main(String[] args) {
  PizzaStore nyStore = new NYPizzaStore();
  PizzaStore smStore = new SMPizzaStore();
  Pizza pizza = nyStore.orderPizza("cheese");
  System.out.println("Ethan ordered a " + pizza.getName() + "\n");
  pizza = nyStore.orderPizza("clam");
  System.out.println("Ethan ordered a " + pizza.getName() + "\n");
  pizza = nyStore.orderPizza("pepperoni");
  System.out.println("Ethan ordered a " + pizza.getName() + "\n");
   pizza = nyStore.orderPizza("veggie");
  System.out.println("Ethan ordered a " + pizza.getName() + "\n");
  pizza = smStore.orderPizza("potato");
  System.out.println("Joel ordered a " + pizza.getName() + "\n");
 }
}