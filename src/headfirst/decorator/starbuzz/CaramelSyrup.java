package headfirst.decorator.starbuzz;

public class CaramelSyrup extends CondimentDecorator {
 Beverage beverage;

 public CaramelSyrup(Beverage beverage) {
  this.beverage = beverage;
 }

 public String getDescription() {
  return beverage.getDescription() + ", Caramel Syrup";
 }

 public double cost() {
  return .05 + beverage.cost();
 }
}